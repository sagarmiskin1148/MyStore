package com.mystore.testcases;

import java.io.IOException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.mystore.pageobject.indexpage;
import com.mystore.pageobject.myAccount;
import com.mystore.pageobject.registeredUserAccount;

public class TC_MyAccountPageTest extends BaseClass {
    private static final Logger logger = LogManager.getLogger(TC_MyAccountPageTest.class);

    @Test
    public void VerifyLogin() throws IOException {
        logger.info("*************** TestCase Verify Login starts *****************");

        // ✅ Perform Login
        indexpage index = new indexpage(driver);
        index.clickOnSignIn();

        myAccount account = new myAccount(driver);
        account.enterEmailAddress(emailAddress);
        account.enterPassword(password);
        account.clickSignIn();

        // ✅ Verify Login
        registeredUserAccount regUser = new registeredUserAccount(driver);
        String userName = regUser.getUserName();
        Assert.assertEquals(userName, "Sagar Miskin", "Login failed!");

        logger.info("VerifyLogin - Passed");
        logger.info("*************** TestCase Verify Login ends *****************");
    }

    @Test
    public void VerifySignOut() throws IOException {
        logger.info("*************** TestCase Verify Sign Out starts *****************");

        // ✅ Perform Login before Sign Out
        indexpage index = new indexpage(driver);
        index.clickOnSignIn();

        myAccount account = new myAccount(driver);
        account.enterEmailAddress(emailAddress);
        account.enterPassword(password);
        account.clickSignIn();

        // ✅ Perform Sign Out
        registeredUserAccount regUser = new registeredUserAccount(driver);
        regUser.clickOnSignOut();

        // ✅ Verify Sign Out
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("Login"), "Sign Out failed! Expected title containing 'Login', but got: " + actualTitle);

        logger.info("VerifySignOut - Passed");
        logger.info("*************** TestCase Verify Sign Out ends *****************");
    }
}
