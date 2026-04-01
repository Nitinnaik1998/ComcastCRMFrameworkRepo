package com.comcast.crm.objectrepositoryutility;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreatingNewOrganizationPage {

	WebDriver driver;
	public CreatingNewOrganizationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="accountname")
	private WebElement orgNameEdit;
	
	@FindBy(xpath="//textarea[@name='ship_street']")
	private WebElement shippingEdit;
	
//	@FindBy(name="industry")
//	private WebElement industryDB;
//	
	@FindBy(xpath="//select[@name='accounttype']")
	private WebElement typeDB;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
//	@FindBy(id="phone")
//	private WebElement phoneEdit;

//	@FindBy(id="mouseArea_Organization Name")
//	private WebElement verifyorgName;
//	
//	@FindBy(id="dtlview_Phone")
//	private WebElement verifyPhoneNor;
	
	@FindBy(id="dtlview_Industry")
	private WebElement verifyIndustry;
	
	@FindBy(id="dtlview_Type")
	private WebElement verifyType;
	
	public WebElement getVerifyIndustry() {
		return verifyIndustry;
	}

	public WebElement getVerifyType() {
		return verifyType;
	}

//	public WebElement getVerifyPhoneNor() {
//		return verifyPhoneNor;
//	}
//
//	public WebElement getVerifyorgName() {
//		return verifyorgName;
//	}
	
//	public WebElement getPhoneEdit() {
//		return phoneEdit;
//	}

	public WebElement getOrgNameEdit() {
		return orgNameEdit;
	}

//	public WebElement getIndustryDB() {
//		return industryDB;
//	}

	public WebElement getTypeDB() {
		return typeDB;
	}

	public WebElement getShippingEdit() {
		return shippingEdit;
	}
	

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	
	public void createOrg(String orgName,String shipAddress )
	{
		orgNameEdit.sendKeys(orgName);
		
		shippingEdit.sendKeys(shipAddress);
		saveBtn.click();
	}
	public void createOrg(String orgName,String shipAddress ,String phone)
	{
		orgNameEdit.sendKeys(orgName);
		
		shippingEdit.sendKeys(shipAddress);
	//	phoneEdit.sendKeys(phone);
		saveBtn.click();
	}
	public void createOrg(String orgName,String shipAddress ,String industry,String type)
	{
		orgNameEdit.sendKeys(orgName);
	//	Select sel=new Select(industryDB);
	//	sel.selectByVisibleText(industry);
		shippingEdit.sendKeys(shipAddress);
		
		Select sel2=new Select(typeDB);
		sel2.selectByVisibleText(type);
		saveBtn.click();
	}
	
	
}
