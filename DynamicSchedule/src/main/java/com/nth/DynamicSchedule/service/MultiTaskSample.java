package com.nth.DynamicSchedule.service;

import com.nth.DynamicSchedule.config.Task;
import com.nth.DynamicSchedule.repository.TBigDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Hong Nguyen
 * @Create: 2020/10/11
 */
public class MultiTaskSample extends Task {
    @PersistenceContext
    EntityManager entityManager;
    @Autowired
    TBigDataRepo repo;

    @Override
    public void execute(String[] args) throws Exception {
        if (args.length == 0) return;
        Integer threadCount = Integer.parseInt(args[0]);
        long totalRow = repo.count();
        System.out.println("--------------- MultiTaskSample is starting ----------------");
        long begin = System.currentTimeMillis();
        insertBatchByMultiThreads((int) totalRow, threadCount);
        long end = System.currentTimeMillis() - begin;
        System.out.println("insert data multi threads take : " + end + " ms");
    }

    @Transactional
    public void insertBatchByMultiThreads(int totalRow, Integer threadCount) {
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);
        int pageSize = (int) Math.ceil((double) totalRow / threadCount);
        for (int i = 0; i < threadCount; i++) {
            int start = i * pageSize;

            executor.execute(() -> {
                StoredProcedureQuery query = entityManager.createStoredProcedureQuery("create_data");
                query.registerStoredProcedureParameter("i_index", Integer.class, ParameterMode.IN);
                query.registerStoredProcedureParameter("i_limit", Integer.class, ParameterMode.IN);
                query.setParameter("i_index", start);
                query.setParameter("i_limit", pageSize);
                query.execute();
            });
        }
    }
}
