package com.ford.test.service;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.BeforeClass;
import org.junit.Test;

import com.ford.test.model.Cart;
import com.ford.test.model.Items;
import com.ford.test.service.DiscountService;

public class DiscountServiceTest {
	private static Items soup = new Items("Soup", "Tin", new BigDecimal("0.65"), true);
	private static Items bread = new Items("Bread", "Loaf", new BigDecimal("0.80"), true);
	private static Items milk = new Items("Milk", "Bottle", new BigDecimal("1.30"), true);
	private static Items apples = new Items("Apples", "Single", new BigDecimal("0.10"), true);

	private static DiscountService discountService;

	@BeforeClass
	public static void setUp() {
		discountService = new DiscountService();
	}

	@Test
	public void testOfferOne() {
		List<Items> order = Stream.of(soup, soup, soup, milk, bread, bread).collect(Collectors.toList());
		Cart cart = new Cart(order);
		Cart discountCart = discountService.offerOne(cart);
		assertNotNull(discountCart);
		assertEquals(new BigDecimal("4.45"), discountCart.getMrp());

	}

	@Test
	public void testOffertwo() {
		List<Items> order = Stream.of(apples, apples, soup, milk, bread, bread).collect(Collectors.toList());
		Cart cart = new Cart(order);
		Cart discountCart = discountService.offerTwo(cart);
		assertNotNull(discountCart);
		assertEquals(new BigDecimal("3.73"), discountCart.getMrp());
	}

}
