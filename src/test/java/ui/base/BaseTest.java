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

        driver.manage().window().maximize();

        if (!baseUrl.isEmpty()) {
            driver.get(baseUrl);
        } else {
            System.err.println("Base URL is null or empty in config.properties");
        }
    }

    public void takeScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "View Screenshot");
        }
    }


    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
}