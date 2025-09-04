package com.sbstore.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sbstore.test.BaseTest;

public class ViewCart {
	
	@FindBy(xpath = "//a[@title='Cart']")
	WebElement cart;

	@FindBy (xpath = "//a[contains(text(),'View cart')]")
	WebElement viewcart;
	
 public ViewCart() {
		PageFactory.initElements(BaseTest.driver, this);
		
	}
	
	public void ClickOnCart() {
	
	    WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(15));
	    WebElement cartElement = wait.until(ExpectedConditions.elementToBeClickable(cart));
	    
	    // Scroll into view in case header is sticky
	    ((JavascriptExecutor) BaseTest.driver).executeScript("arguments[0].scrollIntoView(true);", cartElement);
	    
	    // Click with JavaScript (more reliable for sticky elements)
	    ((JavascriptExecutor) BaseTest.driver).executeScript("arguments[0].click();", cartElement);
	}
		
	
	public void GoToCart() {
		
		  WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(15));
		    Actions action = new Actions(BaseTest.driver);
		    action.moveToElement(cart).perform(); // hover if needed
		    wait.until(ExpectedConditions.elementToBeClickable(viewcart));
		    viewcart.click(); 
		    
		    
		
	}
}
