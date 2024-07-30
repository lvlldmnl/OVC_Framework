package StepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import framework.WebDriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pages.HomePage;
import pages.CartPage;
import pages.loginPage;


public class LoginStep {
	
	public static WebDriver driver;
	
	@Given("Browser is open")
	public void browser_is_open() {
//		System.out.println("Inside Step - browser is open");
//		String projectPath = System.getProperty("user.dir");
//		System.out.println("Project path is: "+ projectPath);
//		System.setProperty("webdriver.chrome.driver",projectPath + "/src/test/resources/drivers/chromedriver.exe");
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
		WebDriverManager.setUp();
	}
	
	@Given("User is on login page")
	public void user_is_on_login_page() {
		System.out.println("Inside Step - user is on login page");
		//WebDriverManager.driver.navigate().to("https://www.saucedemo.com/");
		WebDriverManager.setUp();
	}

	@When("^User enter (.*) and (.*)$")
	public void user_enter_username_and_password(String username, String password) throws InterruptedException {
		System.out.println("Inside Step - user enters username and password");
		
		loginPage.loginUsers(username, password);
//		loginPage.enterPassord(password);
		
		Thread.sleep(2000);
	}

	@And("User clicks on login button")
	public void user_clicks_on_login_button() throws InterruptedException {
		System.out.println("Inside Step - user clicks on login button");
		
		loginPage.clickLogin();
		Thread.sleep(2000);
		
	}
	
	@Then("User receive error message your username is invalid")
	public void user_receive_error_message_invalid_username() throws InterruptedException {
		System.out.println("Inside Step - user cannot login because of invalid username");
		
		loginPage.errorMessageInvalidUsernameisDisplayed();
		
		Thread.sleep(2000);
		WebDriverManager.tearDown();
	}
	
	@Then("User receive error message your password is invalid")
	public void user_receive_error_message_invalid_password() throws InterruptedException {
		System.out.println("Inside Step - user cannot login because of invalid password");
		
		loginPage.errorMessageInvalidPasswordisDisplayed();
		
		Thread.sleep(2000);
		WebDriverManager.tearDown();
	}
	
}