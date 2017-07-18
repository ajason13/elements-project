/**
 * File Name: AdactinTC107B.java<br>
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
public class AdactinTC107B extends BasicTest {

	public AdactinTC107B() {
		super("http://adactin.com/HotelApp");
		this.testingName = "AdactinTC107B";
	}

	@Test
	public void RoomTypeDisplay() {
		System.out.println("Adactin Room Type Displayed Test Case (TC-107B)");
		String expectedRoomType = "Deluxe";
		AdactinHomePage homePage = new AdactinHomePage(this);
		homePage.login("d0ntkn0w321", "qwertbrz");
		AdactinSearchHotelPage searchPage = new AdactinSearchHotelPage(this);
		searchPage.fillSearchHotelForm("Sydney", "Hotel Creek", "Deluxe", "1 - One", 0, 1);
		this.takeScreenshot("TC-107B_Search_Page");
		searchPage.clickOnSearchButton();
		SearchHotelsResultsPage resultsPage = new SearchHotelsResultsPage(this);
		this.takeScreenshot("TC-107B_Result_Page");
		String actualRoomType = resultsPage.getRoomType().getAttribute("value");
		assertEquals(expectedRoomType, actualRoomType);
	}
}
