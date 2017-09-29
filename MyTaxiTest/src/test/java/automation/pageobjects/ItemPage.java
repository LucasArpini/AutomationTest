package test.java.automation.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import test.java.utils.WebDriverUtils;

public class ItemPage {

	private static final String addToCartButtonLocator = ".z-rich-button.z-rich-button--primary";
	private static final String sizeSelectLocator = "*//div[contains(@class,'z-vegas_primaryContent')]//div[contains(@class,'zvui-size-select-dropdown-control')]";
	private static final String sizeListLocator = "div.zvui-size-picker-option-single-column.available span.z-text.z-text-detail-text-regular.z-text-black";
	private static final String miniCartDivLocator = "z-coast-fjord-miniCart-root";
	private static final String itemThumbnail = ".z-coast-fjord-miniCart_thumbnail img";
	
	
	public static WebElement getSizeDropdown(WebDriver driver) {
		return driver.findElement(By.xpath(sizeSelectLocator));
	}
	
	public static WebElement getSizeToClick(WebDriver driver) {
		return driver.findElement(By.cssSelector(sizeListLocator));
	}
	
	public static WebElement getAddToCartButton(WebDriver driver) {
		return driver.findElement(By.cssSelector((addToCartButtonLocator)));
	}
	
	public static boolean waitForItemToBeAddedToCart(WebDriver driver) {
		return WebDriverUtils.waitForElement(driver, By.cssSelector(itemThumbnail)) != null;
	}
	
	public static boolean validateItemAddToCart(WebDriver driver) {
		WebDriverUtils.waitForPageToLoad(driver);
		return driver.findElements(By.className(miniCartDivLocator)).size() != 0;
	}
	
	
}
