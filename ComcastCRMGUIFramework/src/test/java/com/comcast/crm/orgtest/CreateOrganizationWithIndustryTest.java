package com.comcast.crm.orgtest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationPage;

public class CreateOrganizationWithIndustryTest extends BaseClass {

	@Test
	public void createOrganizationWithIndustryTest() throws Throwable {

		// Read TestScript data from Excel file
		String orgName = eLib.getDataFromExcel("org", 1, 2) + jLib.getRandomNumber();
		String industry = eLib.getDataFromExcel("org", 3, 2);
		String type = eLib.getDataFromExcel("org", 4, 2);
		String shipping = eLib.getDataFromExcel("org", 5, 2);

		// Step 2: Navigate to Organization module
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// Step 3: Click on "Create Organization" Button

		OrganizationPage cnp = new OrganizationPage(driver);
		cnp.getCreateNewOrgBtn().click();

		// Step 4: enter all the details and create new Organization

		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName, shipping, industry, type);

		String actIndustries = driver.findElement(By.id("dtlview_Industry")).getText();
		if (actIndustries.equals(industry)) {
			System.out.println(industry + "information is verified==PASS");
		} else {
			System.out.println(industry + "information is not verified==FAIL");
		}
		// Verify Header orgName info Expected Result

		String actType = driver.findElement(By.id("dtlview_Type")).getText();
		if (actType.equals(type)) {
			System.out.println(type + "information is verified==PASS");
		} else {
			System.out.println(type + "information is not verified==FAIL");
		}
	}
}
