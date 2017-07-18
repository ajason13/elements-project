/**
 * File Name: BookAHotelPage.java<br>
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
 * BookAHotelPage //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Alvarez, Jason
 * @version 1.0.0
 * @since 1.0
 */
public class BookAHotelPage extends BasicPage {

	@FindBy(id = "first_name")
	private WebElement firstNameField;

	@FindBy(id = "last_name")
	private WebElement lastNameField;

	@FindBy(id = "address")
	private WebElement addressField;

	@FindBy(id = "cc_num")
	private WebElement creditCardNumField;

	@FindBy(id = "cc_type")
	private WebElement creditCardTypeField;

	@FindBy(id = "cc_exp_month")
	private WebElement creditCardExpireMonField;

	@FindBy(id = "cc_exp_year")
	private WebElement creditCardExpireYearField;

	@FindBy(id = "cc_cvv")
	private WebElement creditCardCVVField;

	@FindBy(id = "book_now")
	private WebElement bookNowButton;

	/**
	 * @param test
	 */
	public BookAHotelPage(BasicTest test) {
		super(test);
	}

	/**
	 *
	 */
	public void clickOnBookNowButton() {
		this.bookNowButton.click();
	}

	public void fillBillingForm(String firstName, String lastName, String billingAddress, String creditCardNum,
			String creditCardType, String expireMonth, String expireYear, String cvvNum) {
		this.firstNameField.sendKeys(firstName);
		this.lastNameField.sendKeys(lastName);
		this.addressField.sendKeys(billingAddress);
		this.creditCardNumField.sendKeys(creditCardNum);
		selectDropDown(this.creditCardTypeField, creditCardType);
		selectDropDown(this.creditCardExpireMonField, expireMonth);
		selectDropDown(this.creditCardExpireYearField, expireYear);
		this.creditCardCVVField.sendKeys(cvvNum);
	}
}
