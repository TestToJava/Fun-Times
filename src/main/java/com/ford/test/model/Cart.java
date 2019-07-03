package com.ford.test.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
/**
 * Cart is to hold all the Ordered Items and 
 * it will calculate the MRP without discount
 * 
 * @author DIBYA
 *
 */
public class Cart {

	private List<Items> items;
	private BigDecimal mrp;
	private BigDecimal price;

	public Cart() {
	}

	public List<Items> getItems() {
		return items;
	}

	public void setItems(List<Items> items) {
		this.items = items;
	}

	public BigDecimal getMrp() {
		return mrp;
	}

	public void setMrp(BigDecimal mrp) {
		this.mrp = mrp;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
/**
 * 
 * @param items --> Items passed through this Constructor
 * to have a normal cart without any discount 
 */
	public Cart(List<Items> items) {
		List<BigDecimal> total = new ArrayList<BigDecimal>();
		items.forEach((item) -> total.add(item.getCost()));
		BigDecimal sum = total.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
		this.items = items;
		this.mrp = sum;
	}

	@Override
	public String toString() {
		StringBuffer reader = new StringBuffer();
		reader.append("[Name\tType\tPrice]\n");
		reader.append("[----\t----\t-----]\n");
		for (Items item : items) {
			reader.append("[" + item.getProduct() + "\t" + item.getUnit() + "\t" + item.getCost() + "]\n");
		}

		return reader.toString();
	}

}