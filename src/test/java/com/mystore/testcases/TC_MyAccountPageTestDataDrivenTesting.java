package com.mystore.testcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mystore.pageobject.accountCreationDetails;
import com.mystore.pageobject.indexpage;
import com.mystore.pageobject.myAccount;
import com.mystore.pageobject.registeredUserAccount;
import com.mystore.utilities.ReadExcelFile;



public class TC_MyAccountPageTestDataDrivenTesting extends BaseClass {

    private static final Logger logger = LogManager.getLogger(TC_MyAccountPageTestDataDrivenTesting.class);

    @Test(enabled=false)
    public void verifyRegistrationAndLogin() {
    	
       

        indexpage pg = new indexpage(driver);
        pg.clickOnSignIn();
        logger.info("Clicked on Sign In link");

        myAccount myAcpg = new myAccount(driver);
        myAcpg.enterCreateEmailAddress("rajesh10065@gmail.com");
        logger.info("Entered email address in create account section");

        myAcpg.clickSubmitCreate();
        logger.info("Clicked on 'Create an Account' button");
        
        
        
        accountCreationDetails accCreationpg=new accountCreationDetails(driver);
        
        accCreationpg.selectTitleMrs();
        accCreationpg.enterCustomerFirstName("Sagar");
        accCreationpg.enterCustomerLastName("Miskin");
        accCreationpg.enterPassword("paswo"); 
        accCreationpg.selectBirthDate("6");
        accCreationpg.selectBirthMonth("11");
        accCreationpg.selectBirthYear("1995");
        
        logger.info("entered user details on account creation page");

        
        accCreationpg.register();
        logger.info("click on register button");

        
        
        
        registeredUserAccount regUser=new registeredUserAccount(driver);
        String userName=regUser.getUserName();
        
        Assert.assertEquals("Sagar Miskin", userName);
        
        
        
        
        
        accCreationpg.addmyfirstaddress();
        logger.info("click on ADD MY FIRST ADDRESS");
        
        
        accCreationpg.enterAddressFirstName("Sagar");
        accCreationpg.enterAddressLastName("Miskin");
        accCreationpg.enterAddress("Pune maharashtra 18/8");
        accCreationpg.enterCity("pune");
        accCreationpg.selectState("Alabama");
        
        accCreationpg.enterPostcode("00000");
        accCreationpg.selectCountry("United States");
        accCreationpg.enterMobilePhone("9891778192");
		accCreationpg.enterAlias("Home");
        
		
		accCreationpg.clickOnSave();
		 logger.info("click on ADD MY FIRST ADDRESS SAVE Button");
		 
		 
		 accCreationpg.clickOnBackAccount();
		 
	        
    }
    
    @Test(dataProvider="LoginDataProvider")
	public void VerifyLogin(String userEmail, String userPwd, String expectedUsername) throws IOException 
	{

		logger.info("***************TestCase Verify Login starts*****************"); 

		 indexpage  pg = new  indexpage (driver);

		pg.clickOnSignIn();
		logger.info("Clicked on sign in link");

		myAccount myAcpg = new myAccount(driver);

		myAcpg.enterEmailAddress(userEmail);
		logger.info("Entered email address");

		myAcpg.enterPassword(userPwd);
		logger.info("Entered password");

		myAcpg.clickSignIn();
		logger.info("Clicked on sign in link..");

		
		
		registeredUserAccount regUser = new registeredUserAccount(driver);
		String userName = regUser.getUserName();


		if(userName.equals(expectedUsername))
		{
			logger.info("VerifyLogin - Passed");
			regUser.clickOnSignOut();
			Assert.assertTrue(true);
		}
		else
		{
			logger.info("VerifyLogin - Failed");
			captureScreenShot(driver,"VerifyLogin");
			Assert.assertTrue(false);

		}


	}
    
    
    @DataProvider(name = "LoginDataProvider")
	public String[][] LoginDataProvider()
	{
		//System.out.println(System.getProperty("user.dir"));
		String fileName = System.getProperty("user.dir") + "\\TestData\\MyStoreTestData.xlsx";


		int ttlRows = ReadExcelFile.getRowCount(fileName, "LoginTestData");
		int ttlColumns = ReadExcelFile.getColCount(fileName, "LoginTestData");
	

		String data[][]=new String[ttlRows-1][ttlColumns];

		for(int i=1;i<ttlRows;i++)//rows =1,2
		{
			for(int j=0;j<ttlColumns;j++)//col=0, 1,2
			{

				data[i-1][j]=ReadExcelFile.getCellValue(fileName,"LoginTestData", i,j);
			}

		}
		return data;
	}

    
}
