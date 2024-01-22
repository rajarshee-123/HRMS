package com.hrms.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrms.page.DashboardPage;
import com.hrms.page.LoginPage;
import com.hrms.utility.BrowserFactory;
import com.hrms.utility.WaitElement;

public class DashboardRegressionSuite {
	
	WebDriver driver;
	WaitElement Wait;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	//String userNameDataFromExcel;
	//String passwordDataFromExcel;
	
	@BeforeMethod
	public void appLaunch() {
		// This will Launch browser and specific URL
		driver = BrowserFactory.launchBrowser("chrome", "https://glocal-hrms-94502.web.app/login");
	}
	
	@Test(priority = 0, enabled = true, description = "TC_0001: Verifying Download from Dashboard functionality")
	public void verifySelctDrpdwn() {
		try {
			loginPage = PageFactory.initElements(driver, LoginPage.class);
			dashboardPage = loginPage.loginDone("super.admin@gmail.com", "Test@123");// Entering valid Credencials.
			 //loginPage.clickSubmitBtn();
			//dashboardPage = loginPage.submitClk();
			//dashboardPage.downldfromDashbrd();
			dashboardPage.chkdashbrdLocatonfunctlity();
			dashboardPage.downldfromDashbrd();
			//dashboardPage.clkEmplye();
			Assert.assertEquals(true, dashboardPage.verifydshbrdpage()); // Verifying valid login scenario.
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Test(priority = 1, enabled = false, description = "TC_0001: Verifying Dashboard functionality")
	public void verifyfunctionlityDashbrd() {
		try {
			//loginPage = PageFactory.initElements(driver, LoginPage.class);
			//loginPage.loginDone("super.admin@gmail.com", "Test@123");// Entering valid Credencials.
			//dashboardPage = loginPage.submitClk();
			//dashboardPage.clickOnEmployeeButton();
			//dashboardPage.clkEmplye();
			//Assert.assertEquals(true, dashboardPage.verifyEmplyeepage()); // Verifying valid login scenario.
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Test(priority = 2, enabled = true, description = "TC_0001: Verifying Dashboard functionality")
	public void verifyreturnToEmpfunctionlityToDashbrd() {
		try {
			loginPage = PageFactory.initElements(driver, LoginPage.class);
			dashboardPage = loginPage.loginDone("super.admin@gmail.com", "Test@123");// Entering valid Credencials.
			//loginPage.clickSubmitBtn();
			//dashboardPage.visibilityofDashboardOption();
			dashboardPage.clickOnEmployeeButton();
			//dashboardPage.clkEmplye();
			Assert.assertEquals(true, dashboardPage.verifyEmplyeepage()); // Verifying valid login scenario.
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@AfterMethod
	public void closeBrowser() {
		WaitElement.waitTill(5000);
		driver.quit();
	}
}
