package repository;

import model.FreeSlot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FreeSlotRepository extends JpaRepository<FreeSlot,Long> {
}
