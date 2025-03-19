package com.mystore.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class registeredUserAccount {
    WebDriver ldriver;

    public registeredUserAccount(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    // Identify web elements
    @FindBy(xpath = "//a[@title='View my customer account']")
    WebElement userName;

    @FindBy(linkText = "Sign out")
    WebElement signOut;

    @FindBy(name = "search_query")
    WebElement searchBox;

    @FindBy(name = "submit_search")
    WebElement submit_search;

   // @FindBy(linkText = "Women")
    //WebElement WomenMenu;

    @FindBy(linkText = "Dresses")
    WebElement dressesMenu;

    public void clickOnSignOut() {
        signOut.click();
    }

    public String getUserName() {
        return userName.getText();
    }

    public void EnterDataInSearchBox(String searchKey) {
        WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(searchBox));

        searchBox.clear();
        searchBox.sendKeys(searchKey);
    }

    public void ClickOnSearchButton() {
        WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(submit_search)).click();
    }

    public void MouseOverTShirtMenu() {
        WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(10));
        //wait.until(ExpectedConditions.visibilityOf(WomenMenu));
        wait.until(ExpectedConditions.visibilityOf(dressesMenu));

        Actions actions = new Actions(ldriver);
        actions.moveToElement(dressesMenu).moveToElement(dressesMenu).click().perform();
    }
}