package stepDefinition;

import java.time.Duration;
import java.util.List;

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

public class OEP_8_Reports {
	public WebDriver driver;
	public WebElement ele, ele1, ele2, ele3, ele4, ele5, ele6, ele7, ele8, ele9;
	public WebDriverWait wait;

	@Given("To Check Reports is navigating to OEP URL is {string}")
	public void to_check_reports_is_navigating_to_oep_url_is(String url) {
		System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
//		option.addArguments("--headless=new");
		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get(url);
	}
	@When("To Check Reports Enter username and password are {string} and {string}")
	public void to_check_reports_enter_username_and_password_are_and(String username, String password) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("email")));
		ele1 = driver.findElement(By.name("email"));
		ele1.clear();
		ele1.sendKeys(username);
		ele2 = driver.findElement(By.name("password"));
		ele2.clear();
		ele2.sendKeys(password);
	}
	@When("click the Signin button To Check Reports page")
	public void click_the_signin_button_to_check_reports_page() {
		ele1 = driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
		ele1.click();
	}
	@Then("Click take picture button in Reports page")
	public void click_take_picture_button_in_reports_page() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space(text())='Take Picture']")));
		ele1 = driver.findElement(By.xpath("//button[normalize-space(text())='Take Picture']"));
		ele1.click();
	}
	@Then("Click Reports button")
	public void click_reports_button() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//li[contains(.,'ReportsTest ResultsEvent Log')]")));
		ele1 = driver.findElement(By.xpath("//li[contains(.,'ReportsTest ResultsEvent Log')]"));
		Actions action = new Actions(driver);
		action.moveToElement(ele1).build().perform();
		ele1.click();
	}
	@Given("Click Test Results button")
	public void click_test_results_button() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//span[normalize-space(text())='Test Results'])[1]")));
		ele1 = driver.findElement(By.xpath("(//span[normalize-space(text())='Test Results'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}
	@Then("Close Reports page")
	public void close_reports_page() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
		System.out.print("Page is closed");
	}
	
	@When("Select valid from date {string} in test results page")
	public void select_valid_from_date_in_test_results_page(String fromDate) throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("cal1")));
		ele1 = driver.findElement(By.id("cal1"));
		ele1.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@role='option'])[1]")));
		ele1 = driver.findElement(By.xpath("(//div[@role='option'])[1]"));
		ele1.click();
		
//		ele1.sendKeys(Keys.END);
//		Thread.sleep(1000);
//		String fromDateValue=ele1.getDomAttribute("value");
//		int length = fromDateValue.length();
//		for(int i=0;i<length;i++) {
//			ele1.sendKeys(Keys.BACK_SPACE);
//		}
//		Thread.sleep(2000);
//		ele1.sendKeys(fromDate);
	}
	@Then("Select valid to date {string} in test results page")
	public void select_valid_to_date_in_test_results_page(String toDate) throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("cal2")));
		ele1 = driver.findElement(By.id("cal2"));
		ele1.click();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[contains(@class,'react-datepicker__day react-datepicker__day--001')])[2]")));
		ele1 = driver.findElement(By.xpath("(//div[contains(@class,'react-datepicker__day react-datepicker__day--001')])[2]"));
		ele1.click();
		
		
//		ele1.sendKeys(Keys.END);
//		Thread.sleep(1000);
//		String fromDateValue=ele1.getDomAttribute("value");
//		int length = fromDateValue.length();
//		for(int i=0;i<length;i++) {
//			ele1.sendKeys(Keys.BACK_SPACE);
//		}
//		Thread.sleep(2000);
//		ele1.sendKeys(toDate);
	}
	@Then("Check details are displayed or not in test results page")
	public void check_details_are_displayed_or_not_in_test_results_page() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'row-cols-1 row-cols-sm-2')]")));
		ele1 = driver.findElement(By.xpath("//div[contains(@class,'row-cols-1 row-cols-sm-2')]"));
		boolean isDisplayed = ele1.isDisplayed();
		Assert.assertTrue("Details are not displayed", isDisplayed);
	}
	@When("Select valid subject name {string} in the dropdown in test results page")
	public void select_valid_subject_name_in_the_dropdown_in_test_results_page(String subjectName) throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[1]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[1]"));
		ele1.click();
		Thread.sleep(2000);
		List<WebElement> options = driver.findElements(By.cssSelector(".react-select__menu-list div"));
		String optionToSelect=subjectName;
		for (WebElement option : options) {
            if (option.getText().equals(optionToSelect)) {
                option.click();
                break;
            }
		}
		
	}
	@When("Check subject name details are displayed or not in test results page")
	public void check_subject_name_details_are_displayed_or_not_in_test_results_page() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@type='button'])[1]")));
		ele1 = driver.findElement(By.xpath("(//button[@type='button'])[1]"));
		boolean isDisplayed = ele1.isDisplayed();
		Assert.assertTrue("Subject name filter is not working", isDisplayed);
	}
	@When("Select valid level {string} in the dropdown in test results page")
	public void select_valid_level_in_the_dropdown_in_test_results_page(String level) throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]"));
		ele1.click();
		Thread.sleep(2000);
		List<WebElement> options = driver.findElements(By.cssSelector(".react-select__menu-list div"));
		String optionToSelect=level;
		for (WebElement option : options) {
            if (option.getText().equals(optionToSelect)) {
                option.click();
                break;
            }
		}
	}
	@When("Check level details are displayed or not in test results page")
	public void check_level_details_are_displayed_or_not_in_test_results_page() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@type='button'])[2]")));
		ele1 = driver.findElement(By.xpath("(//button[@type='button'])[2]"));
		boolean isDisplayed = ele1.isDisplayed();
		Assert.assertTrue("Subject name filter is not working", isDisplayed);
	}
	@Then("Click any test name in test results page")
	public void click_any_test_name_in_test_results_page() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[contains(@class,'w-100 btn-sm')])[1]")));
		ele1 = driver.findElement(By.xpath("(//button[contains(@class,'w-100 btn-sm')])[1]"));
		ele1.click();
	}
	@Then("Check test name details are displayed or not in test results page")
	public void check_test_name_details_are_displayed_or_not_in_test_results_page() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'h-100 cp')]")));
		ele1 = driver.findElement(By.xpath("//div[contains(@class,'h-100 cp')]"));
		boolean isDisplayed = ele1.isDisplayed();
		Assert.assertTrue("Test results are not displayed", isDisplayed);
	}
	@Given("Click Event Log button")
	public void click_event_log_button() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("(//span[normalize-space(text())='Event Log'])[1]")));
		ele1 = driver.findElement(By.xpath("(//span[normalize-space(text())='Event Log'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}
	@When("Select valid from date {string} in Event Log page")
	public void select_valid_from_date_in_event_log_page(String fromDate) throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cal1")));
		ele1 = driver.findElement(By.id("cal1"));
		ele1.click();
		Thread.sleep(2000);
		ele1.sendKeys(Keys.END);
		Thread.sleep(1000);
		String fromDateValue=ele1.getDomAttribute("value");
		int length = fromDateValue.length();
		for(int i=0;i<length;i++) {
			ele1.sendKeys(Keys.BACK_SPACE);
		}
		Thread.sleep(2000);
		ele1.sendKeys(fromDate);
		Thread.sleep(2000);
		ele1.sendKeys(Keys.ENTER);
	}
	@Then("Select valid to date {string} in Event Log page")
	public void select_valid_to_date_in_event_log_page(String toDate) throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cal2")));
		ele1 = driver.findElement(By.id("cal2"));
		ele1.click();
		Thread.sleep(2000);
		ele1.sendKeys(Keys.END);
		Thread.sleep(1000);
		String fromDateValue=ele1.getDomAttribute("value");
		int length = fromDateValue.length();
		for(int i=0;i<length;i++) {
			ele1.sendKeys(Keys.BACK_SPACE);
		}
		Thread.sleep(2000);
		ele1.sendKeys(toDate);
		Thread.sleep(2000);
		ele1.sendKeys(Keys.ENTER);
	}
	@Then("Check details are displayed or not in Event Log page")
	public void check_details_are_displayed_or_not_in_event_log_page() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[contains(@class,'pt-0 pb-0')])[2]")));
		ele1 = driver.findElement(By.xpath("(//div[contains(@class,'pt-0 pb-0')])[2]"));
		boolean isDisplayed = ele1.isDisplayed();
		Assert.assertTrue("Test results are not displayed", isDisplayed);
	}
	@When("Enter valid username {string} in event log page")
	public void enter_valid_username_in_event_log_page(String userName) throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("search")));
		ele1 = driver.findElement(By.name("search"));
		ele1.sendKeys(userName);
	}
	@Then("Check username {string} details are displayed or not in Event Log page")
	public void check_username_details_are_displayed_or_not_in_event_log_page(String userName) throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[contains(@class,'text-alternate align-items-center')])[1]")));
		ele1 = driver.findElement(By.xpath("(//div[contains(@class,'text-alternate align-items-center')])[1]"));
		String actualName=ele1.getText();
		String expName=userName;
		Assert.assertEquals("Search option is not working", actualName, expName);
	}
	@Then("Enter valid IpAddress {string} in event log page")
	public void enter_valid_ip_address_in_event_log_page(String ipAddress) throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("search")));
		ele1 = driver.findElement(By.name("search"));
		ele1.sendKeys(ipAddress);
	}
	@When("Check IpAddress {string} details are displayed or not in Event Log page")
	public void check_ip_address_details_are_displayed_or_not_in_event_log_page(String ipAddress) throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='align-items-center text-alternate'])[2]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='align-items-center text-alternate'])[2]"));
		String actualName=ele1.getText();
		String expName=ipAddress;
		Assert.assertEquals("Search option is not working", actualName, expName);
	}
	@When("Click last button in pagination in Event Log page")
	public void click_last_button_in_pagination_in_event_log_page() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[contains(.,'Last')]")));
		ele1 = driver.findElement(By.xpath("//li[contains(.,'Last')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(3000);
		ele1.click();
	}
	@When("Click first button in pagination in Event Log page")
	public void click_first_button_in_pagination_in_event_log_page() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@class='page-link'])[1]")));
		ele1 = driver.findElement(By.xpath("(//a[@class='page-link'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(3000);
		ele1.click();
	}
	@When("Click next button in pagination in Event Log page")
	public void click_next_button_in_pagination_in_event_log_page() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[contains(.,'Next')]")));
		ele1 = driver.findElement(By.xpath("//li[contains(.,'Next')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(3000);
		ele1.click();
	}
	@Then("Click previous button in pagination in Event Log page")
	public void click_previous_button_in_pagination_in_event_log_page() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[contains(.,'Previous')]")));
		ele1 = driver.findElement(By.xpath("//li[contains(.,'Previous')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(3000);
		ele1.click();
	}
	@Then("Click the number button in pagination in Event Log page")
	public void click_the_number_button_in_pagination_in_event_log_page() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[normalize-space(text())='5']")));
		ele1 = driver.findElement(By.xpath("//a[normalize-space(text())='5']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(3000);
		ele1.click();
	}
	@Then("Click edit button in Event Log page")
	public void click_edit_button_in_event_log_page() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[@class='text-primary cp'])[1]")));
		ele1 = driver.findElement(By.xpath("(//span[@class='text-primary cp'])[1]"));
		ele1.click();
	}
	@Then("Click back button in Event Log page")
	public void click_back_button_in_event_log_page() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[normalize-space(text())='Back']")));
		ele1 = driver.findElement(By.xpath("//button[normalize-space(text())='Back']"));
		ele1.click();
	}
	@Then("Check landing page in Event Log page")
	public void check_landing_page_in_event_log_page() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("search")));
		ele1 = driver.findElement(By.name("search"));
		boolean isDisplayed = ele1.isDisplayed();
		Assert.assertTrue("Back button is not working", isDisplayed);
	}
//	@When("Select valid from date {string} in test results page")
//	public void select_valid_from_date_in_test_results_page(String date) throws InterruptedException {
//		Thread.sleep(2000);
//	    // 1. Parse the date string:
//	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy"); // Adjust the format if needed
//	    LocalDate targetDate = LocalDate.parse(date, formatter);
//
//	    // 2. Open the calendar:
//	    driver.findElement(By.id("cal1")).click(); // Or By.name("stdate") if id is not unique
//
//	    // 3. Wait for the calendar to be visible (important!):
//	    wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Adjust timeout as needed
//	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("react-datepicker__month"))); // Find a suitable element within the calendar that becomes visible
//
//	    // 4. Select the date:
//	    int targetDay = targetDate.getDayOfMonth();
//	    String xpath = String.format("//div[contains(@class, 'react-datepicker__month')]//div[@class='react-datepicker__day react-datepicker__day--0%d' and not(contains(@class, 'react-datepicker__day--outside'))]", targetDay);
//
//	    WebElement dayElement = driver.findElement(By.xpath(xpath));
//
//	    dayElement.click();
//
//	    // 5. (Optional) Assertion to verify the date is selected (highly recommended):
//	    String selectedDate = driver.findElement(By.id("cal1")).getDomAttribute("value");
//	    Assert.assertEquals(date, selectedDate);  // Or a more robust comparison if the format differs slightly
//	}
	
	
	}