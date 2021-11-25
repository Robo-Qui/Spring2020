package data.repository;

import data.component.model.model.FreeSlot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FreeSlotRepository extends JpaRepository<FreeSlot,Long> {
}
