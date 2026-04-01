package com.comcast.crm.orgtest.pom;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
import com.comcast.crm.objectrepositoryutility.OrganizationPage;


public class CreateOrganizationTest extends BaseClass {


	@Test(groups="smokeTest")
	public void createOrganizationTest() throws Throwable
	{
		UtilityClassObject.getTest().log(Status.INFO, "read data from Excel");
		
		// Read TestScript data from Excel file
		String orgName=eLib.getDataFromExcel("org", 10,2) +jLib.getRandomNumber();
		String shipping = eLib.getDataFromExcel("org", 1, 5);
	
		//Step 2: Navigate to Organization module
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Org page");
		HomePage hp=new HomePage(driver);
		hp.getOrgLink().click();
		
		
		//Step 3: Click on "Create Organization" Button
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to create Org page");
		OrganizationPage cnp=new OrganizationPage(driver);
		cnp.getCreateNewOrgBtn().click();
		
		
		//Step 4: enter all the details and create new Organization
		UtilityClassObject.getTest().log(Status.INFO, "Create a new Org");
		CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName, shipping);
		
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Org page");
		//Verify Header message Expected Result
		
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		AssertJUnit.assertTrue(oip.getHeaderMsg().contains(orgName));
		
		
}
	@Test(groups="regressionTest")
	public void CreateOrgwithPhoneNumber1Test() throws Throwable
	{
		
		
		// Read TestScript data from Excel file
		UtilityClassObject.getTest().log(Status.INFO, "read data from Excel");
		String orgName=eLib.getDataFromExcel("org", 1,2) +jLib.getRandomNumber();
		String PhoneNumber=eLib.getDataFromExcel("org", 7,3);
		String shipping = eLib.getDataFromExcel("org", 1, 5);
		
		
		//Step 2: Navigate to Organization module
			UtilityClassObject.getTest().log(Status.INFO, "Navigate to Org page");
				HomePage hp=new HomePage(driver);
				hp.getOrgLink().click();
		
				//Step 3: Click on "Create Organization" Button
				UtilityClassObject.getTest().log(Status.INFO, "Navigate to create Org page");
				OrganizationPage cnp=new OrganizationPage(driver);
				cnp.getCreateNewOrgBtn().click();
				
				
				//Step 4: enter all the details and create new Organization
				UtilityClassObject.getTest().log(Status.INFO, "Navigate to New Org page");
				CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
				cnop.createOrg(orgName, shipping, PhoneNumber);

		
		//Verify PhoneNumber info Expected Result
				UtilityClassObject.getTest().log(Status.INFO, "Navigate to Org Info page");
				OrganizationInfoPage oip = new OrganizationInfoPage(driver);
				AssertJUnit.assertTrue(oip.getPhoneNumber().contains(PhoneNumber));
		
}
	@Test(groups="regressionTest")
	public void createOrganizationWithIndustryTest() throws Throwable {

		// Read TestScript data from Excel file
		UtilityClassObject.getTest().log(Status.INFO, "read data from Excel");
		String orgName = eLib.getDataFromExcel("org", 4, 2) + jLib.getRandomNumber();
		String industry = eLib.getDataFromExcel("org", 4, 3);
		String type = eLib.getDataFromExcel("org", 4, 4);
		String shipping = eLib.getDataFromExcel("org", 4, 5);

		// Step 2: Navigate to Organization module
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Org page");
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// Step 3: Click on "Create Organization" Button
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to create Org page");
		OrganizationPage cnp = new OrganizationPage(driver);
		cnp.getCreateNewOrgBtn().click();

		// Step 4: enter all the details and create new Organization
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to new Org page");
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName, shipping, industry, type);

		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Org info page");
		OrganizationInfoPage oip = new OrganizationInfoPage(driver);

		AssertJUnit.assertTrue(oip.getIndustry().contains(industry));
		AssertJUnit.assertTrue(oip.getType().contains(type));
}
}
