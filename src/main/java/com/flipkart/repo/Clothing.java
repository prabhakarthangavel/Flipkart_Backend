package com.flipkart.repo;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.flipkart.io.entity.ClothEntity;

@Repository
public interface Clothing extends CrudRepository<ClothEntity, Integer> {
	
	@Query(value="select * from clothing where category = ?1",nativeQuery=true)
	List<ClothEntity> findCategory(String category);

	@Query(value="select * from clothing where name =?1",nativeQuery=true)
	ClothEntity findName(String a);
}
