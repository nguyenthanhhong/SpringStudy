package com.nth.SpringJpaBatch;

import com.nth.SpringJpaBatch.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App implements CommandLineRunner {
    @Autowired
    TestService sv;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("--------------- insert data ----------------");
        long begin = System.currentTimeMillis();
        sv.insert();
        long end = System.currentTimeMillis() - begin;
        System.out.println("insert data in normal take : " + end + " ms");


        begin = System.currentTimeMillis();
        sv.insertBatch();
        end = System.currentTimeMillis() - begin;
        System.out.println("insert data in for each take : " + end + " ms");


        begin = System.currentTimeMillis();
        sv.insertBatchByMultiThreads();
        end = System.currentTimeMillis() - begin;
        System.out.println("insert data in multi threads take : " + end + " ms");
    }
}
