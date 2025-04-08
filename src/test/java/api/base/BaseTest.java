package api.base;

import config.ConfigLoader;

public class BaseTest {

    protected static String baseUrl;

    // Sets the Base URL for the API tests - called by the Hooks class
    public void setUp() {
        baseUrl = ConfigLoader.getApiBaseUrl();
        if (baseUrl.isEmpty()) {
            System.err.println("apiBaseUrl is null or empty in config.properties");
        }
    }
}