package com.mystore.pageobject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class indexpage {
    WebDriver driver;

    // Constructor
    public indexpage(WebDriver rdriver) {
        driver = rdriver;
        PageFactory.initElements(driver, this);
    }

    // WebElement for "Sign In"
    @FindBy(xpath = "//a[@class='login']")
    WebElement signInLink;

    // Method to Click on "Sign In"
    public void clickOnSignIn() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(signInLink));

            // Ensure element is displayed
            if (signInLink.isDisplayed()) {
                System.out.println("Sign In link is visible, clicking now...");
                signInLink.click();
            } else {
                System.out.println("Sign In link is not visible!");
            }

        } catch (Exception e) {
            System.out.println("Normal click failed! Trying JavaScript click...");
            try {
                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", signInLink);
            } catch (Exception jsException) {
                System.out.println("JavaScript click also failed!");
                jsException.printStackTrace();
            }
        }
    }
}
