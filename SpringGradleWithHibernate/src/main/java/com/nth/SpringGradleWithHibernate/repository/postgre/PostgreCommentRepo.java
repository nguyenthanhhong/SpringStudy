package com.nth.SpringGradleWithHibernate.repository.postgre;

import com.nth.SpringGradleWithHibernate.entity.postgre.PostgreComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostgreCommentRepo extends JpaRepository<PostgreComment, Long> {
}
