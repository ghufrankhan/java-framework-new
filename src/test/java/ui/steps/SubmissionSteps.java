package ui.steps;

import ui.base.BaseTest;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import ui.pages.SubmissionPage;

import java.util.ArrayList;
import java.util.List;

public class SubmissionSteps {

    protected WebDriver driver;
    private final SubmissionPage submissionPage;

    public SubmissionSteps() {
        this.driver = BaseTest.getDriver();
        this.submissionPage = new SubmissionPage(driver);
    }

    @And("the message displayed should be {string}")
    public void assert_message(String expectedMessage) {
        Assertions.assertEquals(expectedMessage, submissionPage.getMessage(), "Unexpected message on submission page");
    }

    @And("the URL should contain the following values")
    public void assertUrlContainsValues(DataTable dataTable) {
        String urlText = submissionPage.getUrlText();
        List<String> missingValues = new ArrayList<>();

        for (String expectedValue : dataTable.asList()) {
            String encodedValue = expectedValue.replace(" ", "+");
            if (!urlText.contains(encodedValue)) {
                missingValues.add(expectedValue);
            }
        }

        if (!missingValues.isEmpty()) {
            Assertions.fail("The following values were not found in the URL: " + String.join(", ", missingValues));
        }
    }
}