package service;

import java.util.ResourceBundle;

public final class TestDataCalculatorFormReader {

    public static ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("environment", "dev"));

    private TestDataCalculatorFormReader() {
    }

    public static String getTestData(String key) {
        return resourceBundle.getString(key);
    }
}
