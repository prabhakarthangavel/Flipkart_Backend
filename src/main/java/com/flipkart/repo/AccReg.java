package com.flipkart.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flipkart.io.entity.AccountRegEntity;

@Repository
public interface AccReg extends JpaRepository<AccountRegEntity, Integer> {

	AccountRegEntity findByusername(String username);
}
