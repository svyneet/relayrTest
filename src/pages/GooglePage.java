package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actions.Actions;

public class GooglePage extends Actions {
	
	
	public GooglePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='q']")
	WebElement googleSearchBox;
	
	public String getGoogleSearchBoxValue()
	{
		waitForElement(googleSearchBox);
		return this.getAttributeValue(googleSearchBox);
	}
	
	public void setGoogleSearchBoxValue(String value)
	{
		clearAndType(googleSearchBox,value);
	}
	
	public void pressEnter()
	{
		pressEnter(googleSearchBox);
	}
}
