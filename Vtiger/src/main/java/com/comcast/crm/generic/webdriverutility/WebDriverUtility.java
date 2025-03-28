package com.comcast.crm.generic.webdriverutility;



import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility
{
	
	public void waitForPageLoad(WebDriver driver)
	{
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
    public void waitForElementPresent(WebDriver driver ,WebElement  element)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		
		              wait.until(ExpectedConditions.visibilityOf(element));
	}
    
    
	public void  switchToTabBasedOnURL(WebDriver driver ,String partialURL)
	{
		 Set<String>set=driver.getWindowHandles();
         Iterator<String>it =set.iterator();
         while(it.hasNext())
         {
        	 String windowID=it.next();
        	 
        	 driver.switchTo().window(windowID);
        	 
        	 String actURL =driver.getCurrentUrl();
        	 if (actURL.contains(partialURL)) {
        		 
        		 break;
				
        	 }
         }
	}
	public void  switchToTabBasedOntitle(WebDriver driver ,String partialTitle)
	{
		 Set<String>set=driver.getWindowHandles();
         Iterator<String>it =set.iterator();
         while(it.hasNext())
         {
        	 String windowID=it.next();
        	 
        	 driver.switchTo().window(windowID);
        	 
        	 String actTitle =driver.getTitle();
        	 String actUrl =driver.getCurrentUrl();
        	// System.out.println("actual title :"+actTitle);
        	// System.out.println("actual url :"+actUrl);
        	 if (actTitle.contains(partialTitle)) {
        		 
        		 break;
				
        	 }
         }
}
	public void switchToFrame(WebDriver driver ,int index)
	{
		driver.switchTo().frame(index);
	}
	public void switchToFrame(WebDriver driver ,String nameID)
	{
		driver.switchTo().frame(nameID);
	}
	public void switchToFrame(WebDriver driver ,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	
	public void switchToAlerAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public void switchToAlertAndCancel(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}

	public void selectBytext(WebElement element,String text)
	{
		 Select sel=new Select(element);
		 sel.selectByVisibleText(text);
	}
	public void selectByValue(WebElement element,String value)
	{
		 Select sel=new Select(element);
		 sel.selectByVisibleText(value);
	}
	
	
	public void selectByIndex(WebElement element,int index)
	{
		 Select sel=new Select(element);
		 sel.selectByIndex(index);
	}
	public void mousemoveOnElement(WebDriver driver,WebElement element) 
	{
		
		Actions act=new Actions(driver);
		
		act.moveToElement(element).perform();
		
	}
	
	public void doubleclick(WebDriver driver,WebElement element)
	{
          Actions act=new Actions(driver);
		
		act.doubleClick(element).perform();
		            
	}
	
	
}
	
