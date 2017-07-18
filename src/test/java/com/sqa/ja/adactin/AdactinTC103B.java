/**
 * File Name: AdactinTC103B.java<br>
 * Alvarez, Jason<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: Jul 15, 2017
 */
package com.sqa.ja.adactin;

import static org.testng.Assert.*;

import org.openqa.selenium.*;
import org.testng.annotations.*;

import com.sqa.ja.auto.*;

/**
 * AdactinTC103B //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Alvarez, Jason
 * @version 1.0.0
 * @since 1.0
 */
public class AdactinTC103B extends BasicTest {

	public AdactinTC103B() {
		super("http://adactin.com/HotelAppBuild2/");
		this.testingName = "AdactinTC103B";
	}

	@Test
	public void CheckoutDateInPast() {
		System.out.println("Adactin Checkout Date in the Pass Error Test Case (TC-103B)");
		String expectedCheckOutErrorMsg = "Check-In Date should be either Today or Later Date";
		String actualCheckOutErrorMsg = "";
		AdactinHomePage homePage = new AdactinHomePage(this);
		homePage.login("d0ntkn0w321", "qwertbrz");
		AdactinSearchHotelPage searchPage = new AdactinSearchHotelPage(this);
		searchPage.fillSearchHotelForm("Sydney", "Hotel Creek", "Standard", "1 - One", -5, -3);
		searchPage.clickOnSearchButton();
		this.takeScreenshot("TC-103B");
		if (isPresent(By.id("checkin_span"))) {
			actualCheckOutErrorMsg = getDriver().findElement(By.id("checkin_span")).getText();
		}
		assertEquals(actualCheckOutErrorMsg, expectedCheckOutErrorMsg);
	}
}
