package com.sbstore.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sbstore.test.BaseTest;

public class SelectSubCategory {

	
	@FindBy (xpath = "//img[contains(@alt, 'Beverages')]")
	WebElement subcategory;
	
	public SelectSubCategory() {
		
	PageFactory.initElements(BaseTest.driver, this);
	}
	
	public void ClickingSubCategory() {
		try
		{
       WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(15));
       
       wait.until(ExpectedConditions.visibilityOf(subcategory));
       
    // Scroll into view
       ((JavascriptExecutor) BaseTest.driver).executeScript("arguments[0].scrollIntoView(true);", subcategory);
		
       // Click using JavaScript to avoid overlay issues
       ((JavascriptExecutor) BaseTest.driver).executeScript("arguments[0].click();", subcategory);

       System.out.println("Category clicked successfully!");

   } catch (Exception e) {
       System.out.println("Failed to click on the category: " + e.getMessage());
	
   
   }
		
	}
	
}
