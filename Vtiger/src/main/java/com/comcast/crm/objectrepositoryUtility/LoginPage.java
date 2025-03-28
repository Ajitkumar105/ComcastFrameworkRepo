package com.comcast.crm.objectrepositoryUtility;


/**
 * @author Ajit
 * 
 * 
 * Contains Login Page element & business library like Login()
 
 * */



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * ertyuiolkjuhytrf
 * **/

import com.comcast.crm.generic.webdriverutility.WebDriverUtility;


 
public class LoginPage extends WebDriverUtility  {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		
		this.driver=driver;
		
	
		
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	@FindBy(name="user_name")
	public WebElement usernameEdt;
	
	@FindBy(name="user_password")
	public WebElement passwordEdt;
	

	@FindBy(id="submitButton") 
	public WebElement loginButtonEdt;

//step: 4 object Encapsulation
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}


	public WebElement getPasswordEdt() {
		return passwordEdt;
	}


	public WebElement getLoginButtonEdt() {
		return loginButtonEdt;
	}
	
	//step :5 Bussiness Action
	/**
	 * login to application based on username, password ,url argument
	 * @param url
	 * @param username
	 * @param password
	 **/
	
	public void LoginToApp( String url,String username,String password) 
	{     
		
		driver.get(url);
		waitForPageLoad(driver);
		driver.manage().window().maximize();
		passwordEdt.sendKeys(username);
		usernameEdt.sendKeys(password);
		loginButtonEdt.click();
	}
	
	
	
	

}
