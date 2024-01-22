package com.hrms.page;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.hrms.utility.WaitElement;

public class LeaveManagementPage {

	WebDriver driver;
	WaitElement Wait;

	@FindBy(xpath = "//select[@id='dropdownMenuButton']")
	WebElement locationLeaveManagement;

	//@FindBy(xpath = "//a[contains(text(),'Head Office - HO')]")
	//WebElement locationHO;

	@FindBy(xpath = "//button[contains(text(),'Search')]")
	WebElement btnSearch;
	
	@FindBy(xpath = "//input[@id='empinputleave']")
	WebElement searchtxtbox;

	@FindBy(xpath = "//img[@class='download-svg']")
	WebElement downlodbtnLeaveManagement;

	@FindBy(css = "#inputGroupFile04")
	WebElement browsbtnLeaveManagement;

	@FindBy(css = ".btn-outline-secondary-upld")
	WebElement uplodbtnLeaveManagement;

	@FindBy(css = "div[aria-label='Please select a file.']")
	WebElement toastLeaveManagement;

	@FindBy(xpath = "//input[@id='empinputleave']")
	WebElement searchLeaveManagement;
	
	@FindBy(xpath = "//span[contains(text(),'Inventory Management')]")
	WebElement goToInventoryManagement;

	public LeaveManagementPage(WebDriver driver) {
		this.driver = driver;
		//PageFactory.initElements(driver, this);
	}

	public void chkLocationLeaveManagement(String name) throws InterruptedException {
		Thread.sleep(6000);
		WaitElement.waitTill(5000);
		locationLeaveManagement.click();
		Thread.sleep(6000);
		WaitElement.waitTill(1000);
		Select select = new Select(locationLeaveManagement);
		select.selectByValue("LOC003");
		Thread.sleep(6000);
		WaitElement.waitTill(1000);
		btnSearch.click();
		Thread.sleep(6000);
		searchtxtbox.click();
		Thread.sleep(6000);
		searchtxtbox.sendKeys(name);
		WaitElement.waitTill(1000);
		downlodbtnLeaveManagement.click();
	}

	public void chkfileUploadfunction() throws InterruptedException, IOException {
		Thread.sleep(6000);
		WaitElement.waitTill(5000);
		Runtime.getRuntime().exec("D:\\Rajashree_Backup\\Rajarshee_Docs\\Personal\\AutoIT\\FileUpload.exe");
		//downlodbtnLeaveManagement.click();
		Thread.sleep(6000);
		//WaitElement.waitTill(5000);
		//browsbtnLeaveManagement.click();
		//WaitElement.waitTill(5000);
		//browsbtnLeaveManagement.sendKeys("C:\\Users\\gloca\\Downloads");
		//WaitElement.waitTill(5000);
		//System.out.println("Please select a file.");
		//WaitElement.waitTill(5000);
		//uplodbtnLeaveManagement.click();
		//WaitElement.waitTill(5000);
	}

	public InventoryManagementPage goToInventoryManagement() throws InterruptedException {
		Thread.sleep(1000);
		WaitElement.waitTill(1000);
		//searchLeaveManagement.click();
		//WaitElement.waitTill(5000);
		//searchLeaveManagement.sendKeys(empName);
		//WaitElement.waitTill(5000);
		//Thread.sleep(1000);
		goToInventoryManagement.click();
		return PageFactory.initElements(driver, InventoryManagementPage.class);
	}
	// ========================================================================================================

	/* Verifying File Upload Successful */
	public boolean verifyuploadFileLeaveManagement() {
		String expectedURL = "https://glocal-hrms-94502.web.app/dashboard/inv-mangement";
		String actualMsg = driver.getCurrentUrl();
		if (expectedURL.equalsIgnoreCase(actualMsg)) {
			return true;
		} else {
			return false;
		}
	}
}
