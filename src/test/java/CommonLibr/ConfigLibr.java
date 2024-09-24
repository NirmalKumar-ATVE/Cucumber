package CommonLibr;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class ConfigLibr {
	public static String ConfigValue= null;

	public String Readconfig(String Value) {
		File file = new File("C:/Data/Flemish/TestConfiguration/config.properties");

		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();

		// load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			ConfigValue = prop.getProperty(Value);
		} catch (Exception e) {
			// TODO: handle exception
		}		
		return ConfigValue;
	}
	
	public String ReadOR(String Value) {
		File file = new File("src/test/resources/OR/objectRepo.properties");

		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();

		// load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			ConfigValue = prop.getProperty(Value);
		} catch (Exception e) {
			// TODO: handle exception
		}		
		return ConfigValue;
	}
	
	public String ReadTempValue(String filePath,String Value) {
		File file = new File(filePath);
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		// load properties file
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			ConfigValue = prop.getProperty(Value);
		} catch (Exception e) {
			// TODO: handle exception
		}		
		return ConfigValue;
	}
}
