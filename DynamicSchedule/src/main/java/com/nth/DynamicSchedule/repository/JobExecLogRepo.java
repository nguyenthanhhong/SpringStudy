package com.nth.DynamicSchedule.repository;

import com.nth.DynamicSchedule.model.JobExecLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobExecLogRepo extends JpaRepository<JobExecLog, Integer> {
}
