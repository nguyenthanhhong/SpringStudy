package com.nth.mybatis.service;

import com.nth.mybatis.mapper.TbCmUserDynamicSqlSupport;
import com.nth.mybatis.mapper.TbCmUserMapper;
import com.nth.mybatis.model.TbCmUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Component
public class AutoGeneratorService {

    @Autowired
    TbCmUserMapper mbUserMapper;

    static void printUser(TbCmUser user) {
        System.out.println("UserId : " + user.getUserId() +
                ", UserNm : " + user.getUserNm() +
                ", Email : " + user.getEmail() +
                ", LangCd : " + user.getLangCd());
    }

    public void selectOne(String userId) {
        TbCmUser users = mbUserMapper.selectOne(u ->
                u.where(TbCmUserDynamicSqlSupport.userId, isEqualTo(userId))).get();
        printUser(users);
    }

    public void selectMany() {
        List<TbCmUser> users = mbUserMapper.select(u -> u.limit(5));
        for (TbCmUser row : users) {
            printUser(row);
        }
    }

    @PostConstruct
    public void init() {
        System.out.println("Generator config selectOne");
        selectOne("001");
        System.out.println("Generator config selectMany");
        selectMany();
    }
}
