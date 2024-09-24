package PageObjects;

import org.openqa.selenium.By;
import org.sikuli.script.FindFailed;

import CommonLibr.BaseClass;
import CommonLibr.BusinessLib;
import CommonLibr.ConfigLibr;
import CommonLibr.GenericLib;

public class DVS_Pages extends BaseClass {

	private static String environment;
	private static String browser;
	private static String app_url;
	private static By txtnationalID;
	private static By btnSearchIcon;
	private static By clkDossierNum;
	private static By lblVergunningsType;
	private static By lblVergunningsNumber;
	
	private static By lblPartijid;
	private static By lblNaam;
	private static By lblStraat;
	private static By lblGemeente;
	private static By lblLand;
	private static By lblTypeadres;
	private static By Status;

	public DVS_Pages() {
		// TODO Auto-generated constructor stub
		genericLib = new GenericLib();
		bussLib = new BusinessLib();

		configLib = new ConfigLibr();

		
		txtnationalID = By.xpath(
				"//div[text()='RR of KBO nr (start met):']/parent::div/parent::div/parent::div/following-sibling::div[1]//input");
		btnSearchIcon = By.xpath("//img[@src='http://cb-int.fb.vlaanderen.be/cb-dvs/VAADIN/themes/vfp/icons/toolbar/search.png']");
		clkDossierNum = By.xpath("//table[@class='v-table-table']//tr[1]//td[2]");
		
		lblVergunningsType = By.xpath("//table[@role='grid']//td[1]");
		lblVergunningsNumber = By.xpath("//table[@role='grid']//td[2]");

		configLib = new ConfigLibr();
		environment = configLib.Readconfig("Environment");
		app_url = configLib.Readconfig(environment + "_DVSurl");

	}

	public static boolean openNewTab() throws Exception {
		bussLib.newWindow();
		genericLib.selectWindow();
		driver.get(app_url);
		return true;
	}

	public boolean enterNationalID(String Number) throws Exception {
		genericLib.inputText(txtnationalID, Number);	
		return true;
	}


	public boolean clickSearch() throws Exception {
		//genericLib.clickifExist(btnSearch);
		genericLib.clickUntilelementVisible(btnSearchIcon,clkDossierNum);
		return true;
	}

	public boolean ClickdossierLnk() throws Exception {
		genericLib.clickElement(clkDossierNum);
		return true;
	}

	public boolean waitTillDocumentUpload() throws Exception{
		genericLib.WaitByImage("Documentation");
		return true;
	}
	
	public boolean ClickDocumentUpload() throws Exception{
		genericLib.clickByImage("Documentation");
		return true;
	}
}
