package com.taa.project.scheduler.data.repository;

import com.taa.project.scheduler.data.model.FreeSlot;
import com.taa.project.scheduler.data.model.Professional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FreeSlotRepository extends JpaRepository<FreeSlot, Long> {
    @Query("select  p from FreeSlot p where p.id=?1")
    FreeSlot getById(Long id);
}
