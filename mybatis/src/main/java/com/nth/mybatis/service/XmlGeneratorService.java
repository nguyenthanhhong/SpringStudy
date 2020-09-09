package com.nth.mybatis.service;

import com.nth.mybatis.mapper.TbCmUserExtendMapper;
import com.nth.mybatis.model.TbCmUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;

@Component
public class XmlGeneratorService {
    @Autowired
    TbCmUserExtendMapper usersCustomMapper;

    void contextLoads() {
        HashMap param = new HashMap();
        param.put("USER_ID", "001");
        List<HashMap> user2 = usersCustomMapper.getUserAuthList(param);
        for (HashMap row : user2) {
            System.out.println(row);
        }
    }

    @PostConstruct
    public void init() {
        System.out.println("xml Generator query");
        contextLoads();
    }
}
