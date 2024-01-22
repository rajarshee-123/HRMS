package com.hrms.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrms.page.DashboardPage;
import com.hrms.page.EmployeePage;
import com.hrms.page.LeaveManagementPage;
import com.hrms.page.LeavePage;
import com.hrms.page.LoginPage;
import com.hrms.utility.BrowserFactory;
import com.hrms.utility.WaitElement;

public class LeaveManagementRegressionSuite {
	
	WebDriver driver;
	WaitElement Wait;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	LeaveManagementPage leaveManagementPage;
	LeavePage leavePage;
	EmployeePage employeePage;
	
	@BeforeMethod
	public void appLaunch() {
		// This will Launch browser and specific URL
		driver = BrowserFactory.launchBrowser("chrome", "https://glocal-hrms-94502.web.app/login");
	}
	
	@Test(priority = 0, enabled = true, description = "TC_0001: Verifying valid login functionality")
	public void verifyValidLogin() {
		try {
			loginPage = PageFactory.initElements(driver, LoginPage.class);
			dashboardPage = loginPage.loginDone("super.admin@gmail.com", "Test@123");// Entering valid Credencials.
			//loginPage.clickSubmitBtn();
			employeePage = dashboardPage.clickOnEmployeeButton();
			leavePage = employeePage.goToLeavePage();
			leaveManagementPage = leavePage.goToLeaveManagementPage();
			leaveManagementPage.chkLocationLeaveManagement("Name!!!");
			leaveManagementPage.chkfileUploadfunction();
			leaveManagementPage.goToInventoryManagement();
			//dashboardPage.chkdashbrdfunc();
			//dashboardPage.clkEmplye();
			Assert.assertEquals(true, leaveManagementPage.verifyuploadFileLeaveManagement()); // Verifying valid login scenario.
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
