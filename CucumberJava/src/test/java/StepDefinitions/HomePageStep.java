package StepDefinitions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.Utils;
import framework.WebDriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.CartPage;
import pages.loginPage;

public class HomePageStep {
	WebDriverWait wait;
	
	@Then("User is navigated to the home page")
	public void user_is_navigated_to_the_home_page() throws InterruptedException {
		System.out.println("Inside Step - user is on home page");
		Thread.sleep(5000);
		WebDriverManager.driver.close();
		WebDriverManager.driver.quit();
		
	}
	
	
    @When("the user adds the following items to the cart")
    public void theUserAddsTheFollowingItemsToTheCart(DataTable dataTable) throws InterruptedException {
        wait = new WebDriverWait(WebDriverManager.driver, Duration.ofSeconds(10));
        List<String> items = dataTable.asList(String.class);
        for (String itemName : items) {
            By dynamicXPath = HomePage.getItem(itemName);
            WebElement addItemToCart = wait.until(ExpectedConditions.elementToBeClickable(dynamicXPath));
            addItemToCart.click();
            Thread.sleep(2000);
        }
    }
    
	@And("User navigate to the shopping cart")
	public void user_navigate_to_the_shopping_cart() {
		System.out.println("Inside Step - user navigate to the shopping cart");
		HomePage.openShoppingCart();
	}
	
}