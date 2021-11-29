package com.taa.project.scheduler.data.repository;

import com.taa.project.scheduler.data.model.FreeSlot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FreeSlotRepository extends JpaRepository<FreeSlot, Long> {
}
