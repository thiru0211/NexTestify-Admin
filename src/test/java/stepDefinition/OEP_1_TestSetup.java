package stepDefinition;

import java.time.Duration;
import java.util.UUID;

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

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OEP_1_TestSetup {
	public WebDriver driver;
	public WebElement ele, ele1, ele2, ele3, ele4, ele5, ele6, ele7, ele8, ele9;
	public WebDriverWait wait;

	@Given("To Check Test Setup is navigating to OEP URL is {string}")
	public void to_check_test_setup_is_navigating_to_oep_url_is(String url) {
		System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--headless=new");
		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get(url);
	}

	@When("To Check Test Setup Enter username and password are {string} and {string}")
	public void to_check_test_setup_enter_username_and_password_are_and(String userName, String password) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.name("email")));
		ele1 = driver.findElement(By.name("email"));
		ele1.clear();
		ele1.sendKeys(userName);
		ele2 = driver.findElement(By.name("password"));
		ele2.clear();
		ele2.sendKeys(password);
	}

	@When("click the Signin button To Check Test Setup")
	public void click_the_signin_button_to_check_test_setup() {
		ele1 = driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
		ele1.click();
	}

	@Then("Close Test Setup button")
	public void close_test_setup_button() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
		System.out.print("Page is closed");
	}

	@Then("Click Test Setup button")
	public void click_test_setup_button() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(.,'Test SetupTest Setup')]")));
		ele1 = driver.findElement(By.xpath("//li[contains(.,'Test SetupTest Setup')]"));
		Actions action = new Actions(driver);
		action.moveToElement(ele1).build().perform();
		ele1.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='Test Setup'])[2]")));
		ele2 = driver.findElement(By.xpath("(//span[text()='Test Setup'])[2]"));
		ele2.click();
		driver.navigate().refresh();
	}

	@Given("Enter valid test name {string} in the searchbox")
	public void enter_valid_test_name_in_the_searchbox(String username) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.name("txtSearch")));
		ele1 = driver.findElement(By.name("txtSearch"));
		String tabvalue = ele1.getDomProperty("value");
		int length = tabvalue.length();
		Thread.sleep(2000);
		for (int i = 0; i < length; i++) {
			ele1.sendKeys(Keys.CONTROL + "a");
			Thread.sleep(1000);
			ele1.sendKeys(Keys.BACK_SPACE);
		}
		Thread.sleep(2000);
		ele1.sendKeys(username);
		Thread.sleep(2000);
		ele1.sendKeys(Keys.ENTER);
	}

	@When("Enter valid date {string} in the searchbox")
	public void enter_valid_date_in_the_searchbox(String date) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.name("txtSearch")));
		ele1 = driver.findElement(By.name("txtSearch"));
		ele1.click();
		String tabvalue = ele1.getDomProperty("value");
		int length = tabvalue.length();
		Thread.sleep(2000);
		for (int i = 0; i < length; i++) {
			ele1.sendKeys(Keys.CONTROL + "a");
			Thread.sleep(1000);
			ele1.sendKeys(Keys.BACK_SPACE);
		}
		Thread.sleep(2000);
		ele1.sendKeys(date);
		Thread.sleep(2000);
	}

	@Then("Enter valid description {string} in the searchbox")
	public void enter_valid_description_in_the_searchbox(String description) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.name("txtSearch")));
		ele1 = driver.findElement(By.name("txtSearch"));
		ele1.click();
		String tabvalue = ele1.getDomProperty("value");
		int length = tabvalue.length();
		Thread.sleep(2000);
		for (int i = 0; i < length; i++) {
			ele1.sendKeys(Keys.CONTROL + "a");
			Thread.sleep(1000);
			ele1.sendKeys(Keys.BACK_SPACE);
		}
		Thread.sleep(2000);
		ele1.sendKeys(description);
		Thread.sleep(2000);
	}

	@Given("Select {string} 1st Option in the dropdown")
	public void select_1st_option_in_the_dropdown(String string) throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//div[@class='react-select__single-value css-1uccc91-singleValue'])[1]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='react-select__single-value css-1uccc91-singleValue'])[1]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='All Status']"));
		Thread.sleep(2000);
		ele2.click();
	}

	@Given("Select {string} 1st Option in dropdown")
	public void select_1st_option_in_dropdown(String string) throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='All Test']"));
		ele2.click();
	}
	@Then("Click take picture button in test setup")
	public void click_take_picture_button_in_test_setup() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//button[normalize-space(text())='Take Picture']")));
		ele1 = driver.findElement(By.xpath(
				"//button[normalize-space(text())='Take Picture']"));
		ele1.click();
	}
	@When("Select {string} 2nd Option in the dropdown")
	public void select_2nd_option_in_the_dropdown(String string) throws InterruptedException {
		Thread.sleep(4000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//div[@class='react-select__single-value css-1uccc91-singleValue'])[1]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='react-select__single-value css-1uccc91-singleValue'])[1]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='In Progress']"));
		Thread.sleep(2000);
		ele2.click();
	}

	@When("Select {string} 2nd Option in dropdown")
	public void select_2nd_option_in_dropdown(String string) throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Practice Test']"));
		Thread.sleep(2000);
		ele2.click();
	}

	@Then("Select {string} 3rd Option in the dropdown")
	public void select_3rd_option_in_the_dropdown(String string) throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//div[@class='react-select__single-value css-1uccc91-singleValue'])[1]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='react-select__single-value css-1uccc91-singleValue'])[1]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Completed']"));
		Thread.sleep(2000);
		ele2.click();
	}

	@Then("Select {string} 3rd Option in dropdown")
	public void select_3rd_option_in_dropdown(String string) throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Main Test']"));
		Thread.sleep(2000);
		ele2.click();
	}

	@Then("Select {string} 4th Option in the dropdown")
	public void select_4th_option_in_the_dropdown(String string) throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("(//div[@class='react-select__single-value css-1uccc91-singleValue'])[1]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='react-select__single-value css-1uccc91-singleValue'])[1]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Frozen']"));
		Thread.sleep(2000);
		ele2.click();
	}

	@Then("Check In Progress details displayed or not")
	public void check_in_progress_details_displayed_or_not() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='IN PROGRESS'])[1]")));
		ele1 = driver.findElement(By.xpath("(//span[text()='IN PROGRESS'])[1]"));
		String actualStatus = ele1.getText();
		String expectedStatus = "IN PROGRESS";
		Assert.assertEquals("Page displayed invalid details", actualStatus, expectedStatus);
	}

	@When("Check entered {string} test name details is displayed or not in the test setup page")
	public void check_entered_test_name_details_is_displayed_or_not_in_the_test_setup_page(String testName)
			throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='fs-16 text-bold text-primary']")));
		ele1 = driver.findElement(By.xpath("//div[@class='fs-16 text-bold text-primary']"));
		Thread.sleep(2000);
		ele1 = driver.findElement(By.xpath("//div[@class='fs-16 text-bold text-primary']"));
		String actualTestName = ele1.getText();
		System.out.println("Actual test name displayed as: " + actualTestName);
		String expectedTestName = testName;
		Assert.assertEquals("Page displayed invalid details", actualTestName, expectedTestName);
	}

	@Then("Check entered {string} date details is displayed or not in the test setup page")
	public void check_entered_date_details_is_displayed_or_not_in_the_test_setup_page(String date)
			throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='text-bold mb-1']")));
		Thread.sleep(2000);
		ele1 = driver.findElement(By.xpath("//div[@class='text-bold mb-1']"));
		String actualDate = ele1.getText();
		System.out.println("Actual date displayed as: " + actualDate);
		String expectedDate = date;
		Assert.assertEquals("Page displayed invalid details", actualDate, expectedDate);
	}

	@Then("Check entered {string} description details is displayed or not in the test setup page")
	public void check_entered_description_details_is_displayed_or_not_in_the_test_setup_page(String description)
			throws InterruptedException {
		Thread.sleep(4000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='text-muted']")));
		Thread.sleep(2000);
		ele1 = driver.findElement(By.xpath("//div[@class='text-muted']"));
		String actualDescription = ele1.getText();
		System.out.println("Actual description displayed as: " + actualDescription);
		String expectedDescription = description;
		Assert.assertEquals("Page displayed invalid details", actualDescription, expectedDescription);
	}

	@Then("Check selected {string} option is displayed or not")
	public void check_selected_option_is_displayed_or_not(String option) throws InterruptedException {
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='text-muted mb-1'])[1]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='text-muted mb-1'])[1]"));
		String actualDescription = ele1.getText();
		System.out.println("Actual description displayed as: " + actualDescription);
		boolean testTypeContains = actualDescription.contains(option);
//		
//		String expectedDescription = option;
//		Assert.assertEquals("Page displayed invalid details", actualDescription, expectedDescription);\

		Assert.assertTrue(testTypeContains);
	}

	@Then("Check Completed details displayed or not")
	public void check_completed_details_displayed_or_not() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='COMPLETED'])[1]")));
		ele1 = driver.findElement(By.xpath("(//span[text()='COMPLETED'])[1]"));
		String actualStatus = ele1.getText();
		String expectedStatus = "COMPLETED";
		Assert.assertEquals("Page displayed invalid details", actualStatus, expectedStatus);
	}

	@Then("Check Frozen details displayed or not")
	public void check_frozen_details_displayed_or_not() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[text()='FROZEN'])[1]")));
		ele1 = driver.findElement(By.xpath("(//span[text()='FROZEN'])[1]"));
		String actualStatus = ele1.getText();
		String expectedStatus = "FROZEN";
		Assert.assertEquals("Page displayed invalid details", actualStatus, expectedStatus);
	}

	@Given("Click new test button")
	public void click_new_test_button() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-primary']")));
		ele1 = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		Thread.sleep(2000);
		ele1.click();
	}

	@Then("Click back button")
	public void click_back_button() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(@class,'btn btn-sm')])[1]")));
		ele1 = driver.findElement(By.xpath("(//button[contains(@class,'btn btn-sm')])[1]"));
		ele1.click();
	}

	@Then("Check the landing page")
	public void check_the_landing_page() throws InterruptedException {
		Thread.sleep(2000);
//		String actualUrl = driver.getCurrentUrl();
//		String expectedUrl = "http://192.168.1.30/OEPADMIN/Testsetup/Setup";
//		Assert.assertEquals("Page doesnot landed to test setup homepage", actualUrl, expectedUrl);
		ele1 = driver.findElement(By.name("txtSearch"));
		boolean displayed = ele1.isDisplayed();
		Assert.assertTrue("Back button is not working", displayed);
	}

	@Then("Click save button")
	public void click_save_button() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Save']")));
		ele1 = driver.findElement(By.xpath("//button[text()='Save']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}

	@Then("Check mandatory red border is displayed or not")
	public void check_mandatory_red_border_is_displayed_or_not() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("testName")));
		ele1 = driver.findElement(By.id("testName"));
		String borderColor;
		try {
			borderColor = ele1.getCssValue("border-color");
			System.out.println("Red border is displayed and its code is: " + borderColor);
		} catch (Exception e) {
			borderColor = "not available";
			System.out.println("Error getting border color: " + e.getMessage());
		}
		String expectedBorderColor = "rgb(255, 0, 0)";
		System.out.println("Actual border color : " + borderColor);
		Assert.assertEquals("Red border is not displayed in the mandatory field", borderColor, expectedBorderColor);
	}

	@Then("Click Main Test radio button")
	public void click_main_test_radio_button() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@name='ttype'])[2]")));
		ele1 = driver.findElement(By.xpath("(//input[@name='ttype'])[2]"));
		ele1.click();
	}

	@Then("Enter alpha {string} characters in Proctoring Capacity tab")
	public void enter_alpha_characters_in_proctoring_capacity_tab(String capacity) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("proctor")));
		ele1 = driver.findElement(By.id("proctor"));
		ele1.sendKeys(capacity);
	}

	@Then("Check tab is empty or not in Proctoring Capacity tab")
	public void check_tab_is_empty_or_not_in_proctoring_capacity_tab() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("proctor")));
		ele1 = driver.findElement(By.id("proctor"));
		String tabDetails = ele1.getDomProperty("value");
		System.out.println("Proctoring Capacity tab contains: " + tabDetails);
		boolean tabValue = tabDetails.isEmpty();
		Assert.assertTrue("Tab accept alpha or special characters", tabValue);
	}

	@Then("Enter special {string} characters in Proctoring Capacity tab")
	public void enter_special_characters_in_proctoring_capacity_tab(String capacity) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("proctor")));
		ele1 = driver.findElement(By.id("proctor"));
		ele1.sendKeys(capacity);
	}

	@Then("Enter more than max characters {string} in Proctoring Capacity tab")
	public void enter_more_than_max_characters_in_proctoring_capacity_tab(String maxCharacters) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("proctor")));
		ele1 = driver.findElement(By.id("proctor"));
		ele1.sendKeys(maxCharacters);
	}

	@Then("Check the tab contains more than maximum character or not")
	public void check_the_tab_contains_more_than_maximum_character_or_not() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("proctor")));
		ele1 = driver.findElement(By.id("proctor"));
		String tabValue = ele1.getDomProperty("value");
		int actualTotalDigits = tabValue.replaceAll("\\D+", "").length();
		System.out.println("Total digits present in the tab: " + actualTotalDigits);
		int expectedTotalDigits = 3;
		Assert.assertEquals("Proctoring capacity Tab accept more than maximum characters", actualTotalDigits,
				expectedTotalDigits);
//		if (tabValue.replaceAll("\\D+", "").length() > 3) {
//			System.out.println("The tab contains more than three digits.");
//		} else {
//			System.out.println("The tab contains three digits or less.");
//		}

	}

	@Then("Click Practice Test radio button")
	public void click_practice_test_radio_button() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@name='ttype'])[1]")));
		ele1 = driver.findElement(By.xpath("(//input[@name='ttype'])[1]"));
		ele1.click();
	}

	@Then("Enter valid test name")
	public void enter_valid_test_name() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.name("testName")));
		ele1 = driver.findElement(By.name("testName"));
//		Faker fakename = new Faker();
//		String firstName = fakename.name().
		String uuid = UUID.randomUUID().toString();
		String randomTestName = "Test_" + uuid.substring(0, 8);
		ele1.sendKeys(randomTestName);
		
	}

	@Then("Select valid subject name")
	public void select_valid_subject_name() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[1]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[1]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Artificial Intelligence']"));
		ele2.click();
	}

	@Then("Select valid level")
	public void select_valid_level() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Easy']"));
		ele2.click();
	}

	@Then("Enter valid description details")
	public void enter_valid_description_details() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.name("desc")));
		ele1 = driver.findElement(By.name("desc"));
		ele1.sendKeys("Sample Test");
	}

	@Then("Click clear button")
	public void click_clear_button() throws InterruptedException {
		Thread.sleep(15000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='click here to clear']")));
		ele1 = driver.findElement(By.xpath("//button[@title='click here to clear']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}

	@Then("Check all tabs are cleared or not in main test")
	public void check_all_tabs_are_cleared_or_not_in_main_test() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.name("testName")));
		ele1 = driver.findElement(By.name("testName"));
		String testNameTab = ele1.getDomProperty("value");
		wait.until(ExpectedConditions.elementToBeClickable(By.name("proctor")));
		ele2 = driver.findElement(By.name("proctor"));
		String proctorTab = ele2.getDomProperty("value");
		Assert.assertTrue("Test name tab is not cleared", testNameTab.isEmpty());
		Assert.assertTrue("Proctor tab is not cleared", proctorTab.isEmpty());
	}

	@Then("Check all tabs are cleared or not in question manager")
	public void check_all_tabs_are_cleared_or_not_in_question_manager() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.name("question")));
		ele1 = driver.findElement(By.name("question"));
		String overallQuestionTab = ele1.getDomProperty("value");
		wait.until(ExpectedConditions.elementToBeClickable(By.name("score")));
		ele1 = driver.findElement(By.name("score"));
		String overallPTab = ele1.getDomProperty("value");
		Assert.assertTrue("Overall question Tab is not cleared", overallQuestionTab.isEmpty());
		Assert.assertTrue("Overall points Tab is not cleared", overallPTab.isEmpty());
	}

	@Then("Check all tabs are cleared or not")
	public void check_all_tabs_are_cleared_or_not() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.name("testName")));
		ele1 = driver.findElement(By.name("testName"));
		String testNameTab = ele1.getDomProperty("value");
		wait.until(ExpectedConditions.elementToBeClickable(By.name("proctor")));
		ele2 = driver.findElement(By.name("proctor"));
		String proctorTab = ele2.getDomProperty("value");
		Assert.assertTrue("Test name tab is not cleared", testNameTab.isEmpty());
		Assert.assertTrue("Proctor tab is not cleared", proctorTab.isEmpty());
	}

	@Then("Enter valid Proctoring Capacity count")
	public void enter_valid_proctoring_capacity_count() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.name("proctor")));
		ele1 = driver.findElement(By.name("proctor"));
		ele1.sendKeys("5");
	}

	@Then("Check success message is displayed or not in test portal page")
	public void check_success_message_is_displayed_or_not_in_test_portal_page() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String text = ele1.getText();
		System.out.println("Success message displayed like: " + text);
	}

	@Then("Check success message is displayed or not in Basic Settings tab")
	public void check_success_message_is_displayed_or_not_in_basic_settings_tab() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actualMsg = ele1.getText();
		System.out.println("Success message displayed like: " + actualMsg);
		String expectedMsg = "Basic Settings saved successfully!";
		Assert.assertEquals("Success message is not displayed", actualMsg, expectedMsg);
	}

	@Then("Check success message is displayed or not in Finalize Test tab")
	public void check_success_message_is_displayed_or_not_in_Finalize_test_tab() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actualMsg = ele1.getText();
		System.out.println("Success message displayed like: " + actualMsg);
		String expectedMsg = "Test finalized successfully!";
		Assert.assertEquals("Success message is not displayed", actualMsg, expectedMsg);
	}

	@Then("Check success message is displayed or not in Question Manager tab")
	public void check_success_message_is_displayed_or_not_in_question_manager_tab() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actualMsg = ele1.getText();
		System.out.println("Success message displayed like: " + actualMsg);
		String expectedMsg = "Question Manager saved successfully!";
		Assert.assertEquals("Success message is not displayed", actualMsg, expectedMsg);
	}

	@Then("Check success message is displayed or not in time setup tab")
	public void check_success_message_is_displayed_or_not_in_time_setup_tab() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actualMsg = ele1.getText();
		System.out.println("Success message displayed like: " + actualMsg);
		String expectedMsg = "Time Setup saved successfully!";
		Assert.assertEquals("Success message is not displayed", actualMsg, expectedMsg);
	}

	@Then("Enter invalid {string} Test activation Date and Time in time setup tab")
	public void enter_invalid_test_activation_date_and_time_in_time_setup_tab(String invalidDate)
			throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='form-control'])[2]")));
		ele1 = driver.findElement(By.xpath("(//input[@class='form-control'])[2]"));

		String testActDate = ele1.getDomProperty("value");
		int testActDateLength = testActDate.length();
		for (int i = 0; i < testActDateLength; i++) {
			ele1.sendKeys(Keys.BACK_SPACE);
		}
		Thread.sleep(2000);
		ele1.sendKeys(invalidDate);
	}

	@Then("Enter invalid {string} Last Registration Date and Time in time setup tab")
	public void enter_invalid_last_registration_date_and_time_in_time_setup_tab(String invalidDate)
			throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[normalize-space(text())='Last Registration Date & Time']")));
		ele1 = driver.findElement(By.xpath("//div[normalize-space(text())='Last Registration Date & Time']"));
		ele1.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='form-control'])[3]")));
		ele2 = driver.findElement(By.xpath("(//input[@class='form-control'])[3]"));
		String lastRegDate = ele2.getDomProperty("value");
		int lastRegDateLength = lastRegDate.length();
		for (int i = 0; i < lastRegDateLength; i++) {
			ele2.sendKeys(Keys.BACK_SPACE);
		}
		Thread.sleep(2000);
		ele2.sendKeys(invalidDate);
	}

	@Then("Check error message is displayed or not in time setup tab")
	public void check_error_message_is_displayed_or_not_in_time_setup_tab() throws InterruptedException {
		Thread.sleep(1500);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actualMsg = ele1.getText();
		System.out.println("Error message displayed like: " + actualMsg);
		String expectedMsg = "Last registration date and time must be at least 24 hours prior to the test activation date and time!";
		Assert.assertEquals("Error message is not displayed", actualMsg, expectedMsg);
	}

	@Then("Enter valid {string} Test activation Date and Time in time setup tab")
	public void enter_valid_test_activation_date_and_time_in_time_setup_tab(String validDate)
			throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='form-control'])[2]")));
		ele1 = driver.findElement(By.xpath("(//input[@class='form-control'])[2]"));
		String testActDate = ele1.getDomProperty("value");
		int testActDateLength = testActDate.length();
		for (int i = 0; i < testActDateLength; i++) {
			ele1.sendKeys(Keys.BACK_SPACE);
		}
		Thread.sleep(2000);
		ele1.sendKeys(validDate);
	}

	@Then("Enter valid {string} Last Registration Date and Time in time setup tab")
	public void enter_valid_last_registration_date_and_time_in_time_setup_tab(String validDate)
			throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[normalize-space(text())='Last Registration Date & Time']")));
		ele1 = driver.findElement(By.xpath("//div[normalize-space(text())='Last Registration Date & Time']"));
		ele1.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='form-control'])[3]")));
		ele2 = driver.findElement(By.xpath("(//input[@class='form-control'])[3]"));
		String lastRegDate = ele2.getDomProperty("value");
		int lastRegDateLength = lastRegDate.length();
		for (int i = 0; i < lastRegDateLength; i++) {
			ele2.sendKeys(Keys.BACK_SPACE);
		}
		Thread.sleep(2000);
		ele2.sendKeys(validDate);
	}

	@Given("Search any valid main test name")
	public void search_any_valid_main_test_name() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.name("txtSearch")));
		ele1 = driver.findElement(By.name("txtSearch"));
		ele1.click();
		Thread.sleep(2000);
		ele1.clear();
		Thread.sleep(2000);
		ele1.sendKeys("Sample Main Test For Automation Testing");
		Thread.sleep(4000);
	}

	@Then("Click the test name")
	public void click_the_test_name() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[text()='Sample Main Test For Automation Testing']")));
		ele1 = driver.findElement(By.xpath("//div[text()='Sample Main Test For Automation Testing']"));
		ele1.click();
	}

	@Then("Click the practice test name")
	public void click_the_practice_test_name() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Sample Test-Practice']")));
		ele1 = driver.findElement(By.xpath("//div[text()='Sample Test-Practice']"));
		ele1.click();
	}

	@Then("Click question manager tab")
	public void click_question_manager_tab() throws InterruptedException {
		Thread.sleep(15000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(90));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Question Manager']")));
		ele1 = driver.findElement(By.xpath("//button[text()='Question Manager']"));
		Thread.sleep(3000);
		ele1 = driver.findElement(By.xpath("//button[text()='Question Manager']"));
		ele1.click();
	}

	@Then("Enter alpha characters in Overall Questions")
	public void enter_alpha_characters_in_overall_questions() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.name("question")));
		ele1 = driver.findElement(By.name("question"));
		String overallQuestionValue = ele1.getDomProperty("value");
		int length = overallQuestionValue.length();
		Thread.sleep(2000);
		for (int i = 0; i < length; i++) {
			ele1.sendKeys(Keys.CONTROL + "a");
			Thread.sleep(1000);
			ele1.sendKeys(Keys.BACK_SPACE);
		}
		Thread.sleep(2000);
		ele1.sendKeys("Sample");
	}

	@Then("Check tab is empty or not in Overall Questions")
	public void check_tab_is_empty_or_not_in_overall_questions() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.name("question")));
		ele1 = driver.findElement(By.name("question"));
		String actualText = ele1.getDomProperty("value");
		Assert.assertTrue("User can able to enter the alpha and special characters", actualText.isEmpty());
	}

	@Then("Enter special characters in Overall Questions")
	public void enter_special_characters_in_overall_questions() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.name("question")));
		ele1 = driver.findElement(By.name("question"));
		ele1.click();
		Thread.sleep(2000);
		ele1.clear();
		Thread.sleep(2000);
		ele1.sendKeys("!@#$%^&");
	}

	@Then("Enter alpha characters in Overall Points")
	public void enter_alpha_characters_in_overall_points() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.name("score")));
		ele1 = driver.findElement(By.name("score"));
		String points = ele1.getDomProperty("value");
		ele1.click();
		Thread.sleep(2000);
		for (int i = 0; i < points.length(); i++) {
			ele1.sendKeys(Keys.CONTROL + "a");
			Thread.sleep(1000);
			ele1.sendKeys(Keys.BACK_SPACE);
		}
		Thread.sleep(2000);
		ele1.sendKeys("Sample");
	}

	@Then("Check tab is empty or not")
	public void check_tab_is_empty_or_not() {
		wait.until(ExpectedConditions.elementToBeClickable(By.name("score")));
		ele1 = driver.findElement(By.name("score"));
		String actualText = ele1.getDomProperty("value");
		Assert.assertTrue("User can able to enter the alpha and special characters", actualText.isEmpty());
	}

	@Then("Enter special characters in Overall Points")
	public void enter_special_characters_in_overall_points() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.name("score")));
		ele1 = driver.findElement(By.name("score"));
		String points = ele1.getDomProperty("value");
		ele1.click();
		for (int i = 0; i < points.length(); i++) {
			ele1.sendKeys(Keys.CONTROL + "a");
			Thread.sleep(1000);
			ele1.sendKeys(Keys.BACK_SPACE);
		}
		Thread.sleep(2000);
		ele1.sendKeys("!@#$%^&");
	}

	@Then("Select any topic from the dropdown")
	public void select_any_topic_from_the_dropdown() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//div[contains(@class,'react-select__value-container react-select__value-container--has-value')]")));
		ele1 = driver.findElement(By.xpath(
				"//div[contains(@class,'react-select__value-container react-select__value-container--has-value')]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Block Chain']"));
		ele2.click();
	}

	@Then("Click add button")
	public void click_add_button() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Click here to Add Topic']")));
		ele1 = driver.findElement(By.xpath("//button[@title='Click here to Add Topic']"));
		ele1.click();
	}

	@Then("Check red border is displayed or not in the mandatory tab")
	public void check_red_border_is_displayed_or_not_in_the_mandatory_tab() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("question")));
		ele1 = driver.findElement(By.id("question"));
		String borderColor;
		try {
			borderColor = ele1.getCssValue("border-color");
		} catch (Exception e) {
			borderColor = "not available";
			System.out.println("Error getting border color: " + e.getMessage());
		}
		String expectedBorderColor = "rgb(255, 0, 0)";
		System.out.println("Actual border color : " + borderColor);
		Assert.assertEquals("Red border is not displayed in mandatory fields", borderColor, expectedBorderColor);
	}

	@Then("Click clear button in question manager")
	public void click_clear_button_in_question_manager() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='click here to clear']")));
		ele1 = driver.findElement(By.xpath("//button[@title='click here to clear']"));
		ele1.click();
	}

	@Then("Enter valid overall question")
	public void enter_valid_overall_question() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.name("question")));
		ele1 = driver.findElement(By.name("question"));
		ele1.click();
		Thread.sleep(2000);
		ele1.clear();
		Thread.sleep(2000);
		ele1.sendKeys("10");
	}

	@Then("Enter valid overall points")
	public void enter_valid_overall_points() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.name("score")));
		ele1 = driver.findElement(By.name("score"));
		ele1.click();
		Thread.sleep(2000);
		ele1.clear();
		Thread.sleep(2000);
		ele1.sendKeys("20");
	}

	@Then("Select valid topic")
	public void select_valid_topic() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//div[contains(@class,'react-select__value-container react-select__value-container--has-value')]")));
		ele1 = driver.findElement(By.xpath(
				"//div[contains(@class,'react-select__value-container react-select__value-container--has-value')]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Block Chain']"));
		ele2.click();
	}

	@Then("Click delete button")
	public void click_delete_button() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Click here to Delete']")));
		ele1 = driver.findElement(By.xpath("//button[@title='Click here to Delete']"));
		ele1.click();
	}

	@Then("Click No button in the pop up")
	public void click_no_button_in_the_pop_up() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//button[contains(@class,'btn btn-outline-primary')])[2]")));
		ele1 = driver.findElement(By.xpath("(//button[contains(@class,'btn btn-outline-primary')])[2]"));
		ele1.click();
	}

	@Then("Check topic is removed or not")
	public void check_topic_is_removed_or_not() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'text-bold text-center')]")));
		ele1 = driver.findElement(By.xpath("//div[contains(@class,'text-bold text-center')]"));
		String actualText = ele1.getText();
		String expectedText = "Block Chain";
		Assert.assertEquals("Topic is removed", actualText, expectedText);
	}

	@Then("Click Yes button in the pop up")
	public void click_yes_button_in_the_pop_up() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Click here to delete']")));
		ele1 = driver.findElement(By.xpath("//button[@title='Click here to delete']"));
		ele1.click();
	}

	@Then("Enter alpha characters in Questions tab")
	public void enter_alpha_characters_in_questions_tab() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("tquest-2")));
		ele1 = driver.findElement(By.id("tquest-2"));
		String questionValue = ele1.getDomProperty("value");
		int length = questionValue.length();
		Thread.sleep(2000);
		for (int i = 0; i < length; i++) {
			ele1.sendKeys(Keys.BACK_SPACE);
		}
		Thread.sleep(2000);
		ele1.sendKeys("Sample");
	}

	@Then("Check tab is empty or not in Questions tab")
	public void check_tab_is_empty_or_not_in_questions_tab() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("tquest-2")));
		ele1 = driver.findElement(By.id("tquest-2"));
		String actualText = ele1.getDomProperty("value");
		System.out.println("Question tab contains: " + actualText);
		boolean questionTabValue = actualText.isBlank();
		System.out.println("Question tab contains: " + questionTabValue);
		Assert.assertTrue("Question tab accepts alpha and special characters", questionTabValue);
	}

	@Then("Enter special characters in Questions tab")
	public void enter_special_characters_in_questions_tab() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("tquest-2")));
		ele1 = driver.findElement(By.id("tquest-2"));
		String questionValue = ele1.getDomProperty("value");
		int length = questionValue.length();
		Thread.sleep(2000);
		for (int i = 0; i < length; i++) {
			ele1.sendKeys(Keys.BACK_SPACE);
		}
		Thread.sleep(2000);
		ele1.sendKeys("!@#$%^");
	}

	@Then("Enter alpha characters in points tab")
	public void enter_alpha_characters_in_points_tab() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("tscore-2")));
		ele1 = driver.findElement(By.id("tscore-2"));
		String questionValue = ele1.getDomProperty("value");
		int length = questionValue.length();
		Thread.sleep(2000);
		for (int i = 0; i < length; i++) {
			ele1.sendKeys(Keys.BACK_SPACE);
		}
		Thread.sleep(2000);
		ele1.sendKeys("Sample Test");
	}

	@Then("Check tab is empty or not in points tab")
	public void check_tab_is_empty_or_not_in_points_tab() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("tscore-2")));
		ele1 = driver.findElement(By.id("tscore-2"));
		String actualText = ele1.getDomProperty("value");
		Assert.assertTrue("Points tab accepts alpha and special characters", actualText.isBlank());
	}

	@Then("Enter special characters in points tab")
	public void enter_special_characters_in_points_tab() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("tscore-2")));
		ele1 = driver.findElement(By.id("tscore-2"));
		String questionValue = ele1.getDomProperty("value");
		int length = questionValue.length();
		Thread.sleep(2000);
		for (int i = 0; i < length; i++) {
			ele1.sendKeys(Keys.BACK_SPACE);
		}
		Thread.sleep(2000);
		ele1.sendKeys("!@#$%^");
	}

	@Then("Enter alpha characters in Time tab")
	public void enter_alpha_characters_in_time_tab() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("ttime-2")));
		ele1 = driver.findElement(By.id("ttime-2"));
		ele1.click();
		Thread.sleep(2000);
		ele1.clear();
		Thread.sleep(2000);
		ele1.sendKeys("Sample Test");
	}

	@Then("Check tab is empty or not in Time tab")
	public void check_tab_is_empty_or_not_in_time_tab() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("ttime-2")));
		ele1 = driver.findElement(By.id("ttime-2"));
		String actualText = ele1.getDomProperty("value");
		Assert.assertTrue("Points tab accepts alpha and special characters", actualText.isEmpty());
	}

	@Then("Enter special characters in Time tab")
	public void enter_special_characters_in_time_tab() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("ttime-2")));
		ele1 = driver.findElement(By.id("ttime-2"));
		ele1.click();
		Thread.sleep(2000);
		ele1.clear();
		Thread.sleep(2000);
		ele1.sendKeys("!@#$%^");
	}

	@Then("Enter the value in questions tab more than overall questions tab")
	public void enter_the_value_in_questions_tab_more_than_overall_questions_tab() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("tquest-2")));
		ele1 = driver.findElement(By.id("tquest-2"));
		ele1.click();
		Thread.sleep(2000);
		ele1.clear();
		Thread.sleep(2000);
		ele1.sendKeys("20");
	}

	@Then("Enter the value in questions tab more than overall points tab")
	public void enter_the_value_in_questions_tab_more_than_overall_points_tab() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("tscore-2")));
		ele1 = driver.findElement(By.id("tscore-2"));
		ele1.click();
		Thread.sleep(2000);
		ele1.clear();
		Thread.sleep(2000);
		ele1.sendKeys("40");
	}

	@Then("Enter  valid in Time tab")
	public void enter_valid_in_time_tab() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("ttime-2")));
		ele1 = driver.findElement(By.id("ttime-2"));
		ele1.click();
		Thread.sleep(2000);
		ele1.clear();
		Thread.sleep(2000);
		ele1.sendKeys("0020");
	}

	@Then("check error message is displayed or not in question manager tab")
	public void check_error_message_is_displayed_or_not() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actualText = ele1.getText();
		System.out.println("Error message displayed like: " + actualText);
		String expectedText = "Overall Total not matched!";
		Assert.assertEquals("Error message is not displayed", actualText, expectedText);
	}

	@Then("Check error message is displayed or not in test access")
	public void check_error_message_is_displayed_or_not_in_test_access() throws InterruptedException {
		Thread.sleep(1000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actualText = ele1.getText();
		System.out.println("Error message displayed like: " + actualText);
		String expectedText = "Please select atleast one candidate!";
		Assert.assertEquals("Checkbox cannot able to select", actualText, expectedText);
	}

	@Then("Click save button in question manager")
	public void click_save_button_in_question_manager() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='click here to save']")));
		ele1 = driver.findElement(By.xpath("//button[@title='click here to save']"));
		ele1.click();
	}

	@Then("Enter valid overall question values")
	public void enter_valid_overall_question_values() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("question")));
		ele1 = driver.findElement(By.id("question"));
		ele1.click();
		Thread.sleep(2000);
		ele1.clear();
		Thread.sleep(2000);
		ele1.sendKeys("10");
	}

	@Then("Enter valid overall points values")
	public void enter_valid_overall_points_values() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("score")));
		ele1 = driver.findElement(By.id("score"));
		ele1.click();
		Thread.sleep(2000);
		ele1.clear();
		Thread.sleep(2000);
		ele1.sendKeys("20");
	}

	@Then("Enter valid value in questions tab")
	public void enter_valid_value_in_questions_tab() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("tquest-2")));
		ele1 = driver.findElement(By.id("tquest-2"));
		ele1.click();
		Thread.sleep(2000);
		ele1.clear();
		Thread.sleep(2000);
		ele1.sendKeys("10");
	}

	@Then("Enter valid value in questions tab in Question Manager")
	public void enter_valid_value_in_questions_tab_in_question_Manager() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("tquest-1")));
		ele1 = driver.findElement(By.id("tquest-1"));
		ele1.click();
		Thread.sleep(2000);
		ele1.clear();
		Thread.sleep(2000);
		ele1.sendKeys("10");
	}

	@Then("Enter valid value in points tab")
	public void enter_valid_value_in_points_tab() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("tscore-2")));
		ele1 = driver.findElement(By.id("tscore-2"));
		ele1.click();
		Thread.sleep(2000);
		ele1.clear();
		Thread.sleep(2000);
		ele1.sendKeys("20");
	}

	@Then("Enter valid value in points tab in Question Manager")
	public void enter_valid_value_in_points_tab_in_question_Manager() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("tscore-1")));
		ele1 = driver.findElement(By.id("tscore-1"));
		ele1.click();
		Thread.sleep(2000);
		ele1.clear();
		Thread.sleep(2000);
		ele1.sendKeys("20");
	}

	@Then("Enter valid in Time tab based on proper format")
	public void enter_valid_in_time_tab_based_on_proper_format() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("ttime-2")));
		ele1 = driver.findElement(By.id("ttime-2"));
		ele1.click();
		Thread.sleep(2000);
		ele1.clear();
		Thread.sleep(2000);
		ele1.sendKeys("0020");
	}

	@Then("Enter valid in Time tab based on proper format in Question Manager")
	public void enter_valid_in_time_tab_based_on_proper_format_in_question_manager() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("ttime-1")));
		ele1 = driver.findElement(By.id("ttime-1"));
		ele1.click();
		Thread.sleep(2000);
		ele1.clear();
		Thread.sleep(2000);
		ele1.sendKeys("0020");
	}

	@Then("Click time setup tab")
	public void click_time_setup_tab() throws InterruptedException {
		Thread.sleep(15000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Time Setup']")));
		Thread.sleep(2000);
		ele1 = driver.findElement(By.xpath("//button[text()='Time Setup']"));
		ele1.click();
	}

	@Then("Click question manager button")
	public void click_question_manager_button() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//span[normalize-space(text())='Question Manager']")));
		ele1 = driver.findElement(By.xpath("//span[normalize-space(text())='Question Manager']"));
		ele1.click();
	}

	@Then("Check landing page")
	public void check_landing_page() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//h3[normalize-space(text())='QUESTION MANAGER']")));
		ele1 = driver.findElement(By.xpath("//h3[normalize-space(text())='QUESTION MANAGER']"));
		String actualText = ele1.getText();
		String expectedText = "QUESTION MANAGER";
		Assert.assertEquals("Page doesnot landed to previous tab", actualText, expectedText);
	}

	@Given("Search any valid practice test name")
	public void search_any_valid_practice_test_name() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.name("txtSearch")));
		ele1 = driver.findElement(By.name("txtSearch"));
		ele1.click();
		Thread.sleep(2000);
		ele1.clear();
		Thread.sleep(2000);
		ele1.sendKeys("Sample Test-Practice");
		Thread.sleep(4000);
	}

	@Then("Click save button in time setup")
	public void click_save_button_in_time_setup() throws InterruptedException {
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='click here to save time setup']")));
		ele1 = driver.findElement(By.xpath("//button[@title='click here to save time setup']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(3000);
		ele1.click();
	}

	@Then("Click Grading setup tab")
	public void click_grading_setup_tab() throws InterruptedException {
		Thread.sleep(15000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Grading Setup']")));
		ele1 = driver.findElement(By.xpath("//button[text()='Grading Setup']"));
		Thread.sleep(2000);
		ele1 = driver.findElement(By.xpath("//button[text()='Grading Setup']"));
		ele1.click();
	}

	@Then("Check all features are working or not in the all respondents text box")
	public void check_all_features_are_working_or_not_in_the_all_respondents_text_box() throws InterruptedException {
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='ql-header'])[1]")));
		ele1 = driver.findElement(By.xpath("(//button[@class='ql-header'])[1]"));
		ele1.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='ql-header'])[2]")));
		ele2 = driver.findElement(By.xpath("(//button[@class='ql-header'])[2]"));
		ele2.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='ql-list'])[1]")));
		ele3 = driver.findElement(By.xpath("(//button[@class='ql-list'])[1]"));
		ele3.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='ql-list'])[2]")));
		ele4 = driver.findElement(By.xpath("(//button[@class='ql-list'])[2]"));
		ele4.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//span[@class='ql-picker-label'])[2]")));
		ele5 = driver.findElement(By.xpath("(//span[@class='ql-picker-label'])[2]"));
		ele5.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='ql-bold'])[1]")));
		ele6 = driver.findElement(By.xpath("(//button[@class='ql-bold'])[1]"));
		ele6.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='ql-italic'])[1]")));
		ele7 = driver.findElement(By.xpath("(//button[@class='ql-italic'])[1]"));
		ele7.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='ql-underline'])[1]")));
		ele8 = driver.findElement(By.xpath("(//button[@class='ql-underline'])[1]"));
		ele8.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='ql-strike'])[1]")));
		ele9 = driver.findElement(By.xpath("(//button[@class='ql-strike'])[1]"));
		ele9.click();
	}

	@Then("Clear the text present in the all respondents text box")
	public void clear_the_text_present_in_the_all_respondents_text_box() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='ql-editor'])[1]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='ql-editor'])[1]"));
		ele1.click();
		Thread.sleep(2000);
		ele1.clear();
	}

	@Then("Enter valid message in the all respondents text box")
	public void enter_valid_message_in_the_all_respondents_text_box() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='ql-editor'])[1]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='ql-editor'])[1]"));
		ele1.sendKeys("Thank you for taking the test!");
	}

	@Then("Check all features are working or not in the all passed text box")
	public void check_all_features_are_working_or_not_in_the_all_passed_text_box() throws InterruptedException {
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='ql-header'])[3]")));
		ele1 = driver.findElement(By.xpath("(//button[@class='ql-header'])[3]"));
		ele1.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='ql-header'])[1]")));
		ele2 = driver.findElement(By.xpath("(//button[@class='ql-header'])[1]"));
		ele2.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='ql-list'])[3]")));
		ele3 = driver.findElement(By.xpath("(//button[@class='ql-list'])[3]"));
		ele3.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@value='bullet'])[2]")));
		ele4 = driver.findElement(By.xpath("(//button[@value='bullet'])[2]"));
		ele4.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@aria-controls='ql-picker-options-5']")));
		ele5 = driver.findElement(By.xpath("//span[@aria-controls='ql-picker-options-5']"));
		ele5.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='ql-bold'])[2]")));
		ele6 = driver.findElement(By.xpath("(//button[@class='ql-bold'])[2]"));
		ele6.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='ql-italic'])[2]")));
		ele7 = driver.findElement(By.xpath("(//button[@class='ql-italic'])[2]"));
		ele7.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='ql-underline'])[2]")));
		ele8 = driver.findElement(By.xpath("(//button[@class='ql-underline'])[2]"));
		ele8.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='ql-strike'])[2]")));
		ele9 = driver.findElement(By.xpath("(//button[@class='ql-strike'])[2]"));
		ele9.click();
	}

	@Then("Clear the text present in the all passed text box")
	public void clear_the_text_present_in_the_all_passed_text_box() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='ql-editor'])[2]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='ql-editor'])[2]"));
		ele1.click();
		Thread.sleep(2000);
		ele1.clear();
	}

	@Then("Enter valid message in the all passed text box")
	public void enter_valid_message_in_the_all_passed_text_box() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='ql-editor'])[2]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='ql-editor'])[2]"));
		ele1.sendKeys("Congratulations on passing the test!");
	}

	@Then("Check all features are working or not in the all failed text box")
	public void check_all_features_are_working_or_not_in_the_all_failed_text_box() throws InterruptedException {
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='ql-header'])[5]")));
		ele1 = driver.findElement(By.xpath("(//button[@class='ql-header'])[5]"));
		ele1.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='ql-list'])[5]")));
		ele3 = driver.findElement(By.xpath("(//button[@class='ql-list'])[5]"));
		ele3.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@value='bullet'])[3]")));
		ele4 = driver.findElement(By.xpath("(//button[@value='bullet'])[3]"));
		ele4.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@aria-controls='ql-picker-options-9']")));
		ele5 = driver.findElement(By.xpath("//span[@aria-controls='ql-picker-options-9']"));
		ele5.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='ql-bold'])[3]")));
		ele6 = driver.findElement(By.xpath("(//button[@class='ql-bold'])[3]"));
		ele6.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='ql-italic'])[3]")));
		ele7 = driver.findElement(By.xpath("(//button[@class='ql-italic'])[3]"));
		ele7.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='ql-underline'])[3]")));
		ele8 = driver.findElement(By.xpath("(//button[@class='ql-underline'])[3]"));
		ele8.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[@class='ql-strike'])[3]")));
		ele9 = driver.findElement(By.xpath("(//button[@class='ql-strike'])[3]"));
		ele9.click();
	}

	@Then("Clear the text present in the all failed text box")
	public void clear_the_text_present_in_the_all_failed_text_box() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='ql-editor'])[3]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='ql-editor'])[3]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
		Thread.sleep(2000);
		ele1.clear();
	}

	@Then("Enter valid message in the all failed text box")
	public void enter_valid_message_in_the_all_failed_text_box() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='ql-editor ql-blank'])")));
		ele1 = driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])"));
		ele1.sendKeys("Your score was too low to pass this test!");
	}

	@Then("Enter alpha characters {string} in Pass Mark tab")
	public void enter_alpha_characters_in_pass_mark_tab(String alphaCharacters) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("mark")));
		ele1 = driver.findElement(By.id("mark"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.clear();
		Thread.sleep(2000);
		ele1.click();
		Thread.sleep(2000);
		ele1.sendKeys(alphaCharacters);
	}

	@Then("Check tab is empty or not in Pass Mark tab")
	public void check_tab_is_empty_or_not_in_pass_mark_tab() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("mark")));
		ele1 = driver.findElement(By.id("mark"));
		String actualText = ele1.getDomProperty("value");

		boolean containsOnlyNumbers = true;

		for (char c : actualText.toCharArray()) {
			if (!Character.isDigit(c)) {
				containsOnlyNumbers = false;
				break;
			}
		}

		if (containsOnlyNumbers) {
			System.out.println("Tab contains only numbers.");
		} else {
			System.out.println("Tab contains alphabetic or special characters.");
		}

		Assert.assertTrue("Pass Mark tab accepts alpha and special characters", containsOnlyNumbers);
	}

	@Then("Enter special characters {string} in Pass Mark tab")
	public void enter_special_characters_in_pass_mark_tab(String specialCharacters) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("mark")));
		ele1 = driver.findElement(By.id("mark"));
		ele1.click();
		Thread.sleep(2000);
		ele1.clear();
		Thread.sleep(2000);
		ele1.sendKeys(specialCharacters);
	}

	@Then("Click add range button")
	public void click_add_range_button() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='click here to add ranges']")));
		ele1 = driver.findElement(By.xpath("//button[@title='click here to add ranges']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}

	@Then("Check new row is added or not")
	public void check_new_row_is_added_or_not() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(.,'Range 3 *')]")));
		ele1 = driver.findElement(By.xpath("//span[contains(.,'Range 3 *')]"));
		Assert.assertTrue("Add range button is not working", ele1.isDisplayed());
	}

	@Then("Check all tab is cleared or not in grading setup")
	public void check_all_tab_is_cleared_or_not_in_grading_setup() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='ql-editor ql-blank'])[1]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 0);");
		Thread.sleep(3000);
		String allRespondents = ele1.getText();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='ql-editor ql-blank'])[2]")));
		ele2 = driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[2]"));
		String passedMessage = ele2.getText();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='ql-editor ql-blank'])[3]")));
		ele3 = driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[3]"));
		String failedMessage = ele3.getText();

		wait.until(ExpectedConditions.elementToBeClickable(By.id("mark")));
		ele4 = driver.findElement(By.id("mark"));
		String passMark = ele4.getText();

		wait.until(ExpectedConditions.elementToBeClickable(By.id("from1")));
		ele5 = driver.findElement(By.id("from1"));
		String fromRange1 = ele5.getText();

		wait.until(ExpectedConditions.elementToBeClickable(By.id("to1")));
		ele6 = driver.findElement(By.id("to1"));
		String toRange1 = ele6.getText();

		wait.until(ExpectedConditions.elementToBeClickable(By.id("grade1")));
		ele7 = driver.findElement(By.id("grade1"));
		String grade1 = ele7.getText();

		Assert.assertTrue("Clear button is not working",
				allRespondents.isBlank() && passedMessage.isBlank() && failedMessage.isBlank() && passMark.isBlank()
						&& fromRange1.isBlank() && toRange1.isBlank() && grade1.isBlank());
	}

	@Then("Click save button in grading setup")
	public void click_save_button_in_grading_setup() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='click here to save grade setup']")));
		ele1 = driver.findElement(By.xpath("//button[@title='click here to save grade setup']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}

	@Then("Check error message is displayed or not in grading setup page")
	public void check_error_message_is_displayed_or_not_in_grading_setup_page() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actualText = ele1.getText();
		System.out.println("Success message displayed like: " + actualText);
		String expectedText = "Test end message is required!";
		Assert.assertEquals("Mandatory message is not displayed", actualText, expectedText);
	}

	@Then("Enter valid test end message details")
	public void enter_valid_test_end_message_details() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='ql-editor ql-blank'])[1]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, 0);");
		Thread.sleep(2000);
		ele1.click();
		Thread.sleep(2000);
		ele1.sendKeys("Thank you for taking the test!");
	}

	@Then("Enter valid passed message details")
	public void enter_valid_passed_message_details() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='ql-editor ql-blank'])[1]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[1]"));
		Thread.sleep(2000);
		ele1.click();
		Thread.sleep(2000);
		ele1.sendKeys("Congratulations on passing the test!");
	}

	@Then("Enter valid failed message details")
	public void enter_valid_failed_message_details() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='ql-editor ql-blank'])[1]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
		Thread.sleep(2000);
		ele1.sendKeys("Your score was too low to pass this test!");
	}

	@Then("Enter valid pass mark value details")
	public void enter_valid_pass_mark_value_details() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("mark")));
		ele1 = driver.findElement(By.id("mark"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
		Thread.sleep(2000);
		ele1.sendKeys("10");
	}

	@Then("Select {string} 2nd option in unit dropdown")
	public void select_2nd_option_in_unit_dropdown(String string) throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[1]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[1]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')]//div)[1]"));
		ele2.click();
	}

	@Then("Select {string} 2nd option in ranges unit")
	public void select_2nd_option_in_ranges_unit(String string) throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("(//div[@class='react-select__single-value css-1uccc91-singleValue'])[2]"));
		ele2.click();
	}

	@Then("Enter valid from range value in range 1st tab")
	public void enter_valid_from_range_value_in_range_1st_tab() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("from1")));
		ele1 = driver.findElement(By.id("from1"));
		ele1.sendKeys("0");
	}

	@Then("Enter valid grade {string} in range 1st tab")
	public void enter_valid_grade_in_range_1st_tab(String grade1) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("grade1")));
		ele1 = driver.findElement(By.id("grade1"));
		ele1.sendKeys(grade1);
	}

	@Then("Enter valid grade {string} in range 2nd tab")
	public void enter_valid_grade_in_range_2nd_tab(String grade2) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("grade2")));
		ele1 = driver.findElement(By.id("grade2"));
		ele1.sendKeys(grade2);
	}

	@Then("Enter valid to range value in range 1st tab")
	public void enter_valid_to_range_value_in_range_1st_tab() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("to1")));
		ele1 = driver.findElement(By.id("to1"));
		ele1.sendKeys("10");
	}

	@Then("Enter valid from range value in range 2nd tab")
	public void enter_valid_from_range_value_in_range_2nd_tab() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("from2")));
		ele1 = driver.findElement(By.id("from2"));
		ele1.sendKeys("11");
	}

	@Then("Enter valid to range value in range 2nd tab")
	public void enter_valid_to_range_value_in_range_2nd_tab() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("to2")));
		ele1 = driver.findElement(By.id("to2"));
		ele1.sendKeys("20");
	}

	@Then("Check success message is displayed or not in grading setup")
	public void check_success_message_is_displayed_or_not_in_grading_setup() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actualText = ele1.getText();
		System.out.println("Success message displayed like: " + actualText);
		String expectedText = "Grade Setup saved successfully!";
		Assert.assertEquals("Save button is not working", actualText, expectedText);

	}

	@Then("Check success message is displayed or not in grading setup tab")
	public void check_success_message_is_displayed_or_not_in_grading_setup_tab() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actualText = ele1.getText();
		System.out.println("Success message displayed like: " + actualText);
		String expectedText = "Grade Setup updated successfully!";
		Assert.assertEquals("Update button is not working", actualText, expectedText);

	}

	@Then("Check success message for deleted topic is displayed or not in question manager tab")
	public void check_success_message_for_deleted_topic_is_displayed_or_not_in_question_manager_tab()
			throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actualText = ele1.getText();
		System.out.println("Success message displayed like: " + actualText);
		String expectedText = "Question Setup deleted successfully!";
		Assert.assertEquals("Topic is not deleted", actualText, expectedText);
	}

	@Then("Check success message is displayed or not in test access")
	public void check_success_message_is_displayed_or_not_in_test_access() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actualText = ele1.getText();
		System.out.println("Success message displayed like: " + actualText);
		String expectedText = "Test Access saved successfully!";
		Assert.assertEquals("Topic is not deleted", actualText, expectedText);
	}

	@Then("Select {string} 1st option in unit dropdown")
	public void select_1st_option_in_unit_dropdown(String string) throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[1]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[1]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='P']"));
		ele2.click();
	}

	@Then("Select {string} 1st option in ranges unit")
	public void select_1st_option_in_ranges_unit(String string) throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[1]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[1]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("(//div[@class='react-select__single-value css-1uccc91-singleValue'])[2]"));
		ele2.click();
	}

	@Then("Click Certificate Template tab")
	public void click_certificate_template_tab() throws InterruptedException {
		Thread.sleep(15000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Certificate Template']")));
		Thread.sleep(2000);
		ele1 = driver.findElement(By.xpath("//button[text()='Certificate Template']"));
		ele1.click();
	}

	@Then("Unselect the selected checkbox in all tabs")
	public void unselect_the_selected_checkbox_in_all_tabs() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='form-check-input cp'])[1]")));
		ele1 = driver.findElement(By.xpath("(//input[@class='form-check-input cp'])[1]"));
		ele2 = driver.findElement(By.xpath("(//input[@class='form-check-input cp'])[2]"));
		ele3 = driver.findElement(By.xpath("(//input[@class='form-check-input cp'])[3]"));
		ele4 = driver.findElement(By.xpath("(//input[@class='form-check-input cp'])[4]"));
		ele5 = driver.findElement(By.xpath("(//input[@class='form-check-input cp'])[5]"));
		ele6 = driver.findElement(By.xpath("(//input[@class='form-check-input cp'])[6]"));
		ele7 = driver.findElement(By.xpath("(//input[@class='form-check-input cp'])[7]"));
		ele8 = driver.findElement(By.xpath("(//input[@class='form-check-input cp'])[8]"));
		ele9 = driver.findElement(By.xpath("(//input[@class='form-check-input cp'])[9]"));
		WebElement ele10 = driver.findElement(By.xpath("(//input[@class='form-check-input cp'])[10]"));
		if (ele1.isSelected() && ele2.isSelected() && ele3.isSelected() && ele4.isSelected() && ele5.isSelected()
				&& ele6.isSelected() && ele7.isSelected() && ele8.isSelected() && ele9.isSelected()
				&& ele10.isSelected()) {
			ele1.click();
			Thread.sleep(1000);
			ele2.click();
			Thread.sleep(1000);
			ele3.click();
			Thread.sleep(1000);
			ele4.click();
			Thread.sleep(1000);
			ele5.click();
			Thread.sleep(1000);
			ele6.click();
			Thread.sleep(1000);
			ele7.click();
			Thread.sleep(1000);
			ele8.click();
			Thread.sleep(1000);
			ele9.click();
			Thread.sleep(1000);
			ele10.click();
		} else {
			System.out.println("Check box is already unselected");
		}
	}

	@Then("Check checkbox is unselected or not")
	public void check_checkbox_is_unselected_or_not() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='form-check-input cp'])[1]")));
		ele1 = driver.findElement(By.xpath("(//input[@class='form-check-input cp'])[1]"));
		ele2 = driver.findElement(By.xpath("(//input[@class='form-check-input cp'])[2]"));
		ele3 = driver.findElement(By.xpath("(//input[@class='form-check-input cp'])[3]"));
		ele4 = driver.findElement(By.xpath("(//input[@class='form-check-input cp'])[4]"));
		ele5 = driver.findElement(By.xpath("(//input[@class='form-check-input cp'])[5]"));
		ele6 = driver.findElement(By.xpath("(//input[@class='form-check-input cp'])[6]"));
		ele7 = driver.findElement(By.xpath("(//input[@class='form-check-input cp'])[7]"));
		ele8 = driver.findElement(By.xpath("(//input[@class='form-check-input cp'])[8]"));
		ele9 = driver.findElement(By.xpath("(//input[@class='form-check-input cp'])[9]"));
		WebElement ele10 = driver.findElement(By.xpath("(//input[@class='form-check-input cp'])[10]"));
		if (ele1.isSelected() && ele2.isSelected() && ele3.isSelected() && ele4.isSelected() && ele5.isSelected()
				&& ele6.isSelected() && ele7.isSelected() && ele8.isSelected() && ele9.isSelected()
				&& ele10.isSelected()) {
			System.out.println("Check box is selected");
		} else {
			System.out.println("Check box is already unselected");
		}
		Assert.assertTrue("1th Checkbox cannot able to unselect", !ele1.isSelected());
		Assert.assertTrue("2nd Checkbox cannot able to unselect", !ele2.isSelected());
		Assert.assertTrue("3rd Checkbox cannot able to unselect", !ele3.isSelected());
		Assert.assertTrue("4th Checkbox cannot able to unselect", !ele4.isSelected());
		Assert.assertTrue("5th Checkbox cannot able to unselect", !ele5.isSelected());
		Assert.assertTrue("6th Checkbox cannot able to unselect", !ele6.isSelected());
		Assert.assertTrue("7th Checkbox cannot able to unselect", !ele7.isSelected());
		Assert.assertTrue("8th Checkbox cannot able to unselect", !ele8.isSelected());
		Assert.assertTrue("9th Checkbox cannot able to unselect", !ele9.isSelected());
		Assert.assertTrue("10th Checkbox cannot able to unselect", !ele10.isSelected());
	}

	@Then("Select the unselected checkbox in all tabs")
	public void select_the_unselected_checkbox_in_all_tabs() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='form-check-input cp'])[1]")));
		ele1 = driver.findElement(By.xpath("(//input[@class='form-check-input cp'])[1]"));
		ele2 = driver.findElement(By.xpath("(//input[@class='form-check-input cp'])[2]"));
		ele3 = driver.findElement(By.xpath("(//input[@class='form-check-input cp'])[3]"));
		ele4 = driver.findElement(By.xpath("(//input[@class='form-check-input cp'])[4]"));
		ele5 = driver.findElement(By.xpath("(//input[@class='form-check-input cp'])[5]"));
		ele6 = driver.findElement(By.xpath("(//input[@class='form-check-input cp'])[6]"));
		ele7 = driver.findElement(By.xpath("(//input[@class='form-check-input cp'])[7]"));
		ele8 = driver.findElement(By.xpath("(//input[@class='form-check-input cp'])[8]"));
		ele9 = driver.findElement(By.xpath("(//input[@class='form-check-input cp'])[9]"));
		WebElement ele10 = driver.findElement(By.xpath("(//input[@class='form-check-input cp'])[10]"));
		if (!ele1.isSelected() && !ele2.isSelected() && !ele3.isSelected() && !ele4.isSelected() && !ele5.isSelected()
				&& !ele6.isSelected() && !ele7.isSelected() && !ele8.isSelected() && !ele9.isSelected()
				&& !ele10.isSelected()) {
			ele1.click();
			Thread.sleep(1000);
			ele2.click();
			Thread.sleep(1000);
			ele3.click();
			Thread.sleep(1000);
			ele4.click();
			Thread.sleep(1000);
			ele5.click();
			Thread.sleep(1000);
			ele6.click();
			Thread.sleep(1000);
			ele7.click();
			Thread.sleep(1000);
			ele8.click();
			Thread.sleep(1000);
			ele9.click();
			Thread.sleep(1000);
			ele10.click();
		} else {
			System.out.println("Check box is already unselected");
		}
	}

	@Then("Check checkbox is selected or not")
	public void check_checkbox_is_selected_or_not() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='form-check-input cp'])[1]")));
		ele1 = driver.findElement(By.xpath("(//input[@class='form-check-input cp'])[1]"));
		ele2 = driver.findElement(By.xpath("(//input[@class='form-check-input cp'])[2]"));
		ele3 = driver.findElement(By.xpath("(//input[@class='form-check-input cp'])[3]"));
		ele4 = driver.findElement(By.xpath("(//input[@class='form-check-input cp'])[4]"));
		ele5 = driver.findElement(By.xpath("(//input[@class='form-check-input cp'])[5]"));
		ele6 = driver.findElement(By.xpath("(//input[@class='form-check-input cp'])[6]"));
		ele7 = driver.findElement(By.xpath("(//input[@class='form-check-input cp'])[7]"));
		ele8 = driver.findElement(By.xpath("(//input[@class='form-check-input cp'])[8]"));
		ele9 = driver.findElement(By.xpath("(//input[@class='form-check-input cp'])[9]"));
		WebElement ele10 = driver.findElement(By.xpath("(//input[@class='form-check-input cp'])[10]"));
		if (ele1.isSelected() && ele2.isSelected() && ele3.isSelected() && ele4.isSelected() && ele5.isSelected()
				&& ele6.isSelected() && ele7.isSelected() && ele8.isSelected() && ele9.isSelected()
				&& ele10.isSelected()) {
			System.out.println("Check box is selected");
		} else {
			System.out.println("Check box is already unselected");
		}
		Assert.assertTrue("1th Checkbox cannot able to select", ele1.isSelected());
		Assert.assertTrue("2nd Checkbox cannot able to select", ele2.isSelected());
		Assert.assertTrue("3rd Checkbox cannot able to select", ele3.isSelected());
		Assert.assertTrue("4th Checkbox cannot able to select", ele4.isSelected());
		Assert.assertTrue("5th Checkbox cannot able to select", ele5.isSelected());
		Assert.assertTrue("6th Checkbox cannot able to select", ele6.isSelected());
		Assert.assertTrue("7th Checkbox cannot able to select", ele7.isSelected());
		Assert.assertTrue("8th Checkbox cannot able to select", ele8.isSelected());
		Assert.assertTrue("9th Checkbox cannot able to select", ele9.isSelected());
		Assert.assertTrue("10th Checkbox cannot able to select", ele10.isSelected());
	}

	@Then("Click Test Access tab")
	public void click_test_access_tab() throws InterruptedException {
		Thread.sleep(15000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Test Access']")));
		Thread.sleep(2000);
		ele1 = driver.findElement(By.xpath("//button[text()='Test Access']"));
		ele1.click();
	}

	@Then("Unselect the checkbox")
	public void unselect_the_checkbox() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='checkbox'])[2]")));
		ele1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
		if (ele1.isSelected()) {
			ele1.click();
		} else {
			System.out.println("Checkbox is already unselected");
		}
	}

	@Then("Select the single checkbox")
	public void select_the_single_checkbox() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@type='checkbox'])[2]")));
		ele1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
		if (!ele1.isSelected()) {
			ele1.click();
		} else {
			System.out.println("Checkbox is already selected");
		}
	}

	@Then("Click save button in test access")
	public void click_save_button_in_test_access() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[@title='Click here to save Test Access details']")));
		ele1 = driver.findElement(By.xpath("//button[@title='Click here to save Test Access details']"));
		ele1.click();
	}

	@Then("Select the all checkbox")
	public void select_the_all_checkbox() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("checkAll")));
		ele1 = driver.findElement(By.id("checkAll"));
		if (!ele1.isSelected()) {
			ele1.click();
		} else {
			System.out.println("Checkbox is already selected");
		}
	}

	@Then("Select any proctor from the dropdown")
	public void select_any_proctor_from_the_dropdown() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//div[contains(@class,'react-select__value-container react-select__value-container--has-value')]")));
		ele1 = driver.findElement(By.xpath(
				"//div[contains(@class,'react-select__value-container react-select__value-container--has-value')]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Test User']"));
		ele2.click();
	}

	@Then("Select valid test level")
	public void select_valid_test_level() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Medium']"));
		ele2.click();
	}

	@Then("Enter valid test description")
	public void enter_valid_test_description() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.name("desc")));
		ele1 = driver.findElement(By.name("desc"));
		ele1.sendKeys("Test created for testing");
	}

	@Then("Click save button in practice test")
	public void click_save_button_in_practice_test() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='click here to save']")));
		ele1 = driver.findElement(By.xpath("//button[@title='click here to save']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}

	@Then("Enter valid overall questions value")
	public void enter_valid_overall_questions_value() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.name("question")));
		ele1 = driver.findElement(By.name("question"));
		ele1.sendKeys("10");
	}

	@Then("Enter valid overall points value")
	public void enter_valid_overall_points_value() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.name("score")));
		ele1 = driver.findElement(By.name("score"));
		ele1.sendKeys("20");
	}

	@Then("Select valid topic in add topics")
	public void select_valid_topic_in_add_topics() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//div[contains(@class,'react-select__value-container react-select__value-container--has-value')]")));
		ele1 = driver.findElement(By.xpath(
				"//div[contains(@class,'react-select__value-container react-select__value-container--has-value')]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Block Chain']"));
		ele2.click();
	}

	@Then("Click add button in add topics")
	public void click_add_button_in_add_topics() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='Click here to Add Topic']")));
		ele1 = driver.findElement(By.xpath("//button[@title='Click here to Add Topic']"));
		ele1.click();
	}

	@Then("Enter valid questions value in questions tab")
	public void enter_valid_questions_value_in_questions_tab() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("tquest-1")));
		ele1 = driver.findElement(By.id("tquest-1"));
		Thread.sleep(2000);
		ele1.click();
		Thread.sleep(2000);
		ele1.sendKeys("10");
	}

	@Then("Enter valid points value in points tab")
	public void enter_valid_points_value_in_points_tab() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("tscore-1")));
		ele1 = driver.findElement(By.id("tscore-1"));
		Thread.sleep(2000);
		ele1.click();
		Thread.sleep(2000);
		ele1.sendKeys("20");
	}

	@Then("Enter valid time value in time tab")
	public void enter_valid_time_value_in_time_tab() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("ttime-1")));
		ele1 = driver.findElement(By.id("ttime-1"));
		Thread.sleep(2000);
		ele1.click();
		Thread.sleep(2000);
		ele1.sendKeys("0020");
	}

	@Then("Click save button in time setup page")
	public void click_save_button_in_time_setup_page() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='click here to save time setup']")));
		ele1 = driver.findElement(By.xpath("//button[@title='click here to save time setup']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}

	@Then("Enter valid pass mark in grading setup")
	public void enter_valid_pass_mark_in_grading_setup() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.name("mark")));
		ele1 = driver.findElement(By.name("mark"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys("10");
	}

	@Then("Enter valid from range mark tab in 1st range tab in grading setup")
	public void enter_valid_from_range_mark_tab_in_1st_range_tab_in_grading_setup() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.name("from1")));
		ele1 = driver.findElement(By.name("from1"));
		Thread.sleep(2000);
		ele1.sendKeys("0");
	}

	@Then("Enter valid to range mark tab in 1st range tab in grading setups")
	public void enter_valid_to_range_mark_tab_in_1st_range_tab_in_grading_setups() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.name("to1")));
		ele1 = driver.findElement(By.name("to1"));
		Thread.sleep(2000);
		ele1.sendKeys("10");
	}

	@Then("Enter valid grade mark tab in 1st range tab in grading setup")
	public void enter_valid_grade_mark_tab_in_1st_range_tab_in_grading_setup() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.name("grade1")));
		ele1 = driver.findElement(By.name("grade1"));
		Thread.sleep(2000);
		ele1.sendKeys("A");
	}

	@Then("Enter valid from range mark tab in 2st range tab in grading setup")
	public void enter_valid_from_range_mark_tab_in_2st_range_tab_in_grading_setup() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.name("from2")));
		ele1 = driver.findElement(By.name("from2"));
		Thread.sleep(2000);
		ele1.sendKeys("11");
	}

	@Then("Enter valid to range mark tab in 2st range tab in grading setups")
	public void enter_valid_to_range_mark_tab_in_2st_range_tab_in_grading_setups() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.name("to2")));
		ele1 = driver.findElement(By.name("to2"));
		Thread.sleep(2000);
		ele1.sendKeys("20");
	}

	@Then("Enter valid grade mark tab in 2st range tab in grading setup")
	public void enter_valid_grade_mark_tab_in_2st_range_tab_in_grading_setup() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.name("grade2")));
		ele1 = driver.findElement(By.name("grade2"));
		Thread.sleep(2000);
		ele1.sendKeys("S");
	}

	@Then("Click finalize button in Finalize test page")
	public void click_finalize_button_in_Finalize_test_page() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='click here to finalize test']")));
		ele1 = driver.findElement(By.xpath("//button[@title='click here to finalize test']"));
		ele1.click();
	}

	@Then("Enter valid test name in main test")
	public void enter_valid_test_name_in_main_test() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.name("testName")));
		ele1 = driver.findElement(By.name("testName"));
//		Faker fakename = new Faker();
//		String firstName = fakename.name().
		String uuid = UUID.randomUUID().toString();
		String randomTestName = "Test Main_" + uuid.substring(0, 8);
		ele1.sendKeys(randomTestName);
	}

	@Then("Enter valid proctoring capacity in main test")
	public void enter_valid_proctoring_capacity_in_main_test() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.name("proctor")));
		ele1 = driver.findElement(By.name("proctor"));
		ele1.sendKeys("2");
	}

	@Then("Select valid subject name in main test")
	public void select_valid_subject_name_in_main_test() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[1]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[1]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Artificial Intelligence']"));
		ele2.click();
	}

	@Then("Select valid test level in main test")
	public void select_valid_test_level_in_main_test() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Medium']"));
		ele2.click();
	}

	@Then("Enter valid test description in main test")
	public void enter_valid_test_description_in_main_test() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.name("desc")));
		ele1 = driver.findElement(By.name("desc"));
		ele1.sendKeys("Test created for testing");
	}

	@Then("Click save button in main test")
	public void click_save_button_in_main_test() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='click here to save']")));
		ele1 = driver.findElement(By.xpath("//button[@title='click here to save']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}

	@Then("Enter valid questions value in points tab")
	public void enter_valid_questions_value_in_points_tab() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.name("question")));
		ele1 = driver.findElement(By.name("question"));
		ele1.sendKeys("10");
	}

	@Then("Enter valid questions value in time tab")
	public void enter_valid_questions_value_in_time_tab() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.name("score")));
		ele1 = driver.findElement(By.name("score"));
		ele1.sendKeys("20");
	}

	@Then("Enter valid test activation date and time")
	public void enter_valid_test_activation_date_and_time() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='form-control'])[2]")));
		ele1 = driver.findElement(By.xpath("(//input[@class='form-control'])[2]"));
		String text = ele1.getDomProperty("value");
		int length = text.length();
		for (int i = 0; i < length; i++) {
			ele1.sendKeys(Keys.BACK_SPACE);
		}
		Thread.sleep(2000);
		ele1.sendKeys("January 4, 2026 2:20 AM");
		Thread.sleep(2000);
		ele1.sendKeys(Keys.TAB);
	}

	@Then("Enter valid last registration date and time")
	public void enter_valid_last_registration_date_and_time() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//input[@class='form-control react-datepicker-ignore-onclickoutside']")));
		ele1 = driver.findElement(By.xpath("//input[@class='form-control react-datepicker-ignore-onclickoutside']"));
		ele1.click();
		String text = ele1.getDomProperty("value");
		int length = text.length();
		for (int i = 0; i < length; i++) {
			ele1.sendKeys(Keys.BACK_SPACE);
		}
		Thread.sleep(4000);
		ele1.sendKeys("January 2, 2026 2:20 AM");
	}

	@Then("Click save button in certificate template page")
	public void click_save_button_in_certificate_template_page() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='click here to save template']")));
		ele1 = driver.findElement(By.xpath("//button[@title='click here to save template']"));
		Thread.sleep(2000);
		ele1.click();
	}

	@Then("Modify the details in basic settings")
	public void modify_the_details_in_basic_settings() throws InterruptedException {
		Thread.sleep(15000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.name("testName")));
		ele1 = driver.findElement(By.name("testName"));
		String testName = ele1.getDomProperty("value");
		int length = testName.length();
		Thread.sleep(2000);
		for (int i = 0; i < length; i++) {
			ele1.sendKeys(Keys.BACK_SPACE);
		}
		Thread.sleep(2000);
		ele1.sendKeys(testName);
	}

	@Then("Click update button")
	public void click_update_button() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='click here to save']")));
		ele1 = driver.findElement(By.xpath("//button[@title='click here to save']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}

	@Then("Check success message is displayed or not in basic settings")
	public void check_success_message_is_displayed_or_not_in_basic_settings() throws InterruptedException {
		Thread.sleep(1500);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actualMsg = ele1.getText();
		System.out.println("Success message displayed like: " + actualMsg);
		String expectedMsg = "Basic Settings updated successfully!";
		Assert.assertEquals("Success message is not displayed", actualMsg, expectedMsg);
	}

	@Then("Check success message is displayed or not in certificate template page")
	public void check_success_message_is_displayed_or_not_in_certificate_template_page() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actualMsg = ele1.getText();
		System.out.println("Success message displayed like: " + actualMsg);
		String expectedMsg = "Template saved successfully!";
		Assert.assertEquals("Success message is not displayed", actualMsg, expectedMsg);
	}

	@Then("Modify the details in Question Manager")
	public void modify_the_details_in_question_manager() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.name("question")));
		ele1 = driver.findElement(By.name("question"));
		String questions = ele1.getDomProperty("value");
		int length = questions.length();
		Thread.sleep(2000);
		for (int i = 0; i < length; i++) {
			ele1.sendKeys(Keys.BACK_SPACE);
		}
		Thread.sleep(2000);
		ele1.sendKeys(questions);
	}

	@Then("Check success message is displayed or not in Question Manager")
	public void check_success_message_is_displayed_or_not_in_question_manager() throws InterruptedException {
		Thread.sleep(1500);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actualText = ele1.getText();
		System.out.println("Success message displayed like: " + actualText);
		String expectedText = "Question Manager saved successfully!";
		Assert.assertEquals("Question manager cannot able to save", actualText, expectedText);
	}

	@Then("Modify the details in Grading Setup")
	public void modify_the_details_in_grading_setup() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.name("mark")));
		ele1 = driver.findElement(By.name("mark"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		String mark = ele1.getDomProperty("value");
		int length = mark.length();
		Thread.sleep(2000);
		for (int i = 0; i < length; i++) {
			ele1.sendKeys(Keys.BACK_SPACE);
		}
		Thread.sleep(2000);
		ele1.sendKeys(mark);
	}

	@Then("Click update button in Grading Setup")
	public void click_update_button_in_grading_setup() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//button[@title='click here to save grade setup']")));
		ele1 = driver.findElement(By.xpath("//button[@title='click here to save grade setup']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.click();
	}
}