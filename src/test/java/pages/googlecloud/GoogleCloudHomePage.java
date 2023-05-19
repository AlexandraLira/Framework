package pages.googlecloud;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class GoogleCloudHomePage extends BasePage {

    private static final String GOOGLE_CLOUD_PAGE_URL = "https://cloud.google.com/";

    @FindBy(xpath = "//*[@aria-label='Search']")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@data-ctorig='https://cloud.google.com/products/calculator']")
    private WebElement calculatorPageLink;

    public GoogleCloudHomePage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudHomePage openPage() {
        super.openPage(GOOGLE_CLOUD_PAGE_URL);
        return this;
    }

    public GoogleCloudHomePage searchForTerms(String searchTerm) {
        searchButton.click();
        searchButton.sendKeys(searchTerm + Keys.ENTER);
        waitForElementToBeVisible(WAIT_TIME_10_SECONDS, calculatorPageLink).click();
        return this;
    }
}
