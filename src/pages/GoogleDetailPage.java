package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import actions.Actions;

public class GoogleDetailPage  extends Actions {
	
	public ArrayList<String> searchResultsInString = new ArrayList<String>();
	
	public GoogleDetailPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[@name='btnG']")
	public WebElement searchButton;
	
	@FindBy(xpath = "//div[@class='rc']//h3[@class='r']")
	public List<WebElement> searchResults;

	//Error Messages displayed on invalid input
	@FindBy(xpath = "//div[@class='med card-section']")
	public WebElement errorMessages;
	
	
	public ArrayList<String> getGoogleSearchResults()
	{
		waitForElement(searchButton);
		for (WebElement x: searchResults)
			searchResultsInString.add(x.getText());
		return searchResultsInString;
	}
	
	public String getErrorMessage()
	{
		return errorMessages.getText();
	}
	
	public static class ErrorMessage{
		public static String Suggestion= "Suggestions:";
		public static String Suggestion1= "Make sure that all words are spelled correctly.";
		public static String Suggestion2= "Try different keywords.";
		public static String Suggestion3= "Try more general keywords.";
		public static String Suggestion4= "Try fewer keywords.";
	}
	
	

}
