package com.nth.SpringJpaBatch.repository;

import com.nth.SpringJpaBatch.model.TmpBigData;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author: Hong Nguyen
 * @Create: 2020/10/10
 */
public interface TmpBigDataRepo extends JpaRepository<TmpBigData, String> {
}
