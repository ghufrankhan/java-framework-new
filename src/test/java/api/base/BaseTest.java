package api.base;

import config.ConfigLoader;

public class BaseTest {

    protected static String baseUrl;

    public void setUp() {
        baseUrl = ConfigLoader.getApiBaseUrl();
        if (baseUrl.isEmpty()) {
            System.err.println("apiBaseUrl is null or empty in config.properties");
        }
    }
}