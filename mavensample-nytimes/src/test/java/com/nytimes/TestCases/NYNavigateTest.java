package com.nytimes.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nytimes.BrowserInstance.BrowserHandle;
import com.nytimes.pageobjects.NYHomePage;

public class NYNavigateTest {
	
	WebDriver driver;
    NYHomePage homePage;

    @Parameters("browser")
    @BeforeMethod
    public void setup(@Optional("chrome")String browser) {
        driver = BrowserHandle.getDriver(browser);
        driver.get("https://www.nytimes.com/international/");
        homePage = new NYHomePage(driver);
    }
      @Test
        public void navigateToTest() {
    	homePage.clickOnContinue();
        homePage.navigate();
       
        Assert.assertTrue(driver.findElement(By.xpath("//h1[text()='Technology']")).isDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
