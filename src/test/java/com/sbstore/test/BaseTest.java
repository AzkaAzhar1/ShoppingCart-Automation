package com.sbstore.test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;

import com.report.ExtentReportUtils;

public class BaseTest {

	
 public static	WebDriver driver; //so that we can access webdriver from anywhere in the project
	
 
 @BeforeSuite
public void InitDrive() {
	 
     ChromeOptions options = new ChromeOptions();

	
	// Disable Chrome's save password popup
     Map<String, Object> prefs = new HashMap<>();
     prefs.put("credentials_enable_service", false);
     prefs.put("profile.password_manager_enabled", false);
     prefs.put("profile.password_manager_leak_detection_enabled", false);
     prefs.put("autofill.profile_enabled", false);
     prefs.put("autofill.credit_card_enabled", false);

     options.setExperimentalOption("prefs", prefs);

     // Disable "save password" and "change password" bubbles
     options.addArguments("--disable-save-password-bubble");

     // Disable Chrome Safe Browsing & password check service
     options.addArguments("--disable-features=PasswordManagerOnboarding,PasswordImport,AutofillServerCommunication,AutofillEnableAccountWalletStorage,PasswordCheck");
     options.addArguments("--disable-blink-features=PasswordManagerUI");
     
     // setup method was a static method that's why we called it with a class name
     ExtentReportUtils.setUpReport();
    //initialize driver 
	driver = new ChromeDriver(options);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	
	driver.get("https://sbstore.com.pk/login");
	
}
}
