package com.orangehrm.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageInitializer 
{
	public PageInitializer(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
}
