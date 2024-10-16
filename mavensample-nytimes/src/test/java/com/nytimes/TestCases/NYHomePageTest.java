package com.nytimes.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nytimes.BrowserInstance.BrowserHandle;
import com.nytimes.pageobjects.NYHomePage;

public class NYHomePageTest {
	
	WebDriver driver;
    NYHomePage homePage;

    @Parameters("browser")
    @BeforeMethod
    public void setup(String browser) {
        driver = BrowserHandle.getDriver(browser);
        driver.get("https://www.nytimes.com/international/");
        homePage = new NYHomePage(driver);
        
    }

    @Test(dataProvider = "searchData", dataProviderClass = DataProvider.class)
    public void searchArticleTest(String text) {
        homePage.searchNews(text);
        Assert.assertTrue(driver.getTitle().contains(text), "Article not found!");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
