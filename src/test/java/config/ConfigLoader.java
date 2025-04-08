package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {

    private static final Properties properties = new Properties();

    // Loads the config file shown iin the path when the class is initialised
    static {
        String configPath = System.getProperty("config.path", "src/test/resources/config.properties");
        try (InputStream input = new FileInputStream(configPath)) {
            properties.load(input);
        } catch (IOException ex) {
            throw new RuntimeException("Error loading configuration file: " + configPath, ex);
        }
    }

    // Gets the property value by key
    public static String getProperty(String key) {
        String value = properties.getProperty(key);
        if (value == null) {
            throw new IllegalArgumentException("Property not found: " + key);
        }
        return value;
    }

    // Gets the Base URL for the UI tests
    public static String getUiBaseUrl() {
        return getProperty("uiBaseUrl");
    }

    // Gets the Browser for the UI tests
    public static String getBrowser() {
        return getProperty("browser");
    }

    // Gets the Base URL for the API tests
    public static String getApiBaseUrl() {
        return getProperty("apiBaseUrl");
    }
}