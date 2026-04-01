package com.orangehrm.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import com.orangehrm.utilities.PageInitializer;

public class PIMPageObjects extends PageInitializer
{
	@FindBy(xpath = "//a[text()='Add Employee']")
	private WebElement addEmpBtn;
	
	@FindBy(name="firstName")
	private WebElement fnTf;
	
	@FindBy(name="middleName")
	private WebElement mnTf;
	
	@FindBy(name="lastName")
	private WebElement lnTf;
	
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement saveBtn;
	
	
	public PIMPageObjects(WebDriver driver)
	{
		//PageFactory.initElements(driver,this);
		super(driver);
	}
	
	public void clickaddEmpBtn()
	{
		addEmpBtn.click();
	}
	public void enterFirstName(String fn)
	{
		fnTf.sendKeys(fn);
	}
	public void clearfirstName()
	{
		fnTf.clear();
	}
	public void enterMiddleName(String mn)
	{
		mnTf.sendKeys(mn);
	}
	public void clearMiddleName()
	{
		mnTf.clear();
	}
	public void enetrLastName(String ln)
	{
		lnTf.sendKeys(ln);
	}
	public void clearLastName()
	{
		lnTf.clear();
	}
	public void clicksaveBtn()
	{
		saveBtn.click();
	}
}
