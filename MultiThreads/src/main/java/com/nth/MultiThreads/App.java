package com.nth.MultiThreads;

import com.nth.MultiThreads.service.TestService;
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
        sv.selectAllUser();
        System.out.println("--------------- insert data ----------------");
        long begin = System.currentTimeMillis();
        //sv.insertFromTableByMultiThreads();
        sv.insertFromTableByFor();
        long end = System.currentTimeMillis() - begin;
        System.out.println("insert data take : " + end + " ms");
    }
}
