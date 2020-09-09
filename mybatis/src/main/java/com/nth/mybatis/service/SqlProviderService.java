package com.nth.mybatis.service;

import com.nth.mybatis.mapper.TbCmUserDynamicSqlSupport;
import com.nth.mybatis.mapper.TbCmUserExtendMapper;
import com.nth.mybatis.model.TbCmUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Component
public class SqlProviderService {@Autowired
TbCmUserExtendMapper usersCustomMapper;
    static void printUser(TbCmUser user) {
        System.out.println("UserId : " + user.getUserId() +
                ", UserNm : " + user.getUserNm() +
                ", Email : " + user.getEmail() +
                ", LangCd : " + user.getLangCd());
    }
    void contextLoads() {
        TbCmUser user1 = usersCustomMapper.selectById("001");
        printUser(user1);
    }

    @PostConstruct
    public void init() {
        System.out.println("SqlProvider select 002");
        contextLoads();
    }
}
