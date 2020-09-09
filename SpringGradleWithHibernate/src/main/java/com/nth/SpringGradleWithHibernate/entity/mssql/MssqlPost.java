package com.nth.SpringGradleWithHibernate.entity.mssql;

import com.nth.SpringGradleWithHibernate.entity.Post;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table
public class MssqlPost extends Post {
}
