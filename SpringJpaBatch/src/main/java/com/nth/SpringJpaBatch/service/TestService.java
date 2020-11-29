package com.nth.SpringJpaBatch.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: Hong Nguyen
 * @Create: 2020/10/10
 */
@Service
@Slf4j
public class TestService {
    private static final int BATCH_SIZE = 6;
    private static final int totalRow = 200000;
    private static final int threadCount = 6;
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void insert() {
        StoredProcedureQuery query = entityManager.createStoredProcedureQuery("create_data");
        query.registerStoredProcedureParameter("i_index", Integer.class, ParameterMode.IN);
        query.registerStoredProcedureParameter("i_limit", Integer.class, ParameterMode.IN);
        query.setParameter("i_index", 0);
        query.setParameter("i_limit", totalRow);
        query.execute();
    }

    @Transactional
    public void insertBatch() {
        int pageSize = (int) Math.ceil((double) totalRow / threadCount);
        for (int i = 0; i < threadCount; i++) {
            int start = i * pageSize;

            StoredProcedureQuery query = entityManager.createStoredProcedureQuery("create_data");
            query.registerStoredProcedureParameter("i_index", Integer.class, ParameterMode.IN);
            query.registerStoredProcedureParameter("i_limit", Integer.class, ParameterMode.IN);
            query.setParameter("i_index", start);
            query.setParameter("i_limit", pageSize);
            query.execute();
        }
    }

    @Transactional
    public void insertBatchByMultiThreads() {
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
