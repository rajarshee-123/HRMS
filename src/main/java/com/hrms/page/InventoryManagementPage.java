package com.hrms.page;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.hrms.utility.WaitElement;

public class InventoryManagementPage {
	
	
	WebDriver driver;
	WaitElement Wait;
	
	@FindBy(xpath = "//button[contains(text(),'Add Department')]")
	WebElement addDeptbtn;
	
	//@FindBy(xpath = "//input[@placeholder='Enter Department Name']")
	//WebElement addDeptNamebtn;
	
	//@FindBy(css = ".btn-outline-secondary.btn-outline-secondary-deptsbmt")
	//WebElement addDeptsubmtbtn;
	
	//@FindBy(css = "//div[@id='toast-container']")
	//WebElement toastAddDeptInventoryManagementPage;
	
	@FindBy(xpath = "//button[contains(text(),'Add Location')]")
	WebElement addLocationbtn;
	
	//@FindBy(xpath = "//input[@placeholder='Enter Location Name']")
	//WebElement addLocationNameSmtbtn;
	
	//@FindBy(xpath = "//input[@placeholder='Enter Longitude']")
	//WebElement addlongituteSmtbtn;
	
	//@FindBy(xpath = "//input[@placeholder='Enter Latitude']")
	//WebElement addlatitudeSmtbtn;
	
	//@FindBy(xpath = "//button[contains(text(),'Submit')]")
	//WebElement addLocationsubmtbtn;
	
	@FindBy(xpath = "//button[contains(text(),'Add Job Title')]")
	WebElement addJobLocationBtn;
	
	//@FindBy(xpath = "//div[@id='toast-container']")
	//WebElement toastAddLocationInventoryManagementPage;
	
	//@FindBy(css = ".btn.btn-outline-secondary.btn-outline-secondary-adddept2")
	//WebElement addJobTitlebtn;
	
	//@FindBy(xpath = "//input[@placeholder='Enter Job Role']")
	//WebElement enterJobRoleInventoryManagementPage;
	
	//@FindBy(xpath = "//button[contains(text(),'Submit')]")
	//WebElement addJobTitlesubmtbtn;
	
	//@FindBy(css = "//div[@id='toast-container']")
	//WebElement toastAddJobTitleInventoryManagementPage;
	
	@FindBy(xpath = "//span[contains(text(),'Roster Management')]")
	WebElement goToRosterManagementPage;
	
	@FindBy(xpath="//div[@id='inventorydept']//button[@type='button'][normalize-space()='×']")
	WebElement close;
	
	@FindBy(xpath="//div[@id='inventoryloctn']//button[@type='button'][normalize-space()='×']")
	WebElement close1;
	
	@FindBy(xpath="//div[@id='inventorjob']//button[@type='button'][normalize-space()='×']")
	WebElement close2;
	
	public InventoryManagementPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void chkAddDeptartment() throws InterruptedException {
		Thread.sleep(3000);
		WaitElement.waitTill(1000);
		addDeptbtn.click();
		//driver.close();
		Thread.sleep(3000);
		close.click();
		//Thread.sleep(6000);
		//WaitElement.waitTill(5000);
		//addDeptNamebtn.sendKeys(adddeptName);
		// Select select = new Select(statusLeave);
		// select.selectByValue("Reject");
		//WaitElement.waitTill(5000);
		//addDeptsubmtbtn.click();
		//WaitElement.waitTill(5000);
	}
	
	public void chkAddLocation() throws InterruptedException {
		Thread.sleep(3000);
		WaitElement.waitTill(1000);
		addLocationbtn.click();
		Thread.sleep(3000);
		close1.click();
		//WaitElement.waitTill(5000);
		//addLocationNameSmtbtn.sendKeys(addLocationName);
		// Select select = new Select(statusLeave);
		// select.selectByValue("Reject");
		//WaitElement.waitTill(5000);
		//addlongituteSmtbtn.sendKeys(addlongituteName);
		//WaitElement.waitTill(5000);
		//addlatitudeSmtbtn.sendKeys(addlatitudeName);
		//WaitElement.waitTill(5000);
		//addLocationsubmtbtn.click();
		//WaitElement.waitTill(5000);
	}
	
	public void addJobLocation() throws InterruptedException {
		Thread.sleep(3000);
		WaitElement.waitTill(1000);
		addJobLocationBtn.click();
		Thread.sleep(3000);
		close2.click();
	}
	public RosterManagementPage goToRoasterManagement() throws InterruptedException {
		//WaitElement.waitTill(5000);
		//addJobTitlebtn.click();
		//WaitElement.waitTill(5000);
		//enterJobRoleInventoryManagementPage.sendKeys(addJobTitleName);
		// Select select = new Select(statusLeave);
		// select.selectByValue("Reject");
		//WaitElement.waitTill(5000);
		//addlongituteSmtbtn.sendKeys(addlongituteName);
		//WaitElement.waitTill(5000);
		//addlatitudeSmtbtn.sendKeys(addlatitudeName);
		//addJobTitlesubmtbtn.click();
		Thread.sleep(3000);
		WaitElement.waitTill(1000);
		goToRosterManagementPage.click();
		return PageFactory.initElements(driver, RosterManagementPage.class);
	}

	// ========================================================================================================

		/* Verifying File Add Department Name Successful */
		public boolean verifyadddeptnameInventoryManagement() {
			String expectedURL = "https://glocal-hrms-94502.web.app/dashboard/inv-mangement";
			String actualURL = driver.getCurrentUrl();
			if (expectedURL.equalsIgnoreCase(actualURL)) {
				return true;
			} else {
				return false;
			}
		}
	
		/* Verifying File Add Location Name Successful */
		public boolean verifyadddLocationnameInventoryManagement() {
			String expectedURL = "https://glocal-hrms-94502.web.app/dashboard/inv-mangement";
			String actualURL = driver.getCurrentUrl();
			if (expectedURL.equalsIgnoreCase(actualURL)) {
				return true;
			} else {
				return false;
			}
		}
		
		/* Verifying File Add Location Name Successful */
		public boolean verifyadddJobTitlenameInventoryManagement() {
			String expectedURL = "https://glocal-hrms-94502.web.app/dashboard/inv-mangement";
			String actualURL = driver.getCurrentUrl();
			if (expectedURL.equalsIgnoreCase(actualURL)) {
				return true;
			} else {
				return false;
			}
		}
}
