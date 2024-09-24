package CommonLibr;

import java.awt.Dimension;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.sikuli.script.Screen;


public class BusinessLib extends BaseClass {

	private static PreparedStatement stmt = null;
	private static ResultSet rsltSet = null;
	private static Connection conn = null;
	private static String DBUserName = null;
	private static String DBUserPassword = null;
	private static String DBHostUrl = null;
	private static String environ = null;

	public BusinessLib() {
		// TODO Auto-generated constructor stub

		configLib = new ConfigLibr();
		environ = configLib.Readconfig("Environment");
		DBUserName = configLib.Readconfig(environ + "_DBName_UserName");
		DBUserPassword = configLib.Readconfig(environ + "_DBName_Password");
		DBHostUrl = configLib.Readconfig(environ + "_DBName_hostUrl");
	}

	public static String nationalID() {
		String nationalID = "";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(DBHostUrl, DBUserName, DBUserPassword);
			System.out.println(conn);
			// Prepare statement
			stmt = conn.prepareStatement("Alter session set current_schema = k_zone_e");
			rsltSet = stmt.executeQuery();
			// Query to get national id
			stmt = conn.prepareStatement(
					"select  a.PART_EXTN_IDFC_CD, a.part_id, c.naam from k_zone_e.kd_part_extn_idfc a, kd_pesn_naam c where a.EXTN_IDFC_TYPE_ID = 402 and a.part_id = c.part_id and  a.part_id not in (select organisator_part_id from kd_sw)  and length(a.part_id) < 18 and length(a.PART_EXTN_IDFC_CD) = 11 and a.PART_EXTN_IDFC_CD > 93012218746 and rownum < 2");
			rsltSet = stmt.executeQuery();
			rsltSet.next();
			System.out.println(rsltSet.getString("PART_EXTN_IDFC_CD"));
			// store national id
			nationalID = rsltSet.getString("PART_EXTN_IDFC_CD");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return nationalID;

	}

	public void pressTab() throws Exception {
		Robot rbt = new Robot();
		rbt.keyPress(KeyEvent.VK_TAB);
		Thread.sleep(800);
		rbt.keyRelease(KeyEvent.VK_TAB);
		Thread.sleep(800);
	}

	public void pressEnter() throws Exception {
		Robot rbt = new Robot();
		rbt.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(800);
		rbt.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(800);
	}

	public void newWindow() throws Exception {
		Robot rbt = new Robot();
		rbt.keyPress(KeyEvent.VK_CONTROL);
		Thread.sleep(200);
		rbt.keyPress(KeyEvent.VK_T);
		Thread.sleep(200);
		rbt.keyPress(KeyEvent.VK_T);
		Thread.sleep(200);
		rbt.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(200);
	}

	public void EnterNumber() throws Exception {
		Robot rbt = new Robot();
		rbt.keyPress(KeyEvent.VK_SHIFT);

		rbt.keyPress(KeyEvent.VK_1);
		Thread.sleep(200);
		rbt.keyRelease(KeyEvent.VK_1);
		Thread.sleep(200);
		rbt.keyPress(KeyEvent.VK_2);
		Thread.sleep(200);
		rbt.keyRelease(KeyEvent.VK_2);
		Thread.sleep(200);

		rbt.keyPress(KeyEvent.VK_3);
		Thread.sleep(200);
		rbt.keyRelease(KeyEvent.VK_3);
		Thread.sleep(200);
		rbt.keyPress(KeyEvent.VK_4);
		Thread.sleep(200);
		rbt.keyRelease(KeyEvent.VK_4);
		Thread.sleep(800);

		rbt.keyRelease(KeyEvent.VK_SHIFT);
		Thread.sleep(800);
	}

	public void EnterThousand() throws Exception {
		Robot rbt = new Robot();
		rbt.keyPress(KeyEvent.VK_SHIFT);
		rbt.keyPress(KeyEvent.VK_1);
		Thread.sleep(200);
		rbt.keyRelease(KeyEvent.VK_1);
		Thread.sleep(200);
		rbt.keyPress(KeyEvent.VK_0);
		Thread.sleep(200);
		rbt.keyRelease(KeyEvent.VK_0);
		Thread.sleep(200);

		rbt.keyPress(KeyEvent.VK_0);
		Thread.sleep(200);
		rbt.keyRelease(KeyEvent.VK_0);
		Thread.sleep(200);
		rbt.keyPress(KeyEvent.VK_0);
		Thread.sleep(200);
		rbt.keyRelease(KeyEvent.VK_0);
		Thread.sleep(200);
		rbt.keyPress(KeyEvent.VK_0);
		Thread.sleep(200);

		rbt.keyRelease(KeyEvent.VK_0);
		rbt.keyRelease(KeyEvent.VK_SHIFT);
		Thread.sleep(800);
	}

	public void replaceValueinText(String FilePath,String ActualValue,String ReplaceValue) throws IOException {
		String TxtVal = null;
		BufferedReader brr = new BufferedReader(new FileReader(FilePath));
		try {
			StringBuilder sbb = new StringBuilder();
			String line = brr.readLine();

			while (line != null) {
				sbb.append(line);
				sbb.append("\n");
				line = brr.readLine();
			}
			TxtVal = sbb.toString().replace(ActualValue, ReplaceValue);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			brr.close();
		}
		
		FileWriter writer= null;
		try {
			writer = new FileWriter(FilePath);
			writer.write(TxtVal);
			writer.flush();
			writer.close();
		} finally {
			// writer: handle finally clause
			writer.close();
		}
	}

	public void copyFile(String copyFilePath, String DestinationFilePath) {
		InputStream inStream = null;
		OutputStream outStream = null;

		try {

			File afile = new File(copyFilePath);
			File bfile = new File(DestinationFilePath);

			inStream = new FileInputStream(afile);
			outStream = new FileOutputStream(bfile);

			byte[] buffer = new byte[1024];

			int length;
			// copy the file content in bytes
			while ((length = inStream.read(buffer)) > 0) {

				outStream.write(buffer, 0, length);

			}

			inStream.close();
			outStream.close();

			System.out.println("File is copied successful!");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void refreshTillElementVisible(By by,String ExpectedVal,String ImageName,String ImageName1) throws Exception {
		// test.log(Status.INFO, "Wait until VISIBLE_TEXT is Enabled");
		try {
			
			do {
				
				genericLib.clickByImage(ImageName);
				Thread.sleep(3000);
				genericLib.clickByImage(ImageName1);
				Thread.sleep(2000);
			} while (!driver.findElement(by).getText().equals(ExpectedVal));		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
