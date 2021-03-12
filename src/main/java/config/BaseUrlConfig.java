package config;

public class BaseUrlConfig {
    private static PropertyLoader propertyLoader = new PropertyLoader("config.properties");

    private static final String rateAPIHost = propertyLoader.getProperty("RATE_API_HOST");

    public static String getRateAPIHost() {
        return rateAPIHost;
    }
}
