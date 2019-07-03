package com.ford.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import com.ford.test.factory.StockItems;
import com.ford.test.model.Cart;
import com.ford.test.model.Items;
import com.ford.test.service.OrderService;

/**
 * 
 * @author DIBYA
 *
 */

public class HeneryStoreTest {
	/**
	 * 
	 * @param item --> Input Item from Command prompt
	 * @param count --> Count of the Item
	 * @return List of Items to be added in Cart
	 */
	public static List<Items> generateCart(Items item, String count) {
		List<Items> cartList = new ArrayList<>();
		for (int i = 0; i < Integer.parseInt(count); i++) {
			cartList.add(item);
		}
		return cartList;
	}

	public static void main(String[] args) {
		// Taking Today's Date as Order Date, Below commented snippet can be used for
		// manual order Date
		LocalDate today = LocalDate.now();
//		 DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//		 LocalDate today = LocalDate.parse("08-07-2019", formatter);
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please select the Quantity of Items:[minimum Zero] ");
		System.out.print("[Apples]: ");
		String applesCount = scanner.next();
		List<Items> appleList = generateCart(StockItems.apples, applesCount);
		System.out.print("[Milk]: ");
		String milkCount = scanner.next();
		List<Items> milkList = generateCart(StockItems.milk, milkCount);
		System.out.print("[Bread]: ");
		String breadCount = scanner.next();
		List<Items> breadList = generateCart(StockItems.bread, breadCount);
		System.out.print("[Soup]: ");
		String soupCount = scanner.next();
		List<Items> soupList = generateCart(StockItems.soup, soupCount);
		System.out.println("Tnank You for Shopping with us! ");

		List<Items> order = new ArrayList<>();
		Stream.of(appleList, milkList, breadList, soupList).forEach(order::addAll);
		OrderService orderService = new OrderService();
		Cart cart = orderService.placeOrder(order, today);
		System.out.println(cart);
		System.out.println("Amount Payable: " + cart.getMrp());

	}

}