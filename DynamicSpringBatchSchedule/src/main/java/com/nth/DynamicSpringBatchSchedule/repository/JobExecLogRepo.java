package com.nth.DynamicSpringBatchSchedule.repository;

import com.nth.DynamicSpringBatchSchedule.model.JobExecLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobExecLogRepo extends JpaRepository<JobExecLog, Integer> {
}
