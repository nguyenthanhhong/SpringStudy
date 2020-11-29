package com.nth.DynamicSpringBatchSchedule.config;

import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.job.builder.SimpleJobBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class BatchJob extends Task {
    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    JobBuilderFactory jobBuilders;

    @Override
    public void execute(String[] args) throws Exception {
        Job customJob = customJob();
        if (customJob == null) return;

        JobParameters params = createJobParameter(args);
        JobExecution execution = jobLauncher.run(customJob, params);
    }

    private Job customJob() {
        List<Step> arrSteps = createStepFlows();

        if (arrSteps.size() > 0) {
            SimpleJobBuilder jobBuild = jobBuilders.get(taskName + System.currentTimeMillis())
                    .incrementer(new RunIdIncrementer())
                    .start(arrSteps.get(0));
            for (int i = 1; i < arrSteps.size(); i++) {
                jobBuild.next(arrSteps.get(i));
            }
            return jobBuild.build();
        }

        return null;
    }

    private JobParameters createJobParameter(String[] args) {
        if (args.length > 0) {
            Map<String, JobParameter> parameters = new LinkedHashMap<>();
            for (int i = 0; i < args.length; i++) {
                JobParameter param = new JobParameter(args[i]);
                parameters.put("param" + (i + 1), param);
            }
            return new JobParameters(parameters);
        }

        return new JobParametersBuilder().toJobParameters();
    }

    abstract public List<Step> createStepFlows();
}
