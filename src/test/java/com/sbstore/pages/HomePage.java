package com.sbstore.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sbstore.test.BaseTest;

public class HomePage {

	
	 @FindBy(xpath = "//img[@alt='SB Store']")
	    WebElement sbStoreLogo;
	 
	 
	 public HomePage() {
		 PageFactory.initElements(BaseTest.driver, this);  //this keyword tells pagefactory to for annotations in the class
		                                                   //we use initElements in class so that when we create object of the class all findby annotations
		                                                      //gets initialize. 
		}
	 		
	 public boolean IsLogodiplayed() {
		
		 return sbStoreLogo.isDisplayed();
		    }
	 
		 
	 }
	 

