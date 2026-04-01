package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactBtnPage {
	WebDriver driver;
	public CreateNewContactBtnPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[@class=\"dvHeaderText\"]")
	private WebElement headerMsg;
	
	@FindBy(xpath="//td[@id=\"mouseArea_Last Name\"]")
	private WebElement lastnameMsg;
	////input[@name="lastname"]
	@FindBy(id="dtlview_Support Start Date")
	private WebElement verifyStartDate;
	
	@FindBy(id="dtlview_Support End Date")
	private WebElement verifyEndDate;
	
	@FindBy(xpath="//img[@title=\"Create Contact...\"]")
	private WebElement newContactBtn;

	public WebElement getVerifyStartDate() {
		return verifyStartDate;
	}

	public WebElement getVerifyEndDate() {
		return verifyEndDate;
	}

	public WebElement getLastname() {
		return lastnameMsg;
	}

	public WebElement getHeaderMsg() {
		return headerMsg;
	}
	
	
	public WebElement getNewContactBtn()
	{
		return newContactBtn;
	}
	
	
}
