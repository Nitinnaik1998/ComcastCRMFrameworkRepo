package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {

	WebDriver driver;

	public OrganizationInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className = "dvHeaderText")
	private WebElement headerMsg;

	@FindBy(name = "industry")
	private WebElement industryText;

	@FindBy(name = "accounttype")
	private WebElement typeText;

	@FindBy(id = "phone	")
	private WebElement phoneNumberText;
	

	public String getHeaderMsg() {
		return headerMsg.getText();
	}

	public String getIndustry() {
		return industryText.getText();
	}

	public String getType() {
		return typeText.getText();
	}

	public String getPhoneNumber() {
		return phoneNumberText.getText();
	}
}
