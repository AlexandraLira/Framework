package pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public abstract class BasePage {

    protected WebDriver driver;
    protected final int WAIT_TIME_1_SECOND = 1;
    protected final int WAIT_TIME_5_SECONDS = 5;
    protected final int WAIT_TIME_10_SECONDS = 10;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openPage(String url) {
        driver.get(url);
    }

    public WebElement waitForElementToBeVisible(int seconds, WebElement element) {
        return new WebDriverWait(driver, Duration.ofSeconds(seconds))
                .until(ExpectedConditions.visibilityOf(element));
    }

    public void switchTabs(int tab) {
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tab));
    }
}
