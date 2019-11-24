package com.flipkart.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flipkart.io.entity.AccountRegEntity;

@Repository
public interface AccReg extends JpaRepository<AccountRegEntity, Integer> {

	Optional<AccountRegEntity> findByemail(String email);
}
