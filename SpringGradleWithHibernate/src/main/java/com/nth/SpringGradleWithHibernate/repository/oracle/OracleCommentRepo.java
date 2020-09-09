package com.nth.SpringGradleWithHibernate.repository.oracle;

import com.nth.SpringGradleWithHibernate.entity.oracle.OracleComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OracleCommentRepo extends JpaRepository<OracleComment, Long> {
}
