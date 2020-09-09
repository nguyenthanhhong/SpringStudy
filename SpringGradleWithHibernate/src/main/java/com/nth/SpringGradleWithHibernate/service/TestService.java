package com.nth.SpringGradleWithHibernate.service;

import com.nth.SpringGradleWithHibernate.entity.Post;
import com.nth.SpringGradleWithHibernate.repository.mysql.MySqlPostRepo;
import com.nth.SpringGradleWithHibernate.repository.postgre.PostgrePostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestService {
    @Autowired
    MySqlPostRepo mySqlPostRepo;

    @Autowired
    PostgrePostRepo postgrePostRepo;

    public List selectAllPost() {
        List<Post> posts =new ArrayList<>();

        posts.addAll(mySqlPostRepo.findAll());
        posts.addAll(postgrePostRepo.findAll());
        return posts;
    }
}
