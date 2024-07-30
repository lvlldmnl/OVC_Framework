package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import StepDefinitions.HomePageStep;
import StepDefinitions.LoginStep;
import framework.Utils;
import framework.WebDriverManager;
import utils.DynamicLocator;

import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HomePage {
	
	static String addToCartButtonLocator = "//div[text()='%s']/ancestor::div/following-sibling::div/button[text()='Add to cart']";
	String elementWithDynamicTextLocatorTemplate = "//div[contains(text(), '%s')]";
	
	//shoppingCart
	static By basketIcon = By.id("shopping_cart_container");
	
	//ButtonAddBelow
	static By btn_Logout = By.xpath("//div/a[text()='Log out']");
	
    public HomePage(WebDriver driver) {
    	WebDriverManager.driver = driver;
    }
    
	public void checkLogoutisDisplayed() {
//		WebDriverManager.driver.findElement(btn_Logout).isDisplayed();
		Utils.isDisplayed(WebDriverManager.driver, btn_Logout);
	}
	
	 public static By getItem(String itemName) {
	        return By.xpath(String.format(addToCartButtonLocator, itemName));
	 }
	
	public static void openShoppingCart() {
		Utils.click(WebDriverManager.driver, basketIcon);
	}
	
    // Method to find an element with dynamic text
//    public WebElement findElementWithDynamicText(String dynamicText) {
//        String dynamicTextLocator = DynamicLocator.generateLocatorWithDynamicText(elementWithDynamicTextLocatorTemplate, dynamicText);
//        return WebDriverManager.driver.findElement(By.xpath(dynamicTextLocator));
//    }
	
}
