package ui.base;

import config.ConfigLoader;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BaseTest {

    protected static WebDriver driver;

    // Sets the Browser and Base URL for the UI tests - called by the Hooks class
    public void setUp() {
        String browser = ConfigLoader.getBrowser();
        String baseUrl = ConfigLoader.getUiBaseUrl();

        switch (browser.toLowerCase()) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
        }

        // Maximize the browser window
        driver.manage().window().maximize();

        // Navigate to the Base URL
        if (!baseUrl.isEmpty()) {
            driver.get(baseUrl);
        } else {
            System.err.println("Base URL is null or empty in config.properties");
        }
    }

    // Takes a screenshot of the failed scenario and attaches it to the report
    public void takeScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "View Screenshot");
        }
    }

    // Quits the driver after each scenario
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Gets the driver for the UI tests
    public static WebDriver getDriver() {
        return driver;
    }
}