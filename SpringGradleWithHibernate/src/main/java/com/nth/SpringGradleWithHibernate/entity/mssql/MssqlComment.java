package com.nth.SpringGradleWithHibernate.entity.mssql;

import com.nth.SpringGradleWithHibernate.entity.Comment;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table
public class MssqlComment extends Comment {
}
