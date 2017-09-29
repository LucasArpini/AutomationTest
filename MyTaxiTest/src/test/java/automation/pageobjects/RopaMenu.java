package test.java.automation.pageobjects;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import test.java.utils.WebDriverUtils;



	public class RopaMenu extends HomePage{

	private static final String ropaTitleLocator = "*//span[text()='Ropa De Mujer']";
	private static final String itemListLocator = "z-nvg-cognac_imageLink-OPGGa";
	private static final String itemListLocatorWithBanner = "catalogArticlesList_item";
	private static final String bannerTitleLocator = "*//h2[text()='Elige una sección']";
	
	public static boolean validateRopaMenuLoad(WebDriver driver) {
		WebDriverUtils.waitForLoad(driver);
		return driver.findElement(By.xpath(ropaTitleLocator)).isDisplayed();
	}
	
	public static List<WebElement> getItemList(WebDriver driver) {
		return driver.findElements(By.className(itemListLocator));
	}
	
	public static List<WebElement> getItemListBanner(WebDriver driver) {
		return driver.findElements(By.className(itemListLocatorWithBanner));
	}
	public static WebElement getBannerTitle(WebDriver driver) {
		return driver.findElement(By.xpath(bannerTitleLocator));
	}
	
	public static boolean validateBannerExistance(WebDriver driver) {
		return driver.findElements(By.xpath(bannerTitleLocator)).size() != 0;
	}
	
	
	
}
