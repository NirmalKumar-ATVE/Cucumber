package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.runtime.Utils;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.CucumberFeatureWrapper;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CommonLibr.BaseClass;
import CommonLibr.ConfigLibr;
import CommonLibr.GenericLib;

import java.io.File;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;



@CucumberOptions(features = "src/test/resources/features", glue = { "stepdefs", "serviceHooks" }, 
		// tags = {"~@Ignore"},

		format = { "pretty", "html:C:/Data/Flemish/Report/cucumber-reports/cucumber-pretty",
				"json:C:/Data/Flemish/Report/cucumber-reports/CucumberTestReport.json",
				"rerun:C:/Data/Flemish/Report/cucumber-reports/rerun.txt" }, monochrome = true)
public class Runner extends BaseClass {

	private static String environment;
	private static String browser;
	private static String app_url;
	private TestNGCucumberRunner testNGCucumberRunner;

	public Runner() {
		// TODO Auto-generated constructor stub
		genericLib = new GenericLib();
	}

	@BeforeSuite(alwaysRun = true)
	public static void init() {
		System.out.println("Init");
		configLib = new ConfigLibr();
		environment = configLib.Readconfig("Environment");
		browser = configLib.Readconfig("Browser");
		app_url = configLib.Readconfig(environment + "_url");
		
		System.out.println(app_url);

		try {
			if (browser.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"C:/Data/Flemish/Drivers/chromedriver.exe");
				DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				capabilities.setCapability("unexpectedAlertBehaviour", "ignore");
				capabilities.setCapability("nativeEvents", true);
				
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--incognito");
				capabilities.setCapability(ChromeOptions.CAPABILITY, options);
				driver = new ChromeDriver(capabilities);
				System.out.println(driver);
				driver.manage().window().maximize();
				driver.get(app_url);
			} else if (browser.equalsIgnoreCase("IE")) {
				System.setProperty("webdriver.ie.driver", "C:/IAS/Packages/Test_Libraries/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			} else if (browser.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver", "C:/Data/Flemish/Drivers/geckodriver.exe");
				driver = new FirefoxDriver();
				driver.get(app_url);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Before
	public void beforeScenario() {
		System.out.println("This will run before the Scenario");
	}

	@BeforeClass(alwaysRun = true)
	public void setUpClass() throws Exception {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}

	@Test(groups = "cucumber", description = "Runs Cucumber Feature", dataProvider = "features")
	public void feature(CucumberFeatureWrapper cucumberFeature) {
		testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	}

	/**
	 * @return returns two dimensional array of {@link CucumberFeatureWrapper}
	 *         objects.
	 */
	@DataProvider
	public Object[][] features() {
		return testNGCucumberRunner.provideFeatures();
	}

	@After
	public void embedScreenshot(Scenario scenario) {
		if (scenario.isFailed()) {
			try {
				System.out.println("Fails");
				scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES),
						"C:/Data/MicroService/Report/cucumber-reports/image.png");
			} catch (Exception e) {
				e.printStackTrace();
			}
			scenario.write(Utils.htmlEscape(driver.getPageSource()));
		}
	}

	@AfterClass(alwaysRun = true)
	public void tearDownClass() throws Exception {
		testNGCucumberRunner.finish();
	}

	@AfterSuite(alwaysRun = true)
	public void closeBroser() {
//		driver.close();
	}
}