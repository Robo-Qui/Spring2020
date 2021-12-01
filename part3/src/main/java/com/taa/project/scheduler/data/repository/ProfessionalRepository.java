package com.taa.project.scheduler.data.repository;

import com.taa.project.scheduler.data.model.Professional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProfessionalRepository extends JpaRepository<Professional, Long> {
    @Query("select  p from Professional p where p.id=?1")
    Professional getProfessionalById(Long id);

    @Query("select p from Professional p where p.login=?1")
    Professional getProfessionalByLogin(String login);

    @Query("select p from Professional p where p.name=?1")
    Professional getProfessionalByName(String name);

}
