package serviceHooks;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import CommonLibr.BaseClass;
import CommonLibr.ConfigLibr;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends BaseClass {
	
	private static String environment;
	private static String app_url;
	
	@Before
    public void beforeScenario(){
		configLib = new ConfigLibr();
		environment = configLib.Readconfig("Environment");
		app_url = configLib.Readconfig(environment + "_url");
		}	
	
	@After
	public void tearDown(Scenario scenario) {
	    if (scenario.isFailed()) {
	      // Take a screenshot...
	      final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	      scenario.embed(screenshot, "image/png"); // ... and embed it in the report.
	    } else {
	    	 final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		      scenario.embed(screenshot, "image/png");
	    }
	}
}