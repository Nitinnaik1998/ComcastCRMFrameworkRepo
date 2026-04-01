package PracticeTest;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;


import com.comcast.crm.basetest.BaseClass;


public class InvoiceTest extends BaseClass
{
	@Test
	public void createinvoiceTest()
	{
		System.out.println("execute createInvoiceTest");
		String actTitle=driver.getTitle();
		AssertJUnit.assertEquals(actTitle, "Home Page");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
	}
	
	@Test
	public void createInvoicewithContactTest()
	{
		System.out.println("execute createInvoicewithContactTest");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
	}
	
}
