package test.java.automation.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

	private static final String cartItemsListLocator = "z-coast-fjord_articleGroupList";
	
	public static List<WebElement> getItemListBanner(WebDriver driver) {
		return driver.findElements(By.className(cartItemsListLocator));
	}
}
