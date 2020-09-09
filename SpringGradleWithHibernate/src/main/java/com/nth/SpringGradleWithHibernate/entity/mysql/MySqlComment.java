package com.nth.SpringGradleWithHibernate.entity.mysql;

import com.nth.SpringGradleWithHibernate.entity.Comment;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table
public class MySqlComment extends Comment {
}
