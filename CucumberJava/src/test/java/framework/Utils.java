package framework;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utils {
    
    // Method to click on an element and assert if it is clickable
    public static void click(WebDriver driver, By string) {
        WebElement element = driver.findElement(string);
        
        // Assertion to verify if element is clickable
        Assert.assertTrue("Element is not clickable", element.isEnabled() && element.isDisplayed());
        
        // Click on the element
        element.click();
        
    }
    
    // Method to send keys to an element and assert if it is editable
    public static void sendKeys(WebDriver driver, By locator, String keysToSend) {
        WebElement element = driver.findElement(locator);
        
        // Assertion to verify if element is editable
        Assert.assertTrue("Element is not editable", element.isEnabled() && element.isDisplayed());
        
        // Send keys to the element
        element.sendKeys(keysToSend);
    }
    
    // Method to check if an element is displayed
    public static void isDisplayed(WebDriver driver, By locator) {
        WebElement element = driver.findElement(locator);
        
        // Assertion to verify if element is displayed
        Assert.assertTrue("Element is not displayed", element.isDisplayed());
    }

}
