package com.nth.DynamicSchedule.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author: Hong Nguyen
 * @Create: 2020/10/10
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "t_big_data")
public class TBigData {
    @Id
    String id;
    String name;
    Double value;
    Date date;
}
