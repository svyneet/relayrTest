package tests;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.GoogleDetailPage;
import pages.GooglePage;
import config.Test_Base;

public class GoogleSearchTest extends Test_Base {

	@BeforeClass
	public void setup() {
		this.configureBrowser();
	}

	@AfterClass
	public void cleanUp() {
		driver.close();
		driver.quit();
	}

	@BeforeMethod
	public void redirectToHome() {
		this.navigateToHomePage();
	}

	@Test
	public void verifySearchBarFunctionalityWithValidInputs() {
		
		GooglePage googlePage = new GooglePage(this.driver);
		GoogleDetailPage googleDetailPage = new GoogleDetailPage(this.driver);

		String valid = "relayr";
		ArrayList<String> listOfResults;
		implicitWait(1);
		googlePage.setGoogleSearchBoxValue(valid);
		googlePage.pressEnter();
		
		listOfResults = googleDetailPage.getGoogleSearchResults(); // contains the title of the results displayed on Google search page
		for(String result: listOfResults)
		{
			System.out.println(result);
			if(!result.toLowerCase().contains(valid))
				Assert.fail("The search results do not contain search term");
		}
	}
	

	@Test
	public void verifySearchBarFunctionalityWithInvalidInputs() {
		
		GooglePage googlePage = new GooglePage(this.driver);
		GoogleDetailPage googleDetailPage = new GoogleDetailPage(this.driver);

		String invalid = "2198379821 ewrsdlsaweioqr";
		implicitWait(1);
		googlePage.setGoogleSearchBoxValue(invalid);
		googlePage.pressEnter();
		implicitWait(2);
		Assert.assertTrue(googleDetailPage.getErrorMessage().contains(GoogleDetailPage.ErrorMessage.Suggestion));
		Assert.assertTrue(googleDetailPage.getErrorMessage().contains(GoogleDetailPage.ErrorMessage.Suggestion1));
		Assert.assertTrue(googleDetailPage.getErrorMessage().contains(GoogleDetailPage.ErrorMessage.Suggestion2));
		Assert.assertTrue(googleDetailPage.getErrorMessage().contains(GoogleDetailPage.ErrorMessage.Suggestion3));
		Assert.assertTrue(googleDetailPage.getErrorMessage().contains(GoogleDetailPage.ErrorMessage.Suggestion4));
		
	}

}
