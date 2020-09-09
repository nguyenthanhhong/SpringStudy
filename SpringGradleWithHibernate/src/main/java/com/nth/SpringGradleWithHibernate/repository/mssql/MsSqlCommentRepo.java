package com.nth.SpringGradleWithHibernate.repository.mssql;

import com.nth.SpringGradleWithHibernate.entity.mssql.MssqlComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MsSqlCommentRepo extends JpaRepository<MssqlComment, Long> {
}
