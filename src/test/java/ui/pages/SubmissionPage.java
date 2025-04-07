package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SubmissionPage extends CommonPage {

    private final By message = By.id("message");

    public SubmissionPage(WebDriver driver) {
        super(driver);
    }

    public String getMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(message));
        return driver.findElement(message).getText();
    }

    public String getUrlText(){
        return driver.getCurrentUrl();
    }
}