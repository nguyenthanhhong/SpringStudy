package com.nth.MultiThreads.service;

import com.nth.MultiThreads.mapper.TbCmUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author: DELL
 * @Create: 2020/10/10
 */
@Service
@Slf4j
public class TestService {
    private static final int MAX_ROW = 100000;
    private static final int threadCount = 6;
    @Autowired
    TbCmUserMapper mapper;

    @Autowired
    SqlSessionFactory sqlSessionFactory;

    public void selectAllUser() {
        List<HashMap> data = mapper.getAllUser();

        for (HashMap row : data) {
            log.info("Id: " + row.get("USER_ID") + " Name: " + row.get("USER_NM"));
        }
    }

    public void insertBigData() {
        for (int i = 0; i < MAX_ROW; i++) {
            HashMap data = new HashMap();
            data.put("ID", System.currentTimeMillis());
            data.put("NAME", "row insert number 2" + i);
            data.put("VALUE", Math.random() * 1000);
            data.put("DATE", new Date());
            mapper.insertData(data);
        }
    }

    public void insertBatch() {
        final SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        try {
            final TbCmUserMapper mapperBatch = sqlSession.getMapper(TbCmUserMapper.class);
            for (int i = 0; i < MAX_ROW; i++) {
                HashMap data = new HashMap();
                data.put("ID", System.currentTimeMillis());
                data.put("NAME", "row insert number 2" + i);
                data.put("VALUE", Math.random() * 1000);
                data.put("DATE", new Date());
                mapperBatch.insertData(data);
                Thread.sleep(1);
            }
            sqlSession.commit();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    public void insertFromTableByBatch() {
        final SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        try {
            final TbCmUserMapper mapperBatch = sqlSession.getMapper(TbCmUserMapper.class);
            mapperBatch.insertFromProc(0, 200000);
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    public void insertFromTableByMultiThreads() {
        final SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        try {
            ExecutorService executor = Executors.newFixedThreadPool(threadCount);
            final TbCmUserMapper mapperBatch = sqlSession.getMapper(TbCmUserMapper.class);
            final int totalRow = 200000;
            int pageSize = (int) Math.ceil((double) totalRow / threadCount);
            for (int i = 0; i < threadCount; i++) {
                int start = i * pageSize;
                executor.execute(() -> mapperBatch.insertFromProc(start, pageSize));
            }
            sqlSession.commit();
            executor.shutdown();
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    public void insertFromTableByFor() {
        final SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        try {
            final TbCmUserMapper mapperBatch = sqlSession.getMapper(TbCmUserMapper.class);
            final int totalRow = 200000;
            int pageSize = (int) Math.ceil((double) totalRow / threadCount);
            for (int i = 0; i < threadCount; i++) {
                int start = i * pageSize;
                mapperBatch.insertFromProc(start, pageSize);
            }
            sqlSession.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
}
