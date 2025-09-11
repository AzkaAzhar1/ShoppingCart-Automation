package com.sbstore.test;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sbstore.pages.AddToCart;
import com.sbstore.pages.GoBackToHomePage;
import com.sbstore.pages.LoginPage;
import com.sbstore.pages.SelectCategory;
import com.sbstore.pages.SelectSubCategory;
import com.sbstore.pages.ViewCart;

public class LoginTest extends BaseTest{

	@Test  (priority = 1)
	public void loginwithvalidcredentials() {
		
		LoginPage loginPage = new LoginPage();
		
		loginPage.logintosbstore("Sarah21@gmail.com", "123456");
		loginPage.closePopupIfPresent();
		loginPage.closingCookiePopup();
		loginPage.CloseAlertPopup();
		loginPage.IsLogodiplayed();
		
		
	}
	
	@Test (priority = 2)
	public void Selectingthecategory() {
		SelectCategory categoryPage = new SelectCategory();
        categoryPage.SelectingCategory();
        
        Assert.assertTrue(BaseTest.driver.getCurrentUrl().contains("/category/grocery-44rpe"));

	}
	
	
	@Test (priority = 3)
	public void SelectingtheSubCategory() {
		
		SelectSubCategory subcategorypage = new SelectSubCategory();
		subcategorypage.ClickingSubCategory();
		
		Assert.assertTrue(BaseTest.driver.getCurrentUrl().contains("/category/beverages-yfnyb"));
	}
	
	@Test (priority = 4)
	public void Addingtocartproduct() {
		AddToCart cart = new AddToCart();
		cart.AddingToCart();
		cart.VerifyCartIncrement();		
		
	}
	
	@Test (priority = 5)
	public void GoingBacktohomepage() {
		
		GoBackToHomePage home = new GoBackToHomePage();
		home.returntohomepage();
		
String actualURL = "https://sbstore.com.pk/";

WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(5));
wait.until(ExpectedConditions.urlToBe(actualURL));

Assert.assertEquals(BaseTest.driver.getCurrentUrl(), actualURL);
	}
	
	
	/* @Test (priority = 6)
	public void ViewCartProducts() {
		
		ViewCart view = new ViewCart();
		view.ClickOnCart();
		view.GoToCart();
		
		Assert.assertTrue(BaseTest.driver.getCurrentUrl().contains("https://sbstore.com.pk/cart"));
		
	} */
	
}