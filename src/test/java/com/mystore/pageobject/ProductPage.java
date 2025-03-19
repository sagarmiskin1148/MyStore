package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
    WebDriver ldriver;

    public ProductPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    // Clickable Dropdown for Size
    @FindBy(xpath = "//div[@id='uniform-group_1']")
    WebElement sizeDropdownClick;

    
    // "M" Size Option Selection
    @FindBy(xpath = "//select[@id='group_1']/option[@value='2']")
    WebElement sizeMOption;

    // Add to Cart Button
    @FindBy(name = "Submit")
    WebElement addToCart;

    // ✅ Proceed to Checkout Button
    @FindBy(xpath = "//a[@title='Proceed to checkout']")
    WebElement proceedToCheckout;
    
    
    
    @FindBy(xpath = "(//a[@title='Printed Summer Dress'][normalize-space()='Printed Summer Dress'])[1]")
    WebElement more;

    // ==================== Methods ==================== //

    // Select "M" Size
    public void selectMSize() {
        sizeDropdownClick.click(); 
        try {
            Thread.sleep(500); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sizeMOption.click(); 
    }

    // Click Add to Cart
    public void clickOnAddToCart() {
        addToCart.click();
    }

    // ✅ New Method: Click Proceed to Checkout
    public void clickOnProceedToCheckout() {
        proceedToCheckout.click();
    }
}
