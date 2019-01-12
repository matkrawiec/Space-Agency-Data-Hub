package com.mk.spaceAgencyDataHub.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="mission")
public class Mission implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="mission_name", unique=true)
	private String missionName;
	
	@Column(name="imagery_type")
	@Pattern(regexp= "Panchromatic|Multispectral|Hyperspectral", flags = Pattern.Flag.CASE_INSENSITIVE,
	message = "Enter correct type - Panchromatic / Multispectral / Hyperspectral")
	private String imageryType;
	
	@Column(name="start_date")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss zzz", timezone="UTC")
	private Date startDate;
	
	@Column(name="finish_date")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm:ss zzz", timezone="UTC")
	private Date finishDate;
	
	@OneToMany(mappedBy ="mission", cascade =
		{CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	private List<Product> product;
	

	public Mission() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getMissionName() {
		return missionName;
	}

	public void setMissionName(String missionName) {
		this.missionName = missionName;
	}

	public String getImageryType() {
		return imageryType;
	}

	public void setImageryType(String imageryType) {
		this.imageryType = imageryType;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(Date finishDate) {
		this.finishDate = finishDate;
	}
	

}












