/**
 * File Name: AdactinSearchHotelPage.java<br>
 * Alvarez, Jason<br>
 * Java Boot Camp Exercise<br>
 * Instructor: Jean-francois Nepton<br>
 * Created: Jul 3, 2017
 */
package com.sqa.ja.adactin;

import java.time.*;
import java.time.format.*;
import java.util.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

import com.sqa.ja.auto.*;

/**
 * AdactinSearchHotelPage //ADDD (description of class)
 * <p>
 * //ADDD (description of core fields)
 * <p>
 * //ADDD (description of core methods)
 *
 * @author Alvarez, Jason
 * @version 1.0.0
 * @since 1.0
 */
public class AdactinSearchHotelPage extends BasicPage {

	@FindBy(id = "location")
	private WebElement locationField;

	@FindBy(id = "hotels")
	private WebElement hotelField;

	@FindBy(id = "room_type")
	private WebElement roomTypeField;

	@FindBy(id = "room_nos")
	private WebElement numOfRoomsField;

	@FindBy(id = "datepick_in")
	private WebElement checkinDateField;

	@FindBy(id = "datepick_out")
	private WebElement checkoutDateField;

	@FindBy(id = "Submit")
	private WebElement submitButton;

	private Date input;

	private LocalDate date;

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	/**
	 * @param test
	 */
	public AdactinSearchHotelPage(BasicTest test) {
		super(test);
	}

	public String addDaysToCurrentDate(int days) {
		String temp = this.date.plusDays(days).format(this.formatter);
		return temp;
	}

	public void checkForDateErrorMsg() {
		// TODO code in checking for Checkin/Checkout error msg cuz don't want
		// getDriver()...... in test cases
	}

	public void clickOnSearchButton() {
		this.submitButton.click();
	}

	public void fillSearchHotelForm(String location, String hotel, String roomType, String roomNums, int checkinDay,
			int checkoutDay) {
		selectDropDown(this.locationField, location);
		selectDropDown(this.hotelField, hotel);
		selectDropDown(this.roomTypeField, roomType);
		selectDropDown(this.numOfRoomsField, roomNums);
		this.input = new Date();
		this.date = this.input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		String tempCheckIn = addDaysToCurrentDate(checkinDay);
		String tempCheckOut = addDaysToCurrentDate(checkoutDay);
		setDate(tempCheckIn, tempCheckOut);
	}

	/**
	 * @return the checkinDateField
	 */
	public WebElement getCheckinDateField() {
		return this.checkinDateField;
	}

	/**
	 * @return the checkoutDateField
	 */
	public WebElement getCheckoutDateField() {
		return this.checkoutDateField;
	}

	/**
	 * @return the date
	 */
	public LocalDate getDate() {
		return this.date;
	}

	/**
	 * @return the formatter
	 */
	public DateTimeFormatter getFormatter() {
		return this.formatter;
	}

	/**
	 * @return the hotelField
	 */
	public WebElement getHotelField() {
		return this.hotelField;
	}

	/**
	 * @return the input
	 */
	public Date getInput() {
		return this.input;
	}

	/**
	 * @return the locationField
	 */
	public WebElement getLocationField() {
		return this.locationField;
	}

	/**
	 * @return the numOfRoomsField
	 */
	public WebElement getNumOfRoomsField() {
		return this.numOfRoomsField;
	}

	/**
	 * @return the roomTypeField
	 */
	public WebElement getRoomTypeField() {
		return this.roomTypeField;
	}

	/**
	 * @return the submitButton
	 */
	public WebElement getSubmitButton() {
		return this.submitButton;
	}

	// public SearchHotelsResultsPage searchForHotels(String... data) {
	// fillSearchHotelForm();
	// clickOnSearchButton();
	// return new SearchHotelsResultsPage(this.getRelTest());
	// }
	public void setDate(String checkinDate, String checkoutDate) {
		this.checkinDateField.clear();
		this.checkinDateField.sendKeys(checkinDate);
		this.checkoutDateField.clear();
		this.checkoutDateField.sendKeys(checkoutDate);
	}
}
