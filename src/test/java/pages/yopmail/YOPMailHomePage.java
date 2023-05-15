package pages.yopmail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class YOPMailHomePage extends BasePage {

    private static final String YOP_MAIL_PAGE_URL = "https://yopmail.com/";

    @FindBy(xpath = "//h3[text()='Случайный адрес электронной почты']")
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

    public YOPMailHomePage generateRandomEmailAddressIconClick() {
        waitForElementToBeVisible(10, generateRandomEmailAddressIcon).click();
        return this;
    }

    public YOPMailHomePage copyEmailAddressIconClick() {
        waitForElementToBeVisible(5, copyEmailAddressIcon).click();
        return this;
    }
}
