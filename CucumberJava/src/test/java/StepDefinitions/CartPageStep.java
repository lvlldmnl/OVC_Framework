package StepDefinitions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.WebDriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CartPage;
import pages.HomePage;
import pages.loginPage;

public class CartPageStep {
	WebDriverWait wait;
	
	@Then("User verifies the following items in the cart:")
    public void theUserAddsTheFollowingItemsToTheCart(DataTable dataTable) throws InterruptedException {
		System.out.println("Inside Step - user verify the following item in the cart");
        wait = new WebDriverWait(WebDriverManager.driver, Duration.ofSeconds(10));
        List<String> items = dataTable.asList(String.class);
        for (String itemName : items) {
            By dynamicXPath = CartPage.cartItem(itemName);
            System.out.println(items);
            WebElement addItemToCart = wait.until(ExpectedConditions.elementToBeClickable(dynamicXPath));
            if(addItemToCart.equals(items)) {
            	return;//System.out.println("Cart Items:" + addItemToCart);
            }
            Thread.sleep(2000);
        }
    }
	
}