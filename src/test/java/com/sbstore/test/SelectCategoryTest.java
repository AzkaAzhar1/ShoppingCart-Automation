package com.sbstore.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sbstore.pages.SelectCategory;

public class SelectCategoryTest extends BaseTest {

	@Test
public void Clickingcategory() {
	
	SelectCategory category = new SelectCategory();
	category.SelectingCategory();
	
	String ExpectedUrl = "https://sbstore.com.pk/category/grocery-44rpe";
	
	Assert.assertEquals(BaseTest.driver.getCurrentUrl(), ExpectedUrl, "Navigation to Grocery failed!");
}
	
}
