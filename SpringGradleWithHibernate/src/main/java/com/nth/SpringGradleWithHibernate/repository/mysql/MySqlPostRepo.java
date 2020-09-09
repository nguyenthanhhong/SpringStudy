package com.nth.SpringGradleWithHibernate.repository.mysql;

import com.nth.SpringGradleWithHibernate.entity.mysql.MySqlPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MySqlPostRepo extends JpaRepository<MySqlPost, Long> {
}
