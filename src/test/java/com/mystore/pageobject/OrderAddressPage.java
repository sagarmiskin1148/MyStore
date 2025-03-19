package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderAddressPage {
    WebDriver ldriver;

    public OrderAddressPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(name = "processAddress")
    WebElement proceedFromAddressPage;

    public void clickOnProceedToCheckout() {
        proceedFromAddressPage.click();
    }
}
