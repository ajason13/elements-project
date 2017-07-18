/**
 * File Name: AdactinTC108B.java<br>
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
 * AdactinTC106B //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Alvarez, Jason
 * @version 1.0.0
 * @since 1.0
 */
public class AdactinTC108B extends BasicTest {

	public AdactinTC108B() {
		super("http://adactin.com/HotelApp");
		this.testingName = "AdactinTC108B";
	}

	@Test
	public void CalcTotalPrice() {
		System.out.println("Adactin Calculate Total Price Test Case (TC-108B)");
		double expectedTotalPrice = 250;
		AdactinHomePage homePage = new AdactinHomePage(this);
		homePage.login("d0ntkn0w321", "qwertbrz");
		AdactinSearchHotelPage searchPage = new AdactinSearchHotelPage(this);
		searchPage.fillSearchHotelForm("Sydney", "Hotel Creek", "Standard", "2 - Two", 0, 1);
		this.takeScreenshot("TC-108B_Search_Page");
		searchPage.clickOnSearchButton();
		SearchHotelsResultsPage resultsPage = new SearchHotelsResultsPage(this);
		this.takeScreenshot("TC-108B_Result_Page");
		String temp = resultsPage.getTotalPrice().getAttribute("value");
		double actualTotalPrice = Double.parseDouble(temp.substring(5));
		assertEquals(expectedTotalPrice, actualTotalPrice);
	}
}
