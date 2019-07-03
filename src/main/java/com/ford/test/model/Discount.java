package com.ford.test.model;

import java.time.LocalDate;
/**
 * To hold the Discount offers with 
 * the Offer start and End date
 * @author DIBYA
 *
 */
public class Discount {

	private String offer;
	private LocalDate validFrom;
	private LocalDate validTo;

	public Discount() {

	}

	public Discount(String offer, LocalDate validFrom, LocalDate validTo) {
		super();
		this.offer = offer;
		this.validFrom = validFrom;
		this.validTo = validTo;
	}

	public String getOffer() {
		return offer;
	}

	public void setOffer(String offer) {
		this.offer = offer;
	}

	public LocalDate getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(LocalDate validFrom) {
		this.validFrom = validFrom;
	}

	public LocalDate getValidTo() {
		return validTo;
	}

	public void setValidTo(LocalDate validTo) {
		this.validTo = validTo;
	}

	@Override
	public String toString() {
		return "Discount [offer=" + offer + ", validFrom=" + validFrom + ", validTo=" + validTo + "]";
	}

}