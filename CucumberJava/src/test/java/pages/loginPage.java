package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import StepDefinitions.LoginStep;
import framework.Utils;
import framework.WebDriverManager;

public class loginPage {
	
	//Text
	static By text_InvalidUsername = By.xpath("//div[text()='Your username is invalid!']");
	static By text_InvalidPassword = By.xpath("//div[text()='Your password is invalid!']");

	//TextfieldAddBelow
	static By textfield_Username = By.id("user-name");
	static By textfield_Password = By.id("password");
	
	//ButtonAddBelow
	static By btn_Login = By.id("login-button");
	
	public loginPage(WebDriver driver) {
		WebDriverManager.driver = driver;
		if(WebDriverManager.driver.getTitle().equals("https://www.saucedemo.com/")) {
			throw new IllegalStateException("This is not login page"
			+WebDriverManager.driver.getCurrentUrl());
		}
	}
	
	public static void enterUsername(String username) {
//		WebDriverManager.driver.findElement(textfield_Username).sendKeys(username);
		Utils.sendKeys(WebDriverManager.driver, textfield_Username, username);
	}
	
	public static void enterPassord(String password) {
//		WebDriverManager.driver.findElement(textfield_Password).sendKeys(password);
		Utils.sendKeys(WebDriverManager.driver, textfield_Password, password);
	}
	
	public static void clickLogin() {
//		WebDriverManager.driver.findElement(btn_Login).click();
		Utils.click(WebDriverManager.driver, btn_Login); // Example locator, replace with your own
		
	}

	public static void errorMessageInvalidUsernameisDisplayed() {
//		WebDriverManager.driver.findElement(text_InvalidUsername).isDisplayed();
		Utils.isDisplayed(WebDriverManager.driver, text_InvalidUsername);
	}
	
	public static void errorMessageInvalidPasswordisDisplayed() {
//		WebDriverManager.driver.findElement(text_InvalidPassword).isDisplayed();
		Utils.isDisplayed(WebDriverManager.driver, text_InvalidPassword);
	}
	
	public static void loginUsers(String username, String password) {
//		WebDriverManager.driver.findElement(textfield_Username).sendKeys(username);
//		WebDriverManager.driver.findElement(textfield_Password).sendKeys(password);
		Utils.sendKeys(WebDriverManager.driver, textfield_Username, username);
		Utils.sendKeys(WebDriverManager.driver, textfield_Password, password);
	}
	

}
