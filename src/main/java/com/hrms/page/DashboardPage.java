package com.hrms.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.hrms.utility.WaitElement;

public class DashboardPage {

	WebDriver driver;
	WaitElement Wait;

	//@FindBy(xpath = "//span[contains(text(),'Dashboard')]")
	//WebElement DashBoard;

	//@FindBy(css = ".form-control.form-control-from")
	//WebElement frmCalender;

	//@FindBy(css = ".form-control.form-control-to")
	//WebElement toCalender;

	//@FindBy(xpath = "//a[contains(text(),'Head Office - HO')]")
	//WebElement chooseLocationDshbrd;

	//@FindBy(className = "btn.btn-sm btn-primary")
	//WebElement editDshbrd;
	
	@FindBy(xpath = "//img[@class='download-svg']")
	WebElement downldDshbrd;
	
	@FindBy(xpath = "//select[@id='dropdownMenuButton']")
	WebElement locationDrpdown;

	@FindBy(xpath = "//button[contains(text(),'Search')]")
	WebElement btnSearchDshbrd;
	
	@FindBy(xpath = "//span[contains(text(),'Employees')]")
	WebElement btnEmployees;
	
	@FindBy(xpath = "//button[@class='btn btn-sm btn-primary ng-star-inserted']")
	WebElement btnEdit;
	
	@FindBy(xpath = "//div[@class='modal-header']//button[@type='button'][normalize-space()='×']")
	WebElement btnClose;
	
	@FindBy(xpath = "//input[@id='date-range']")
	WebElement frmdateCaln;
	
	@FindBy(xpath = "//input[@id='date-range'][2]")
	WebElement todateCaln;
	
	//@FindBy(xpath = "//img[@class='updtimgicon']");
	//<List>WebElement empUpdatenmaes;

	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		//PageFactory.initElements(driver, this);
	}

	public void chkdashbrdLocatonfunctlity() throws InterruptedException {
		Thread.sleep(10000);
		frmdateCaln.sendKeys("01/10/2023");
		Thread.sleep(3000);
		todateCaln.sendKeys("10-10-2023");
		WaitElement.waitTill(1000);
		locationDrpdown.click();
		WaitElement.waitTill(1000);
		locationDrpdown.click();
		Thread.sleep(6000);
		Select select = new Select(locationDrpdown);
		select.selectByVisibleText("Head Office - HO");
		Thread.sleep(6000);
		select.selectByIndex(3);
		Thread.sleep(6000);
		select.selectByValue("LOC013");
		Thread.sleep(6000);
		select.selectByVisibleText("Head Office - HO");
		Thread.sleep(6000);
		WaitElement.waitTill(1000);
		btnSearchDshbrd.click();
		Thread.sleep(6000);
		// select.selectByIndex(1);
		// select.selectByValue("BEHR");
	}
	
	public void downldfromDashbrd() throws InterruptedException {
		Thread.sleep(6000);
		WaitElement.waitTill(2000);
		downldDshbrd.click();
		WaitElement.waitTill(2000);
		btnEdit.click();	
		Thread.sleep(6000);
		btnClose.click();
		
	}
	
	public EmployeePage clickOnEmployeeButton() throws InterruptedException {
		WaitElement.waitForElement(btnEmployees, 100, driver);
		Thread.sleep(6000);
		btnEmployees.click();
		Thread.sleep(1000);
		WaitElement.waitTill(1000);
		return PageFactory.initElements(driver, EmployeePage.class);
	}
	
	/*public boolean visibilityofDashboardOption() {
		WaitElement.waitForElement(DashBoard, 50, driver);
		DashBoard.click();
		WaitElement.waitTill(3000);
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		String expectedTitle = "Employee attendance and leave management system";
		String actualTitle = driver.getTitle();
		// if(js.executeScript("arguments[0].scrollIntoView();", cust).equals(cust)) {
		// return true;
		// }else {
		// return false;
		// }
		if (expectedTitle.equals(actualTitle)) {
			return true;
		} else {
			return false;
		}
	}*/

	// ======================================================================================================

	/* Verifying Calender of Dashboard */
	public boolean verifydshbrdpage() {
		String expURL = "https://glocal-hrms-94502.web.app/dashboard";
		String actURL = driver.getCurrentUrl();

		if (expURL.equalsIgnoreCase(actURL)) {
			return true;
		} else {
			return false;
		}
	}

	/* Verifying Calender of Dashboard */
	public boolean verifyEmplyeepage() {
		String expURL = "https://glocal-hrms-94502.web.app/dashboard/emp";
		String actURL = driver.getCurrentUrl();

		if (expURL.equalsIgnoreCase(actURL)) {
			return true;
		} else {
			return false;
		}
	}

}
