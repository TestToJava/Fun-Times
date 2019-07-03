package com.ford.test.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.ford.test.model.Cart;
import com.ford.test.model.Items;
/**
 * 
 * @author DIBYA
 *
 */
public class DiscountService {
/**
 * OfferOne will calculate the Bread and Soup combo offer
 * @param cart -> If the Cart contains Two Soup and 3 Breads
 * the offer of 50% will be applicable for Single Bread.
 * If the Cart contains 5 Soups and 4 Breads then the offer will
 * be applicable for both the Breads present in Cart.
 * @return
 */
	public Cart offerOne(Cart cart) {

		boolean applicable = false;
		List<Items> discounted = new ArrayList<>();
		double maxBreads = 0;
		int breadCount = 0;
		Map<Items, Long> itemsMap = cart.getItems().stream()
				.collect(Collectors.groupingBy(e -> e, Collectors.counting()));
		for (Items item : cart.getItems()) {
			if ("soup".equalsIgnoreCase(item.getProduct()) && itemsMap.get(item) >= 2) {
				maxBreads = Math.floor(itemsMap.get(item) / 2);
				applicable = true;
			}
		}
		for (Items item : cart.getItems()) {
			if ("bread".equalsIgnoreCase(item.getProduct()) && applicable) {
				breadCount++;
				BigDecimal divisor = new BigDecimal("2");
				BigDecimal cost = item.getCost().divide(divisor, 2);
				Items discountedItem = new Items(item.getProduct(), item.getUnit(), cost, item.isInStock());
				discounted.add(discountedItem);
				if (breadCount == maxBreads) {
					applicable = false;
				}
			} else {
				discounted.add(item);
			}
		}
		return new Cart(discounted);
	}
/**
 * 
 * @param cart -> if the Cart contains Apples, 
 * It will calculate the 10% discount and will subtract
 * from the main price and return the Apples with Discount.
 * @return
 */
	public Cart offerTwo(Cart cart) {
		List<Items> discounted = new ArrayList<>();
		for (Items item : cart.getItems()) {
			if ("apples".equalsIgnoreCase(item.getProduct())) {
				BigDecimal divisor = new BigDecimal("100");
				BigDecimal percentile = new BigDecimal("10");
				BigDecimal discount = percentile.multiply(item.getCost()).divide(divisor, 2);
				BigDecimal finalCost = item.getCost().subtract(discount);
				Items discountedItem = new Items(item.getProduct(), item.getUnit(), finalCost, item.isInStock());
				discounted.add(discountedItem);
			}
			else {
				discounted.add(item);
			}
		}
		return new Cart(discounted);
	}
}