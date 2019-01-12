package com.mk.spaceAgencyDataHub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mk.spaceAgencyDataHub.entity.Mission;
import com.mk.spaceAgencyDataHub.entity.Product;
import com.mk.spaceAgencyDataHub.service.MissionService;
import com.mk.spaceAgencyDataHub.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private MissionService missionService;
	
	@GetMapping("/products")
	public List<Product> getProducts(){
		List<Product> products = productService.retriveProducts();
		return products;
	}
	
	@PostMapping("/products/{missionId}")
	public void saveProduct(@PathVariable(name="missionId") Long missionId, @RequestBody Product product) {
		String missionName = missionService.getMission(missionId).getMissionName();
		if(missionName != null) {
			Mission mission = missionService.getMission(missionId);
			product.setMission(mission);
			product.setId(0L);
			productService.saveProduct(product);
		}
	}
	@DeleteMapping("/products/{missionId}")
	public void deleteMission (@PathVariable(name="missionId") Long missionId) {
		productService.deleteMission(missionId);
	}
}





















