package com.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class login {

	ChromeDriver driver;

	@Test (priority = 1)
	public void login() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SC\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		//Open Browser
		  ChromeDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // enter username
	
		driver.findElement(By.name("username")).sendKeys("Admin");
		//enter password
		driver.findElement(By.name("password")).sendKeys("admin123");
		
		//click on login button
		driver.findElement(By.className("oxd-button")).click();
	}
	
	@Test (priority = 2)
	public void searchleave() {
	WebElement leaveoption = driver.findElement(By.xpath("//a[contains(@class, 'oxd-main-menu-item') and span[text()='Leave']]"));
     leaveoption.click();
	}
	
}
