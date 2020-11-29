/*
 * Created by Hong Nguyen on 2020/9/14
 */

package com.nth.SpringGradleWithMyBatis.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/postgre")
public class PostgresqlController {
    @GetMapping("")
    public List<HashMap> index() {
        return null;
    }
}
