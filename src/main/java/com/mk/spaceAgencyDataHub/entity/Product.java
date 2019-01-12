package com.mk.spaceAgencyDataHub.entity;

import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="product")
public class Product {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="product_footprint")
	private ArrayList<Double> productFootprint;
	
	@Column(name="product_acquisition_date")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss zzz", timezone="UTC")
	private Date productAcquisitionDate;
	
	@Min(value=0, message="The price muse be positive")
	private int price;
	
	private URL url;
	
	@ManyToOne(fetch=FetchType.LAZY, 
			cascade ={CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="mission_name", referencedColumnName = "mission_name")
	private Mission mission;

	
	
	public Product() {
	}

	public Product(ArrayList<Double> productFootprint, Date productAcquisitionDate,
			@Min(value = 0, message = "The price must be positive") int price, URL url) {
		this.productFootprint = productFootprint;
		this.productAcquisitionDate = productAcquisitionDate;
		this.price = price;
		this.url = url;
	}


	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}

	public Mission getMission() {
		return mission;
	}


	public void setMission(Mission mission) {
		this.mission = mission;
	}

	public ArrayList<Double> getProductFootprint() {
		return productFootprint;
	}

	public void setProductFootprint(ArrayList<Double> productFootprint) {
		this.productFootprint = productFootprint;
	}

	public Date getProductAcquisitionDate() {
		return productAcquisitionDate;
	}

	public void setProductAcquisitionDate(Date productAcquisitionDate) {
		this.productAcquisitionDate = productAcquisitionDate;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}
	
	
	
	
	

}











