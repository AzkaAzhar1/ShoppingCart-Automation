package com.sbstore.test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

	
 public static	WebDriver driver; //so that we can access webdriver from anywhere in the project
	
 
 @BeforeSuite
 
public void InitDrive() {
	 
     ChromeOptions options = new ChromeOptions();

	
	// Disable Chrome's save password popup
     Map<String, Object> prefs = new HashMap<>();
     prefs.put("credentials_enable_service", false);
     prefs.put("profile.password_manager_enabled", false);
     options.setExperimentalOption("prefs", prefs);
     options.addArguments("--disable-save-password-bubble");
	 
    //initialize driver 
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.manage().window().maximize();
	
	driver.get("https://sbstore.com.pk/login");
	
}
}
