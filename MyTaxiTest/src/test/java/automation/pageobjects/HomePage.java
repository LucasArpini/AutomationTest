package test.java.automation.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import test.java.utils.WebDriverUtils;

public class HomePage {
	
	protected static WebElement element = null;
	private static final String logoLocator = "header.logo";
	private static final String ropaMenuLocator = "*//span[text()='Ropa']/..";
	private static final String cartMenuLocator = "*//span[text()='Cesta']";
	
	public static WebElement getLogo(WebDriver driver){
	    element = driver.findElement(By.name(logoLocator));
	    return element;	 
	}
	
	
	public static WebElement getRopaMenu(WebDriver driver){
	    element = driver.findElement(By.xpath(ropaMenuLocator));	 
	    return element;	 
	}
	
	public static boolean validateHomePageLoad(WebDriver driver) {
		WebDriverUtils.waitForLoad(driver);
		return driver.findElement(By.name(logoLocator)).isDisplayed();
	}
	
	public static WebElement getCartMenu(WebDriver driver) {
		return driver.findElement(By.xpath(cartMenuLocator));
		
	}
	//*//span[text()='Ropa']/..
}
