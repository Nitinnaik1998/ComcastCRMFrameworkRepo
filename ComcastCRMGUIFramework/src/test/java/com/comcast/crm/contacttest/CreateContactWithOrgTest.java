package com.comcast.crm.contacttest;

import org.openqa.selenium.By;

import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;

import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationPage;

public class CreateContactWithOrgTest extends BaseClass {

	@Test
	public void createOrganiztaionTest() throws Throwable {
		// Read TestScript data from Excel file

		String orgName = eLib.getDataFromExcel("org", 1, 2) + jLib.getRandomNumber();
		String shipAddress = eLib.getDataFromExcel("org", 4, 5);
		String industry = eLib.getDataFromExcel("org", 4, 3);
		String type = eLib.getDataFromExcel("org", 4, 4);
		// Step 4: enter all the details and create new Organization
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		OrganizationPage cnp = new OrganizationPage(driver);
		cnp.getCreateNewOrgBtn().click();

		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName, shipAddress, industry, type);


		// verify Header orgName info Expected Result
		String actOrgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		if (actOrgName.trim().equals(orgName)) {
			System.out.println(orgName + "information is created==PASS");
		} else {
			System.out.println(orgName + "information is notcreated==FAIL");
		}

		// Step 5: NAvigate to contact module
		hp.getContactLink().click();

	}
}
