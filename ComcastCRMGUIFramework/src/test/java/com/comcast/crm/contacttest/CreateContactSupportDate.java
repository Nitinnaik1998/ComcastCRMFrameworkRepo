package com.comcast.crm.contacttest;

import org.openqa.selenium.By;

import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;

import com.comcast.crm.objectrepositoryutility.HomePage;

public class CreateContactSupportDate extends BaseClass {
	@Test
	public void createOrganiztaionTest() throws Throwable {

		// Read TestScript data from Excel file
		String lastName = eLib.getDataFromExcel("contact", 4, 2) + jLib.getRandomNumber();

		// Navigate to Contacts
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();
		

		String startDate = jLib.getSysytemDateYYYYDDMM();
		String endDate = jLib.getSysytemDateYYYYDDMM();

		// Enter contact details
		driver.findElement(By.name("lastname")).sendKeys(lastName);

		driver.findElement(By.name("support_start_date")).clear();
		driver.findElement(By.name("support_start_date")).sendKeys(startDate);

		driver.findElement(By.name("support_end_date")).clear();
		driver.findElement(By.name("support_end_date")).sendKeys(endDate);

		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		// Verification - Start Date
		String actStartDate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		if (actStartDate.equals(startDate)) {
			System.out.println(startDate + " information is verified == PASS");
		} else {
			System.out.println(startDate + " information is not verified == FAIL");
		}

		// Verification - End Date
		String actEndDate = driver.findElement(By.id("dtlview_Support End Date")).getText();
		if (actEndDate.equals(endDate)) {
			System.out.println(endDate + " information is verified == PASS");
		} else {
			System.out.println(endDate + " information is not verified == FAIL");
		}

	}
}
