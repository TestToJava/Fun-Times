package com.ford.test.model;

import java.math.BigDecimal;
/**
 * Items are the Grocery Stock items
 * @author DIBYA
 *
 */
public class Items {

	private String product;
	private String unit;
	private BigDecimal cost;
	private boolean inStock = false;

	public Items() {

	}

	public Items(String product, String unit, BigDecimal cost, boolean inStock) {
		super();
		this.product = product;
		this.unit = unit;
		this.cost = cost;
		this.inStock = inStock;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public boolean isInStock() {
		return inStock;
	}

	public void setInStock(boolean inStock) {
		this.inStock = inStock;
	}

	@Override
	public String toString() {
		return "Items [product=" + product + ", unit=" + unit + ", cost=" + cost + ", inStock=" + inStock + "]";
	}

}