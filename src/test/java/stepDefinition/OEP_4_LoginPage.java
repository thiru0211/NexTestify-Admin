package stepDefinition;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OEP_4_LoginPage {
	public WebDriver driver;
	public WebElement ele, ele1, ele2, ele3, ele4, ele5, ele6, ele7, ele8, ele9;
	public WebDriverWait wait;

	@Given("To Check Login is navigating to OEP URL is {string}")
	public void to_check_login_is_navigating_to_oep_url_is(String url) {
		System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--headless=new");
		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get(url);
	}

	@When("To Check Login Enter username and password are {string} and {string}")
	public void to_check_login_enter_username_and_password_are_and(String username, String password) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("email")));
		ele1 = driver.findElement(By.name("email"));
		ele1.clear();
		ele1.sendKeys(username);
		ele2 = driver.findElement(By.name("password"));
		ele2.clear();
		ele2.sendKeys(password);
	}

	@When("click the Signin button To Check Login")
	public void click_the_signin_button_to_check_login() {
		ele1 = driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
		ele1.click();
	}

	@Then("close the Login Page")
	public void close_the_admin_page() {
		driver.quit();
		System.out.print("Page is closed");
	}

	@Then("Click User logo button in Top right corner")
	public void click_user_logo_button_in_top_right_corner() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@class='profile mb-2']")));
		ele1 = driver.findElement(By.xpath("//img[@class='profile mb-2']"));
		Actions action = new Actions(driver);
		action.moveToElement(ele1).build().perform();
		ele1.click();
	}

	@Then("Click SignOut button")
	public void click_sign_out_button() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("colorButton1")));
		ele1 = driver.findElement(By.id("colorButton1"));
		ele1.click();
	}

	@Then("Check login page is displayed or not using assert")
	public void check_login_page_is_displayed_or_not_using_assert() {
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = "http://192.168.1.30/OEPADMIN/";
		Assert.assertEquals("Page doesnot landed to Login page", currentUrl, expectedUrl);
	}

	@Then("Check alert message is displayed or not")
	public void check_alert_message_is_displayed_or_not() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		boolean isDisplayed = ele1.isDisplayed();
		String actualText = ele1.getText();
		System.out.println("Alert message dispalyed like : " + actualText);
		Assert.assertTrue("Alert message is not displayed", isDisplayed);
	}
	
	@Then("Check alert message is displayed or not in Login Page")
	public void check_alert_message_is_displayed_or_not_in_login_Page() throws InterruptedException {
		try {
		    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		    ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		    boolean isDisplayed = ele1.isDisplayed();
		    String actualText = ele1.getText();
		    System.out.println("Alert message displayed like : " + actualText);
		    Assert.assertTrue("Alert message is not displayed", isDisplayed); 
		} catch (TimeoutException e) {
		    System.out.println("Alert message is not displayed and page navigates to next page"); // Print the message here
		    Assert.fail("Alert message is not found and page navigates to next page"); 
		}
	}

	@Then("Click admin button to unlock the account")
	public void click_admin_button_to_unlock_the_account() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[@class='label'])[3]")));
		ele1 = driver.findElement(By.xpath("(//span[@class='label'])[3]"));
		Actions action = new Actions(driver);
		action.moveToElement(ele1).build().perform();
		ele1.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class='collapse show']//a[1]")));
		ele2 = driver.findElement(By.xpath("//ul[@class='collapse show']//a[1]"));
		ele2.click();
		driver.navigate().refresh();
	}

	@Then("Search valid username {string} in the searchbox to unlock the account")
	public void search_valid_username_in_the_searchbox_to_unlock_the_account(String username)
			throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("fname")));
		ele1 = driver.findElement(By.name("fname"));
		ele1.clear();
		ele1.sendKeys(username);
		Thread.sleep(2000);
		ele1.sendKeys(Keys.ENTER);
	}
	@Then("Click take picture button")
	public void click_take_picture_button() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//button[normalize-space(text())='Take Picture']")));
		ele1 = driver.findElement(By.xpath(
				"//button[normalize-space(text())='Take Picture']"));
		ele1.click();
	}
	@Then("Click edit button to unlock the account")
	public void click_edit_button_to_unlock_the_account() throws InterruptedException {
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//button[contains(@class,'btn-icon btn-icon-start')]")));
		ele1 = driver.findElement(By.xpath("//button[contains(@class,'btn-icon btn-icon-start')]"));
		ele1.click();
	}

	@Then("Click unlock button to unlock the account")
	public void click_unlock_button_to_unlock_the_account() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='btn btn-danger']")));
		ele1 = driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}

	@Then("Click yes button in the unlock tab")
	public void click_yes_button_in_the_unlock_tab() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[normalize-space(text())='Yes']")));
		ele1 = driver.findElement(By.xpath("//button[normalize-space(text())='Yes']"));
		ele1.click();
	}

	@Then("Check alert toast message is displayed in password tab or not")
	public void check_alert_toast_message_is_displayed_or_not() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//div[normalize-space(text())='Password is required!']")));
		ele1 = driver.findElement(By.xpath("//div[normalize-space(text())='Password is required!']"));
		String actualText = ele1.getText();
		System.out.println("Alert message dispalyed like : " + actualText);
		boolean isDisplayed = ele1.isDisplayed();
		Assert.assertTrue(isDisplayed);
	}

	@Then("Check alert toast message is displayed in email tab or not")
	public void check_alert_toast_message_is_displayed_in_email_or_not() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//div[normalize-space(text())='Email or mobile is required!']")));
		ele1 = driver.findElement(By.xpath("//div[normalize-space(text())='Email or mobile is required!']"));
		String actualText = ele1.getText();
		System.out.println("Alert message dispalyed like : " + actualText);
		boolean isDisplayed = ele1.isDisplayed();
		Assert.assertTrue(isDisplayed);
	}

	@When("To Check Login Enter Invalid username and valid password are {string} and {string}")
	public void to_check_login_enter_invalid_username_and_valid_password_are_and(String username, String password) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("email")));
		ele1 = driver.findElement(By.name("email"));
		ele1.sendKeys(username);
		ele2 = driver.findElement(By.name("password"));
		ele2.sendKeys(password);
	}

	@When("To Check Login Enter valid username and Invalid password are {string} and {string}")
	public void to_check_login_enter_valid_username_and_invalid_password_are_and(String username, String password) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("email")));
		ele1 = driver.findElement(By.name("email"));
		ele1.sendKeys(username);
		ele2 = driver.findElement(By.name("password"));
		ele2.sendKeys(password);
	}

	@When("To Check Login Enter Invalid username and Invalid password are {string} and {string}")
	public void to_check_login_enter_invalid_username_and_invalid_password_are_and(String username, String password) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("email")));
		ele1 = driver.findElement(By.name("email"));
		ele1.sendKeys(username);
		ele2 = driver.findElement(By.name("password"));
		ele2.sendKeys(password);
	}

	@When("To Check Login Enter username only {string}")
	public void to_check_login_enter_username_only(String username) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("email")));
		ele1 = driver.findElement(By.name("email"));
		ele1.sendKeys(username);
	}

	@When("To Check Login Enter password only {string}")
	public void to_check_login_enter_password_only(String password) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("email")));
		ele2 = driver.findElement(By.name("password"));
		ele2.sendKeys(password);
	}

	@When("Without enter email id click Forget password button")
	public void without_enter_email_id_click_forget_password_button() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//a[normalize-space(text())='Forgot Password?']")));
		ele1 = driver.findElement(By.xpath("//a[normalize-space(text())='Forgot Password?']"));
		ele1.click();
	}

	@When("To Check Login Enter email id {string}")
	public void to_check_login_enter_email_id(String username) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("email")));
		ele1 = driver.findElement(By.name("email"));
		ele1.sendKeys(username);
	}

	@When("click Forget password button")
	public void click_forget_password_button() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//a[normalize-space(text())='Forgot Password?']")));
		ele1 = driver.findElement(By.xpath("//a[normalize-space(text())='Forgot Password?']"));
		ele1.click();
	}

	@Then("Click Ok button")
	public void click_ok_button() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//button[normalize-space(text())='Ok got it!']")));
		ele1 = driver.findElement(By.xpath("//button[normalize-space(text())='Ok got it!']"));
		ele1.click();
	}

	@Then("Check landing page after click ok button")
	public void check_landing_page_after_click_ok_button() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(),'Login')]")));
		ele1 = driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
		Assert.assertTrue("Page doesnot login to login page", ele1.isDisplayed());
	}

	@When("Click ENTER button")
	public void click_enter_button() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("email")));
		ele1 = driver.findElement(By.name("password"));
		ele1.sendKeys(Keys.ENTER);

	}

	@Then("Check the landing page using assert function")
	public void check_the_landing_page_using_assert_function() throws InterruptedException {
		Thread.sleep(2000);
		String currentUrl = driver.getCurrentUrl();
		String expectedUrl = "http://192.168.1.30/OEPADMIN/TwolevelAuth";
		Assert.assertEquals("Page doesnot landed to Login page", currentUrl, expectedUrl);
	}

	@When("To Check Login Enter inactive username and valid password are {string} and {string}")
	public void to_check_login_enter_inactive_username_and_valid_password_are_and(String username, String password) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("email")));
		ele1 = driver.findElement(By.name("email"));
		ele1.sendKeys(username);
		ele2 = driver.findElement(By.name("password"));
		ele2.sendKeys(password);
	}
}