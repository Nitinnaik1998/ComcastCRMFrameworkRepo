package com.orangehrm.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import com.orangehrm.utilities.PageInitializer;

public class DashBoardPageObjects extends PageInitializer
{
	
	// Step 1: Declaration
	@FindBy(xpath="//p[@class='oxd-userdropdown-name']")
	private WebElement profileDropDown;
	
	@FindBy(linkText = "Logout")
	private WebElement logoutBtn;
	
	@FindBy(xpath = "(//span[.='PIM'])[1]")
	//@FindBy(xpath="//span[normalize-space(text())='PIM']")
	//@FindBy(xpath="//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name' and text()='PIM']")
	private WebElement PIMbutton;
	

	// Step 2: Initialization
	public DashBoardPageObjects(WebDriver driver)
	{
		super(driver);
	}
	
	// Step 3: Implementation
	public void profileDropDownClick()
	{
		profileDropDown.click();
	}
	public void logoutBtnClick()
	{
		logoutBtn.click();
	}
	public void PIMBtnClick()
	{
		PIMbutton.click();
	}
}
