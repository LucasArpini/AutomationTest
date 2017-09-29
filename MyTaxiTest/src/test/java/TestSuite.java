package test.java;

import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import test.java.automation.workflow.AddToCartWorkflow;
import test.java.utils.DataUtils;
import test.java.utils.Log;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;

public class TestSuite {
	
	private static final Logger logger = LoggerFactory.getLogger(AddToCartWorkflow.class);
	private WebDriver driver;
	
	@Rule
	public TestRule watcher = new TestWatcher() {
	   protected void starting(Description description) {
		   Log.createLogDir(description.getMethodName());
	   }
	};
	
	@Before
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", DataUtils.getProperties().getProperty("Selenium.WebDriver.ChromeDriver.Folder"));
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	  }
	
	@After
	public void cleanUp() {
		driver.close();
	}
	
	@Test
	public void addItemToCart() {
		int numberOfItems = Integer.parseInt(DataUtils.getProperties().getProperty("Selenium.Data.NumberOfItemsToAdd"));
		Assert.assertTrue("Failed to load Homepage", AddToCartWorkflow.accessWebSite(driver));
		for(int i=0;i<numberOfItems;i++) {
			Assert.assertTrue("Failed to access Ropa Menu page", AddToCartWorkflow.accessRopaMenu(driver));
			Assert.assertTrue("Failed to access item [" + i + "] on item list", AddToCartWorkflow.accessItem(driver,i));
			Assert.assertTrue("Failed to add item number [" + i + "] to cart",AddToCartWorkflow.selectSize(driver));
		}
		int itemsInCart = AddToCartWorkflow.checkCart(driver);
		Assert.assertTrue("Number of items in cart [" + itemsInCart + "] differs from the expected [" + numberOfItems + "]",Integer.compare(itemsInCart,numberOfItems)==0);
		logger.info("Test Case addItemToCart completed successfully");
	}
}
