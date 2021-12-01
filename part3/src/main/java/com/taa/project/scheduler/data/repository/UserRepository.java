package com.taa.project.scheduler.data.repository;

import com.taa.project.scheduler.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User getUserById(Long id);

    User getUserByLogin(String login);
}
