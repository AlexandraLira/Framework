package pages.yopmail;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class YOPMailInboxPage extends BasePage {

    @FindBy(id = "ifmail")
    private WebElement emailFrame;

    @FindBy(xpath = "//button[2][@class='md but text f24 egenbut']")
    private WebElement checkInboxButton;

    @FindBy(id = "nbmail")
    private WebElement amountOfEmails;

    @FindBy(id = "refresh")
    private WebElement refreshButton;

    @FindBy(xpath = "//*[text()='Total Estimated Monthly Cost']/parent::*/following-sibling::*/h3")
    private WebElement totalCostEmail;

    public YOPMailInboxPage(WebDriver driver) {
        super(driver);
    }

    public YOPMailInboxPage checkInboxButtonClick() {
        checkInboxButton.click();
        return this;
    }

    public YOPMailInboxPage switchEmailFrame() {
        driver.switchTo().frame(emailFrame);
        return this;
    }

    public YOPMailInboxPage refreshPage() {
        while (amountOfEmails.getText().contains("0 mail")) refreshButton.click();
        return this;
    }

    public String getTotalCost() {
        return totalCostEmail.getText().replaceAll("[a-zA-Z]", "").trim();
    }
}
