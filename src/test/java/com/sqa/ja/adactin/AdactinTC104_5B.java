/**
 * File Name: AdactinTC104B.java<br>
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
 * AdactinTC104B //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Alvarez, Jason
 * @version 1.0.0
 * @since 1.0
 */
public class AdactinTC104_5B extends BasicTest {

	public AdactinTC104_5B() {
		super("http://adactin.com/HotelApp");
		this.testingName = "AdactinTC104B and AdactinTC105B";
	}

	@Test
	public void LocationDisplayed() {
		System.out.println("Adactin Location, Arrival Date, and Departure Date Displayed Test Case (TC-104B, TC-105B)");
		String expectedLocation = "Sydney";
		AdactinHomePage homePage = new AdactinHomePage(this);
		homePage.login("d0ntkn0w321", "qwertbrz");
		AdactinSearchHotelPage searchPage = new AdactinSearchHotelPage(this);
		searchPage.fillSearchHotelForm("Sydney", "Hotel Creek", "Standard", "1 - One", 0, 1);
		String checkinDate = searchPage.addDaysToCurrentDate(0);
		String checkoutDate = searchPage.addDaysToCurrentDate(1);
		this.takeScreenshot("TC-104_5B_Search_Page");
		searchPage.clickOnSearchButton();
		SearchHotelsResultsPage resultsPage = new SearchHotelsResultsPage(this);
		this.takeScreenshot("TC-104_5B_Result_Page");
		String actualLocation = resultsPage.getLocation().getAttribute("value");
		String actualArrivalDate = resultsPage.getArrivalDate().getAttribute("value");
		String actualDepartureDate = resultsPage.getDepartureDate().getAttribute("value");
		assertEquals(actualLocation, expectedLocation);
		assertEquals(actualArrivalDate, checkinDate);
		assertEquals(actualDepartureDate, checkoutDate);
	}
}
