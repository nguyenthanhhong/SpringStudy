package com.nth.SpringGradleWithHibernate.repository.mysql;

import com.nth.SpringGradleWithHibernate.entity.mysql.MySqlComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MySqlCommentRepo extends JpaRepository<MySqlComment, Long> {
}
