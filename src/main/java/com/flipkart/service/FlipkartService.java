package com.flipkart.service;

import java.util.List;

import com.flipkart.shared.dto.AccountRegDto;
import com.flipkart.shared.dto.ClothDto;
import com.flipkart.shared.dto.ProductsDto;

public interface FlipkartService {
	List<ProductsDto> MensAccProduct();
	List<ClothDto> Clothing(String category, String size);
	ClothDto clothDetail(String name);
	
}
