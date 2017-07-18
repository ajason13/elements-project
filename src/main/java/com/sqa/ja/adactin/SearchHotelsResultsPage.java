/**
 * File Name: SearchHotelsResultsPage.java<br>
 * Alvarez, Jason<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: Jul 3, 2017
 */
package com.sqa.ja.adactin;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import com.sqa.ja.auto.*;

/**
 * SearchHotelsResultsPage //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Alvarez, Jason
 * @version 1.0.0
 * @since 1.0
 */
public class SearchHotelsResultsPage extends BasicPage {

	@FindBy(id = "location_0")
	private WebElement location;

	@FindBy(id = "arr_date_0")
	private WebElement arrivalDate;

	@FindBy(id = "dep_date_0")
	private WebElement departureDate;

	@FindBy(id = "rooms_0")
	private WebElement rooms;

	@FindBy(id = "room_type_0")
	private WebElement roomType;

	@FindBy(id = "total_price_0")
	private WebElement totalPrice;

	@FindBy(id = "radiobutton_0")
	private WebElement radioButton;

	@FindBy(id = "continue")
	private WebElement continueButton;

	/**
	 * @param test
	 */
	public SearchHotelsResultsPage(BasicTest test) {
		super(test);
	}

	public void clickOnContinueButton() {
		this.continueButton.click();
	}

	public void clickOnFirstRadioButton() {
		this.radioButton.click();
	}

	/**
	 * @return the arrivalDate
	 */
	public WebElement getArrivalDate() {
		return this.arrivalDate;
	}

	/**
	 * @return the continueButton
	 */
	public WebElement getContinueButton() {
		return this.continueButton;
	}

	/**
	 * @return the departureDate
	 */
	public WebElement getDepartureDate() {
		return this.departureDate;
	}

	/**
	 * @return the location0
	 */
	public WebElement getLocation() {
		return this.location;
	}

	/**
	 * @return the radioButton
	 */
	public WebElement getRadioButton() {
		return this.radioButton;
	}

	/**
	 * @return the rooms
	 */
	public WebElement getRooms() {
		return this.rooms;
	}

	/**
	 * @return the roomType
	 */
	public WebElement getRoomType() {
		return this.roomType;
	}

	/**
	 * @return the totalPrice
	 */
	public WebElement getTotalPrice() {
		return this.totalPrice;
	}
}
