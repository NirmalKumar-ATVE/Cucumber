package PageObjects;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import CommonLibr.*;

public class HomePage extends BaseClass {
	
	private static By Meldaan;
	private static By eID;
	private static By userName;
	private static By password;
	private static By btnLogin;
	private static By btnAccecptAlert;
	
	


	public HomePage() {
		// TODO Auto-generated constructor stub
		genericLib = new GenericLib();
		Meldaan = By.xpath("//a[text()='Meld aan']");
		eID = By.xpath("//h3[text()='eID en aangesloten kaartlezer']");	
		userName = By.id("rrnr");
		password = By.id("kbo");
		btnLogin = By.xpath("//button[text()='Login']");
		btnAccecptAlert = By.id("acceptBtn");	
	}
	
	public static boolean clickMeldaan() throws Exception{
		genericLib.clickbutton(Meldaan);
		return true;
	}
	
	public static boolean clickEID() throws Exception{
		genericLib.clickbutton(eID);
		return true;
	}
	public static boolean enterEIDNumber(String eIDNumber) throws Exception{
		genericLib.inputText(userName, eIDNumber);
		return true;
	}
	public static boolean clickLogin() throws Exception{
		genericLib.clickbutton(btnLogin);
		return true;
	}
	public static boolean accecptAlert() throws Exception{
		genericLib.clickbutton(btnAccecptAlert);
		return true;
	}
}
