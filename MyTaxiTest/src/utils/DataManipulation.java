package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.sun.jna.platform.win32.Sspi.TimeStamp;

import org.apache.commons.io.FileUtils;

public class DataManipulation {

	private static Properties properties = new Properties();
	
	static {
		InputStream input; 
		try {
			input = new FileInputStream("./properties/propertiesFile.properties");
			getProperties().load(input);
		}
		catch(Exception e) {
			System.out.println("Properties file couldn't be opened");
			System.out.println(e.toString());
		}
	}

	public static Properties getProperties() {
		return properties;
	}
	
	public static String getTimestamp() {
		Calendar calendar = Calendar.getInstance();
		
		return new SimpleDateFormat("yyyyMMddHHmmss").format(calendar.getTime());
	}
}
	
