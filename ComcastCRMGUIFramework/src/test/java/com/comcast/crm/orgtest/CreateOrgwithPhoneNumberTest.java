package com.comcast.crm.orgtest;



import org.openqa.selenium.By;

import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;

import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationPage;

public class CreateOrgwithPhoneNumberTest extends BaseClass{

	@Test
	public void CreateOrgwithPhoneNumber1Test() throws Throwable
	{
		
		
		// Read TestScript data from Excel file
		
		String orgName=eLib.getDataFromExcel("org", 1,2) +jLib.getRandomNumber();
		String PhoneNumber=eLib.getDataFromExcel("org", 7,3);
		
		
		//Step 2: Navigate to Organization module
				HomePage hp=new HomePage(driver);
				hp.getOrgLink().click();
		
				//Step 3: Click on "Create Organization" Button
				
				OrganizationPage cnp=new OrganizationPage(driver);
				cnp.getCreateNewOrgBtn().click();
				
				
				//Step 4: enter all the details and create new Organization
				
				CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
				cnop.createOrg(orgName, orgName, PhoneNumber);

		
		//Verify PhoneNumber info Expected Result
		String actPhoneNumber=driver.findElement(By.id("dtlview_Phone")).getText();
		if(actPhoneNumber.equals(PhoneNumber))
		{
			System.out.println(PhoneNumber + "information is verified==PASS");
		}
		else
		{
			System.out.println(PhoneNumber + "information is not verified==FAIL");
		}
}
}
