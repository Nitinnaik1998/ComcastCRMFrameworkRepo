package com.orangehrm.runnerscripts;

import org.testng.annotations.Test;


import com.orangehrm.genericscripts.BasePage;
import com.orangehrm.utilities.ReadExcel;

public class Test1 extends BasePage
{
	@Test(dataProvider = "UserData",dataProviderClass = ReadExcel.class)
	public void testingCase(String fn,String mn,String ln)
	{	
		dp.PIMBtnClick();
		pim.clickaddEmpBtn();
		pim.enterFirstName(fn);
		pim.enterMiddleName(mn);
		pim.enetrLastName(ln);
		pim.clicksaveBtn();
	}

}
