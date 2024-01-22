package com.hrms.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrms.page.DashboardPage;
import com.hrms.page.EmployeePage;
import com.hrms.page.InventoryManagementPage;
import com.hrms.page.LeaveManagementPage;
import com.hrms.page.LeavePage;
import com.hrms.page.LoginPage;
import com.hrms.utility.BrowserFactory;
import com.hrms.utility.WaitElement;

public class InventoryManagementRegressionSuite {
	
	WebDriver driver;
	WaitElement Wait;
	LoginPage loginPage;
	DashboardPage dashboardPage;
	LeaveManagementPage leaveManagementPage;
	LeavePage leavePage;
	EmployeePage employeePage;
	InventoryManagementPage inventoryManagementPage;
	
	@BeforeMethod
	public void appLaunch() {
		// This will Launch browser and specific URL
		driver = BrowserFactory.launchBrowser("chrome", "https://glocal-hrms-94502.web.app/login");
	}
	
	@Test(priority = 0, enabled = true, description = "TC_0001: Verifying AddDepartment functionality")
	public void verifyAddDepartment() {
		try {
			loginPage = PageFactory.initElements(driver, LoginPage.class);
			dashboardPage = loginPage.loginDone("super.admin@gmail.com", "Test@123");// Entering valid Credencials.
			//loginPage.clickSubmitBtn();
			employeePage = dashboardPage.clickOnEmployeeButton();
			leavePage = employeePage.goToLeavePage();
			leaveManagementPage = leavePage.goToLeaveManagementPage();
			inventoryManagementPage = leaveManagementPage.goToInventoryManagement();
			//dashboardPage = loginPage.submitClk();
			inventoryManagementPage.chkAddDeptartment();
			//inventoryManagementPage.chkAddLocation();
			//inventoryManagementPage.addJobLocation();
			inventoryManagementPage.goToRoasterManagement();
			//dashboardPage.chkdashbrdfunc();
			//dashboardPage.clkEmplye();
			Assert.assertEquals(true, inventoryManagementPage.verifyadddeptnameInventoryManagement()); // Verifying valid login scenario.
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Test(priority = 1, enabled = true, description = "TC_0001: Verifying AddLocation functionality")
	public void verifyAddLocation() {
		try {
			loginPage = PageFactory.initElements(driver, LoginPage.class);
			dashboardPage = loginPage.loginDone("super.admin@gmail.com", "Test@123");// Entering valid Credencials.
			//loginPage.clickSubmitBtn();
			employeePage = dashboardPage.clickOnEmployeeButton();
			leavePage = employeePage.goToLeavePage();
			leaveManagementPage = leavePage.goToLeaveManagementPage();
			inventoryManagementPage = leaveManagementPage.goToInventoryManagement();
			inventoryManagementPage.chkAddLocation();
			inventoryManagementPage.goToRoasterManagement();
			//inventoryManagementPage.chkAddLocationInventoryManagement();
			//dashboardPage.chkdashbrdfunc();
			//dashboardPage.clkEmplye();
			Assert.assertEquals(true, inventoryManagementPage.verifyadddLocationnameInventoryManagement()); // Verifying valid login scenario.
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Test(priority = 2, enabled = true, description = "TC_0001: Verifying AddJobTitle functionality")
	public void verifyAddJobTitle() {
		try {
			loginPage = PageFactory.initElements(driver, LoginPage.class);
			dashboardPage = loginPage.loginDone("super.admin@gmail.com", "Test@123");// Entering valid Credencials.
			//loginPage.clickSubmitBtn();
			employeePage = dashboardPage.clickOnEmployeeButton();
			leavePage = employeePage.goToLeavePage();
			leaveManagementPage = leavePage.goToLeaveManagementPage();
			inventoryManagementPage = leaveManagementPage.goToInventoryManagement();
			inventoryManagementPage.addJobLocation();
			inventoryManagementPage.goToRoasterManagement();
			//inventoryManagementPage.chkAddJobTitleInventoryManagement("Doctor");
			//dashboardPage.chkdashbrdfunc();
			//dashboardPage.clkEmplye();
			Assert.assertEquals(true, inventoryManagementPage.verifyadddJobTitlenameInventoryManagement()); // Verifying valid login scenario.
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
