package test.java.automation.workflow;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import test.java.automation.pageobjects.CartPage;
import test.java.automation.pageobjects.HomePage;
import test.java.automation.pageobjects.ItemPage;
import test.java.automation.pageobjects.RopaMenu;
import test.java.utils.DataUtils;
import test.java.utils.Log;
import test.java.utils.WebDriverUtils;

public class AddToCartWorkflow {

	private static final Logger logger = LoggerFactory.getLogger(AddToCartWorkflow.class);
	
	public static boolean accessWebSite(WebDriver driver) {
		String Url = DataUtils.getProperties().getProperty("Selenium.Data.Application");
		driver.get(Url);
		logger.info("Application accessed using URL [" + Url + "]");
		WebDriverUtils.saveScreenshotToFile(driver, "HomePage");
		return HomePage.validateHomePageLoad(driver);
	}
	
	public static boolean accessRopaMenu(WebDriver driver) {
		HomePage.getRopaMenu(driver).click();
		logger.info("Accessing Ropa Menu");
		WebDriverUtils.saveScreenshotToFile(driver, "RopaMenu");
		return HomePage.validateHomePageLoad(driver);
	}
	
	
	public static boolean accessItem(WebDriver driver, int itemOcurrence) {
		List<WebElement> itemList = RopaMenu.validateBannerExistance(driver) ? RopaMenu.getItemListBanner(driver) : RopaMenu.getItemList(driver) ;
		itemList.get(itemOcurrence).click();
		logger.info("Accessing Item [" + itemOcurrence + "] from item list");
		WebDriverUtils.saveScreenshotToFile(driver, "ItemPage");
		return HomePage.validateHomePageLoad(driver);
	}
	
	public static boolean selectSize(WebDriver driver) {
		ItemPage.getSizeDropdown(driver).click();
		ItemPage.getSizeToClick(driver).click();
		logger.info("Selecting size for Item");
		WebDriverUtils.saveScreenshotToFile(driver, "ItemPage_SizeSelected");
		ItemPage.getAddToCartButton(driver).click();
		ItemPage.waitForItemToBeAddedToCart(driver);
		logger.info("Adding Item to cart");
		WebDriverUtils.saveScreenshotToFile(driver, "ItemPage_AddToCartButton");
		return ItemPage.validateItemAddToCart(driver);
	}
	
	public static int checkCart(WebDriver driver) {
		HomePage.getCartMenu(driver).click();
		logger.info("Checking cart item count");
		WebDriverUtils.saveScreenshotToFile(driver, "ItemPage_SizeSelected");
		return CartPage.getItemListBanner(driver).size();
	}
}
