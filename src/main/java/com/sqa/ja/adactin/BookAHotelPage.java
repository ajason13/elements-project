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

	@FindBy(id = "hotel_name_dis")
	private WebElement hotelName;

	@FindBy(id = "location_dis")
	private WebElement location;

	@FindBy(id = "room_type_dis")
	private WebElement roomType;

	@FindBy(id = "total_days_dis")
	private WebElement totalDays;

	@FindBy(id = "price_night_dis")
	private WebElement pricePerNight;

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

	@FindBy(id = "final_price_dis")
	private WebElement finalPrice;

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

	/**
	 * @return the addressField
	 */
	public WebElement getAddressField() {
		return this.addressField;
	}

	/**
	 * @return the bookNowButton
	 */
	public WebElement getBookNowButton() {
		return this.bookNowButton;
	}

	/**
	 * @return the creditCardCVVField
	 */
	public WebElement getCreditCardCVVField() {
		return this.creditCardCVVField;
	}

	/**
	 * @return the creditCardExpireMonField
	 */
	public WebElement getCreditCardExpireMonField() {
		return this.creditCardExpireMonField;
	}

	/**
	 * @return the creditCardExpireYearField
	 */
	public WebElement getCreditCardExpireYearField() {
		return this.creditCardExpireYearField;
	}

	/**
	 * @return the creditCardNumField
	 */
	public WebElement getCreditCardNumField() {
		return this.creditCardNumField;
	}

	/**
	 * @return the creditCardTypeField
	 */
	public WebElement getCreditCardTypeField() {
		return this.creditCardTypeField;
	}

	/**
	 * @return the finalPrice
	 */
	public WebElement getFinalPrice() {
		return this.finalPrice;
	}

	/**
	 * @return the firstNameField
	 */
	public WebElement getFirstNameField() {
		return this.firstNameField;
	}

	/**
	 * @return the hotelName
	 */
	public WebElement getHotelName() {
		return this.hotelName;
	}

	/**
	 * @return the lastNameField
	 */
	public WebElement getLastNameField() {
		return this.lastNameField;
	}

	/**
	 * @return the location
	 */
	public WebElement getLocation() {
		return this.location;
	}

	/**
	 * @return the pricePerNight
	 */
	public WebElement getPricePerNight() {
		return this.pricePerNight;
	}

	/**
	 * @return the roomType
	 */
	public WebElement getRoomType() {
		return this.roomType;
	}

	/**
	 * @return the totalDays
	 */
	public WebElement getTotalDays() {
		return this.totalDays;
	}
}
