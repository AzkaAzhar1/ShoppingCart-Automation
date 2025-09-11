package com.sbstore.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.report.ExtentReportUtils;
import com.sbstore.test.BaseTest;

public class GoBackToHomePage {
	
	  @FindBy(xpath = "//a[contains(normalize-space(text()),'Home')]")
	    WebElement homeLink;
	 
	 public GoBackToHomePage() {
		 PageFactory.initElements(BaseTest.driver, this);
	 }

	 public void returntohomepage() {
		 
		 WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(10));
	        
	        // Wait for the link to be visible
	        wait.until(ExpectedConditions.visibilityOf(homeLink));
	        
	        // Force-click using JavaScript to bypass overlays or intercepted clicks
	        JavascriptExecutor js = (JavascriptExecutor) BaseTest.driver;
	        js.executeScript("arguments[0].click();", homeLink);
	        
	        // Optional: Wait for the URL to change to the homepage
	        wait.until(ExpectedConditions.urlToBe("https://sbstore.com.pk/"));
	        
	        ExtentReportUtils.addStep("Returned to homepage using JS force-click");
}
}