package com.mystore.pageobject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class accountCreationDetails {
	WebDriver ldriver;

	public accountCreationDetails(WebDriver rdriver) {
		this.ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "id_gender2")
	WebElement titlemrs;

	@FindBy(id = "customer_firstname")
	WebElement firstName;

	@FindBy(id = "customer_lastname")
	WebElement lastName;

	@FindBy(id = "passwd")
	WebElement password;

	@FindBy(name = "days")
	WebElement bdate;

	@FindBy(name = "months")
	WebElement bmonth;

	@FindBy(name = "years")
	WebElement byear;

	@FindBy(id = "submitAccount")
	WebElement submitregisterbtn;

	@FindBy(xpath = "//a[@title='Add my first address']")
	WebElement AddMyFirstAddress;

	@FindBy(id = "firstname")
	WebElement addFirstname;

	@FindBy(id = "lastname")
	WebElement addLastname;

	// address1
	@FindBy(id = "address1")
	WebElement address1;

	@FindBy(id = "city")
	WebElement city;

	// id_state
	@FindBy(id = "id_state")
	WebElement state;

	@FindBy(id = "postcode")
	WebElement postcode;

	@FindBy(id = "id_country")
	WebElement country;

	// phone_mobile
	@FindBy(id = "phone_mobile")
	WebElement phone_mobile;

	// alias
	@FindBy(id = "alias")
	WebElement alias;

	// alias
	@FindBy(name = "submitAddress")
	WebElement submitaddress;
	
	// alias
		@FindBy(xpath = "//a[@href='http://www.automationpractice.pl/index.php?controller=my-account']")
		WebElement BackMyAccount;

	
	
	
	
	
	
	// Select Title Mrs.
	public void selectTitleMrs() {
		titlemrs.click();
	}

	// Enter First Name
	public void enterCustomerFirstName(String fname) {
		firstName.sendKeys(fname);
	}

	// Enter Last Name
	public void enterCustomerLastName(String lname) {
		lastName.sendKeys(lname);
	}

	// Enter Password
	public void enterPassword(String psw) {
		password.sendKeys(psw);
	}

	// Select Birth Date
	public void selectBirthDate(String day) {
		new Select(bdate).selectByValue(day);
	}

	// Select Birth Month
	public void selectBirthMonth(String month) {
		new Select(bmonth).selectByValue(month);
	}

	// Select Birth Year
	public void selectBirthYear(String year) {
		new Select(byear).selectByValue(year);
	}

	// Click on Register Button
	public void register() {
		submitregisterbtn.click();
	}

	// Click on Register Button
	public void addmyfirstaddress() {
		AddMyFirstAddress.click();
	}
	
	
	public void enterAddressFirstName(String fname)
	{
		addFirstname.clear();

		addFirstname.sendKeys(fname);
	}
	
	
	
	public void enterAddressLastName(String lname)
	{
		addLastname.clear();

		addLastname.sendKeys(lname);
	}
	
	
	public void enterAddress(String address)
	{
		address1.sendKeys(address);
	}
	
	
	public void enterCity(String cityName)
	{
		city.sendKeys(cityName);
	}
	
	
	public void selectState(String text)
	{
		Select obj = new Select(state);
		obj.selectByVisibleText(text);
	}
	
	
	
	public void enterPostcode(String postcodeData)
	{
		postcode.sendKeys(postcodeData);
	}
	
	
	public void selectCountry(String text)
	{
		Select obj = new Select(country);
		obj.selectByVisibleText(text);
	}
	
	
	
	public void enterMobilePhone(String mobile)
	{
		phone_mobile.sendKeys(mobile);
	}


	
	public void enterAlias(String text)
	{
		alias.clear();
		alias.sendKeys(text);
	}
	
	
	public void clickOnSave()
	{
		submitaddress.click();
	}
	
	
	
	public void clickOnBackAccount()
	{
		BackMyAccount.click();
	}
	
}
