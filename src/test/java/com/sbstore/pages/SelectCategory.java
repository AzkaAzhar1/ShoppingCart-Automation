package com.sbstore.pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.report.ExtentReportUtils;
import com.sbstore.test.BaseTest;

public class SelectCategory {
	
	@FindBy (xpath = "//a[normalize-space()='Grocery']")
	WebElement category;
	
	public SelectCategory() {
		PageFactory.initElements(BaseTest.driver, this);
	}

	public void SelectingCategory() {
        try {
            WebDriverWait wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(30));

            // Wait until the category is visible
            wait.until(ExpectedConditions.visibilityOf(category));

            // Scroll into view
            ((JavascriptExecutor) BaseTest.driver).executeScript("arguments[0].scrollIntoView(true);", category);

            // Click using JavaScript to avoid overlay issues
            ((JavascriptExecutor) BaseTest.driver).executeScript("arguments[0].click();", category);

            System.out.println("Category clicked successfully!");
            ExtentReportUtils.addStep("Category is clicked");

        } catch (Exception e) {
            System.out.println("Failed to click on category: " + e.getMessage());
        }
	}

}