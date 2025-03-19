package com.mystore.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SearchResultPage {
    WebDriver ldriver;
    private static final Logger logger = LogManager.getLogger(SearchResultPage.class);

    public SearchResultPage(WebDriver rdriver) {
        ldriver = rdriver;
        PageFactory.initElements(rdriver, this);
    }

    // Locate all product names in search results
    @FindBy(xpath = "//ul[contains(@class,'product_list')]//a[@class='product-name']")
    List<WebElement> searchResults;

    // "More" link for Printed Summer Dress
    @FindBy(xpath = "(//div[@class='product-container']//a[@title='Printed Summer Dress'])[2]")
    WebElement moreLink;

    // Fetch the first search result product name
    public String getSearchResultProductName() {
        try {
            WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(20));
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[contains(@class,'product_list')]//a[@class='product-name']")));

            if (searchResults.isEmpty()) {
                logger.error("No search results found.");
                return "";
            }

            // Log all search results
            for (WebElement product : searchResults) {
                logger.info("Found Product: " + product.getText().trim());
            }

            // Select the first product name
            String productName = searchResults.get(0).getText().trim();
            logger.info("First search result: " + productName);
            return productName;
        } catch (Exception e) {
            logger.error("Error fetching search result product name: " + e.getMessage());
            return "";
        }
    }

    // Click on "More" link for Printed Summer Dress
    public void clickOnMoreLink() {
        try {
            WebDriverWait wait = new WebDriverWait(ldriver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.elementToBeClickable(moreLink)).click();
            logger.info("Clicked on 'More' link for Printed Summer Dress");
        } catch (Exception e) {
            logger.error("Error clicking on 'More' link: " + e.getMessage());
        }
    }
}
