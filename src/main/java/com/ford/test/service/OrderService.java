package com.ford.test.service;

import java.time.LocalDate;
import java.util.List;

import com.ford.test.factory.StockItems;
import com.ford.test.model.Cart;
import com.ford.test.model.Discount;
import com.ford.test.model.Items;
import com.ford.test.utils.DiscountUtils;

public class OrderService {
/**
 * It will Validate the Offer and checks the Cart Items
 * If Soup are present then Soup offer will be applied.
 * If apples are present Apple offer will be applied
 * @param order -> List of Ordered items
 * @param date -> order date
 * @return The cart with/without discount
 */
	public Cart placeOrder(List<Items> order, LocalDate date) {

		DiscountService discount = new DiscountService();
		Discount offer1 = DiscountUtils.getOffer1();
		Discount offer2 = DiscountUtils.getOffer2();
		Cart dicountCart = new Cart();
		Cart cart = new Cart(order);
		if (order.contains(StockItems.bread) && DiscountUtils.validateOffer(offer1, date)) {
			dicountCart = discount.offerOne(cart);
		}
		if (order.contains(StockItems.apples) && DiscountUtils.validateOffer(offer2, date)) {
			if (null != dicountCart.getItems())
				dicountCart = discount.offerTwo(dicountCart);
			else
				dicountCart = discount.offerTwo(cart);

		} else if (dicountCart.getItems()==null) {
			return cart;
		}
		return dicountCart;
	}

}
