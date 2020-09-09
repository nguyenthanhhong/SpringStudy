package com.nth.SpringGradleWithHibernate.repository.postgre;

import com.nth.SpringGradleWithHibernate.entity.postgre.PostgrePost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostgrePostRepo extends JpaRepository<PostgrePost, Long> {
}
