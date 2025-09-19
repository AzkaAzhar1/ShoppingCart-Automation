package com.sbstore.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.sbstore.test.BaseTest;

public class Checkout {

	@FindBy(xpath="//a[contains(text(),'Proceed to Checkout')]")
	WebElement checkoutBtn;
	
	public Checkout() {
		PageFactory.initElements(BaseTest.driver, this);
		
	}
	
	
	public void GoToCheckOut() {
		
		WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(15));
		WebElement GoToCheckOutBtn = wait.until(ExpectedConditions.visibilityOf(checkoutBtn));
		
		((JavascriptExecutor)BaseTest.driver).executeScript("arguments[0].scrollIntoView(true);", GoToCheckOutBtn);
		

		((JavascriptExecutor)BaseTest.driver).executeScript("arguments[0].click()", GoToCheckOutBtn);
		
	}
}
