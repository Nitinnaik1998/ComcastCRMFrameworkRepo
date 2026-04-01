package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {

	WebDriver driver;
	public OrganizationPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createNewOrgBtn;
	
	@FindBy(name="search_text")
	private WebElement searchEdit;
	//
	@FindBy(name="search_field")
	private WebElement searchDD;
	
	@FindBy(name="submit")
	private WebElement submitBtn;
	
	public WebElement getSearchEdit() {
		return searchEdit;
	}

	public void setSearchEdit(WebElement searchEdit) {
		this.searchEdit = searchEdit;
	}

	public WebElement getSearchDD() {
		return searchDD;
	}

	public void setSearchDD(WebElement searchDD) {
		this.searchDD = searchDD;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	

	public WebElement getCreateNewOrgBtn() {
		return createNewOrgBtn;
	}
	
}
