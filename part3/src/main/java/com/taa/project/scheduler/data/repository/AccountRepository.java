package com.taa.project.scheduler.data.repository;

import com.taa.project.scheduler.data.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
