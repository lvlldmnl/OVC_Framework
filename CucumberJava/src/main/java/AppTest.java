
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.lang.Thread;

public class AppTest {

    private WebDriver webDriver;
    private String baseUrl = "https://codility-frontend-prod.s3.amazonaws.com/media/task_static/qa_login_page/9a83bda125cd7398f9f482a3d6d45ea4/static/attachments/reference_page.html";
    
    @BeforeMethod
    public void setUp() {
		String projectPath = System.getProperty("user.dir");
		System.out.println("Project path is: "+ projectPath);
		System.setProperty("webdriver.chrome.driver",projectPath + "/src/test/resources/drivers/chromedriver-127.exe");
		webDriver = new ChromeDriver();
		webDriver.get(baseUrl);
    }

    @Test
    public void testEmailAndPasswordFieldsDisplayed() {
    	//Locator Element
    	WebElement emailInput = webDriver.findElement(By.id("email-input"));
        WebElement passwordInput = webDriver.findElement(By.id("password-input"));

        assertTrue("Email input field is displayed", emailInput.isDisplayed());
        assertTrue("Password input field is displayed", passwordInput.isDisplayed());
    }
    
    @Test
    public void testLoginWithValidCredentials() {
        WebElement emailInput = webDriver.findElement(By.id("email-input"));
        WebElement passwordInput = webDriver.findElement(By.id("password-input"));
        WebElement loginButton = webDriver.findElement(By.id("login-button"));

        emailInput.sendKeys("login@codility.com");
        passwordInput.sendKeys("password");
        loginButton.click();

        WebElement successMessage = webDriver.findElement(By.xpath("//div[contains(@class, 'message success')][text()='Welcome to Codility']"));
        assertTrue("Successfully login", successMessage.isDisplayed());
        
    }
    
    @Test
    public void testLoginWithInvalidCredentials() {
        WebElement emailInput = webDriver.findElement(By.id("email-input"));
        WebElement passwordInput = webDriver.findElement(By.id("password-input"));
        WebElement loginButton = webDriver.findElement(By.id("login-button"));
        
        emailInput.sendKeys("unknown@codility.com");
        passwordInput.sendKeys("password");
        loginButton.click();
        
        WebElement errorMessage = webDriver.findElement(By.xpath("//div[contains(@class, 'message error')][text()='You shall not pass! Arr!']"));
        assertTrue("Error message is displayed for invalid credentials", errorMessage.isDisplayed());
    }
    
    @Test
    public void testValidationErrorDisplayedForInvalidInput() {
        WebElement emailInput = webDriver.findElement(By.id("email-input"));
        WebElement passwordInput = webDriver.findElement(By.id("password-input"));
        WebElement loginButton = webDriver.findElement(By.id("login-button"));
        
        emailInput.sendKeys("asdasdasd");
        passwordInput.sendKeys("password");
        loginButton.click();

        WebElement EnterValidEmailError = webDriver.findElement(By.xpath("//div[contains(@class, 'validation error')][text()='Enter a valid email']"));
        assertTrue("Validation error message is displayed for invalid input", EnterValidEmailError.isDisplayed());
    }

    @Test
    public void testValidationErrorDisplayedForEmptyCredentials() {
        WebElement emailInput = webDriver.findElement(By.id("email-input"));
        WebElement passwordInput = webDriver.findElement(By.id("password-input"));
        WebElement loginButton = webDriver.findElement(By.id("login-button"));

        emailInput.clear();
        passwordInput.clear();
        loginButton.click();

        boolean isEmailErrorVisible = isErrorMessageVisible("Email is required");
        boolean isPasswordErrorVisible = isErrorMessageVisible("Password is required");
        assertTrue("Validation error message for empty email is displayed", isEmailErrorVisible);
        assertTrue("Validation error message for empty password is displayed", isPasswordErrorVisible);
    }

    private boolean isErrorMessageVisible(String errorMessage) {
        WebElement errorMessageElement = webDriver.findElement(By.xpath("//div[contains(@class, 'validation error')][text()='"+ errorMessage +"']"));
        return errorMessageElement.isDisplayed();
    
    }

    @Test
    public void testTabAndEnterKeys() {
        WebElement emailInput = webDriver.findElement(By.id("email-input"));
        WebElement passwordInput = webDriver.findElement(By.id("password-input"));
        WebElement loginButton = webDriver.findElement(By.id("login-button"));

        emailInput.sendKeys(Keys.TAB);

        assertTrue("Focus is on the password input field after pressing Tab key",
                webDriver.switchTo().activeElement().equals(passwordInput));

        emailInput.sendKeys("login@codility.com");
        passwordInput.sendKeys("password");

        passwordInput.sendKeys(Keys.TAB);
        
        assertTrue("Focus is on the login button field after pressing Tab key",
                webDriver.switchTo().activeElement().equals(loginButton));
        
        loginButton.sendKeys(Keys.ENTER);

    }

    @AfterMethod
    public void tearDown() {
        if (webDriver != null) {
        	webDriver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
        	webDriver.close();
        	webDriver.quit();
        }
    }
}