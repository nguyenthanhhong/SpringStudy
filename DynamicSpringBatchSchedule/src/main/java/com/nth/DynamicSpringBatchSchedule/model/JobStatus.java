package com.nth.DynamicSpringBatchSchedule.model;

public enum JobStatus {
    START("0"), SUCCESS("1"), FAIL("2");
    public final String value;

    JobStatus(String s) {
        this.value = s;
    }
}
