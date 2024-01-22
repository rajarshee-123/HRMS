package com.hrms.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.hrms.utility.WaitElement;

public class LeavePage {

	WebDriver driver;
	WaitElement Wait;
	
	@FindBy(xpath = "//span[text()='Leave']")
	WebElement btnLeave;
	
	@FindBy(xpath = "//select[@id='leaveactv']")
	WebElement statusdrpdown;
	
	//@FindBy(css = ".ng-pristine.ng-valid.ng-touched")
	//WebElement statusLeave;
	
	@FindBy(xpath = "//select[@id='dropdownMenuButton']")
	WebElement locationDrpdown;
	
	//@FindBy(xpath = "//a[contains(text(),'Bhagalpur - BGLP')]")
	//WebElement locationBGLP;
	
	//@FindBy(css = ".form-control-fromm")
	//WebElement frmCalendrLeave;
	
	//@FindBy(css = ".form-control-too")
	//WebElement toCalendrLeave;
	
	@FindBy(xpath = "//button[contains(text(),'Search')]")
	WebElement searchbtn;
	
	@FindBy(xpath = "//input[@id='empinputleave']")
	WebElement searchbtnLeave;
	
	@FindBy(xpath = "//span[contains(text(),'Leave Management')]")
	WebElement btnLeaveManagement;
	
	
	public LeavePage(WebDriver driver) {
		this.driver = driver;
		//PageFactory.initElements(driver, this);
	}

	public void chkStatusLeave(String srchname) throws InterruptedException {
		Thread.sleep(1000);		
		WaitElement.waitTill(1000);
		btnLeave.click();
		Thread.sleep(1000);	
		statusdrpdown.click();
		Thread.sleep(1000);	
		statusdrpdown.click();
		Thread.sleep(1000);	
		Select select = new Select(statusdrpdown);
		//statusLeave.click();
		WaitElement.waitTill(1000);
		select.selectByValue("A");
		Thread.sleep(1000);	
		select.selectByIndex(3);
		Thread.sleep(1000);	
		select.selectByVisibleText("Pending");
		Thread.sleep(1000);	
		WaitElement.waitTill(1000);
		locationDrpdown.click();
		WaitElement.waitTill(1000);
		locationDrpdown.click();
		Thread.sleep(1000);
		Select select1 = new Select(locationDrpdown);
		select1.selectByVisibleText("Head Office - HO");
		Thread.sleep(1000);
		select1.selectByIndex(3);
		Thread.sleep(1000);
		select1.selectByValue("LOC006");
		Thread.sleep(1000);
		select1.selectByVisibleText("Head Office - HO");
		Thread.sleep(1000);
		WaitElement.waitTill(1000);
		searchbtn.click();
		Thread.sleep(6000);
		WaitElement.waitTill(1000);
		searchbtnLeave.click();
		Thread.sleep(6000);
		searchbtnLeave.sendKeys(srchname);
		Thread.sleep(6000);
}
	
	public LeaveManagementPage goToLeaveManagementPage() throws InterruptedException {
		Thread.sleep(1000);		
		btnLeaveManagement.click();
		return PageFactory.initElements(driver, LeaveManagementPage.class);
}
	// ========================================================================================================


		/* Verifying Employee Page */
		public boolean verifyLeaveManagementpage() {
			String expURL = "https://glocal-hrms-94502.web.app/dashboard/leave-mangement";
			String actURL = driver.getCurrentUrl();

			if (expURL.equalsIgnoreCase(actURL)) {
				return true;
			} else {
				return false;
			}
		}
}
