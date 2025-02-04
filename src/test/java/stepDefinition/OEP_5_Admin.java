package stepDefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.javafaker.Faker;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OEP_5_Admin {
	public WebDriver driver;
	public WebElement ele, ele1, ele2, ele3, ele4, ele5, ele6, ele7, ele8, ele9;
	public WebDriverWait wait;

	@Given("To Check Admin is navigating to OEP URL is {string}")
	public void to_check_admin_is_navigating_to_oep_url_is(String url) {
		System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--headless=new");
		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get(url);
	}

	@When("To Check Admin Enter username and password are {string} and {string}")
	public void to_check_admin_enter_username_and_password_are_and(String username, String password) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("email")));
		ele1 = driver.findElement(By.name("email"));
		ele1.clear();
		ele1.sendKeys(username);
		ele2 = driver.findElement(By.name("password"));
		ele2.clear();
		ele2.sendKeys(password);
	}

	@When("click the Signin button To Check Admin")
	public void click_the_signin_button_to_check_admin() {
		ele1 = driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
		ele1.click();
	}

	@Then("Click admin button")
	public void click_admin_button() {
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

	@Given("Click User logo button in Top right corner in create admin")
	public void click_user_logo_button_in_top_right_corner_in_create_admin() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@class='profile mb-2']")));
		ele1 = driver.findElement(By.xpath("//img[@class='profile mb-2']"));
		Actions action = new Actions(driver);
		action.moveToElement(ele1).build().perform();
		ele1.click();
	}

	@Given("Click SignOut button in create admin")
	public void click_sign_out_button_in_create_admin() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[normalize-space()='Logout']")));
		ele1 = driver.findElement(By.xpath("//span[normalize-space()='Logout']"));
		ele1.click();
	}

	@Then("Close Admin button")
	public void close_admin_button() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
		System.out.print("Page is closed");
	}

	@When("Check entered username {string} is displayed or not in create admin page")
	public void check_entered_username_is_displayed_or_not_in_create_admin_page(String username) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//div[@class='align-items-center text-alternate'])[1]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='align-items-center text-alternate'])[1]"));
		String actualText = ele1.getText();
		String expectedText = username;
		Assert.assertEquals("Entered Username is not displayed", actualText, expectedText);
	}

	@Then("Check entered emailid {string} is displayed or not in create admin page")
	public void check_entered_emailid_is_displayed_or_not_in_create_admin_page(String emailId) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//div[@class='align-items-center text-alternate'])[2]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='align-items-center text-alternate'])[2]"));
		String actualText = ele1.getText();
		String expectedText = emailId;
		Assert.assertEquals("Entered Email ID is not displayed", actualText, expectedText);
	}

	@Then("Check entered phone number {string} is displayed or not in create admin page")
	public void check_entered_phone_number_is_displayed_or_not_in_create_admin_page(String phoneNumber) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//div[@class='align-items-center text-alternate'])[3]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='align-items-center text-alternate'])[3]"));
		String actualText = ele1.getText();
		String expectedText = phoneNumber;
		Assert.assertEquals("Entered Phone Number is not displayed", actualText, expectedText);
	}

	@Then("Click take picture button in admin")
	public void click_take_picture_button_in_admin() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//button[normalize-space(text())='Take Picture']")));
		ele1 = driver.findElement(By.xpath(
				"//button[normalize-space(text())='Take Picture']"));
		ele1.click();
	}
	@Given("Enter valid username {string} in the searchbox")
	public void enter_valid_username_in_the_searchbox(String username) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("fname")));
		ele1 = driver.findElement(By.name("fname"));
		ele1.clear();
		ele1.sendKeys(username);
		Thread.sleep(2000);
		ele1.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}

	@When("Enter valid email id {string} in the searchbox")
	public void enter_valid_email_id_in_the_searchbox(String emailID) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("fname")));
		ele1 = driver.findElement(By.name("fname"));
		ele1.clear();
		String clearedText = ele1.getDomProperty("value");
		if (clearedText.isEmpty()) {
			ele1.sendKeys(emailID);
			Thread.sleep(2000);
			ele1.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
		} else {
			System.out.println("Text is not cleared");
		}
	}

	@Then("Enter valid phone number {string} in the searchbox")
	public void enter_valid_phone_number_in_the_searchbox(String phoneNumber) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("fname")));
		ele1 = driver.findElement(By.name("fname"));
		ele1.clear();
		String clearedText = ele1.getDomProperty("value");
		if (clearedText.isEmpty()) {
			ele1.sendKeys(phoneNumber);
			Thread.sleep(2000);
			ele1.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
		} else {
			System.out.println("Text is not cleared");
		}
	}

	@Then("Check Selected {string} status is displayed or not")
	public void Check_selected_status_is_displayed_or_not(String status) throws InterruptedException {
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='text-center col-xl-1 col-lg-1'])[2]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='text-center col-xl-1 col-lg-1'])[2]"));
		String actualStatus = ele1.getText();
		System.out.println("Status displayed as: " + actualStatus);
		String expectedStatus = status;
		Assert.assertEquals("Status is not displayed as per selection", actualStatus, expectedStatus);
	}

	@Then("Check Selected {string} user type is displayed or not")
	public void check_selected_user_type_is_displayed_or_not(String option) throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='text-muted fs-12'])[1]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='text-muted fs-12'])[1]"));
		String actualUsrType = ele1.getText();
		System.out.println("Status displayed as: " + actualUsrType);
		String expectedUsrType = option;
		Assert.assertEquals("Status is not displayed as per selection", actualUsrType, expectedUsrType);
	}

	@Given("Select {string} 1st Option in status dropdown")
	public void select_1st_option_in_status_dropdown(String string) throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[1]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[1]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='All']"));
		ele2.click();
	}

	@When("Select {string} 2nd Option in status dropdown")
	public void select_2nd_option_in_status_dropdown(String string) throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[1]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[1]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Active']"));
		ele2.click();
	}

	@Then("Select {string} 3rd Option in status dropdown")
	public void select_3rd_option_in_status_dropdown(String string) throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[1]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[1]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Inactive']"));
		ele2.click();
	}

	@Given("Select {string} 1st Option in user type dropdown")
	public void select_1st_option_in_user_type_dropdown(String string) throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='All Admins']"));
		ele2.click();
	}

	@When("Select {string} 2nd Option in user type dropdown")
	public void select_2nd_option_in_user_type_dropdown(String string) throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Super Admin']"));
		ele2.click();
	}

	@Then("Select {string} 3rd Option in user type dropdown")
	public void select_3rd_option_in_user_type_dropdown(String string) throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Proctor']"));
		ele2.click();
	}

	@Then("Select {string} 4th Option in user type dropdown")
	public void select_4th_option_in_user_type_dropdown(String string) throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Question Manager']"));
		ele2.click();
	}

	@Given("Click next page button in below of the grid")
	public void click_next_page_button_in_below_of_the_grid() throws InterruptedException {
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@class='page-link']//span)[1]")));
		ele1 = driver.findElement(By.xpath("(//a[@class='page-link']//span)[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}

	@Given("Click Last page button in below of the grid")
	public void click_last_page_button_in_below_of_the_grid() throws InterruptedException {
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@class='page-link']//span)[3]")));
		ele1 = driver.findElement(By.xpath("(//a[@class='page-link']//span)[3]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}
	
	@When("Click First page button in below of the grid")
	public void click_first_page_button_in_below_of_the_grid() throws InterruptedException {
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@class='page-link']//span)[1]")));
		ele1 = driver.findElement(By.xpath("(//a[@class='page-link']//span)[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}
	@Then("Click the number button in below of the grid")
	public void click_the_number_button_in_below_of_the_grid() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[normalize-space(text())='2']")));
		ele1 = driver.findElement(By.xpath("//a[normalize-space(text())='2']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}
	
	@When("Click previous page button in below of the grid")
	public void click_previous_page_button_in_below_of_the_grid() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@class='page-link']//span)[3]")));
		ele1 = driver.findElement(By.xpath("(//a[@class='page-link']//span)[3]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}

	@Given("Click Add User button in create admin page")
	public void click_add_user_button_in_create_admin_page() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Click here to add user']")));
		ele1 = driver.findElement(By.xpath("//button[@title='Click here to add user']"));
		ele1.click();
	}

	@Given("Click back button in create admin page")
	public void click_back_button_in_create_admin_page() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Click here to back']")));
		ele1 = driver.findElement(By.xpath("//button[@title='Click here to back']"));
		ele1.click();
	}

	@Given("Click save button in create admin page")
	public void click_save_button_in_create_admin_page() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Click here to save']")));
		ele1 = driver.findElement(By.xpath("//button[@title='Click here to save']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}

	@Given("Enter numerical characters {string} in first name tab")
	public void enter_numerical_characters_in_first_name_tab(String firstname) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("FirstName")));
		ele1 = driver.findElement(By.id("FirstName"));
		ele1.sendKeys(firstname);
	}

	@Then("Check tab is empty or not in first name tab")
	public void check_tab_is_empty_or_not_in_first_name_tab() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("FirstName")));
		ele1 = driver.findElement(By.id("FirstName"));
		String fname = ele1.getDomProperty("value");
		System.out.println("Firstname tab value is: " + fname);
		Assert.assertTrue("FirstName tab is not empty!", fname.isEmpty());
	}

	@Then("Check tab is empty or not in first name")
	public void check_tab_is_empty_or_not_in_first_name() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("FirstName")));
		ele1 = driver.findElement(By.id("FirstName"));
		String fname = ele1.getDomProperty("value");
		System.out.println("Firstname tab value is: " + fname);
		Assert.assertFalse("FirstName tab is not empty!", fname.isEmpty());
	}

	@Then("Enter special characters {string} in first name tab")
	public void enter_special_characters_in_first_name_tab(String firstname) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("FirstName")));
		ele1 = driver.findElement(By.id("FirstName"));
		ele1.sendKeys(firstname);
	}

	@Given("Enter alphabetical characters {string} in first name tab")
	public void enter_alphabetical_characters_in_first_name_tab(String firstname) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("FirstName")));
		ele1 = driver.findElement(By.id("FirstName"));
		ele1.sendKeys(firstname);
	}

	@Given("Enter numerical characters {string} in last name tab")
	public void enter_numerical_characters_in_last_name_tab(String lastname) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("FirstName")));
		ele1 = driver.findElement(By.id("FirstName"));
		ele1.sendKeys(lastname);
	}

	@Then("Check tab is empty or not in last name tab")
	public void check_tab_is_empty_or_not_in_last_name_tab() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("LastName")));
		ele1 = driver.findElement(By.id("LastName"));
		String lastname = ele1.getDomProperty("value");
		System.out.println("Lastname tab value is: " + lastname);
		Assert.assertTrue("Lastname tab is not empty!", lastname.isEmpty());
	}

	@Then("Check tab is empty or not in last name")
	public void check_tab_is_empty_or_not_in_last_name() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("LastName")));
		ele1 = driver.findElement(By.id("LastName"));
		String lastname = ele1.getDomProperty("value");
		System.out.println("Lastname tab value is: " + lastname);
		Assert.assertFalse("Lastname tab is not empty!", lastname.isEmpty());
	}

	@Then("Enter special characters {string} in last name tab")
	public void enter_special_characters_in_last_name_tab(String lastname) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("LastName")));
		ele1 = driver.findElement(By.id("LastName"));
		ele1.sendKeys(lastname);
	}

	@Given("Enter alphabetical characters {string} in last name tab")
	public void enter_alphabetical_characters_in_last_name_tab(String lastname) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("LastName")));
		ele1 = driver.findElement(By.id("LastName"));
		ele1.sendKeys(lastname);
	}

	@Given("Enter valid email id {string} in email tab")
	public void enter_valid_email_id_in_email_tab(String emailID) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Email")));
		ele1 = driver.findElement(By.id("Email"));
		ele1.sendKeys(emailID);
	}

	@Then("Check tab is empty or not in email tab")
	public void check_tab_is_empty_or_not_in_email_tab() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Email")));
		ele1 = driver.findElement(By.id("Email"));
		String email = ele1.getDomProperty("value");
		System.out.println("Email tab value is: " + email);
		Assert.assertFalse("Email tab is not empty!", email.isEmpty());
	}

	@Then("Check alert message is displayed or not in email tab")
	public void check_alert_message_is_displayed_or_not_in_email_tab() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='d-block invalid-tooltip']")));
		ele1 = driver.findElement(By.xpath("//div[@class='d-block invalid-tooltip']"));
		String actualMsg = ele1.getText();
		System.out.println("Error message is displayed like: " + actualMsg);
		String expmsg = "Email must be valid.";
		Assert.assertEquals("Error message is not displayed", actualMsg, expmsg);
	}

	@Then("Check entered user type {string} is displayed or not in create admin")
	public void check_entered_user_type_is_displayed_or_not_in_create_admin(String userType) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[1]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[1]"));
		String actualUsrType = ele1.getText();
		String expUsrTyp = userType;
		Assert.assertEquals("User type cannot able to select and enter", actualUsrType, expUsrTyp);
	}

	@Then("Check alert message is displayed or not in change email tab")
	public void check_alert_message_is_displayed_or_not_in_change_email_tab() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actText = ele1.getText();
		System.out.println("Success message displayed like: " + actText);
		String expText="Given email is already existing. please provide another one!";
		Assert.assertEquals("User type cannot able to select and enter", actText, expText);
	}

	@Then("Check success message is displayed or not in verify email")
	public void check_success_message_is_displayed_or_not_in_verify_email() throws InterruptedException {
		Thread.sleep(4000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actText = ele1.getText();
		System.out.println("Verification message displayed like: " + actText);
		String expText="Verification code sent successfully!";
		Assert.assertEquals("Verification code sent message is not displayed", actText, expText);
	}
	
	@Then("Check success message is displayed or not for user unlock")
	public void check_success_message_is_displayed_or_not_for_user_unlock() throws InterruptedException {
		Thread.sleep(4000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actText = ele1.getText();
		System.out.println("Unlock message displayed like: " + actText);
		String expText="Account has been unlocked successfully!";
		Assert.assertEquals("Unlock message is not displayed", actText, expText);
	}
	
	@Given("Enter valid user type {string} in the dropdown")
	public void enter_valid_user_type_in_the_dropdown(String usrType) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("(//div[@class='react-select__single-value css-1uccc91-singleValue'])[1]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='react-select__single-value css-1uccc91-singleValue'])[1]"));
		ele1.click();

		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Super Admin']"));
		ele2.click();
	}

	@Given("Select valid user type {string} in the dropdown")
	public void select_valid_user_type_in_the_dropdown(String usrType) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("(//div[@class='react-select__single-value css-1uccc91-singleValue'])[1]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='react-select__single-value css-1uccc91-singleValue'])[1]"));
		ele1.click();

		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Super Admin']"));
		ele2.click();
	}

	@Given("Enter alphabetical characters {string} in phone number tab")
	public void enter_alphabetical_characters_in_phone_number_tab(String phone) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Phone")));
		ele1 = driver.findElement(By.id("Phone"));
		ele1.sendKeys(phone);
	}

	@Then("Check tab is empty or not in phone number tab")
	public void check_tab_is_empty_or_not_in_phone_number_tab() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Phone")));
		ele1 = driver.findElement(By.id("Phone"));
		String phone = ele1.getDomProperty("value");
		System.out.println("Lastname tab value is: " + phone);
		Assert.assertTrue("Lastname tab is not empty!", phone.isEmpty());
	}

	@Then("Check entered phone number {string} is displayed or not in phone number tab in create admin")
	public void check_entered_phone_number_is_displayed_or_not_in_phone_number_tab_in_create_admin(String phoneNumber) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Phone")));
		ele1 = driver.findElement(By.id("Phone"));
		String actualText = ele1.getDomAttribute("value");
		System.out.println("Phone number tab has: "+actualText);
		String expectedText = phoneNumber;
		Assert.assertEquals("Entered Phone number is not displayed", actualText, expectedText);
	}

	@Given("Enter special characters {string} in phone number tab")
	public void enter_special_characters_in_phone_number_tab(String phone) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Phone")));
		ele1 = driver.findElement(By.id("Phone"));
		ele1.sendKeys(phone);
	}

	@Given("Enter numerical {string} characters in phone number tab")
	public void enter_numerical_characters_in_phone_number_tab(String phone) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Phone")));
		ele1 = driver.findElement(By.id("Phone"));
		ele1.sendKeys(phone);
	}

	@Then("Check the status changed to No-option in the toggle button")
	public void check_the_status_changed_to_no_option_in_the_toggle_button() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='ant-switch-inner']")));
		ele1 = driver.findElement(By.xpath("//span[@class='ant-switch-inner']"));
		Thread.sleep(2000);
		String actToggleStatus = ele1.getText();
		System.out.println("Toggle button status is: "+actToggleStatus);
		String expToggleStatus ="No";
		Assert.assertEquals("Toggle button is not working", actToggleStatus, expToggleStatus);
	}
	
	@Then("Check the status changed to Yes-option in the toggle button")
	public void check_the_status_changed_to_yes_option_in_the_toggle_button() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='ant-switch-inner']")));
		ele1 = driver.findElement(By.xpath("//span[@class='ant-switch-inner']"));
		Thread.sleep(2000);
		String actToggleStatus = ele1.getText();
		System.out.println("Toggle button status is: "+actToggleStatus);
		String expToggleStatus ="Yes";
		Thread.sleep(2000);
		Assert.assertEquals("Toggle button is not working", actToggleStatus, expToggleStatus);
	}
	
	@Then("Check entered details {string} are displayed or not in address1 tab")
	public void check_entered_details_are_displayed_or_not_in_address1_tab(String address1) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Address1")));
		ele1 = driver.findElement(By.name("Address1"));
		String acttext = ele1.getDomProperty("value");
		String exptext =address1;
		Assert.assertEquals("Entered text is not displayed", acttext, exptext);
	}
	
	@Then("Check entered details {string} are displayed or not in address2 tab")
	public void check_entered_details_are_displayed_or_not_in_address2_tab(String address2) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Address2")));
		ele1 = driver.findElement(By.name("Address2"));
		String acttext = ele1.getDomProperty("value");
		String exptext =address2;
		Assert.assertEquals("Entered text is not displayed", acttext, exptext);
	}
	
	@Then("Select valid country code {string}")
	public void select_valid_country_code(String phone) throws InterruptedException, AWTException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='Select']")));
		ele1 = driver.findElement(By.xpath("//div[normalize-space(text())='Select']"));
		ele1.click();
		Thread.sleep(3000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='+91']"));
		Thread.sleep(1000);
		ele2.click();
//		ele1.sendKeys(phone);
		
	}

	@Then("Enter valid phone number {string}")
	public void enter_valid_phone_number(String phone) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Phone")));
		ele1 = driver.findElement(By.id("Phone"));
		ele1.sendKeys(phone);
	}

	@Then("Click the toggle button")
	public void click_the_toggle_button() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='ant-switch-inner']")));
		ele1 = driver.findElement(By.xpath("//span[@class='ant-switch-inner']"));
		ele1.click();
	}

	@Given("Enter valid {string} in address1 tab")
	public void enter_valid_in_address1_tab(String address) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Address1")));
		ele1 = driver.findElement(By.name("Address1"));
		ele1.sendKeys(address);
	}

	@Given("Enter valid {string} in address2 tab")
	public void enter_valid_in_address2_tab(String address) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Address2")));
		ele1 = driver.findElement(By.name("Address2"));
		ele1.sendKeys(address);
	}

	@Given("Enter numerical characters {string} in city tab")
	public void enter_numerical_characters_in_city_tab(String city) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("City")));
		ele1 = driver.findElement(By.name("City"));
		ele1.sendKeys(city);
	}

	@Then("Check tab is empty or not in city tab")
	public void check_tab_is_empty_or_not_in_city_tab() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.name("City")));
		ele = driver.findElement(By.name("ZipCode"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
		Thread.sleep(2000);
		ele1 = driver.findElement(By.name("City"));
		String city = ele1.getDomProperty("value");
		Assert.assertTrue("City tab is not empty", city.isEmpty());
	}
	
	@Then("Check tab is empty or not in city")
	public void check_tab_is_empty_or_not_in_city() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("City")));
		ele1 = driver.findElement(By.name("City"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		String cityValue = ele1.getDomProperty("value");
		System.out.println("City tab value is: " + cityValue);
		Assert.assertFalse("City tab is not empty", cityValue.isEmpty());
	}

	@Then("Check entered country name {string} is displayed or not in country tab")
	public void check_entered_country_name_is_displayed_or_not_in_country_tab(String countryName) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[3]")));
		ele1 = driver.findElement(By.xpath("(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[3]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		String actText = ele1.getText();
		String expText =countryName;
		Assert.assertEquals("Entered country name is not displayed", actText, expText);
	}
	
	@Then("Check entered state name {string} is displayed or not in country tab")
	public void check_entered_state_name_is_displayed_or_not_in_country_tab(String stateName) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("(//div[@class='react-select__value-container react-select__value-container--has-value css-1hwfws3'])[4]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='react-select__value-container react-select__value-container--has-value css-1hwfws3'])[4]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		String actText = ele1.getText();
		String expText =stateName;
		Assert.assertEquals("Entered state name is not displayed", actText, expText);
	}
	
	@Then("Check entered Time Zone name {string} is displayed or not in Time Zone tab")
	public void check_entered_time_zone_name_is_displayed_or_not_in_time_zone_tab(String timeZone) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("(//div[@class='react-select__value-container react-select__value-container--has-value css-1hwfws3'])[5]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='react-select__value-container react-select__value-container--has-value css-1hwfws3'])[5]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		String actText = ele1.getText();
		String expText =timeZone;
		Assert.assertEquals("Entered state name is not displayed", actText, expText);
	}
	
	@Given("Enter special characters {string} in city tab")
	public void enter_special_characters_in_city_tab(String city) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("City")));
		ele1 = driver.findElement(By.name("City"));
		ele1.sendKeys(city);
	}

	@Given("Enter alphabetical characters {string} in city tab")
	public void enter_alphabetical_characters_in_city_tab(String city) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("City")));
		ele1 = driver.findElement(By.name("City"));
		ele1.sendKeys(city);
	}

	@Given("Enter country name {string} in country tab")
	public void enter_country_name_in_country_tab(String counName) throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[3]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[3]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='India']"));
		ele2.click();
	}

	@Given("Select country name {string} in country tab")
	public void select_country_name_in_country_tab(String counName) throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[3]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[3]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='India']"));
		ele2.click();
	}

	@Given("Enter state name {string} in state tab")
	public void enter_state_name_in_state_tab(String state) throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[4]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[4]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Tamil Nadu']"));
		ele2.click();
	}

	@Given("Select state name {string} in state tab")
	public void select_state_name_in_state_tab(String state) throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[4]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[4]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Tamil Nadu']"));
		ele2.click();
	}

	@Given("Enter Time Zone name {string} in Time Zone tab")
	public void enter_time_zone_name_in_time_zone_tab(String timeZone) throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//div[@class='react-select__value-container react-select__value-container--has-value css-1hwfws3'])[5]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='react-select__value-container react-select__value-container--has-value css-1hwfws3'])[5]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Asia/Kolkata']"));
		ele2.click();
	}

	@Given("Select valid {string} in timezone tab")
	public void select_valid_in_timezone_tab(String timeZone) throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//div[@class='react-select__value-container react-select__value-container--has-value css-1hwfws3'])[5]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='react-select__value-container react-select__value-container--has-value css-1hwfws3'])[5]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Asia/Kolkata']"));
		ele2.click();
	}

	@Given("Enter alphabetical characters {string} in Zip Code tab")
	public void enter_alphabetical_characters_in_zip_code_tab(String zipCode) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("ZipCode")));
		ele1 = driver.findElement(By.name("ZipCode"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.sendKeys(zipCode);
	}

	@Then("Check tab is empty or not in Zip Code tab")
	public void check_tab_is_empty_or_not_in_zip_code_tab() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("ZipCode")));
		ele1 = driver.findElement(By.name("ZipCode"));
		String zipCode = ele1.getDomProperty("value");
		Assert.assertTrue("ZZip code tab is not empty", zipCode.isEmpty());
	}
	
	@Then("Check tab is empty or not in Zip Code")
	public void check_tab_is_empty_or_not_in_zip_code() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("ZipCode")));
		ele1 = driver.findElement(By.name("ZipCode"));
		String zipCode = ele1.getDomProperty("value");
		Assert.assertFalse("ZZip code tab is not empty", zipCode.isEmpty());
	}

	@Given("Enter special characters {string} in Zip Code tab")
	public void enter_special_characters_in_zip_code_tab(String zipCode) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("ZipCode")));
		ele1 = driver.findElement(By.name("ZipCode"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.sendKeys(zipCode);
	}

	@Given("Enter valid characters {string} in Zip Code tab")
	public void enter_valid_characters_in_zip_code_tab(String zipCode) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("ZipCode")));
		ele1 = driver.findElement(By.name("ZipCode"));
		ele1.sendKeys(zipCode);
	}

	@Given("Upload invalid file in profile upload tab")
	public void upload_invalid_file_in_profile_upload_tab() throws InterruptedException, AWTException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='imageUpload']//button[1]")));
		ele1 = driver.findElement(By.xpath("//div[@id='imageUpload']//button[1]"));
		ele1.click();
		// Upload the file
		Thread.sleep(2000);
		String filePath = "C:\\Users\\thirumaran\\eclipse-workspace\\NexTestify_Cucumber\\Files\\Blank.xlsx";
		Robot robot = new Robot();
		StringSelection selection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		driver.switchTo().defaultContent();
	}

	@Given("Upload valid file in profile upload tab")
	public void upload_valid_file_in_profile_upload_tab() throws InterruptedException, AWTException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='imageUpload']//button[1]")));
		ele1 = driver.findElement(By.xpath("//div[@id='imageUpload']//button[1]"));
		ele1.click();
		// Upload the file
		Thread.sleep(2000);
		String filePath = "C:\\Users\\thirumaran\\eclipse-workspace\\NexTestify_Cucumber\\Files\\Sample.png";
		Robot robot = new Robot();
		StringSelection selection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		driver.switchTo().defaultContent();
	}

	@Then("Click No radio button in 2FA Details tab")
	public void click_no_radio_button_in_2fa_details_tab() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@name='twoauthstatus'])[2]")));
		ele1 = driver.findElement(By.xpath("(//input[@name='twoauthstatus'])[2]"));
		ele1.click();
	}

	@Then("Click Yes radio button in 2FA Details tab")
	public void click_yes_radio_button_in_2fa_details_tab() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@name='twoauthstatus'])[1]")));
		ele1 = driver.findElement(By.xpath("(//input[@name='twoauthstatus'])[1]"));
		ele1.click();
	}

	@Then("Click Email radio button in 2FA Details tab")
	public void click_email_radio_button_in_2fa_details_tab() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@name='tfaVia'])[1]")));
		ele1 = driver.findElement(By.xpath("(//input[@name='tfaVia'])[1]"));
		ele1.click();
	}

	@Then("Click SMS radio button in 2FA Details tab")
	public void click_sms_radio_button_in_2fa_details_tab() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@name='tfaVia'])[2]")));
		ele1 = driver.findElement(By.xpath("(//input[@name='tfaVia'])[2]"));
		ele1.click();
	}

	@When("Enter valid first name in create admin page")
	public void enter_valid_first_name_in_create_admin_page() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("FirstName")));
		ele1 = driver.findElement(By.id("FirstName"));
		Faker fakename = new Faker();
		String firstName = fakename.name().firstName();
		ele1.sendKeys(firstName);
	}

	@Then("Enter valid last name in create admin page")
	public void enter_valid_last_name_in_create_admin_page() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("LastName")));
		ele1 = driver.findElement(By.id("LastName"));
		Faker fakename = new Faker();
		String lastName = fakename.name().lastName();
		ele1.sendKeys(lastName);
	}

	@Then("Enter valid email id in create admin page")
	public void enter_valid_email_id_in_create_admin_page() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Email")));
		ele1 = driver.findElement(By.id("Email"));
		Faker fakename = new Faker();
		String firstName = fakename.name().firstName();
		String email = firstName.toLowerCase() + "@guerrillamail.info";
		ele1.sendKeys(email);
	}

	@Then("Select valid user type {string} in create admin page")
	public void select_valid_user_type_in_create_admin_page(String usrType) throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[1]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[1]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Super Admin']"));
		ele2.click();
	}

	@Then("Select valid country code {string} in create admin page")
	public void select_valid_country_code_in_create_admin_page(String counCode) throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[@class='react-select__value-container react-select__value-container--has-value css-1hwfws3'])[2]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[@class='react-select__value-container react-select__value-container--has-value css-1hwfws3'])[2]"));
		ele1.click();
		Thread.sleep(2000);
		ele1 = driver.findElement(By.xpath(
				"(//div[@class='react-select__value-container react-select__value-container--has-value css-1hwfws3'])[2]"));
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='+91']"));
		Thread.sleep(2000);
		ele2.click();
	}

	@Then("Enter valid phone number {string} in create admin page")
	public void Enter_valid_phone_number_in_create_admin_page(String phNumber) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Phone")));
		ele1 = driver.findElement(By.id("Phone"));
		ele1.sendKeys(phNumber);
	}

	@Then("Check error message is displayed or not for invalid file upload")
	public void check_error_message_is_displayed_or_not_for_invalid_file_upload() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast Toastify__toast--default danger']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast Toastify__toast--default danger']"));
		String actText = ele1.getText();
		System.out.println("Error message displayed like: " + actText);
		String expText="Invalid file format!";
		Assert.assertEquals("Invalid Error message is displayed", actText, expText);
		
	}
	
	@Then("Enter valid address1 details {string}")
	public void enter_valid_address1_details(String address1) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Address1")));
		ele1 = driver.findElement(By.name("Address1"));
		ele1.sendKeys(address1);
	}

	@Then("Enter valid address2 details {string}")
	public void enter_valid_address2_details(String address2) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Address2")));
		ele1 = driver.findElement(By.name("Address2"));
		ele1.sendKeys(address2);
	}

	@Then("Enter valid city details {string}")
	public void enter_valid_city_details(String city) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("City")));
		ele1 = driver.findElement(By.name("City"));
		ele1.sendKeys(city);
	}

	@Then("Select valid country {string} in the dropdown")
	public void select_valid_country_in_the_dropdown(String country) throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[3]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[3]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='India']"));
		ele2.click();
	}

	@Then("Select valid state {string} in the dropdown")
	public void select_valid_state_in_the_dropdown(String state) throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[4]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[4]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Tamil Nadu']"));
		ele2.click();
	}

	@Then("Select valid timezone {string} in the dropdown")
	public void select_valid_timezone_in_the_dropdown(String timezone) throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("(//div[@class='react-select__value-container react-select__value-container--has-value css-1hwfws3'])[5]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='react-select__value-container react-select__value-container--has-value css-1hwfws3'])[5]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Asia/Kolkata']"));
		ele2.click();
	}

	@Then("Select {string} Option in status dropdown")
	public void select_option_in_status_dropdown(String string) throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[1]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='All']"));
		ele2.click();
	}

	@Then("Enter valid zipcode {string}")
	public void enter_valid_zipcode(String zipCode) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("ZipCode")));
		ele1 = driver.findElement(By.name("ZipCode"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.sendKeys(zipCode);
	}

	@Then("Upload valid file in the profile upload page")
	public void upload_valid_file_in_the_profile_upload_page() throws InterruptedException, AWTException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='imageUpload']//button[1]")));
		ele1 = driver.findElement(By.xpath("//div[@id='imageUpload']//button[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 0)");
		Thread.sleep(2000);
		ele1.click();
		// Upload the file
		Thread.sleep(2000);
		String filePath = "C:\\Users\\thirumaran\\eclipse-workspace\\NexTestify_Cucumber\\Files\\Sample.png";
		Robot robot = new Robot();
		StringSelection selection = new StringSelection(filePath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		driver.switchTo().defaultContent();
	}

	@Then("Select No option in the 2FA tab")
	public void select_no_option_in_the_2fa_tab() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@name='twoauthstatus'])[2]")));
		ele1 = driver.findElement(By.xpath("(//input[@name='twoauthstatus'])[2]"));
		ele1.click();
	}

	@Then("Check error message is displayed or not")
	public void check_error_message_is_displayed_or_not() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Phone")));
		ele1 = driver.findElement(By.id("Phone"));
		String borderColor;
		try {
			borderColor = ele1.getCssValue("border-color");
			System.out.println("Actual Border color is: "+borderColor);
		} catch (Exception e) {
			borderColor = "not available";
			System.out.println("Error getting border color: " + e.getMessage());
		}
		String expectedBorderColor = "rgb(255, 0, 0)";
		System.out.println("Expected border color is : " + expectedBorderColor);
		Assert.assertEquals("Red border is not displayed in valid tab", borderColor, expectedBorderColor);
	}

	@Then("Check success message is displayed or not")
	public void check_success_message_is_displayed_or_not() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actText = ele1.getText();
		System.out.println("Success message displayed like: " + actText);
		String expText="Admin User created successfully!";
		Assert.assertEquals("User cannot able to create the admin (or) success message is not displayed properly", actText, expText);
	}

	@Then("Check admin user created success message is displayed or not")
	public void check_admin_user_created_success_message_is_displayed_or_not() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actText = ele1.getText();
		System.out.println("Success message displayed like: " + actText);
		String expText="Admin User added successfully!";
		boolean displayed = ele1.isDisplayed();
		System.out.println("success message is: "+displayed);
		Assert.assertTrue(ele1.isDisplayed());
//		if(ele1.isDisplayed()) {
//		Assert.assertEquals("User cannot able to create the admin (or) success message is not displayed properly", actText, expText);
//		}
	}
	
	@Then("Check admin user updated success message is displayed or not")
	public void check_admin_user_updated_success_message_is_displayed_or_not() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actText = ele1.getText();
		System.out.println("Success message displayed like: " + actText);
		String expText="Admin User updated successfully!";
		Assert.assertEquals("User cannot able to create the admin (or) success message is not displayed properly", actText, expText);
	}
	
	@Given("Enter user name {string} in the Search box")
	public void enter_user_name_in_the_search_box(String userName) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("fname")));
		ele1 = driver.findElement(By.name("fname"));
		ele1.clear();
		Thread.sleep(2000);
		ele1.sendKeys(userName);
		Thread.sleep(2000);
		ele1.sendKeys(Keys.ENTER);
	}

	@When("Click Edit button")
	public void click_edit_button() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//button[contains(@class,'btn-icon btn-icon-start')]")));
		ele1 = driver.findElement(By.xpath("//button[contains(@class,'btn-icon btn-icon-start')]"));
		ele1.click();
	}

	@Then("Modify valid details in edit admin page")
	public void modify_valid_details_in_edit_admin_page() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("City")));
		ele1 = driver.findElement(By.name("City"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		String cityName = ele1.getDomProperty("value");
		int length = cityName.length();
		for (int i = 0; i < length; i++) {
			ele1.sendKeys(Keys.BACK_SPACE);
		}
		Thread.sleep(2000);
		ele1.sendKeys(cityName);
	}

	@Then("Click update button in edit admin page")
	public void click_update_button_in_edit_admin_page() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[normalize-space(text())='Update']")));
		ele1 = driver.findElement(By.xpath("//button[normalize-space(text())='Update']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 0)");
		Thread.sleep(2000);
		ele1.click();
	}

	@Then("Change the status to inactive mode")
	public void change_the_status_to_inactive_mode() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//button[contains(@class,'ant-switch text-primary')]//span)[1]")));
		ele1 = driver.findElement(By.xpath("(//button[contains(@class,'ant-switch text-primary')]//span)[1]"));
		String text = ele1.getText();
		System.out.println("Text contains: " + text);
		Thread.sleep(2000);
		if (text.contains("Yes")) {
			ele1.click();
		} else {
			System.out.println("Status already in Inactive state");
		}
	}

	@Then("Change the status to active mode")
	public void change_the_status_to_active_mode() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//button[contains(@class,'ant-switch text-primary')]//span)[1]")));
		ele1 = driver.findElement(By.xpath("(//button[contains(@class,'ant-switch text-primary')]//span)[1]"));
		String text = ele1.getText();
		System.out.println("Text contains: " + text);
		Thread.sleep(2000);
		if (text.contains("No")) {
			ele1.click();
		} else {
			System.out.println("Status already in Active state");
		}
	}

	@Then("Check the status is inactive or not in the grid of the same username")
	public void check_the_status_is_inactive_or_not_in_the_grid_of_the_same_username() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[normalize-space(text())='Inactive']")));
		ele1 = driver.findElement(By.xpath("//span[normalize-space(text())='Inactive']"));
		String actualStatus = ele1.getText();
		System.out.println("Status is displayed as: " + actualStatus);
		String expectedStatus = "Inactive";
		Assert.assertEquals("Status is not changed", actualStatus, expectedStatus);
	}

	@Then("Check the status is active or not in the grid of the same username")
	public void check_the_status_is_active_or_not__in_the_grid_of_the_same_username() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[normalize-space(text())='Active']")));
		ele1 = driver.findElement(By.xpath("//span[normalize-space(text())='Active']"));
		String actualStatus = ele1.getText();
		System.out.println("Status is displayed as: " + actualStatus);
		String expectedStatus = "Active";
		Assert.assertEquals("Status is not changed", actualStatus, expectedStatus);
	}

	@Then("Click change email button")
	public void click_change_email_button() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//b[normalize-space(text())='Change Email']")));
		ele1 = driver.findElement(By.xpath("//b[normalize-space(text())='Change Email']"));
		ele1.click();
	}

	@Then("Click close button of the pop up")
	public void click_close_button_of_the_pop_up() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='modal-header']//div)[3]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='modal-header']//div)[3]"));
		ele1.click();
	}

	@Then("Enter existing {string} email id")
	public void enter_existing_email_id(String emailId) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("newemail")));
		ele1 = driver.findElement(By.id("newemail"));
		ele1.sendKeys(emailId);
	}

	@Then("Click verify email button")
	public void click_verify_email_button() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//button[contains(@class,'btn btn-outline-primary')]")));
		ele1 = driver.findElement(By.xpath("//button[contains(@class,'btn btn-outline-primary')]"));
		ele1.click();
	}

	@Then("Enter valid email id")
	public void enter_valid_email_id() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("newemail")));
		ele1 = driver.findElement(By.id("newemail"));
		Faker fakename = new Faker();
		String firstName = fakename.name().firstName();
		String email = firstName.toLowerCase() + "@guerrillamail.info";
		ele1.sendKeys(email);
	}

	@Then("Enter valid email id login page {string}")
	public void enter_valid_email_id_login_page(String emailId) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("email")));
		ele1 = driver.findElement(By.name("email"));
		ele1.sendKeys(emailId);
	}

	@Then("Enter invalid password {string}")
	public void enter_invalid_password(String password) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("password")));
		ele1 = driver.findElement(By.name("password"));
		ele1.sendKeys(password);
	}

	@Then("Click login button 5times")
	public void click_login_button_5times() throws InterruptedException {
		try {
			// Wait for the button to be present (up to 30 seconds)
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions
					.presenceOfElementLocated(By.xpath("//div[@class='text-center mt-1']//button[1]")));

			// Find the button element
			WebElement button = driver.findElement(By.xpath("//div[@class='text-center mt-1']//button[1]"));

			// Click the button 5 times with a 1-second interval
			for (int i = 0; i < 5; i++) {
				button.click();
				Thread.sleep(1000);

				// Wait for the toast notification element to appear (if applicable)
				try {
					wait.until(ExpectedConditions
							.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
					WebElement toast = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
					String text = toast.getText();
					System.out.println("Error message displayed like: " + text);
				} catch (Exception e) {
					// Handle cases where the toast notification may not appear
					System.out.println("Toast notification not found.");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Then("Check lock message is displayed or not")
	public void check_lock_message_is_displayed_or_not() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String text = ele1.getText();
		System.out.println("Error message displayed like: " + text);
	}

	@Then("Click unlock button")
	public void click_unlock_button() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='btn btn-danger']")));
		ele1 = driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}

	@Then("Click no button in the pop up")
	public void click_no_button_in_the_pop_up() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[normalize-space(text())='No']")));
		ele1 = driver.findElement(By.xpath("//button[normalize-space(text())='No']"));
		ele1.click();
	}

	@Then("Click yes button in the pop up")
	public void click_yes_button_in_the_pop_up() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[normalize-space(text())='Yes']")));
		ele1 = driver.findElement(By.xpath("//button[normalize-space(text())='Yes']"));
		ele1.click();
	}

	@Then("Check unlock button is displayed or not")
	public void check_unlock_button_is_displayed_or_not() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='btn btn-danger']")));
		ele1 = driver.findElement(By.xpath("//button[@class='btn btn-danger']"));
		if (ele1.isDisplayed()) {
			System.out.println("Unlock button is displayed");
		} else {
			System.out.println("Unlock button is not displayed");
		}
	}

	@Then("Check page navigates to create admin page or not")
	public void check_page_navigates_to_create_admin_page_or_not() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//div[contains(@class,'text-primary text-center')])[2]")));
		ele1 = driver.findElement(By.xpath("(//div[contains(@class,'text-primary text-center')])[2]"));
		String actualText = ele1.getText();
		String expectedText = "PROFILE";
		Assert.assertEquals("Page doesnot navigates to create admin page after click back button", actualText,
				expectedText);
	}

	@Then("Check mandatory red border is displayed or not in mandatory tabs")
	public void check_mandatory_red_border_is_displayed_or_not_in_mandatory_tabs() throws InterruptedException {
		Thread.sleep(2000);
		String expectedBorderColor1 = "rgb(255, 0, 0)";
		String expectedBorderColor2 = "rgb(78, 78, 78)";
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("FirstName")));
			ele1 = driver.findElement(By.id("FirstName"));
			ele2 = driver.findElement(By.id("LastName"));
			ele3 = driver.findElement(By.id("Email"));
			ele4 = driver.findElement(By.xpath(
					"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[1]"));
			ele5 = driver.findElement(By.xpath(
					"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]"));
			ele6 = driver.findElement(By.xpath(
					"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[3]"));

			String borderColor1 = ele1.getCssValue("border-color");
			System.out.println("1st tab color is: " + borderColor1);
			String borderColor2 = ele2.getCssValue("border-color");
			System.out.println("2nd tab color is: " + borderColor2);
			String borderColor3 = ele3.getCssValue("border-color");
			System.out.println("3rd tab color is: " + borderColor3);
			String borderColor4 = ele4.getCssValue("border-color");
			System.out.println("4th tab color is: " + borderColor4);
			String borderColor5 = ele5.getCssValue("border-color");
			System.out.println("5th tab color is: " + borderColor5);
			String borderColor6 = ele6.getCssValue("border-color");
			System.out.println("6th tab color is: " + borderColor6);

			// Assertions for border color
			Assert.assertEquals("Red border is not displayed", borderColor1, expectedBorderColor1);
			Assert.assertEquals("Red border is not displayed", borderColor2, expectedBorderColor1);
			Assert.assertEquals("Red border is not displayed", borderColor3, expectedBorderColor1);
			Assert.assertEquals("Red border is not displayed", borderColor4, expectedBorderColor2);
			Assert.assertEquals("Red border is not displayed", borderColor5, expectedBorderColor2);
			Assert.assertEquals("Red border is not displayed", borderColor6, expectedBorderColor2);

		} catch (Exception e) {
			System.out.println("Error getting border color: " + e.getMessage());
		}
	}

}