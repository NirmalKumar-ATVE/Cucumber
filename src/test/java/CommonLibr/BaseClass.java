package CommonLibr;

import org.openqa.selenium.WebDriver;
import org.testng.TestRunner;

import PageObjects.*;


public class BaseClass {

	public static WebDriver driver = null;
	public static Login_Page LoginPg = null;
	public static ConfigLibr configLib = null;
	public static GenericLib genericLib = null;
	public static BusinessLib bussLib = null;
	public static HomePage homePage;	
	public static LandingPage landingpage;
	public static AangifteFileUpload_Page addfile;
	public static TaxVerifyPage txVrfy;
	public static Aangiftes AangiftesPg;
	public static TestRunner runner;
	public static DVS_Pages dvsPages;
	
}
