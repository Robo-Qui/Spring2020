package data.repository;

import data.model.FreeSlot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FreeSlotRepository extends JpaRepository<FreeSlot,Long> {
}
