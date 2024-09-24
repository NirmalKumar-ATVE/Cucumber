package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import CommonLibr.BaseClass;
import CommonLibr.ConfigLibr;
import CommonLibr.GenericLib;

public class Login_Page extends BaseClass {

	private By userName;
	private By passWord;
	private By btnLogin;

	public Login_Page() {
		// TODO Auto-generated constructor stub

		configLib = new ConfigLibr();
		genericLib = new GenericLib();

		this.userName = By.id(configLib.ReadOR("Login_UserName"));
		this.passWord = By.id(configLib.ReadOR("Login_Password"));
		this.btnLogin = By.id(configLib.ReadOR("Login_btnLogin"));
	}

	public boolean enterUserName(String userName) throws Exception {
		genericLib.inputText(this.userName, userName);
		return true;
	}

	public boolean enterUserPassword( String passWord) throws Exception {
		genericLib.inputText(this.passWord, passWord);
		return true;
	}

	public boolean clickLogin() throws Exception {
		genericLib.clickbutton(this.btnLogin);
		return true;
	}

}
