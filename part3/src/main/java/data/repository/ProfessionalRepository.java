package data.repository;

import data.component.model.model.Professional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ProfessionalRepository extends JpaRepository<Professional, Long> {
    @Query("select Professional p where p.Id=?1")
    Professional getProfessionalById(Long id);

    @Query("select Professional p where p.Login=?1")
    Professional getProfessionalByLogin(String login);

    @Query("select Professional p where p.Name=?1")
    Professional getProfessionalByName(String name);

    @Modifying
    @Query("update User u")
    void update(Professional prof);
}
