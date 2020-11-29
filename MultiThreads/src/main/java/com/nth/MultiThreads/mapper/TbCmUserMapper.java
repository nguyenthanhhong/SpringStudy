package com.nth.MultiThreads.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

/**
 * @Author: DELL
 * @Create: 2020/10/10
 */
@Mapper
public interface TbCmUserMapper {
    List<HashMap> getAllUser();

    int insertData(HashMap data);

    void insertFromProc(int index, int limit);
}
