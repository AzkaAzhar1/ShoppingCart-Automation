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

public class AddToCart {


	@FindBy(xpath = "//a[contains(@onclick,'showAddToCartModal')]\r\n")
	WebElement productbtn;
	
	@FindBy (xpath = "//a[@title='Cart' and contains(@class,'d-flex')]")
	WebElement verifycartcount;
	
	
	@FindBy(xpath="//img[contains(@title, 'NESTLE MILO POUCH 70G')]")
	WebElement product;
	
	
	
	public AddToCart() {
		PageFactory.initElements(BaseTest.driver, this);
	}
	
	public void AddingToCart() {
		
		try {
			
		
		//ExplicitWait
		WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(product));
		
		// Scroll into view
	       ((JavascriptExecutor) BaseTest.driver).executeScript("arguments[0].scrollIntoView(true);", product);
			
	       
	   	Actions action = new Actions(BaseTest.driver);
		action.moveToElement(product).perform();
	       
		wait.until(ExpectedConditions.elementToBeClickable(product));

	       // Click using JavaScript to avoid overlay issues
	       ((JavascriptExecutor) BaseTest.driver).executeScript("arguments[0].click();", productbtn);
		
		//for hovering on the product so that the add to cart button is visible 
	
		
		
		System.out.println("product added succesfully");
		
		} catch (Exception e) {
			
			System.out.println("product not added in cart"+ e.getMessage());
		}
		
		
	}
	
	public void VerifyCartIncrement() {
		
		try {
		WebDriverWait wait = new WebDriverWait(BaseTest.driver,Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(verifycartcount));
		
		String countText = verifycartcount.getText();
        int count = Integer.parseInt(countText);

        if (count > 0) {
            System.out.println("Cart incremented successfully. Cart count: " + count);
        } else {
            System.out.println("Cart did not increment. Cart count: " + count);
        }

    } catch (Exception e) {
        System.out.println("Error verifying cart increment: " + e.getMessage());
    }
		
			
			
		}
		
		
	}
	