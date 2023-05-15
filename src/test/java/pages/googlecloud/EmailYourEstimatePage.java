package pages.googlecloud;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class EmailYourEstimatePage extends BasePage {

    @FindBy(xpath = "//*[@ng-model='emailQuote.user.email']")
    private WebElement emailField;

    @FindBy(xpath = "//*[@ng-click='emailQuote.emailQuote(true); emailQuote.$mdDialog.hide()']")
    private WebElement sendEmailButton;

    public EmailYourEstimatePage(WebDriver driver) {
        super(driver);
    }

    public EmailYourEstimatePage pasteCopiedEmail() {
        emailField.sendKeys(Keys.CONTROL + "V");
        return this;
    }

    public EmailYourEstimatePage sendEmailButtonClick() {
        sendEmailButton.click();
        return this;
    }

}
