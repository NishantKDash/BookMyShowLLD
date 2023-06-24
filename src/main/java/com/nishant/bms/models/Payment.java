package com.nishant.bms.models;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;

@Entity
public class Payment extends BaseModel{

	
	@Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;	
	private Date timeOfPayment;
	private double amount;
	private String referenceId;
	
	@Enumerated(EnumType.STRING)
	private PaymentStatus paymentStatus;
	
	@ManyToOne
	private Ticket ticket;
}
