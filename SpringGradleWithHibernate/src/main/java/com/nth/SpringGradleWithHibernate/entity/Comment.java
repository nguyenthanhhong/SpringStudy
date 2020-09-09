package com.nth.SpringGradleWithHibernate.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table
public class Comment {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Id
    @Column
    private Long post_id;
    @Column
    private String content;
    @Column
    private String crt_user_id;
    @Column
    private Date crt_date;
}
