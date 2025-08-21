package com.sbstore.pages;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sbstore.test.BaseTest;

public class SearchProduct {

	@FindBy(name="keyword")
	WebElement searchfield;
	
	
	public SearchProduct() {
		PageFactory.initElements(BaseTest.driver, this);
	}
		
	public void searchForProduct(String productName) {
	    WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(10));
	    
	    // Wait until search field is visible and interactable
	    wait.until(ExpectedConditions.visibilityOf(searchfield));
	    wait.until(ExpectedConditions.elementToBeClickable(searchfield));

        searchfield.sendKeys(productName);
        searchfield.sendKeys(Keys.ENTER);
	}
	
	public String getSearchInputValue() {
        return searchfield.getAttribute("value");
    }
}
