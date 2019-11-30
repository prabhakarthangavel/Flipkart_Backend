package com.flipkart.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flipkart.io.entity.AccountRegEntity;
import com.flipkart.io.entity.ClothEntity;
import com.flipkart.io.entity.ClothSizeEntity;
import com.flipkart.io.entity.MensAccsEntity;
import com.flipkart.repo.AccReg;
import com.flipkart.repo.ClothSizeRepo;
import com.flipkart.repo.Clothing;
import com.flipkart.repo.MensAccsProduct;
import com.flipkart.service.FlipkartService;
import com.flipkart.shared.dto.AccountRegDto;
import com.flipkart.shared.dto.ClothDto;
import com.flipkart.shared.dto.ProductsDto;
import com.flipkart.utils.Utilities;

@Service
public class ServiceImpl implements FlipkartService {
	@Autowired
	AccReg accRepo;

	@Autowired
	MensAccsProduct mensAccsRepo;

	@Autowired
	Clothing clothRepo;

	@Autowired
	ClothSizeRepo clothsizeRepo;

	@Autowired
	Utilities utils;

//	@Override
//	public AccountRegDto Login(AccountRegDto dto) {
//		AccountRegDto DTO = new AccountRegDto();
//		AccountRegEntity entity = new AccountRegEntity();
//		BeanUtils.copyProperties(dto, entity);
//		AccountRegEntity reqEntity = accRepo.findByemail(dto.getEmail());
//		if (dto.getEmail() == null || dto.getPassword() == null) {
//			dto.setStatus("All the fields are mandatory");
//		} else if (reqEntity == null) {
//			dto.setStatus("Invalid username or password");
//		} else if (dto.getPassword().equalsIgnoreCase(reqEntity.getPassword())) {
//			dto.setStatus("Login Sucessfull");
//		}
//		return dto;
//	}

//	@Override
//	public AccountRegDto Register(AccountRegDto details) {
//		AccountRegDto dtoValue = new AccountRegDto();
//		AccountRegEntity entity = new AccountRegEntity();
//		BeanUtils.copyProperties(details, entity);
//		if (details.getUsername() == null) {
//			dtoValue.setStatus("Username is mandatory");
//		} else if (accRepo.findByusername(details.getUsername()) != null) {
//			dtoValue.setStatus("Username already used");
//		} else if (details.getPassword() == null) {
//			dtoValue.setStatus("Password is Mandatory");
//		} else if (utils.checkString(details.getPassword()) == false) {
//			dtoValue.setStatus(
//					"Password should contain at least an uppercase and a lowercase character, a number and a special character");
//		} else if (accRepo.save(entity) != null) {
//			System.out.println("idValue" + entity.getId());
//			dtoValue.setStatus("Sucess");
//		}
//		return dtoValue;
//	}

	@Override
	public List<ProductsDto> MensAccProduct() {
		List<ProductsDto> dto = new ArrayList<ProductsDto>();
		Iterable<MensAccsEntity> entity = mensAccsRepo.findAll();
		for (MensAccsEntity source : entity) {
			ProductsDto target = new ProductsDto();
			BeanUtils.copyProperties(source, target);
			dto.add(target);
		}
		return dto;
	}

	@Override
	public List<ClothDto> Clothing(String category, String size) {
		if (category == null && size == null) {
			Iterable<ClothEntity> entity = clothRepo.findAll();
			ModelMapper mapper = new ModelMapper();
			java.lang.reflect.Type targetListType = new TypeToken<List<ClothDto>>() {
			}.getType();
			List<ClothDto> dto = mapper.map(entity, targetListType);
			return dto;
		} else if (category != null && size == null) {
			Iterable<ClothEntity> entity = clothRepo.findCategory(category);
			ModelMapper mapper = new ModelMapper();
			java.lang.reflect.Type targetListType = new TypeToken<List<ClothDto>>() {
			}.getType();
			List<ClothDto> dto = mapper.map(entity, targetListType);
			return dto;
		} else if (category == null && size != null) {
			if (size.equalsIgnoreCase("Small")) {
				Iterable<ClothSizeEntity> sizeEntity = clothsizeRepo.findSmallSize("true");
				ModelMapper mapper = new ModelMapper();
				java.lang.reflect.Type targetListType = new TypeToken<List<ClothDto>>() {
				}.getType();
				List<ClothDto> dto = mapper.map(sizeEntity, targetListType);
				return dto;
			} else if (size.equalsIgnoreCase("Medium")) {
				Iterable<ClothSizeEntity> sizeEntity = clothsizeRepo.findMediumSize("true");
				ModelMapper mapper = new ModelMapper();
				java.lang.reflect.Type targetListType = new TypeToken<List<ClothDto>>() {
				}.getType();
				List<ClothDto> dto = mapper.map(sizeEntity, targetListType);
				return dto;
			} else if (size.equalsIgnoreCase("Large")) {
				Iterable<ClothSizeEntity> sizeEntity = clothsizeRepo.findLargeSize("true");
				ModelMapper mapper = new ModelMapper();
				java.lang.reflect.Type targetListType = new TypeToken<List<ClothDto>>() {
				}.getType();
				List<ClothDto> dto = mapper.map(sizeEntity, targetListType);
				return dto;
			}
		} else {
			Iterable<ClothEntity> entity = clothRepo.findCategory(category);
			List<ClothEntity> returnEntity = new ArrayList<ClothEntity>();
			if (size.equalsIgnoreCase("Small")) {
				for (ClothEntity source : entity) {
					if (source.getClothSize().isSmall()) {
						returnEntity.add(source);
					}
				}

			} else if (size.equalsIgnoreCase("Medium")) {
				for (ClothEntity source : entity) {
					if (source.getClothSize().isMedium()) {
						returnEntity.add(source);
					}
				}
			} else if (size.equalsIgnoreCase("Large")) {
				for (ClothEntity source : entity) {
					if (source.getClothSize().isLarge()) {
						returnEntity.add(source);
					}
				}
			}
			ModelMapper mapper = new ModelMapper();
			java.lang.reflect.Type targetListType = new TypeToken<List<ClothDto>>() {
			}.getType();
			List<ClothDto> dto = mapper.map(returnEntity, targetListType);
			return dto;
		}
		return null;
	}

	@Override
	public ClothDto clothDetail(String name) {
		String a = name;
		System.out.println(a);
		ClothEntity entity = clothRepo.findName(a);
		ModelMapper mapper = new ModelMapper();
		ClothDto dto = mapper.map(entity, ClothDto.class);
		return dto;
	}

}
