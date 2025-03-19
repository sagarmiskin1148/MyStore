package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderShippingPage {
    WebDriver ldriver;

    public OrderShippingPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    @FindBy(id = "cgv")
    WebElement termsOfServiceCheckbox;

    @FindBy(name = "processCarrier")
    WebElement proceedToCheckoutButton;

    public void selectTermsOfServices() {
        if (!termsOfServiceCheckbox.isSelected()) {
            termsOfServiceCheckbox.click();
        }
    }

    public void clickOnProceedToCheckout() {
        proceedToCheckoutButton.click();
    }
}
