package com.nth.SpringGradleWithHibernate.repository.oracle;

import com.nth.SpringGradleWithHibernate.entity.oracle.OraclePost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OraclePostRepo extends JpaRepository<OraclePost, Long> {
}
