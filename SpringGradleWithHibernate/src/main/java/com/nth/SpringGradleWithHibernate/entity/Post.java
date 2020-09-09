package com.nth.SpringGradleWithHibernate.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table
public class Post {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long post_id;
    @Column
    private String content;
    @Column
    private String crt_user_id;
    @Column
    private String upd_user_id;
    @Column
    private Date crt_date;
    @Column
    private Date upd_date;
}
