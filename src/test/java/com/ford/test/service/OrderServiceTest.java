package com.ford.test.service;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.BeforeClass;
import org.junit.Test;

import com.ford.test.factory.StockItems;
import com.ford.test.model.Cart;
import com.ford.test.model.Items;

public class OrderServiceTest {

	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	private static LocalDate today = LocalDate.parse("03-07-2019", formatter);
	private static LocalDate nextMonth = LocalDate.parse("03-08-2019", formatter);

	private static OrderService orderService;
	private static List<Items> appleOrder;
	private static List<Items> breadOrder;

	@BeforeClass
	public static void setUp() {
		orderService = new OrderService();
		appleOrder = Stream
				.of(StockItems.apples, StockItems.apples, StockItems.apples, StockItems.milk, StockItems.bread)
				.collect(Collectors.toList());
		breadOrder = Stream.of(StockItems.soup, StockItems.soup, StockItems.soup, StockItems.soup, StockItems.bread,
				StockItems.bread, StockItems.bread).collect(Collectors.toList());

	}

	@Test
	public void testPlaceOrder() {
		Cart cart = orderService.placeOrder(appleOrder, today);
		assertEquals(new BigDecimal("2.40"), cart.getMrp());
		Cart cart1 = orderService.placeOrder(breadOrder, nextMonth);
		assertNotEquals(new BigDecimal("4.2"), cart1.getMrp());

	}

}
