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

import com.github.javafaker.Artist;
import com.github.javafaker.Faker;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OEP_3_StudyMaterial {
	public WebDriver driver;
	public WebElement ele, ele1, ele2, ele3, ele4, ele5, ele6, ele7, ele8, ele9;
	public WebDriverWait wait;

	@Given("To Check Study Material is navigating to OEP URL is {string}")
	public void to_check_study_material_is_navigating_to_oep_url_is(String url) {
		System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--headless=new");
		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get(url);
	}

	@When("To Check Study Material Enter username and password are {string} and {string}")
	public void to_check_study_material_enter_username_and_password_are_and(String username, String password) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("email")));
		ele1 = driver.findElement(By.name("email"));
		ele1.clear();
		ele1.sendKeys(username);
		ele2 = driver.findElement(By.name("password"));
		ele2.clear();
		ele2.sendKeys(password);
	}

	@When("click the Signin button To Check Study Material")
	public void click_the_signin_button_to_check_study_material() {
		ele1 = driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
		ele1.click();
	}

	@Then("Close Study Material button")
	public void close_study_material_button() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
		System.out.print("Page is closed");
	}

	@Then("Click Study Material button")
	public void click_Study_Material_button() throws InterruptedException {
		Thread.sleep(4000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//span[normalize-space(text())='Study Material'])[1]")));
		ele1 = driver.findElement(By.xpath("(//span[normalize-space(text())='Study Material'])[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(ele1).build().perform();
		ele1.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//span[normalize-space(text())='Study Material'])[2]")));
		ele2 = driver.findElement(By.xpath("(//span[normalize-space(text())='Study Material'])[2]"));
		ele2.click();
		Thread.sleep(2000);
		driver.navigate().refresh();
	}

	@Given("Click any subject name")
	public void click_any_subject_name() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//button[normalize-space(text())='Artificial Intelligence']")));
		ele1 = driver.findElement(By.xpath("//button[normalize-space(text())='Artificial Intelligence']"));
		ele1.click();
	}

	@When("Click any topic button")
	public void click_any_topic_button() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//button[normalize-space(text())='1. Smart Contracts']")));
		ele1 = driver.findElement(By.xpath("//button[normalize-space(text())='1. Smart Contracts']"));
		ele1.click();
	}

	@When("Click add material button")
	public void click_add_material_button() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//button[@title='click here to new study material']")));
		ele1 = driver.findElement(By.xpath("//button[@title='click here to new study material']"));
		ele1.click();
	}

	@When("Click view material button")
	public void click_view_material_button() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//button[normalize-space(text())='View Material']")));
		ele1 = driver.findElement(By.xpath("//button[normalize-space(text())='View Material']"));
		ele1.click();
	}

	@When("Click save button in add material")
	public void click_save_button_in_add_material() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='click here to save']")));
		ele1 = driver.findElement(By.xpath("//button[@title='click here to save']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}

	@Then("Select valid topic name")
	public void select_valid_topic_name() throws InterruptedException {
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

	@Then("Enter valid chapter name")
	public void enter_valid_chapter_name() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("chapter")));
		ele1 = driver.findElement(By.id("chapter"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		Faker fakename = new Faker();
		String fullName = fakename.name().fullName();
		ele1.sendKeys("Test Chapter for automation testing created by - " + fullName + "Sample Tester");
	}

	@Then("Enter valid synopsis")
	public void enter_valid_synopsis() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='ql-editor ql-blank']")));
		ele1 = driver.findElement(By.xpath("//div[@class='ql-editor ql-blank']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.sendKeys("Test Synopsis");
	}

	@When("Select valid subject name in create material")
	public void select_valid_subject_name_in_create_material() throws InterruptedException {
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

	@Then("Click take picture button in Study Material")
	public void click_take_picture_button_in_Study_Material() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//button[normalize-space(text())='Take Picture']")));
		ele1 = driver.findElement(By.xpath(
				"//button[normalize-space(text())='Take Picture']"));
		ele1.click();
	}
	
	@Then("Select valid topic name in create material")
	public void select_valid_topic_name_in_create_material() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Block Chain']"));
		ele2.click();
	}

	@Then("Click clear button in add material")
	public void click_clear_button_in_add_material() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(),'Clear')]")));
		ele1 = driver.findElement(By.xpath("//button[contains(text(),'Clear')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}

	@Then("Click clear button in edit question")
	public void click_clear_button_in_edit_question() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(),'Clear')]")));
		ele1 = driver.findElement(By.xpath("//button[contains(text(),'Clear')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}

	@Then("Click update button in edit question")
	public void click_update_button_in_edit_question() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(text(),'Update')]")));
		ele1 = driver.findElement(By.xpath("//button[contains(text(),'Update')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}

	@Then("Check details are cleared or not in add material")
	public void check_details_are_cleared_or_not_in_add_material() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("chapterName")));
		ele1 = driver.findElement(By.name("chapterName"));
		String chapterNameTab = ele1.getDomProperty("value");
		System.out.println("Chapter tab has: " + chapterNameTab);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='ql-editor ql-blank']")));
		ele2 = driver.findElement(By.xpath("//div[@class='ql-editor ql-blank']"));
		String synopsisTab = ele2.getDomProperty("value");
		System.out.println("synopsisTab has: " + synopsisTab);

		if (chapterNameTab.isEmpty()) {
			System.out.println("All tabs are cleared and clear button is working");
		} else {
			System.out.println("clear button is not working");
		}

		Assert.assertTrue("Clear button is not working", chapterNameTab.isEmpty());
	}

	@Then("Check details are cleared or not in edit question")
	public void check_details_are_cleared_or_not_in_edit_material() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='ql-editor ql-blank'])[1]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='ql-editor ql-blank'])[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		String questionTab = ele1.getText();
		System.out.println("Chapter tab has: " + questionTab);
		if (questionTab.isBlank()) {
			System.out.println("All tabs are cleared and clear button is working");
		} else {
			System.out.println("clear button is not wrking");
		}
		Assert.assertTrue("Clear button is not working", questionTab.isBlank());
	}

	@Then("Check mandatory red border is displayed or not in add material")
	public void check_mandatory_red_border_is_displayed_or_not_in_add_material() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//div[@class='react-select__value-container css-1hwfws3']")));
		ele2 = driver.findElement(By.xpath("//div[@class='react-select__value-container css-1hwfws3']"));
		ele3 = driver.findElement(By.id("chapter"));

		String borderColor2, borderColor3;
		try {
			borderColor2 = ele2.getCssValue("border-color");
			borderColor3 = ele3.getCssValue("border-color");
		} catch (Exception e) {
			borderColor2 = "not available";
			borderColor3 = "not available";
			System.out.println("Error getting border color: " + e.getMessage());
		}
		String expectedBorderColor1 = "rgb(78, 78, 78)";
		String expectedBorderColor2 = "rgb(255, 0, 0)";
		System.out.println("Actual border color : " + borderColor2);
		System.out.println("Actual border color : " + borderColor3);
		if (borderColor2.toLowerCase().equals(expectedBorderColor1.toLowerCase())) {
			System.out.println(
					"2nd Tab border color is as expected as RED colour with color code : " + expectedBorderColor1);
		} else {
			System.out.println("2nd Tab border color is incorrect. Expected: " + expectedBorderColor1 + ", Actual: "
					+ borderColor2);
		}
		if (borderColor3.toLowerCase().equals(expectedBorderColor2.toLowerCase())) {
			System.out.println(
					"3rd Tab border color is as expected as RED colour with color code : " + expectedBorderColor2);
		} else {
			System.out.println("3rd Tab border color is incorrect. Expected: " + expectedBorderColor2 + ", Actual: "
					+ borderColor3);
		}
		Assert.assertEquals("Red border is not displayed in mandatory field", borderColor2, expectedBorderColor1);
		Assert.assertEquals("Red border is not displayed in mandatory field", borderColor3, expectedBorderColor2);
	}

	@Then("Check mandatory red border is displayed or not in add material page")
	public void check_mandatory_red_border_is_displayed_or_not_in_add_material_Page() throws InterruptedException {
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]")));
		ele2 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]"));
		ele3 = driver.findElement(By.id("chapter"));

		String borderColor2, borderColor3;
		try {
			borderColor2 = ele2.getCssValue("border-color");
			borderColor3 = ele3.getCssValue("border-color");
		} catch (Exception e) {
			borderColor2 = "not available";
			borderColor3 = "not available";
			System.out.println("Error getting border color: " + e.getMessage());
		}
		String expectedBorderColor1 = "rgb(78, 78, 78)";
		String expectedBorderColor2 = "rgb(255, 0, 0)";
		System.out.println("Actual border color : " + borderColor2);
		System.out.println("Actual border color : " + borderColor3);
		if (borderColor2.toLowerCase().equals(expectedBorderColor1.toLowerCase())) {
			System.out.println(
					"2nd Tab border color is as expected as RED colour with color code : " + expectedBorderColor1);
		} else {
			System.out.println("2nd Tab border color is incorrect. Expected: " + expectedBorderColor1 + ", Actual: "
					+ borderColor2);
		}
		if (borderColor3.toLowerCase().equals(expectedBorderColor2.toLowerCase())) {
			System.out.println(
					"3rd Tab border color is as expected as RED colour with color code : " + expectedBorderColor2);
		} else {
			System.out.println("3rd Tab border color is incorrect. Expected: " + expectedBorderColor2 + ", Actual: "
					+ borderColor3);
		}
		Assert.assertEquals("Red border is not displayed in mandatory field", borderColor2, expectedBorderColor1);
		Assert.assertEquals("Red border is not displayed in mandatory field", borderColor3, expectedBorderColor2);
	}

	@When("Check all features are working or not in the text box")
	public void check_all_features_are_working_or_not_in_the_text_box() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-header'])[1]")));
		ele1 = driver.findElement(By.xpath("(//button[@class='ql-header'])[1]"));
		ele1.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-list'])[1]")));
		ele3 = driver.findElement(By.xpath("(//button[@class='ql-list'])[1]"));
		ele3.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[@class='ql-picker-label'])[2]")));
		ele5 = driver.findElement(By.xpath("(//span[@class='ql-picker-label'])[2]"));
		ele5.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-bold'])[1]")));
		ele6 = driver.findElement(By.xpath("(//button[@class='ql-bold'])[1]"));
		ele6.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-italic'])[1]")));
		ele7 = driver.findElement(By.xpath("(//button[@class='ql-italic'])[1]"));
		ele7.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-underline'])[1]")));
		ele8 = driver.findElement(By.xpath("(//button[@class='ql-underline'])[1]"));
		ele8.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-strike'])[1]")));
		ele9 = driver.findElement(By.xpath("(//button[@class='ql-strike'])[1]"));
		ele9.click();
	}

	@Then("Check alert message is displayed or not in add subject in create material")
	public void check_alert_message_is_displayed_or_not_in_add_subject_in_create_material()
			throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actMessage = ele1.getText();
		System.out.println("Error message displayed like: " + actMessage);
		String expMessage = "Subject already exist!";
		Assert.assertEquals("Error message is not displayed", actMessage, expMessage);

	}

	@Then("Check success message is displayed or not in edit subject in create material")
	public void check_alert_message_is_displayed_or_not_in_edit_subject_in_create_material()
			throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actMsg = ele1.getText();
		System.out.println("Error message displayed like: " + actMsg);
		String expMsg = "Subject updated successfully!";
		Assert.assertEquals("Error message is not displayed", actMsg, expMsg);
	}

	@When("Click add button in the subject tab")
	public void click_add_button_in_the_subject_tab() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Click here to Add Category']")));
		ele1 = driver.findElement(By.xpath("//button[@title='Click here to Add Category']"));
		ele1.click();
	}

	@Then("Click close button in add subject")
	public void click_close_button_in_add_subject() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='modal-header']//div)[3]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='modal-header']//div)[3]"));
		ele1.click();
	}

	@Then("Click save button in add subject")
	public void click_save_button_in_add_subject() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//button[contains(@class,'btn btn-outline-primary')]")));
		ele1 = driver.findElement(By.xpath("//button[contains(@class,'btn btn-outline-primary')]"));
		ele1.click();
	}

	@Then("Check mandatory red border is displayed or not in add subject")
	public void check_mandatory_red_border_is_displayed_or_not_in_add_subject() throws InterruptedException {
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
		} else {
			System.out.println(
					"Tab border color is incorrect. Expected: " + expectedBorderColor + ", Actual: " + borderColor);
		}
		Assert.assertEquals("Red border is not displayed in the mandatory field", borderColor, expectedBorderColor);
	}

	@Then("Enter existing subject name in add subject")
	public void enter_existing_subject_name_in_add_subject() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("catName")));
		ele1 = driver.findElement(By.id("catName"));
		ele1.sendKeys("Artificial Intelligence");
	}

	@Then("Enter valid subject name in add subject")
	public void enter_valid_subject_name_in_add_subject() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("catName")));
		ele1 = driver.findElement(By.id("catName"));
		ele1.sendKeys("Test Subject");
	}

	@When("Select any subject from the dropdown in the subject tab")
	public void select_any_subject_from_the_dropdown_in_the_subject_tab() throws InterruptedException {
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

	@Then("Click edit button of the subject tab")
	public void click_edit_button_of_the_subject_tab() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//button[@title='Click here to Edit Category']")));
		ele1 = driver.findElement(By.xpath("//button[@title='Click here to Edit Category']"));
		ele1.click();
	}

	@Then("Click Close button in edit subject")
	public void click_close_button_in_edit_subject() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='modal-header']//div)[3]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='modal-header']//div)[3]"));
		ele1.click();
	}

	@Then("Modify valid subject name in edit subject")
	public void modify_valid_subject_name_in_edit_subject() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("catName")));
		ele1 = driver.findElement(By.id("catName"));
		String subjectName = ele1.getDomAttribute("value");
		System.out.println("Subject name is: " + subjectName);
		int length = subjectName.length();
		for (int i = 0; i < length; i++) {
			ele1.sendKeys(Keys.BACK_SPACE);
		}
		ele1.sendKeys(subjectName);
	}

	@Then("Click Update button in edit subject")
	public void click_update_button_in_edit_subject() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[normalize-space(text())='Update']")));
		ele1 = driver.findElement(By.xpath("//button[normalize-space(text())='Update']"));
		ele1.click();
	}

	@Then("Click delete button of the subject tab")
	public void click_delete_button_of_the_subject_tab() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//button[@title='Click here to Delete Category']")));
		ele1 = driver.findElement(By.xpath("//button[@title='Click here to Delete Category']"));
		ele1.click();
	}

	@Then("Click close button in delete popup")
	public void click_close_button_in_delete_popup() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='modal-header']//div)[3]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='modal-header']//div)[3]"));
		ele1.click();
	}

	@Then("Click No button in the delete subject popup")
	public void click_no_button_in_the_delete_subject_popup() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[normalize-space(text())='No']")));
		ele1 = driver.findElement(By.xpath("//button[normalize-space(text())='No']"));
		ele1.click();
	}

	@Then("Click Yes button in the delete subject popup")
	public void click_yes_button_in_the_delete_subject_popup() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[normalize-space(text())='Yes']")));
		ele1 = driver.findElement(By.xpath("//button[normalize-space(text())='Yes']"));
		ele1.click();
	}

	@Then("Click add button in topic tab in create material page")
	public void click_add_button_in_topic_tab_in_create_material_page() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Click here to Add Topic']")));
		ele1 = driver.findElement(By.xpath("//button[@title='Click here to Add Topic']"));
		ele1.click();
	}

	@Then("Click Close button in topic tab")
	public void click_close_button_in_topic_tab() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='modal-header']//div)[3]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='modal-header']//div)[3]"));
		ele1.click();
	}

	@When("Click back button in study material page")
	public void click_back_button_in_study_material_page() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='click here to back']")));
		ele1 = driver.findElement(By.xpath("//button[@title='click here to back']"));
		ele1.click();
	}

	@Then("Check landing page in study material page")
	public void check_landing_page_in_study_material_page() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[@class='fs-16 text-primary']")));
		ele1 = driver.findElement(By.xpath("//h1[@class='fs-16 text-primary']"));
		String actText = ele1.getText();
		String expText = "Study Material >> Study Material";
		Assert.assertEquals("Page desnot navigates to study material page", actText, expText);
	}

	@Then("Check page navigates to view material page or not")
	public void check_page_navigates_to_view_material_page_or_not() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[contains(@class,'btn btn-sm')])[1]")));
		ele1 = driver.findElement(By.xpath("(//button[contains(@class,'btn btn-sm')])[1]"));
		boolean isDisplayed = ele1.isDisplayed();
		Assert.assertTrue("Page desnot navigates to study material page", isDisplayed);
	}

	@Then("Click add button in add topic tab")
	public void click_add_button_in_add_topic_tab() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[normalize-space(text())='Add'])[3]")));
		ele1 = driver.findElement(By.xpath("(//button[normalize-space(text())='Add'])[3]"));
		ele1.click();
	}

	@Then("Check mandatory message is displayed or not in topic tab")
	public void check_mandatory_message_is_displayed_or_not_in_topic_tab() throws InterruptedException {
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
		Assert.assertEquals("Red border is not displayed in mandatory fields", borderColor, expectedBorderColor);
	}

	@Then("Enter valid topic name in add topic tab")
	public void enter_valid_topic_name_in_add_topic_tab() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("topicName")));
		ele1 = driver.findElement(By.id("topicName"));
		ele1.sendKeys("Test Topic");
	}

	@Then("Select any topic name from the dropdown in topic tab")
	public void select_any_topic_name_from_the_dropdown_in_topic_tab() throws InterruptedException {
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
	
	@Then("Select valid subject name in add topic pop up in add material page")
	public void select_valid_subject_name_in_add_topic_pop_up_in_add_material_page() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[3]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[3]"));
		Thread.sleep(2000);
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Artificial Intelligence']"));
		Thread.sleep(2000);
		ele2.click();
	}
	
	@Then("Select any topic name from the dropdown in topic")
	public void select_any_topic_name_from_the_dropdown_in_topic() throws InterruptedException {
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

	@Then("Select any topic name from the dropdown in the topic tab")
	public void select_any_topic_name_from_the_dropdown_in_the_topic_tab() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]")));
		ele1 = driver.findElement(By.xpath(
				"(//div[contains(@class,'react-select__value-container react-select__value-container--has-value')])[2]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Sample']"));
		ele2.click();
	}

	@Then("Click close button in edit topic tab")
	public void click_close_button_in_edit_topic_tab() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='modal-header']//div)[3]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='modal-header']//div)[3]"));
		ele1.click();
	}

	@Then("Click edit button in topic tab in create material page")
	public void click_edit_button_in_topic_tab_in_create_material_page() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Click here to Edit Topic']")));
		ele1 = driver.findElement(By.xpath("//button[@title='Click here to Edit Topic']"));
		ele1.click();
	}

	@Then("Modify valid topic details in edit topic tab")
	public void modify_valid_topic_details_in_edit_topic_tab() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("topicName")));
		ele1 = driver.findElement(By.id("topicName"));
		String topicName = ele1.getDomAttribute("value");
		System.out.println("Subject name is: " + topicName);
		int length = topicName.length();
		for (int i = 0; i < length; i++) {
			ele1.sendKeys(Keys.BACK_SPACE);
		}
		ele1.sendKeys(topicName+"s");
	}
	
	@Then("Modify valid topic details in edit topic")
	public void modify_valid_topic_details_in_edit_topic() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("topicName")));
		ele1 = driver.findElement(By.id("topicName"));
		String topicName = ele1.getDomAttribute("value");
		System.out.println("Subject name is: " + topicName);
		int length = topicName.length();
		for (int i = 0; i < length; i++) {
			ele1.sendKeys(Keys.BACK_SPACE);
		}
		ele1.sendKeys("Test Topic");
	}

	@Then("Click update button in edit topic tab")
	public void click_update_button_in_edit_topic_tab() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[normalize-space(text())='Update']")));
		ele1 = driver.findElement(By.xpath("//button[normalize-space(text())='Update']"));
		ele1.click();
	}

	@Then("Click delete button in topic tab")
	public void click_delete_button_in_topic_tab() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Click here to Delete Topic']")));
		ele1 = driver.findElement(By.xpath("//button[@title='Click here to Delete Topic']"));
		ele1.click();
	}

	@Then("Click close button in delete topic")
	public void click_close_button_in_delete_topic() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='modal-header']//div)[3]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='modal-header']//div)[3]"));
		ele1.click();
	}

	@Then("Click no button in delete topic")
	public void click_no_button_in_delete_topic() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[normalize-space(text())='No']")));
		ele1 = driver.findElement(By.xpath("//button[normalize-space(text())='No']"));
		ele1.click();
	}

	@Then("Click yes button in delete topic")
	public void click_yes_button_in_delete_topic() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[normalize-space(text())='Yes']")));
		ele1 = driver.findElement(By.xpath("//button[normalize-space(text())='Yes']"));
		ele1.click();
	}

	@Then("Click raw content radio button")
	public void click_raw_content_radio_button() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@class='form-check-input cp'])[1]")));
		ele1 = driver.findElement(By.xpath("(//input[@class='form-check-input cp'])[1]"));
		if (ele1.isSelected()) {
			System.out.println("Radio button is already selected");
		} else {
			ele1.click();
			System.out.println("Radio button is not selected & now it was selected");
		}
	}

	@Then("Enter valid details in the Synopsis box")
	public void enter_valid_details_in_the_synopsis_box() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='ql-editor ql-blank']")));
		ele1 = driver.findElement(By.xpath("//div[@class='ql-editor ql-blank']"));
		ele1.sendKeys("Test Synopsis");
	}

	@Then("Upload valid files in appendices tab")
	public void upload_valid_files_in_appendices_tab() throws InterruptedException, AWTException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//label[normalize-space(text())='Drop Files']")));
		ele1 = driver.findElement(By.xpath("//label[normalize-space(text())='Drop Files']"));
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

	@Then("Check success message is displayed or not in add material page")
	public void check_success_message_is_displayed_or_not_in_add_material_page() throws InterruptedException {
		Thread.sleep(1500);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actMsg = ele1.getText();
		System.out.println("Success message displayed like: " + actMsg);
		String expMsg = "Topic added successfully!";
		Assert.assertEquals("Success message is not displayed", actMsg, expMsg);
	}

	@Then("Check success message is displayed or not in add material")
	public void check_success_message_is_displayed_or_not_in_add_material() throws InterruptedException {
		Thread.sleep(1500);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actMsg = ele1.getText();
		System.out.println("Success message displayed like: " + actMsg);
		String expMsg = "Study Material saved successfully!";
		Assert.assertEquals("Success message is not displayed", actMsg, expMsg);
	}

	@Then("Check success message is displayed or not in edit topic popup")
	public void check_success_message_is_displayed_or_not_in_edit_topic_popup() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actMsg = ele1.getText();
		System.out.println("Success message displayed like: " + actMsg);
		String expMsg = "Topic updated successfully!";
		Assert.assertEquals("Success message is not displayed", actMsg, expMsg);
	}

	@When("Click any question and answer details")
	public void click_any_question_and_answer_details() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='card-body']//div)[1]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='card-body']//div)[1]"));
		ele1.click();
	}

	@When("Click clear button in edit material page")
	public void click_clear_button_in_edit_material_page() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='click here to clear']")));
		ele1 = driver.findElement(By.xpath("//button[@title='click here to clear']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}

	@Then("Check details gets cleared or not in edit material page")
	public void check_details_gets_cleared_or_not_in_edit_material_page() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("chapterName")));
		ele1 = driver.findElement(By.name("chapterName"));
		String chapterNameTab = ele1.getDomProperty("value");
		if (chapterNameTab.isEmpty()) {
			System.out.println("All tabs are cleared and clear button is working");
		} else {
			System.out.println("clear button is not wrking");
		}
		Assert.assertTrue("Clear button is not working or any one of the tab is not cleared", chapterNameTab.isEmpty());
	}

	@When("Click delete button in edit material page")
	public void click_delete_button_in_edit_material_page() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@class,'btn btn-link')]")));
		ele1 = driver.findElement(By.xpath("//button[contains(@class,'btn btn-link')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}

	@Then("Upload any material in edit material page")
	public void Upload_any_material_in_edit_material_page() throws InterruptedException, AWTException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath("//label[normalize-space(text())='Drop Files']")));
		ele1 = driver.findElement(By.xpath("//label[normalize-space(text())='Drop Files']"));
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

	@When("Modify any details in edit material page")
	public void modify_any_details_in_edit_material_page() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("chapter")));
		ele1 = driver.findElement(By.id("chapter"));
		String topicName = ele1.getDomAttribute("value");
		System.out.println("Subject name is: " + topicName);
		int length = topicName.length();
		for (int i = 0; i < length; i++) {
			ele1.sendKeys(Keys.BACK_SPACE);
		}
		ele1.sendKeys(topicName);
	}

	@Then("Click update button in edit material page")
	public void click_update_button_in_edit_material_page() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Update']")));
		ele1 = driver.findElement(By.xpath("//button[text()='Update']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}

	@Then("Check success message is displayed or not in edit material page")
	public void check_success_message_is_displayed_or_not_in_edit_material_page() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actMsg = ele1.getText();
		System.out.println("Success message displayed like: " + actMsg);
		String expMsg = "Study Material updated successfully!";
		Assert.assertEquals("Update button is not working", actMsg, expMsg);

	}

	@When("Click the exercise button")
	public void click_the_exercise_button() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//button[@title='click here to preview exercise']")));
		ele1 = driver.findElement(By.xpath("//button[@title='click here to preview exercise']"));
		ele1.click();
	}

	@When("Click view material button in exercise")
	public void click_view_material_button_in_exercise() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//button[@title='click here to preview exercise']")));
		ele1 = driver.findElement(By.xpath("//button[@title='click here to preview exercise']"));
		ele1.click();
	}

	@Then("Check page navigates to topic home page or not")
	public void check_page_navigates_to_topic_home_page_or_not() {
		String actualUrl = driver.getCurrentUrl();
		String expectedUrl = "http://192.168.1.30/OEPADMIN/Material/StudyMaterial";
		Assert.assertEquals("Page desnot navigates to study material page", actualUrl, expectedUrl);
	}

	@When("Click add material button in exercise")
	public void click_add_material_button_in_exercise() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//button[@title='click here to new study material']")));
		ele1 = driver.findElement(By.xpath("//button[@title='click here to new study material']"));
		ele1.click();
	}

	@Then("Check page navigates to add material page or not")
	public void check_page_navigates_to_add_material_page_or_not() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//h4[normalize-space(text())='Create Material']")));
		ele1 = driver.findElement(By.xpath("//h4[normalize-space(text())='Create Material']"));
		boolean isDisplayed = ele1.isDisplayed();
		Assert.assertTrue("Add material button is not working in exercise page", isDisplayed);

	}

	@When("Click edit button of any exercise question")
	public void click_edit_button_of_any_exercise_question() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//button[contains(@class,'btn-icon btn-icon-start')])[1]")));
		Thread.sleep(3000);
		ele1 = driver.findElement(By.xpath("(//button[contains(@class,'btn-icon btn-icon-start')])[1]"));
		ele1.click();
	}

	@Then("Check mandatory error message is displayed or not in edit question page")
	public void check_mandatory_error_message_is_displayed_or_not_in_edit_question_page() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actMsg = ele1.getText();
		System.out.println("Error message displayed like: " + actMsg);
		String expMsg="Question is required!";
		Assert.assertEquals("Mandatory alert message is not displayed", actMsg, expMsg);
	}

	@Then("Check all features are working or not in questions tab")
	public void check_all_features_are_working_or_not_in_questions_tab() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-header'])[1]")));
		ele1 = driver.findElement(By.xpath("(//button[@class='ql-header'])[1]"));
		ele1.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-header'])[2]")));
		ele2 = driver.findElement(By.xpath("(//button[@class='ql-header'])[2]"));
		ele2.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-list'])[1]")));
		ele3 = driver.findElement(By.xpath("(//button[@class='ql-list'])[1]"));
		ele3.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-list'])[2]")));
		ele4 = driver.findElement(By.xpath("(//button[@class='ql-list'])[2]"));
		ele4.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[@class='ql-picker-label'])[2]")));
		ele5 = driver.findElement(By.xpath("(//span[@class='ql-picker-label'])[2]"));
		ele5.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-bold'])[1]")));
		ele6 = driver.findElement(By.xpath("(//button[@class='ql-bold'])[1]"));
		ele6.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-italic'])[1]")));
		ele7 = driver.findElement(By.xpath("(//button[@class='ql-italic'])[1]"));
		ele7.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-underline'])[1]")));
		ele8 = driver.findElement(By.xpath("(//button[@class='ql-underline'])[1]"));
		ele8.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-strike'])[1]")));
		ele9 = driver.findElement(By.xpath("(//button[@class='ql-strike'])[1]"));
		ele9.click();
	}

	@Then("Check all features are working or not in answers 1st option tab")
	public void check_all_features_are_working_or_not_in_answers_1st_option_tab() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-header'])[1]")));
		ele1 = driver.findElement(By.xpath("(//button[@class='ql-header'])[3]"));
		ele1.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-header'])[2]")));
		ele2 = driver.findElement(By.xpath("(//button[@class='ql-header'])[4]"));
		ele2.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-list'])[1]")));
		ele3 = driver.findElement(By.xpath("(//button[@class='ql-list'])[3]"));
		ele3.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-list'])[2]")));
		ele4 = driver.findElement(By.xpath("(//button[@class='ql-list'])[4]"));
		ele4.click();
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//span[contains(@class,'ql-align ql-picker')])[2]")));
		ele5 = driver.findElement(By.xpath("(//span[contains(@class,'ql-align ql-picker')])[2]"));
		ele5.click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-bold'])[2]")));
		ele6 = driver.findElement(By.xpath("(//button[@class='ql-bold'])[2]"));
		ele6.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-italic'])[2]")));
		ele7 = driver.findElement(By.xpath("(//button[@class='ql-italic'])[2]"));
		ele7.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-underline'])[2]")));
		ele8 = driver.findElement(By.xpath("(//button[@class='ql-underline'])[2]"));
		ele8.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-strike'])[2]")));
		ele9 = driver.findElement(By.xpath("(//button[@class='ql-strike'])[2]"));
		ele9.click();
	}

	@When("Check all features are working or not in answers 2nd option tab")
	public void check_all_features_are_working_or_not_in_answers_2nd_option_tab() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-header'])[1]")));
		ele1 = driver.findElement(By.xpath("(//button[@class='ql-header'])[5]"));
		ele1.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-header'])[2]")));
		ele2 = driver.findElement(By.xpath("(//button[@class='ql-header'])[6]"));
		ele2.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-list'])[1]")));
		ele3 = driver.findElement(By.xpath("(//button[@class='ql-list'])[5]"));
		ele3.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-list'])[2]")));
		ele4 = driver.findElement(By.xpath("(//button[@class='ql-list'])[6]"));
		ele4.click();
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//span[contains(@class,'ql-align ql-picker')])[3]")));
		ele5 = driver.findElement(By.xpath("(//span[contains(@class,'ql-align ql-picker')])[3]"));
		ele5.click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-bold'])[3]")));
		ele6 = driver.findElement(By.xpath("(//button[@class='ql-bold'])[3]"));
		ele6.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-italic'])[3]")));
		ele7 = driver.findElement(By.xpath("(//button[@class='ql-italic'])[3]"));
		ele7.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-underline'])[3]")));
		ele8 = driver.findElement(By.xpath("(//button[@class='ql-underline'])[3]"));
		ele8.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-strike'])[3]")));
		ele9 = driver.findElement(By.xpath("(//button[@class='ql-strike'])[3]"));
		ele9.click();
	}

	@When("Check all features are working or not in answers 3rd option tab")
	public void check_all_features_are_working_or_not_in_answers_3rd_option_tab() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-header'])[7]")));
		ele1 = driver.findElement(By.xpath("(//button[@class='ql-header'])[7]"));
		ele1.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-header'])[8]")));
		ele2 = driver.findElement(By.xpath("(//button[@class='ql-header'])[8]"));
		ele2.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-list'])[7]")));
		ele3 = driver.findElement(By.xpath("(//button[@class='ql-list'])[7]"));
		ele3.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-list'])[8]")));
		ele4 = driver.findElement(By.xpath("(//button[@class='ql-list'])[8]"));
		ele4.click();
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//span[contains(@class,'ql-align ql-picker')])[4]")));
		ele5 = driver.findElement(By.xpath("(//span[contains(@class,'ql-align ql-picker')])[4]"));
		ele5.click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-bold'])[4]")));
		ele6 = driver.findElement(By.xpath("(//button[@class='ql-bold'])[4]"));
		ele6.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-italic'])[4]")));
		ele7 = driver.findElement(By.xpath("(//button[@class='ql-italic'])[4]"));
		ele7.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-underline'])[4]")));
		ele8 = driver.findElement(By.xpath("(//button[@class='ql-underline'])[4]"));
		ele8.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-strike'])[4]")));
		ele9 = driver.findElement(By.xpath("(//button[@class='ql-strike'])[4]"));
		ele9.click();
	}

	@When("Check all features are working or not in answers 4th option tab")
	public void check_all_features_are_working_or_not_in_answers_4th_option_tab() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-header'])[9]")));
		ele1 = driver.findElement(By.xpath("(//button[@class='ql-header'])[9]"));
		ele1.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-header'])[10]")));
		ele2 = driver.findElement(By.xpath("(//button[@class='ql-header'])[1]"));
		ele2.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-list'])[9]")));
		ele3 = driver.findElement(By.xpath("(//button[@class='ql-list'])[9]"));
		ele3.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-list'])[10]")));
		ele4 = driver.findElement(By.xpath("(//button[@class='ql-list'])[10]"));
		ele4.click();
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//span[contains(@class,'ql-align ql-picker')])[5]")));
		ele5 = driver.findElement(By.xpath("(//span[contains(@class,'ql-align ql-picker')])[5]"));
		ele5.click();

		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-bold'])[5]")));
		ele6 = driver.findElement(By.xpath("(//button[@class='ql-bold'])[5]"));
		ele6.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-italic'])[5]")));
		ele7 = driver.findElement(By.xpath("(//button[@class='ql-italic'])[5]"));
		ele7.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-underline'])[5]")));
		ele8 = driver.findElement(By.xpath("(//button[@class='ql-underline'])[5]"));
		ele8.click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@class='ql-strike'])[5]")));
		ele9 = driver.findElement(By.xpath("(//button[@class='ql-strike'])[5]"));
		ele9.click();
	}

	@Then("Modify valid details in edit question page")
	public void modify_valid_details_in_edit_question_page() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[@class='ql-editor'])[1]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='ql-editor'])[1]"));
		String questionValue = ele1.getText();
		System.out.println("Subject name is: " + questionValue);
		int length = questionValue.length();
		for (int i = 0; i < length; i++) {
			ele1.clear();
		}
		ele1.sendKeys(questionValue);
	}

	@Then("Check success message is displayed or not in edit question")
	public void check_alert_message_is_displayed_or_not_in_edit_question() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actMsg = ele1.getText();
		System.out.println("Success message displayed like: " + actMsg);
		String expMsg="Question and answer updated successfully!";
		Assert.assertEquals("Update button is not working", actMsg, expMsg);
	}

}