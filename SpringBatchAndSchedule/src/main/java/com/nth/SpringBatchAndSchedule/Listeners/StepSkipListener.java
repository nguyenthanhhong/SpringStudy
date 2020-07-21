package com.nth.SpringBatchAndSchedule.Listeners;

import org.springframework.batch.core.SkipListener;

public class StepSkipListener implements SkipListener<String, Number> {

    @Override
    public void onSkipInRead(Throwable t) {
        System.out.println("StepSkipListener - onSkipInRead");
    }

    @Override
    public void onSkipInWrite(Number item, Throwable t) {
        System.out.println("StepSkipListener - afterWrite");
    }

    @Override
    public void onSkipInProcess(String item, Throwable t) {
        System.out.println("StepSkipListener - onWriteError");
    }
}
