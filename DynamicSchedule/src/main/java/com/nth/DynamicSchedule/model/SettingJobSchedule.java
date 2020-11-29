package com.nth.DynamicSchedule.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@Table(name = "T_SETTING_JOB_SCHEDULE")
@NoArgsConstructor
public class SettingJobSchedule {
    @Id
    @GeneratedValue
    int JobId;

    @NonNull
    String JobName;

    String Description;

    @NonNull
    String ClassPath;

    String Parameter;

    @NonNull
    String CronExpression;

    Boolean UseYn;

    String RegId;

    Date RegDt;

    String UpdId;

    Date UpdDt;
}
