package com.mystore.testcases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mystore.pageobject.OrderAddressPage;
import com.mystore.pageobject.OrderConfirmationPage;
import com.mystore.pageobject.OrderPaymentPage;
import com.mystore.pageobject.OrderShippingPage;
import com.mystore.pageobject.OrderSummaryPage;
import com.mystore.pageobject.ProductPage;
import com.mystore.pageobject.SearchResultPage;
import com.mystore.pageobject.indexpage;
import com.mystore.pageobject.myAccount;
import com.mystore.pageobject.registeredUserAccount;

public class TC_ProductPageTest extends BaseClass {

	@Test
	public void VerifySearchProduct() throws IOException {
	    String searchKey = "Dresses";
	    logger.info("\n*************** Test Case: Search Product Started *****************");

	    indexpage indexPg = new indexpage(driver);
	    indexPg.clickOnSignIn();

	    myAccount pg = new myAccount(driver);
	    pg.enterEmailAddress(emailAddress);
	    logger.info("User Email and Password entered.");
	    pg.enterPassword(password);
	    pg.clickSignIn();
	    logger.info("Sign In link clicked");

	    registeredUserAccount productPg = new registeredUserAccount(driver);
	    productPg.EnterDataInSearchBox(searchKey);
	    logger.info("Entered search key: " + searchKey);
	    
	    productPg.ClickOnSearchButton();
	    logger.info("Clicked on search button");

	    SearchResultPage resultPg = new SearchResultPage(driver);
	    String searchResultProductName = resultPg.getSearchResultProductName();

	    // Log the search result for debugging
	    logger.info("Actual Search Result: " + searchResultProductName);

	    // FIXED: Check for any matching product name
	    if (!searchResultProductName.isEmpty() && (searchResultProductName.toLowerCase().contains("dress") || searchResultProductName.toLowerCase().contains(searchKey.toLowerCase()))) {
	        logger.info("Search Product TestCase - Passed");
	        Assert.assertTrue(true);
	    } else {
	        logger.info("Search Product TestCase - Failed");
	        captureScreenShot(driver, "VerifySearchProduct");
	        Assert.fail("Search Result did not contain expected product: " + searchKey + ". Actual Result: " + searchResultProductName);
	    }

	    productPg.clickOnSignOut();
	    logger.info("*************** Test Case: Search Product Ends *****************");
	}

    
    @Test
    public void VerifyBuyProduct() throws IOException {
        logger.info("\n***************TestCase Buy Product started*****************");

        indexpage indexPg = new indexpage(driver);
        indexPg.clickOnSignIn();

        myAccount pg = new myAccount(driver);
        pg.enterEmailAddress(emailAddress);
        pg.enterPassword(password);
        pg.clickSignIn();
        logger.info("Sign In link clicked");
        

        registeredUserAccount prodCatPg = new registeredUserAccount(driver);
        prodCatPg.EnterDataInSearchBox("Dresses");
        logger.info("Dresses entered in search box");
        
        prodCatPg.ClickOnSearchButton();
        logger.info("clicked on  search button");

        SearchResultPage searchResultPg = new SearchResultPage(driver);
        searchResultPg.clickOnMoreLink();
        logger.info("Clicked on more button");
        
        

        ProductPage prodPg = new ProductPage(driver);
        
        prodPg.selectMSize(); 
        logger.info("size M entered");
        
        prodPg.clickOnAddToCart();
        logger.info("Clicked on add to cart");
        
        prodPg.clickOnProceedToCheckout();
        logger.info("Clicked on proceed to checkout on product page");


        OrderSummaryPage orderSumPg = new OrderSummaryPage(driver);
        orderSumPg.cickOnProceedToCheckout();

        OrderAddressPage orderAddPg = new OrderAddressPage(driver);
        orderAddPg.clickOnProceedToCheckout();

        OrderShippingPage orderShippingPg = new OrderShippingPage(driver);
        orderShippingPg.selectTermsOfServices();
        orderShippingPg.clickOnProceedToCheckout();

        // Click on "Pay by Bank Wire"
        OrderPaymentPage orderPaymentPg = new OrderPaymentPage(driver);
        orderPaymentPg.clickOnPayByBankWire(); // Updated to select Bank Wire payment

        // Wait for the redirection to the payment confirmation page
        OrderConfirmationPage orderConfirmPg = new OrderConfirmationPage(driver);
        orderConfirmPg.clickOnConfirmOrder(); // Confirm order on the bank wire payment page

        // Get the success message and log it for debugging
        String successMsg = orderConfirmPg.getOrderSuccessMessage();
        logger.info("Success message: " + successMsg);  // Log the message to check

        // Check if the success message matches the expected text
        Assert.assertEquals(successMsg, "Your order on My Shop is complete.", "Order confirmation message mismatch");

        logger.info("VerifyBuyProduct - Passed");
        orderConfirmPg.clickOnSignOut();

        logger.info("***************TestCase BuyProduct ends*****************");
    }






}
