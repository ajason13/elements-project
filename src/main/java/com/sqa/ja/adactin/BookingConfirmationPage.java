/**
 * File Name: BookingConfirmationPage.java<br>
 * Alvarez, Jason<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: Jul 17, 2017
 */
package com.sqa.ja.adactin;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import com.sqa.ja.auto.*;

/**
 * BookingConfirmationPage //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Alvarez, Jason
 * @version 1.0.0
 * @since 1.0
 */
public class BookingConfirmationPage extends BasicPage {

	@FindBy(id = "logout")
	private WebElement logoutButton;

	/**
	 * @param test
	 */
	public BookingConfirmationPage(BasicTest test) {
		super(test);
	}

	public void clickOnLogoutButton() {
		this.logoutButton.click();
	}
}
