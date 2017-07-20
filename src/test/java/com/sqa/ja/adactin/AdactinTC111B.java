/**
 * File Name: AdactinTC111B.java<br>
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
 * AdactinTC109B //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Alvarez, Jason
 * @version 1.0.0
 * @since 1.0
 */
public class AdactinTC111B extends BasicTest {

	public AdactinTC111B() {
		super("http://adactin.com/HotelApp");
		this.testingName = "AdactinTC111B";
	}

	@Test
	public void CompleteRervation() {
		System.out.println("Adactin Select Hotel Page and Book Hotel Page have the same data (TC-111B)");
		AdactinHomePage homePage = new AdactinHomePage(this);
		homePage.login("d0ntkn0w321", "qwertbrz");
		AdactinSearchHotelPage searchPage = new AdactinSearchHotelPage(this);
		searchPage.fillSearchHotelForm("Sydney", "Hotel Creek", "Standard", "2 - Two", 0, 1);
		this.takeScreenshot("TC-111B_Search_Page");
		searchPage.clickOnSearchButton();
		SearchHotelsResultsPage resultsPage = new SearchHotelsResultsPage(this);
		this.takeScreenshot("TC-111B_Result_Page");
		String expectedhotelName = resultsPage.getHotelName().getText();
		String expectedLocation = resultsPage.getLocation().getText();
		String temp = resultsPage.getNumOfDays().getAttribute("value");
		short expectedNumOfDays = Short.valueOf(temp.substring(0, 1));
		String expectedRoomType = resultsPage.getRoomType().getText();
		temp = resultsPage.getPricePerNight().getAttribute("value");
		double expectedPricePerNight = Double.parseDouble(temp.substring(5));
		resultsPage.clickOnFirstRadioButton();
		resultsPage.clickOnContinueButton();
		BookAHotelPage bookHotelPage = new BookAHotelPage(this);
		this.takeScreenshot("TC-111B_Book_Page");
		String actualhotelName = bookHotelPage.getHotelName().getText();
		String actualLocation = bookHotelPage.getLocation().getText();
		temp = bookHotelPage.getTotalDays().getAttribute("value");
		short actualNumOfDays = Short.valueOf(temp.substring(0, 1));
		String actualRoomType = bookHotelPage.getRoomType().getText();
		temp = bookHotelPage.getPricePerNight().getAttribute("value");
		double actualPricePerNight = Double.parseDouble(temp.substring(5));
		assertEquals(actualhotelName, expectedhotelName);
		assertEquals(actualLocation, expectedLocation);
		assertEquals(actualNumOfDays, expectedNumOfDays);
		assertEquals(actualRoomType, expectedRoomType);
		assertEquals(actualPricePerNight, expectedPricePerNight);
	}
}
