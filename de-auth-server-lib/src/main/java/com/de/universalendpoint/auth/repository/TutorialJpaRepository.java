package com.de.universalendpoint.auth.repository;

import com.de.universalendpoint.auth.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TutorialJpaRepository extends JpaRepository<Tutorial,Long> {
    List<Tutorial> findByPublished(boolean published);

    List<Tutorial> findByTitleContaining(String title);

}
