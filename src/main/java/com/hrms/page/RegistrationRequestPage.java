package com.hrms.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.utility.WaitElement;

public class RegistrationRequestPage {
	
	WebDriver driver;
	WaitElement Wait;
	
	@FindBy(xpath = "//input[@id='date-range']")
	WebElement frmdateCaln;
	
	@FindBy(xpath = "//input[@id='date-range'][2]")
	WebElement todateCaln;
	
	@FindBy(xpath = "//button[contains(text(),'Search')]")
	WebElement btnSearch;
	
	@FindBy(xpath = "//span[contains(text(),'Monthly Report')]")
	WebElement btnMonthlyReport;
	
	public RegistrationRequestPage(WebDriver driver) {
		this.driver = driver;
		//PageFactory.initElements(driver, this);
	}
	
	public void chkRegistrationrequestfunctlity() throws InterruptedException {
		Thread.sleep(6000);
		frmdateCaln.sendKeys("01/10/2023");
		Thread.sleep(3000);
		todateCaln.sendKeys("10-10-2023");
		WaitElement.waitTill(1000);
		btnSearch.click();
		WaitElement.waitTill(1000);
	}
	
	public MonthlyReportPage goTORegistrationRequest() throws InterruptedException {
		Thread.sleep(6000);
		btnMonthlyReport.click();
		Thread.sleep(3000);
		return PageFactory.initElements(driver, MonthlyReportPage.class);
	}



//========================================================================================================

	/* Verifying Employee Registration Request Page */
	public boolean verifyMonthlyReportpage() {
		String expURL = "https://glocal-hrms-94502.web.app/dashboard/mnthly-rpt";
		String actURL = driver.getCurrentUrl();

		if (expURL.equalsIgnoreCase(actURL)) {
			return true;
		} else {
			return false;
		}
	}
	}

