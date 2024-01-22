package com.hrms.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Testdatadriventesing {

	static WebDriver driver;
	String userNameDataFromExcel;
	String passwordDataFromExcel;
	String userNameDataFromExcel1 = userNameDataFromExcel;
	String passwordDataFromExcel1 = passwordDataFromExcel;
	
	/*public static void main(String[] args) throws IOException, InterruptedException, InvalidFormatException {
		Testdatadriventesing tcs = new Testdatadriventesing();
		tcs.browserLaunch();
		tcs.readExcelFile();
		//tcs.closebrowser();
	}*/

	/*public void browserLaunch() throws IOException, InterruptedException, InvalidFormatException {
		System.setProperty("webdriver.chrome.driver", ".\\chromedriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://glocal-hrms-94502.web.app/login");
	}*/

	public static void readExcelFile(String userNameDataFromExcel1, String passwordDataFromExcel1) throws InvalidFormatException, IOException, InterruptedException {
		File src = new File(".\\testdata\\Login_Data.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(src);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		int rows = sheet.getPhysicalNumberOfRows();
		System.out.println(rows);
		for (int i = 1; i < rows; i++) {
			// for (int j = 1; j < rows; j++) {
			// System.out.println(sheet.getRow(i).getCell(0).getStringCellValue()+"::"+sheet.getRow(i).getCell(1).getStringCellValue());
			String userNameDataFromExcel = sheet.getRow(i).getCell(0).getStringCellValue();
			String passwordDataFromExcel = sheet.getRow(i).getCell(1).getStringCellValue();
			Thread.sleep(5000);
			//WebElement uName = driver.findElement(By.xpath("//input[@id='email']"));
			//uName.sendKeys(userNameDataFromExcel);
			//Thread.sleep(5000);
			//System.out.println(userNameDataFromExcel);
			//WebElement pwd = driver.findElement(By.xpath("//input[@id='loginPaswd']"));
			//pwd.sendKeys(passwordDataFromExcel);
			//Thread.sleep(5000);
			//System.out.println(passwordDataFromExcel);
			//WebElement login = driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
			//login.click();
			//Thread.sleep(10000);
			//WebElement toster = driver.findElement(By.xpath("//div[contains(text(),'Invalid credential')]"));
			//if (toster.isDisplayed()) {
			//	break;
			//}
			//WebElement superAdmin = driver.findElement(By.xpath("//span[contains(text(),'Super Admin')]"));
			//System.out.println("superAdmin::" + superAdmin);
			//superAdmin.click();
			//Thread.sleep(5000);
			//WebElement logOut = driver.findElement(By.xpath("//a[contains(text(),'Logout')]"));
			//logOut.click();
			//Thread.sleep(5000);
		}
	}

	/*public void closebrowser() {
		driver.close();
	}*/
}



