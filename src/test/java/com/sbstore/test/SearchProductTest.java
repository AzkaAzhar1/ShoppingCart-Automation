package com.sbstore.test;

import org.testng.annotations.Test;

import com.sbstore.pages.SearchProduct;

public class SearchProductTest extends BaseTest {
	
	@Test
	public void searchingproduct() {

	SearchProduct searchproduct = new SearchProduct();
	
	searchproduct.searchForProduct("surf");
}
}