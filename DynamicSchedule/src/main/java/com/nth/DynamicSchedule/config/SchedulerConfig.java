package com.nth.DynamicSchedule.config;

import com.nth.DynamicSchedule.model.SettingJobSchedule;
import com.nth.DynamicSchedule.repository.SettingJobScheduleRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;
import java.util.stream.Collectors;

/**
 * @Author: Hong Nguyen
 * @Create: 2020/10/10
 */
@EnableScheduling
@Service
@Slf4j
public class SchedulerConfig implements SchedulingConfigurer {
    private static final String CRON_END_OF_THE_YEAR = "0 0 0 31 12 ?";

    @Value("${SCHEDULED_THREADS_POOL_SIZE}")
    int SCHEDULED_THREADS_POOL_SIZE;

    List<SettingJobSchedule> currentList = new ArrayList<>();
    private ScheduledTaskRegistrar scheduledTaskRegistrar;

    private Map<Integer, ScheduledFuture> futureMap = new ConcurrentHashMap<>();

    @Autowired
    private AutowireCapableBeanFactory autowireCapableBeanFactory;

    @Autowired
    SettingJobScheduleRepo setting;

    @Bean
    public TaskScheduler poolScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setThreadNamePrefix("ThreadPoolTaskScheduler");
        scheduler.setPoolSize(SCHEDULED_THREADS_POOL_SIZE); // number of methods that can be run at the same time
        scheduler.initialize();
        return scheduler;
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        if (scheduledTaskRegistrar == null) {
            scheduledTaskRegistrar = taskRegistrar;
        }
        if (taskRegistrar.getScheduler() == null) {
            taskRegistrar.setScheduler(poolScheduler());
        }
        reloadJobList();
    }

    private String[] getCurrentJobCondition(SettingJobSchedule job) {
        return job.getParameter() != null ? job.getParameter().split(",") : new String[0];
    }

    private String getCurrentJobCron(SettingJobSchedule job) {
        return job.getCronExpression() != null ? job.getCronExpression() : CRON_END_OF_THE_YEAR;
    }


    @Scheduled(fixedDelayString = "${SCHEDULED_RELOAD_SETTING_TIME}")
    public void reloadJobList() {
        log.info("Reload scheduled config at: " + (new Date()));
        List<SettingJobSchedule> newJobList = setting.getAvailableJob();
        List<SettingJobSchedule> addJobs = new ArrayList<>();
        List<SettingJobSchedule> removeJobs = new ArrayList<>();

        // get 2 list: new jobs to add to Schedule list and unused job to remove from Schedule list
        if (!newJobList.isEmpty()) {
            if (!currentList.isEmpty()) {
                addJobs = newJobList.stream().filter(e -> !currentList.contains(e)).collect(Collectors.toList());
                removeJobs = currentList.stream().filter(e -> !newJobList.contains(e)).collect(Collectors.toList());
            } else {
                addJobs = new ArrayList<>(newJobList);
            }
        } else {
            if (!currentList.isEmpty()) {
                removeJobs = new ArrayList<>(currentList);
            }
        }
        log.info("new jobs count= " + addJobs.size());
        log.info("remove jobs count= " + removeJobs.size());

        // remove unused jobs
        for (SettingJobSchedule conf : removeJobs) {
            if (!futureMap.isEmpty()) {
                ScheduledFuture future = futureMap.get(conf.getJobId());
                if (future != null) {
                    log.info("cancelling task " + conf.getJobId() + " ...");
                    future.cancel(false); // set to false if you want the running task to be completed first.
                    log.info(conf.getJobId() + " isCancelled = " + future.isCancelled());
                    futureMap.remove(conf.getJobId());
                }
            }
        }

        // add new jobs
        for (SettingJobSchedule job : addJobs) {
            Task newJob = InitialContext.getInstance(job.getClassPath());
            if (newJob != null) {
                newJob.taskName = job.getJobName();
                autowireCapableBeanFactory.autowireBean(newJob);
                ScheduledFuture future = scheduledTaskRegistrar.getScheduler().schedule(
                        () -> newJob.run(job.getJobId(), getCurrentJobCondition(job)),
                        t -> {
                            CronTrigger crontrigger = new CronTrigger(getCurrentJobCron(job));
                            return crontrigger.nextExecutionTime(t);
                        });
                futureMap.put(job.getJobId(), future);
            }
        }

        currentList.clear();
        currentList = newJobList;
    }
}
