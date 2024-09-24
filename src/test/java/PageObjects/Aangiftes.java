package PageObjects;

import java.io.IOException;

import org.openqa.selenium.By;

import CommonLibr.BaseClass;
import CommonLibr.BusinessLib;
import CommonLibr.ConfigLibr;
import CommonLibr.GenericLib;

public class Aangiftes extends BaseClass {

	private static By clmnYear;
	private static By clmnAangifteType;
	private static By btnAangiftes;
	private static By clmnStatus;
	private static By clmnTerInkohering;
	private static By rowOne;
	private static By imgGlass;
	private static By lblVergunningsNumber;
	private static By lblIndieningsdatum;
	private static By lblTypeaangifte;
	private static By lblAanslagjaar;
	private static By lblMaand;
	private static By lblAangiftenummer;
	private static By lblAangifteid;
	private static By lblBISnummer;
	private static By lblPartijid;
	private static By lblNaam;
	private static By lblStraat;
	private static By lblGemeente;
	private static By lblLand;
	private static By lblTypeadres;
	private static By lblStatus;
	private static By lblReferentieindiener; // Empty
	private static By btnSpelen;

	private static By clmnType;
	private static By clmnBelasbaar;
	private static By clmnKANSSPELINRICHTING;
	private static By clmnVergunningsType;
	private static By clmnVergunningsNumber;

	private static By lblAangegevenbedrag;
	private static By btnBerekening;

	private static By clmnBelasbaarBedget;
	private static By clmnRechten;

	public Aangiftes() {
		// TODO Auto-generated constructor stub
		genericLib = new GenericLib();
		bussLib = new BusinessLib();

		clmnYear = By.xpath("//table[@role='grid']//td[2]");
		clmnAangifteType = By.xpath("//table[@role='grid']//td[4]");
		btnAangiftes = By.xpath("//div[text()='Aangiftes']");
		clmnStatus = By.xpath("//table[@role='grid']//td[7]");
		clmnTerInkohering = By.xpath("//table[@role='grid']//td[8]");
		rowOne = By.xpath("//table[@role='grid']//tbody//tr[1]");
		imgGlass = By.xpath(
				"//img[@src='http://tax-int.fb.vlaanderen.be/vfp-menu/VAADIN/themes/vfp/icons/toolbar/view.png']");
		btnSpelen = By.xpath("//div[text()='Spelen en weddenschappen']");
		clmnType = By.xpath("//div[text()='TYPE']/parent::th/parent::tr/parent::thead/following-sibling::tbody//td[1]");
		clmnBelasbaar = By
				.xpath("//div[text()='TYPE']/parent::th/parent::tr/parent::thead/following-sibling::tbody//td[2]");
		clmnKANSSPELINRICHTING = By.xpath(
				"//div[text()='KANSSPELINRICHTING']/parent::th/parent::tr/parent::thead/following-sibling::tbody//td[1] ");
		clmnVergunningsType = By.xpath(
				"//div[text()='VERGUNNINGSTYPE']/parent::th/parent::tr/parent::thead/following-sibling::tbody//td[1]");
		clmnVergunningsNumber = By.xpath(
				"//div[text()='VERGUNNINGSTYPE']/parent::th/parent::tr/parent::thead/following-sibling::tbody//td[2]");

		btnBerekening=By.xpath("//div[text()='Berekening']");
	}

	public static boolean clickAagniftes() throws Exception {
		genericLib.clickByImage("Agngiftes");
		Thread.sleep(2000);
		return true;
	}

	public boolean ValidateOverzichtaangiftes(String Aangifte, String status, String inkohiering) throws Exception {
		boolean result = genericLib.VerifyText(Aangifte, clmnAangifteType);
		
		bussLib.refreshTillElementVisible(clmnStatus,"Controle OK", "Dossier", "Agngiftes");
		boolean result1 = genericLib.VerifyText(status, clmnStatus);
		bussLib.refreshTillElementVisible(clmnTerInkohering,"Ja", "Dossier", "Agngiftes");
		boolean result2 = genericLib.VerifyText(inkohiering, clmnTerInkohering);
		if ((result1 == true) && (result == true) && (result2 == true)) {
			result = true;
		} else
			result = false;
		return result;
	}

	public boolean selectRow() throws Exception {
		genericLib.clickElement(rowOne);
		return true;
	}


	public boolean clickGlassIcon() throws Exception {
		genericLib.clickifExist(imgGlass);
		return true;
	}

	public boolean clickSpelen() throws Exception {
		genericLib.clickifExist(btnSpelen);
		return true;
	}

	public boolean validateorganisatorfields(String fieldValue) {
		boolean result = false;
		String[] value = fieldValue.split(",");
		for (int i = 0; i < value.length; i++) {
			By xpath = By.xpath(
					"//div[text()='" + value[i] + "']/parent::div/parent::div/parent::div/following-sibling::div[1]");
			result = genericLib.VerifyNotNull(xpath);
			if (result == false) {
				result = false;
				break;
			} else
				result = true;
		}
		return result;

	}

	public boolean ValidateTypeAmount(String AangifteType) throws Exception {
		boolean result = genericLib.VerifyText(AangifteType, clmnType);
		boolean result1 = genericLib.VerifyText("10 000,00", clmnBelasbaar);
		if ((result1 == true) && (result == true)) {
			result = true;
		} else
			result = false;
		return result;
	}

	public boolean validateKanspelinrichting(String Kanspelinrichting) {
		boolean result = genericLib.VerifyText(Kanspelinrichting, clmnKANSSPELINRICHTING);
		return result;
	}
	
	public boolean validateVergunningstype(String Vergunningstype) {
		boolean result = genericLib.VerifyText(Vergunningstype, clmnVergunningsType);
		return result;
	}
	
	public boolean clickbtnBerekening() throws IOException {
		genericLib.clickbutton(btnBerekening);
		return true;
	}

}
