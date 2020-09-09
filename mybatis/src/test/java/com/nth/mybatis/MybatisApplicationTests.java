package com.nth.mybatis;

import com.nth.mybatis.mapper.TbCmUserDynamicSqlSupport;
import com.nth.mybatis.mapper.TbCmUserExtendMapper;
import com.nth.mybatis.mapper.TbCmUserMapper;
import com.nth.mybatis.model.TbCmUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@SpringBootTest
class MybatisApplicationTests {
    @Autowired
    TbCmUserMapper usersMapper;
    @Autowired
    TbCmUserExtendMapper usersCustomMapper;

    @Test
    void contextLoads() {
        String userId = "001";
        TbCmUser user = usersMapper.selectOne(u ->
                u.where(TbCmUserDynamicSqlSupport.userId, isEqualTo(userId))).get();
        System.out.println("print full name of user " + userId + " : " + user.getUserNm());

        List<TbCmUser> users = usersMapper.select(u -> u.limit(5));

        for (TbCmUser row : users) {
            System.out.println("print full name of user " + userId + " : " + row.getUserNm());
        }
        HashMap user2 = usersCustomMapper.getUser("002");
        System.out.println(user2);

        TbCmUser user1 = usersCustomMapper.selectById("001");
        System.out.println("print full name of user " + userId + " : " + user1.getUserNm());
    }

}
