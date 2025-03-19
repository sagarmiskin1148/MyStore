package com.mystore.testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import java.lang.System;
import com.mystore.utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
    ReadConfig readConfig = new ReadConfig();

    String url = readConfig.getBaseUrl();
    String browser = readConfig.getBrowser();
    public String emailAddress = readConfig.getEmail();
    public String password = readConfig.getPassword();

    public static WebDriver driver;
    public static Logger logger = LogManager.getLogger(BaseClass.class);

    @BeforeMethod
    public void setup(ITestContext context) { 
        logger.info("Initializing Browser: " + browser);

        switch (browser.toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--remote-debugging-port=0");
                options.addArguments("--disable-extensions");
                options.addArguments("--start-maximized");
                driver = new ChromeDriver(options);
                logger.info("Chrome Browser Launched Successfully");
                break;

            case "msedge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                logger.info("Edge Browser Launched Successfully");
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                logger.info("Firefox Browser Launched Successfully");
                break;

            default:
                logger.error("Invalid browser specified: " + browser);
                throw new IllegalArgumentException("Unsupported browser: " + browser);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(url);
        logger.info("Navigated to: " + url);

        context.setAttribute("WebDriver", driver); // ✅ Store WebDriver in test context
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            logger.info("Closing Browser");
            driver.quit();
            logger.info("Browser Closed Successfully");
        }
    }

    // ✅ Method to capture a screenshot
    public void captureScreenShot(WebDriver driver, String testName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File destination = new File(System.getProperty("user.dir") + "/Screenshots/" + testName + ".png");

        try {
            FileUtils.copyFile(source, destination);
            logger.info("Screenshot saved: " + destination.getAbsolutePath());
        } catch (IOException e) {
            logger.error("Failed to capture screenshot: " + e.getMessage());
        }
    }
}
