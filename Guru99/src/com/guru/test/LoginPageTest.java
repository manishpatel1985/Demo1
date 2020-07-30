package com.guru.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.guru.pages.HomePage;
import com.guru.pages.LoginPage;
import com.guru.testbase.TestBase;

public class LoginPageTest extends TestBase {
	LoginPage  loginpage;
	HomePage homepage;
	

	public LoginPageTest() throws IOException {
		super();
		
	}
	
	@BeforeMethod
	public void setup() throws IOException {
		Initialisation();
		loginpage = new LoginPage();
		homepage = new HomePage();
	}
	
	@Test
	public void verifyLoginPageTitleTest() {
	String title= 	loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "Guru99 Bank Home Page");
	}
	@Test
	public void validateGuru99LogoTest() {
		boolean logo = loginpage.validateGuru99Logo();
		Assert.assertTrue(logo);
	}
	
	@Test
	public void loginTest() throws IOException {
		homepage = loginpage.login(prop.getProperty("UserID"), "Password");
		
	}
	
	
	@AfterMethod
	public void teardow() {
		driver.quit();
	}

}
