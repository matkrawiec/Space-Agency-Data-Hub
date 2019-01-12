package com.mk.spaceAgencyDataHub.service;

import java.util.List;

import com.mk.spaceAgencyDataHub.entity.Product;

public interface ProductService {

	public List<Product> retriveProducts();

	public void saveProduct(Product product);

	public void deleteMission(Long missionId);
	

}
