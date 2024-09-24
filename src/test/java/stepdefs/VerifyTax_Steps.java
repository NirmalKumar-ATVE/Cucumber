package stepdefs;

import static org.testng.Assert.assertEquals;

import CommonLibr.BaseClass;
import CommonLibr.ConfigLibr;
import PageObjects.AangifteFileUpload_Page;
import PageObjects.Aangiftes;
import PageObjects.TaxVerifyPage;
import cucumber.api.java8.En;

public class VerifyTax_Steps extends BaseClass implements En {
	
	
	public VerifyTax_Steps() {
		txVrfy = new TaxVerifyPage();
		AangiftesPg = new Aangiftes();
		
		configLib = new ConfigLibr();
		
		

		Given("Open new tab$", () -> {
			try {
				boolean result = txVrfy.openNewTab();
				assertEquals(result, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});

		When("Login in to Tax application", () -> {
			try {
				boolean result = txVrfy.logintoTaxApplication();
				assertEquals(result, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});
		
		Then("Fill in RR/KBO/BIS-nummer$", () -> {
			boolean result;
			try {				
				result = txVrfy.enterRegNum(configLib.ReadTempValue(configLib.Readconfig("DestinationPath"),"NationalID"));
				assertEquals(result, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		Then("Click on zoeken button$", () -> {
			boolean result;
			try {
				result = txVrfy.clickSearch();
				assertEquals(result, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		Then("validate Email is '(.*)'$", (String email) -> {
			boolean result;
			try {
				result = txVrfy.validateEmail(email);
				assertEquals(result, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});

		Then("validate Vergunningstype is '(.*)' and Vergunningsnummer$", (String Vergunningstype) -> {
			boolean result;
			try {
				result = txVrfy.validateVergunningsTypeNumber(Vergunningstype, "1234");
				assertEquals(result, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		Then("validate organisator fields of '(.*)' are filled in Dossier page$", (String organisatorfields) -> {
			boolean result;
			try {
				result = txVrfy.validateorganisatorfields(organisatorfields);
				assertEquals(result, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		Then("Click on Aangifte tab$", () -> {
			boolean result;
			try {
				result = AangiftesPg.clickAagniftes();
				assertEquals(result, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});

		When("validate Aangifte type is '(.*)' Status is '(.*)' and Aangeboden ter inkohiering is '(.*)'$",
				(String Aangifte, String status, String inkohiering) -> {
					boolean result;
					try {
						result = AangiftesPg.ValidateOverzichtaangiftes(Aangifte, status, inkohiering);
						assertEquals(result, true);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});

		Then("select the row$", () -> {
			boolean result;
			try {
				result = AangiftesPg.selectRow();
				assertEquals(result, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		Then("Click glass Icon$", () -> {
			boolean result;
			try {
				result = AangiftesPg.clickGlassIcon();
				assertEquals(result, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		When("validate information is filled in in detail van de aangifte in detail van de aangifte of$",
				(String Value) -> {
					boolean result;
					try {
						result = AangiftesPg.validateorganisatorfields(Value);
						assertEquals(result, true);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				});

		Then("Click on spelen button$", () -> {
			boolean result;
			try {
				result = AangiftesPg.clickSpelen();
				assertEquals(result, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

//		Then("Click on spenlen button$", () -> {
//			boolean result;
//			try {
//				result = AangiftesPg.clickSpelen();
//				assertEquals(result, true);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		});

		Then("validate type is '(.*)' in spelen en weddenschappen$", (String AangifteType) -> {
			boolean result;
			try {
				result = AangiftesPg.ValidateTypeAmount(AangifteType);
				assertEquals(result, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		Then("validate Kanspelinrichting is '(.*)' in Kansspelinrichting$", (String Kanspelinrichting) -> {
			boolean result;
			try {
				result = AangiftesPg.validateKanspelinrichting(Kanspelinrichting);
				assertEquals(result, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		Then("validate Vergunningstype is '(.*)' in vergunninsinformatie$", (String Vergunningstype) -> {
			boolean result;
			try {
				result = AangiftesPg.validateVergunningstype(Vergunningstype);
				assertEquals(result, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		Then("Click on Berekening button$", () -> {
			boolean result;
			try {
				result = AangiftesPg.clickbtnBerekening();
				assertEquals(result, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		Then("Close Current Browser$", () -> {
			try {	
				driver.close();
				genericLib.switchDefault();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		});

	}
}
