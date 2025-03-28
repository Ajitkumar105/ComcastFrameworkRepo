package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClassReal;

public class NetworkTest extends BaseClassReal {
	@Test(retryAnalyzer = com.comcast.crm.listenerutility.RetryListenerImplementationClass.class)
	public void activateSim()
	{
		System.out.println("execute ActivatesimTest");
	
		//Assert.assertEquals("", "Login");
		System.out.println("step-1");
		System.out.println("step-2");
		System.out.println("step-3");
		System.out.println("step-4");
	}

}
