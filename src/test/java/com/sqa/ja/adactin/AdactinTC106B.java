/**
 * File Name: AdactinTC106B.java<br>
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
public class AdactinTC106B extends BasicTest {

	public AdactinTC106B() {
		super("http://adactin.com/HotelApp");
		this.testingName = "AdactinTC106B";
	}

	@Test
	public void NumberOfRoomsDisplay() {
		System.out.println("Adactin Number of Rooms Displayed Test Case (TC-106B)");
		String expectedRoomNum = "3 Rooms";
		AdactinHomePage homePage = new AdactinHomePage(this);
		homePage.login("d0ntkn0w321", "qwertbrz");
		AdactinSearchHotelPage searchPage = new AdactinSearchHotelPage(this);
		searchPage.fillSearchHotelForm("Sydney", "Hotel Creek", "Standard", "3 - Three", 0, 1);
		this.takeScreenshot("TC-106B_Search_Page");
		searchPage.clickOnSearchButton();
		SearchHotelsResultsPage resultsPage = new SearchHotelsResultsPage(this);
		this.takeScreenshot("TC-106B_Result_Page");
		String actualRoomNum = resultsPage.getRooms().getAttribute("value");
		assertEquals(expectedRoomNum, actualRoomNum);
	}
}
