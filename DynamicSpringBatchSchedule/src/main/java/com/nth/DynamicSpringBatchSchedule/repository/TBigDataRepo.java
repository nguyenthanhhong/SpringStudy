package com.nth.DynamicSpringBatchSchedule.repository;

import com.nth.DynamicSpringBatchSchedule.model.TBigData;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: Hong Nguyen
 * @Create: 2020/10/10
 */
public interface TBigDataRepo extends JpaRepository<TBigData, String> {
}
