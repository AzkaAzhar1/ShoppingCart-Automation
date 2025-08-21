package com.sbstore.test;

import org.testng.annotations.Test;

import com.sbstore.pages.HomePage;

public class HomeTest extends BaseTest{

	@Test
	public void checklogo() {
		
		HomePage homepage = new HomePage();
		homepage.IsLogodiplayed();
		
	}
	
}
