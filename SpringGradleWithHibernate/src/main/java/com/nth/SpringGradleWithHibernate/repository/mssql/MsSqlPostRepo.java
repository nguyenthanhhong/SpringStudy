package com.nth.SpringGradleWithHibernate.repository.mssql;

import com.nth.SpringGradleWithHibernate.entity.mssql.MssqlPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MsSqlPostRepo extends JpaRepository<MssqlPost, Long> {
}
