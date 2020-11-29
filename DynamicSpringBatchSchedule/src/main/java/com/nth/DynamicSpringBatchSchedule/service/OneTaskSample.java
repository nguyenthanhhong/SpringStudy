package com.nth.DynamicSpringBatchSchedule.service;

import com.nth.DynamicSpringBatchSchedule.config.Task;
import com.nth.DynamicSpringBatchSchedule.repository.TBigDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

/**
 * @Author: Hong Nguyen
 * @Create: 2020/10/11
 */
public class OneTaskSample extends Task {
    @PersistenceContext
    EntityManager entityManager;
    @Autowired
    TBigDataRepo repo;

    @Override
    public void execute(String[] args) throws Exception {
        long totalRow = repo.count();
        System.out.println("--------------- OneTaskSample is starting ----------------");
        long begin = System.currentTimeMillis();
        insert((int) totalRow);
        long end = System.currentTimeMillis() - begin;
        System.out.println("insert data in normal take : " + end + " ms");
    }

    @Transactional
    public void insert(int totalRow) {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("create_data");
        query.registerStoredProcedureParameter("i_index", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("i_limit", Integer.class, ParameterMode.IN);
        query.setParameter("i_index", 0);
        query.setParameter("i_limit", totalRow);
        query.execute();
    }
}
