package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class OrderPaymentPage {
    WebDriver ldriver;
    WebDriverWait wait;

    // Constructor to initialize the driver and WebDriverWait
    public OrderPaymentPage(WebDriver rdriver) {
        ldriver = rdriver;
        wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));  // Updated wait with Duration
        PageFactory.initElements(rdriver, this);  // Initialize the elements
    }

    // Locate Pay by Cheque button
    @FindBy(xpath = "/html/body/div[1]/div[2]/div/div[3]/div/div/div[3]/div[2]/div/p/a")
    WebElement payByCheque;
    
    // Locate Pay by Bank Wire button
    @FindBy(className = "bankwire")
    WebElement payByBankWire;

    // Get current page URL (for validation or verification)
    public String getPageTitle() {
        return (ldriver.getCurrentUrl());
    }

    // Click on "Pay by Bank Wire"
    public void clickOnPayByBankWire() {
        try {
            // Wait until "Pay by Bank Wire" button is clickable
            wait.until(ExpectedConditions.elementToBeClickable(payByBankWire));
            payByBankWire.click();
        } catch (Exception e) {
            System.out.println("Error occurred while clicking on 'Pay by Bank Wire': " + e.getMessage());
        }
    }
}
