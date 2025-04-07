package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CommonPage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    private final By pageTitle = By.cssSelector("h1");

    public CommonPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getPageTitle() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle));
        return driver.findElement(pageTitle).getText();
    }
}