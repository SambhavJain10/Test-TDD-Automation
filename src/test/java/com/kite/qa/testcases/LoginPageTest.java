package com.kite.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.kite.qa.base.TestBase;
import com.kite.qa.pages.HomePage;
import com.kite.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	public LoginPageTest() {
		
		super();
	}
	
	@BeforeTest
	public void Setup() {
		
		initializaion();
		loginPage= new LoginPage();
	}
	
	@Test(priority=1)
	public void ValidateLoginTitleTest() {
		
		String title=loginPage.ValidateLoginPageTitle();
		Assert.assertEquals(title, "Kite - Zerodha's fast and elegant flagship trading platform");
	}
	
	@Test(priority=2)
	public void ValidateLoginTest() {
		
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		//Assert.assertEquals(homePage, new HomePage());
	}

	
	@AfterTest
	public void teadown(){
		
		driver.quit();
	}
}
