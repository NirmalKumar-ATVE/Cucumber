package CommonLibr;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Screen;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import cucumber.api.Scenario;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

public class GenericLib extends BaseClass {

	public static BufferedWriter bufferRead = null;
	public static FileWriter fileWriter = null;

	public GenericLib() {
		// TODO Auto-generated constructor stub
	}

	// Get Text
	public String getText(By by, String elementname) throws Exception {
		String textVal = "";
		try {

			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			WebElement e1 = driver.findElement(by);
			System.out.println(e1);
			if (e1.isDisplayed()) {
				textVal = e1.getAttribute("value");
				System.out.println(textVal);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return textVal;
	}

	// Enter Value in edit field
	public void inputText(By by, String data) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 45);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
				Actions actions = new Actions(driver);
				actions.moveToElement(e1).click().build().perform();
				e1.clear();
				e1.sendKeys(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean chkVisible(By by) throws IOException {
		// Click Button
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	// Random String
	public String generateString() {
		String strRandom = "";
		String strNumbers = "abcdefghijklmnopqrstuvwxyzacvbe";
		Random rnd = new Random();
		StringBuilder strRandomNumber = new StringBuilder(9);
		for (int i = 0; i < 6; i++)
			strRandomNumber.append(strNumbers.charAt(rnd.nextInt(strNumbers.length())));
		strRandom = strRandomNumber.toString() + "7";
		return strRandom;
	}

	// Click Button
	public void clickbutton(By by) throws IOException {
		// Click Button
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, 45);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));

			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
				js.executeScript("arguments[0].click();", e1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Click Button
	public void clickifExist(By by) throws IOException {
		// Click Button
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			Thread.sleep(1000);
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
				js.executeScript("arguments[0].click();", e1);
			} else {

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Click Link
	public void clickLink(By by, String elementname) throws IOException {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, 45);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
				e1.click();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void clickByImage(String fileName) throws FindFailed, Exception {
		Screen s = new Screen();
		String FileName = "C:/Data/Flemish/Image/" + fileName + ".PNG";
		Thread.sleep(1000);
		s.find(FileName);
		s.click(FileName);
	}

	public void WaitByImage(String fileName) throws FindFailed, Exception {
		Screen s = new Screen();
		String FileName = "C:/Data/Flemish/Image/" + fileName + ".PNG";

		do {
			Thread.sleep(1000);
		} while (s.exists(FileName) != null);

	}

	// Click Element
	public void clickElement(By by) throws IOException {
		try {
			// test.log(Status.INFO, "Click on" + elementname);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, 45);

			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
				e1.click();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clickUntilelementVisible(By by, By by1) throws IOException {
		try {
			// test.log(Status.INFO, "Click on" + elementname);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, 45);

			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {

				do {
					e1.click();
					Thread.sleep(5000);
				} while (!driver.findElement(by).isDisplayed());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void closeBrowser() throws Exception {
		try {
			driver.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void closeAllBrowser() throws Exception {
		try {
			driver.quit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void confirmAlert() throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alt = driver.switchTo().alert();
			Thread.sleep(1000);
			alt.accept();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void dismissAlert() throws Exception {

		try {
			WebDriverWait wait = new WebDriverWait(driver, 45);
			wait.until(ExpectedConditions.alertIsPresent());
			Alert alt = driver.switchTo().alert();
			Thread.sleep(1000);
			alt.dismiss();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
	}

	public void doubleClick(By by, String elementname) throws Exception {
		try {
			// test.log(Status.INFO, "Double click on" + elementname);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, 45);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
				Actions builder = new Actions(driver);
				builder.doubleClick(e1).perform();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void reloadPage() throws Exception {
		// Refresh
		try {
			driver.navigate().refresh();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void selectCheckbox(By by, String elementname) throws Exception {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, 45);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
				if (e1.isSelected()) {

				} else {
					e1.click();
					Thread.sleep(2000);

				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void unselectCheckbox(By by, String elementname) throws Exception {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, 45);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
				if (e1.isSelected()) {
					e1.click();
					Thread.sleep(2000);

				} else {

				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void selectByIndex(By by, String elementname, String data) throws Exception {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, 45);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			// wait.until(ExpectedConditions.elementToBeSelected(by));
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
				Select se = new Select(e1);
				int val = Integer.parseInt(data);
				se.selectByIndex(val);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void unselectByIndex(By by, String elementname, String data) throws Exception {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, 45);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			wait.until(ExpectedConditions.elementToBeSelected(by));
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
				Actions actions = new Actions(driver);
				actions.moveToElement(e1).click().perform();
				Select se = new Select(e1);
				int val = Integer.parseInt(data);
				se.deselectByIndex(val);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectByText(By by, String elementname, String data) throws Exception {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
				Select se = new Select(e1);
				se.selectByVisibleText(data);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void unselectByText(By by, String elementname, String data) throws Exception {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			wait.until(ExpectedConditions.elementToBeSelected(by));
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
				Actions actions = new Actions(driver);
				actions.moveToElement(e1).click().perform();
				Select se = new Select(e1);
				se.deselectByVisibleText(data);

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void unselectAll(By by, String elementname, String data) throws Exception {
		try {

			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, 45);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			wait.until(ExpectedConditions.elementToBeSelected(by));
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
				Actions actions = new Actions(driver);
				actions.moveToElement(e1).click().perform();
				Select se = new Select(e1);
				se.deselectAll();
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void verifyTitle(String Text) throws Exception {
		try {
			// test.log(Status.INFO, "Verify title of page is" + Text);
			if (driver.getTitle().contains(Text)) {

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean VerifyText(String Expected, By by) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, 45);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		String Actual = driver.findElement(by).getText();
		if (Actual.equalsIgnoreCase(Expected)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean VerifyNotNull(By by) {
		String Actual = driver.findElement(by).getText();
		if ((Actual.equals(null)) || (Actual.equals(""))) {
			return false;
		} else {
			return true;
		}
	}

	public void verifyApps(String Expected, By by) {

		try {
			String Actual = driver.findElement(by).getText();
			String[] splitActual = Actual.split("iiams-applications:");
			System.out.println("Actual: " + splitActual[1].trim());
			if (splitActual[1].trim().equalsIgnoreCase(Expected)) {
			} else {
			}
		} catch (Exception e) {

		}
	}

	public void Verifyurl(String Expected) throws IOException {
		try {
			String currenturl;
			for (int i = 1; i < 120; i++) {
				Thread.sleep(1000);
				currenturl = driver.getCurrentUrl();
				if (currenturl.contains(Expected)) {
					break;
				}
			}
			currenturl = driver.getCurrentUrl();
			if (currenturl.contains(Expected)) {

			} else {

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectByValue(By by, String elementname, String data) throws Exception {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, 45);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			wait.until(ExpectedConditions.elementToBeSelected(by));
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
				Select se = new Select(e1);
				se.selectByVisibleText(data);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void unselectByValue(By by, String elementname, String data) throws Exception {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, 45);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			wait.until(ExpectedConditions.elementToBeSelected(by));
			WebElement e1 = driver.findElement(by);
			if (e1.isDisplayed()) {
				Actions actions = new Actions(driver);
				actions.moveToElement(e1).click().perform();
				Select se = new Select(e1);
				se.deselectByValue(data);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void selectWindow() throws Exception {
		try {
			// To handle all new opened window.
			Set<String> s1 = driver.getWindowHandles();
			Iterator<String> i1 = s1.iterator();

			while (i1.hasNext()) {
				String ChildWindow = i1.next();

				// Switching to Child window
				driver.switchTo().window(ChildWindow);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void switchDefault() throws Exception {
		// Switch Default Window
		try {
			// test.log(Status.INFO, "Switch Default Window");
			driver.switchTo().defaultContent();
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void frameByIndex(int Input) throws Exception {
		try {
			// test.log(Status.INFO, "Switch in to Frame");
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(Input));
			driver.switchTo().frame(Input);
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void frameByelement(By by) throws Exception {
		try {
			// test.log(Status.INFO, "Switch in to Frame");
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by));
			WebElement e1 = driver.findElement(by);
			driver.switchTo().frame(e1);
			Thread.sleep(2000);

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void waitTillElementEnable(By by, String elementName) throws Exception {
		// test.log(Status.INFO, "Wait until VISIBLE_TEXT is Enabled");
		try {
			WebDriverWait wait = new WebDriverWait(driver, 45);
			wait.until(ExpectedConditions.elementToBeClickable(by));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	// public void waitTillElementVisible(By by, String elementName) throws
	// Exception {
	// // test.log(Status.INFO, "Wait until VISIBLE_TEXT is Enabled");
	// try {
	// WebDriverWait wait = new WebDriverWait(driver, 45);
	// wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	// // test.log(Status.PASS, elementName + " is enabled in the page");
	// } catch (Exception e) {
	// // TODO: handle exception
	// // test.fail("Screenshot below: " +
	// // test.addScreenCaptureFromPath(takeScreenShot("VISIBLE_TEXTWait")));
	// // test.log(Status.FAIL, elementName + "is not-enabled in the
	// // page");
	// e.printStackTrace();
	// }
	// }

	public void waitTillTextVisible(By by, String elementName) throws Exception {
		boolean val = false;
		try {
			for (int i = 0; i < 100; i++) {
				val = this.VerifyText(elementName, by);
				if (val == true) {
					break;
				} else
					Thread.sleep(1000);

			}

		} catch (Exception e) {
			// TODO: handle exception
			// test.fail("Screenshot below: " +
			// test.addScreenCaptureFromPath(takeScreenShot("VISIBLE_TEXTWait")));
			// test.log(Status.FAIL, elementName + "is not-enabled in the
			// page");
			e.printStackTrace();
		}
	}

	public boolean waitTillAdPopup(By by) throws Exception {
		// test.log(Status.INFO, "Wait until VISIBLE_TEXT is Enabled");
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void writeNodePad(String notepad, String content) {
		try {
			fileWriter = new FileWriter(notepad);
			bufferRead = new BufferedWriter(fileWriter);
			bufferRead.write(content);
			System.out.println("Done");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferRead != null)
					bufferRead.close();
				if (fileWriter != null)
					fileWriter.close();
			} catch (IOException ex) {
				ex.printStackTrace();

			}
		}
	}

	public void newTab() throws AWTException, InterruptedException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(500);
		robot.keyPress(KeyEvent.VK_T);
		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_T);
		Thread.sleep(500);
		robot.keyRelease(KeyEvent.VK_CONTROL);

		// Actions actions = new Actions(driver);
		// actions.keyDown(Keys.CONTROL).sendKeys("t").keyUp(Keys.CONTROL).perform();
	}

	public void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
	}

	public File takeScreenShot(Scenario methodName) {
		String path = "C:/Data/MicroService/Report\\" + methodName + ".png";
		File screenshotFile = null;
		try {
			screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(screenshotFile, new File(path));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return screenshotFile;
	}
}
