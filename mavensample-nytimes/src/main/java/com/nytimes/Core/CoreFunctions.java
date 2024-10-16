package com.nytimes.Core;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nytimes.BrowserInstance.BrowserHandle;

public class CoreFunctions extends BrowserHandle {
	
	public static void waitForElementToBeVisible(WebDriver driver, WebElement element, Duration timeout) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
    }
	
	public static void waitForElementToBeClickable(WebDriver driver, WebElement element, Duration timeout) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
    }

	public static void presenceOfElementLocated(WebDriver driver, By element, Duration timeout) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.presenceOfElementLocated(element));
		
	}
	
	public static void click(WebElement element, String elementName) {

		try {
			element.click();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void setText(WebElement element, String Text) {
		
		try {
			element.sendKeys(Text);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void clearText(WebElement element) {
		try {element.clear();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	public static String getElementText(WebElement element) {

		String text = "";
		try {
			text = element.getText().trim();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return text;
	}


	
}
