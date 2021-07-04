package com.roze.domain;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import java.util.List;
@Entity
public class Tag extends BaseEntity {

	private String reference;

	@Lob
	private String description;

	private String color;

	@ManyToMany
	private List<ProductService> services;

	public Tag() {
		
	}

	public Tag(String reference, String description, String color, List<ProductService> services) {
		super();
		this.reference = reference;
		this.description = description;
		this.color = color;
		this.services = services;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public List<ProductService> getServices() {
		return services;
	}

	public void setServices(List<ProductService> services) {
		this.services = services;
	}
	

	
	
	

}
