package com.hrms.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hrms.utility.WaitElement;

public class FaceMismatch {

	WebDriver driver;
	WaitElement Wait;

	@FindBy(xpath = "//button[contains(text(),'Delete Face')]")
	WebElement btnDeleteFace;

	@FindBy(xpath = "//button[contains(text(),'Cancel')]")
	WebElement btnCancelFace;

	@FindBy(xpath = "//span[contains(text(),'Registration Request')]")
	WebElement btnRegistratinRequst;

	public FaceMismatch(WebDriver driver) {
		this.driver = driver;
		// PageFactory.initElements(driver, this);
	}

	public void faceMismatchfunction() throws InterruptedException {
		Thread.sleep(6000);
		btnDeleteFace.click();
		Thread.sleep(3000);
		driver.switchTo().alert().dismiss();
		driver.navigate().refresh();
		Thread.sleep(3000);
		btnCancelFace.click();
		driver.switchTo().alert().dismiss();
		driver.navigate().refresh();
	}

	public RegistrationRequestPage goTORegistrationRequest() throws InterruptedException {
		Thread.sleep(6000);
		btnRegistratinRequst.click();
		Thread.sleep(3000);
		return PageFactory.initElements(driver, RegistrationRequestPage.class);
	}



//========================================================================================================

	/* Verifying Employee Registration Request Page */
	public boolean verifyemployeeFaceMismatchpage() {
		String expURL = "https://glocal-hrms-94502.web.app/dashboard/face-mismtch";
		String actURL = driver.getCurrentUrl();

		if (expURL.equalsIgnoreCase(actURL)) {
			return true;
		} else {
			return false;
		}
	}
	}
