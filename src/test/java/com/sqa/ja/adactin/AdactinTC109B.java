/**
 * File Name: AdactinTC109B.java<br>
 * Alvarez, Jason<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: Jul 16, 2017
 */
package com.sqa.ja.adactin;

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
public class AdactinTC109B extends BasicTest {

	public AdactinTC109B() {
		super("http://adactin.com/HotelApp");
		this.testingName = "AdactinTC109B";
	}

	@Test
	public void CompleteRervation() {
		System.out.println("Adactin Successful Transaction (TC-104B)");
		AdactinHomePage homePage = new AdactinHomePage(this);
		homePage.login("d0ntkn0w321", "qwertbrz");
		AdactinSearchHotelPage searchPage = new AdactinSearchHotelPage(this);
		searchPage.fillSearchHotelForm("Sydney", "Hotel Creek", "Standard", "2 - Two", 0, 1);
		this.takeScreenshot("TC-109B_Search_Page");
		searchPage.clickOnSearchButton();
		SearchHotelsResultsPage resultsPage = new SearchHotelsResultsPage(this);
		this.takeScreenshot("TC-109B_Result_Page");
		resultsPage.clickOnFirstRadioButton();
		resultsPage.clickOnContinueButton();
		BookAHotelPage bookHotelPage = new BookAHotelPage(this);
		bookHotelPage.fillBillingForm("John", "Doe", "123 Fake Street", "1234567891012131", "VISA", "January", "2018",
				"111");
		this.takeScreenshot("TC-109B_Billing_Page");
		bookHotelPage.clickOnBookNowButton();
		BookingConfirmationPage confirmationPage = new BookingConfirmationPage(this);
		this.takeScreenshot("TC-109B_Confirmation_Page");
		confirmationPage.clickOnLogoutButton();
		this.takeScreenshot("TC-109B_Logout_Page");
	}
}
