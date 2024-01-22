package com.hrms.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.hrms.utility.WaitElement;

public class RosterManagementPage {
	
	
	WebDriver driver;
	WaitElement Wait;
	
	@FindBy(xpath = "//select[@id='dropdownMenuButton']")
	WebElement locationroster;
	
	//@FindBy(xpath = "//a[contains(text(),'Head Office - HO')]")
	//WebElement locationHO;
	
	@FindBy(xpath = "//input[@class='form-control form-control-emptbl ng-untouched ng-pristine ng-valid']")
	WebElement searchTxtName;
	
	@FindBy(xpath = "//button[contains(text(),'Search')]")
	WebElement searchBtn;
	
	@FindBy(xpath = "//button[contains(text(),'Select Template')]")
	WebElement selectTemplateBtn;
	
	@FindBy(xpath = "//div[@class='modal-content modal-content-rgctad']//button[@type='button'][normalize-space()='×']")
	WebElement closeBtn;
	
	@FindBy(xpath = "//button[contains(text(),'Add Shifts')]")
	WebElement addShiftBtn;
	
	@FindBy(xpath = "//div[@class='modal-header']//button[@type='button'][normalize-space()='×']")
	WebElement close1Btn;
	
	@FindBy(xpath = "//button[contains(text(),'Save Template')]")
	WebElement saveTemplate;
	
	@FindBy(xpath = "//div[@class='modal-content modal-content-rgct']//button[@type='button'][normalize-space()='×']")
	WebElement close2Btn;

	@FindBy(xpath = "//span[contains(text(),'Face Mismatch')]")
	WebElement faceMismatch;
	
	@FindBy(xpath = "//a[contains(text(),'Super Admin')]")
	WebElement dropdownlist;
	
	
	//@FindBy(xpath = "//a[contains(text(),'New Employee4')]")
	//WebElement empNamesearchfrmdropdown;
	
	//@FindBy(css = ".btn.btn-outline-secondary.btn-outline-secondary-search")
	//WebElement searchEmpRosterbtn;
	
	//@FindBy(css = ".btn.btn-outline-secondary.btn-outline-secondary-adddept")
	//WebElement selectDay;
	
	//@FindBy(className = "//select[@class='select select-shift2 ng-pristine ng-valid ng-touched']")
	//WebElement addShifts;
	
	//@FindBy(css = ".btn.btn-outline-secondary.btn-outline-secondary-Selecttemplate")
	//WebElement selectSaveTemplate;
	
	//@FindBy(xpath = "//select[@id='shift']")
	//WebElement tmplatNamesearchfrmdropdown;
	
	//@FindBy(className = "//button[@class='btn btn-sm btn-primary btn-primary-shiftsbmt2']")
	//WebElement submtbtn;
	
	public RosterManagementPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void chkRoasterManagementFunctionality(String name) throws InterruptedException {
		Thread.sleep(6000);
		locationroster.click();
		Select select = new Select(locationroster);
		select.selectByVisibleText("Muzaffarpur - MUZF");
		Thread.sleep(6000);
		select.selectByValue("LOC006");
		Thread.sleep(6000);
		select.selectByIndex(1);
		//WaitElement.waitTill(1000);
		searchTxtName.click();
		Thread.sleep(6000);
		searchTxtName.sendKeys(name);
		Thread.sleep(6000);
		dropdownlist.click();
		WaitElement.waitTill(1000);
		searchBtn.click();
		Thread.sleep(6000);
	}
	
	public void chkRosterManagement() throws InterruptedException {
		Thread.sleep(6000);
		WaitElement.waitTill(1000);
		selectTemplateBtn.click();
		Thread.sleep(6000);
		WaitElement.waitTill(1000);
		closeBtn.click();
		Thread.sleep(6000);
		WaitElement.waitTill(1000);
		addShiftBtn.click();
		Thread.sleep(6000);
		close1Btn.click();
		//WaitElement.waitTill(1000);
		//searchboxEmpRosterName.sendKeys(empName);
		//WaitElement.waitTill(1000);
		//saveTemplate.clear();
		//WaitElement.waitTill(1000);
		Thread.sleep(6000);
		saveTemplate.click();
		WaitElement.waitTill(1000);
		Thread.sleep(6000);
		close2Btn.click();
		//searchEmpRosterbtn.click();
		//WaitElement.waitTill(5000);
		//selectSaveTemplate.click();
		//addShifts.click();
		//WaitElement.waitTill(5000);
		//Select select = new Select(tmplatNamesearchfrmdropdown);
		//select.selectByIndex(0);
		//WaitElement.waitTill(5000);
		//submtbtn.click();
		//WaitElement.waitTill(5000);
	}
	
	public FaceMismatch goToFaceMismatch() throws InterruptedException {
		Thread.sleep(6000);
		faceMismatch.click();
		return PageFactory.initElements(driver, FaceMismatch.class);
	}
	
	// ========================================================================================================

		/* Verifying File Upload Successful */
		public boolean verifyRoasterManagementPage() {
			String expURL = "https://glocal-hrms-94502.web.app/dashboard/face-mismtch";
			String actURL = driver.getCurrentUrl();
			if (expURL.equalsIgnoreCase(actURL)) {
				return true;
			} else {
				return false;
			}
		}
	
	
}
