package ui.mapping;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
	private static WebElement element = null;
	private static final String logoLocator = "header.logo";
	private static final String ropaMenuLocator = "*//span[text()='Ropa']/..";
	
	public static WebElement getLogo(WebDriver driver){
	    element = driver.findElement(By.name(logoLocator));
	    return element;	 
	}
	
	
	public static WebElement getRopaMenu(WebDriver driver){
	    element = driver.findElement(By.xpath(ropaMenuLocator));	 
	    return element;	 
	}
	
	public static boolean validatePageLoad(WebDriver driver) {
		return driver.findElement(By.name(logoLocator)).isDisplayed();
	}
	
	//*//span[text()='Ropa']/..
}
