package data.repository;

import data.component.model.model.Heading;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeadingRepository extends JpaRepository<Heading,Long> {
}
