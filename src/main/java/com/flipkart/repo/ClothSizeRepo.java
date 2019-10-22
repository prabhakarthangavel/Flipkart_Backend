package com.flipkart.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.flipkart.io.entity.ClothSizeEntity;

public interface ClothSizeRepo extends CrudRepository<ClothSizeEntity, Integer> {
	@Query(value="select * from clothsize where small = ?1",nativeQuery=true)
	List<ClothSizeEntity> findSmallSize(String size);
	
	@Query(value="select * from clothsize where medium = ?1",nativeQuery=true)
	List<ClothSizeEntity> findMediumSize(String size);
	
	@Query(value="select * from clothsize where large = ?1",nativeQuery=true)
	List<ClothSizeEntity> findLargeSize(String size);
}
