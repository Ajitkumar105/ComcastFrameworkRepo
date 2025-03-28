package practice;


import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClassReal;

@Listeners(com.comcast.crm.listenerutility.ListenerImplementationClass.class)

public  class InvoiceTest extends BaseClassReal {
	@Test
	public void CreateInvoice()
	{
	System.out.println("execute CreateInvoice");
	String actTitle  =driver.getTitle();
	Assert.assertEquals(actTitle, "Login");
	System.out.println("step-1");
	System.out.println("step-2");
	System.out.println("step-3");
	System.out.println("step-4");
	
	
	
	
	}
	
	
	@Test
	public  void createInvoicewithContactTest()
	{
		System.out.println("execute CreateInvoice");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
		
	}

}
