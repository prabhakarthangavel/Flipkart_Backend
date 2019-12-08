package com.flipkart.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.flipkart.io.entity.UserRoles;

@Repository
public interface UserRolesRepo extends CrudRepository<UserRoles, Integer> {

}
