package com.taa.project.scheduler.data.repository;

import com.taa.project.scheduler.data.model.Heading;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeadingRepository extends JpaRepository<Heading, Long> {
}
