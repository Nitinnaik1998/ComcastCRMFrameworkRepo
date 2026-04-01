package com.comcast.crm.orgtest;


import java.time.Duration;

	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;

	import org.testng.annotations.Test;

	import com.comcast.crm.generic.fileutility.ExcelUtility;
	import com.comcast.crm.generic.fileutility.FileUtility;
	import com.comcast.crm.generic.webdriverutility.JavaUtility;
	import com.comcast.crm.objectrepositoryutility.CreatingNewOrganizationPage;
	import com.comcast.crm.objectrepositoryutility.HomePage;
	import com.comcast.crm.objectrepositoryutility.LoginPage;
	import com.comcast.crm.objectrepositoryutility.OrganizationInfoPage;
	import com.comcast.crm.objectrepositoryutility.OrganizationPage;

	public class DeleteOrgTest
	{


		@Test
		public void createOrganiztaionTest() throws Throwable
		{
			//Create Object
			FileUtility fLib=new FileUtility();
			ExcelUtility eLib=new ExcelUtility();
			JavaUtility jLib=new JavaUtility();
			
			String BROWSER = fLib.getDataFromProperties("Browser");
			String URL = fLib.getDataFromProperties("Url");
			String USERNAME = fLib.getDataFromProperties("Username");
			String PASSWORD = fLib.getDataFromProperties("Password");
			
			
			// Read TestScript data from Excel file
			String orgName=eLib.getDataFromExcel("org", 10,2) +jLib.getRandomNumber();
			String shipping = eLib.getDataFromExcel("org", 1, 5);
			
			WebDriver driver=null;
			
			if(BROWSER.equals("Chrome"))
			{
				driver=new ChromeDriver();
			}
			else if(BROWSER.equals("Firefox"))
			{
				driver=new FirefoxDriver();
			}
			else if(BROWSER.equals("Edge"))
			{
				driver=new EdgeDriver();
			}
			else
			{
				driver=new ChromeDriver();
			}
			//Login Page
			LoginPage lp=new LoginPage(driver);
			lp.loginToapp(URL,USERNAME, PASSWORD);
			
			//Step 2: Navigate to Organization module
			HomePage hp=new HomePage(driver);
			hp.getOrgLink().click();
			
			//Step 3: Click on "Create Organization" Button
			OrganizationPage cnp=new OrganizationPage(driver);
			cnp.getCreateNewOrgBtn().click();
			
			//Step 4: enter all the details and create new Organization
			CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
			cnop.createOrg(orgName, shipping);
			
			
			//Verify Header message Expected Result
			OrganizationInfoPage oip=new OrganizationInfoPage(driver);
			String actOrgName=oip.getHeaderMsg();
			if(actOrgName.contains(orgName))
			{
				System.out.println(orgName + "name is verified == PASS");
			}
			else
			{
				System.out.println(orgName + "name is NOT verified == FAIL");
			}
			
			//Go back to Organization Page
			HomePage hp1=new HomePage(driver);
			hp1.getOrgLink().click();
			//Search for Organization
			//In dynamic WebTable select and delete org
			
			//Step 5: Logout
			hp.logout();

			driver.quit();

			
	}
	}


