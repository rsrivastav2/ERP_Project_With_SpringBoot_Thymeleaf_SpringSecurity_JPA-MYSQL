package com.roze.domain;

import javax.persistence.Entity;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Supplier extends ThirdParty {

    private String supplierReference;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date plannedDeliveryDate;

	public Supplier() {
	
	}

	public Supplier(String supplierReference, Date plannedDeliveryDate) {
		this.supplierReference = supplierReference;
		this.plannedDeliveryDate = plannedDeliveryDate;
	}

	public String getSupplierReference() {
		return supplierReference;
	}

	public void setSupplierReference(String supplierReference) {
		this.supplierReference = supplierReference;
	}

	public Date getPlannedDeliveryDate() {
		return plannedDeliveryDate;
	}

	public void setPlannedDeliveryDate(Date plannedDeliveryDate) {
		this.plannedDeliveryDate = plannedDeliveryDate;
	}
	
    
    

}
