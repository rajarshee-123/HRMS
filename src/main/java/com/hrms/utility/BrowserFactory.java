package com.hrms.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {
	
static WebDriver driver;
	
	public static WebDriver launchBrowser(String browsername, String url) {
		
		if(browsername.equalsIgnoreCase("chrome")) {
			//options.addArguments("--disable-notifications");
			//System.setProperty("webdriver.chrome.driver", ".\\chromedriver\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(browsername.equalsIgnoreCase("firefox")) {
			//System.setProperty("webdriver.firefox.driver", ".\\firefoxdriver\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(browsername.equalsIgnoreCase("IE")) {
			//System.setProperty("webdriver.ie.driver", ".\\iedriver\\IEDriverServer.exe");
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		//}else {
			//System.out.println("No Browser Selected");
		}	
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(url);
		return driver;
	}
	
	//public static WebDriver closeBrowser() {
		//driver.close();
		///return driver;
	//}
	
}
