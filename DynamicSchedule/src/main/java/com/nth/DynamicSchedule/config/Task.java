package com.nth.DynamicSchedule.config;

import com.nth.DynamicSchedule.model.JobExecLog;
import com.nth.DynamicSchedule.model.JobStatus;
import com.nth.DynamicSchedule.repository.JobExecLogRepo;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Date;

/**
 * @Author: Hong Nguyen
 * @Create: 2020/10/10
 */
@Slf4j
@NoArgsConstructor
public abstract class Task {
    private final SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    protected String taskName = "";
    @Autowired
    JobExecLogRepo repo;

    public void run(int JobId, String[] args) {
        args = convertParameter(args);
        JobExecLog jobLog = insertBatchStartLog(JobId, args);
        try {
            execute(args);
            updateBatchFinishLog(jobLog, JobStatus.SUCCESS, "SUCCESS");
        } catch (Exception ex) {
            updateBatchFinishLog(jobLog, JobStatus.FAIL, ex.getMessage());
            ex.printStackTrace();
        }
    }

    abstract public void execute(String[] args) throws Exception;

    private JobExecLog insertBatchStartLog(int JobId, String[] args) {
        Date exeDate = new Date();
        JobExecLog jobLog = new JobExecLog();
        jobLog.setJobId(JobId);
        jobLog.setConditions(args.length > 0 ? Arrays.toString(args).replaceAll("\\[|\\]", "") : null);
        jobLog.setJobStatus(JobStatus.START);
        jobLog.setRunDate(exeDate);
        jobLog.setStartDt(exeDate);
        return repo.saveAndFlush(jobLog);
    }

    private void updateBatchFinishLog(JobExecLog jobLog, JobStatus status, String msg) {
        jobLog.setEndDt(new Date());
        jobLog.setJobStatus(status);
        jobLog.setMsg(msg != null ? msg.getBytes() : "".getBytes());
        repo.saveAndFlush(jobLog);
    }

    private String[] convertParameter(String[] args) {
        if (args.length == 0) return args;
        String[] newArgs = new String[args.length];
        int i = 0;
        for (String param : args) {
            switch (param) {
                case "TODAY":
                    newArgs[i] = formatter.format(new Date());
                    break;
                case "YESTERDAY":
                    Instant yesterday = Instant.now().minus(Duration.ofDays(1));
                    newArgs[i] = formatter.format(Date.from(yesterday));
                    break;
                default:
                    newArgs[i] = param;
            }
            i++;
        }
        return newArgs;
    }
}
