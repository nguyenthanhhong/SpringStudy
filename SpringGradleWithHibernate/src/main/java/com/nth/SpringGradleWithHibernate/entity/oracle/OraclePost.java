package com.nth.SpringGradleWithHibernate.entity.oracle;

import com.nth.SpringGradleWithHibernate.entity.Comment;
import com.nth.SpringGradleWithHibernate.entity.Post;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table
public class OraclePost extends Post {
}
