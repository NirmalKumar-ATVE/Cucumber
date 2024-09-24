package PageObjects;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import CommonLibr.*;

public class AangifteFileUpload_Page extends BaseClass {
	
	private static By btnAddAangifte;
	private static By selectMonth;
	private static By selectYear;
	private static By btnAdd;
	private static By btnNxt;
	private static By spelDefinitionSelect;
	private static By selEnnOption;
	private static By Klasse;
	private static By attachmentUpload;
	private static By amount;
	
	private static By vergunningType;
	private static By LicenseNumer;
	private static By submitButton;
	private static By nextButton;
	private static By addButton;
	private static By aggreechkBox;
	private static By btnsubmit;
	private static By acceptBtn;
	


	public AangifteFileUpload_Page() {
		// TODO Auto-generated constructor stub
		genericLib = new GenericLib();
		bussLib = new BusinessLib();
		btnAddAangifte  = By.id("addAangifteButton");
		selectMonth = By.id("taxMonthSelect");
		selectYear = By.id("taxYearSelect");
		btnNxt = By.id("nextButtonId"); 
		btnAdd = By.id("add-spel-pofi-add-button");
		spelDefinitionSelect = By.id("spelDefinitionSelect");
		selEnnOption = By.xpath("//div[@class='mat-select-value']"); 
		Klasse = By.xpath("//span[contains(text(),'Klasse IV - Vast')]");
		attachmentUpload = By.id("attachmentUpload-file");
		amount = By.id("aangegevenInput");
		addButton = By.id("addButton");
		vergunningType  = By.id("vergunningType");
		LicenseNumer  = By.id("LicenseNumer");
		submitButton  = By.id("submitButton");
		nextButton  = By.id("nextButtonId");
		
		aggreechkBox  = By.id("confirmText");
		btnsubmit  = By.id("submit");
		acceptBtn = By.id("acceptBtn");
	}
	
	public static boolean clickAangifteButton() throws IOException{
		genericLib.clickbutton(btnAddAangifte);
		return true;
	}
	
	public static boolean selectMonth() throws Exception{
		Thread.sleep(2000);
		genericLib.selectByIndex(selectYear, "SelectYear", "2");
		Thread.sleep(1000);
		genericLib.selectByIndex(selectMonth, "selectMonth", "1");
		Thread.sleep(1000);
		return true;
	}
	
	public static boolean nextButton() throws Exception{
		genericLib.clickbutton(btnNxt);
		return true;
	}
	
	public static boolean addButton() throws Exception{
		genericLib.clickbutton(btnAdd);
		return true;
	}
	
	public static boolean spelDefinitionSelect() throws Exception{
		genericLib.selectByIndex(spelDefinitionSelect, "spelDefinitionSelect", "7");
		return true;
	}
	
	public static boolean Selectpdffile() throws Exception{
		selectFile();
		return true;
	}
	
	public static boolean uploadLisenceFile() throws Exception{
		UploadLisense();
		return true;
	}
	
	public static boolean clickCheckbox() throws Exception{
		genericLib.clickbutton(aggreechkBox);
		return true;
	}
	
	public static boolean clicksubmitbutton() throws Exception{
		genericLib.clickbutton(btnsubmit);
		return true;
	}
	
	public static boolean clickyesButton() throws Exception{
		genericLib.clickbutton(acceptBtn);
		Thread.sleep(500);
		genericLib.clickbutton(acceptBtn);
		return true;
	}
	
	

	
	
	
	public static void uploadFile() throws Exception{
		genericLib.clickbutton(btnAddAangifte);
		
	// Select Date
		genericLib.selectByIndex(selectYear, "SelectYear", "2");
		Thread.sleep(2000);
		genericLib.selectByIndex(selectMonth, "selectMonth", "0");
		Thread.sleep(1000);
		genericLib.clickbutton(btnNxt);
		
		genericLib.clickbutton(btnAdd);
		genericLib.selectByIndex(spelDefinitionSelect, "spelDefinitionSelect", "7");
		selectFile();
		UploadLisense();
		
	}
	
	public static void selectFile() throws Exception{
		
		genericLib.clickbutton(selEnnOption);
		genericLib.clickbutton(Klasse);
		bussLib.pressTab();
		bussLib.EnterThousand();
		bussLib.pressTab();
		bussLib.pressEnter();
		//genericLib.inputText(amount, "Amount", "aangegevenInput");
		//genericLib.clickbutton(attachmentUpload, "attachmentUpload");
		
		// FileLocation
		Runtime.getRuntime().exec("C:/Selenium/AutoIt/FileUpload.exe");
	
	}
	
	public static void UploadLisense() throws Exception{
		genericLib.clickbutton(addButton);
		
		genericLib.selectByIndex(vergunningType, "vergunningType", "1");
		Thread.sleep(1000);
		bussLib.pressTab();
		bussLib.EnterNumber();
		genericLib.clickbutton(submitButton);
		Thread.sleep(1000);
		genericLib.clickbutton(submitButton);
		genericLib.clickbutton(nextButton);		
		genericLib.clickbutton(nextButton);
//		genericLib.clickbutton(nextButton);
//		genericLib.clickbutton(nextButton);
//		genericLib.clickbutton(nextButton);
//		Thread.sleep(1000);
//		genericLib.clickbutton(nextButton);
		
	}
	
	
		

	
}
