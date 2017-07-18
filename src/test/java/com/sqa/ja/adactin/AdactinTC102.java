/**
 * File Name: AdactinTC102.java<br>
 * Alvarez, Jason<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: Jul 2, 2017
 */
package com.sqa.ja.adactin;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.*;
import org.testng.annotations.*;

/**
 * AdactinTC102 //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Alvarez, Jason
 * @version 1.0.0
 * @since 1.0
 */
public class AdactinTC102 extends AdactinTest {

	@Test
	void doTest() {
		System.out.println("Adactin Test Login (TC-102)");
		String expectCheckInErrorMsg = "Check-In Date shall be before than Check-Out Date";
		String expectCheckOutErrorMsg = "Check-Out Date shall be after than Check-In Date";
		String checkInDate = addDaysToCurrentDate(7);
		String checkOutDate = addDaysToCurrentDate(5);
		Select locationDropDown = new Select(getDriver().findElement(By.id("location")));
		locationDropDown.selectByVisibleText(getLocation());
		Select hotelsDropDown = new Select(getDriver().findElement(By.id("hotels")));
		hotelsDropDown.selectByVisibleText(getHotel());
		Select roomTypeDropDown = new Select(getDriver().findElement(By.id("room_type")));
		roomTypeDropDown.selectByVisibleText(getRoomType());
		Select numOfRoomsDropDown = new Select(getDriver().findElement(By.id("room_nos")));
		numOfRoomsDropDown.selectByVisibleText(getNumOfRooms());
		WebElement checkInDateField = getDriver().findElement(By.id("datepick_in"));
		checkInDateField.clear();
		checkInDateField.sendKeys(checkInDate);
		WebElement checkOutDateField = getDriver().findElement(By.id("datepick_out"));
		checkOutDateField.clear();
		checkOutDateField.sendKeys(checkOutDate);
		WebElement submitButton = getDriver().findElement(By.id("Submit"));
		submitButton.click();
		this.takeScreenshot("AdactinTC102");
		if (this.isPresent(By.id("checkin_span"))) {
			String actualCheckInErrorMsg = getDriver().findElement(By.id("checkin_span")).getText();
			Assert.assertEquals(actualCheckInErrorMsg, expectCheckInErrorMsg);
		}
		if (this.isPresent(By.id("checkout_span"))) {
			String actualCheckOutErrorMsg = getDriver().findElement(By.id("checkout_span")).getText();
			Assert.assertEquals(actualCheckOutErrorMsg, expectCheckOutErrorMsg);
		}
	}
}
