package ui.steps;

import ui.base.BaseTest;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import ui.pages.CommonPage;

public class CommonSteps {

    protected WebDriver driver;
    private final CommonPage commonPage;

    public CommonSteps() {
        this.driver = BaseTest.getDriver();
        this.commonPage = new CommonPage(driver);
    }

    @Then("the page title should be {string}")
    public void assert_page_title(String expectedTitle) {
        Assertions.assertEquals(expectedTitle, commonPage.getPageTitle(), "Unexpected page title");
    }
}