package com.nth.DynamicSpringBatchSchedule.service;

import com.nth.DynamicSpringBatchSchedule.config.BatchJob;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: Hong Nguyen
 * @Create: 2020/10/11
 */
public class MultiJobSample extends BatchJob {
    @Autowired
    private StepBuilderFactory steps;

    @Override
    public List<Step> createStepFlows() {
        return Arrays.asList(stepOne(), stepTwo());
    }

    public Step stepOne() {
        return steps.get("taskletStep1")
                .tasklet(tasklet1())
                .build();
    }

    public Step stepTwo() {
        return steps.get("taskletStep2")
                .tasklet(tasklet2())
                .build();
    }

    public Tasklet tasklet1() {
        return (contribution, chunkContext) -> {
            return RepeatStatus.FINISHED;
        };
    }

    public Tasklet tasklet2() {
        return (contribution, chunkContext) -> {
            //chunkContext.getStepContext().getJobParameters().get("param1");
            return RepeatStatus.FINISHED;
        };
    }
}
