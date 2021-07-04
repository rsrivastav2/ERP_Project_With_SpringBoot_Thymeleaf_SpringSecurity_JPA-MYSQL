package com.roze.domain;


import com.roze.enumeration.Currency;
import com.roze.enumeration.PaymentTerms;
import com.roze.enumeration.PaymentTypes;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import java.util.List;
@Entity
public class ThirdParty extends BaseEntity {

    private String reference;

    private PaymentTerms paymentTerms;

    private PaymentTypes paymentTypes;

    @Lob
    private String publicNote;

    @Lob
    private String privateNote;

    private Currency currency;

    @OneToMany(mappedBy = "thirdParty")
    private List<Contract> contracts;

	public ThirdParty() {
		
	}

	public ThirdParty(String reference, PaymentTerms paymentTerms, PaymentTypes paymentTypes, String publicNote,
			String privateNote, Currency currency, List<Contract> contracts) {
		super();
		this.reference = reference;
		this.paymentTerms = paymentTerms;
		this.paymentTypes = paymentTypes;
		this.publicNote = publicNote;
		this.privateNote = privateNote;
		this.currency = currency;
		this.contracts = contracts;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public PaymentTerms getPaymentTerms() {
		return paymentTerms;
	}

	public void setPaymentTerms(PaymentTerms paymentTerms) {
		this.paymentTerms = paymentTerms;
	}

	public PaymentTypes getPaymentTypes() {
		return paymentTypes;
	}

	public void setPaymentTypes(PaymentTypes paymentTypes) {
		this.paymentTypes = paymentTypes;
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

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public List<Contract> getContracts() {
		return contracts;
	}

	public void setContracts(List<Contract> contracts) {
		this.contracts = contracts;
	}
	
    
    

}
