/**
 * File Name: AdactinTC101B.java<br>
 * Alvarez, Jason<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: Jul 1, 2017
 */
package com.sqa.ja.adactin;

import static org.testng.Assert.*;

import org.openqa.selenium.*;
import org.testng.annotations.*;

import com.sqa.ja.auto.*;

/**
 * AdactinTC101B //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Alvarez, Jason
 * @version 1.0.0
 * @since 1.0
 */
public class AdactinTC101B extends BasicTest {

	public AdactinTC101B() {
		super("http://adactin.com/HotelApp");
		this.testingName = "AdactinTC101B";
	}

	@Test
	public void loginTest() {
		String expectedLoginMsg = "Hello d0ntkn0w321!";
		System.out.println("Adactin Login Test Case (TC-101B)");
		AdactinHomePage homePage = new AdactinHomePage(this);
		this.takeScreenshot();
		homePage.login("d0ntkn0w321", "qwertbrz");
		this.takeScreenshot();
		String actualLoginMsg = getDriver().findElement(By.id("username_show")).getText();
		assertEquals(actualLoginMsg, expectedLoginMsg);
	}
}
