package com.nytimes.pageobjects;

import java.io.IOException; 
import java.time.Duration; 
import java.util.concurrent.TimeUnit; 
import org.testng.Assert; 
import org.apache.poi.ss.usermodel.Cell; 
import org.apache.poi.ss.usermodel.Row; 
import org.apache.poi.ss.usermodel.Sheet; 
import org.apache.poi.ss.usermodel.Workbook; 
import org.apache.poi.xssf.usermodel.XSSFWorkbook; 
import org.openqa.selenium.support.ui.ExpectedConditions; 
import org.openqa.selenium.support.ui.WebDriverWait; 
import java.io.FileInputStream; 
import java.io.IOException; 
import java.util.ArrayList; 
import java.util.List; 
import org.openqa.selenium.By; 
import org.openqa.selenium.WebDriver; 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver; 

public class ReadExcel { 
	public static void main(String[] args) throws InterruptedException { 
		// TODO Auto-generated method stub      
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		String loginUrl = "https://www.nytimes.com/international/"; 
		driver.get(loginUrl);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='complianceOverlay']//button[contains(text(),'Continue')]")).click(); 
		
		try { 
			
			// Navigate to the application URL 
			// Load the Excel file 
			FileInputStream excelFile = new FileInputStream("/mavensample-nytimes/src/main/java/com/nytimes/pageobjects/Book1.xlsx"); 
			
			// Adjust the path as needed 
			
			Workbook workbook = new XSSFWorkbook(excelFile); 
			Sheet sheet = workbook.getSheetAt(0); 
			
			// Get the first sheet 
			// Iterate over the rows of the Excel sheet 
			for (Row row : sheet) 
			{ 
				Cell cell = row.getCell(0); 
			
			// Assuming the search terms are in the first column 
			String searchTerm = cell.getStringCellValue(); 
			// Find the search box and enter the search term 
			
			WebElement searchicon =driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div[1]/div[2]/header/section[1]/div[1]/div/button")); 
			Thread.sleep(2000); 
			searchicon.click(); 
			Thread.sleep(5000); 
			WebElement searchBox = driver.findElement(By.xpath("//input[@data-testid='search-input']")); 
			// Replace with the actual search box locator 
			//searchBox.clear(); 
			searchBox.sendKeys(searchTerm); 
			Thread.sleep(4000); 
			// Submit the search 
			WebElement searchButton = driver.findElement(By.xpath("//button[contains(text(),'Go')]")); 
			
			// Replace with the actual search button locator 
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 
			WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(searchButton)); 
			
			// Use the appropriate locator
			//element1.sendKeys(searchTerm); 
			element1.click(); 
			// Optional: wait for search results to load
			Thread.sleep(2000); 
			
			// Replace with explicit waits in a real application 
			System.out.println("Searched for: " + searchTerm); } 
			// Close the workbook 
			workbook.close(); 
			excelFile.close(); 
			} catch (IOException e) 
		{ e.printStackTrace(); } 
		catch (InterruptedException e) 
		{ e.printStackTrace();
			}
		}
	}
