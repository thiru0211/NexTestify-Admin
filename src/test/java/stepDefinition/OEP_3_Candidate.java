package stepDefinition;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

public class OEP_3_Candidate {
	public WebDriver driver;
	public WebElement ele, ele1, ele2, ele3, ele4, ele5, ele6, ele7, ele8, ele9;
	public WebDriverWait wait;

	@Given("To Check candidate is navigating to OEP URL is {string}")
	public void to_check_candidate_is_navigating_to_oep_url_is(String url) {
		System.setProperty("webdriver.chrome.driver", ".\\Driver\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
//		option.addArguments("--headless=new");
		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get(url);
	}

	@When("To Check candidate Enter username and password are {string} and {string}")
	public void to_check_candidate_enter_username_and_password_are_and(String username, String password) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("email")));
		ele1 = driver.findElement(By.name("email"));
		ele1.clear();
		ele1.sendKeys(username);
		ele2 = driver.findElement(By.name("password"));
		ele2.clear();
		ele2.sendKeys(password);
	}

	@When("click the Signin button To Check candidate page")
	public void click_the_signin_button_to_check_candidate_page() {
		ele1 = driver.findElement(By.xpath("//button[contains(@class,'btn btn-sm')]"));
		ele1.click();
	}

	@Then("Close candidate button")
	public void close_candidate_button() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
		System.out.print("Page is closed");
	}

	@Then("Click take picture button in candidate page")
	public void click_take_picture_button_in_candidate_page() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space(text())='Take Picture']")));
		ele1 = driver.findElement(By.xpath("//button[normalize-space(text())='Take Picture']"));
		ele1.click();
	}

	@Then("Click candidate button in admin module")
	public void click_candidate_button_in_admin_module() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(60));

		// ✅ Wait for full page load
		wait.until(
				driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));

		// ✅ Wait for collapse button to be clickable
		By collapseToggle = By.xpath("(//a[@data-bs-toggle='collapse'])[2]");
		wait.until(ExpectedConditions.elementToBeClickable(collapseToggle));

		// ✅ Wait until the loader disappears
		By loader = By.cssSelector("div.loaderStyle"); // Adjust if needed
		wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));

		// ✅ Now safely move and click the element
		By labelSpan = By.xpath("(//span[@class='label'])[3]");
		ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(labelSpan));
		Actions action = new Actions(driver);
		action.moveToElement(ele1).build().perform();
		ele1.click();

		// ✅ Click submenu item
		By submenuLink = By.xpath("(//ul[@class='collapse show']//a[1])[2]");
		ele2 = wait.until(ExpectedConditions.elementToBeClickable(submenuLink));
		ele2.click();
	}
	
	@Given("Enter valid username {string} in the searchbox in candidate page")
	public void enter_valid_username_in_the_searchbox_in_candidate_page(String username) throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("fname")));
		ele1 = driver.findElement(By.name("fname"));
		ele1.sendKeys(username);
	}

	@When("Check entered username {string} is displayed or not in candidate page")
	public void check_entered_username_is_displayed_or_not_in_candidate_page(String username) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		By userTextLocator = By.xpath("//div[@class='align-items-center text-bold']");

		wait.until(ExpectedConditions.presenceOfElementLocated(userTextLocator));
		wait.until(ExpectedConditions.visibilityOfElementLocated(userTextLocator));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(userTextLocator, username));

		WebElement ele1 = driver.findElement(userTextLocator);
		String actualText = ele1.getText();
		String expectedText = username;

		Assert.assertEquals("Entered Username is not displayed", expectedText, actualText);
	}

	@When("Enter valid email id {string} in the searchbox in candidate page")
	public void enter_valid_email_id_in_the_searchbox_in_candidate_page(String emailID) throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("fname")));
		ele1 = driver.findElement(By.name("fname"));
		ele1.sendKeys(emailID);
	}

	@Then("Check entered emailid {string} is displayed or not in candidate page")
	public void check_entered_emailid_is_displayed_or_not_in_candidate_page(String emailID) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		By userEmailID = By.xpath("(//div[@class='align-items-center text-alternate'])[2]");
		
		wait.until(ExpectedConditions.presenceOfElementLocated(userEmailID));
		wait.until(ExpectedConditions.visibilityOfElementLocated(userEmailID));
		wait.until(ExpectedConditions.textToBePresentInElementLocated(userEmailID, emailID));

		WebElement ele1 = driver.findElement(userEmailID);
		String actualText = ele1.getText();
		String expectedText = emailID;
		Assert.assertEquals("Entered Email ID is not displayed", actualText, expectedText);
	}

	@Then("Enter valid phone number {string} in the searchbox in candidate page")
	public void enter_valid_phone_number_in_the_searchbox_in_candidate_page(String phoneNumber) throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("fname")));
		ele1 = driver.findElement(By.name("fname"));
		ele1.sendKeys(phoneNumber);
	}

	@Then("Check entered phone number {string} is displayed or not in candidate page")
	public void check_entered_phone_number_is_displayed_or_not_in_candidate_page(String phoneNumber) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//div[@class='align-items-center text-alternate'])[3]")));
		ele1 = driver.findElement(By.xpath("(//div[@class='align-items-center text-alternate'])[3]"));
		String actualText = ele1.getText();
		String expectedText = "+91-8098911086";
		Assert.assertEquals("Entered Username is not displayed", actualText, expectedText);
	}
	
	@Given("Select {string} option in the dropdown in candidate page")
	public void select_option_in_the_dropdown_in_candidate_page(String string) throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"//div[contains(@class,'react-select__value-container react-select__value-container--has-value')]")));
		ele1 = driver.findElement(By.xpath(
				"//div[contains(@class,'react-select__value-container react-select__value-container--has-value')]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='All']"));
		ele2.click();
	}
	
	@Given("Select All option in the dropdown in candidate page")
	public void select_all_option_in_the_dropdown_in_candidate_page() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"//div[contains(@class,'react-select__value-container react-select__value-container--has-value')]")));
		ele1 = driver.findElement(By.xpath(
				"//div[contains(@class,'react-select__value-container react-select__value-container--has-value')]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='All']"));
		ele2.click();
	}
	
	@Given("Select {string} 2nd option in the dropdown in candidate page")
	public void select_2nd_option_in_the_dropdown_in_candidate_page(String string) throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"//div[contains(@class,'react-select__value-container react-select__value-container--has-value')]")));
		ele1 = driver.findElement(By.xpath(
				"//div[contains(@class,'react-select__value-container react-select__value-container--has-value')]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Paid']"));
		ele2.click();
	}
	@When("Check selected 2nd option {string} is displayed or not in candidate page")
	public void check_selected_2nd_option_is_displayed_or_not_in_candidate_page(String string) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//span[@class='badge bg-outline-success'])[1]")));
		ele1 = driver.findElement(By.xpath("(//span[@class='badge bg-outline-success'])[1]"));
		String actualText = ele1.getText();
		String expectedText = "Paid";
		Assert.assertEquals("Entered Username is not displayed", actualText, expectedText);
	}
	
	@Given("Select {string} 3rd option in the dropdown in candidate page")
	public void select_3rd_option_in_the_dropdown_in_candidate_page(String string) throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
				"//div[contains(@class,'react-select__value-container react-select__value-container--has-value')]")));
		ele1 = driver.findElement(By.xpath(
				"//div[contains(@class,'react-select__value-container react-select__value-container--has-value')]"));
		ele1.click();
		Thread.sleep(2000);
		ele2 = driver.findElement(By.xpath("//div[normalize-space(text())='Trial']"));
		ele2.click();
	}
	@When("Check selected 3rd option {string} is displayed or not in candidate page")
	public void check_selected_3rd_option_is_displayed_or_not_in_candidate_page(String string) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions
				.presenceOfElementLocated(By.xpath("(//span[@class='badge bg-outline-warning'])[1]")));
		ele1 = driver.findElement(By.xpath("(//span[@class='badge bg-outline-warning'])[1]"));
		String actualText = ele1.getText();
		String expectedText = "Trial";
		Assert.assertEquals("Entered Username is not displayed", actualText, expectedText);
	}
	
	@Given("Click Last page button in below of the grid in candidate page")
	public void click_last_page_button_in_below_of_the_grid_in_candidate_page() throws InterruptedException {
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@class='page-link']//span)[3]")));
		ele1 = driver.findElement(By.xpath("(//a[@class='page-link']//span)[3]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}
	@When("Click First page button in below of the grid in candidate page")
	public void click_first_page_button_in_below_of_the_grid_in_candidate_page() throws InterruptedException {
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@class='page-link']//span)[1]")));
		ele1 = driver.findElement(By.xpath("(//a[@class='page-link']//span)[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}
	@When("Click next page button in below of the grid in candidate page")
	public void click_next_page_button_in_below_of_the_grid_in_candidate_page() throws InterruptedException {
		Thread.sleep(3000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@class='page-link']//span)[1]")));
		ele1 = driver.findElement(By.xpath("(//a[@class='page-link']//span)[1]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}
	@Then("Click previous page button in below of the grid in candidate page")
	public void click_previous_page_button_in_below_of_the_grid_in_candidate_page() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//a[@class='page-link']//span)[3]")));
		ele1 = driver.findElement(By.xpath("(//a[@class='page-link']//span)[3]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}
	@Then("Click the number button in below of the grid in candidate page")
	public void click_the_number_button_in_below_of_the_grid_in_candidate_page() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[normalize-space(text())='2']")));
		ele1 = driver.findElement(By.xpath("//a[normalize-space(text())='2']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}
	@When("Click edit button in candidate page")
	public void click_edit_button_in_candidate_page() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@class,'btn-icon btn-icon-start')]")));
		ele1 = driver.findElement(By.xpath("//button[contains(@class,'btn-icon btn-icon-start')]"));
		ele1.click();
	}
	@When("Click back button in candidate page")
	public void click_back_button_in_candidate_page() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[contains(@class,'btn btn-sm')]")));
		ele1 = driver.findElement(By.xpath("//button[contains(@class,'btn btn-sm')]"));
		ele1.click();
	}
	@Then("Check page navigates to previous page or not in candidate page")
	public void check_page_navigates_to_previous_page_or_not_in_candidate_page() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("fname")));
		ele1 = driver.findElement(By.name("fname"));
		Assert.assertTrue("Back button is not working", ele1.isDisplayed());
	}
	@When("Click no radio button in Two FA tab in candidate page")
	public void click_no_radio_button_in_two_fa_tab_in_candidate_page() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@type='radio'])[2]")));
		ele1 = driver.findElement(By.xpath("(//input[@type='radio'])[2]"));
		ele1.click();
	}
	@Then("Click update button in candidate page")
	public void click_update_button_in_candidate_page() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Click here to update']")));
		ele1 = driver.findElement(By.xpath("//button[@title='Click here to update']"));
		ele1.click();
	}
	@Then("Check success message is displayed or not in candidate page")
	public void check_success_message_is_displayed_or_not_in_candidate_page() throws InterruptedException {
		Thread.sleep(2000);
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='Toastify__toast-body']")));
		ele1 = driver.findElement(By.xpath("//div[@class='Toastify__toast-body']"));
		String actText = ele1.getText();
		System.out.println("Verification message displayed like: " + actText);
		String expText="Two-level authentication has been set successfully!";
		Assert.assertEquals("Success message is not displayed", actText, expText);
	}
	@When("Click yes radio button in Two FA tab in candidate page")
	public void click_yes_radio_button_in_two_fa_tab_in_candidate_page() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@type='radio'])[1]")));
		ele1 = driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
		ele1.click();
	}
	@Then("Click email radio button in Two FA tab in candidate page")
	public void click_email_radio_button_in_two_fa_tab_in_candidate_page() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@type='radio'])[3]")));
		ele1 = driver.findElement(By.xpath("(//input[@type='radio'])[3]"));
		ele1.click();
	}
	@Then("Click sms radio button in Two FA tab in candidate page")
	public void click_sms_radio_button_in_two_fa_tab_in_candidate_page() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//input[@type='radio'])[4]")));
		ele1 = driver.findElement(By.xpath("(//input[@type='radio'])[4]"));
		ele1.click();
	}
	@When("Click invoice details button in candidate page")
	public void click_invoice_details_button_in_candidate_page() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@title='Click here to get Invoice details']")));
		ele1 = driver.findElement(By.xpath("//button[@title='Click here to get Invoice details']"));
		ele1.click();
	}
	@Then("Click download button in candidate page")
	public void click_download_button_in_candidate_page() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//div[contains(@class,'text-alternate align-items-center')])[2]")));
		ele1 = driver.findElement(By.xpath("(//div[contains(@class,'text-alternate align-items-center')])[2]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele1);
		Thread.sleep(2000);
		ele1.click();
	}

}