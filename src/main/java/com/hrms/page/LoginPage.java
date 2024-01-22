package com.hrms.page;

import javax.swing.JOptionPane;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.hrms.utility.WaitElement;

public class LoginPage {

	WebDriver driver;
	WaitElement Wait;

	@FindBy(css = ".forgot-link")
	WebElement forgotPassword;

	@FindBy(id = "email")
	WebElement txtEmailAddress;

	@FindBy(id = "loginPaswd")
	WebElement txtPassword;

	@FindBy(css = ".toggle-password")
	WebElement PaswrdEye;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement btnLogin;

	@FindBy(xpath = "//span[contains(text(),'Super Admin')]")
	WebElement superAdmin;

	@FindBy(xpath = "//a[contains(text(),'Logout')]")
	WebElement logOut;

	@FindBy(css = ".btn.btn-canclecode")
	WebElement cancelfrgtpswd;

	@FindBy(css = "input[placeholder='Email Address']")
	WebElement emailAddrsForgPaswrd;

	@FindBy(xpath = "//button[normalize-space()='Send OTP']")
	WebElement sendOTPfrgpswd;

	@FindBy(xpath = "//input[@placeholder='Drop your OTP here']")
	WebElement dropOTPhrfrgtpsw;

	@FindBy(xpath = "//button[contains(text(),'Submit Otp')]")
	WebElement sbmtOTP;

	@FindBy(css = "input[placeholder='New Password']")
	WebElement nwpswdchgpwd;

	@FindBy(css = "input[placeholder='Confirm password']")
	WebElement cnfpswdchgpwd;

	@FindBy(css = ".btn.btn-submitcodee")
	WebElement finalSubmit;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		// PageFactory.initElements(driver, this);
	}

	public void chkForgtPasswrdlink() {
		forgotPassword.click();
	}

	public void verifyLogin(String userName, String passwordData)
			throws InterruptedException, InvalidFormatException, IOException {
		File src = new File(".\\testdata\\Login_Data.xlsx");
		FileInputStream inputStream = new FileInputStream(src);
		// Properties prop = new Properties();
		// prop.load(fis);
		XSSFWorkbook wb = new XSSFWorkbook(inputStream);
		XSSFSheet sheet = wb.getSheet("Sheet1");

		XSSFRow row = null;
		XSSFCell cell = null;
		String UserName = null;
		String Password = null;

		// int rows = sheet.getPhysicalNumberOfRows();
		// System.out.println(rows);
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			row = sheet.getRow(i);
			for (int j = 0; j < row.getLastCellNum(); j++) {
				cell = row.getCell(j);
				if (j == 0) {
					UserName = cell.getStringCellValue();
				}
				if (j == 1) {
					Password = cell.getStringCellValue();
				}
			}
			Thread.sleep(2000);
			// String userNameDataFromExcel =
			// sheet.getRow(i).getCell(0).getStringCellValue();
			// String passwordDataFromExcel =
			// sheet.getRow(i).getCell(1).getStringCellValue();
			// Thread.sleep(5000);
			Thread.sleep(6000);
			WaitElement.waitTill(1000);
			txtEmailAddress.sendKeys(UserName);
			WaitElement.waitTill(1000);
			txtPassword.sendKeys(Password);
			WaitElement.waitTill(1000);
			PaswrdEye.click();
			WaitElement.waitTill(1000);
			btnLogin.click();
			WaitElement.waitTill(10000);
			//superAdmin.click();
			//Thread.sleep(3000);
			//logOut.click();
			//Thread.sleep(3000);
			String result = null;
			try {
				String ExpURL = "https://glocal-hrms-94502.web.app/dashboard";
				String ActURL = driver.getCurrentUrl();
				if (ExpURL.equalsIgnoreCase(ActURL)) {
					result = "PASS";
				}
				// Boolean isLoggedIn =
				// driver.findElement(By.xpath("//*[@class='app_logo']")).isDisplayed();
				// if(isLoggedIn==true)
				// {
				// result="PASS";
				// }
				System.out.println("Username: " + UserName + " -----> " + "Password: " + Password
						+ " -----> Login Success? " + result);
				Thread.sleep(4000);
				// driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
				superAdmin.click();
				Thread.sleep(3000);
				logOut.click();
				// driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
				// Thread.sleep(5000);
			} catch (Exception e) {
				String ExpURL = "https://glocal-hrms-94502.web.app/login";
				String ActURL = driver.getCurrentUrl();
				if (ExpURL.equalsIgnoreCase(ActURL)) {
					result = "FAIL";
				}
				// Boolean isError = driver.findElement(By.xpath("//div[contains(text(),'Invalid
				// credential')]")).isDisplayed();
				// if(isError==true)
				// {
				// result="FAIL";
				// }
				System.out.println("Username: " + UserName + " -----> " + "Password: " + Password
						+ " -----> Login Success? " + result);
				Thread.sleep(3000);
			}

		}
	}

	public DashboardPage loginDone(String uname, String password) {
		WaitElement.waitTill(1000);
		txtEmailAddress.sendKeys(uname);
		WaitElement.waitTill(1000);
		txtPassword.sendKeys(password);
		WaitElement.waitTill(1000);
		PaswrdEye.click();
		WaitElement.waitTill(1000);
		btnLogin.click();
		WaitElement.waitTill(1000);
		return PageFactory.initElements(driver, DashboardPage.class);
	}

	public void goToHome() throws InterruptedException {
		WaitElement.waitTill(10000);
		superAdmin.click();
		Thread.sleep(3000);
		logOut.click();
		Thread.sleep(3000);
	}

	public void cancelbtnfrgtpswdchk() {
		forgotPassword.click();
		WaitElement.waitTill(1000);
		cancelfrgtpswd.click();
		WaitElement.waitTill(1000);
	}

	public void forgotPasswordlinkChkfunc(String emailAddrsForPaswrd, String enterOTP, String nwpsrwdfrgtpsw,
			String confmpaswdfrgtpsrd) {
		forgotPassword.click();
		WaitElement.waitTill(1000);
		emailAddrsForgPaswrd.click();
		WaitElement.waitTill(1000);
		emailAddrsForgPaswrd.sendKeys(emailAddrsForPaswrd);
		WaitElement.waitTill(1000);
		sendOTPfrgpswd.click();
		WaitElement.waitTill(1000);
		dropOTPhrfrgtpsw.click();
		WaitElement.waitTill(25000);
		dropOTPhrfrgtpsw.sendKeys(enterOTP);
		// String captchaVal = JOptionPane.showInputDialog("Please enter the OTP
		// value:");
		// dropOTPhrfrgtpsw.sendKeys(captchaVal);
		WaitElement.waitTill(1000);
		sbmtOTP.click();
		WaitElement.waitTill(1000);
		nwpswdchgpwd.click();
		WaitElement.waitTill(1000);
		nwpswdchgpwd.sendKeys(confmpaswdfrgtpsrd);
		WaitElement.waitTill(1000);
		cnfpswdchgpwd.click();
		WaitElement.waitTill(1000);
		cnfpswdchgpwd.sendKeys(confmpaswdfrgtpsrd);
		WaitElement.waitTill(1000);
		finalSubmit.click();
		WaitElement.waitTill(1000);
		driver.manage().deleteAllCookies();
	}

	/*
	 * public class Testdatadriventesing {
	 * 
	 * static WebDriver driver; String userNameDataFromExcel; String
	 * passwordDataFromExcel; String userNameDataFromExcel1 = userNameDataFromExcel;
	 * String passwordDataFromExcel1 = passwordDataFromExcel;
	 * 
	 * /* public static void main(String[] args) throws IOException,
	 * InterruptedException, InvalidFormatException { Testdatadriventesing tcs = new
	 * Testdatadriventesing(); tcs.browserLaunch(); tcs.readExcelFile();
	 * //tcs.closebrowser(); }
	 */

	/*
	 * public void browserLaunch() throws IOException, InterruptedException,
	 * InvalidFormatException { System.setProperty("webdriver.chrome.driver",
	 * ".\\chromedriver\\chromedriver.exe"); driver = new ChromeDriver();
	 * driver.get("https://glocal-hrms-94502.web.app/login"); }
	 */

	/*
	 * public static void readExcelFile() throws InvalidFormatException,
	 * IOException, InterruptedException { File src = new
	 * File(".\\testdata\\Login_Data.xlsx"); XSSFWorkbook wb = new
	 * XSSFWorkbook(src); XSSFSheet sheet = wb.getSheet("Sheet1"); int rows =
	 * sheet.getPhysicalNumberOfRows(); System.out.println(rows); for (int i = 1; i
	 * < rows; i++) { // for (int j = 1; j < rows; j++) { //
	 * System.out.println(sheet.getRow(i).getCell(0).getStringCellValue()+"::"+sheet
	 * .getRow(i).getCell(1).getStringCellValue()); String userNameDataFromExcel =
	 * sheet.getRow(i).getCell(0).getStringCellValue(); String passwordDataFromExcel
	 * = sheet.getRow(i).getCell(1).getStringCellValue(); Thread.sleep(5000); //
	 * WebElement uName = driver.findElement(By.xpath("//input[@id='email']")); //
	 * uName.sendKeys(userNameDataFromExcel); // Thread.sleep(5000); //
	 * System.out.println(userNameDataFromExcel); // WebElement pwd =
	 * driver.findElement(By.xpath("//input[@id='loginPaswd']")); //
	 * pwd.sendKeys(passwordDataFromExcel); // Thread.sleep(5000); //
	 * System.out.println(passwordDataFromExcel); // WebElement login = //
	 * driver.findElement(By.xpath("//button[contains(text(),'Login')]")); //
	 * login.click(); // Thread.sleep(10000); // WebElement toster = //
	 * driver.findElement(By.xpath("//div[contains(text(),'Invalid credential')]"));
	 * // if (toster.isDisplayed()) { // break; // } // WebElement superAdmin = //
	 * driver.findElement(By.xpath("//span[contains(text(),'Super Admin')]")); //
	 * System.out.println("superAdmin::" + superAdmin); // superAdmin.click(); //
	 * Thread.sleep(5000); // WebElement logOut = //
	 * driver.findElement(By.xpath("//a[contains(text(),'Logout')]")); //
	 * logOut.click(); // Thread.sleep(5000); } }
	 */

	// ========================================================================================================

	/* Verifying ForgotPassword Link */
	public boolean verifyforgotPasswordlnk() {
		String expURL = "https://glocal-hrms-94502.web.app/forgot-pswd";
		String actURL = driver.getCurrentUrl();
		if (expURL.equalsIgnoreCase(actURL)) {
			return true;
		} else {
			return false;
		}
	}

	/* Verifying valid login */
	public boolean verifyValidLogin() {
		String expURL = "https://glocal-hrms-94502.web.app/dashboard";
		String actURL = driver.getCurrentUrl();

		if (expURL.equalsIgnoreCase(actURL)) {
			return true;
		} else {
			return false;
		}
	}

	/* Verifying invalid login */
	public boolean verifyInValidLogin() {
		String expURL = "https://glocal-hrms-94502.web.app/dashboard";
		String actURL = driver.getCurrentUrl();

		if (expURL.equalsIgnoreCase(actURL)) {
			return true;
		} else {
			return false;
		}
	}

	/* Verifying ForgotPassword cancel button */
	public boolean verifyforgotPasswordcancelbtnchk() {
		String expURL = "https://glocal-hrms-94502.web.app/login";
		String actURL = driver.getCurrentUrl();
		if (expURL.equalsIgnoreCase(actURL)) {
			return true;
		} else {
			return false;
		}
	}

	/* Verifying ForgotPassword functionality */
	public boolean verifyforgotPasswordfunctonaty() {
		String expURL = "https://glocal-hrms-94502.web.app/login";
		String actURL = driver.getCurrentUrl();

		if (expURL.equalsIgnoreCase(actURL)) {
			return true;
		} else {
			return false;
		}
	}

}
