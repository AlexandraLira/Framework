package util;

import driver.DriverSingleton;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TestListener implements ITestListener {

    private final Logger log = LogManager.getRootLogger();

    public void onTestStart(ITestResult result) {
        log.info("Test {} started successfully", result.getName());
    }

    public void onTestSuccess(ITestResult result) {
        log.info("Test {} passed successfully", result.getName());
    }

    public void onTestFailure(ITestResult result) {
        log.info("Test {} failed", result.getName());
        saveScreenshot();
    }

    public void onTestSkipped(ITestResult result) {
        log.info("Test {} skipped", result.getName());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // no need to log message here
    }

    public void onTestFailedWithTimeout(ITestResult result) {
        this.onTestFailure(result);
    }

    public void onStart(ITestContext context) {
        log.info("Test suite {} started", context.getSuite().getName());

    }

    public void onFinish(ITestContext context) {
        log.info("Test suite {} finished", context.getSuite().getName());
    }

    private void saveScreenshot() {
        log.info("Saving screenshot...");
        File screenCapture = ((TakesScreenshot) DriverSingleton
                .getDriver())
                .getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenCapture, new File(
                    ".//target/screenshots/"
                            + getCurrentTimeAsString() +
                            ".png"));
        } catch (IOException e) {
            log.error("Failed to save screenshot: " + e.getLocalizedMessage());
        }
    }

    private String getCurrentTimeAsString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd_HH-mm-ss");
        return ZonedDateTime.now().format(formatter);
    }
}
