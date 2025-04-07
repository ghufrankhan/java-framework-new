package ui.steps;

import ui.base.BaseTest;
import config.ConfigLoader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import ui.pages.StartPage;

public class StartSteps {

    private final WebDriver driver;
    private StartPage startPage;

    public StartSteps() {
        this.driver = BaseTest.getDriver();
    }

    @Given("I have navigated to the Selenium web form page")
    public void i_have_navigated_to_the_selenium_web_form_page() {
        startPage = new StartPage(driver);

        String baseUrl = ConfigLoader.getUiBaseUrl();
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals(baseUrl, currentUrl, "User is not on the web form page. Current URL: " + currentUrl);
    }

    @When("I enter {string} in the text input field")
    public void i_enter_in_the_text_input_field(String text) {
        startPage.enterTextInTextInputField(text);
    }

    @And("I enter {string} in the password field")
    public void i_enter_in_the_password_field(String text) {
        startPage.enterPasswordInPasswordField(text);
    }

    @And("I enter {string} in the text area input")
    public void i_enter_in_the_text_area_input(String text) {
        startPage.enterTextInTextAreaInput(text);
    }

    @And("I select {string} from the dropdown select")
    public void i_select_from_the_dropdown_select(String text) {
        startPage.selectFromDropdownByVisibleText(text);
    }

    @And("I select {string} from the dropdown datalist")
    public void i_select_from_the_dropdown_datalist(String text) {
        startPage.selectFromDatalist(text);
    }

    @When("I click the submit button")
    public void i_click_the_submit_button() {
        startPage.clickSubmitButton();
    }
}