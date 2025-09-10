package stepDefinition;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
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

public class OEP_4_QuestionManager {
	public WebDriver driver;
	public WebElement ele, ele1, ele2, ele3, ele4, ele5, ele6, ele7, ele8, ele9;
	public WebDriverWait wait;

	@Given("To Check Create Question is navigating to OEP URL is {string}")
	public void to_check_create_question_is_navigating_to_oep_url_is(String url) {
		System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
//		option.addArguments("--headless=new");
		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get(url);
	}

	@When("To Check Create Question Enter username and password are {string} and {string}")
	public void to_check_create_question_enter_username_and_password_are_and(String username, String password) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("email")));
		ele1 = driver.findElement(By.name("email"));
		ele1.clear();
		ele1.sendKeys(username);
		ele2 = driver.findElement(By.name("password"));
		ele2.clear();
		ele2.sendKeys(password);
	}

	@When("click the Signin button To Check Create Question")
	public void click_the_signin_button_to_check_create_question() {
		ele1 = driver.findElement(By.xpath("//button[contains(@class,'btn btn-sm')]"));
		ele1.click();
	}

	@Then("Close Create Question button")
	public void close_create_question_button() throws InterruptedException {
		Thread.sleep(2000);
		driver.close();
		driver.quit();
		System.out.print("\u001B[1mPage is closed\u001B[0m");
	}

	@Then("Click Create Question button")
	public void click_create_question_button() {

		wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		// ✅ Wait for full page load
		wait.until(
				driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));

		// ✅ Wait for collapse button to be clickable
		By collapseToggle = By.xpath("(//a[@data-bs-toggle='collapse'])[3]");
		wait.until(ExpectedConditions.elementToBeClickable(collapseToggle));

		// ✅ Wait until the loader disappears
		By loader = By.cssSelector("div.loaderStyle"); // Adjust if needed
		wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));

		// ✅ Now safely move and click the element
		By labelSpan = By.xpath("(//a[@data-bs-toggle='collapse'])[3]");
		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(labelSpan));
		Actions action = new Actions(driver);
		action.moveToElement(ele1).build().perform();
		ele1.click();

		// ✅ Click submenu item
		By submenuLink = By.xpath("//ul[@class='collapse show']//a[1]");
		ele2 = wait.until(ExpectedConditions.elementToBeClickable(submenuLink));
		ele2.click();
	}

	@Given("Enter valid question {string} details in the searchbox")
	public void enter_valid_question_details_in_the_searchbox(String validQuestion) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// ✅ Wait until page is fully loaded
		wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
				.equals("complete"));

		// ✅ Wait until loader disappears completely
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.loaderStyle")));

		// ✅ Ensure no overlay blocks the click
		wait.until(ExpectedConditions.elementToBeClickable(By.name("txtSearch")));

		WebElement ele1 = driver.findElement(By.name("txtSearch"));

		// Step 4: Ensure searchbox is ready (value is empty & interactable)
		wait.until(driver1 -> ele1.getAttribute("value").isEmpty());

		// Clear text properly
		ele1.clear();

		// Enter valid answer
		ele1.sendKeys(validQuestion);
		Thread.sleep(3000);
		ele1.sendKeys(Keys.BACK_SPACE);
	}

	@When("Enter valid answer {string} details in the searchbox")
	public void enter_valid_answer_details_in_the_searchbox(String validAnswer) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Step 1: Wait until page is fully loaded
		wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
				.equals("complete"));

		// Step 2: Wait until loader disappears
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.loaderStyle")));

		// Step 3: Wait until searchbox is clickable
		WebElement ele1 = wait.until(ExpectedConditions.elementToBeClickable(By.name("txtSearch")));

		// Step 4: Ensure searchbox is ready (value is empty & interactable)
		wait.until(driver1 -> ele1.getAttribute("value").isEmpty());

		// Clear text properly
		ele1.clear();

		// Enter valid answer
		ele1.sendKeys(validAnswer);
		Thread.sleep(3000);
		ele1.sendKeys(Keys.BACK_SPACE);
	}

	@Then("Enter valid subject name {string} in the searchbox")
	public void enter_valid_subject_name_in_the_searchbox(String validSubjectName) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtSearch")));
		ele1 = driver.findElement(By.name("txtSearch"));
		String searchBox = ele1.getDomProperty("value");
		ele1.click();
		int length = searchBox.length();
		for (int i = 0; i < length; i++) {
			ele1.clear();
		}
		Thread.sleep(4000);
		ele1.sendKeys(validSubjectName);
		Thread.sleep(2000);
		ele1.sendKeys(Keys.ENTER);
	}

	@When("Check entered question {string} details is displayed or not")
	public void check_entered_question_details_is_displayed_or_not(String validQuestionDetail)
			throws InterruptedException {
		Thread.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
				.equals("complete"));
		WebElement ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[contains(@class,'col-xl-8') and contains(@class,'col-lg-8')]")));

		String actualQuestionDetail = ele1.getText();
		Assert.assertEquals("Entered question name is not displayed", actualQuestionDetail, validQuestionDetail);

	}

	@Then("Check entered answer {string} details is displayed or not")
	public void check_entered_answer_details_is_displayed_or_not(String validAnswerDetail) throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'pe-7 ms-5')]")));
		ele1 = driver.findElement(By.xpath("//div[contains(@class,'pe-7 ms-5')]"));
		String actualAnswerDetail = ele1.getText();
		String expectedAnswerDetail = validAnswerDetail;
		Assert.assertEquals("Entered question name is not displayed", actualAnswerDetail, expectedAnswerDetail);
	}

	@Then("Check entered subject name {string} details is displayed or not")
	public void check_entered_subject_name_details_is_displayed_or_not(String validSubjectName)
			throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='badge bg-outline-primary']")));
		ele1 = driver.findElement(By.xpath("//span[@class='badge bg-outline-primary']"));
		String actualSubjectName = ele1.getText();
		String expectedSubjectName = validSubjectName;
		Assert.assertEquals("Entered question name is not displayed", actualSubjectName, expectedSubjectName);
	}

	@When("Click edit button in any question")
	public void click_edit_button_in_any_question() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//button[contains(@class,'btn-icon btn-icon-start')])[1]")));
		ele1 = driver.findElement(By.xpath("(//button[contains(@class,'btn-icon btn-icon-start')])[1]"));
		ele1.click();
	}

	@When("Check question status {string} is same as user selected")
	public void check_question_status_is_same_as_user_selected(String selectedQuestionStatus)
			throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[@class='react-select__value-container react-select__value-container--has-value css-1hwfws3'])[5]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[@class='react-select__value-container react-select__value-container--has-value css-1hwfws3'])[5]"));
		String actualquestionStatus = ele1.getText();
		System.out.println("✅ Status displayed as: " + actualquestionStatus);
		String expectedQuestionStatus = selectedQuestionStatus;
		Assert.assertEquals("Status dropdown is not working", actualquestionStatus, expectedQuestionStatus);
	}

	@Then("Check question level {string} is same as user selected")
	public void check_question_level_is_same_as_user_selected(String selectedQuestionLevel)
			throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[@class='react-select__value-container react-select__value-container--has-value css-1hwfws3'])[4]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[@class='react-select__value-container react-select__value-container--has-value css-1hwfws3'])[4]"));
		String actualquestionLevel = ele1.getText();
		System.out.println("✅ Status displayed as: " + actualquestionLevel);
		String expectedQuestionLevel = selectedQuestionLevel;
		Assert.assertEquals("Status dropdown is not working", actualquestionLevel, expectedQuestionLevel);
	}

	@Then("Click take picture button in Create Question")
	public void click_take_picture_button_in_Create_Question() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space(text())='Take Picture']")));
		ele1 = driver.findElement(By.xpath("//button[normalize-space(text())='Take Picture']"));
		ele1.click();
	}

	@Then("Check selected {string} option in subject dropdown")
	public void check_selected_option_in_subject_dropdown(String selectedSubject) throws InterruptedException {
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//span[@class='badge bg-outline-primary'])[1]")));
		ele1 = driver.findElement(By.xpath("(//span[@class='badge bg-outline-primary'])[1]"));
		String actualSubject = ele1.getText();
		System.out.println("✅ Status displayed as: " + actualSubject);
		String expectedSubject = selectedSubject;
		Assert.assertEquals("Subject dropdown is not working", actualSubject, expectedSubject);
	}

	public void waitForLoader(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.loaderStyle")));
	}

	public void waitForPageLoad(WebDriver driver) {
		new WebDriverWait(driver, Duration.ofSeconds(30)).until(webDriver -> ((JavascriptExecutor) webDriver)
				.executeScript("return document.readyState").equals("complete"));
	}

	@Given("Select All option in status dropdown")
	public void select_all_option_in_status_dropdown() {
		// Step 0: Wait until page load is complete
		waitForPageLoad(driver);

		By dropdownLocator = By.xpath("(//div[@class='react-select__control css-yk16xz-control'])[2]");

		// 1. Wait until loader is gone
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.loaderStyle")));

		// 2. Wait until dropdown is visible & enabled
		WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(dropdownLocator));

		// 3. Scroll & click
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", dropdown);

		try {
			dropdown.click();
		} catch (ElementClickInterceptedException e) {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.loaderStyle")));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", dropdown);
		}

	}

	@Given("Select {string} option in question set filter dropdown")
	public void select_option_in_question_set_filter_dropdown(String questionSet) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Step 0: Wait for loader to disappear if it's present
		By loaderLocator = By.cssSelector("div.loaderStyle");
		wait.until(ExpectedConditions.invisibilityOfElementLocated(loaderLocator));

		// Step 1: Click dropdown
		By dropdownLocator = By.xpath("(//div[contains(@class,'react-select__control')])[1]");
		WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(dropdownLocator));
		dropdown.click();

		// Step 2: Wait for menu to appear
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(@class,'react-select__menu')]")));

		// Step 3: Click the option
		By optionLocator = By.xpath(
				"//div[contains(@class,'react-select__option') and normalize-space(text())='" + questionSet + "']");
		WebElement option = wait.until(ExpectedConditions.elementToBeClickable(optionLocator));
		option.click();
	}

	@Given("Select Active option in status dropdown")
	public void select_active_option_in_status_dropdown() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Step 1: Wait for dropdown to be present and clickable
		By dropdownLocator = By.xpath("(//div[@class='react-select__control css-yk16xz-control'])[2]");
		WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(dropdownLocator));

		// Step 2: Click the dropdown to open options
		dropdown.click();

		// Step 3: Wait for the 'All' option to appear and click it
		By activeOptionLocator = By
				.xpath("//div[contains(@class,'react-select__option') and normalize-space(.)='Active']");
		WebElement activeOption = wait.until(ExpectedConditions.visibilityOfElementLocated(activeOptionLocator));
		activeOption.click();
	}

	@Given("Select Inactive option in status dropdown")
	public void select_inactive_option_in_status_dropdown() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Step 1: Wait for dropdown to be present and clickable
		By dropdownLocator = By.xpath("(//div[@class='react-select__control css-yk16xz-control'])[2]");
		WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(dropdownLocator));

		// Step 2: Click the dropdown to open options
		dropdown.click();

		// Step 3: Wait for the 'All' option to appear and click it
		By inactiveOptionLocator = By
				.xpath("//div[contains(@class,'react-select__option') and normalize-space(.)='Inactive']");
		WebElement inactiveOption = wait.until(ExpectedConditions.visibilityOfElementLocated(inactiveOptionLocator));
		inactiveOption.click();
	}

	@Given("Select All Subject option in subject dropdown")
	public void select_all_subject_option_in_subject_dropdown() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// 1️. Wait for loader to disappear
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.loaderStyle")));

		// 2️. Wait for dropdown to be clickable
		By dropdownLocator = By.xpath("(//div[@class='react-select__control css-yk16xz-control'])[3]");
		WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(dropdownLocator));

		// 3️. Click the dropdown
		dropdown.click();

		// 4️. Wait for the 'All Subject' option to appear and click it
		By allOptionLocator = By
				.xpath("//div[contains(@class,'react-select__option') and normalize-space(.)='All Subject']");
		WebElement allOption = wait.until(ExpectedConditions.visibilityOfElementLocated(allOptionLocator));
		allOption.click();
	}

	@Given("Select {string} option in subject dropdown in create question")
	public void select_option_in_subject_dropdown_in_create_question(String subName) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// 0. Ensure page load complete
		waitForPageLoad(driver);

		// 1. Wait for loader to disappear (stable check)
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.loaderStyle")));

		// 2. Wait for dropdown to be clickable
		By dropdownLocator = By.xpath("(//div[@class='react-select__control css-yk16xz-control'])[3]");
		WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(dropdownLocator));

		// 3. Scroll into view (avoid hidden click)
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", dropdown);

		// 4. Try clicking safely
		try {
			dropdown.click();
		} catch (ElementClickInterceptedException e) {
			// Loader popped up again → wait and retry
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.loaderStyle")));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", dropdown);
		}

		// 5. Wait for the desired option
		By allOptionLocator = By
				.xpath("//div[contains(@class,'react-select__option') and normalize-space(.)='" + subName + "']");
		WebElement allOption = wait.until(ExpectedConditions.visibilityOfElementLocated(allOptionLocator));

		// 6. Click the option
		allOption.click();

	}

	@Given("Select Artificial Intelligence option in subject dropdown")
	public void select_artificial_intelligence_option_in_subject_dropdown() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[3]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[3]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Artificial Intelligence']"));
		ele2.click();
	}

	@Given("Select {string} option in subject dropdown")
	public void select_option_in_subject_dropdown(String subName) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Click the dropdown
		WebElement dropdown = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[contains(@class,'react-select__control')])[1]")));
		dropdown.click();

		// Wait for the menu to appear
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".react-select__menu")));

		// DEBUG: Print all available options
		List<WebElement> allOptions = driver.findElements(By.cssSelector(".react-select__option"));
		for (WebElement opt : allOptions) {
			System.out.println("[" + opt.getText() + "]");
		}

		// Try to find the matching option
		WebElement option = wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//div[contains(@class,'react-select__option') and contains(., \"" + subName.trim() + "\")]")));
		option.click();
	}

	@Then("Select Business and Commerce option in subject dropdown")
	public void select_business_and_commerce_option_in_subject_dropdown() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[3]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[3]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Business and Commerce']"));
		ele2.click();
	}

	@Then("Select Cryptography option in subject dropdown")
	public void select_cryptography_option_in_subject_dropdown() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[3]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[3]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Automation  Testing using Selenium']"));
		ele2.click();
	}

	@Then("Select Cyber Security option in subject dropdown")
	public void select_cyber_security_option_in_subject_dropdown() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Cyber Security']"));
		ele2.click();
	}

	@Then("Select Data Science option in subject dropdown")
	public void select_data_science_option_in_subject_dropdown() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Data Science']"));
		ele2.click();
	}

	@Given("Select All Level option in level dropdown")
	public void select_all_level_option_in_level_dropdown() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//div[@class='react-select__control css-yk16xz-control'])[5]")));
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[@class='react-select__control css-yk16xz-control'])[5]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='react-select__control css-yk16xz-control'])[5]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='All Level']"));
		ele2.click();
		ele1.click();
	}

	@When("Select {string} option in the topic dropdown")
	public void select_option_in_the_topic_dropdown(String topicName) {
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.loaderStyle")));
		} catch (TimeoutException ignored) {

		}

		// 2. Wait for the Level dropdown control to be clickable
		By topicDropdownLocator = By.xpath("(//div[contains(@class,'react-select__control')])[4]");
		WebElement topicDropdown = wait.until(ExpectedConditions.elementToBeClickable(topicDropdownLocator));

		// 3. Click to open dropdown
		topicDropdown.click();

		// 4. Wait for options menu to appear
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".react-select__menu")));

		// 5. Wait for and click the desired level option
		By topicOptionLocator = By.xpath(
				"//div[contains(@class,'react-select__option') and normalize-space(text())='" + topicName + "']");
		WebElement topicOption = wait.until(ExpectedConditions.elementToBeClickable(topicOptionLocator));
		topicOption.click();
	}

	@Then("Check {string} option is displayed or not in the topic dropdown")
	public void check_option_is_displayed_or_not_in_the_topic_dropdown(String topicName) {
		By topicDropdownLocator = By.xpath("(//div[contains(@class,'react-select__control')])[2]");
		By seleniumOptionLocator = By
				.xpath("//div[contains(@class,'react-select__option') and normalize-space(text())='Selenium']");

		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Retry in case of StaleElementReferenceException
		for (int attempt = 0; attempt < 2; attempt++) {
			try {
				// Always re-find the dropdown before clicking
				WebElement topicDropdown = wait.until(ExpectedConditions.elementToBeClickable(topicDropdownLocator));
				topicDropdown.click();

				// Wait for menu to appear
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".react-select__menu")));

				// Check if Selenium option is visible
				boolean isDisplayed;
				try {
					isDisplayed = wait.until(ExpectedConditions.visibilityOfElementLocated(seleniumOptionLocator))
							.isDisplayed();
					System.out.println("✅ Selected Option is displayed");
				} catch (TimeoutException e) {
					isDisplayed = false;
				}
				break; // Exit loop if successful

			} catch (StaleElementReferenceException e) {
				System.out.println("✅ Dropdown went stale, retrying... attempt " + (attempt + 1));
			}
		}

	}

	@When("Select {string} option in level dropdown")
	public void select_option_in_level_dropdown(String levelName) {
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.loaderStyle")));
		} catch (TimeoutException ignored) {
		}

		// 2. Wait for the Level dropdown control to be clickable
		By levelDropdownLocator = By.xpath("(//div[contains(@class,'react-select__control')])[5]");
		WebElement levelDropdown = wait.until(ExpectedConditions.elementToBeClickable(levelDropdownLocator));

		// 3. Click to open dropdown
		levelDropdown.click();

		// 4. Wait for options menu to appear
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".react-select__menu")));

		// 5. Wait for and click the desired level option
		By levelOptionLocator = By.xpath(
				"//div[contains(@class,'react-select__option') and normalize-space(text())='" + levelName + "']");
		WebElement levelOption = wait.until(ExpectedConditions.elementToBeClickable(levelOptionLocator));
		levelOption.click();
	}

	@Given("Select Easy option in level dropdown")
	public void select_easy_option_in_level_dropdown() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"//div[@class='react-select__control react-select__control--is-focused react-select__control--menu-is-open css-1pahdxg-control']")));
		ele1 = driver.findElement(By.xpath(
				"//div[@class='react-select__control react-select__control--is-focused react-select__control--menu-is-open css-1pahdxg-control']"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Easy']"));
		ele2.click();
	}

	@Then("Select Medium option in level dropdown")
	public void select_medium_option_in_level_dropdown() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[3]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[3]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Medium']"));
		ele2.click();
	}

	@Then("Select Hard option in level dropdown")
	public void select_hard_option_in_level_dropdown() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[3]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[3]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Hard']"));
		ele2.click();
	}

	@Given("Check 3dots button")
	public void check_3dots_button() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//button[contains(@class,'btn-icon btn-icon-only')])[1]")));
		WebElement elementToHover = driver
				.findElement(By.xpath("(//button[contains(@class,'btn-icon btn-icon-only')])[1]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(elementToHover).perform();
	}

	@Given("Check  question created user name and date & time details displayed or not")
	public void check_question_created_user_name_and_date_time_details_displayed_or_not() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='popover-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='popover-body']"));
		String text = ele1.getText();
		System.out.println("✅ Question created username and Date & Time is: " + text);
	}

	@Then("Click previous button in pagination in question manager")
	public void click_previous_button_in_pagination_in_question_manager() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[contains(.,'Previous')]")));
		ele1 = driver.findElement(By.xpath("//li[contains(.,'Previous')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(3000);
		ele1.click();
	}

	@When("Click next button in pagination in question manager")
	public void click_next_button_in_pagination_in_question_manager() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[contains(.,'Next')]")));
		ele1 = driver.findElement(By.xpath("//li[contains(.,'Next')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(3000);
		ele1.click();
	}

	@Then("Click the number button in pagination in question manager")
	public void click_the_number_button_in_pagination_in_question_manager() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[normalize-space(text())='5']")));
		ele1 = driver.findElement(By.xpath("//a[normalize-space(text())='5']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(3000);
		ele1.click();
	}

	@Given("Click last button in pagination in question manager")
	public void click_last_button_in_pagination_in_question_manager() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[contains(.,'Last')]")));
		ele1 = driver.findElement(By.xpath("//li[contains(.,'Last')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(3000);
		ele1.click();
	}

	@When("Click first button in pagination in question manager")
	public void click_first_button_in_pagination_in_question_manager() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@class='page-link'])[1]")));
		ele1 = driver.findElement(By.xpath("(//a[@class='page-link'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(3000);
		ele1.click();
	}

//	@Given("Click add questions button")
//	public void click_add_questions_button() {
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
//
//		// First round
//		 // Wait for the Actions button and click it
//        WebElement actionsButton = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//button[contains(text(),'Actions')]")
//        ));
//        actionsButton.click();
//
//        // Wait for "Add Questions" link to appear
//        WebElement addQuestions = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//a[contains(.,'Add Questions')]")
//        ));
//        addQuestions.click();
//	}

	@Given("Click actions button")
	public void click_actions_button() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// ✅ Step 1: Ensure the page is fully loaded
		wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
				.equals("complete"));

		// ✅ Step 2: Wait until loader is completely gone
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.loaderStyle")));

		// ✅ Step 3: Wait for the Actions button to be clickable AND visible without
		// obstruction
		By actionsButtonLocator = By.xpath("//button[contains(text(),'Actions')]");
		wait.until(ExpectedConditions.elementToBeClickable(actionsButtonLocator));

		// Extra safety: Ensure no loader appears again before clicking
		wait.until(driver1 -> {
			List<WebElement> loaders = driver1.findElements(By.cssSelector("div.loaderStyle"));
			return loaders.isEmpty() || loaders.stream().allMatch(e -> !e.isDisplayed());
		});

		// ✅ Step 4: Click the button using JS (bypasses overlay issues if still
		// present)
		WebElement actionsButton = driver.findElement(actionsButtonLocator);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", actionsButton);
	}

	@When("Click add questions button")
	public void click_add_questions_button() throws InterruptedException {
		Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		// ✅ Wait until the page is fully loaded (document.readyState = complete)
		wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
				.equals("complete"));

		wait.until(ExpectedConditions.or(
		        ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.loaderStyle")),
		        ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Add Questions')]"))
		));

		WebElement addQuestions = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(.,'Add Questions')]")));
		try {
		    addQuestions.click();
		} catch (ElementClickInterceptedException e) {
		    // Loader still covering, wait a bit and retry
		    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.loaderStyle")));
		    addQuestions.click();
		}
	}

	public void safeClick(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Wait for page to finish loading
		wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
				.equals("complete"));

		// Retry loop: try clicking until success
		for (int i = 0; i < 3; i++) {
			try {
				// Wait for loader to be invisible
				wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.loaderStyle")));

				// Wait for element to be clickable
				WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

				// Scroll into view
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", element);

				// Try click
				element.click();
				return; // ✅ success → exit method
			} catch (ElementClickInterceptedException e) {
				System.out.println("⚠️ Loader still intercepting, retrying... attempt " + (i + 1));
				try {
					Thread.sleep(1000); // small wait before retry
				} catch (InterruptedException ignored) {
				}
			}
		}

		// Final fallback → JS click
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	}

	@Given("Click view questions button")
	public void click_view_questions_button() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Step 1: Wait for page fully loaded
		wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
				.equals("complete"));

		// Step 2: Wait until loader is gone
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.loaderStyle")));

		// Step 3: Wait until button is actually clickable (not just present)
		By buttonLocator = By.xpath("(//button[contains(@class,'btn btn-sm')])[1]");
		safeClick(driver, buttonLocator);
	}

	@Then("Check landing page in add question page")
	public void check_landing_page_in_add_question_page() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
				.equals("complete"));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.loaderStyle")));
		wait.until(ExpectedConditions.elementToBeClickable(By.name("txtSearch")));
		ele1 = driver.findElement(By.name("txtSearch"));
		boolean isDisplayed = ele1.isDisplayed();
		Assert.assertTrue("Back button is not working", isDisplayed);
	}

	@Given("Click save button in add question page")
	public void click_save_button_in_add_question_page() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnSave")));
		ele1 = driver.findElement(By.id("btnSave"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}

	@Then("Check mandatory red border is displayed or not in add question page")
	public void check_mandatory_red_border_is_displayed_or_not_in_add_question_page() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[1]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[1]"));
		ele2 = driver.findElement(By.xpath("//div[@class='react-select__value-container css-1hwfws3']"));
		ele3 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]"));
		ele4 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[3]"));

		String borderColor1, borderColor2, borderColor3, borderColor4;
		try {
			borderColor1 = ele1.getCssValue("border-color");
			borderColor2 = ele2.getCssValue("border-color");
			borderColor3 = ele3.getCssValue("border-color");
			borderColor4 = ele4.getCssValue("border-color");
		} catch (Exception e) {
			borderColor1 = "not available";
			borderColor2 = "not available";
			borderColor3 = "not available";
			borderColor4 = "not available";

			System.out.println("✅ Error getting border color: " + e.getMessage());
		}
		String expectedBorderColor = "rgb(78, 78, 78)";
		System.out.println("✅ Actual border color : " + borderColor1);
		System.out.println("✅ Actual border color : " + borderColor2);
		System.out.println("✅ Actual border color : " + borderColor3);
		System.out.println("✅ Actual border color : " + borderColor4);
		if (borderColor1.toLowerCase().equals(expectedBorderColor.toLowerCase())) {
			System.out.println(
					"✅ Tab border color is as expected as RED colour with color code : " + expectedBorderColor);
		} else {
			System.out.println(
					"✅ Tab border color is incorrect. Expected: " + expectedBorderColor + ", Actual: " + borderColor1);
		}
		if (borderColor2.toLowerCase().equals(expectedBorderColor.toLowerCase())) {
			System.out.println(
					"✅ Tab border color is as expected as RED colour with color code : " + expectedBorderColor);
		} else {
			System.out.println(
					"✅ Tab border color is incorrect. Expected: " + expectedBorderColor + ", Actual: " + borderColor2);
		}
		if (borderColor3.toLowerCase().equals(expectedBorderColor.toLowerCase())) {
			System.out.println(
					"✅ Tab border color is as expected as RED colour with color code : " + expectedBorderColor);
		} else {
			System.out.println(
					"✅ Tab border color is incorrect. Expected: " + expectedBorderColor + ", Actual: " + borderColor3);
		}
		if (borderColor4.toLowerCase().equals(expectedBorderColor.toLowerCase())) {
			System.out.println(
					"✅ Tab border color is as expected as RED colour with color code : " + expectedBorderColor);
		} else {
			System.out.println(
					"✅ Tab border color is incorrect. Expected: " + expectedBorderColor + ", Actual: " + borderColor4);
		}
		Assert.assertEquals("Red border is not displayed in subject tab", borderColor1, expectedBorderColor);
		Assert.assertEquals("Red border is not displayed in topic tab", borderColor2, expectedBorderColor);
		Assert.assertEquals("Red border is not displayed in question type tab", borderColor3, expectedBorderColor);
		Assert.assertEquals("Red border is not displayed in question level tab", borderColor4, expectedBorderColor);
	}

	@Then("Click clear button in add questions page")
	public void click_clear_button_in_add_questions_page() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(.,'Clear')]")));
		ele1 = driver.findElement(By.xpath("//button[contains(.,'Clear')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}

	@Then("Check mandatory red border is removed or not in add question page")
	public void check_mandatory_red_border_is_removed_or_not_in_add_question_page() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[1]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[1]"));
		ele2 = driver.findElement(By.xpath("//div[@class='react-select__value-container css-1hwfws3']"));
		ele3 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]"));
		ele4 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[3]"));

		String borderColor1, borderColor2, borderColor3, borderColor4;
		try {
			borderColor1 = ele1.getCssValue("border-color");
			borderColor2 = ele2.getCssValue("border-color");
			borderColor3 = ele3.getCssValue("border-color");
			borderColor4 = ele4.getCssValue("border-color");
		} catch (Exception e) {
			borderColor1 = "not available";
			borderColor2 = "not available";
			borderColor3 = "not available";
			borderColor4 = "not available";

			System.out.println("❌ Error getting border color: " + e.getMessage());
		}
		String expectedBorderColor = "rgb(78, 78, 78)";
		System.out.println("⚠️ Actual border color : " + borderColor1);
		System.out.println("⚠️ Actual border color : " + borderColor2);
		System.out.println("⚠️ Actual border color : " + borderColor3);
		System.out.println("⚠️ Actual border color : " + borderColor4);
		if (borderColor1.toLowerCase().equals(expectedBorderColor.toLowerCase())) {
			System.out.println(
					"✅ Tab border color is as expected as RED colour with color code : " + expectedBorderColor);
			System.out.println("✔️ Red border is removed");
		} else {
			System.out.println("❌ Red border is not removed");
		}
		if (borderColor2.toLowerCase().equals(expectedBorderColor.toLowerCase())) {
			System.out.println(
					"✔️ Tab border color is as expected as RED colour with color code : " + expectedBorderColor);
			System.out.println("✔️ Red border is removed");
		} else {
			System.out.println("❌ Red border is not removed");
		}
		if (borderColor3.toLowerCase().equals(expectedBorderColor.toLowerCase())) {
			System.out.println(
					"✔️ Tab border color is as expected as RED colour with color code : " + expectedBorderColor);
			System.out.println("✔️ Red border is removed");
		} else {
			System.out.println("❌ Red border is not removed");
		}
		if (borderColor4.toLowerCase().equals(expectedBorderColor.toLowerCase())) {
			System.out.println(
					"✔️ Tab border color is as expected as RED colour with color code : " + expectedBorderColor);
			System.out.println("✔️ Red border is removed");
		} else {
			System.out.println("❌ Red border is not removed");
		}

		Assert.assertEquals("❌ Red border is not removed in subject tab", borderColor1, expectedBorderColor);
		Assert.assertEquals("❌ Red border is not removed in topic tab", borderColor2, expectedBorderColor);
		Assert.assertEquals("❌ Red border is not removed in question type tab", borderColor3, expectedBorderColor);
		Assert.assertEquals("❌ Red border is not removed in question level tab", borderColor4, expectedBorderColor);
	}

	@Given("Click add button in subject tab")
	public void click_add_button_in_subject_tab() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[contains(@class,'btn btn-sm')])[2]")));
		ele1 = driver.findElement(By.xpath("(//button[contains(@class,'btn btn-sm')])[2]"));
		ele1.click();
	}

	@Given("Click close button in add subject popup")
	public void click_close_button_in_add_subject_popup() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@class,'btn-sms btn')]")));
		ele1 = driver.findElement(By.xpath("//button[contains(@class,'btn-sms btn')]"));
		ele1.click();
	}

	@Then("Click add button in add subject popup")
	public void click_add_button_in_add_subject_popup() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//button[contains(@class,'btn btn-outline-primary')])[2]")));
		ele1 = driver.findElement(By.xpath("(//button[contains(@class,'btn btn-outline-primary')])[2]"));
		ele1.click();
	}

	@Then("Check mandatory red border is displayed or not in subject name")
	public void check_mandatory_red_border_is_displayed_or_not_in_subject_name() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("catName")));
		ele1 = driver.findElement(By.id("catName"));
		String borderColor;
		try {
			borderColor = ele1.getCssValue("border-color");
		} catch (Exception e) {
			borderColor = "not available";
			System.out.println("❌ Error getting border color: " + e.getMessage());
		}
		String expectedBorderColor = "rgb(255, 0, 0)";
		System.out.println("⚠️ Actual border color : " + borderColor);
		if (borderColor.toLowerCase().equals(expectedBorderColor.toLowerCase())) {
			System.out.println(
					"✔️ Tab border color is as expected as RED colour with color code : " + expectedBorderColor);
			System.out.println("✔️ Red border is displayed");
		} else {
			System.out.println(
					"❌ Tab border color is incorrect. Expected: " + expectedBorderColor + ", Actual: " + borderColor);
		}
		Assert.assertEquals("❌ Red border is not displayed in subject name", borderColor, expectedBorderColor);
	}

	@Then("Enter special characters in add subject popup")
	public void enter_special_characters_in_add_subject_popup() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("catName")));
		ele1 = driver.findElement(By.id("catName"));
		ele1.sendKeys("!@#$%");
	}

	@Then("Clear the details in add subject popup")
	public void clear_the_details_in_add_subject_popup() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("catName")));
		ele1 = driver.findElement(By.id("catName"));
		ele1.clear();
	}

	@Then("Enter numerical characters in add subject popup")
	public void enter_numerical_characters_in_add_subject_popup() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("catName")));
		ele1 = driver.findElement(By.id("catName"));
		ele1.sendKeys("12345");
	}

	@Then("Enter existing subject name in add subject popup")
	public void enter_existing_subject_name_in_add_subject_popup() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("catName")));
		ele1 = driver.findElement(By.id("catName"));
		ele1.sendKeys("Artificial Intelligence");
	}

	@Then("Check alert message is displayed or not in add subject")
	public void check_alert_message_is_displayed_or_not_in_add_subject() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actualMessage = ele1.getText();
		System.out.println("⚠️ Error message displayed like: " + actualMessage);
		String expectedMessage = "Subject already exists!";
		Assert.assertEquals("⚠️ Error message need to display", actualMessage, expectedMessage);
	}

	@Then("Check alert message is displayed or not in add subject page")
	public void check_alert_message_is_displayed_or_not_in_add_subject_page() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actualMessage = ele1.getText();
		System.out.println("⚠️ Error message displayed like: " + actualMessage);
		String expectedMessage = "Question 1 - question type is required!";
		Assert.assertEquals("⚠️ Error message need to display", actualMessage, expectedMessage);
	}

	@Then("Check alert message is displayed or not to check question level in add subject page")
	public void check_alert_message_is_displayed_or_not_to_check_question_level_in_add_subject_page()
			throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actualMessage = ele1.getText();
		System.out.println("⚠️ Error message displayed like: " + actualMessage);
		String expectedMessage = "Question 1 - question level is required!";
		Assert.assertEquals("⚠️ Error message need to display", actualMessage, expectedMessage);
	}

	@Then("Check alert message is displayed or not to check question required in add subject page")
	public void check_alert_message_is_displayed_or_not_to_check_question_required_in_add_subject_page()
			throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actualMessage = ele1.getText();
		System.out.println("⚠️ Error message displayed like: " + actualMessage);
		String expectedMessage = "Question 1 - Question is required!";
		Assert.assertEquals("⚠️ Error message need to display", actualMessage, expectedMessage);
	}

	@Then("Check alert message is displayed or not to check answer required in add subject page")
	public void check_alert_message_is_displayed_or_not_to_check_answer_required_in_add_subject_page()
			throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actualMessage = ele1.getText();
		System.out.println("⚠️ Error message displayed like: " + actualMessage);
		String expectedMessage = "Question 1 - Answer is required!";
		Assert.assertEquals("⚠️ Error message need to display", actualMessage, expectedMessage);
	}

	@Then("Check alert message is displayed or not to check explanation required in add subject page")
	public void check_alert_message_is_displayed_or_not_to_check_explanation_required_in_add_subject_page()
			throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actualMessage = ele1.getText();
		System.out.println("⚠️ Error message displayed like: " + actualMessage);
		String expectedMessage = "Question 1 - Explanation is required!";
		Assert.assertEquals("⚠️ Error message need to display", actualMessage, expectedMessage);
	}
	
	@Then("Check alert message is displayed or not in scenario required in add subject")
	public void check_alert_message_is_displayed_or_not_in_scenario_required_in_add_subject()
			throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actualMessage = ele1.getText();
		System.out.println("⚠️ Error message displayed like: " + actualMessage);
		String expectedMessage = "Scenario is required!";
		Assert.assertEquals("⚠️ Error message need to display", actualMessage, expectedMessage);
	}

	@Then("Enter valid subject name in add subject popup")
	public void enter_valid_subject_name_in_add_subject_popup() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("catName")));
		ele1 = driver.findElement(By.id("catName"));
		Faker fake = new Faker();
		String subname = fake.educator().course();
		ele1.sendKeys(subname);
	}

	@Then("Check success message is displayed or not in add subject")
	public void check_success_message_is_displayed_or_not_in_add_subject() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actualMessage = ele1.getText();
		System.out.println("✅ Success message displayed like: " + actualMessage);
		String expectedMessage = "Subject added successfully!";
		Assert.assertEquals("Error message need to display", actualMessage, expectedMessage);
	}

	@When("Select {string} subject from the dropdown")
	public void select_subject_from_the_dropdown(String subName) throws InterruptedException {
		Thread.sleep(2000);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Wait for the dropdown container to be clickable (not necessarily with value)
		WebElement dropdown = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//div[contains(@class,'react-select__value-container')])[1]")));
		dropdown.click();

		// Now wait for the desired option to appear
		WebElement option = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[normalize-space(text())='" + subName + "']")));
		option.click();
	}

	@Then("Click edit button in subject tab")
	public void click_edit_button_in_subject_tab() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[contains(@class,'btn btn-sm')])[3]")));
		ele1 = driver.findElement(By.xpath("(//button[contains(@class,'btn btn-sm')])[3]"));
		ele1.click();
	}

	@Then("Click Close button in edit subject popup")
	public void click_close_button_in_edit_subject_popup() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@class,'btn-sms btn')]")));
		ele1 = driver.findElement(By.xpath("//button[contains(@class,'btn-sms btn')]"));
		ele1.click();
	}

	@Then("Modify valid subject name in edit subject popup")
	public void modify_valid_subject_name_in_edit_subject_popup() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("catName")));
		ele1 = driver.findElement(By.id("catName"));
		String text = ele1.getDomAttribute("value");
		int length = text.length();
		for (int i = 0; i < length; i++) {
			ele1.sendKeys(Keys.BACK_SPACE);
		}
		ele1.sendKeys(text);
	}

	@Then("Click update button in edit subject popup")
	public void click_update_button_in_edit_subject_popup() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//button[contains(@class,'btn btn-outline-primary')])[2]")));
		ele1 = driver.findElement(By.xpath("(//button[contains(@class,'btn btn-outline-primary')])[2]"));
		ele1.click();
	}

	@Then("Check success message is displayed or not in edit subject")
	public void check_success_message_is_displayed_or_not_in_edit_subject() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actualMessage = ele1.getText();
		System.out.println("✅ Success message displayed like: " + actualMessage);
	}

	@Then("Click Delete button in subject tab")
	public void click_delete_button_in_subject_tab() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[contains(@class,'btn btn-sm')])[4]")));
		ele1 = driver.findElement(By.xpath("(//button[contains(@class,'btn btn-sm')])[4]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}

	@Then("Click Close button in Delete Subject popup")
	public void click_close_button_in_delete_subject_popup() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@class,'btn-sms btn')]")));
		ele1 = driver.findElement(By.xpath("//button[contains(@class,'btn-sms btn')]"));
		ele1.click();
	}

	@Then("Click NO button in Delete Subject popup")
	public void click_no_button_in_delete_subject_popup() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//button[contains(@class,'btn btn-outline-primary')])[2]")));
		ele1 = driver.findElement(By.xpath("(//button[contains(@class,'btn btn-outline-primary')])[2]"));
		ele1.click();
	}

	@Then("Click YES button in Delete Subject popup")
	public void click_yes_button_in_delete_subject_popup() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='btn btn-primary']")));
		ele1 = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		ele1.click();
	}

	@Then("Check success message is displayed or not in Delete Subject")
	public void check_success_message_is_displayed_or_not_in_delete_subject() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement ele = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		assertTrue(ele.isDisplayed());
		String alertMessage = ele.getText();
		System.out.println("✅ Alert message displayed like: " + alertMessage);
	}

	@Then("Click add button in topic tab")
	public void click_add_button_in_topic_tab() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("(//button[contains(@class,'btn btn-sm btn-outline-primary ms-2')])[4]")));
		ele1 = driver.findElement(By.xpath("(//button[contains(@class,'btn btn-sm btn-outline-primary ms-2')])[4]"));
		ele1.click();
	}

	@Then("Click add button in add topic popup")
	public void click_add_button_in_add_topic_popup() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//button[contains(@class,'btn btn-outline-primary')])[2]")));
		ele1 = driver.findElement(By.xpath("(//button[contains(@class,'btn btn-outline-primary')])[2]"));
		ele1.click();
	}

	@Then("Click close button in add topic popup")
	public void click_close_button_in_add_topic_popup() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@class,'btn-sms btn')]")));
		ele1 = driver.findElement(By.xpath("//button[contains(@class,'btn-sms btn')]"));
		ele1.click();
	}

	@Then("Check mandatory red border is displayed or not in add topic popup")
	public void check_mandatory_red_border_is_displayed_or_not_in_add_topic_popup() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("topicName")));
		ele1 = driver.findElement(By.id("topicName"));
		String borderColor;
		try {
			borderColor = ele1.getCssValue("border-color");
		} catch (Exception e) {
			borderColor = "not available";
			System.out.println("❌ Error getting border color: " + e.getMessage());
		}
		String expectedBorderColor = "rgb(255, 0, 0)";
		System.out.println("⚠️ Actual border color : " + borderColor);
		if (borderColor.toLowerCase().equals(expectedBorderColor.toLowerCase())) {
			System.out.println(
					"✔️ Tab border color is as expected as RED colour with color code : " + expectedBorderColor);
		} else {
			System.out.println(
					"❌ Tab border color is incorrect. Expected: " + expectedBorderColor + ", Actual: " + borderColor);
		}
		Assert.assertEquals("Red border is not displayed", borderColor, expectedBorderColor);
	}

	@Then("Enter valid topic name in add topic popup")
	public void enter_valid_topic_name_in_add_topic_popup() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("topicName")));
		ele1 = driver.findElement(By.id("topicName"));
		ele1.sendKeys("Test Topic");
	}

	@Then("Check success message is displayed or not in add topic popup")
	public void check_success_message_is_displayed_or_not_in_add_topic_popup() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actualMessage = ele1.getText();
		System.out.println("✔️ Success message displayed like: " + actualMessage);
		String expectedMessage = "Topic added successfully!";
		Assert.assertEquals("Add topic is not working", actualMessage, expectedMessage);
	}

	@Then("Click edit button in topic tab")
	public void click_edit_button_in_topic_tab() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//button[@class='btn btn-sm btn-outline-primary ms-2'])[5]")));
		ele1 = driver.findElement(By.xpath("(//button[@class='btn btn-sm btn-outline-primary ms-2'])[5]"));
		ele1.click();
	}

	@Then("Click Close button in edit topic popup")
	public void click_close_button_in_edit_topic_popup() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@class,'btn-sms btn')]")));
		ele1 = driver.findElement(By.xpath("//button[contains(@class,'btn-sms btn')]"));
		ele1.click();
	}

	@Then("Modify valid topic name in edit topic popup")
	public void modify_valid_topic_name_in_edit_topic_popup() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("topicName")));
		ele1 = driver.findElement(By.id("topicName"));
		String text = ele1.getDomProperty("value");
		int length = text.length();
		for (int i = 0; i < length; i++) {
			ele1.sendKeys(Keys.BACK_SPACE);
		}
		Thread.sleep(2000);
		ele1.sendKeys(text);
	}

	@Then("Modify valid subject name in edit topic")
	public void modify_valid_subject_name_in_edit_topic() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("topicName")));
		ele1 = driver.findElement(By.id("topicName"));
		String text = ele1.getDomProperty("value");
		int length = text.length();
		for (int i = 0; i < length; i++) {
			ele1.sendKeys(Keys.BACK_SPACE);
		}
		Thread.sleep(2000);
		ele1.sendKeys("Test Topic");
	}

	@Then("Click update button in edit topic popup")
	public void click_update_button_in_edit_topic_popup() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//button[contains(@class,'btn btn-outline-primary')])[2]")));
		ele1 = driver.findElement(By.xpath("(//button[contains(@class,'btn btn-outline-primary')])[2]"));
		ele1.click();
	}

	@Then("Check success message is displayed or not in edit topic")
	public void check_success_message_is_displayed_or_not_in_edit_topic() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actualMessage = ele1.getText();
		System.out.println("✔️ Success message displayed like: " + actualMessage);
		String expectedMessage = "Topic updated successfully!";
		Assert.assertEquals("Test topic add button is not working", actualMessage, expectedMessage);
	}

	@Then("Click Delete button in topic tab")
	public void click_delete_button_in_topic_tab() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[contains(@class,'btn btn-sm')])[7]")));
		ele1 = driver.findElement(By.xpath("(//button[contains(@class,'btn btn-sm')])[7]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}

	@Then("Click Close button in Delete topic popup")
	public void click_close_button_in_delete_topic_popup() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@class,'btn-sms btn')]")));
		ele1 = driver.findElement(By.xpath("//button[contains(@class,'btn-sms btn')]"));
		ele1.click();
	}

	@Then("Click NO button in Delete topic popup")
	public void click_no_button_in_delete_topic_popup() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//button[contains(@class,'btn btn-outline-primary')])[2]")));
		ele1 = driver.findElement(By.xpath("(//button[contains(@class,'btn btn-outline-primary')])[2]"));
		ele1.click();
	}

	@Then("Click YES button in Delete topic popup")
	public void click_yes_button_in_delete_topic_popup() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[normalize-space(text())='Yes']")));
		ele1 = driver.findElement(By.xpath("//button[normalize-space(text())='Yes']"));
		ele1.click();
	}

	@Then("Check success message is displayed or not in topic tab")
	public void check_success_message_is_displayed_or_not_in_topic_tab() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actualMessage = ele1.getText();
		System.out.println("✔️ Success message displayed like: " + actualMessage);
		String expectedMessage = "Topic deleted successfully!";
		Assert.assertEquals("Delete topic is not working", actualMessage, expectedMessage);
	}

	@Given("Click add button in Question Type tab")
	public void click_add_button_in_question_type_tab() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("(//button[contains(@class,'btn btn-sm btn-outline-primary ms-2')])[7]")));
		ele1 = driver.findElement(By.xpath("(//button[contains(@class,'btn btn-sm btn-outline-primary ms-2')])[7]"));
		ele1.click();
	}

	@Then("Click add button in add Question Type popup")
	public void click_add_button_in_add_question_type_popup() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//button[contains(@class,'btn btn-outline-primary')])[2]")));
		ele1 = driver.findElement(By.xpath("(//button[contains(@class,'btn btn-outline-primary')])[2]"));
		ele1.click();
	}

	@Then("Click close button in add Question Type popup")
	public void click_close_button_in_add_question_type_popup() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@class,'btn-sms btn')]")));
		ele1 = driver.findElement(By.xpath("//button[contains(@class,'btn-sms btn')]"));
		ele1.click();
	}

	@Then("Check mandatory red border is displayed or not in add Question Type popup")
	public void check_mandatory_red_border_is_displayed_or_not_in_add_question_type_popup()
			throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("questType")));
		ele1 = driver.findElement(By.id("questType"));
		String borderColor;
		try {
			borderColor = ele1.getCssValue("border-color");
		} catch (Exception e) {
			borderColor = "not available";
			System.out.println("❌ Error getting border color: " + e.getMessage());
		}
		String expectedBorderColor = "rgb(255, 0, 0)";
		System.out.println("⚠️ Actual border color : " + borderColor);
		if (borderColor.toLowerCase().equals(expectedBorderColor.toLowerCase())) {
			System.out.println(
					"✔️ Tab border color is as expected as RED colour with color code : " + expectedBorderColor);
		} else {
			System.out.println(
					"❌ Tab border color is incorrect. Expected: " + expectedBorderColor + ", Actual: " + borderColor);
		}
		Assert.assertEquals("❌ Red border is not displayed in question type pop up", borderColor, expectedBorderColor);
	}

	@Then("Enter {string} question type in add Question Type popup")
	public void enter_question_type_in_add_question_type_popup(String queType) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Question Type']")));
		ele1 = driver.findElement(By.xpath("//input[@placeholder='Question Type']"));
		ele1.sendKeys(queType);
	}

	@Then("Check success message is displayed or not in add Question Type popup")
	public void check_success_message_is_displayed_or_not_in_add_question_type_popup() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actualMessage = ele1.getText();
		System.out.println("✔️ Success message displayed like: " + actualMessage);
		String expectedMessage = "Question Type added successfully!";
		Assert.assertEquals("Add question type is not working", actualMessage, expectedMessage);
	}

	@Given("Select any Question Type from the dropdown")
	public void select_any_question_type_from_the_dropdown() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Test Types']"));
		ele2.click();
	}

	@When("Select {string} Question Type from the dropdown")
	public void select_question_type_from_the_dropdown(String queType) throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[3]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[3]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='" + queType + "']"));
		ele2.click();
	}

	@Then("Select {string} topic from the dropdown in create questions")
	public void select_topic_from_the_dropdown_in_create_questions(String topicName) throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='" + topicName + "']"));
		ele2.click();
	}

	@Then("Select any topic from dropdown in create questions")
	public void select_any_topic_from_dropdown_in_create_questions() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Selenium']"));
		ele2.click();
	}

	@Then("Click edit button in Question Type tab")
	public void click_edit_button_in_question_type_tab() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//button[@class='btn btn-sm btn-outline-primary ms-2'])[8]")));
		ele1 = driver.findElement(By.xpath("(//button[@class='btn btn-sm btn-outline-primary ms-2'])[8]"));
		ele1.click();
	}

	@Then("Click Close button in edit Question Type popup")
	public void click_close_button_in_edit_question_type_popup() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@class,'btn-sms btn')]")));
		ele1 = driver.findElement(By.xpath("//button[contains(@class,'btn-sms btn')]"));
		ele1.click();
	}

	@Then("Modify Question Type name into {string} in edit Question Type popup")
	public void modify_question_type_name_into_in_edit_question_type_popup(String queType) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("questType")));
		ele1 = driver.findElement(By.id("questType"));
		String text = ele1.getDomProperty("value");
		int length = text.length();
		for (int i = 0; i < length; i++) {
			ele1.sendKeys(Keys.BACK_SPACE);
		}
		ele1.sendKeys(queType);
	}

	@Then("Modify valid subject name in edit Question Type")
	public void modify_valid_subject_name_in_edit_question_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("questType")));
		ele1 = driver.findElement(By.id("questType"));
		String text = ele1.getDomProperty("value");
		int length = text.length();
		for (int i = 0; i < length; i++) {
			ele1.sendKeys(Keys.BACK_SPACE);
		}
		Thread.sleep(1000);
		ele1.sendKeys("Test Type");
	}

	@Then("Click update button in edit Question Type popup")
	public void click_update_button_in_edit_question_type_popup() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//button[contains(@class,'btn btn-outline-primary')])[2]")));
		ele1 = driver.findElement(By.xpath("(//button[contains(@class,'btn btn-outline-primary')])[2]"));
		ele1.click();
	}

	@Then("Check success message is displayed or not in edit Question Type")
	public void check_success_message_is_displayed_or_not_in_edit_question_type() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actualMessage = ele1.getText();
		System.out.println("✔️ Success message displayed like: " + actualMessage);
		String expectedMessage = "Question Type updated successfully!";
		Assert.assertEquals("Add question type is not working", actualMessage, expectedMessage);
	}

	@Then("Click Delete button in Question Type tab")
	public void click_delete_button_in_question_type_tab() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//button[@class='btn btn-sm btn-outline-primary ms-2'])[9]")));
		ele1 = driver.findElement(By.xpath("(//button[@class='btn btn-sm btn-outline-primary ms-2'])[9]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}

	@Then("Click Close button in Delete Question Type popup")
	public void click_close_button_in_delete_question_type_popup() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@class,'btn-sms btn')]")));
		ele1 = driver.findElement(By.xpath("//button[contains(@class,'btn-sms btn')]"));
		ele1.click();
	}

	@Then("Click NO button in Delete Question Type popup")
	public void click_no_button_in_delete_question_type_popup() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//button[contains(@class,'btn btn-outline-primary')])[2]")));
		ele1 = driver.findElement(By.xpath("(//button[contains(@class,'btn btn-outline-primary')])[2]"));
		ele1.click();
	}

	@Then("Click YES button in Delete Question Type popup")
	public void click_yes_button_in_delete_question_type_popup() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='btn btn-primary']")));
		ele1 = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		ele1.click();
	}

	@Then("Check success message is displayed or not in Question Type")
	public void check_success_message_is_displayed_or_not_in_question_type() throws InterruptedException {
		Thread.sleep(1000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actualMessage = ele1.getText();
		System.out.println("✔️ Success message displayed like: " + actualMessage);
		String expectedMessage = "Question type deleted successfully!";
		Assert.assertEquals("Question type cannot able to delete", actualMessage, expectedMessage);
	}

	@Given("Select any option in subject")
	public void select_any_option_in_subject() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[1]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[1]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Artificial Intelligence']"));
		ele2.click();
	}

	@Then("Select {string} option in topic dropdown")
	public void select_option_in_topic_dropdown(String topic) throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[@class='react-select__value-container react-select__value-container--has-value css-1hwfws3'])[2]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[@class='react-select__value-container react-select__value-container--has-value css-1hwfws3'])[2]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='" + topic + "']"));
		ele2.click();
	}
	
	@Then("Select any option in topic")
	public void select_any_option_in_topic() {
		// 1️⃣ Click the dropdown to expand
		By dropdown = By.xpath("(//div[contains(@class,'react-select__value-container')])[1]");
		WebElement dropdownElement = driver.findElement(dropdown);
		dropdownElement.click();

		// 2️⃣ Wait for options to appear
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		List<WebElement> options = wait.until(ExpectedConditions
		        .visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'react-select__option')]")));

		// 3️⃣ Select the 2nd option (index 1 because list starts from 0)
		if (options.size() >= 2) {
		    options.get(1).click();  // this will select the 2nd value
		} else {
		    throw new RuntimeException("⚠️ Less than 2 options found in the dropdown");
		}

	}

	@Then("Select any option in question type")
	public void select_any_option_in_question_type() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[3]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[3]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Essay']"));
		ele2.click();
	}

	@Then("Click and Upload invalid file format in image field")
	public void click_and_upload_invalid_file_format_in_image_field() throws InterruptedException, AWTException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("imgref")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1 = driver.findElement(By.id("imgref"));
		Thread.sleep(2000);
		ele1.click();
		// Upload the file
		Thread.sleep(2000);
		String filepath = System.getProperty("user.dir") + "\\Files\\Audio File.mp3";
		Robot robot = new Robot();
		StringSelection selection = new StringSelection(filepath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		driver.switchTo().defaultContent();
	}

	@Then("Check file is uploaded or not in image field")
	public void check_file_is_uploaded_or_not_in_image_field() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[contains(@class,'me-3 text-bold')]")));
		ele1 = driver.findElement(By.xpath("//span[contains(@class,'me-3 text-bold')]"));
		boolean displayed = ele1.isDisplayed();
		if (displayed == true) {
			System.out.println("✔️ Image is uploaded");
		} else {
			System.out.println("🚫 Image is not uploaded");
		}
		Assert.assertTrue("Image File is not uploaded", displayed);
	}

	@Then("Check file is uploaded or not in audio field")
	public void check_file_is_uploaded_or_not_in_audio_field() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//span[contains(@class,'me-3 text-bold')])[1]")));
		ele1 = driver.findElement(By.xpath("(//span[contains(@class,'me-3 text-bold')])[1]"));
		boolean displayed = ele1.isDisplayed();
		if (displayed == true) {
			System.out.println("✔️ Audio is uploaded");
		} else {
			System.out.println("🚫 Audio is not uploaded");
		}
		Assert.assertTrue("Audio File is not uploaded", displayed);
	}

	@Then("Check file is uploaded or not in video field")
	public void check_file_is_uploaded_or_not_in_video_field() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//span[contains(@class,'me-3 text-bold')])[1]")));
		ele1 = driver.findElement(By.xpath("(//span[contains(@class,'me-3 text-bold')])[1]"));
		boolean displayed = ele1.isDisplayed();
		if (displayed == true) {
			System.out.println("✔️ Video is uploaded");
		} else {
			System.out.println("🚫 Video is not uploaded");
		}
		Assert.assertTrue("Video File is not uploaded", displayed);
	}

	@Then("Check error message is displayed or not in image field")
	public void check_error_message_is_displayed_or_not_in_image_field() throws InterruptedException {
		Thread.sleep(1500);
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actualMessage = ele1.getText();
		System.out.println("✅ Success message displayed like: " + actualMessage);
		String expMessage = "Invalid file format!";
		Assert.assertEquals("Invlaid file format can able to upload", actualMessage, expMessage);
	}

	@Then("Click and Upload invalid file format in audio field")
	public void click_and_upload_invalid_file_format_in_audio_field() throws InterruptedException, AWTException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("audref")));
		ele1 = driver.findElement(By.id("audref"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
		// Upload the file
		Thread.sleep(2000);
		String filepath = System.getProperty("user.dir") + "\\Files\\Sample.png";
		Robot robot = new Robot();
		StringSelection selection = new StringSelection(filepath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		driver.switchTo().defaultContent();
	}

	@Then("Check error message is displayed or not in audio field")
	public void check_error_message_is_displayed_or_not_in_audio_field() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actualMessage = ele1.getText();
		System.out.println("✅ Success message displayed like: " + actualMessage);
		String expMessage = "Invalid file format!";
		Assert.assertEquals("Invlaid file format can able to upload", actualMessage, expMessage);
	}

	@Then("Click and Upload invalid file format in video field")
	public void click_and_upload_invalid_file_format_in_video_field() throws InterruptedException, AWTException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("vidref")));
		ele1 = driver.findElement(By.id("vidref"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
		// Upload the file
		Thread.sleep(2000);
		String filepath = System.getProperty("user.dir") + "\\Files\\Sample.png";
		Robot robot = new Robot();
		StringSelection selection = new StringSelection(filepath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		driver.switchTo().defaultContent();
	}

	@Then("Check error message is displayed or not in video field")
	public void check_error_message_is_displayed_or_not_in_video_field() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actualMessage = ele1.getText();
		System.out.println("✅ Success message displayed like: " + actualMessage);
		String expMessage = "Invalid file format!";
		Assert.assertEquals("Invlaid file format can able to upload", actualMessage, expMessage);
	}

	@Then("Click and Upload valid file format in image field")
	public void click_and_upload_valid_file_format_in_image_field() throws InterruptedException, AWTException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("imgref")));
		ele1 = driver.findElement(By.id("imgref"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
		// Upload the file
		Thread.sleep(2000);
		String filepath = System.getProperty("user.dir") + "\\Files\\Sample.png";
		Robot robot = new Robot();
		StringSelection selection = new StringSelection(filepath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		driver.switchTo().defaultContent();
	}

	@Then("Check success message is displayed or not in image field")
	public void check_success_message_is_displayed_or_not_in_image_field() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement ele = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		assertTrue(ele.isDisplayed());
		String alertMessage = ele.getText();
		System.out.println("✅ Alert message displayed like: " + alertMessage);
	}

	@Then("Check alert message is displayed or not in source type")
	public void check_alert_message_is_displayed_or_not_in_source_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement ele1 = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		WebElement ele = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		assertTrue(ele.isDisplayed());
		String alertMessage = ele.getText();
		System.out.println("✅ Alert message displayed like: " + alertMessage);
	}

	@Then("Click and Upload valid file format in audio field")
	public void click_and_upload_valid_file_format_in_audio_field() throws InterruptedException, AWTException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("audref")));
		ele1 = driver.findElement(By.id("audref"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
		// Upload the file
		Thread.sleep(2000);
		String filepath = System.getProperty("user.dir") + "\\Files\\Audio File.mp3";
		Robot robot = new Robot();
		StringSelection selection = new StringSelection(filepath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		driver.switchTo().defaultContent();
	}

	@Then("Check success message is displayed or not in audio field")
	public void check_success_message_is_displayed_or_not_in_audio_field() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement ele = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		assertTrue(ele.isDisplayed());
		String alertMessage = ele.getText();
		System.out.println("✅ Alert message displayed like: " + alertMessage);
	}

	@Then("Click and Upload valid file format in video field")
	public void click_and_upload_valid_file_format_in_video_field() throws InterruptedException, AWTException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("vidref")));
		ele1 = driver.findElement(By.id("vidref"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
		// Upload the file
		Thread.sleep(2000);
		String filepath = System.getProperty("user.dir") + "\\Files\\Video File.mp4";
		Robot robot = new Robot();
		StringSelection selection = new StringSelection(filepath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		driver.switchTo().defaultContent();
	}

	@Then("Check success message is displayed or not in video field")
	public void check_success_message_is_displayed_or_not_in_video_field() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement ele = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		assertTrue(ele.isDisplayed());
		String alertMessage = ele.getText();
		System.out.println("✅ Alert message displayed like: " + alertMessage);
	}

	@Then("Click delete button in image field")
	public void click_delete_button_in_image_field() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Wait until delete button is clickable
		WebElement deleteButton = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[contains(@class,'btn-icon btn-icon-start')]")));

		// Wait until toast notification is gone
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.Toastify__toast-container")));

		// Scroll into view (optional)
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", deleteButton);

		// Click the delete button
		deleteButton.click();

	}

	@Then("Check file is removed or not in image field")
	public void check_file_is_removed_or_not_in_image_field() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[contains(@class,'text-center mt-2')]")));
		ele1 = driver.findElement(By.xpath("//div[contains(@class,'text-center mt-2')]"));
		boolean displayed = ele1.isDisplayed();
		if (displayed == false) {
			System.out.println("✅ Image is removed");
		} else {
			System.out.println("🚫 Image is not removed");
		}
		Assert.assertFalse("Image file is not able to delete", displayed);
	}

	@Then("Click delete button in audio field")
	public void click_delete_button_in_audio_field() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//button[contains(@class,'btn-icon btn-icon-start')]")));
		ele1 = driver.findElement(By.xpath("//button[contains(@class,'btn-icon btn-icon-start')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}

	@Then("Click No button in the delete confirmation popup")
	public void click_no_button_in_the_delete_confirmation_popup() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//button[contains(@class,'btn btn-outline-primary')])[3]")));
		ele1 = driver.findElement(By.xpath("(//button[contains(@class,'btn btn-outline-primary')])[3]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}

	@Then("Click Yes button in the delete confirmation popup")
	public void click_yes_button_in_the_delete_confirmation_popup() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='btn btn-primary']")));
		ele1 = driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}

	@Then("Check file is removed or not in audio field")
	public void check_file_is_removed_or_not_in_audio_field() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='mt-5']//audio[1]")));
		ele1 = driver.findElement(By.xpath("//div[@class='mt-5']//audio[1]"));
		boolean displayed = ele1.isDisplayed();
		System.out.println("⚠️ Item displayed status is: " + displayed);
		if (displayed == true) {
			System.out.println("✅ Audio is removed");
		} else {
			System.out.println("❌ Audio is not removed");
		}
		Assert.assertTrue("Audio file is not able to delete", displayed);
	}

	@Then("Click delete button in video field")
	public void click_delete_button_in_video_field() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//button[contains(@class,'btn-icon btn-icon-start')]")));
		ele1 = driver.findElement(By.xpath("//button[contains(@class,'btn-icon btn-icon-start')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}

	@Then("Check file is removed or not in video field")
	public void check_file_is_removed_or_not_in_video_field() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//div[contains(@class,'d-flex flex-column')])[2]")));
		ele1 = driver.findElement(By.xpath("(//div[contains(@class,'d-flex flex-column')])[2]"));
		boolean displayed = ele1.isDisplayed();
		if (displayed == false) {
			System.out.println("✅ Video is removed");
		} else {
			System.out.println("❌ Video is not removed");
		}
		Assert.assertFalse("Video file is not able to delete", displayed);
	}

	@Then("Select ESSAY option in question type")
	public void select_essay_option_in_question_type() throws InterruptedException {
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[3]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[3]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Essay']"));
		ele2.click();
	}

	@Then("Enter {string} details in question text box")
	public void enter_details_in_question_text_box(String question) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Wait for the iframe to be present
		WebElement iframeElement = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='tox-edit-area'])[1]//iframe")));

		// Scroll iframe into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", iframeElement);
		Thread.sleep(1000);

		// Switch to the iframe
		driver.switchTo().frame(iframeElement);

		// Now target the body inside TinyMCE
		WebElement textBody = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tinymce")));

		// Clear and enter the question
		textBody.clear();
		textBody.sendKeys(question);

		// Switch back to the main document
		driver.switchTo().defaultContent();
	}

	@Then("Check entered question details {string} is displayed or not in the question text box")
	public void check_entered_question_details_is_displayed_or_not_in_the_question_text_box(String string)
			throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='tox-edit-area'])[1]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='tox-edit-area'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		assertTrue(ele1.isDisplayed(), "❌ Entered question is not displayed!");
		System.out.println("✅ Entered question is displayed");
	}

	@Then("Enter {string} details in answers text box")
	public void enter_details_in_answers_text_box(String question) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Wait for the iframe to be present
		WebElement iframeElement = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='tox-edit-area'])[2]//iframe")));

		// Scroll iframe into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", iframeElement);
		Thread.sleep(1000);

		// Switch to the iframe
		driver.switchTo().frame(iframeElement);

		// Now target the body inside TinyMCE
		WebElement textBody = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tinymce")));

		// Clear and enter the question
		textBody.clear();
		textBody.sendKeys(question);

		// Switch back to the main document
		driver.switchTo().defaultContent();
	}

	@Then("Check entered answers details {string} is displayed or not in the answers text box")
	public void check_entered_answers_details_is_displayed_or_not_in_the_answers_text_box(String string)
			throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='tox-edit-area'])[2]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='tox-edit-area'])[2]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		assertTrue(ele1.isDisplayed(), "❌ Entered answer is not displayed!");
		System.out.println("✅ Entered answer is displayed");

	}

	@Then("Enter {string} details in remarks text box in add questions")
	public void enter_details_in_remarks_text_box_in_add_questions(String Remarks) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Step 1: Wait for the TinyMCE iframe
		WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("(//iframe[contains(@id,'_ifr') or contains(@class,'tox-edit-area__iframe')])[4]")));

		// Step 2: Switch to the iframe
		driver.switchTo().frame(iframe);

		// Step 3: Find the body of the editor and type
		WebElement body = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body")));
		body.clear(); // optional if old text exists
		body.sendKeys(Remarks);

		// Step 4: Switch back to the main page
		driver.switchTo().defaultContent();
	}

	@Then("Check entered answers details {string} is displayed or not in the remarks text box")
	public void check_entered_answers_details_is_displayed_or_not_in_the_remarks_text_box(String string)
			throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='tox-edit-area'])[4]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='tox-edit-area'])[4]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		assertTrue(ele1.isDisplayed(), "❌ Entered remarks is not displayed!");
		System.out.println("✅ Entered remarks is displayed");
	}

	@Then("Perform and check all features in the remarks text box")
	public void perform_and_check_all_features_in_the_remarks_text_box() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-header'])[5]")));
		ele1 = driver.findElement(By.xpath("(//button[@class='ql-header'])[5]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-list'])[5]")));
		ele3 = driver.findElement(By.xpath("(//button[@class='ql-list'])[5]"));
		ele3.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@value='bullet'])[3]")));
		ele4 = driver.findElement(By.xpath("(//button[@value='bullet'])[3]"));
		ele4.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//span[contains(@class,'ql-align ql-picker')])[3]")));
		ele5 = driver.findElement(By.xpath("(//span[contains(@class,'ql-align ql-picker')])[3]"));
		ele5.click();
		Thread.sleep(2000);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-bold'])[3]")));
		ele6 = driver.findElement(By.xpath("(//button[@class='ql-bold'])[3]"));
		ele6.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-italic'])[3]")));
		ele7 = driver.findElement(By.xpath("(//button[@class='ql-italic'])[3]"));
		ele7.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-underline'])[3]")));
		ele8 = driver.findElement(By.xpath("(//button[@class='ql-underline'])[3]"));
		ele8.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-strike'])[3]")));
		ele9 = driver.findElement(By.xpath("(//button[@class='ql-strike'])[3]"));
		ele9.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-clean'])[3]")));
		WebElement ele10 = driver.findElement(By.xpath("(//button[@class='ql-clean'])[3]"));
		ele10.click();
	}

	@Then("Enter {string} details in Explanation text box")
	public void enter_details_in_explanation_text_box(String Explanation) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Step 1: Locate the TinyMCE iframe for Explanation
		WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("(//iframe[contains(@id,'_ifr') or contains(@class,'tox-edit-area__iframe')])[3]")));

		// Step 2: Switch to that iframe
		driver.switchTo().frame(iframe);

		// Step 3: Inside iframe → locate <body> (actual editor area)
		WebElement body = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body")));
		body.clear(); // Optional: clears existing text
		body.sendKeys(Explanation);

		// Step 4: Switch back to main DOM
		driver.switchTo().defaultContent();
	}

	@Then("Check entered answers details {string} is displayed or not in the Explanation text box")
	public void check_entered_answers_details_is_displayed_or_not_in_the_explanation_text_box(String string)
			throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='tox-edit-area'])[3]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='tox-edit-area'])[3]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		assertTrue(ele1.isDisplayed(), "❌ Entered Explanation is not displayed!");
		System.out.println("✅ Entered Explanation is displayed");
	}

	@Then("Perform and check all features in the Explanation text box")
	public void perform_and_check_all_features_in_the_explanation_text_box() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-header'])[3]")));
		ele1 = driver.findElement(By.xpath("(//button[@class='ql-header'])[3]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-header'])[4]")));
		ele2 = driver.findElement(By.xpath("(//button[@class='ql-header'])[4]"));
		ele2.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-list'])[3]")));
		ele3 = driver.findElement(By.xpath("(//button[@class='ql-list'])[3]"));
		ele3.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@value='bullet'])[3]")));
		ele4 = driver.findElement(By.xpath("(//button[@value='bullet'])[2]"));
		ele4.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//span[contains(@class,'ql-align ql-picker')])[3]")));
		ele5 = driver.findElement(By.xpath("(//span[contains(@class,'ql-align ql-picker')])[3]"));
		ele5.click();
		Thread.sleep(2000);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-bold'])[3]")));
		ele6 = driver.findElement(By.xpath("(//button[@class='ql-bold'])[3]"));
		ele6.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-italic'])[3]")));
		ele7 = driver.findElement(By.xpath("(//button[@class='ql-italic'])[3]"));
		ele7.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-underline'])[3]")));
		ele8 = driver.findElement(By.xpath("(//button[@class='ql-underline'])[3]"));
		ele8.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-strike'])[3]")));
		ele9 = driver.findElement(By.xpath("(//button[@class='ql-strike'])[3]"));
		ele9.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-clean'])[3]")));
		WebElement ele10 = driver.findElement(By.xpath("(//button[@class='ql-clean'])[3]"));
		ele10.click();
	}

	@Then("Enter alpha characters in points for answer field")
	public void enter_alpha_characters_in_points_for_answer_field() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("score")));
		ele1 = driver.findElement(By.id("score"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(1000);
		ele1.sendKeys("abc!@#");
	}

	@Then("Check tab is empty of not in points for answer field")
	public void check_tab_is_empty_of_not_in_points_for_answer_field() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("score")));
		ele1 = driver.findElement(By.id("score"));
		String tabText = ele1.getDomProperty("value");
		boolean tabValue = tabText.isEmpty();
		Assert.assertTrue("Tab accept alpha and special characters", tabValue);
	}

	@Then("Enter special characters in points for answer field")
	public void enter_special_characters_in_points_for_answer_field() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("score")));
		ele1 = driver.findElement(By.id("score"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(1000);
		ele1.sendKeys("ABC!@#");
	}

	@Then("Enter alpha characters in Time field")
	public void enter_alpha_characters_in_time_field() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("time")));
		ele1 = driver.findElement(By.id("time"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(1000);
		ele1.sendKeys("abc!@#");
	}

	@Then("Check tab is empty of not in Time field")
	public void check_tab_is_empty_of_not_in_time_field() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("time")));
		ele1 = driver.findElement(By.id("time"));
		String tabText = ele1.getDomProperty("value");
		boolean tabValue = tabText.isEmpty();
		Assert.assertTrue("Tab accept alpha and special characters", tabValue);
	}

	@Then("Enter special characters in Time field")
	public void enter_special_characters_in_time_field() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("time")));
		ele1 = driver.findElement(By.id("time"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.sendKeys("ABC!@#");
	}

	@Then("Select valid option in question level")
	public void select_valid_option_in_question_level() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[@class='react-select__value-container react-select__value-container--has-value css-1hwfws3'])[4]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[@class='react-select__value-container react-select__value-container--has-value css-1hwfws3'])[4]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Easy']"));
		ele2.click();
	}

	@Then("Select valid option in question status")
	public void select_valid_option_in_question_status() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[@class='react-select__value-container react-select__value-container--has-value css-1hwfws3'])[5]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[@class='react-select__value-container react-select__value-container--has-value css-1hwfws3'])[5]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Active']"));
		ele2.click();
	}

	@Then("Upload valid image file")
	public void upload_valid_image_file() throws InterruptedException, AWTException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("imgref")));
		ele1 = driver.findElement(By.id("imgref"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
		// Upload the file
		Thread.sleep(2000);
		String filepath = System.getProperty("user.dir") + "\\Files\\Sample.png";
		Robot robot = new Robot();
		StringSelection selection = new StringSelection(filepath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		driver.switchTo().defaultContent();
	}

	@Then("Upload valid audio file")
	public void upload_valid_audio_file() throws InterruptedException, AWTException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("audref")));
		ele1 = driver.findElement(By.id("audref"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
		// Upload the file
		Thread.sleep(2000);
		String filepath = System.getProperty("user.dir") + "\\Files\\Audio File.mp3";
		Robot robot = new Robot();
		StringSelection selection = new StringSelection(filepath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		driver.switchTo().defaultContent();
	}

	@Then("Upload valid video file")
	public void upload_valid_video_file() throws InterruptedException, AWTException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("vidref")));
		ele1 = driver.findElement(By.id("vidref"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
		// Upload the file
		Thread.sleep(2000);
		String filepath = System.getProperty("user.dir") + "\\Files\\Video File.mp4";
		Robot robot = new Robot();
		StringSelection selection = new StringSelection(filepath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		driver.switchTo().defaultContent();
	}

	@Then("Enter {string} details in question text box for essay type")
	public void enter_details_in_question_text_box_for_essay_type(String Questions) throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='jodit-wysiwyg'])[1]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='jodit-wysiwyg'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.sendKeys(Questions);
	}

	@Then("Enter {string} details in answers text box for essay type")
	public void enter_details_in_answers_text_box_for_essay_type(String Answers) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='jodit-wysiwyg'])[2]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='jodit-wysiwyg'])[2]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.sendKeys(Answers);
	}

	@Then("Enter {string} details in Explanation text box for essay type")
	public void enter_details_in_explanation_text_box_for_essay_type(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

	@Then("Enter {string} details in remarks text box for essay type")
	public void enter_details_in_remarks_text_box_for_essay_type(String Remarks) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='ql-editor ql-blank'])[1]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.sendKeys(Remarks);
	}

	@Then("Enter {string} points in add questions")
	public void enter_points_for_answer_for_essay_type(String points) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("score")));
		ele1 = driver.findElement(By.id("score"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.clear();
		Thread.sleep(2000);
		ele1.sendKeys(points);
	}

	@Then("Enter {string} time in add questions")
	public void enter_time_for_essay_type(String time) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("time")));
		ele1 = driver.findElement(By.id("time"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.clear();
		Thread.sleep(2000);
		ele1.sendKeys(time);
	}

	@Then("Click clear button for essay type")
	public void click_clear_button_for_essay_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(.,'Clear')]")));
		ele1 = driver.findElement(By.xpath("//button[contains(.,'Clear')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}

	@Then("Check tab is cleared or not for essay type")
	public void check_tab_is_cleared_or_not_for_essay_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[1]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		String actualtext = ele1.getText();
		System.out.println("⚠️ Actual text is: " + actualtext);
		String expectedText = "Please Select";
		Assert.assertEquals("Clear button is not working", actualtext, expectedText);
	}

	@Then("Click save button for essay type")
	public void click_save_button_for_essay_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnSave")));
		ele1 = driver.findElement(By.id("btnSave"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}

	@Then("Check success message is displayed or not for essay type")
	public void check_success_message_is_displayed_or_not_for_essay_type() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actualMessage = ele1.getText();
		System.out.println("✅ Success message displayed like: " + actualMessage);
		String expMessage = "Question & Answer saved successfully!";
		Assert.assertEquals("Save button is not working", actualMessage, expMessage);
	}

	@Then("Enter {string} question details for fill in the blanks type")
	public void enter_question_details_for_fill_in_the_blanks_type(String question) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Wait for the iframe to be present
		WebElement iframeElement = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='tox-edit-area'])[1]//iframe")));

		// Scroll iframe into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", iframeElement);
		Thread.sleep(1000);

		// Switch to the iframe
		driver.switchTo().frame(iframeElement);

		// Now target the body inside TinyMCE
		WebElement textBody = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tinymce")));

		// Clear and enter the question
		textBody.clear();
		textBody.sendKeys(question);

		// Switch back to the main document
		driver.switchTo().defaultContent();
	}

	@Then("Enter {string} answer details for fill in the blanks type")
	public void enter_answer_details_for_fill_in_the_blanks_type(String answer) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Wait for input to be visible & enabled
		WebElement answerBox = wait.until(ExpectedConditions.elementToBeClickable(By.id("fillBlank")));

		// Scroll into view if needed
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", answerBox);
		Thread.sleep(500);

		// Clear any existing text and type
		answerBox.clear();
		answerBox.sendKeys(answer);

	}

	@Then("Enter {string} explanation details for fill in the blanks type")
	public void enter_explanation_details_for_fill_in_the_blanks_type(String explanation) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Step 1: Locate the TinyMCE iframe for Explanation
		WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("(//iframe[contains(@id,'_ifr') or contains(@class,'tox-edit-area__iframe')])[2]")));

		// Step 2: Switch to that iframe
		driver.switchTo().frame(iframe);

		// Step 3: Inside iframe → locate <body> (actual editor area)
		WebElement body = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body")));
		body.clear(); // Optional: clears existing text
		body.sendKeys(explanation);

		// Step 4: Switch back to main DOM
		driver.switchTo().defaultContent();
	}

	@Then("Enter {string} remarks details for fill in the blanks type")
	public void enter_remarks_details_for_fill_in_the_blanks_type(String remarks) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Step 1: Wait for the TinyMCE iframe
		WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("(//iframe[contains(@id,'_ifr') or contains(@class,'tox-edit-area__iframe')])[3]")));

		// Step 2: Switch to the iframe
		driver.switchTo().frame(iframe);

		// Step 3: Find the body of the editor and type
		WebElement body = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body")));
		body.clear(); // optional if old text exists
		body.sendKeys(remarks);

		// Step 4: Switch back to the main page
		driver.switchTo().defaultContent();
	}

	@Then("Enter valid points for answer for fill in the blanks type")
	public void enter_valid_points_for_answer_for_fill_in_the_blanks_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("score")));
		ele1 = driver.findElement(By.id("score"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
		Thread.sleep(2000);
		ele1.clear();
		Thread.sleep(2000);
		ele1.sendKeys("2");
	}

	@Then("Enter valid time for fill in the blanks type")
	public void enter_valid_time_for_fill_in_the_blanks_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("time")));
		ele1 = driver.findElement(By.id("time"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.clear();
		Thread.sleep(2000);
		ele1.sendKeys("2");
	}

	@Then("Click clear button for fill in the blanks type")
	public void click_clear_button_for_fill_in_the_blanks_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(.,'Clear')]")));
		ele1 = driver.findElement(By.xpath("//button[contains(.,'Clear')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}

	@Then("Check tab is cleared or not for fill in the blanks type")
	public void check_tab_is_cleared_or_not_for_fill_in_the_blanks_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[1]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		String actualtext = ele1.getText();
		System.out.println("⚠️ Actual text is: " + actualtext);
		String expectedText = "Please Select";
		Assert.assertEquals("Clear button is not working", actualtext, expectedText);
	}

	@Then("Click save button for fill in the blanks type")
	public void click_save_button_for_fill_in_the_blanks_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnSave")));
		ele1 = driver.findElement(By.id("btnSave"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}

	@Then("Check success message is displayed or not for fill in the blanks type")
	public void check_success_message_is_displayed_or_not_for_fill_in_the_blanks_type() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actualMessage = ele1.getText();
		System.out.println("✅ Success message displayed like: " + actualMessage);
		String expMessage = "Question & Answer saved successfully!";
		Assert.assertEquals("Save button is not working", actualMessage, expMessage);
	}

	@Then("Enter {string} question details for Multiple Choice type")
	public void enter_question_details_for_multiple_choice_type(String questions) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Wait for the iframe to be present
		WebElement iframeElement = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='tox-edit-area'])[1]//iframe")));

		// Scroll iframe into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", iframeElement);
		Thread.sleep(1000);

		// Switch to the iframe
		driver.switchTo().frame(iframeElement);

		// Now target the body inside TinyMCE
		WebElement textBody = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tinymce")));

		// Clear and enter the question
		textBody.clear();
		textBody.sendKeys(questions);

		// Switch back to the main document
		driver.switchTo().defaultContent();
	}

	@Then("Enter {string} first answer details for Multiple Choice type")
	public void enter_first_answer_details_for_multiple_choice_type(String Option) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Wait for the iframe to be present
		WebElement iframeElement = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='tox-edit-area'])[2]//iframe")));

		// Scroll iframe into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", iframeElement);
		Thread.sleep(1000);

		// Switch to the iframe
		driver.switchTo().frame(iframeElement);

		// Now target the body inside TinyMCE
		WebElement textBody = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tinymce")));

		// Clear and enter the question
		textBody.clear();
		textBody.sendKeys(Option);

		// Switch back to the main document
		driver.switchTo().defaultContent();
	}

	@Then("Enter {string} second answer details for Multiple Choice type")
	public void enter_second_answer_details_for_multiple_choice_type(String Option) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Wait for the iframe to be present
		WebElement iframeElement = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='tox-edit-area'])[3]//iframe")));

		// Scroll iframe into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", iframeElement);
		Thread.sleep(1000);

		// Switch to the iframe
		driver.switchTo().frame(iframeElement);

		// Now target the body inside TinyMCE
		WebElement textBody = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tinymce")));

		// Clear and enter the question
		textBody.clear();
		textBody.sendKeys(Option);

		// Switch back to the main document
		driver.switchTo().defaultContent();
	}

	@Then("Enter {string} third answer details for Multiple Choice type")
	public void enter_third_answer_details_for_multiple_choice_type(String Option) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Wait for the iframe to be present
		WebElement iframeElement = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='tox-edit-area'])[4]//iframe")));

		// Scroll iframe into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", iframeElement);
		Thread.sleep(1000);

		// Switch to the iframe
		driver.switchTo().frame(iframeElement);

		// Now target the body inside TinyMCE
		WebElement textBody = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tinymce")));

		// Clear and enter the question
		textBody.clear();
		textBody.sendKeys(Option);

		// Switch back to the main document
		driver.switchTo().defaultContent();
	}

	@Then("Select checkbox no {string} in answers field for Multiple Choice type")
	public void select_checkbox_no_in_answers_field_for_multiple_choice_type(String number)
			throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("chk" + number + "")));
		ele1 = driver.findElement(By.id("chk1"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		if (ele1.isSelected()) {
			ele1.click();
		}
		Thread.sleep(2000);
		ele2 = driver.findElement(By.id("chk" + number + ""));
		ele2.click();
	}

	@Then("Enter {string} explanation details for Multiple Choice type")
	public void enter_explanation_details_for_multiple_choice_type(String explanation) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Wait for the iframe to be present
		WebElement iframeElement = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='tox-edit-area'])[5]//iframe")));

		// Scroll iframe into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", iframeElement);
		Thread.sleep(1000);

		// Switch to the iframe
		driver.switchTo().frame(iframeElement);

		// Now target the body inside TinyMCE
		WebElement textBody = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tinymce")));

		// Clear and enter the question
		textBody.clear();
		textBody.sendKeys(explanation);

		// Switch back to the main document
		driver.switchTo().defaultContent();
	}

	@Then("Enter {string} remarks details for Multiple Choice type")
	public void enter_remarks_details_for_multiple_choice_type(String remarks) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Wait for the iframe to be present
		WebElement iframeElement = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='tox-edit-area'])[6]//iframe")));

		// Scroll iframe into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", iframeElement);
		Thread.sleep(1000);

		// Switch to the iframe
		driver.switchTo().frame(iframeElement);

		// Now target the body inside TinyMCE
		WebElement textBody = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tinymce")));

		// Clear and enter the question
		textBody.clear();
		textBody.sendKeys(remarks);

		// Switch back to the main document
		driver.switchTo().defaultContent();
	}

	@Then("Enter valid points for answer for Multiple Choice type")
	public void enter_valid_points_for_answer_for_multiple_choice_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("score")));
		ele1 = driver.findElement(By.id("score"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.clear();
		Thread.sleep(2000);
		ele1.sendKeys("2");
	}

	@Then("Enter valid time for Multiple Choice type")
	public void enter_valid_time_for_multiple_choice_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("time")));
		ele1 = driver.findElement(By.id("time"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.clear();
		Thread.sleep(2000);
		ele1.sendKeys("4");
	}

	@Then("Click clear button for Multiple Choice type")
	public void click_clear_button_for_multiple_choice_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(.,'Clear')]")));
		ele1 = driver.findElement(By.xpath("//button[contains(.,'Clear')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}

	@Then("Check tab is cleared or not for Multiple Choice type")
	public void check_tab_is_cleared_or_not_for_multiple_choice_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[1]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		String actualtext = ele1.getText();
		System.out.println("⚠️ Actual text is: " + actualtext);
		String expectedText = "Please Select";
		Assert.assertEquals("Clear button is not working", actualtext, expectedText);
	}

	@Then("Click save button for Multiple Choice type")
	public void click_save_button_for_multiple_choice_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnSave")));
		ele1 = driver.findElement(By.id("btnSave"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}

	@Then("Check success message is displayed or not for Multiple Choice type")
	public void check_success_message_is_displayed_or_not_for_multiple_choice_type() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actualMessage = ele1.getText();
		System.out.println("✅ Success message displayed like: " + actualMessage);
		String expMessage = "Question & Answer saved successfully!";
		Assert.assertEquals("Save button is not working", actualMessage, expMessage);
	}

	@Then("Enter {string} question details for Short Answer type")
	public void enter_question_details_for_short_answer_type(String questions) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Wait for the iframe to be present
		WebElement iframeElement = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='tox-edit-area'])[1]//iframe")));

		// Scroll iframe into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", iframeElement);
		Thread.sleep(1000);

		// Switch to the iframe
		driver.switchTo().frame(iframeElement);

		// Now target the body inside TinyMCE
		WebElement textBody = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tinymce")));

		// Clear and enter the question
		textBody.clear();
		textBody.sendKeys(questions);

		// Switch back to the main document
		driver.switchTo().defaultContent();
	}

	@Then("Enter {string} answer details for Short Answer type")
	public void enter_answer_details_for_short_answer_type(String answers) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Wait for the iframe to be present
		WebElement iframeElement = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("(//textarea[@class='form-control'])[1]")));

		// Scroll iframe into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", iframeElement);
		Thread.sleep(1000);

		iframeElement.sendKeys(answers);

	}

	@Then("Enter {string} explanation details for Short Answer type")
	public void enter_explanation_details_for_short_answer_type(String explanation) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Wait for the iframe to be present
		WebElement iframeElement = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='tox-edit-area'])[2]//iframe")));

		// Scroll iframe into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", iframeElement);
		Thread.sleep(1000);

		// Switch to the iframe
		driver.switchTo().frame(iframeElement);

		// Now target the body inside TinyMCE
		WebElement textBody = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tinymce")));

		// Clear and enter the question
		textBody.clear();
		textBody.sendKeys(explanation);

		// Switch back to the main document
		driver.switchTo().defaultContent();
	}

	@Then("Enter {string} remarks details for Short Answer type")
	public void enter_remarks_details_for_short_answer_type(String remarks) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Wait for the iframe to be present
		WebElement iframeElement = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='tox-edit-area'])[3]//iframe")));

		// Scroll iframe into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", iframeElement);
		Thread.sleep(1000);

		// Switch to the iframe
		driver.switchTo().frame(iframeElement);

		// Now target the body inside TinyMCE
		WebElement textBody = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("tinymce")));

		// Clear and enter the question
		textBody.clear();
		textBody.sendKeys(remarks);

		// Switch back to the main document
		driver.switchTo().defaultContent();
	}

	@Then("Enter valid points for answer for Short Answer type")
	public void enter_valid_points_for_answer_for_short_answer_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("score")));
		ele1 = driver.findElement(By.id("score"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.clear();
		Thread.sleep(2000);
		ele1.sendKeys("2");
	}

	@Then("Enter valid time for Short Answer type")
	public void enter_valid_time_for_short_answer_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("time")));
		ele1 = driver.findElement(By.id("time"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.clear();
		Thread.sleep(2000);
		ele1.sendKeys("4");
	}

	@Then("Click clear button for Short Answer type")
	public void click_clear_button_for_short_answer_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(.,'Clear')]")));
		ele1 = driver.findElement(By.xpath("//button[contains(.,'Clear')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}

	@Then("Check tab is cleared or not for Short Answer type")
	public void check_tab_is_cleared_or_not_for_short_answer_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[1]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		String actualtext = ele1.getText();
		System.out.println("⚠️ Actual text is: " + actualtext);
		String expectedText = "Please Select";
		Assert.assertEquals("Clear button is not working", actualtext, expectedText);
	}

	@Then("Click save button for Short Answer type")
	public void click_save_button_for_short_answer_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnSave")));
		ele1 = driver.findElement(By.id("btnSave"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}

	@Then("Check success message is displayed or not for Short Answer type")
	public void check_success_message_is_displayed_or_not_for_short_answer_type() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actualMessage = ele1.getText();
		System.out.println("✅ Success message displayed like: " + actualMessage);
		String expMessage = "Question & Answer saved successfully!";
		Assert.assertEquals("Save button is not working", actualMessage, expMessage);
	}

	@Then("Enter {string} question details for Single Choice type")
	public void enter_question_details_for_single_choice_type(String questions) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Step 1: Wait for the TinyMCE iframe
		WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("(//iframe[contains(@id,'_ifr') or contains(@class,'tox-edit-area__iframe')])[1]")));

		// Step 2: Switch to the iframe
		driver.switchTo().frame(iframe);

		// Step 3: Find the body of the editor and type
		WebElement body = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body")));
		body.clear(); // optional if old text exists
		body.sendKeys(questions);

		// Step 4: Switch back to the main page
		driver.switchTo().defaultContent();
	}

	@Then("Enter {string} first answer details for Single Choice type")
	public void enter_first_answer_details_for_single_choice_type(String option) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Step 1: Wait for the TinyMCE iframe
		WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("(//iframe[contains(@id,'_ifr') or contains(@class,'tox-edit-area__iframe')])[2]")));

		// Step 2: Switch to the iframe
		driver.switchTo().frame(iframe);

		// Step 3: Find the body of the editor and type
		WebElement body = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body")));
		body.clear(); // optional if old text exists
		body.sendKeys(option);

		// Step 4: Switch back to the main page
		driver.switchTo().defaultContent();
	}

	@Then("Enter {string} second answer details for Single Choice type")
	public void enter_second_answer_details_for_single_choice_type(String option) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Step 1: Wait for the TinyMCE iframe
		WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("(//iframe[contains(@id,'_ifr') or contains(@class,'tox-edit-area__iframe')])[3]")));

		// Step 2: Switch to the iframe
		driver.switchTo().frame(iframe);

		// Step 3: Find the body of the editor and type
		WebElement body = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body")));
		body.clear(); // optional if old text exists
		body.sendKeys(option);

		// Step 4: Switch back to the main page
		driver.switchTo().defaultContent();
	}

	@Then("Enter {string} third answer details for Single Choice type")
	public void enter_third_answer_details_for_single_choice_type(String option) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Step 1: Wait for the TinyMCE iframe
		WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("(//iframe[contains(@id,'_ifr') or contains(@class,'tox-edit-area__iframe')])[4]")));

		// Step 2: Switch to the iframe
		driver.switchTo().frame(iframe);

		// Step 3: Find the body of the editor and type
		WebElement body = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body")));
		body.clear(); // optional if old text exists
		body.sendKeys(option);

		// Step 4: Switch back to the main page
		driver.switchTo().defaultContent();
	}

	@Then("Select radio button {string} in answers field for Single Choice type")
	public void select_radio_button_in_answers_field_for_single_choice_type(String radioBtn)
			throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("rdo" + radioBtn + "")));
		ele1 = driver.findElement(By.id("rdo" + radioBtn + ""));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}

	@Then("Enter {string} explanation details for Single Choice type")
	public void enter_explanation_details_for_single_choice_type(String explanation) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Step 1: Wait for the TinyMCE iframe
		WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("(//iframe[contains(@id,'_ifr') or contains(@class,'tox-edit-area__iframe')])[5]")));

		// Step 2: Switch to the iframe
		driver.switchTo().frame(iframe);

		// Step 3: Find the body of the editor and type
		WebElement body = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body")));
		body.clear(); // optional if old text exists
		body.sendKeys(explanation);

		// Step 4: Switch back to the main page
		driver.switchTo().defaultContent();
	}

	@Then("Enter {string} remarks details for Single Choice type")
	public void enter_remarks_details_for_single_choice_type(String remarks) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Step 1: Wait for the TinyMCE iframe
		WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("(//iframe[contains(@id,'_ifr') or contains(@class,'tox-edit-area__iframe')])[6]")));

		// Step 2: Switch to the iframe
		driver.switchTo().frame(iframe);

		// Step 3: Find the body of the editor and type
		WebElement body = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body")));
		body.clear(); // optional if old text exists
		body.sendKeys(remarks);

		// Step 4: Switch back to the main page
		driver.switchTo().defaultContent();
	}

	@Then("Enter valid points for answer for Single Choice type")
	public void enter_valid_points_for_answer_for_single_choice_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("score")));
		ele1 = driver.findElement(By.id("score"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.clear();
		Thread.sleep(2000);
		ele1.sendKeys("2");
	}

	@Then("Enter valid time for Single Choice type")
	public void enter_valid_time_for_single_choice_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("time")));
		ele1 = driver.findElement(By.id("time"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.clear();
		Thread.sleep(2000);
		ele1.sendKeys("2");
	}

	@Then("Click clear button for Single Choice type")
	public void click_clear_button_for_single_choice_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(.,'Clear')]")));
		ele1 = driver.findElement(By.xpath("//button[contains(.,'Clear')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}

	@Then("Check tab is cleared or not for Single Choice type")
	public void check_tab_is_cleared_or_not_for_single_choice_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[1]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		String actualtext = ele1.getText();
		System.out.println("⚠️ Actual text is: " + actualtext);
		String expectedText = "Please Select";
		Assert.assertEquals("Clear button is not working", actualtext, expectedText);
	}

	@Then("Click save button for Single Choice type")
	public void click_save_button_for_single_choice_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnSave")));
		ele1 = driver.findElement(By.id("btnSave"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}

	@Then("Check success message is displayed or not for Single Choice type")
	public void check_success_message_is_displayed_or_not_for_single_choice_type() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actualMessage = ele1.getText();
		System.out.println("✅ Success message displayed like: " + actualMessage);
		String expMessage = "Question & Answer saved successfully!";
		Assert.assertEquals("Save button is not working", actualMessage, expMessage);
	}

	@Then("Enter {string} question details for True or False type")
	public void enter_question_details_for_true_or_false_type(String questions) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Step 1: Wait for the TinyMCE iframe
		WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("(//iframe[contains(@id,'_ifr') or contains(@class,'tox-edit-area__iframe')])[1]")));

		// Step 2: Switch to the iframe
		driver.switchTo().frame(iframe);

		// Step 3: Find the body of the editor and type
		WebElement body = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body")));
		body.clear(); // optional if old text exists
		body.sendKeys(questions);

		// Step 4: Switch back to the main page
		driver.switchTo().defaultContent();
	}

	@Then("Enter valid answer details for True or False type")
	public void enter_valid_answer_details_for_true_false_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='ql-editor ql-blank'])[1]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.sendKeys("True");
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[1]"));
		ele2.sendKeys("False");
	}

	@Then("Select True radio in answers field for True or False type")
	public void select_true_radio_in_answers_field_for_true_or_false_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("rdo6")));
		ele1 = driver.findElement(By.id("rdo6"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}

	@Then("Select False radio in answers field for True or False type")
	public void select_false_radio_in_answers_field_for_true_or_false_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("rdo7")));
		ele1 = driver.findElement(By.id("rdo7"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}

	@Then("Enter {string} explanation details for True or False type")
	public void enter_explanation_details_for_true_or_false_type(String explanation) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Step 1: Wait for the TinyMCE iframe
		WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("(//iframe[contains(@id,'_ifr') or contains(@class,'tox-edit-area__iframe')])[4]")));

		// Step 2: Switch to the iframe
		driver.switchTo().frame(iframe);

		// Step 3: Find the body of the editor and type
		WebElement body = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body")));
		body.clear(); // optional if old text exists
		body.sendKeys(explanation);

		// Step 4: Switch back to the main page
		driver.switchTo().defaultContent();
	}

	@Then("Enter {string} remarks details for True or False type")
	public void enter_remarks_details_for_true_or_false_type(String remarks) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Step 1: Wait for the TinyMCE iframe
		WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("(//iframe[contains(@id,'_ifr') or contains(@class,'tox-edit-area__iframe')])[5]")));

		// Step 2: Switch to the iframe
		driver.switchTo().frame(iframe);

		// Step 3: Find the body of the editor and type
		WebElement body = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body")));
		body.clear(); // optional if old text exists
		body.sendKeys(remarks);

		// Step 4: Switch back to the main page
		driver.switchTo().defaultContent();
	}

	@Then("Enter {string} question details for Match The Following type")
	public void enter_question_details_for_match_the_following_type(String question) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Step 1: Wait for the TinyMCE iframe
		WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("(//iframe[contains(@id,'_ifr') or contains(@class,'tox-edit-area__iframe')])[1]")));

		// Step 2: Switch to the iframe
		driver.switchTo().frame(iframe);

		// Step 3: Find the body of the editor and type
		WebElement body = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body")));
		body.clear(); // optional if old text exists
		body.sendKeys(question);

		// Step 4: Switch back to the main page
		driver.switchTo().defaultContent();
	}

	@Then("Enter {string} in first coloumn-A for Match The Following type")
	public void enter_in_first_coloumn_a_for_match_the_following_type(String option) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@class='form-control'])[1]")));
		ele1 = driver.findElement(By.xpath("(//input[@class='form-control'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.clear();
		Thread.sleep(2000);
		ele1.sendKeys(option);
	}

	@Then("Enter {string} in first coloumn-B for Match The Following type")
	public void enter_in_first_coloumn_b_for_match_the_following_type(String option) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@class='form-control'])[1]")));
		ele1 = driver.findElement(By.xpath("(//input[@class='form-control'])[2]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.clear();
		Thread.sleep(2000);
		ele1.sendKeys(option);
	}

	@Then("Enter {string} in second coloumn-A for Match The Following type")
	public void enter_in_second_coloumn_a_for_match_the_following_type(String option) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@class='form-control'])[3]")));
		ele1 = driver.findElement(By.xpath("(//input[@class='form-control'])[3]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.clear();
		Thread.sleep(2000);
		ele1.sendKeys(option);
	}

	@Then("Enter {string} in second coloumn-B for Match The Following type")
	public void enter_in_second_coloumn_b_for_match_the_following_type(String option) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@class='form-control'])[4]")));
		ele1 = driver.findElement(By.xpath("(//input[@class='form-control'])[4]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.clear();
		Thread.sleep(2000);
		ele1.sendKeys(option);
	}

	@Then("Enter {string} in third coloumn-A for Match The Following type")
	public void enter_in_third_coloumn_a_for_match_the_following_type(String option) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@class='form-control'])[5]")));
		ele1 = driver.findElement(By.xpath("(//input[@class='form-control'])[5]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.clear();
		Thread.sleep(2000);
		ele1.sendKeys(option);
	}

	@Then("Enter {string} in third coloumn-B for Match The Following type")
	public void enter_in_third_coloumn_b_for_match_the_following_type(String option) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@class='form-control'])[6]")));
		ele1 = driver.findElement(By.xpath("(//input[@class='form-control'])[6]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.clear();
		Thread.sleep(2000);
		ele1.sendKeys(option);
	}

	@Then("Enter {string} in fourth coloumn-A for Match The Following type")
	public void enter_in_fourth_coloumn_a_for_match_the_following_type(String option) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@class='form-control'])[7]")));
		ele1 = driver.findElement(By.xpath("(//input[@class='form-control'])[7]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.clear();
		Thread.sleep(2000);
		ele1.sendKeys(option);
	}

	@Then("Enter {string} in fourth coloumn-B for Match The Following type")
	public void enter_in_fourth_coloumn_b_for_match_the_following_type(String option) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@class='form-control'])[8]")));
		ele1 = driver.findElement(By.xpath("(//input[@class='form-control'])[8]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.clear();
		Thread.sleep(2000);
		ele1.sendKeys(option);
	}

	@Then("Click add options button in answers tab")
	public void click_add_options_button_in_answers_tab() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		WebElement ele1 = wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//div[contains(@class,'mb-4 text-center')]//button[1]")));

		// Scroll into center
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", ele1);

		// Ensure clickable
		wait.until(ExpectedConditions.elementToBeClickable(ele1)).click();
	}

	@Then("Enter {string} explanation details for Match The Following type")
	public void enter_explanation_details_for_match_the_following_type(String explanation) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Step 1: Wait for the TinyMCE iframe
		WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("(//iframe[contains(@id,'_ifr') or contains(@class,'tox-edit-area__iframe')])[2]")));

		// Step 2: Switch to the iframe
		driver.switchTo().frame(iframe);

		// Step 3: Find the body of the editor and type
		WebElement body = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body")));
		body.clear(); // optional if old text exists
		body.sendKeys(explanation);

		// Step 4: Switch back to the main page
		driver.switchTo().defaultContent();
	}

	@Then("Enter {string} remarks details for Match The Following type")
	public void enter_remarks_details_for_match_the_following_type(String remarks) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Step 1: Wait for the TinyMCE iframe
		WebElement iframe = wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("(//iframe[contains(@id,'_ifr') or contains(@class,'tox-edit-area__iframe')])[3]")));

		// Step 2: Switch to the iframe
		driver.switchTo().frame(iframe);

		// Step 3: Find the body of the editor and type
		WebElement body = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body")));
		body.clear(); // optional if old text exists
		body.sendKeys(remarks);

		// Step 4: Switch back to the main page
		driver.switchTo().defaultContent();
	}

	@Then("Click clear button for Match The Following type")
	public void click_clear_button_for_match_the_following_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(.,'Clear')]")));
		ele1 = driver.findElement(By.xpath("//button[contains(.,'Clear')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}

	@Then("Check tab is cleared or not for Match The Following type")
	public void check_tab_is_cleared_or_not_for_match_the_following_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[1]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		String actualtext = ele1.getText();
		System.out.println("⚠️ Actual text is: " + actualtext);
		String expectedText = "Please Select";
		Assert.assertEquals("Clear button is not working", actualtext, expectedText);
	}

	@Then("Click save button for Match The Following type")
	public void click_save_button_for_match_the_following_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnSave")));
		ele1 = driver.findElement(By.id("btnSave"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}

	@Then("Check success message is displayed or not for Match The Following type")
	public void check_success_message_is_displayed_or_not_for_match_the_following_type() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actualMessage = ele1.getText();
		System.out.println("✅ Success message displayed like: " + actualMessage);
		String expMessage = "Question & Answer saved successfully!";
		Assert.assertEquals("Save button is not working", actualMessage, expMessage);
	}

	@Then("Enter valid points for answer for True or False type")
	public void enter_valid_points_for_answer_for_true_false_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("score")));
		ele1 = driver.findElement(By.id("score"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.clear();
		Thread.sleep(2000);
		ele1.sendKeys("2");
	}

	@Then("Enter valid time for True or False type")
	public void enter_valid_time_for_true_false_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("time")));
		ele1 = driver.findElement(By.id("time"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.clear();
		Thread.sleep(2000);
		ele1.sendKeys("2");
	}

	@Then("Click clear button for True or False type")
	public void click_clear_button_for_true_false_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(.,'Clear')]")));
		ele1 = driver.findElement(By.xpath("//button[contains(.,'Clear')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}

	@Then("Check tab is cleared or not for True or False type")
	public void check_tab_is_cleared_or_not_for_true_false_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[1]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		String actualtext = ele1.getText();
		System.out.println("⚠️ Actual text is: " + actualtext);
		String expectedText = "Please Select";
		Assert.assertEquals("Clear button is not working", actualtext, expectedText);
	}

	@Then("Click save button for True or False type")
	public void click_save_button_for_true_or_false_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnSave")));
		ele1 = driver.findElement(By.id("btnSave"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}

	@Then("Check success message is displayed or not for True or False type")
	public void check_success_message_is_displayed_or_not_for_true_or_false_type() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actualMessage = ele1.getText();
		System.out.println("✅ Success message displayed like: " + actualMessage);
		String expMessage = "Question & Answer saved successfully!";
		Assert.assertEquals("Save button is not working", actualMessage, expMessage);
	}

	@Then("Check success message is displayed or not question save in add subject")
	public void check_success_message_is_displayed_or_not_question_save_in_add_subject() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actualMessage = ele1.getText();
		System.out.println("✅ Success message displayed like: " + actualMessage);
		String expMessage = "Question & Answer saved successfully!";
		Assert.assertEquals("Save button is not working", actualMessage, expMessage);
	}

	@Then("Enter valid details in question tab")
	public void enter_valid_details_in_question_tab() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='ql-editor ql-blank'])[1]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
		ele1.sendKeys("Test Questions");
	}

	@Then("Enter valid details in answers tab")
	public void enter_valid_details_in_answers_tab() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='ql-editor ql-blank'])[1]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
		ele1.sendKeys("Test Answers");
	}

	@Then("Enter valid details in remarks tab")
	public void enter_valid_details_in_remarks_tab() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='ql-editor ql-blank'])[1]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
		ele1.sendKeys("Test Remarks");
	}

	@Then("Change the question type in any other type")
	public void change_the_question_type_in_any_other_type() throws InterruptedException {
		Thread.sleep(3000);
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
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Multiple Choice']"));
		ele2.click();
	}

	@Then("Check entered details are cleared or not")
	public void check_entered_details_are_cleared_or_not() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='tox-edit-area'])[1]//iframe")));
		ele1 = driver.findElement(By.xpath("(//div[@class='tox-edit-area'])[1]//iframe"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		String tabvalue = ele1.getText();
		System.out.println("✅ Tab value is: " + tabvalue);
		boolean checktabvalue = tabvalue.trim().isEmpty();
		Assert.assertTrue("Tab is not empty.", checktabvalue);
	}

	public void typeLikeHuman(WebDriver driver, WebElement element, String text) {
		for (char c : text.toCharArray()) {
			String s = String.valueOf(c);
			element.sendKeys(s);

			// Small random delay between keystrokes (optional)
			try {
				Thread.sleep(100 + (int) (Math.random() * 200));
			} catch (InterruptedException e) {
				Thread.currentThread().interrupt();
			}
		}
	}

	@Then("Search {string} question name in search field")
	public void search_question_name_in_search_field(String question) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Step 1: Wait until DOM is fully loaded
		wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
				.equals("complete"));

		// Step 2: Wait until loader disappears (if you have a loader)
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.loaderStyle")));

		// Step 3: Now wait for your search box to be visible & enabled
		WebElement ele1 = wait.until(ExpectedConditions.elementToBeClickable(By.name("txtSearch")));

		// Step 4: Send data safely
		ele1.clear();
		typeLikeHuman(driver, ele1, question);
	}

	@Then("Select All Subject option in status dropdown")
	public void select_all_subject_option_in_status_dropdown() throws InterruptedException {
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[@class='react-select__value-container react-select__value-container--has-value css-1hwfws3'])[1]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[@class='react-select__value-container react-select__value-container--has-value css-1hwfws3'])[1]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='All Subject']"));
		ele2.click();
		Thread.sleep(3000);
	}

	@Then("Select fill in the blanks option in question type")
	public void select_fill_in_the_blanks_option_in_question_type() throws InterruptedException {
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[@class='react-select__value-container react-select__value-container--has-value css-1hwfws3'])[3]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[@class='react-select__value-container react-select__value-container--has-value css-1hwfws3'])[3]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Fill in the Blanks']"));
		ele2.click();
		Thread.sleep(3000);
	}

	@Then("Select Multiple Choice option in question type")
	public void select_multiple_choice_option_in_question_type() throws InterruptedException {
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[@class='react-select__value-container react-select__value-container--has-value css-1hwfws3'])[3]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[@class='react-select__value-container react-select__value-container--has-value css-1hwfws3'])[3]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Multiple Choice']"));
		ele2.click();
		Thread.sleep(3000);
	}

	@Then("Select Short Answer option in question type")
	public void select_short_answer_option_in_question_type() throws InterruptedException {
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[@class='react-select__value-container react-select__value-container--has-value css-1hwfws3'])[3]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[@class='react-select__value-container react-select__value-container--has-value css-1hwfws3'])[3]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Short Answer']"));
		ele2.click();
		Thread.sleep(3000);
	}

	@Then("Select Single Choice option in question type")
	public void select_single_choice_option_in_question_type() throws InterruptedException {
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[@class='react-select__value-container react-select__value-container--has-value css-1hwfws3'])[3]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[@class='react-select__value-container react-select__value-container--has-value css-1hwfws3'])[3]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Single Choice']"));
		ele2.click();
		Thread.sleep(3000);
	}

	@Then("Select True or False option in question type")
	public void select_true_or_false_option_in_question_type() throws InterruptedException {
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[@class='react-select__value-container react-select__value-container--has-value css-1hwfws3'])[3]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[@class='react-select__value-container react-select__value-container--has-value css-1hwfws3'])[3]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='True/False']"));
		ele2.click();
		Thread.sleep(3000);
	}

	@Then("Click edit button in create question page")
	public void click_edit_button_in_create_question_page() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
				.equals("complete"));

		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.loaderStyle")));

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@type='button'])[3]")));
		Thread.sleep(2000);
		ele1 = driver.findElement(By.xpath("(//button[@type='button'])[3]"));
		ele1.click();
	}

	@Then("Click view questions button in edit question page")
	public void click_view_questions_button_in_edit_question_page() {
		// Step 1: Wait for page fully loaded
		wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState")
				.equals("complete"));

		// Step 2: Wait until loader is gone
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.loaderStyle")));

		// Step 3: Safe click (instead of manual steps)
		By buttonLocator = By.xpath("(//button[contains(@class,'btn btn-sm')])[1]");
		safeClick(driver, buttonLocator);

	}

	@Then("Click clear button in edit question page")
	public void click_clear_button_in_edit_question_page() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(.,'Clear')]")));
		ele1 = driver.findElement(By.xpath("//button[contains(.,'Clear')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}

	@Then("Check details are cleared or not in edit question page")
	public void check_details_are_cleared_or_not_in_edit_question_page() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[@class='react-select__value-container react-select__value-container--has-value css-1hwfws3'])[1]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[@class='react-select__value-container react-select__value-container--has-value css-1hwfws3'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		String actualtext = ele1.getText();
		System.out.println("⚠️ Actual text is: " + actualtext);
		String expectedText = "Please Select";
		Assert.assertEquals("Clear button is not working", actualtext, expectedText);
	}

	@Then("Modify valid details in any tab")
	public void modify_valid_details_in_any_tab() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='tox-edit-area'])[1]//iframe")));
		ele1 = driver.findElement(By.xpath("(//div[@class='tox-edit-area'])[1]//iframe"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		String actualDetail = ele1.getText();
		System.out.println("⚠️ Actual text is: " + actualDetail);
		Thread.sleep(2000);
		ele1.clear();
		Thread.sleep(2000);
		ele1.sendKeys(actualDetail);
	}

	@Then("Click update button in edit question page")
	public void click_update_button_in_edit_question_page() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnSave")));
		ele1 = driver.findElement(By.id("btnSave"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}

	@Then("Check success message is displayed or not in edit question page")
	public void check_success_message_is_displayed_or_not_in_edit_question_page() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
			ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
			String actualMessage = ele1.getText();
			System.out.println("✅ Success message displayed like: " + actualMessage);
			String expMessage = "Question & Answer updated successfully!";
			Assert.assertEquals("Save button is not working", actualMessage, expMessage);
		} catch (TimeoutException e) {
			System.out.println("❌ Update button is not working"); // Print the message here
			Assert.fail("Update button is not working");
		}
	}

	@Then("Click Approve button in create question page")
	public void click_approve_button_in_create_question_page() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//label[contains(@class,'btn btn-outline-success')]")));
		ele1 = driver.findElement(By.xpath("//label[contains(@class,'btn btn-outline-success')]"));
		ele1.click();
	}

	@Then("Enter valid approval details in create question page")
	public void enter_valid_approval_details_in_create_question_page() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("aDesc")));
		ele1 = driver.findElement(By.name("aDesc"));
		ele1.sendKeys("Test question approval");
	}

	@When("Click Group question radio button in create question")
	public void click_group_question_radio_button_in_create_question() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@name='qstype'])[2]")));
		ele1 = driver.findElement(By.xpath("(//input[@name='qstype'])[2]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}

	@Then("Check mandatory red border is displayed or not for group question")
	public void check_mandatory_red_border_is_displayed_or_not_for_group_question() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[1]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[1]"));
		ele2 = driver.findElement(By.xpath("//div[@class='react-select__value-container css-1hwfws3']"));
		ele3 = driver.findElement(By.id("divqcount"));

		String borderColor1, borderColor2, borderColor3;
		try {
			borderColor1 = ele1.getCssValue("border-color");
			borderColor2 = ele2.getCssValue("border-color");
			borderColor3 = ele3.getCssValue("border-color");
		} catch (Exception e) {
			borderColor1 = "not available";
			borderColor2 = "not available";
			borderColor3 = "not available";

			System.out.println("❌ Error getting border color: " + e.getMessage());
		}
		String expectedBorderColor = "rgb(78, 78, 78)";
		String expectedBorderColor1 = "rgb(255, 0, 0)";
		System.out.println("⚠️ Actual border color : " + borderColor1);
		System.out.println("⚠️ Actual border color : " + borderColor2);
		System.out.println("⚠️ Actual border color : " + borderColor3);
		if (borderColor1.toLowerCase().equals(expectedBorderColor.toLowerCase())) {
			System.out.println(
					"✅ Tab border color is as expected as RED colour with color code : " + expectedBorderColor);
			System.out.println("✔️ Red border is removed");
		} else {
			System.out.println("❌ Red border is not removed");
		}
		if (borderColor2.toLowerCase().equals(expectedBorderColor.toLowerCase())) {
			System.out.println(
					"✔️ Tab border color is as expected as RED colour with color code : " + expectedBorderColor);
			System.out.println("✔️ Red border is removed");
		} else {
			System.out.println("❌ Red border is not removed");
		}
		if (borderColor3.toLowerCase().equals(expectedBorderColor1.toLowerCase())) {
			System.out.println(
					"✔️ Tab border color is as expected as RED colour with color code : " + expectedBorderColor1);
			System.out.println("✔️ Red border is removed");
		} else {
			System.out.println("❌ Red border is not removed");
		}
		Assert.assertEquals("❌ Red border is not removed in subject tab", borderColor1, expectedBorderColor);
		Assert.assertEquals("❌ Red border is not removed in topic tab", borderColor2, expectedBorderColor);
		Assert.assertEquals("❌ Red border is not removed in question type tab", borderColor3, expectedBorderColor1);
	}

	@Then("Enter {string} question in question count tab")
	public void enter_question_in_question_count_tab(String count) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("qsCount")));
		ele1 = driver.findElement(By.name("qsCount"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(count);
	}

	@Then("Check {string} question tab is displayed or not in group question")
	public void check_tab_is_displayed_or_not_in_group_question(String tabValue) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("qsCount")));
		ele1 = driver.findElement(By.name("qsCount"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		String actTabValue = ele1.getAttribute("value");
		String expTabValue = tabValue;
		Assert.assertEquals("❌ Entered text is not displayed", actTabValue, expTabValue);
	}

	@Then("Click Scenario-Based question radio button in create question")
	public void click_scenario_based_question_radio_button_in_create_question() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@name='qstype'])[3]")));
		ele1 = driver.findElement(By.xpath("(//input[@name='qstype'])[3]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}

	@Then("Check mandatory red border is displayed or not question type")
	public void check_mandatory_red_border_is_displayed_or_not_question_type() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("type0")));
		ele1 = driver.findElement(By.id("type0"));
		String borderColor;
		try {
			borderColor = ele1.getCssValue("border-color");
		} catch (Exception e) {
			borderColor = "not available";
			System.out.println("❌ Error getting border color: " + e.getMessage());
		}
		String expectedBorderColor = "rgb(255, 0, 0)";
		System.out.println("⚠️ Actual border color : " + borderColor);
		if (borderColor.toLowerCase().equals(expectedBorderColor.toLowerCase())) {
			System.out.println(
					"✔️ Tab border color is as expected as RED colour with color code : " + expectedBorderColor);
		} else {
			System.out.println(
					"❌ Tab border color is incorrect. Expected: " + expectedBorderColor + ", Actual: " + borderColor);
		}
		Assert.assertEquals("❌ Red border is not displayed in question type pop up", borderColor, expectedBorderColor);
	}

	@Then("Select {string} option in question type in question1")
	public void select_option_in_question_type_in_question1(String questionType) throws InterruptedException {
		// Locate the dropdown
		WebElement dropdown = driver
				.findElement(By.xpath("(//div[contains(@class,'react-select__value-container')])[4]"));

		// Scroll into view before clicking
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdown);
		Thread.sleep(1000); // small pause to stabilize UI

		// Click the dropdown
		dropdown.click();

		// Wait for "Essay" option to appear
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[contains(@class,'react-select__option')][normalize-space()='" + questionType + "']")));

		// Scroll to option as well (sometimes needed)
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);
		Thread.sleep(1000);

		// Click the option
		option.click();
	}

	@Then("Select {string} option in question level in question1")
	public void select_option_in_question_level_in_question1(String questionLevel) throws InterruptedException {
		// Locate the dropdown
		WebElement dropdown = driver
				.findElement(By.xpath("(//div[contains(@class,'react-select__value-container')])[5]"));

		// Scroll into view before clicking
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdown);
		Thread.sleep(1000); // small pause to stabilize UI

		// Click the dropdown
		dropdown.click();

		// Wait for "Essay" option to appear
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[contains(@class,'react-select__option')][normalize-space()='" + questionLevel + "']")));

		// Scroll to option as well (sometimes needed)
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);
		Thread.sleep(1000);

		// Click the option
		option.click();
	}

	@Then("Enter {string} detail in question tab in question1")
	public void enter_detail_in_question_tab_in_question1(String question) {
		By questionTab = By.xpath("(//div[@class='jodit-wysiwyg'])[1]");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = driver.findElement(questionTab);
		ele1.sendKeys(genre + " " + question);
	}

	@Then("Enter {string} detail in answer tab in question1")
	public void enter_detail_in_answer_tab_in_question1(String answer) {
		By answerTab = By.xpath("(//div[@class='jodit-wysiwyg'])[2]");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = driver.findElement(answerTab);
		ele1.sendKeys(genre + " " + answer);
	}

	@Then("Enter {string} detail in explanation tab in question1")
	public void enter_detail_in_explanation_tab_in_question1(String explanation) {
		By explanationTab = By.xpath("(//div[@class='jodit-wysiwyg'])[3]");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(explanationTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + explanation);
	}

	@Then("Enter {string} detail in remarks tab in question1")
	public void enter_detail_in_remarks_tab_in_question1(String remarks) {
		By remarksTab = By.xpath("(//div[@class='jodit-wysiwyg'])[4]");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(remarksTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + remarks);
	}

	@Then("Click clear button in add question page")
	public void click_clear_button_in_add_question_page() {
		By clearButton = By.xpath("//button[contains(.,'Clear')]");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		ele1 = driver.findElement(clearButton);
		// Scroll into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);

		// Force click using JavaScript
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", ele1);
	}

	@Then("Check details is cleared or not in add question page")
	public void check_details_is_cleared_or_not_in_add_question_page() {
		By subjDrpdwn = By.xpath("(//div[@class='react-select__single-value css-1uccc91-singleValue'])[1]");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		ele1 = driver.findElement(subjDrpdwn);
		String actValue = ele1.getText();
		String expValue = "Please Select";
		Assert.assertEquals("⚠️ Clear button is not working", actValue, expValue);
	}

	@Then("Select {string} option in question type in question2")
	public void select_option_in_question_type_in_question2(String questionType) throws InterruptedException {
		// Locate the dropdown
		WebElement dropdown = driver
				.findElement(By.xpath("(//div[contains(@class,'react-select__value-container')])[6]"));

		// Scroll into view before clicking
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdown);
		Thread.sleep(1000); // small pause to stabilize UI

		// Click the dropdown
		dropdown.click();

		// Wait for "Essay" option to appear
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[contains(@class,'react-select__option')][normalize-space()='" + questionType + "']")));

		// Scroll to option as well (sometimes needed)
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);
		Thread.sleep(1000);

		// Click the option
		option.click();
	}

	@Then("Select {string} option in question level in question2")
	public void select_option_in_question_level_in_question2(String questionLevel) throws InterruptedException {
		// Locate the dropdown
		WebElement dropdown = driver
				.findElement(By.xpath("(//div[contains(@class,'react-select__value-container')])[7]"));

		// Scroll into view before clicking
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdown);
		Thread.sleep(1000); // small pause to stabilize UI

		// Click the dropdown
		dropdown.click();

		// Wait for "Essay" option to appear
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[contains(@class,'react-select__option')][normalize-space()='" + questionLevel + "']")));

		// Scroll to option as well (sometimes needed)
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);
		Thread.sleep(1000);

		// Click the option
		option.click();
	}

	@Then("Enter {string} detail in question tab in question2")
	public void enter_detail_in_question_tab_in_question2(String question) {
		By questionTab = By.xpath("(//div[@class='jodit-wysiwyg'])[5]");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(questionTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + question);
	}
	
	@Then("Enter {string} detail in scenario question tab in question2")
	public void enter_detail_in_question_tab_in_scenario_question2(String question) {
		By questionTab = By.xpath("(//div[@class='jodit-wysiwyg'])[6]");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(questionTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + question);
	}

	@Then("Enter {string} detail in answer tab in question2")
	public void enter_detail_in_answer_tab_in_question2(String answer) {
		By answerTab = By.id("fib");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(answerTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + answer);
	}
	
	@Then("Enter {string} detail in scenario answer tab in question2")
	public void enter_detail_in_scenario_answer_tab_in_question2(String answer) {
		By answerTab = By.id("fib");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(answerTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + answer);
	}

	@Then("Enter {string} detail in scenario explanation tab in question2")
	public void enter_detail_in_scenario_explanation_tab_in_question2(String explanation) {
		By explanationTab = By.xpath("(//div[@class='jodit-wysiwyg'])[7]");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(explanationTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + explanation);
	}
	
	@Then("Enter {string} detail in explanation tab in question2")
	public void enter_detail_in_explanation_tab_in_question2(String explanation) {
		By explanationTab = By.xpath("(//div[@class='jodit-wysiwyg'])[6]");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(explanationTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + explanation);
	}

	@Then("Enter {string} detail in remarks tab in question2")
	public void enter_detail_in_remarks_tab_in_question2(String remarks) {
		By remarksTab = By.xpath("(//div[@class='jodit-wysiwyg'])[7]");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(remarksTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + remarks);
	}
	
	@Then("Enter {string} detail in scenario remarks tab in question2")
	public void enter_detail_in_scenario_remarks_tab_in_question2(String remarks) {
		By remarksTab = By.xpath("(//div[@class='jodit-wysiwyg'])[8]");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(remarksTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + remarks);
	}

	@Then("Click {string} button in add question page")
	public void click_button_in_add_question_page(String questionNo) {
		By remarksTab = By.xpath("//button[contains(.,'" + questionNo + "')]");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement button = wait.until(ExpectedConditions.elementToBeClickable(remarksTab));

		// ✅ Scroll into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);

		// ✅ Click with JavaScript (bypasses overlay/intercept issues)
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
	}

	@Then("Select {string} option in question type in question3")
	public void select_option_in_question_type_in_question3(String questionType) throws InterruptedException {
		// Locate the dropdown
		WebElement dropdown = driver
				.findElement(By.xpath("(//div[contains(@class,'react-select__value-container')])[8]"));

		// Scroll into view before clicking
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdown);
		Thread.sleep(1000); // small pause to stabilize UI

		// Click the dropdown
		dropdown.click();

		// Wait for "Essay" option to appear
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[contains(@class,'react-select__option')][normalize-space()='" + questionType + "']")));

		// Scroll to option as well (sometimes needed)
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);
		Thread.sleep(1000);

		// Click the option
		option.click();
	}

	@Then("Select {string} option in question level in question3")
	public void select_option_in_question_level_in_question3(String questionLevel) throws InterruptedException {
		// Locate the dropdown
		WebElement dropdown = driver
				.findElement(By.xpath("(//div[contains(@class,'react-select__value-container')])[9]"));

		// Scroll into view before clicking
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdown);
		Thread.sleep(1000); // small pause to stabilize UI

		// Click the dropdown
		dropdown.click();

		// Wait for "Essay" option to appear
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[contains(@class,'react-select__option')][normalize-space()='" + questionLevel + "']")));

		// Scroll to option as well (sometimes needed)
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);
		Thread.sleep(1000);

		// Click the option
		option.click();
	}

	@Then("Enter {string} detail in question tab in question3")
	public void enter_detail_in_question_tab_in_question3(String question) {
		By questionTab = By.xpath("(//div[@class='jodit-wysiwyg'])[8]");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(questionTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + question);
	}
	
	@Then("Enter {string} detail in scenario question tab in question3")
	public void enter_detail_in_scenario_question_tab_in_question3(String question) {
		By questionTab = By.xpath("(//div[@class='jodit-wysiwyg'])[9]");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(questionTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + question);
	}

	@Then("Enter {string} detail in answer tab in question3")
	public void enter_detail_in_answer_tab_in_question3(String answer) {
		By answerTab = By.name("sah");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(answerTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + answer);
	}
	
	@Then("Enter {string} detail in scenario answer tab in question3")
	public void enter_detail_in_scenario_answer_tab_in_question3(String answer) {
		By answerTab = By.name("sah");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(answerTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + answer);
	}

	@Then("Enter {string} detail in explanation tab in question3")
	public void enter_detail_in_explanation_tab_in_question3(String explanation) {
		By explanationTab = By.xpath("(//div[@class='jodit-wysiwyg'])[9]");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(explanationTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + explanation);
	}
	
	@Then("Enter {string} detail in scenario explanation tab in question3")
	public void enter_detail_in_explanation_tab__scenarioin_question3(String explanation) {
		By explanationTab = By.xpath("(//div[@class='jodit-wysiwyg'])[10]");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(explanationTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + explanation);
	}

	@Then("Enter {string} detail in remarks tab in question3")
	public void enter_detail_in_remarks_tab_in_question3(String remarks) {
		By remarksTab = By.xpath("(//div[@class='jodit-wysiwyg'])[10]");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(remarksTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + remarks);
	}
	
	@Then("Enter {string} detail in scenario remarks tab in question3")
	public void enter_detail_in_scenario_remarks_tab_in_question3(String remarks) {
		By remarksTab = By.xpath("(//div[@class='jodit-wysiwyg'])[11]");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(remarksTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + remarks);
	}

	@Then("Select {string} option in question type in question4")
	public void select_option_in_question_type_in_question4(String questionType) throws InterruptedException {
		// Locate the dropdown
		WebElement dropdown = driver
				.findElement(By.xpath("(//div[contains(@class,'react-select__value-container')])[10]"));

		// Scroll into view before clicking
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdown);
		Thread.sleep(1000); // small pause to stabilize UI

		// Click the dropdown
		dropdown.click();

		// Wait for "Essay" option to appear
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[contains(@class,'react-select__option')][normalize-space()='" + questionType + "']")));

		// Scroll to option as well (sometimes needed)
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);
		Thread.sleep(1000);

		// Click the option
		option.click();
	}

	@Then("Select {string} option in question level in question4")
	public void select_option_in_question_level_in_question4(String questionType) throws InterruptedException {
		// Locate the dropdown
		WebElement dropdown = driver
				.findElement(By.xpath("(//div[contains(@class,'react-select__value-container')])[11]"));

		// Scroll into view before clicking
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdown);
		Thread.sleep(1000); // small pause to stabilize UI

		// Click the dropdown
		dropdown.click();

		// Wait for "Essay" option to appear
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[contains(@class,'react-select__option')][normalize-space()='" + questionType + "']")));

		// Scroll to option as well (sometimes needed)
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);
		Thread.sleep(1000);

		// Click the option
		option.click();
	}

	@Then("Enter {string} detail in question tab in question4")
	public void enter_detail_in_question_tab_in_question4(String question) {
		By questionTab = By.xpath("(//div[@class='jodit-wysiwyg'])[11]");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(questionTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + question);
	}
	
	@Then("Enter {string} detail in scenario question tab in question4")
	public void enter_detail_in_scenario_question_tab_in_question4(String question) {
		By questionTab = By.xpath("(//div[@class='jodit-wysiwyg'])[12]");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(questionTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + question);
	}

	@Then("Enter {string} detail in option1 in answer tab in question4")
	public void enter_detail_in_option1_in_answer_tab_in_question4(String option) {
		By optionTab = By.xpath("(//div[@class='jodit-wysiwyg'])[12]");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(optionTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + option);
	}
	
	@Then("Enter {string} detail in option1 in scenario answer tab in question4")
	public void enter_detail_in_option1_in_scenario_answer_tab_in_question4(String option) {
		By optionTab = By.xpath("(//div[@class='jodit-wysiwyg'])[13]");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(optionTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + option);
	}

	@Then("Enter {string} detail in option2 in answer tab in question4")
	public void enter_detail_in_option2_in_answer_tab_in_question4(String option) {
		By optionTab = By.xpath("(//div[@class='jodit-wysiwyg'])[13]");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(optionTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + option);
	}
	
	@Then("Enter {string} detail in option2 in scenario answer tab in question4")
	public void enter_detail_in_option2_in_scenario_answer_tab_in_question4(String option) {
		By optionTab = By.xpath("(//div[@class='jodit-wysiwyg'])[14]");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(optionTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + option);
	}

	@Then("Enter {string} detail in option3 in answer tab in question4")
	public void enter_detail_in_option3_in_answer_tab_in_question4(String option) {
		By optionTab = By.xpath("(//div[@class='jodit-wysiwyg'])[14]");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(optionTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + option);
	}
	
	@Then("Enter {string} detail in option3 in scenario answer tab in question4")
	public void enter_detail_in_option3_in_scenario_answer_tab_in_question4(String option) {
		By optionTab = By.xpath("(//div[@class='jodit-wysiwyg'])[15]");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(optionTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + option);
	}

	@Then("Enter {string} detail in explanation tab in question4")
	public void enter_detail_in_explanation_tab_in_question4(String explanation) {
		By explanationTab = By.xpath("(//div[@class='jodit-wysiwyg'])[15]");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(explanationTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + explanation);
	}
	
	@Then("Enter {string} detail in scenario explanation tab in question4")
	public void enter_detail_in_scenario_explanation_tab_in_question4(String explanation) {
		By explanationTab = By.xpath("(//div[@class='jodit-wysiwyg'])[16]");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(explanationTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + explanation);
	}

	@Then("Enter {string} detail in remarks tab in question4")
	public void enter_detail_in_remarks_tab_in_question4(String remarks) {
		By remarksTab = By.xpath("(//div[@class='jodit-wysiwyg'])[16]");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(remarksTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + remarks);
	}
	
	@Then("Enter {string} detail in scenario remarks tab in question4")
	public void enter_detail_in_scenario_remarks_tab_in_question4(String remarks) {
		By remarksTab = By.xpath("(//div[@class='jodit-wysiwyg'])[16]");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(remarksTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + remarks);
	}

	@Then("Select {string} option in question type in question5")
	public void select_option_in_question_type_in_question5(String questionType) throws InterruptedException {
		// Locate the dropdown
		WebElement dropdown = driver
				.findElement(By.xpath("(//div[contains(@class,'react-select__value-container')])[12]"));

		// Scroll into view before clicking
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdown);
		Thread.sleep(1000); // small pause to stabilize UI

		// Click the dropdown
		dropdown.click();

		// Wait for "Essay" option to appear
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[contains(@class,'react-select__option')][normalize-space()='" + questionType + "']")));

		// Scroll to option as well (sometimes needed)
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);
		Thread.sleep(1000);

		// Click the option
		option.click();
	}

	@Then("Select {string} option in question level in question5")
	public void select_option_in_question_level_in_question5(String questionType) throws InterruptedException {
		// Locate the dropdown
		WebElement dropdown = driver
				.findElement(By.xpath("(//div[contains(@class,'react-select__value-container')])[13]"));

		// Scroll into view before clicking
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdown);
		Thread.sleep(1000); // small pause to stabilize UI

		// Click the dropdown
		dropdown.click();

		// Wait for "Essay" option to appear
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[contains(@class,'react-select__option')][normalize-space()='" + questionType + "']")));

		// Scroll to option as well (sometimes needed)
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);
		Thread.sleep(1000);

		// Click the option
		option.click();
	}

	@Then("Enter {string} detail in question tab in question5")
	public void enter_detail_in_question_tab_in_question5(String question) {
		By questionTab = By.xpath("(//div[@class='jodit-wysiwyg'])[17]");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(questionTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + question);
	}
	
	@Then("Enter {string} detail in scenario question tab in question5")
	public void enter_detail_in_scenario_question_tab_in_question5(String question) {
		By questionTab = By.xpath("(//div[@class='jodit-wysiwyg'])[18]");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(questionTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + question);
	}

	@Then("Enter {string} detail in option1 in answer tab in question5")
	public void enter_detail_in_option1_in_answer_tab_in_question5(String option) {
		By optionTab = By.xpath("(//div[@class='jodit-wysiwyg'])[18]");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(optionTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + option);
	}
	
	@Then("Enter {string} detail in option1 in scenario answer tab in question5")
	public void enter_detail_in_option1_in_scenario_answer_tab_in_question5(String option) {
		By optionTab = By.xpath("(//div[@class='jodit-wysiwyg'])[19]");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(optionTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + option);
	}

	@Then("Enter {string} detail in option2 in answer tab in question5")
	public void enter_detail_in_option2_in_answer_tab_in_question5(String option) {
		By optionTab = By.xpath("(//div[@class='jodit-wysiwyg'])[19]");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(optionTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + option);
	}
	
	@Then("Enter {string} detail in option2 in scenario answer tab in question5")
	public void enter_detail_in_option2_in_scenario_answer_tab_in_question5(String option) {
		By optionTab = By.xpath("(//div[@class='jodit-wysiwyg'])[20]");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(optionTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + option);
	}

	@Then("Enter {string} detail in option3 in answer tab in question5")
	public void enter_detail_in_option3_in_answer_tab_in_question5(String option) {
		By optionTab = By.xpath("(//div[@class='jodit-wysiwyg'])[20]");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(optionTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + option);
	}
	
	@Then("Enter {string} detail in option3 in scenario answer tab in question5")
	public void enter_detail_in_option3_in_scenario_answer_tab_in_question5(String option) {
		By optionTab = By.xpath("(//div[@class='jodit-wysiwyg'])[21]");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(optionTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + option);
	}

	@Then("Enter {string} detail in explanation tab in question5")
	public void enter_detail_in_explanation_tab_in_question5(String explanation) {
		By explanationTab = By.xpath("(//div[@class='jodit-wysiwyg'])[21]");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(explanationTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + explanation);
	}
	
	@Then("Enter {string} detail in scenario explanation tab in question5")
	public void enter_detail_in_scenario_explanation_tab_in_question5(String explanation) {
		By explanationTab = By.xpath("(//div[@class='jodit-wysiwyg'])[22]");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(explanationTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + explanation);
	}

	@Then("Enter {string} detail in remarks tab in question5")
	public void enter_detail_in_remarks_tab_in_question5(String remarks) {
		By explanationTab = By.xpath("(//div[@class='jodit-wysiwyg'])[22]");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(explanationTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + remarks);
	}
	
	@Then("Enter {string} detail in scenario remarks tab in question5")
	public void enter_detail_in_scenario_remarks_tab_in_question5(String remarks) {
		By explanationTab = By.xpath("(//div[@class='jodit-wysiwyg'])[23]");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(explanationTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + remarks);
	}

	@Then("Select {string} option in question type in question6")
	public void select_option_in_question_type_in_question6(String questionType) throws InterruptedException {
		// Locate the dropdown
		WebElement dropdown = driver
				.findElement(By.xpath("(//div[contains(@class,'react-select__value-container')])[14]"));

		// Scroll into view before clicking
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdown);
		Thread.sleep(1000); // small pause to stabilize UI

		// Click the dropdown
		dropdown.click();

		// Wait for "Essay" option to appear
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[contains(@class,'react-select__option')][normalize-space()='" + questionType + "']")));

		// Scroll to option as well (sometimes needed)
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);
		Thread.sleep(1000);

		// Click the option
		option.click();
	}

	@Then("Select {string} option in question level in question6")
	public void select_option_in_question_level_in_question6(String questionLevel) throws InterruptedException {
		// Locate the dropdown
		WebElement dropdown = driver
				.findElement(By.xpath("(//div[contains(@class,'react-select__value-container')])[15]"));

		// Scroll into view before clicking
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdown);
		Thread.sleep(1000); // small pause to stabilize UI

		// Click the dropdown
		dropdown.click();

		// Wait for "Essay" option to appear
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[contains(@class,'react-select__option')][normalize-space()='" + questionLevel + "']")));

		// Scroll to option as well (sometimes needed)
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);
		Thread.sleep(1000);

		// Click the option
		option.click();
	}

	@Then("Enter {string} detail in question tab in question6")
	public void enter_detail_in_question_tab_in_question6(String question) {
		By questionTab = By.xpath("(//div[@class='jodit-wysiwyg'])[23]");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(questionTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + question);
	}
	
	@Then("Enter {string} detail in scenario question tab in question6")
	public void enter_detail_in_scenario_question_tab_in_question6(String question) {
		By questionTab = By.xpath("(//div[@class='jodit-wysiwyg'])[24]");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(questionTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + question);
	}

	@Then("Enter {string} detail in explanation tab in question6")
	public void enter_detail_in_explanation_tab_in_question6(String explanation) {
		By explanationTab = By.xpath("(//div[@class='jodit-wysiwyg'])[26]");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(explanationTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + explanation);
	}
	
	@Then("Enter {string} detail in scenario explanation tab in question6")
	public void enter_detail_in_scenario_explanation_tab_in_question6(String explanation) {
		By explanationTab = By.xpath("(//div[@class='jodit-wysiwyg'])[27]");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(explanationTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + explanation);
	}

	@Then("Enter {string} detail in remarks tab in question6")
	public void enter_detail_in_remarks_tab_in_question6(String remarks) {
		By explanationTab = By.xpath("(//div[@class='jodit-wysiwyg'])[27]");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(explanationTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + remarks);
	}
	
	@Then("Enter {string} detail in scenario remarks tab in question6")
	public void enter_detail_in_scenario_remarks_tab_in_question6(String remarks) {
		By explanationTab = By.xpath("(//div[@class='jodit-wysiwyg'])[28]");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(explanationTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + remarks);
	}

	@Then("Select {string} option in question type in question7")
	public void select_option_in_question_type_in_question7(String questionType) throws InterruptedException {
		// Locate the dropdown
		WebElement dropdown = driver
				.findElement(By.xpath("(//div[contains(@class,'react-select__value-container')])[16]"));

		// Scroll into view before clicking
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdown);
		Thread.sleep(1000); // small pause to stabilize UI

		// Click the dropdown
		dropdown.click();

		// Wait for "Essay" option to appear
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[contains(@class,'react-select__option')][normalize-space()='" + questionType + "']")));

		// Scroll to option as well (sometimes needed)
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);
		Thread.sleep(1000);

		// Click the option
		option.click();
	}

	@Then("Select {string} option in question level in question7")
	public void select_option_in_question_level_in_question7(String questionLevel) throws InterruptedException {
		// Locate the dropdown
		WebElement dropdown = driver
				.findElement(By.xpath("(//div[contains(@class,'react-select__value-container')])[17]"));

		// Scroll into view before clicking
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdown);
		Thread.sleep(1000); // small pause to stabilize UI

		// Click the dropdown
		dropdown.click();

		// Wait for "Essay" option to appear
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement option = wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//div[contains(@class,'react-select__option')][normalize-space()='" + questionLevel + "']")));

		// Scroll to option as well (sometimes needed)
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);
		Thread.sleep(1000);

		// Click the option
		option.click();
	}

	@Then("Enter {string} detail in question tab in question7")
	public void enter_detail_in_question_tab_in_question7(String question) {
		By questionTab = By.xpath("(//div[@class='jodit-wysiwyg'])[28]");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(questionTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + question);
	}
	
	@Then("Enter {string} detail in scenario question tab in question7")
	public void enter_detail_in_scenario_question_tab_in_question7(String question) {
		By questionTab = By.xpath("(//div[@class='jodit-wysiwyg'])[29]");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(questionTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + question);
	}

	@Then("Enter {string} detail in left1 in answer tab in question7")
	public void enter_detail_in_left1_in_answer_tab_in_question7(String answer) {
		By answerTab = By.name("leftdef16");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(answerTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + answer);
	}
	
	@Then("Enter {string} detail in left1 in scenario answer tab in question7")
	public void enter_detail_in_left1_in_scenario_answer_tab_in_question7(String answer) {
		By answerTab = By.name("leftdef16");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(answerTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + answer);
	}

	@Then("Enter {string} detail in right1 in answer tab in question7")
	public void enter_detail_in_right1_in_answer_tab_in_question7(String answer) {
		By answerTab = By.name("rightdef16");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(answerTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + answer);
	}
	
	@Then("Enter {string} detail in right1 in scenario answer tab in question7")
	public void enter_detail_in_right1_in_scenario_answer_tab_in_question7(String answer) {
		By answerTab = By.name("rightdef16");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(answerTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + answer);
	}

	@Then("Enter {string} detail in left2 in answer tab in question7")
	public void enter_detail_in_left2_in_answer_tab_in_question7(String answer) {
		By answerTab = By.name("leftdef26");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(answerTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + answer);
	}
	
	@Then("Enter {string} detail in left2 in scenario answer tab in question7")
	public void enter_detail_in_left2_in_scenario_answer_tab_in_question7(String answer) {
		By answerTab = By.name("leftdef26");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(answerTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + answer);
	}

	@Then("Enter {string} detail in right2 in answer tab in question7")
	public void enter_detail_in_right2_in_answer_tab_in_question7(String answer) {
		By answerTab = By.name("rightdef26");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(answerTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + answer);
	}
	
	@Then("Enter {string} detail in right2 in scenario answer tab in question7")
	public void enter_detail_in_right2_in_scenario_answer_tab_in_question7(String answer) {
		By answerTab = By.name("rightdef26");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(answerTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + answer);
	}

	@Then("Enter {string} detail in explanation tab in question7")
	public void enter_detail_in_explanation_tab_in_question7(String explanation) {
		By explanationTab = By.xpath("(//div[@class='jodit-wysiwyg'])[29]");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(explanationTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + explanation);
	}
	
	@Then("Enter {string} detail in scenario explanation tab in question7")
	public void enter_detail_in_scenario_explanation_tab_in_question7(String explanation) {
		By explanationTab = By.xpath("(//div[@class='jodit-wysiwyg'])[29]");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(explanationTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + explanation);
	}

	@Then("Enter {string} detail in remarks tab in question7")
	public void enter_detail_in_remarks_tab_in_question7(String remarks) {
		By explanationTab = By.xpath("(//div[@class='jodit-wysiwyg'])[30]");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(explanationTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + remarks);
	}
	
	@Then("Enter {string} detail in scenario remarks tab in question7")
	public void enter_detail_in_scenario_remarks_tab_in_question7(String remarks) {
		By explanationTab = By.xpath("(//div[@class='jodit-wysiwyg'])[30]");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String genre = fake.book().genre();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(explanationTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(genre + " " + remarks);
	}
	
	@Then("Enter {string} detail in scenario in question tab")
	public void enter_detail_in_scenario_in_question_tab(String scenario) {
		By scenarioTab = By.xpath("(//div[@class='jodit-workplace']//div)[1]");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		Faker fake = new Faker();
		String paragraph = fake.lorem().paragraph();

		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(scenarioTab));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele1);
		ele1.sendKeys(paragraph + " " + scenario);
		System.out.println("---------->Scenario is: "+paragraph);
	}

}