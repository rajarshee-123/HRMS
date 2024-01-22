package com.hrms.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hrms.page.LoginPage;
import com.hrms.utility.BrowserFactory;
import com.hrms.utility.Testdatadriventesing;
import com.hrms.utility.WaitElement;

public class LoginRegressionSuite extends Testdatadriventesing{

	WebDriver driver;
	WaitElement wait;
	LoginPage loginPage;
	String userNameDataFromExcel;
	String passwordDataFromExcel;
	//Testdatadriventesing testdatadriventesing;

	@BeforeMethod
	public void appLaunch() {
		// This will Launch browser and specific URL
		driver = BrowserFactory.launchBrowser("chrome", "https://glocal-hrms-94502.web.app/login");
	}
	
	@Test(priority = 0, enabled = true, description = "TC_0001: Verifying ForgotPassword link")
	public void verifyforgotPasswordlnk() {
		try {
			loginPage = PageFactory.initElements(driver, LoginPage.class);
			loginPage.chkForgtPasswrdlink();// Verify ForgotPassword functionality
			Assert.assertEquals(true, loginPage.verifyforgotPasswordlnk()); // Verifying ForgotPassword scenario.
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Test(priority = 1, enabled = true, description = "TC_0001: Verifying ForgotPassword Cancel functionality")
	public void verifyforgotPasswordcancelbtnchk() {
		try {
			loginPage = PageFactory.initElements(driver, LoginPage.class);
			loginPage.cancelbtnfrgtpswdchk();// Verify ForgotPassword functionality
			Assert.assertEquals(true, loginPage.verifyforgotPasswordcancelbtnchk()); // Verifying ForgotPassword cancel scenario.
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Test(priority = 2, enabled = true, description = "TC_0001: Verifying ForgotPassword functionality")
	public void verifyforgotPasswordfunctonaty() {
		try {
			loginPage = PageFactory.initElements(driver, LoginPage.class);
			loginPage.forgotPasswordlinkChkfunc("rajarshee_bhattacharjee@ghspl.com", "", "Test@123", "Test@123");;// Verify ForgotPassword functionality
			Assert.assertEquals(true, loginPage.verifyforgotPasswordfunctonaty()); // Verifying ForgotPassword cancel scenario.
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@Test(priority = 3, enabled = true, description = "TC_0001: Verifying valid login functionality")
	public void verifyValidLogin() {
		try {
			loginPage = PageFactory.initElements(driver, LoginPage.class);
			//testdatadriventesing.readExcelFile(userNameDataFromExcel,passwordDataFromExcel);
			loginPage.verifyLogin(userNameDataFromExcel,passwordDataFromExcel);// Entering valid Credencials.
			//loginPage.clickSubmitBtn();
			//loginPage.goToHome();
			Assert.assertEquals(true, loginPage.verifyValidLogin()); // Verifying valid login scenario.
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Test(priority = 4, enabled = true, description = "TC_0002: Verifying invalid login functionality")
	public void verifyInvalidLogin() {
		try {
			loginPage = PageFactory.initElements(driver, LoginPage.class);
			loginPage.loginDone("super.admin@gmail.com", "Test@123"); // Entering valid Password.
			Assert.assertEquals(true, loginPage.verifyInValidLogin()); // Verifying valid login scenario.
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	@AfterMethod
	public void closeBrowser() 
	{
		WaitElement.waitTill(1000);
		driver.quit();
	}
}
