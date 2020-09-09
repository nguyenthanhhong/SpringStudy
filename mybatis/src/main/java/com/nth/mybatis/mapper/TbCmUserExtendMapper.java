package com.nth.mybatis.mapper;

import com.nth.mybatis.model.TbCmUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.context.annotation.Primary;

import java.util.HashMap;
import java.util.List;

@Mapper
@Primary
public interface TbCmUserExtendMapper extends  TbCmUserMapper{
    HashMap getUser(String userId);
    List<HashMap> getUserAuthList(HashMap param);

    @SelectProvider(type = SqlProvider.class, method = "selectById")
    TbCmUser selectById(String id);

    public static class SqlProvider {
        public static String selectById() {
            return "select user_id as userId, user_nm as userNm, email as email, phone as phone, address as address, lang_cd as langCd, use_yn as useYn from tb_cm_user WHERE user_id = #{id}";
        }
    }
}
