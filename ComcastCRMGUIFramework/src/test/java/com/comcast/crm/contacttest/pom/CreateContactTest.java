package com.comcast.crm.contacttest.pom;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.ContactPage;
import com.comcast.crm.objectrepositoryutility.CreateContactLinkPage;
import com.comcast.crm.objectrepositoryutility.CreateNewContactBtnPage;
import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganizationPage;
/**
 * @author Vidya
 * 
 */
public class CreateContactTest extends BaseClass 
{

	@Test(groups={"smokeTest","regressionTest"})
	public void createContactTest() throws Throwable 
	{
		UtilityClassObject.getTest().log(Status.INFO, "read data from Excel");
		/* Read TestScript data from Excel file*/
		String lastName = eLib.getDataFromExcel("org", 1, 5) + jLib.getRandomNumber();
		String shipping = eLib.getDataFromExcel("org", 1, 6) ;

		/* Step 2: Navigate to Contact module*/
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to Org page");
		
		HomePage hp = new HomePage(driver);
		hp.getContactLink().click();
		
		CreateContactLinkPage clp=new CreateContactLinkPage(driver);
		clp.getCreateContactLink().click();
		ContactPage cp=new ContactPage(driver);
		cp.createContact(lastName, shipping);
		
	
		UtilityClassObject.getTest().log(Status.INFO, "Navigate to new contact page");
		
		CreateNewContactBtnPage ccp=new CreateNewContactBtnPage(driver);
		ccp.getNewContactBtn().click();
		
		
		String actHeader=cp.getHeaderMsg().getText();
		boolean status = actHeader.contains(lastName);
		AssertJUnit.assertEquals(status, true);
		// After save → new page loads
		AssertJUnit.assertTrue(cp.getHeaderMsg().getText().contains(lastName));

	    SoftAssert soft = new SoftAssert();
	    AssertJUnit.assertEquals(ccp.getLastname().getText(), lastName);
	    soft.assertAll();
		
	}

	@Test(groups="regressionTest")
	public void createContactWithsupportDateTest() throws Throwable 
	{
		// Read TestScript data from Excel file
		UtilityClassObject.getTest().log(Status.INFO, "read data from Excel");
				String lastName = eLib.getDataFromExcel("contact", 4, 2) + jLib.getRandomNumber();

				// Navigate to Contacts
				UtilityClassObject.getTest().log(Status.INFO, "Navigate to Org page");
				HomePage hp = new HomePage(driver);
				hp.getContactLink().click();
				
				UtilityClassObject.getTest().log(Status.INFO, "Navigate to contact page");
				CreateNewContactBtnPage ccp=new CreateNewContactBtnPage(driver);
				ccp.getNewContactBtn().click();
				
				String startDate = jLib.getSysytemDateYYYYDDMM();
				String endDate = jLib.getRequiredDateYYYYMMDD(30);
				System.out.println(endDate);

				// Enter contact details
				UtilityClassObject.getTest().log(Status.INFO, "Navigate to contact info page");
				ContactPage cp=new ContactPage(driver);
				cp.createContactWithDate(lastName, startDate, endDate);

				// Verification - Start Date
				String actEndDate = ccp.getVerifyEndDate().getText();
				SoftAssert soft = new SoftAssert();
				AssertJUnit.assertEquals(actEndDate, endDate);
				soft.assertAll();
	}

	@Test(groups="regressionTest")
	public void createContactWithOrgTest() throws Throwable
	{
		UtilityClassObject.getTest().log(Status.INFO, "read data from Excel");
			String orgName = eLib.getDataFromExcel("org", 1, 2) + jLib.getRandomNumber();
			String shipAddress = eLib.getDataFromExcel("org", 4, 5);
			String industry = eLib.getDataFromExcel("org", 4, 3);
			String type = eLib.getDataFromExcel("org", 4, 4);
			
			// Step 4: enter all the details and create new Organization
			UtilityClassObject.getTest().log(Status.INFO, "Navigate to Org page");
			HomePage hp = new HomePage(driver);
			hp.getOrgLink().click();

			UtilityClassObject.getTest().log(Status.INFO, "Navigate to create Org page");
			OrganizationPage cnp = new OrganizationPage(driver);
			cnp.getCreateNewOrgBtn().click();

			UtilityClassObject.getTest().log(Status.INFO, "Navigate to Org page");
			CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
			cnop.createOrg(orgName, shipAddress, industry, type);


			// verify Header orgName info Expected Result
			String actOrgName = cnop.getVerifyType().getText();
			AssertJUnit.assertTrue(actOrgName.contains(orgName));
			

			// Step 5: NAvigate to contact module
			hp.getContactLink().click();

		}
	}


