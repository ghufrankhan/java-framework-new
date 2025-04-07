package ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class StartPage extends CommonPage {

    private final By textInputField = By.id("my-text-id");
    private final By passwordField = By.name("my-password");
    private final By textareaInput = By.name("my-textarea");
    private final By dropdownSelect = By.name("my-select");
    private final By datalistInput = By.name("my-datalist");
    private final By submitButton = By.cssSelector("button[type='submit']");


    public StartPage(WebDriver driver) {
        super(driver);
    }

    public void enterTextInTextInputField(String text) {
        driver.findElement(textInputField).sendKeys(text);
    }

    public void enterPasswordInPasswordField(String text) {
        driver.findElement(passwordField).sendKeys(text);
    }

    public void enterTextInTextAreaInput(String text) {
        driver.findElement(textareaInput).sendKeys(text);
    }

    public void selectFromDropdownByVisibleText(String text) {
        Select dropdown = new Select(driver.findElement(dropdownSelect));
        dropdown.selectByVisibleText(text);
    }

    public void selectFromDatalist(String text) {
        driver.findElement(datalistInput).sendKeys(text);
    }

    public void clickSubmitButton() {
        driver.findElement(submitButton).click();
    }
}