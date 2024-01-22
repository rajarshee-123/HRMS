package com.hrms.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrms.page.DashboardPage;
import com.hrms.page.EmployeePage;
import com.hrms.page.FaceMismatch;
import com.hrms.page.InventoryManagementPage;
import com.hrms.page.LeaveManagementPage;
import com.hrms.page.LeavePage;
import com.hrms.page.LoginPage;
import com.hrms.page.RegistrationRequestPage;
import com.hrms.page.RosterManagementPage;
import com.hrms.utility.BrowserFactory;
import com.hrms.utility.WaitElement;

public class RegistrationRequestRegressionSuite {
	
	WebDriver driver;
	WaitElement Wait;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	LeaveManagementPage leaveManagementPage;
	LeavePage leavePage;
	EmployeePage employeePage;
	InventoryManagementPage inventoryManagementPage;
	RosterManagementPage rosterManagementPage;
	FaceMismatch faceMismatch;
	RegistrationRequestPage registrationRequestPage;
	
	@BeforeMethod
	public void appLaunch() {
		// This will Launch browser and specific URL
		driver = BrowserFactory.launchBrowser("chrome", "https://glocal-hrms-94502.web.app/login");
	}
	
	@Test(priority = 0, enabled = true, description = "TC_0001: Verifying Roaster Page functionality")
	public void verifyRosterManagement() {
		try {
			loginPage = PageFactory.initElements(driver, LoginPage.class);
			dashboardPage = loginPage.loginDone("super.admin@gmail.com", "Test@123");// Entering valid Credencials.
			//loginPage.clickSubmitBtn();
			employeePage = dashboardPage.clickOnEmployeeButton();
			leavePage = employeePage.goToLeavePage();
			leaveManagementPage = leavePage.goToLeaveManagementPage();
			inventoryManagementPage = leaveManagementPage.goToInventoryManagement();
			rosterManagementPage = inventoryManagementPage.goToRoasterManagement();
			faceMismatch = rosterManagementPage.goToFaceMismatch();
			registrationRequestPage =  faceMismatch.goTORegistrationRequest();
			registrationRequestPage.chkRegistrationrequestfunctlity();
			registrationRequestPage.goTORegistrationRequest();
			Assert.assertEquals(true, registrationRequestPage.verifyMonthlyReportpage()); // Verifying valid login scenario.
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
