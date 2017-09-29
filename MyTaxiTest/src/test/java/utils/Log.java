package test.java.utils;
import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Log {
	private static String currentLogFolder;
	
	public static void createLogDir(String name) {
		currentLogFolder = DataUtils.getProperties().getProperty("Selenium.Log.Folder") + name + "_" + DataUtils.getTimestamp();
		File file = new File(currentLogFolder);
		file.mkdir();
	}
			
	public static String getCurrentLogFolder() {
		return currentLogFolder;
	}
}
