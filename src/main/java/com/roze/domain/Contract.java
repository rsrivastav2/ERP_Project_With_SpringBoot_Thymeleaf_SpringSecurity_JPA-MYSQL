package com.roze.domain;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
@Entity
@EntityListeners(AuditingEntityListener.class)
public class Contract extends BaseEntity {

    private String reference;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Supplier supplier;

    @ManyToOne
    private ThirdParty thirdParty;

    @OneToOne
    private Contract followingUpContract;

    @OneToOne
    private Contract signingContract;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @Lob
    private String publicNote;

    @Lob
    private String privateNote;

    @CreatedBy
    private String createdBy;

    @CreatedDate
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date creationDate;

	public Contract() {
		
	}

	public Contract(String reference, Customer customer, Supplier supplier, ThirdParty thirdParty,
			Contract followingUpContract, Contract signingContract, Date date, String publicNote, String privateNote,
			String createdBy, Date creationDate) {
		super();
		this.reference = reference;
		this.customer = customer;
		this.supplier = supplier;
		this.thirdParty = thirdParty;
		this.followingUpContract = followingUpContract;
		this.signingContract = signingContract;
		this.date = date;
		this.publicNote = publicNote;
		this.privateNote = privateNote;
		this.createdBy = createdBy;
		this.creationDate = creationDate;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public ThirdParty getThirdParty() {
		return thirdParty;
	}

	public void setThirdParty(ThirdParty thirdParty) {
		this.thirdParty = thirdParty;
	}

	public Contract getFollowingUpContract() {
		return followingUpContract;
	}

	public void setFollowingUpContract(Contract followingUpContract) {
		this.followingUpContract = followingUpContract;
	}

	public Contract getSigningContract() {
		return signingContract;
	}

	public void setSigningContract(Contract signingContract) {
		this.signingContract = signingContract;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPublicNote() {
		return publicNote;
	}

	public void setPublicNote(String publicNote) {
		this.publicNote = publicNote;
	}

	public String getPrivateNote() {
		return privateNote;
	}

	public void setPrivateNote(String privateNote) {
		this.privateNote = privateNote;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

}
