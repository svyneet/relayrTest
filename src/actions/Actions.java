package actions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Actions{
	
	WebDriver driver;
	public Actions(WebDriver driver)
	{
		this.driver = driver;
 	}
	
	public void waitForElement(WebElement element) {
		
	    WebDriverWait wait = new WebDriverWait(driver,30);
	    try{
	    wait.until(ExpectedConditions.visibilityOf(element));
	    }
	    catch(Exception ex)
	    {
	    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    }
	}
	
	public void waitForElementToBeClickable(WebElement webElement) {
		
	    WebDriverWait wait = new WebDriverWait(driver,30);
	    try{
	    wait.until(ExpectedConditions.elementToBeClickable(webElement));
	    }
	    catch(Exception ex)
	    {
	    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    }
	}
	 
	
	public void pressEnter(WebElement element)
	{
		element.sendKeys(Keys.RETURN);
	}
	public void clearAndType(WebElement element, String data)
	{
		element.clear();
		element.sendKeys(data);
	}
	public void selectValueFromDropdown(WebElement element, String value)
	{
		Select select= new Select(element);		
		select.selectByVisibleText(value);
	}
	
	public String getAttributeValue(WebElement element)
	{
		return element.getAttribute("value");
	}
	
	
}
