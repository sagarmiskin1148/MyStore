package com.mystore.pageobject;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class myAccount {

    WebDriver driver;

    // Constructor
    public myAccount(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // WebElements for Login Section
    @FindBy(id = "email")
    WebElement emailAddress;

    @FindBy(id = "passwd")
    WebElement password;

    @FindBy(id = "SubmitLogin")
    WebElement signInButton;

    // WebElements for Create Account Section
    @FindBy(id = "email_create")
    WebElement createEmailAddress;

    @FindBy(id = "SubmitCreate")
    WebElement submitCreateButton;

    // **Method to enter email for account creation**
    public void enterCreateEmailAddress(String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement createEmailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email_create")));
        createEmailField.sendKeys(email);
    }

    // **Method to click "Create an Account" button**
    public void clickSubmitCreate() {
        submitCreateButton.click();
    }

    // **Method to enter login email address**
    public void enterEmailAddress(String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
        emailField.sendKeys(email);
    }

    // **Method to enter password**
    public void enterPassword(String pwd) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("passwd")));
        passwordField.sendKeys(pwd);
    }

    // **Method to click "Sign In" button**
    public void clickSignIn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement signInBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("SubmitLogin")));
        signInBtn.click();
    }
}
