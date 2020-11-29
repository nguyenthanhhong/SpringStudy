package com.nth.DynamicSchedule.model;

public enum JobStatus {
    START("0"), SUCCESS("1"), FAIL("2");
    public final String value;

    JobStatus(String s) {
        this.value = s;
    }
}
