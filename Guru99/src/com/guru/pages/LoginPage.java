package com.guru.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.PageFactoryFinder;

import com.guru.testbase.TestBase;

public class LoginPage extends TestBase {
	

	
	
	public LoginPage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(xpath="//input[@name='uid']")
	WebElement username;

	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//input[@name='btnLogin']")
	WebElement loginbtn;
	
	@FindBy(xpath="//img[@role='presentation']")
	WebElement guru99Logo;
	
	//actions
	
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateGuru99Logo() {
		return guru99Logo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) throws IOException {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbtn.click();
		return new HomePage();
	}
	
	
}
