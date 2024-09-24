package stepdefs;

import static org.testng.Assert.assertEquals;

import CommonLibr.BaseClass;
import CommonLibr.ConfigLibr;
import PageObjects.AangifteFileUpload_Page;
import PageObjects.Aangiftes;
import PageObjects.DVS_Pages;
import PageObjects.TaxVerifyPage;
import cucumber.api.java8.En;

public class DVS_Steps extends BaseClass implements En {
	
	
	public DVS_Steps() {

		
		configLib = new ConfigLibr();
		dvsPages = new DVS_Pages();
		
		

		Given("Launch dvs application$", () -> {
			try {
				boolean result = dvsPages.openNewTab();
				assertEquals(result, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});
		
		Then("Enter National Number$", () -> {
			try {
				boolean result = dvsPages.enterNationalID(configLib.ReadTempValue(configLib.Readconfig("DestinationPath"),"NationalID"));
				assertEquals(result, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});
		
		Then("Click search Icon$", () -> {
			try {
				boolean result = dvsPages.clickSearch();
				assertEquals(result, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});
		
		Then("Click on dossier Number$", () -> {
			try {
				boolean result = dvsPages.ClickdossierLnk();
				assertEquals(result, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});
		
		Then("wait for document upload$", () -> {
			try {
				boolean result = dvsPages.waitTillDocumentUpload();
				assertEquals(result, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});
		
		Then("Click on Document$", () -> {
			try {
				boolean result = dvsPages.ClickDocumentUpload();
				assertEquals(result, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});


	}
}
