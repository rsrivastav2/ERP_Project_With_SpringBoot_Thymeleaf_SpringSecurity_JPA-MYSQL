package com.roze.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.URL;


import com.roze.enumeration.DurationType;
import com.roze.enumeration.PurchaseStatus;
import com.roze.enumeration.SaleStatus;
import com.roze.enumeration.TaxRate;
import com.roze.enumeration.TaxType;




@Entity
public class ProductService extends BaseEntity {

	@NotEmpty
	private String reference;

	@NotEmpty
	private String label;

	private SaleStatus saleStatus;

	private PurchaseStatus purchaseStatus;

	@Lob
	private String description;

	@URL
	private String publicUrl;

	private Integer durationValue;

	private DurationType durationType;

	@Lob
	private String note;

	@ManyToMany
	private List<Tag> tags;

	private Double salePrice;

	private TaxType taxType;

	private Double minSalePrice;

	private TaxRate taxRate;

	public ProductService() {
	
	}

	public ProductService(String reference, String label, SaleStatus saleStatus, PurchaseStatus purchaseStatus,
			String description, String publicUrl, Integer durationValue, DurationType durationType, String note,
			List<Tag> tags, Double salePrice, TaxType taxType, Double minSalePrice, TaxRate taxRate) {
		super();
		this.reference = reference;
		this.label = label;
		this.saleStatus = saleStatus;
		this.purchaseStatus = purchaseStatus;
		this.description = description;
		this.publicUrl = publicUrl;
		this.durationValue = durationValue;
		this.durationType = durationType;
		this.note = note;
		this.tags = tags;
		this.salePrice = salePrice;
		this.taxType = taxType;
		this.minSalePrice = minSalePrice;
		this.taxRate = taxRate;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public SaleStatus getSaleStatus() {
		return saleStatus;
	}

	public void setSaleStatus(SaleStatus saleStatus) {
		this.saleStatus = saleStatus;
	}

	public PurchaseStatus getPurchaseStatus() {
		return purchaseStatus;
	}

	public void setPurchaseStatus(PurchaseStatus purchaseStatus) {
		this.purchaseStatus = purchaseStatus;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPublicUrl() {
		return publicUrl;
	}

	public void setPublicUrl(String publicUrl) {
		this.publicUrl = publicUrl;
	}

	public Integer getDurationValue() {
		return durationValue;
	}

	public void setDurationValue(Integer durationValue) {
		this.durationValue = durationValue;
	}

	public DurationType getDurationType() {
		return durationType;
	}

	public void setDurationType(DurationType durationType) {
		this.durationType = durationType;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public Double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}

	public TaxType getTaxType() {
		return taxType;
	}

	public void setTaxType(TaxType taxType) {
		this.taxType = taxType;
	}

	public Double getMinSalePrice() {
		return minSalePrice;
	}

	public void setMinSalePrice(Double minSalePrice) {
		this.minSalePrice = minSalePrice;
	}

	public TaxRate getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(TaxRate taxRate) {
		this.taxRate = taxRate;
	}
	

	
}
