package PageObjects;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import CommonLibr.*;





public class LandingPage extends BaseClass {
	
	private static By Spelen;
	private static By email;
	private static By btnContinue;
	private static By password;
	private static By btnLogin;
	
	


	public LandingPage() {
		// TODO Auto-generated constructor stub
		genericLib = new GenericLib();
		Spelen  = By.xpath("//h5[text()='Ik wil een aangifte doen']/parent::div/parent::base-block-colored-header/following-sibling::base-block-content//a[@href='/ui/authenticated/sw/aangiften']");
		email = By.id("emailInput");	
		btnContinue  = By.id("continueBtn");
			
	}
	
	public static boolean clickSpelen() throws Exception{
		genericLib.clickbutton(Spelen);
		return true;
		
	} 
	
	public static boolean enterEMail(String EmailID) throws Exception{
		genericLib.inputText(email,EmailID);
		return true;
	}
	
	public static boolean clickContinue() throws Exception{
		genericLib.clickbutton(btnContinue);
		return true;
	}
		

	
}
