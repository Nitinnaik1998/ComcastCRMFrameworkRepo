package com.orangehrm.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import com.orangehrm.utilities.PageInitializer;

public class LoginPageObjects extends PageInitializer
{
	// Step 1: Declaration
//	@FindBy(name="username")
	@FindBy(xpath="//input[@name='username']")
	private WebElement usnTf;
	
	@FindBy(name="password")
	private WebElement pswTf;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement loginBtn;
	
	// Step 2: Initialization
	public LoginPageObjects(WebDriver driver)
	{
		//PageFactory.initElements(driver,this);
		super(driver);
	}
	
	// Step 3: Implementation
	public void enterUsn(String usn)
	{
		usnTf.sendKeys(usn);
	}
	public void enterPsw(String psw)
	{
		pswTf.sendKeys(psw);
	}
	public void clickLoginBtn()
	{
		loginBtn.click();
	}
	
}
