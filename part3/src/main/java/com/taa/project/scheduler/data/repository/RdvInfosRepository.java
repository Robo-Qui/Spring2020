package com.taa.project.scheduler.data.repository;

import com.taa.project.scheduler.data.model.RdvInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RdvInfosRepository extends JpaRepository<RdvInfo, Long> {
}
