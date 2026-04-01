package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	WebDriver driver;
	public ContactPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="lastname")
	private WebElement lastnameTF;
		
	@FindBy(name="support_start_date")
	private WebElement startDateTF;
	
	@FindBy(name="support_end_date")
	private WebElement endDateTF;
	
	@FindBy(name="button")
	private WebElement saveBtn;
	
	@FindBy(name="otherstreet")
	private WebElement shipping;
	
	@FindBy(className="dvHeaderText")
	private WebElement headerMsg;
	
	public WebElement getHeaderMsg() {
		return headerMsg;
	}
	public WebElement getShipping()
	{
		return shipping;
	}
	public void createContact(String lastName,String shippingAdd)
	{
		lastnameTF.sendKeys(lastName);
		shipping.sendKeys(shippingAdd);
		saveBtn.click();
	}
	public void createContactWithDate(String lastName,String startdate,String endDate)
	{
		lastnameTF.sendKeys(lastName);
		startDateTF.clear();
		startDateTF.sendKeys(startdate);
		endDateTF.clear();
		endDateTF.sendKeys(endDate);
		saveBtn.click();
	}
	
	
}
