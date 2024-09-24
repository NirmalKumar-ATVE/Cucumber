package stepdefs;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import java.io.IOException;

import org.testng.TestRunner;
import org.testng.annotations.AfterMethod;

import CommonLibr.BaseClass;
import CommonLibr.BusinessLib;
import CommonLibr.ConfigLibr;
import PageObjects.HomePage;
import PageObjects.LandingPage;
import PageObjects.Login_Page;
import PageObjects.TaxVerifyPage;
import cucumber.api.Scenario;
import cucumber.api.java8.En;
//import cucumber.api.java.en.Given;

public class Login_Steps extends BaseClass implements En {

	String nationalNumber;
	String regNumber;
	String natioalID;
	String sourceFile;
	String DestinationFile;

	public Login_Steps() {
		txVrfy = new TaxVerifyPage();
		LoginPg = new Login_Page();
		homePage = new HomePage();
		bussLib = new BusinessLib();
		landingpage = new LandingPage();
		
		configLib = new ConfigLibr();
		natioalID = configLib.Readconfig("Environment");
		sourceFile = configLib.Readconfig("SourcePath");
		DestinationFile = configLib.Readconfig("DestinationPath");
		

		Given("Fetch Rijksregisternummer from database$", () -> {
			nationalNumber = bussLib.nationalID();
			regNumber = nationalNumber;
			bussLib.copyFile(sourceFile, DestinationFile);
			try {
				bussLib.replaceValueinText(DestinationFile, "NATIONAL_NUMBER", regNumber);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			assertNotNull(nationalNumber);
		});

		When("Click on Meldaan link$", () -> {
			try {
				boolean result = HomePage.clickMeldaan();
				assertEquals(result, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});

		Then("Click on eID en aangesloten kaartlezer link$", () -> {
			boolean result;
			try {
				result = HomePage.clickEID();
				assertEquals(result, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		Then("Enter Rijksregisternummer in to edit field$", () -> {
			boolean result;
			try {
				result = HomePage.enterEIDNumber(nationalNumber);
				assertEquals(result, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});

		Then("Click on Login button$", () -> {
			boolean result;
			try {
				result = HomePage.clickLogin();
				assertEquals(result, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		Then("click on OK button appear in info window$", () -> {
			boolean result;
			try {
				result = HomePage.accecptAlert();
				assertEquals(result, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});

		Given("Click on Spelen en Weddenschappen Link$", () -> {
			boolean result;
			try {
				result = landingpage.clickSpelen();
				assertEquals(result, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		

		When("Enter email address as$", () -> {
			boolean result;
			try {	
				result = landingpage.enterEMail("sanity.check@test.com");
				assertEquals(result, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		Then("Click on verdergaan button$", () -> {
			boolean result;
			try {
				result = landingpage.clickContinue();
				assertEquals(result, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		

	}

}
