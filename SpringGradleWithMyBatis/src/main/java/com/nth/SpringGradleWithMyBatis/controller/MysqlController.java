/*
 * Created by Hong Nguyen on 2020/9/14
 */

package com.nth.SpringGradleWithMyBatis.controller;

import com.nth.SpringGradleWithMyBatis.service.MysqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/mysql")
public class MysqlController {
    @Autowired
    MysqlService mysqlService;
    @GetMapping("")
    public List<HashMap> index() {
        return null;
    }
}
