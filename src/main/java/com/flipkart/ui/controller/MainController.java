package com.flipkart.ui.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flipkart.service.FlipkartService;
import com.flipkart.shared.dto.AccountRegDto;
import com.flipkart.shared.dto.ClothDto;
import com.flipkart.shared.dto.ProductsDto;
import com.flipkart.ui.model.request.AccountRegRequest;
import com.flipkart.ui.model.response.AccountRegResponse;
import com.flipkart.ui.model.response.ClothResponse;
import com.flipkart.ui.model.response.ProductsResponse;

@RestController
public class MainController {
	@Autowired
	FlipkartService service;

//	@RequestMapping(value="authenticate",method=RequestMethod.PUT)
//	public AccountRegResponse Login(@RequestBody AccountRegRequest request) {
//		AccountRegResponse response = new AccountRegResponse();
//		AccountRegDto dto = new AccountRegDto();
//		BeanUtils.copyProperties(request, dto);
//		AccountRegDto reqDto = service.Login(dto);
//		BeanUtils.copyProperties(reqDto, response);
//		return response;
//	}

	@GetMapping("authTest")
	public String test() {
		return "Authenticated";
	}

//	@RequestMapping(value = "register", method = RequestMethod.PUT)
//	public AccountRegResponse Register(@RequestBody AccountRegRequest request) {
//		AccountRegResponse response = new AccountRegResponse();
//		AccountRegDto dto = new AccountRegDto();
//		BeanUtils.copyProperties(request, dto);
//		AccountRegDto reqDto = service.Register(dto);
//		BeanUtils.copyProperties(reqDto, response);
//		return response;
//	}

	@RequestMapping(value = "getProducts/mensAccessories", method = RequestMethod.GET)
	public List<ProductsResponse> MensAccs() {
		List<ProductsResponse> response = new ArrayList<ProductsResponse>();
		List<ProductsDto> dto = service.MensAccProduct();
		for (ProductsDto source : dto) {
			ProductsResponse target = new ProductsResponse();
			BeanUtils.copyProperties(source, target);
			response.add(target);
		}
		return response;
	}

	@RequestMapping(value = "getProducts/mensClothing", method = RequestMethod.GET)
	public List<ClothResponse> Cloth(@RequestParam(required = false) String category,
			@RequestParam(required = false) String size) {
		List<ClothDto> dto = service.Clothing(category, size);
		ModelMapper mapper = new ModelMapper();
		java.lang.reflect.Type targetListType = new TypeToken<List<ClothResponse>>() {
		}.getType();
		List<ClothResponse> response = mapper.map(dto, targetListType);
		return response;
	}

	@RequestMapping(value = "getProducts/mensClothing/{name}", method = RequestMethod.GET)
	public ClothResponse ClothDetail(@PathVariable("name") String name) {
		ClothDto dto = service.clothDetail(name);
		ModelMapper mapper = new ModelMapper();
		ClothResponse response = mapper.map(dto, ClothResponse.class);
		return response;
	}

	@RequestMapping({ "/hello" })
	public String firstPage() {
		return "Hello World";
	}
}
