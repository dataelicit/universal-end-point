package com.dataelicit.sw.universalendpoint.auth.repository;

import com.dataelicit.sw.universalendpoint.auth.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TutorialJpaRepository extends JpaRepository<Tutorial,Long> {
    List<Tutorial> findByPublished(boolean published);

    List<Tutorial> findByTitleContaining(String title);

}
