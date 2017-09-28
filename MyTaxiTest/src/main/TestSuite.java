package main;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import automation.workflow.AddToCartWorkflow;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;

import ui.mapping.HomePage;
import utils.DataManipulation;
import utils.WebDriverUtils;

public class TestSuite {
	
	private WebDriver driver;
	
	@Before
	public void setUpClass(){
		System.setProperty("webdriver.chrome.driver", DataManipulation.getProperties().getProperty("Selenium.WebDriver.ChromeDriver.Folder"));
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	  }
	
	@Test
	public void addItemToCart() {
		driver.get("https://www.zalando.es/");

		try {
			
			WebDriverUtils.saveScreenshotToFile(driver, "testScreenShot");
		}
		catch(Exception e) {
			e.printStackTrace();
			Assert.fail("Main page could not be loaded");
		}
		
	}
}
