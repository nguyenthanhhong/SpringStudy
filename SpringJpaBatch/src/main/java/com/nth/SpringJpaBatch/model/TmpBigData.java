package com.nth.SpringJpaBatch.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * @Author: Hong Nguyen
 * @Create: 2020/10/10
 */
@Entity
@Data
@NoArgsConstructor
public class TmpBigData {
    @Id
    String id;
    String name;
    Double value;
    Date date;
}
