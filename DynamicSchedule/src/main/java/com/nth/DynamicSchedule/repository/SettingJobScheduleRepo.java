package com.nth.DynamicSchedule.repository;

import com.nth.DynamicSchedule.model.SettingJobSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SettingJobScheduleRepo extends JpaRepository<SettingJobSchedule, Integer> {
    @Query(value ="SELECT * FROM T_SETTING_JOB_SCHEDULE WHERE use_yn = 1", nativeQuery = true)
    List<SettingJobSchedule> getAvailableJob();
}
