package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage {
    WebDriver ldriver;

    // Constructor to initialize the driver
    public OrderConfirmationPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);  // Initialize elements using driver
    }

    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div/form/p/button/span")
    WebElement confirmOrder;  // Confirm order button

    @FindBy(xpath = "//div[@id='center_column']/p[@class='alert alert-success']")
    WebElement successAlert;  // Success message alert

    @FindBy(linkText = "Sign out")
    WebElement signOut;  // Sign out link

    // Method to click on Sign out
    public void clickOnSignOut() {
        signOut.click();
    }

    // Method to click on Confirm Order button
    public void clickOnConfirmOrder() {
        confirmOrder.click();
    }

    // Method to get the success message after order completion
    public String getOrderSuccessMessage() {
        return successAlert.getText();  // Return the success message text
    }
}
