/**
 * File Name: AdactinTC102B.java<br>
 * Alvarez, Jason<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: Jul 2, 2017
 */
package com.sqa.ja.adactin;

import static org.testng.Assert.*;

import org.openqa.selenium.*;
import org.testng.annotations.*;

import com.sqa.ja.auto.*;

/**
 * AdactinTC102B //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Alvarez, Jason
 * @version 1.0.0
 * @since 1.0
 */
public class AdactinTC102B extends BasicTest {

	public AdactinTC102B() {
		super("http://adactin.com/HotelApp");
		this.testingName = "AdactinTC102B";
	}

	@Test
	public void CheckinGreaterThanCheckoutTest() {
		System.out.println("Adactin Checkin Date is Greater Than Checkout Date Error Test Case (TC-102B)");
		String expectedCheckInErrorMsg = "Check-In Date shall be before than Check-Out Date";
		String expectedCheckOutErrorMsg = "Check-Out Date shall be after than Check-In Date";
		AdactinHomePage homePage = new AdactinHomePage(this);
		homePage.login("d0ntkn0w321", "qwertbrz");
		AdactinSearchHotelPage searchPage = new AdactinSearchHotelPage(this);
		searchPage.fillSearchHotelForm("Sydney", "Hotel Creek", "Standard", "1 - One", 7, 5);
		searchPage.clickOnSearchButton();
		this.takeScreenshot("TC-102B");
		String actualCheckInErrorMsg;
		String actualCheckOutErrorMsg;
		if (isPresent(By.id("checkin_span"))) {
			actualCheckInErrorMsg = getDriver().findElement(By.id("checkin_span")).getText();
		} else {
			System.out.println("No Checkin Error Message");
			actualCheckInErrorMsg = "N/A";
		}
		if (isPresent(By.id("checkout_span"))) {
			actualCheckOutErrorMsg = getDriver().findElement(By.id("checkout_span")).getText();
		} else {
			System.out.println("No Checkout Error Message");
			actualCheckOutErrorMsg = "N/A";
		}
		assertEquals(actualCheckInErrorMsg, expectedCheckInErrorMsg);
		assertEquals(actualCheckOutErrorMsg, expectedCheckOutErrorMsg);
	}
	// @Test
	// public void sampleTest() {
	// System.out.println("Adactin Test Login (TC-102B)");
	// BasicPage resultsPage = new
	// AdactinHomePage(this).login("user","pass").searchForHotels("data");
	// }
}
