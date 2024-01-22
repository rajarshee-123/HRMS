package com.hrms.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.hrms.utility.WaitElement;

public class EmployeePage {
	
	WebDriver driver;
	WaitElement Wait;
	
	@FindBy(xpath = "//span[text()='Leave']")
	WebElement btnLeave;
	
	@FindBy(css="select.form-control-actvdrop")
	WebElement statusEmpType;
	
	@FindBy(xpath = "//select[@id='dropdownMenuButton']")
	WebElement locationDrpdown;
	
	@FindBy(xpath = "//button[contains(text(),'Search')]")
	WebElement btnSearchDshbrd;
	
	//@FindBy(xpath = "//a[contains(text(),'Bhagalpur - BGLP')]")
	//WebElement locationBGLP;
	
	@FindBy(xpath = "//input[@id='empinput']")
	WebElement searchEmp;
	
	@FindBy(xpath = "//span[text()=' Employees']")
	WebElement btnEmployees;
	
	@FindBy(xpath = "//button[@class='btn-add']")
	WebElement addPerson;
	
	@FindBy(xpath = "//div[@id='myModal']//button[@type='button'][normalize-space()='×']")
	WebElement addPersonclose;
	
	
	public EmployeePage(WebDriver driver) {
		this.driver = driver;
		//PageFactory.initElements(driver, this);
	}
	
	public void clickOnEmployeeButton() throws InterruptedException {
		WaitElement.waitForElement(btnEmployees, 100, driver);
		Thread.sleep(6000);
		btnEmployees.click();
		Thread.sleep(20000);
		WaitElement.waitTill(6000);
	}

	public void chkStatusEmployee() throws InterruptedException {
		Thread.sleep(6000);
		statusEmpType.click();
		Thread.sleep(6000);
		statusEmpType.click();
		Thread.sleep(6000);
		Select select1 = new Select(statusEmpType);
		select1.selectByValue("D");
		Thread.sleep(6000);
		select1.selectByVisibleText("ALL");
		Thread.sleep(6000);
		WaitElement.waitTill(1000);
		locationDrpdown.click();
		Thread.sleep(6000);
		locationDrpdown.click();
		WaitElement.waitTill(1000);
		Thread.sleep(6000);
		Select select = new Select(locationDrpdown);
		select.selectByVisibleText("Head Office - HO");
		Thread.sleep(6000);
		select.selectByIndex(3);
		Thread.sleep(6000);
		select.selectByValue("LOC013");
		Thread.sleep(6000);
		select.selectByVisibleText("Head Office - HO");
		WaitElement.waitTill(1000);
		btnSearchDshbrd.click();
		Thread.sleep(6000);
		// select.selectByIndex(1);
		// select.selectByValue("BEHR");
	}
	
	public void searchEmployee(String empName) throws InterruptedException {
		Thread.sleep(6000);
		WaitElement.waitTill(1000);
		searchEmp.click();
		WaitElement.waitTill(1000);
		Thread.sleep(6000);
		searchEmp.sendKeys(empName);
		Thread.sleep(1000);
		WaitElement.waitTill(1000);
		addPerson.click();
		WaitElement.waitTill(1000);
		addPersonclose.click();
		Thread.sleep(6000);		
		WaitElement.waitTill(1000);
		btnLeave.click();
		Thread.sleep(6000);
	}
	
	public LeavePage goToLeavePage() throws InterruptedException {
		Thread.sleep(1000);		
		WaitElement.waitTill(1000);
		btnLeave.click();
		Thread.sleep(1000);
		return PageFactory.initElements(driver, LeavePage.class);
}
	// ========================================================================================================


		/* Verifying Employee Page */
		public boolean verifyemployeepage() {
			String expURL = "https://glocal-hrms-94502.web.app/dashboard/emp";
			String actURL = driver.getCurrentUrl();

			if (expURL.equalsIgnoreCase(actURL)) {
				return true;
			} else {
				return false;
			}
		}
		
		/* Verifying Leave Page */
		public boolean verifyLeavepage() {
			String expURL = "https://glocal-hrms-94502.web.app/dashboard/leave";
			String actURL = driver.getCurrentUrl();

			if (expURL.equalsIgnoreCase(actURL)) {
				return true;
			} else {
				return false;
			}
		}
}