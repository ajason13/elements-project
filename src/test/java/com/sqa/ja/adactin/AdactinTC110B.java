/**
 * File Name: AdactinTC110B.java<br>
 * Alvarez, Jason<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: Jul 16, 2017
 */
package com.sqa.ja.adactin;

import static org.testng.Assert.*;

import org.testng.annotations.*;

import com.sqa.ja.auto.*;

/**
 * AdactinTC110B //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Alvarez, Jason
 * @version 1.0.0
 * @since 1.0
 */
public class AdactinTC110B extends BasicTest {

	public AdactinTC110B() {
		super("http://adactin.com/HotelAppBuild2/");
		this.testingName = "AdactinTC110B";
	}

	@Test
	public void CorrectTotalPrice() {
		System.out.println("Adactin Correct Total Price (TC-110B)");
		double expectedTotalPrice = 250;
		AdactinHomePage homePage = new AdactinHomePage(this);
		homePage.login("d0ntkn0w321", "qwertbrz");
		AdactinSearchHotelPage searchPage = new AdactinSearchHotelPage(this);
		searchPage.fillSearchHotelForm("Melbourne", "Hotel Creek", "Standard", "2 - Two", 0, 1);
		this.takeScreenshot("TC-110B_Search_Page");
		searchPage.clickOnSearchButton();
		SearchHotelsResultsPage resultsPage = new SearchHotelsResultsPage(this);
		this.takeScreenshot("TC-110B_Result_Page");
		resultsPage.clickOnFirstRadioButton();
		resultsPage.clickOnContinueButton();
		BookAHotelPage bookHotelPage = new BookAHotelPage(this);
		this.takeScreenshot("TC-110B_Billing_Page");
		String temp = bookHotelPage.getFinalPrice().getAttribute("value");
		double actualTotalPrice = Double.parseDouble(temp.substring(5));
		assertEquals(expectedTotalPrice, actualTotalPrice);
	}
}
