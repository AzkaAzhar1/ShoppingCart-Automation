package com.sbstore.pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sbstore.test.BaseTest;

public class ViewCart {

	@FindBy (xpath = "//a[contains(text(),'View cart')]")
	WebElement viewcart;
	
	@FindBy (xpath = "//a[@title='Cart' and contains(@class,'d-flex')]")
	WebElement cart;
	
	
	public ViewCart() {
		PageFactory.initElements(BaseTest.driver, this);
		
	}
	
	public void ClickOnCart() {
	
		WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(cart));
		cart.click();
		
	}
	
	public void GoToCart() {
		
		  WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(15));
		    Actions action = new Actions(BaseTest.driver);
		    action.moveToElement(cart).perform(); // hover if needed
		    wait.until(ExpectedConditions.elementToBeClickable(viewcart));
		    viewcart.click();
		    
		    
		
	}
}
