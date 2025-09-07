
package com.sbstore.pages;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sbstore.test.BaseTest;

public class LoginPage {

	//username
	
	@FindBy(name = "email")
	WebElement emailtextbox;
	
	//password
	@FindBy (id = "password")
	WebElement passwordfield;

	//loginbutton 
	@FindBy(xpath = "//button[text()='Login']\r\n")
	WebElement loginbutton;
	
	  @FindBy(xpath = "//button[@data-key='website-popup' and @data-toggle='remove-parent']")
	    WebElement popupCloseButton;
	  
	  @FindBy(xpath = "//img[@alt='SB Store']")
	    WebElement sbStoreLogo;
	 
	
	public LoginPage() {  //this is a constructor 
		PageFactory.initElements(BaseTest.driver, this);  //this keyword tells pagefactory to for annotations in the class
	}
	
	
	Logger log = LogManager.getLogger(LoginPage.class);   //LogManager is a class, log is an object, getlogger is method. .class is a key that creates object of that specific class.

	
	public void logintosbstore(String email, String password) {  // this is our method, and we pass values here so that every time we can test with unique data. 
		emailtextbox.sendKeys(email);
		log.info("email is entered in email textbox");
		passwordfield.sendKeys(password);
		log.info("password is entered in password textbox");
		loginbutton.click();
		log.info("login button is clicked");
		
	}
	
	public void closePopupIfPresent() {
        try {
            if (popupCloseButton.isDisplayed()) {
                popupCloseButton.click();
            }
        }
        catch (Exception e) {
            // Popup not present, ignore
        }
		
	}
	
	
	 public void IsLogodiplayed() {
		 sbStoreLogo.click();		    
		 }
	 
	
}
