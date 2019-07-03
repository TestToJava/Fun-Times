package com.ford.test.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;

import com.ford.test.model.Discount;

/**
 * This Util class holds the Discounts and can Validate the Discount offers by
 * checking the Validity by Date.
 * The Date here mentioned as Today's Date is the Development Time
 * As the Requirement doesn't takes Date as input from Command prompt.
 * @author DIBYA
 *
 */
public class DiscountUtils {
	private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	private static LocalDate today = LocalDate.parse("03-07-2019", formatter);

	public static Discount getOffer1() {

		Discount discount1 = new Discount("Buy 2 tins of soup and get a loaf of bread half price", today.minusDays(1),
				today.plusDays(5));
		System.out.println("Offer 1: " + discount1.getOffer() + "   (Starts on: " + discount1.getValidFrom() + ")"
				+ "   (Expires on: " + discount1.getValidTo() + ")");
		return discount1;
	}

	public static Discount getOffer2() {
		Discount discount2 = new Discount("Apples have a 10% discount", today.plusDays(3),
				today.with(TemporalAdjusters.firstDayOfNextMonth()).minusDays(1));
		System.out.println("Offer 2: " + discount2.getOffer() + "   (Starts on: " + discount2.getValidFrom() + ")"
				+ "   (Expires on: " + discount2.getValidTo() + ")");
		return discount2;
	}

	public static boolean validateOffer(Discount discount, LocalDate date) {
		if (date.compareTo(discount.getValidFrom()) >= 0 && date.compareTo(discount.getValidTo()) <= 0) {
			return true;
		}
		return false;

	}

}
