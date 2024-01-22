package com.hrms.utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitElement {

	public static void waitForElement(WebElement element, int timeout, WebDriver driver) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		
		public static void waitTill(int waitTill) {
			
			try {
				Thread.sleep(waitTill);
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
}
