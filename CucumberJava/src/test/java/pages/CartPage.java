package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import StepDefinitions.CartPageStep;
import framework.Utils;
import framework.WebDriverManager;

public class CartPage {
	
	//CartItem
    static String item = "//div[text()='%s']/text()";
    
	 public static By cartItem(String itemName) {
	        return By.xpath(String.format(item, itemName));
	 }
    
}
