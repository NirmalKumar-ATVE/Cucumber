package stepdefs;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import CommonLibr.BaseClass;
import PageObjects.AangifteFileUpload_Page;
import cucumber.api.java8.En;

public class AangifteFileUpload_steps extends BaseClass implements En{

	public AangifteFileUpload_steps() {
		
	
		addfile = new AangifteFileUpload_Page();

		Given("Click on addAangifte Button$", () -> {
			try {
				boolean result = addfile.clickAangifteButton();
				assertEquals(result, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		});

		When("Select Belastbare period from dropdown$", () -> {
			try {
				boolean result = addfile.selectMonth();
				assertEquals(result, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});

		Then("Click on volgende button$", () -> {
			boolean result;
			try {
				result = addfile.nextButton();
				assertEquals(result, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		When("Click on Spel of weddenschap toevoegen button$", () -> {
			boolean result;
			try {
				result = addfile.addButton();
				assertEquals(result, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});

		When("Select Spel definition type from dropdown$", () -> {
			boolean result;
			try {
				result = addfile.spelDefinitionSelect();
				assertEquals(result, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		When("Select pdf file$", () -> {
			boolean result;
			try {
				result = addfile.Selectpdffile();
				assertEquals(result, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});
		
		Then("Upload file lisence$", () -> {
			boolean result;
			try {
				result = addfile.uploadLisenceFile();
				assertEquals(result, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});
		
		When("Click on agree validate box$", () -> {
			boolean result;
			try {
				result = addfile.clickCheckbox();
				assertEquals(result, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		When("Click on submit button$", () -> {
			boolean result;
			try {
				result = addfile.clicksubmitbutton();
				assertEquals(result, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		When("Click on yes button$", () -> {
			boolean result;
			try {
				result = addfile.clickyesButton();
				assertEquals(result, true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		});

	}
}
