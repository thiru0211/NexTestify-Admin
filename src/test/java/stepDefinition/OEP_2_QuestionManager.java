package stepDefinition;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.jspecify.annotations.Nullable;
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

public class OEP_2_QuestionManager {
	public WebDriver driver;
	public WebElement ele, ele1, ele2, ele3, ele4, ele5, ele6, ele7, ele8, ele9;
	public WebDriverWait wait;

	@Given("To Check Create Question is navigating to OEP URL is {string}")
	public void to_check_create_question_is_navigating_to_oep_url_is(String url) {
		System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--headless=new");
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
		ele1 = driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
		ele1.click();
	}

	@Then("Close Create Question button")
	public void close_create_question_button() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
		System.out.print("\u001B[1mPage is closed\u001B[0m");
	}

	@Then("Click Create Question button")
	public void click_create_question_button() throws InterruptedException {
		Thread.sleep(4000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//span[normalize-space(text())='Question Bank']")));
		ele1 = driver.findElement(By.xpath("//span[normalize-space(text())='Question Bank']"));
		Actions action = new Actions(driver);
		action.moveToElement(ele1).build().perform();
		ele1.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//span[normalize-space(text())='Create Question']")));
		ele2 = driver.findElement(By.xpath("//span[normalize-space(text())='Create Question']"));
		ele2.click();
		Thread.sleep(2000);
		driver.navigate().refresh();
	}

	@Given("Enter valid question {string} details in the searchbox")
	public void enter_valid_question_details_in_the_searchbox(String validQuestion) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtSearch")));
		ele1 = driver.findElement(By.name("txtSearch"));
		ele1.click();
		Thread.sleep(2000);
		ele1.clear();
		Thread.sleep(2000);
		ele1.sendKeys(validQuestion);
		Thread.sleep(2000);
		ele1.sendKeys(Keys.ENTER);
	}

	@When("Enter valid answer {string} details in the searchbox")
	public void enter_valid_answer_details_in_the_searchbox(String validAnswer) throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtSearch")));
		ele1 = driver.findElement(By.name("txtSearch"));
		String searchBox = ele1.getDomProperty("value");
		ele1.click();
		int length = searchBox.length();
		for(int i=0;i<length;i++) {
			ele1.clear();
		}
		Thread.sleep(4000);
		ele1.sendKeys(validAnswer);
		Thread.sleep(2000);
		ele1.sendKeys(Keys.ENTER);
	}

	@Then("Enter valid subject name {string} in the searchbox")
	public void enter_valid_subject_name_in_the_searchbox(String validSubjectName)  throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtSearch")));
		ele1 = driver.findElement(By.name("txtSearch"));
		String searchBox = ele1.getDomProperty("value");
		ele1.click();
		int length = searchBox.length();
		for(int i=0;i<length;i++) {
			ele1.clear();
		}
		Thread.sleep(4000);
		ele1.sendKeys(validSubjectName);
		Thread.sleep(2000);
		ele1.sendKeys(Keys.ENTER);
	}

	@When("Check entered question {string} details is displayed or not")
	public void check_entered_question_details_is_displayed_or_not(String validQuestionDetail) throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='col-xl-8 col-lg-8']")));
		ele1 = driver.findElement(By.xpath("//div[@class='col-xl-8 col-lg-8']"));
		String actualQuestionDetail = ele1.getText();
		String expectedQuestionDetail = validQuestionDetail;
		Assert.assertEquals("Entered question name is not displayed", actualQuestionDetail, expectedQuestionDetail);
		
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
	public void check_entered_subject_name_details_is_displayed_or_not(String validSubjectName) throws InterruptedException {
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
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[contains(@class,'btn-icon btn-icon-start')])[1]")));
		ele1 = driver.findElement(By.xpath("(//button[contains(@class,'btn-icon btn-icon-start')])[1]"));
		ele1.click();
	}
	@When("Check question status {string} is same as user selected")
	public void check_question_status_is_same_as_user_selected(String selectedQuestionStatus) throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='react-select__value-container react-select__value-container--has-value css-1hwfws3'])[5]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='react-select__value-container react-select__value-container--has-value css-1hwfws3'])[5]"));
		String actualquestionStatus=ele1.getText();
		System.out.println("Status displayed as: "+actualquestionStatus);
		String expectedQuestionStatus=selectedQuestionStatus;
		Assert.assertEquals("Status dropdown is not working", actualquestionStatus, expectedQuestionStatus);
	}
	
	@Then("Check question level {string} is same as user selected")
	public void check_question_level_is_same_as_user_selected(String selectedQuestionLevel) throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='react-select__value-container react-select__value-container--has-value css-1hwfws3'])[4]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='react-select__value-container react-select__value-container--has-value css-1hwfws3'])[4]"));
		String actualquestionLevel=ele1.getText();
		System.out.println("Status displayed as: "+actualquestionLevel);
		String expectedQuestionLevel=selectedQuestionLevel;
		Assert.assertEquals("Status dropdown is not working", actualquestionLevel, expectedQuestionLevel);
	}
	@Then("Click take picture button in Create Question")
	public void click_take_picture_button_in_Create_Question() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//button[normalize-space(text())='Take Picture']")));
		ele1 = driver.findElement(By.xpath(
				"//button[normalize-space(text())='Take Picture']"));
		ele1.click();
	}
	
	@Then("Check selected {string} option in subject dropdown")
	public void check_selected_option_in_subject_dropdown(String selectedSubject) throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[@class='badge bg-outline-primary'])[1]")));
		ele1 = driver.findElement(By.xpath("(//span[@class='badge bg-outline-primary'])[1]"));
		String actualSubject=ele1.getText();
		System.out.println("Status displayed as: "+actualSubject);
		String expectedSubject=selectedSubject;
		Assert.assertEquals("Subject dropdown is not working", actualSubject, expectedSubject);
	}
	
	@Given("Select All option in status dropdown")
	public void select_all_option_in_status_dropdown() throws InterruptedException {
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

	@Given("Select Active option in status dropdown")
	public void select_active_option_in_status_dropdown() throws InterruptedException {
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
	
	@Given("Select Inactive option in status dropdown")
	public void select_inactive_option_in_status_dropdown() throws InterruptedException {
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

	@Given("Select All Subject option in subject dropdown")
	public void select_all_subject_option_in_subject_dropdown() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='All Subject']"));
		ele2.click();
	}

	@Given("Select Artificial Intelligence option in subject dropdown")
	public void select_artificial_intelligence_option_in_subject_dropdown() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Artificial Intelligence']"));
		ele2.click();
	}

	@Then("Select Business and Commerce option in subject dropdown")
	public void select_business_and_commerce_option_in_subject_dropdown() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]"));
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
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Cryptography']"));
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
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[3]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[3]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='All Level']"));
		ele2.click();
	}

	@Given("Select Easy option in level dropdown")
	public void select_easy_option_in_level_dropdown() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[3]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[3]"));
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

	@Given("Click 3dots button")
	public void click_3dots_button() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//button[contains(@class,'btn-icon btn-icon-only')])[1]")));
		ele1 = driver.findElement(By.xpath("(//button[contains(@class,'btn-icon btn-icon-only')])[1]"));
		ele1.click();
	}

	@Given("Check  question created user name and date & time details displayed or not")
	public void check_question_created_user_name_and_date_time_details_displayed_or_not() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='popover-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='popover-body']"));
		String text = ele1.getText();
		System.out.println("Question created username and Date & Time is: " + text);
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
	
	@Given("Click add questions button")
	public void click_add_questions_button() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@type='button'])[1]")));
		ele1 = driver.findElement(By.xpath("(//button[@type='button'])[1]"));
		ele1.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='dropdown-menu show']//a[1]")));
		ele2 = driver.findElement(By.xpath("//div[@class='dropdown-menu show']//a[1]"));
		ele2.click();
	}

	@Given("Click view questions button")
	public void click_view_questions_button() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//button[@title='click here to view questions']")));
		ele1 = driver.findElement(By.xpath("//button[@title='click here to view questions']"));
		ele1.click();
	}

	@Then("Check landing page in add question page")
	public void check_landing_page_in_add_question_page() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtSearch")));
		ele1 = driver.findElement(By.name("txtSearch"));
		boolean isDisplayed = ele1.isDisplayed();
		Assert.assertTrue("Back button is not working", isDisplayed);
	}

	@Given("Click save button in add question page")
	public void click_save_button_in_add_question_page() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='click here to save']")));
		ele1 = driver.findElement(By.xpath("//button[@title='click here to save']"));
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

			System.out.println("Error getting border color: " + e.getMessage());
		}
		String expectedBorderColor = "rgb(78, 78, 78)";
		System.out.println("Actual border color : " + borderColor1);
		System.out.println("Actual border color : " + borderColor2);
		System.out.println("Actual border color : " + borderColor3);
		System.out.println("Actual border color : " + borderColor4);
		if (borderColor1.toLowerCase().equals(expectedBorderColor.toLowerCase())) {
			System.out
					.println("Tab border color is as expected as RED colour with color code : " + expectedBorderColor);
		} else {
			System.out.println(
					"Tab border color is incorrect. Expected: " + expectedBorderColor + ", Actual: " + borderColor1);
		}
		if (borderColor2.toLowerCase().equals(expectedBorderColor.toLowerCase())) {
			System.out
					.println("Tab border color is as expected as RED colour with color code : " + expectedBorderColor);
		} else {
			System.out.println(
					"Tab border color is incorrect. Expected: " + expectedBorderColor + ", Actual: " + borderColor2);
		}
		if (borderColor3.toLowerCase().equals(expectedBorderColor.toLowerCase())) {
			System.out
					.println("Tab border color is as expected as RED colour with color code : " + expectedBorderColor);
		} else {
			System.out.println(
					"Tab border color is incorrect. Expected: " + expectedBorderColor + ", Actual: " + borderColor3);
		}
		if (borderColor4.toLowerCase().equals(expectedBorderColor.toLowerCase())) {
			System.out
					.println("Tab border color is as expected as RED colour with color code : " + expectedBorderColor);
		} else {
			System.out.println(
					"Tab border color is incorrect. Expected: " + expectedBorderColor + ", Actual: " + borderColor4);
		}
		Assert.assertEquals("Red border is not displayed in subject tab", borderColor1, expectedBorderColor);
		Assert.assertEquals("Red border is not displayed in topic tab", borderColor2, expectedBorderColor);
		Assert.assertEquals("Red border is not displayed in question type tab", borderColor3, expectedBorderColor);
		Assert.assertEquals("Red border is not displayed in question level tab", borderColor4, expectedBorderColor);
	}

	@Then("Click clear button in add questions page")
	public void click_clear_button_in_add_questions_page() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='click here to clear']")));
		ele1 = driver.findElement(By.xpath("//button[@title='click here to clear']"));
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

			System.out.println("Error getting border color: " + e.getMessage());
		}
		String expectedBorderColor = "rgb(78, 78, 78)";
		System.out.println("Actual border color : " + borderColor1);
		System.out.println("Actual border color : " + borderColor2);
		System.out.println("Actual border color : " + borderColor3);
		System.out.println("Actual border color : " + borderColor4);
		if (borderColor1.toLowerCase().equals(expectedBorderColor.toLowerCase())) {
			System.out
					.println("Tab border color is as expected as RED colour with color code : " + expectedBorderColor);
			System.out.println("Red border is removed");
		} else {
			System.out.println("Red border is not removed");
		}
		if (borderColor2.toLowerCase().equals(expectedBorderColor.toLowerCase())) {
			System.out
					.println("Tab border color is as expected as RED colour with color code : " + expectedBorderColor);
			System.out.println("Red border is removed");
		} else {
			System.out.println("Red border is not removed");
		}
		if (borderColor3.toLowerCase().equals(expectedBorderColor.toLowerCase())) {
			System.out
					.println("Tab border color is as expected as RED colour with color code : " + expectedBorderColor);
			System.out.println("Red border is removed");
		} else {
			System.out.println("Red border is not removed");
		}
		if (borderColor4.toLowerCase().equals(expectedBorderColor.toLowerCase())) {
			System.out
					.println("Tab border color is as expected as RED colour with color code : " + expectedBorderColor);
			System.out.println("Red border is removed");
		} else {
			System.out.println("Red border is not removed");
		}
		
		Assert.assertEquals("Red border is not removed in subject tab", borderColor1, expectedBorderColor);
		Assert.assertEquals("Red border is not removed in topic tab", borderColor2, expectedBorderColor);
		Assert.assertEquals("Red border is not removed in question type tab", borderColor3, expectedBorderColor);
		Assert.assertEquals("Red border is not removed in question level tab", borderColor4, expectedBorderColor);
	}

	@Given("Click add button in subject tab")
	public void click_add_button_in_subject_tab() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Click here to Add Category']")));
		ele1 = driver.findElement(By.xpath("//button[@title='Click here to Add Category']"));
		ele1.click();
	}

	@Given("Click close button in add subject popup")
	public void click_close_button_in_add_subject_popup() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='modal-header']//div)[3]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='modal-header']//div)[3]"));
		ele1.click();
	}

	@Then("Click add button in add subject popup")
	public void click_add_button_in_add_subject_popup() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//button[contains(@class,'btn btn-outline-primary')]")));
		ele1 = driver.findElement(By.xpath("//button[contains(@class,'btn btn-outline-primary')]"));
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
			System.out.println("Error getting border color: " + e.getMessage());
		}
		String expectedBorderColor = "rgb(255, 0, 0)";
		System.out.println("Actual border color : " + borderColor);
		if (borderColor.toLowerCase().equals(expectedBorderColor.toLowerCase())) {
			System.out
					.println("Tab border color is as expected as RED colour with color code : " + expectedBorderColor);
			System.out.println("Red border is displayed");
		} else {
			System.out.println(
					"Tab border color is incorrect. Expected: " + expectedBorderColor + ", Actual: " + borderColor);
		}
		Assert.assertEquals("Red border is not displayed in subject name", borderColor, expectedBorderColor);
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
		System.out.println("Error message displayed like: " + actualMessage);
		String expectedMessage = "Subject already exist!";
		Assert.assertEquals("Error message need to display", actualMessage, expectedMessage);
	}

	@Then("Enter valid subject name in add subject popup")
	public void enter_valid_subject_name_in_add_subject_popup() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("catName")));
		ele1 = driver.findElement(By.id("catName"));
		ele1.sendKeys("Test Subject");
	}

	@Then("Check success message is displayed or not in add subject")
	public void check_success_message_is_displayed_or_not_in_add_subject() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actualMessage = ele1.getText();
		System.out.println("Success message displayed like: " + actualMessage);
		String expectedMessage = "Subject added successfully!";
		Assert.assertEquals("Error message need to display", actualMessage, expectedMessage);
	}

	@Given("Select any subject from the dropdown")
	public void select_any_subject_from_the_dropdown() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[1]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[1]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Cryptography']"));
		ele2.click();
	}

	@Then("Click edit button in subject tab")
	public void click_edit_button_in_subject_tab() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//button[@title='Click here to Edit Category']")));
		ele1 = driver.findElement(By.xpath("//button[@title='Click here to Edit Category']"));
		ele1.click();
	}

	@Then("Click Close button in edit subject popup")
	public void click_close_button_in_edit_subject_popup() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='modal-header']//div)[3]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='modal-header']//div)[3]"));
		ele1.click();
	}

	@Then("Modify valid subject name in edit subject popup")
	public void modify_valid_subject_name_in_edit_subject_popup() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("catName")));
		ele1 = driver.findElement(By.id("catName"));
		String text = ele1.getAttribute("value");
		int length = text.length();
		for (int i = 0; i < length; i++) {
			ele1.sendKeys(Keys.BACK_SPACE);
		}
		ele1.sendKeys(text);
	}

	@Then("Click update button in edit subject popup")
	public void click_update_button_in_edit_subject_popup() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[normalize-space(text())='Update']")));
		ele1 = driver.findElement(By.xpath("//button[normalize-space(text())='Update']"));
		ele1.click();
	}

	@Then("Check success message is displayed or not in edit subject")
	public void check_success_message_is_displayed_or_not_in_edit_subject() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actualMessage = ele1.getText();
		System.out.println("Success message displayed like: " + actualMessage);
	}

	@Then("Click Delete button in subject tab")
	public void click_delete_button_in_subject_tab() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//button[@title='Click here to Delete Category']")));
		ele1 = driver.findElement(By.xpath("//button[@title='Click here to Delete Category']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}

	@Then("Click Close button in Delete Subject popup")
	public void click_close_button_in_delete_subject_popup() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='modal-header']//div)[3]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='modal-header']//div)[3]"));
		ele1.click();
	}

	@Then("Click NO button in Delete Subject popup")
	public void click_no_button_in_delete_subject_popup() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[normalize-space(text())='No']")));
		ele1 = driver.findElement(By.xpath("//button[normalize-space(text())='No']"));
		ele1.click();
	}

	@Then("Click YES button in Delete Subject popup")
	public void click_yes_button_in_delete_subject_popup() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[normalize-space(text())='Yes']")));
		ele1 = driver.findElement(By.xpath("//button[normalize-space(text())='Yes']"));
		ele1.click();
	}

	@Then("Check success message is displayed or not in Delete Subject")
	public void check_success_message_is_displayed_or_not_in_delete_subject() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actualMessage = ele1.getText();
		System.out.println("Success message displayed like: " + actualMessage);
	}

	@Then("Click add button in topic tab")
	public void click_add_button_in_topic_tab() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Click here to Add Topic']")));
		ele1 = driver.findElement(By.xpath("//button[@title='Click here to Add Topic']"));
		ele1.click();
	}

	@Then("Click add button in add topic popup")
	public void click_add_button_in_add_topic_popup() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//button[contains(@class,'btn btn-outline-primary')]")));
		ele1 = driver.findElement(By.xpath("//button[contains(@class,'btn btn-outline-primary')]"));
		ele1.click();
	}

	@Then("Click close button in add topic popup")
	public void click_close_button_in_add_topic_popup() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='modal-header']//div)[3]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='modal-header']//div)[3]"));
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
			System.out.println("Error getting border color: " + e.getMessage());
		}
		String expectedBorderColor = "rgb(255, 0, 0)";
		System.out.println("Actual border color : " + borderColor);
		if (borderColor.toLowerCase().equals(expectedBorderColor.toLowerCase())) {
			System.out
					.println("Tab border color is as expected as RED colour with color code : " + expectedBorderColor);
		} else {
			System.out.println(
					"Tab border color is incorrect. Expected: " + expectedBorderColor + ", Actual: " + borderColor);
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
		System.out.println("Success message displayed like: " + actualMessage);
		String expectedMessage="Topic added successfully!";
		Assert.assertEquals("Add topic is not working", actualMessage, expectedMessage);
	}

	@Then("Click edit button in topic tab")
	public void click_edit_button_in_topic_tab() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Click here to Edit Topic']")));
		ele1 = driver.findElement(By.xpath("//button[@title='Click here to Edit Topic']"));
		ele1.click();
	}

	@Then("Click Close button in edit topic popup")
	public void click_close_button_in_edit_topic_popup() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='modal-header']//div)[3]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='modal-header']//div)[3]"));
		ele1.click();
	}

	@Then("Modify valid subject name in edit topic popup")
	public void modify_valid_subject_name_in_edit_topic_popup() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("topicName")));
		ele1 = driver.findElement(By.id("topicName"));
		String text = ele1.getDomProperty("value");
		int length = text.length();
		for (int i = 0; i < length; i++) {
			ele1.sendKeys(Keys.BACK_SPACE);
		}
		Thread.sleep(2000);
		ele1.sendKeys(text+"s");
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
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[normalize-space(text())='Update']")));
		ele1 = driver.findElement(By.xpath("//button[normalize-space(text())='Update']"));
		ele1.click();
	}

	@Then("Check success message is displayed or not in edit topic")
	public void check_success_message_is_displayed_or_not_in_edit_topic() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actualMessage = ele1.getText();
		System.out.println("Success message displayed like: " + actualMessage);
		String expectedMessage="Topic updated successfully!";
		Assert.assertEquals("Test topic add button is not working", actualMessage, expectedMessage);
	}

	@Then("Click Delete button in topic tab")
	public void click_delete_button_in_topic_tab() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Click here to Delete Topic']")));
		ele1 = driver.findElement(By.xpath("//button[@title='Click here to Delete Topic']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}

	@Then("Click Close button in Delete topic popup")
	public void click_close_button_in_delete_topic_popup() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='modal-header']//div)[3]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='modal-header']//div)[3]"));
		ele1.click();
	}

	@Then("Click NO button in Delete topic popup")
	public void click_no_button_in_delete_topic_popup() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[normalize-space(text())='No']")));
		ele1 = driver.findElement(By.xpath("//button[normalize-space(text())='No']"));
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
		System.out.println("Success message displayed like: " + actualMessage);
		String expectedMessage="Topic deleted successfully!";
		Assert.assertEquals("Delete topic is not working", actualMessage, expectedMessage);
	}

	@Given("Click add button in Question Type tab")
	public void click_add_button_in_question_type_tab() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//button[@title='Click here to Add Question Type']")));
		ele1 = driver.findElement(By.xpath("//button[@title='Click here to Add Question Type']"));
		ele1.click();
	}

	@Then("Click add button in add Question Type popup")
	public void click_add_button_in_add_question_type_popup() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//button[contains(@class,'btn btn-outline-primary')]")));
		ele1 = driver.findElement(By.xpath("//button[contains(@class,'btn btn-outline-primary')]"));
		ele1.click();
	}

	@Then("Click close button in add Question Type popup")
	public void click_close_button_in_add_question_type_popup() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='modal-header']//div)[3]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='modal-header']//div)[3]"));
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
			System.out.println("Error getting border color: " + e.getMessage());
		}
		String expectedBorderColor = "rgb(255, 0, 0)";
		System.out.println("Actual border color : " + borderColor);
		if (borderColor.toLowerCase().equals(expectedBorderColor.toLowerCase())) {
			System.out
					.println("Tab border color is as expected as RED colour with color code : " + expectedBorderColor);
		} else {
			System.out.println(
					"Tab border color is incorrect. Expected: " + expectedBorderColor + ", Actual: " + borderColor);
		}
		Assert.assertEquals("Red border is not displayed in question type pop up", borderColor, expectedBorderColor);
	}

	@Then("Enter valid question type in add Question Type popup")
	public void enter_valid_question_type_in_add_question_type_popup() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='Question Type']")));
		ele1 = driver.findElement(By.xpath("//input[@placeholder='Question Type']"));
		ele1.sendKeys("Test Type");
	}

	@Then("Check success message is displayed or not in add Question Type popup")
	public void check_success_message_is_displayed_or_not_in_add_question_type_popup() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actualMessage = ele1.getText();
		System.out.println("Success message displayed like: " + actualMessage);
		String expectedMessage="Question Type added successfully!";
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
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Test Type']"));
		ele2.click();
	}
	
	@Given("Select any Question Type from dropdown")
	public void select_any_question_type_from_dropdown() throws InterruptedException {
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

	@Then("Select any topic from the dropdown in create questions")
	public void select_any_topic_from_the_dropdown_in_create_questions() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Test Topic']"));
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
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Test Topics']"));
		ele2.click();
	}

	@Then("Click edit button in Question Type tab")
	public void click_edit_button_in_question_type_tab() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//button[@title='Click here to Edit Question Type']")));
		ele1 = driver.findElement(By.xpath("//button[@title='Click here to Edit Question Type']"));
		ele1.click();
	}

	@Then("Click Close button in edit Question Type popup")
	public void click_close_button_in_edit_question_type_popup() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='modal-header']//div)[3]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='modal-header']//div)[3]"));
		ele1.click();
	}

	@Then("Modify valid subject name in edit Question Type popup")
	public void modify_valid_subject_name_in_edit_question_type_popup() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("questType")));
		ele1 = driver.findElement(By.id("questType"));
		String text = ele1.getDomProperty("value");
		int length = text.length();
		for (int i = 0; i < length; i++) {
			ele1.sendKeys(Keys.BACK_SPACE);
		}
		ele1.sendKeys(text+"s");
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
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[normalize-space(text())='Update']")));
		ele1 = driver.findElement(By.xpath("//button[normalize-space(text())='Update']"));
		ele1.click();
	}

	@Then("Check success message is displayed or not in edit Question Type")
	public void check_success_message_is_displayed_or_not_in_edit_question_type() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actualMessage = ele1.getText();
		System.out.println("Success message displayed like: " + actualMessage);
		String expectedMessage="Question Type updated successfully!";
		Assert.assertEquals("Add question type is not working", actualMessage, expectedMessage);
	}

	@Then("Click Delete button in Question Type tab")
	public void click_delete_button_in_question_type_tab() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//button[@title='Click here to Delete Question Type']")));
		ele1 = driver.findElement(By.xpath("//button[@title='Click here to Delete Question Type']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}

	@Then("Click Close button in Delete Question Type popup")
	public void click_close_button_in_delete_question_type_popup() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='modal-header']//div)[3]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='modal-header']//div)[3]"));
		ele1.click();
	}

	@Then("Click NO button in Delete Question Type popup")
	public void click_no_button_in_delete_question_type_popup() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[normalize-space(text())='No']")));
		ele1 = driver.findElement(By.xpath("//button[normalize-space(text())='No']"));
		ele1.click();
	}

	@Then("Click YES button in Delete Question Type popup")
	public void click_yes_button_in_delete_question_type_popup() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[normalize-space(text())='Yes']")));
		ele1 = driver.findElement(By.xpath("//button[normalize-space(text())='Yes']"));
		ele1.click();
	}

	@Then("Check success message is displayed or not in Question Type")
	public void check_success_message_is_displayed_or_not_in_question_type() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actualMessage = ele1.getText();
		System.out.println("Success message displayed like: " + actualMessage);
		String expectedMessage="Question Type deleted successfully!";
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

	@Then("Select any option in topic")
	public void select_any_option_in_topic() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[@class='react-select__value-container react-select__value-container--has-value css-1hwfws3'])[2]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[@class='react-select__value-container react-select__value-container--has-value css-1hwfws3'])[2]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Deep Learning']"));
		ele2.click();
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
		String filepath = "C:\\Users\\thirumaran\\eclipse-workspace\\NexTestify_Cucumber\\Files\\Audio File.mp3";
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
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='text-center mt-2 col-xl-8 col-lg-8']")));
		ele1 = driver.findElement(By.xpath("//div[@class='text-center mt-2 col-xl-8 col-lg-8']"));
		boolean displayed = ele1.isDisplayed();
		if (displayed == true) {
			System.out.println("Image is uploaded");
		} else {
			System.out.println("Image is not uploaded");
		}
		Assert.assertTrue("Image File is not uploaded", displayed);
	}

	@Then("Check file is uploaded or not in audio field")
	public void check_file_is_uploaded_or_not_in_audio_field() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("(//div[@class='d-flex flex-column align-items-center text-white mt-2'])[1]")));
		ele1 = driver
				.findElement(By.xpath("(//div[@class='d-flex flex-column align-items-center text-white mt-2'])[1]"));
		boolean displayed = ele1.isDisplayed();
		if (displayed == true) {
			System.out.println("Audio is uploaded");
		} else {
			System.out.println("Audio is not uploaded");
		}
		Assert.assertTrue("Audio File is not uploaded", displayed);
	}

	@Then("Check file is uploaded or not in video field")
	public void check_file_is_uploaded_or_not_in_video_field() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//div[contains(@class,'d-flex flex-column')])[2]")));
		ele1 = driver.findElement(By.xpath("(//div[contains(@class,'d-flex flex-column')])[2]"));
		boolean displayed = ele1.isDisplayed();
		if (displayed == true) {
			System.out.println("Video is uploaded");
		} else {
			System.out.println("Video is not uploaded");
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
		System.out.println("Success message displayed like: " + actualMessage);
		String expMessage="Invalid file format!";
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
		String filepath = "C:\\Users\\thirumaran\\eclipse-workspace\\NexTestify_Cucumber\\Files\\Sample.png";
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
		System.out.println("Success message displayed like: " + actualMessage);
		String expMessage="Invalid file format!";
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
		String filepath = "C:\\Users\\thirumaran\\eclipse-workspace\\NexTestify_Cucumber\\Files\\Sample.png";
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
		System.out.println("Success message displayed like: " + actualMessage);
		String expMessage="Invalid file format!";
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
		String filepath = "C:\\Users\\thirumaran\\eclipse-workspace\\NexTestify_Cucumber\\Files\\Sample.png";
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
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actualMessage = ele1.getText();
		System.out.println("Success message displayed like: " + actualMessage);
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
		String filepath = "C:\\Users\\thirumaran\\eclipse-workspace\\NexTestify_Cucumber\\Files\\Audio File.mp3";
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
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actualMessage = ele1.getText();
		System.out.println("Success message displayed like: " + actualMessage);
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
		String filepath = "C:\\Users\\thirumaran\\eclipse-workspace\\NexTestify_Cucumber\\Files\\Video File.mp4";
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
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actualMessage = ele1.getText();
		System.out.println("Success message displayed like: " + actualMessage);
	}

	@Then("Click delete button in image field")
	public void click_delete_button_in_image_field() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//button[contains(@class,'btn-icon btn-icon-start')])[1]")));
		ele1 = driver.findElement(By.xpath("(//button[contains(@class,'btn-icon btn-icon-start')])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}

	@Then("Check file is removed or not in image field")
	public void check_file_is_removed_or_not_in_image_field() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//div[contains(@class,'text-center mt-2')]")));
		ele1 = driver.findElement(By.xpath("//div[contains(@class,'text-center mt-2')]"));
		boolean displayed = ele1.isDisplayed();
		if (displayed == false) {
			System.out.println("Image is removed");
		} else {
			System.out.println("Image is not removed");
		}
		Assert.assertFalse("Image file is not able to delete", displayed);
	}

	@Then("Click delete button in audio field")
	public void click_delete_button_in_audio_field() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//button[contains(@class,'btn-icon btn-icon-start')])[2]")));
		ele1 = driver.findElement(By.xpath("(//button[contains(@class,'btn-icon btn-icon-start')])[2]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}

	@Then("Check file is removed or not in audio field")
	public void check_file_is_removed_or_not_in_audio_field() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//div[@class='d-flex flex-column align-items-center text-white mt-2'])[1]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='d-flex flex-column align-items-center text-white mt-2'])[1]"));
		boolean displayed = ele1.isDisplayed();
		System.out.println("Item displayed status is: "+displayed);
		if (displayed == true) {
			System.out.println("Audio is removed");
		} else {
			System.out.println("Audio is not removed");
		}
		Assert.assertTrue("Audio file is not able to delete", displayed);
	}

	@Then("Click delete button in video field")
	public void click_delete_button_in_video_field() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//button[contains(@class,'btn-icon btn-icon-start')])[3]")));
		ele1 = driver.findElement(By.xpath("(//button[contains(@class,'btn-icon btn-icon-start')])[3]"));
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
			System.out.println("Video is removed");
		} else {
			System.out.println("Video is not removed");
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

	@Then("Enter valid details in question text box")
	public void enter_valid_details_in_question_text_box() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='ql-editor ql-blank'])[1]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.sendKeys("Test Questions");
	}

	@Then("Perform and check all features in the question text box")
	public void perform_and_check_all_features_in_the_question_text_box() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-header'])[1]")));
		ele1 = driver.findElement(By.xpath("(//button[@class='ql-header'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='ql-header ql-active']")));
		ele2 = driver.findElement(By.xpath("//button[@class='ql-header ql-active']"));
		ele2.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-list'])[1]")));
		ele3 = driver.findElement(By.xpath("(//button[@class='ql-list'])[1]"));
		ele3.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-list'])[2]")));
		ele4 = driver.findElement(By.xpath("(//button[@class='ql-list'])[2]"));
		ele4.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//span[contains(@class,'ql-align ql-picker')])[1]")));
		ele5 = driver.findElement(By.xpath("(//span[contains(@class,'ql-align ql-picker')])[1]"));
		ele5.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-bold'])[1]")));
		ele6 = driver.findElement(By.xpath("(//button[@class='ql-bold'])[1]"));
		ele6.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-italic'])[1]")));
		ele7 = driver.findElement(By.xpath("(//button[@class='ql-italic'])[1]"));
		ele7.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-underline'])[1]")));
		ele8 = driver.findElement(By.xpath("(//button[@class='ql-underline'])[1]"));
		ele8.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-strike'])[1]")));
		ele9 = driver.findElement(By.xpath("(//button[@class='ql-strike'])[1]"));
		ele9.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-clean'])[1]")));
		WebElement ele10 = driver.findElement(By.xpath("(//button[@class='ql-clean'])[1]"));
		ele10.click();
	}

	@Then("Enter valid details in answers text box")
	public void enter_valid_details_in_answers_text_box() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='ql-editor ql-blank'])[2]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[2]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.sendKeys("Test Answers");
	}

	@Then("Perform and check all features in the answers text box")
	public void perform_and_check_all_features_in_the_answers_text_box() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-header'])[2]")));
		ele1 = driver.findElement(By.xpath("(//button[@class='ql-header'])[2]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-header'])[3]")));
		ele2 = driver.findElement(By.xpath("(//button[@class='ql-header'])[3]"));
		ele2.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-list'])[3]")));
		ele3 = driver.findElement(By.xpath("(//button[@class='ql-list'])[3]"));
		ele3.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@value='bullet'])[2]")));
		ele4 = driver.findElement(By.xpath("(//button[@value='bullet'])[2]"));
		ele4.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//span[contains(@class,'ql-align ql-picker')])[2]")));
		ele5 = driver.findElement(By.xpath("(//span[contains(@class,'ql-align ql-picker')])[2]"));
		ele5.click();
		Thread.sleep(2000);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-bold'])[2]")));
		ele6 = driver.findElement(By.xpath("(//button[@class='ql-bold'])[2]"));
		ele6.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-italic'])[2]")));
		ele7 = driver.findElement(By.xpath("(//button[@class='ql-italic'])[2]"));
		ele7.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-underline'])[2]")));
		ele8 = driver.findElement(By.xpath("(//button[@class='ql-underline'])[2]"));
		ele8.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-strike'])[2]")));
		ele9 = driver.findElement(By.xpath("(//button[@class='ql-strike'])[2]"));
		ele9.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-clean'])[2]")));
		WebElement ele10 = driver.findElement(By.xpath("(//button[@class='ql-clean'])[2]"));
		ele10.click();
	}

	@Then("Enter valid details in remarks text box in add questions")
	public void enter_valid_details_in_remarks_text_box_in_add_questions() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='ql-editor ql-blank'])[3]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[3]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.sendKeys("Test Remarks");
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

	@Then("Enter valid details in Explanation text box")
	public void enter_valid_details_in_explanation_text_box() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='ql-editor ql-blank'])[1]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.sendKeys("Test Explanation");
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
		String filepath = "C:\\Users\\thirumaran\\eclipse-workspace\\NexTestify_Cucumber\\Files\\Sample.png";
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
		String filepath = "C:\\Users\\thirumaran\\eclipse-workspace\\NexTestify_Cucumber\\Files\\Audio File.mp3";
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
		String filepath = "C:\\Users\\thirumaran\\eclipse-workspace\\NexTestify_Cucumber\\Files\\Video File.mp4";
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

	@Then("Enter valid question details for essay type")
	public void enter_valid_question_details_for_essay_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='ql-editor ql-blank'])[1]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.sendKeys("Test Questions");
	}

	@Then("Enter valid answer details for essay type")
	public void enter_valid_answer_details_for_essay_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='ql-editor ql-blank'])[1]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.sendKeys("Test Answers");
	}

	@Then("Enter valid remarks details for essay type")
	public void enter_valid_remarks_details_for_essay_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='ql-editor ql-blank'])[1]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.sendKeys("Test Remarks");
	}

	@Then("Enter valid points for answer for essay type")
	public void enter_valid_points_for_answer_for_essay_type() throws InterruptedException {
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

	@Then("Enter valid time for essay type")
	public void enter_valid_time_for_essay_type() throws InterruptedException {
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

	@Then("Click clear button for essay type")
	public void click_clear_button_for_essay_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='click here to clear']")));
		ele1 = driver.findElement(By.xpath("//button[@title='click here to clear']"));
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
		System.out.println("Actual text is: " + actualtext);
		String expectedText = "Please Select";
		Assert.assertEquals("Clear button is not working", actualtext, expectedText);
	}

	@Then("Click save button for essay type")
	public void click_save_button_for_essay_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='click here to save']")));
		ele1 = driver.findElement(By.xpath("//button[@title='click here to save']"));
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
		System.out.println("Success message displayed like: " + actualMessage);
		String expMessage="Question & Answer saved successfully!";
		Assert.assertEquals("Save button is not working", actualMessage, expMessage);
	}

	@Then("Enter valid question details for fill in the blanks type")
	public void enter_valid_question_details_for_fill_in_the_blanks_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='ql-editor ql-blank'])[1]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.sendKeys("Test Questions");
	}

	@Then("Enter valid answer details for fill in the blanks type")
	public void enter_valid_answer_details_for_fill_in_the_blanks_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("fillBlank")));
		ele1 = driver.findElement(By.id("fillBlank"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.sendKeys("Test Answers");
	}

	@Then("Enter valid explanation details for fill in the blanks type")
	public void enter_valid_explanation_details_for_fill_in_the_blanks_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='ql-editor ql-blank'])[1]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.sendKeys("Test Explanation");
	}

	@Then("Enter valid remarks details for fill in the blanks type")
	public void enter_valid_remarks_details_for_fill_in_the_blanks_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='ql-editor ql-blank'])[1]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.sendKeys("Test Remarks");
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
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='click here to clear']")));
		ele1 = driver.findElement(By.xpath("//button[@title='click here to clear']"));
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
		System.out.println("Actual text is: " + actualtext);
		String expectedText = "Please Select";
		Assert.assertEquals("Clear button is not working", actualtext, expectedText);
	}

	@Then("Click save button for fill in the blanks type")
	public void click_save_button_for_fill_in_the_blanks_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='click here to save']")));
		ele1 = driver.findElement(By.xpath("//button[@title='click here to save']"));
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
		System.out.println("Success message displayed like: " + actualMessage);
		String expMessage="Question & Answer saved successfully!";
		Assert.assertEquals("Save button is not working", actualMessage, expMessage);
	}

	@Then("Enter valid question details for Multiple Choice type")
	public void enter_valid_question_details_for_multiple_choice_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='ql-editor ql-blank'])[1]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.sendKeys("Test Questions");
	}

	@Then("Enter valid answer details for Multiple Choice type")
	public void enter_valid_answer_details_for_multiple_choice_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='ql-editor ql-blank'])[2]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.sendKeys("Option 1");
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[1]"));
		ele2.sendKeys("Option 2");
		Thread.sleep(2000);
		ele3 = driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[1]"));
		ele3.sendKeys("Option 3");
	}

	@Then("Select any valid checkbox in answers field for Multiple Choice type")
	public void select_any_valid_checkbox_in_answers_field_for_multiple_choice_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("chk1")));
		ele1 = driver.findElement(By.id("chk1"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		if (ele1.isSelected()) {
			ele1.click();
		}
		Thread.sleep(2000);
		ele2 = driver.findElement(By.id("chk2"));
		ele2.click();
	}

	@Then("Enter valid explanation details for Multiple Choice type")
	public void enter_valid_explanation_details_for_multiple_choice_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='ql-editor ql-blank'])[1]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.sendKeys("Test Explanation");
	}

	@Then("Enter valid remarks details for Multiple Choice type")
	public void enter_valid_remarks_details_for_multiple_choice_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='ql-editor ql-blank'])[1]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.sendKeys("Test Remarks");
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
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='click here to clear']")));
		ele1 = driver.findElement(By.xpath("//button[@title='click here to clear']"));
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
		System.out.println("Actual text is: " + actualtext);
		String expectedText = "Please Select";
		Assert.assertEquals("Clear button is not working", actualtext, expectedText);
	}

	@Then("Click save button for Multiple Choice type")
	public void click_save_button_for_multiple_choice_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='click here to save']")));
		ele1 = driver.findElement(By.xpath("//button[@title='click here to save']"));
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
		System.out.println("Success message displayed like: " + actualMessage);
		String expMessage="Question & Answer saved successfully!";
		Assert.assertEquals("Save button is not working", actualMessage, expMessage);
	}

	@Then("Enter valid question details for Short Answer type")
	public void enter_valid_question_details_for_short_answer_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='ql-editor ql-blank'])[1]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.sendKeys("Test Questions");
	}

	@Then("Enter valid answer details for Short Answer type")
	public void enter_valid_answer_details_for_short_answer_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("Essay")));
		ele1 = driver.findElement(By.name("Essay"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.sendKeys("Test Answers");
	}

	@Then("Enter valid explanation details for Short Answer type")
	public void enter_valid_explanation_details_for_short_answer_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='ql-editor ql-blank'])[1]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.sendKeys("Test Explanation");
	}

	@Then("Enter valid remarks details for Short Answer type")
	public void enter_valid_remarks_details_for_short_answer_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='ql-editor ql-blank'])[1]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.sendKeys("Test Remarks");
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
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='click here to clear']")));
		ele1 = driver.findElement(By.xpath("//button[@title='click here to clear']"));
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
		System.out.println("Actual text is: " + actualtext);
		String expectedText = "Please Select";
		Assert.assertEquals("Clear button is not working", actualtext, expectedText);
	}

	@Then("Click save button for Short Answer type")
	public void click_save_button_for_short_answer_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='click here to save']")));
		ele1 = driver.findElement(By.xpath("//button[@title='click here to save']"));
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
		System.out.println("Success message displayed like: " + actualMessage);
		String expMessage="Question & Answer saved successfully!";
		Assert.assertEquals("Save button is not working", actualMessage, expMessage);
	}

	@Then("Enter valid question details for Single Choice type")
	public void enter_valid_question_details_for_single_choice_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='ql-editor ql-blank'])[1]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.sendKeys("Test Questions");
	}

	@Then("Enter valid answer details for Single Choice type")
	public void enter_valid_answer_details_for_single_choice_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='ql-editor ql-blank'])[1]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.sendKeys("Option 1");
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[1]"));
		ele2.sendKeys("Option 2");
		Thread.sleep(2000);
		ele3 = driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[1]"));
		ele3.sendKeys("Option 3");
	}

	@Then("Select any valid radio in answers field for Single Choice type")
	public void select_any_valid_radio_in_answers_field_for_single_choice_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("rdo1")));
		ele1 = driver.findElement(By.id("rdo1"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}

	@Then("Enter valid explanation details for Single Choice type")
	public void enter_valid_explanation_details_for_single_choice_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='ql-editor ql-blank'])[1]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.sendKeys("Test Explanation");
	}

	@Then("Enter valid remarks details for Single Choice type")
	public void enter_valid_remarks_details_for_single_choice_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='ql-editor ql-blank'])[1]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.sendKeys("Test Remarks");
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
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='click here to clear']")));
		ele1 = driver.findElement(By.xpath("//button[@title='click here to clear']"));
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
		System.out.println("Actual text is: " + actualtext);
		String expectedText = "Please Select";
		Assert.assertEquals("Clear button is not working", actualtext, expectedText);
	}

	@Then("Click save button for Single Choice type")
	public void click_save_button_for_single_choice_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='click here to save']")));
		ele1 = driver.findElement(By.xpath("//button[@title='click here to save']"));
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
		System.out.println("Success message displayed like: " + actualMessage);
		String expMessage="Question & Answer saved successfully!";
		Assert.assertEquals("Save button is not working", actualMessage, expMessage);
	}

	@Then("Enter valid question details for True or False type")
	public void enter_valid_question_details_for_true_false_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='ql-editor ql-blank'])[1]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.sendKeys("Test Questions");
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

	@Then("Select any valid radio in answers field for True or False type")
	public void select_any_valid_radio_in_answers_field_for_true_false_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("rdo6")));
		ele1 = driver.findElement(By.id("rdo6"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}

	@Then("Enter valid explanation details for True or False type")
	public void enter_valid_explanation_details_for_true_false_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='ql-editor ql-blank'])[1]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.sendKeys("Test Explanation");
	}

	@Then("Enter valid remarks details for True or False type")
	public void enter_valid_remarks_details_for_true_false_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='ql-editor ql-blank'])[1]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.sendKeys("Test Remarks");
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
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='click here to clear']")));
		ele1 = driver.findElement(By.xpath("//button[@title='click here to clear']"));
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
		System.out.println("Actual text is: " + actualtext);
		String expectedText = "Please Select";
		Assert.assertEquals("Clear button is not working", actualtext, expectedText);
	}

	@Then("Click save button for True or False type")
	public void click_save_button_for_true_or_false_type() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='click here to save']")));
		ele1 = driver.findElement(By.xpath("//button[@title='click here to save']"));
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
		System.out.println("Success message displayed like: " + actualMessage);
		String expMessage="Question & Answer saved successfully!";
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
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='ql-editor ql-blank'])[1]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		String tabvalue = ele1.getText();
		System.out.println("Tab value is: " + tabvalue);
		boolean checktabvalue = tabvalue.trim().isEmpty();
		Assert.assertTrue("Tab is not empty.", checktabvalue);
	}

	@Given("Search valid question name in search field")
	public void search_valid_question_name_in_search_field() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("txtSearch")));
		ele1 = driver.findElement(By.name("txtSearch"));
		ele1.sendKeys("Write an Essay about AI");
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
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//button[@type='button'])[2]")));
		Thread.sleep(2000);
		ele1 = driver.findElement(By.xpath("(//button[@type='button'])[2]"));
		ele1.click();
	}

	@Then("Click view questions button in edit question page")
	public void click_view_questions_button_in_edit_question_page() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//button[@title='click here to view questions']")));
		ele1 = driver.findElement(By.xpath("//button[@title='click here to view questions']"));
		ele1.click();
	}

	@Then("Click clear button in edit question page")
	public void click_clear_button_in_edit_question_page() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='click here to clear']")));
		ele1 = driver.findElement(By.xpath("//button[@title='click here to clear']"));
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
		System.out.println("Actual text is: " + actualtext);
		String expectedText = "Please Select";
		Assert.assertEquals("Clear button is not working", actualtext, expectedText);
	}

	@Then("Modify valid details in any tab")
	public void modify_valid_details_in_any_tab() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='ql-editor'])[1]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='ql-editor'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		String actualDetail = ele1.getText();
		System.out.println("Actual text is: " + actualDetail);
		Thread.sleep(2000);
		ele1.clear();
		Thread.sleep(2000);
		ele1.sendKeys(actualDetail);
	}

	@Then("Click update button in edit question page")
	public void click_update_button_in_edit_question_page() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='click here to save']")));
		ele1 = driver.findElement(By.xpath("//button[@title='click here to save']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}

	@Then("Check success message is displayed or not in edit question page")
	public void check_success_message_is_displayed_or_not_in_edit_question_page() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actualMessage = ele1.getText();
		System.out.println("Success message displayed like: " + actualMessage);
		String expMessage="Question & Answer updated successfully!";
		Assert.assertEquals("Save button is not working", actualMessage, expMessage);
	}

}