package com.nth.DynamicSchedule.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "T_JOB_EXEC_LOG")
@NoArgsConstructor
public class JobExecLog {
    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    Integer ExeId;
    @NonNull
    Integer JobId;
    Date RunDate;
    Date StartDt;
    Date EndDt;
    String Conditions;
    JobStatus JobStatus;
    @Lob
    byte[] Msg;
}
