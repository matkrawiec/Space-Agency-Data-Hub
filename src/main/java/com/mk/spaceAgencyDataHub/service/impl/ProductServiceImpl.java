package com.mk.spaceAgencyDataHub.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mk.spaceAgencyDataHub.entity.Product;
import com.mk.spaceAgencyDataHub.repository.ProductRepository;
import com.mk.spaceAgencyDataHub.service.ProductService;

@Service("ProductService")
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> retriveProducts() {
		List<Product> products = productRepository.findAll();
		return products;
	}

	@Override
	public void saveProduct(Product product) {
		productRepository.save(product);
	}

	@Override
	public void deleteMission(Long missionId) {
		productRepository.deleteById(missionId);
		
	}

}












