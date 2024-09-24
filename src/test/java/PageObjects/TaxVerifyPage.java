package PageObjects;

import org.openqa.selenium.By;

import CommonLibr.BaseClass;
import CommonLibr.BusinessLib;
import CommonLibr.ConfigLibr;
import CommonLibr.GenericLib;

public class TaxVerifyPage extends BaseClass {

	private static String environment;
	private static String browser;
	private static String app_url;
	private static String userName;
	private static String passWord;

	private static By txtLogin;
	private static By txtpass;
	private static By btnlogin;
	private static By txtnationalNumber;
	private static By btnSearch;
	private static By lblEmail;
	private static By lblVergunningsType;
	private static By lblVergunningsNumber;
	
	private static By lblPartijid;
	private static By lblNaam;
	private static By lblStraat;
	private static By lblGemeente;
	private static By lblLand;
	private static By lblTypeadres;
	private static By Status;

	public TaxVerifyPage() {
		// TODO Auto-generated constructor stub
		genericLib = new GenericLib();
		bussLib = new BusinessLib();

		configLib = new ConfigLibr();
		
	

		txtLogin = By.xpath("//input[@class='v-textfield v-widget']");
		txtpass = By.xpath("//input[@type='password']");
		btnlogin = By.id("loginButton");
		txtnationalNumber = By.xpath(
				"//div[text()='RR/BIS/KBO-nummer:']/parent::div/parent::div/parent::div/following-sibling::div[1]//input");
		btnSearch = By.xpath("//span[text()='Zoeken']/parent::span/parent::div");
		lblEmail = By.xpath("//div[text()='Email:']/parent::div/parent::div/parent::div/following-sibling::div[1]");
		lblVergunningsType = By.xpath("//table[@role='grid']//td[1]");
		lblVergunningsNumber = By.xpath("//table[@role='grid']//td[2]");

		configLib = new ConfigLibr();
		environment = configLib.Readconfig("Environment");
		app_url = configLib.Readconfig(environment + "_Taxurl");
		userName = configLib.Readconfig(environment +"_UserName");
		passWord = configLib.Readconfig(environment +"_Password");

	}

	public static boolean openNewTab() throws Exception {
		bussLib.newWindow();
		genericLib.selectWindow();
		driver.get(app_url);
		return true;
	}

	public boolean logintoTaxApplication() throws Exception {
		genericLib.inputText(txtLogin, userName);
		genericLib.inputText(txtpass, passWord);
		genericLib.clickifExist(btnlogin);
		return true;
	}

	public boolean enterRegNum(String RegNumber) throws Exception {
		genericLib.inputText(txtnationalNumber, RegNumber);
		return true;
	}

	public boolean clickSearch() throws Exception {
		//genericLib.clickifExist(btnSearch);
		genericLib.clickByImage("Search");
		return true;
	}

	public boolean validateEmail(String email) {
		boolean result = genericLib.VerifyText(email, lblEmail);
		return result;
	}

	public boolean validateVergunningsTypeNumber(String VergunningsType, String Vergunningsnummer) {
		boolean result = genericLib.VerifyText(VergunningsType, lblVergunningsType);
		boolean result1 = genericLib.VerifyText(Vergunningsnummer, lblVergunningsNumber);
		if ((result1 == true) && (result == true)) {
			result = true;
		} else
			result = false;
		return result;
	}
	
	public boolean validateorganisatorfields(String fieldValue) {
		boolean result = false;
		String[] value = fieldValue.split(",");
		for (int i = 0; i < value.length; i++) {
			By xpath = By.xpath("//div[text()='"+value[i]+"']/parent::div/parent::div/parent::div/following-sibling::div[1]");
			result = genericLib.VerifyNotNull(xpath);
			if (result==false) {
				result = false;
				break;
			} else
				result = true;
		}
		return result;

	}

}
