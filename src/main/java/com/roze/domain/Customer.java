package com.roze.domain;

import org.springframework.format.annotation.DateTimeFormat;

import com.roze.enumeration.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Entity
public class Customer extends ThirdParty{


    private String customerReference;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    private Source source;

    private AvailabilityDelay availabilityDelay;

    private ShippingMethod shippingMethod;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date deliveryDate;

    private IncoTerms incoTerms;

    private DefaultDocTemplate defaultDocTemplate;

    @OneToMany(mappedBy = "customer")
    private List<Contract> contracts;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;

	public Customer() {
		
	}

	public Customer(String customerReference, Date date, Source source, AvailabilityDelay availabilityDelay,
			ShippingMethod shippingMethod, Date deliveryDate, IncoTerms incoTerms,
			DefaultDocTemplate defaultDocTemplate, List<Contract> contracts, List<Order> orders) {
		super();
		this.customerReference = customerReference;
		this.date = date;
		this.source = source;
		this.availabilityDelay = availabilityDelay;
		this.shippingMethod = shippingMethod;
		this.deliveryDate = deliveryDate;
		this.incoTerms = incoTerms;
		this.defaultDocTemplate = defaultDocTemplate;
		this.contracts = contracts;
		this.orders = orders;
	}

	public String getCustomerReference() {
		return customerReference;
	}

	public void setCustomerReference(String customerReference) {
		this.customerReference = customerReference;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Source getSource() {
		return source;
	}

	public void setSource(Source source) {
		this.source = source;
	}

	public AvailabilityDelay getAvailabilityDelay() {
		return availabilityDelay;
	}

	public void setAvailabilityDelay(AvailabilityDelay availabilityDelay) {
		this.availabilityDelay = availabilityDelay;
	}

	public ShippingMethod getShippingMethod() {
		return shippingMethod;
	}

	public void setShippingMethod(ShippingMethod shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public IncoTerms getIncoTerms() {
		return incoTerms;
	}

	public void setIncoTerms(IncoTerms incoTerms) {
		this.incoTerms = incoTerms;
	}

	public DefaultDocTemplate getDefaultDocTemplate() {
		return defaultDocTemplate;
	}

	public void setDefaultDocTemplate(DefaultDocTemplate defaultDocTemplate) {
		this.defaultDocTemplate = defaultDocTemplate;
	}

	public List<Contract> getContracts() {
		return contracts;
	}

	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	
    
    

}

