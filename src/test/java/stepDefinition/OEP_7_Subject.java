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

public class OEP_7_Subject {
	public WebDriver driver;
	public WebElement ele, ele1, ele2, ele3, ele4, ele5, ele6, ele7, ele8, ele9;
	public WebDriverWait wait;

	@Given("To Check subject is navigating to OEP URL is {string}")
	public void to_check_subject_is_navigating_to_oep_url_is(String url) {
		System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
//		option.addArguments("--headless=new");
		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get(url);
	}

	@When("To Check subject Enter username and password are {string} and {string}")
	public void to_check_subject_enter_username_and_password_are_and(String username, String password) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("email")));
		ele1 = driver.findElement(By.name("email"));
		ele1.clear();
		ele1.sendKeys(username);
		ele2 = driver.findElement(By.name("password"));
		ele2.clear();
		ele2.sendKeys(password);
	}

	@When("click the Signin button To Check subject page")
	public void click_the_signin_button_to_check_subject_page() {
		ele1 = driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
		ele1.click();
	}

	@Then("Click take picture button in subject page")
	public void click_take_picture_button_in_subject_page() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space(text())='Take Picture']")));
		ele1 = driver.findElement(By.xpath("//button[normalize-space(text())='Take Picture']"));
		ele1.click();
	}

	@Then("Click subject button in setup module")
	public void click_subject_button_in_setup_module() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[normalize-space(text())='Setup']")));
		ele1 = driver.findElement(By.xpath("//span[normalize-space(text())='Setup']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		Actions action = new Actions(driver);
		action.moveToElement(ele1).build().perform();
		ele1.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[normalize-space(text())='Subject']")));
		ele2 = driver.findElement(By.xpath("//span[normalize-space(text())='Subject']"));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("arguments[0].scrollIntoView(true);", ele2);
		Thread.sleep(2000);
		ele2.click();
		driver.navigate().refresh();
	}

	@Then("Close subject button")
	public void close_subject_button() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
		System.out.print("Page is closed");
	}

	@Given("Enter valid subject name {string} in the searchbox in subject page")
	public void enter_valid_subject_name_in_the_searchbox_in_subject_page(String subjectName)
			throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("fname")));
		ele1 = driver.findElement(By.name("fname"));
		ele1.sendKeys(subjectName);
	}

	@When("Check entered subject name {string} is displayed or not in subject page")
	public void check_entered_subject_name_is_displayed_or_not_in_subject_page(String string) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@type='button'])[2]")));
		ele1 = driver.findElement(By.xpath("(//button[@type='button'])[2]"));
		String actualText = ele1.getText();
		String expectedText = "Artificial Intelligence";
		Assert.assertEquals("Entered subject name is not displayed", actualText, expectedText);
	}

	@Given("Select {string} option in the dropdown in subject page")
	public void select_option_in_the_dropdown_in_subject_page(String string) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//div[@class='react-select__single-value css-1uccc91-singleValue']")));
		ele1 = driver.findElement(By.xpath("//div[@class='react-select__single-value css-1uccc91-singleValue']"));
		ele1.click();

		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='All']"));
		ele2.click();
	}

	@Given("Select {string} 2nd option in the dropdown in subject page")
	public void select_2nd_option_in_the_dropdown_in_subject_page(String string) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//div[@class='react-select__single-value css-1uccc91-singleValue']")));
		ele1 = driver.findElement(By.xpath("//div[@class='react-select__single-value css-1uccc91-singleValue']"));
		ele1.click();

		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Active']"));
		ele2.click();
	}

	@Given("Select {string} 3rd option in the dropdown in subject page")
	public void select_3rd_option_in_the_dropdown_in_subject_page(String string) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//div[@class='react-select__single-value css-1uccc91-singleValue']")));
		ele1 = driver.findElement(By.xpath("//div[@class='react-select__single-value css-1uccc91-singleValue']"));
		ele1.click();

		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Inactive']"));
		ele2.click();
	}

	@Given("Click add subject button in subject page")
	public void click_add_subject_button_in_subject_page() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@type='button'])[1]")));
		ele1 = driver.findElement(By.xpath("(//button[@type='button'])[1]"));
		ele1.click();
	}

	@When("Click back button in subject page")
	public void click_back_button_in_subject_page() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Click here to back']")));
		ele1 = driver.findElement(By.xpath("//button[@title='Click here to back']"));
		ele1.click();
	}

	@Then("Check page navigates to previous page or not in subject page")
	public void check_page_navigates_to_previous_page_or_not_in_subject_page() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("fname")));
		ele1 = driver.findElement(By.name("fname"));
		Assert.assertTrue("Back button is not working", ele1.isDisplayed());
	}

	@When("Click save button in subject page")
	public void click_save_button_in_subject_page() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Click here to save']")));
		ele1 = driver.findElement(By.xpath("//button[@title='Click here to save']"));
		ele1.click();
	}

	@Then("Check mandatory red border is displayed or not in add subject page")
	public void check_mandatory_red_border_is_displayed_or_not_in_add_subject_page() throws InterruptedException {
		Thread.sleep(2000);
		String expectedBorderColor1 = "rgb(255, 0, 0)";
//		String expectedBorderColor2 = "rgb(78, 78, 78)";
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Price")));
			ele1 = driver.findElement(By.id("Price"));
			ele2 = driver.findElement(By.id("Subject"));
			ele3 = driver.findElement(By.id("Description"));
			ele4 = driver.findElement(By.id("SubjectContent"));

			String borderColor1 = ele1.getCssValue("border-color");
			System.out.println("1st tab color is: " + borderColor1);
			String borderColor2 = ele2.getCssValue("border-color");
			System.out.println("2nd tab color is: " + borderColor2);
			String borderColor3 = ele3.getCssValue("border-color");
			System.out.println("3rd tab color is: " + borderColor3);
			String borderColor4 = ele4.getCssValue("border-color");
			System.out.println("4th tab color is: " + borderColor4);

			// Assertions for border color
			Assert.assertEquals("Red border is not displayed", borderColor1, expectedBorderColor1);
			Assert.assertEquals("Red border is not displayed", borderColor2, expectedBorderColor1);
			Assert.assertEquals("Red border is not displayed", borderColor3, expectedBorderColor1);
			Assert.assertEquals("Red border is not displayed", borderColor4, expectedBorderColor1);

		} catch (Exception e) {
			System.out.println("Error getting border color: " + e.getMessage());
		}
	}

	@When("Enter alpha characters {string} in price tab")
	public void enter_alpha_characters_in_price_tab(String invalidChars) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Price")));
		ele1 = driver.findElement(By.id("Price"));
		ele1.sendKeys(invalidChars);
	}

	@When("Enter special characters {string} in price tab")
	public void enter_special_characters_in_price_tab(String invalidChars) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Price")));
		ele1 = driver.findElement(By.id("Price"));
		ele1.sendKeys(invalidChars);
	}

	@Then("Check tab is empty or not in price tab")
	public void check_tab_is_empty_or_not_in_price_tab() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Price")));
		ele1 = driver.findElement(By.id("Price"));
		String priceValue = ele1.getDomAttribute("value");
		System.out.println("Tab value is: "+priceValue);
		String expValue="$";
		Thread.sleep(2000);
		Assert.assertEquals("User able to enter alpha and special characters in price tab", priceValue, expValue);
	}

	@When("Enter numerical characters {string} in price tab")
	public void enter_numerical_characters_in_price_tab(String validChars) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Price")));
		ele1 = driver.findElement(By.id("Price"));
		ele1.sendKeys(validChars);
	}

	@Then("Check entered text {string} is displayed or not in price tab")
	public void check_entered_text_is_displayed_or_not_in_price_tab(String priceValue) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Price")));
		ele1 = driver.findElement(By.id("Price"));
		String actualPriceValue = ele1.getDomAttribute("value");
		String expectedPriceValue = priceValue;
		Assert.assertEquals("Numerical values doesnot accept the values", actualPriceValue, expectedPriceValue);
	}

	@Then("Check the tab has more or less than maximum digits in price tab")
	public void check_the_tab_has_more_or_less_than_maximum_digits_in_price_tab() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Price")));
		ele1 = driver.findElement(By.id("Price"));
		String actPriceValue = ele1.getDomAttribute("value");
		int maxCharacters = 5;
		if (actPriceValue.length() > maxCharacters) {
			System.out.println("Input field contains more than " + maxCharacters + " characters.");
		} else {
			System.out.println("Input field contains " + actPriceValue.length() + " characters.");
		}
		Assert.assertTrue("Input field contains more than " + maxCharacters + " characters.",
				actPriceValue.length() <= maxCharacters);
	}

	@When("Click apply discount toggle button in price tab")
	public void click_apply_discount_toggle_button_in_price_tab() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@role='switch'])[1]")));
		ele1 = driver.findElement(By.xpath("(//button[@role='switch'])[1]"));
		ele1.click();
	}

	@Then("Check Discount Unit dropdown is displayed or not")
	public void check_discount_unit_dropdown_is_displayed_or_not() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//span[@class='text-bold'])[4]")));
		ele1 = driver.findElement(By.xpath("(//span[@class='text-bold'])[4]"));
//		String text = ele1.getText();
		Assert.assertTrue("Discount toggle button is not working", ele1.isDisplayed());
	}

	@When("Enter valid price value {string} in price tab")
	public void enter_valid_price_value_in_price_tab(String priceValue) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Price")));
		ele1 = driver.findElement(By.id("Price"));
		ele1.sendKeys(priceValue);
	}

	@Then("Check the total is displayed same like as entered total {string} or not in price tab")
	public void check_the_total_is_displayed_same_like_as_entered_total_or_not_in_price_tab(String enteredPrice) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//span[contains(@class,'text-bold fs-18')])[2]")));
		ele1 = driver.findElement(By.xpath("(//span[contains(@class,'text-bold fs-18')])[2]"));
		String actualPrice = ele1.getText();
		String expPrice = enteredPrice;
		Assert.assertEquals("Total value is diffrent compared with entered price value", actualPrice, expPrice);
	}

	@Then("Select Percentage option in the dropdown in price tab")
	public void select_percentage_option_in_the_dropdown_in_price_tab() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"//div[contains(@class,'react-select__value-container react-select__value-container--has-value')]")));
		ele1 = driver.findElement(By.xpath(
				"//div[contains(@class,'react-select__value-container react-select__value-container--has-value')]"));
		ele1.click();
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Percentage']"));
		ele2.click();
	}

	@Then("Enter valid percentage value {string} in price tab")
	public void enter_valid_percentage_value_in_price_tab(String perValue) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("DiscountValue")));
		ele1 = driver.findElement(By.id("DiscountValue"));
		ele1.sendKeys(perValue);
	}

	@Then("Check valid total value {string} for percentage option is correct or not in price tab")
	public void check_valid_total_value_for_percentage_option_is_correct_or_not_in_price_tab(String discountPrice) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//span[contains(@class,'text-bold fs-18')])[2]")));
		ele1 = driver.findElement(By.xpath("(//span[contains(@class,'text-bold fs-18')])[2]"));
		String actualPrice = ele1.getText();
		String expPrice = discountPrice;
		Assert.assertEquals("Total value is diffrent compared with entered price value", actualPrice, expPrice);
	}

	@Then("Select Flat Amount option in the dropdown in price tab")
	public void select_flat_amount_option_in_the_dropdown_in_price_tab() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"//div[contains(@class,'react-select__value-container react-select__value-container--has-value')]")));
		ele1 = driver.findElement(By.xpath(
				"//div[contains(@class,'react-select__value-container react-select__value-container--has-value')]"));
		ele1.click();
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Flat Amount']"));
		ele2.click();
	}

	@Then("Enter valid Flat Amount value {string} in price tab")
	public void enter_valid_flat_amount_value_in_price_tab(String flatAmtValue) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("DiscountValue")));
		ele1 = driver.findElement(By.id("DiscountValue"));
		ele1.sendKeys(flatAmtValue);
	}

	@Then("Check valid total value {string} for flat amount option is correct or not in price tab")
	public void check_valid_total_value_for_flat_amount_option_is_correct_or_not_in_price_tab(String discountPrice) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//span[contains(@class,'text-bold fs-18')])[2]")));
		ele1 = driver.findElement(By.xpath("(//span[contains(@class,'text-bold fs-18')])[2]"));
		String actualPrice = ele1.getText();
		String expPrice = discountPrice;
		Assert.assertEquals("Total value is diffrent compared with entered price value", actualPrice, expPrice);
	}

	@When("Click file upload button in add subject")
	public void click_file_upload_button_in_add_subject() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("//button[contains(@class,'btn-icon btn-icon-only')]")));
		ele1 = driver.findElement(By.xpath("//button[contains(@class,'btn-icon btn-icon-only')]"));
		ele1.click();
	}

	@Then("Upload invalid file format in add subject")
	public void upload_invalid_file_format_in_add_subject() throws InterruptedException, AWTException {
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

	@Then("Upload valid file format in add subject")
	public void upload_valid_file_format_in_add_subject() throws InterruptedException, AWTException {
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

	@When("Enter Special characters {string} in the subject tab in add subject")
	public void enter_special_characters_in_the_subject_tab_in_add_subject(String Subject) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Subject")));
		ele1 = driver.findElement(By.id("Subject"));
		ele1.sendKeys(Subject);
	}

	@Then("Clear the characters in the subject tab in add subject")
	public void clear_the_characters_in_the_subject_tab_in_add_subject() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Subject")));
		ele1 = driver.findElement(By.id("Subject"));
//		String subjName=ele1.getDomAttribute("value");
		ele1.clear();
	}

	@Then("Enter Numerical characters {string} in the subject tab in add subject")
	public void enter_numerical_characters_in_the_subject_tab_in_add_subject(String Subject) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Subject")));
		ele1 = driver.findElement(By.id("Subject"));
		ele1.sendKeys(Subject);
	}

	@Then("Enter alpha characters {string} in the subject tab in add subject")
	public void enter_alpha_characters_in_the_subject_tab_in_add_subject(String Subject) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Subject")));
		ele1 = driver.findElement(By.id("Subject"));
		ele1.sendKeys(Subject);
	}

	@When("Click the Active toggle button in add subject")
	public void click_the_active_toggle_button_in_add_subject() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@role='switch'])[2]")));
		ele1 = driver.findElement(By.xpath("(//button[@role='switch'])[2]"));
		ele1.click();
	}

	@When("Enter valid price value {string} in add subject")
	public void enter_valid_price_value_in_add_subject(String Price) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Price")));
		ele1 = driver.findElement(By.id("Price"));
		ele1.sendKeys(Price);
	}

	@Then("Enter the valid subject name in add subject")
	public void enter_the_valid_subject_name_in_add_subject() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Subject")));
		ele1 = driver.findElement(By.id("Subject"));
		Faker fakename = new Faker();
		String genre = fakename.book().genre();
		ele1.sendKeys(genre + " subject");
	}

	@Then("Enter valid colour code {string} in add subject")
	public void enter_valid_colour_code_in_add_subject(String colorCode) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Color")));
		ele1 = driver.findElement(By.id("Color"));
		ele1.sendKeys(colorCode);
	}

	@Then("Enter valid description {string} details in add subject")
	public void enter_valid_description_details_in_add_subject(String description) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Description")));
		ele1 = driver.findElement(By.id("Description"));
		ele1.sendKeys(description);
	}

	@Then("Enter the subject content {string} details in add subject")
	public void enter_the_subject_content_details_in_add_subject(String content) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("SubjectContent")));
		ele1 = driver.findElement(By.id("SubjectContent"));
		ele1.sendKeys(content);
	}

	@Then("Enter percentage value {string} in add subject")
	public void enter_percentage_value_in_add_subject(String perValue) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("DiscountValue")));
		ele1 = driver.findElement(By.id("DiscountValue"));
		ele1.sendKeys(perValue);
	}

	@Given("Click the subject name")
	public void click_the_subject_name() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@type='button'])[2]")));
		ele1 = driver.findElement(By.xpath("(//button[@type='button'])[2]"));
		ele1.click();
	}

	@Then("Modify valid details in update subject")
	public void modify_valid_details_in_update_subject() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("Price")));
		ele1 = driver.findElement(By.id("Price"));
		String priceValue = ele1.getDomAttribute("value");
		int length = priceValue.length();
		for (int i = 0; i < length; i++) {
			ele1.sendKeys(Keys.BACK_SPACE);
		}
		Thread.sleep(2000);
		ele1.sendKeys(priceValue);

	}

	@Then("Click update button in update subject")
	public void click_update_button_in_update_subject() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Click here to save']")));
		ele1 = driver.findElement(By.xpath("//button[@title='Click here to save']"));
		ele1.click();
	}
	@Then("Click save button in add subject in subject page")
	public void click_save_button_in_add_subject_in_subject_page() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Click here to save']")));
		ele1 = driver.findElement(By.xpath("//button[@title='Click here to save']"));
		ele1.click();
	}
	@Then("Check success message is displayed or not in update subject in subject page")
	public void check_success_message_is_displayed_or_not_in_update_subject_in_subject_page() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actText = ele1.getText();
		System.out.println("Success message displayed like: " + actText);
		String expText = "Subjects updated successfully!";
		Assert.assertEquals("Update button is not working", actText, expText);
	}
	@Then("Check success message is displayed or not in update subject")
	public void check_success_message_is_displayed_or_not_in_update_subject() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actText = ele1.getText();
		System.out.println("Success message displayed like: " + actText);
		String expText = "Subjects updated successfully!";
		Assert.assertEquals("Update button is not working", actText, expText);
	}
	@Then("Check error message is displayed or not in add subject")
	public void check_error_message_is_displayed_or_not_in_add_subject() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actText = ele1.getText();
		System.out.println("Success message displayed like: " + actText);
		String expText = "Please upload valid image file.";
		Assert.assertEquals("Invalid file can able to upload", actText, expText);
	}
	@Then("Check success message is displayed or not in add subject in subject page")
	public void check_success_message_is_displayed_or_not_in_add_subject_in_subject_page() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actText = ele1.getText();
		System.out.println("Success message displayed like: " + actText);
		String expText = "Subjects added successfully!";
		Assert.assertEquals("Update button is not working", actText, expText);
	}
}