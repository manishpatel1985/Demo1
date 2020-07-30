package com.guru.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	public static WebDriver driver ;
	public static Properties prop;
	
	public TestBase() throws IOException {
		
		prop = new Properties();
		FileInputStream ip = new FileInputStream("C:\\Selenium\\manishSelenium\\manishSelenium\\Guru99\\src\\data.properties");
		prop.load(ip);
	
	}
	
	public  void Initialisation() {
		String browsername = prop.getProperty("browser");
		if(browsername.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\driver\\geckodriver.exe");
			driver = new FirefoxDriver();
			}else if (browsername.contains("chrome")){			
				System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\driver\\chromedriver.exe");
				driver = new ChromeDriver();
			}
		
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			driver.get(prop.getProperty("url"));
			
		}
	

	}
