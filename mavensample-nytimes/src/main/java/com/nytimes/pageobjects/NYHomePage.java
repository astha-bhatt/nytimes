package com.nytimes.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.nytimes.Core.CoreFunctions;

public class NYHomePage extends CoreFunctions {
	
	    WebDriver driver;	   
	    public NYHomePage(WebDriver driver) {
	        this.driver = driver;
	    }

	    By searchIcon = By.xpath("//button[@aria-controls='search-input']");
	    By searchText = By.xpath("//div[@id='search-input']//input[@data-testid='search-input']");
	    By submit = By.xpath("//div[@id='search-input']//button[@data-testid='search-submit']");
	    
	    By businessMenu = By.xpath("(//button[@aria-label='open Business submenu'][@data-navid='Business'])[1]");
	    By tech = By.xpath("//h3[text()='Sections']//a[text()='Tech']");
	    
	    By todayPaper = By.xpath("//a[text()='Today’s Paper']");
	    By frontPage = By.xpath("//a[text()='The Front Page']");
	    
	    By canadaLink = By.xpath("//a[@href='/ca/']");
	    By continueButton = (By.xpath("//div[@id='complianceOverlay']//button[contains(text(),'Continue')]"));
	    
	    public void clickOnContinue()
	    {
			WebElement continuePopUp = driver.findElement(continueButton);
	    	CoreFunctions.waitForElementToBeClickable(driver, continuePopUp, Duration.ofSeconds(10));
	    	CoreFunctions.click(continuePopUp, "Click on business menu");	
	    }
	    	       	    
	    public void searchNews(String text) {
			WebElement search = driver.findElement(searchIcon);
	    	CoreFunctions.waitForElementToBeVisible(driver, search, Duration.ofSeconds(10));
	    	CoreFunctions.click(search, "Click on business menu");
	        driver.findElement(searchText).sendKeys(text);
	        driver.findElement(submit).click();	       			
		}
	    
	    public void navigate() {
	    	
	    	WebElement businessSubMenu = driver.findElement(businessMenu);
//	    	CoreFunctions.presenceOfElementLocated(driver, businessMenu, Duration.ofSeconds(10));
//	    	CoreFunctions.waitForElementToBeClickable(driver, businessSubMenu, Duration.ofSeconds(10));
	    	Actions actions = new Actions(driver);
	    	actions.moveToElement(businessSubMenu).click().perform();
//	    	CoreFunctions.click(businessSubMenu, "Click on business menu");
	    	
	    	WebElement techOption = driver.findElement(tech);
	    	CoreFunctions.waitForElementToBeClickable(driver, techOption, Duration.ofSeconds(10));
	    	CoreFunctions.click(techOption, "Click on Tech section");
	    }
	    
	    public void goToTodaysPaper () {
	    	WebElement todaysPaper = driver.findElement(todayPaper);
	    	CoreFunctions.waitForElementToBeVisible(driver, todaysPaper, Duration.ofSeconds(10));
	    	CoreFunctions.click(todaysPaper, "Click on Tech section");
	    }
	    	
	    	public void goToFrontpage () {
	    	WebElement theFrontPage = driver.findElement(frontPage);
	    	CoreFunctions.waitForElementToBeVisible(driver, theFrontPage, Duration.ofSeconds(10));
	    	CoreFunctions.click(theFrontPage, "Click on Tech section");	    	
	    }
	    	
	    	public void goToCanadaNews () {
	    		WebElement canadaNews = driver.findElement(canadaLink);
		    	CoreFunctions.waitForElementToBeVisible(driver, canadaNews, Duration.ofSeconds(10));
		    	CoreFunctions.click(canadaNews, "Click on Tech section");
	    	}
}
