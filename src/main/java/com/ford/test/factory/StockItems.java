package com.ford.test.factory;

import java.math.BigDecimal;

import com.ford.test.model.Items;
/**
 * 
 * @author DIBYA
 *
 */
public class StockItems {
/**
 * These are the Stock Items currently the Grocery store provides.
 * Multiple new Items can be added here
 */
	public static Items soup = new Items("Soup", "Tin", new BigDecimal("0.65"), true);
	public static Items bread = new Items("Bread", "Loaf", new BigDecimal("0.80"), true);
	public static Items milk = new Items("Milk", "Bottle", new BigDecimal("1.30"), true);
	public static Items apples = new Items("Apples", "Single", new BigDecimal("0.10"), true);

}
