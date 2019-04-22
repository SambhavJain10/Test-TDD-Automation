package com.kite.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.kite.qa.base.TestBase;

public class LoginPage extends TestBase {

	//PageFactory or OR
	@FindBy(xpath="/html/body/div[1]/div/div/div[1]/div/div/div/form/div[2]/input")
	WebElement username;
	
	@FindBy(xpath="/html/body/div[1]/div/div/div[1]/div/div/div/form/div[3]/input")
	WebElement password;
	
	@FindBy(xpath="//button[contains(text(), Login)]")
	WebElement loginbtn;
	
	//Initializing Page objects or OR
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public String ValidateLoginPageTitle() {
	
		return driver.getTitle();
	}
	
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.click();
		return new HomePage();
		
	}
}
