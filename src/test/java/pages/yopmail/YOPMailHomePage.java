package pages.yopmail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class YOPMailHomePage extends BasePage {

    private static final String YOP_MAIL_PAGE_URL = "https://yopmail.com/";

    @FindBy(xpath = "//*[@id='listeliens']/a[@href='email-generator']")
    private WebElement generateRandomEmailAddressIcon;

    @FindBy(xpath = "//span[@class='notmobile']")
    private WebElement copyEmailAddressIcon;

    public YOPMailHomePage(WebDriver driver) {
        super(driver);
    }

    public YOPMailHomePage openPage() {
        super.openPage(YOP_MAIL_PAGE_URL);
        return this;
    }

    public YOPMailHomePage openNewTab() {
        driver.switchTo().newWindow(WindowType.TAB);
        return this;
    }

    public YOPMailHomePage clickGenerateRandomEmailAddressIcon() {
        waitForElementToBeVisible(WAIT_TIME_10_SECONDS, generateRandomEmailAddressIcon).click();
        return this;
    }

    public YOPMailHomePage clickCopyEmailAddressIcon() {
        waitForElementToBeVisible(WAIT_TIME_5_SECONDS, copyEmailAddressIcon).click();
        return this;
    }
}
