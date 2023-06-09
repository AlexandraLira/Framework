package pages.googlecloud;

import model.CalculatorFormData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.base.BasePage;

import java.time.Duration;

public class GoogleCloudPricingCalculatorPage extends BasePage {

    private static final String DROPDOWN_OPTION_XPATH_PATTERN = "//*[contains(@class, 'md-clickable')]//md-option/div[contains(text(), '%s')]";

    @FindBy(xpath = "//*[@id='cloud-site']//iframe")
    private WebElement mainFrame;

    @FindBy(id = "myFrame")
    private WebElement innerFrame;

    @FindBy(xpath = "//div[@title='Compute Engine' and @class='tab-holder compute']")
    private WebElement computeEngineIcon;

    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.quantity']")
    private WebElement numberOfInstancesDropDown;

    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.os']")
    private WebElement operatingSystemSoftwareDropDown;

    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.class']")
    private WebElement provisioningModelDropDown;

    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.series']")
    private WebElement seriesDropDown;

    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.instance']")
    private WebElement machineTypeDropDown;

    @FindBy(xpath = "//*[@aria-label='Add GPUs']")
    private WebElement addGPUsCheckBox;

    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.gpuType']")
    private WebElement gpuTypeDropDown;

    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.gpuCount']")
    private WebElement numberOfGPUsDropDown;

    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.ssd']")
    private WebElement localSSDDropDown;

    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.location']")
    private WebElement dataCenterLocationDropDown;

    @FindBy(xpath = "//*[@ng-model='listingCtrl.computeServer.cud']")
    private WebElement committedUsageDropDown;

    @FindBy(xpath = "//button[@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);']")
    private WebElement addToEstimateButton;

    @FindBy(id = "Email Estimate")
    private WebElement emailEstimateButton;

    @FindBy(xpath = "//div[contains(@class, 'cpc-cart-total')]/h2/b")
    private WebElement totalCostCalculator;

    public GoogleCloudPricingCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudPricingCalculatorPage switchFrames() {
        driver.switchTo().frame(mainFrame);
        driver.switchTo().frame(innerFrame);
        return this;
    }

    public GoogleCloudPricingCalculatorPage exitFromFrame() {
        driver.switchTo().defaultContent();
        return this;
    }

    public GoogleCloudPricingCalculatorPage clickComputeEngineIcon() {
        computeEngineIcon.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage setNumberOfInstances(CalculatorFormData data) {
        numberOfInstancesDropDown.sendKeys(data.getNumberOfInstances());
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectOperatingSystemSoftware(CalculatorFormData data) {
        operatingSystemSoftwareDropDown.click();
        selectDropDownOption(data.getOperatingSystem());
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectProvisioningModel(CalculatorFormData data) {
        provisioningModelDropDown.click();
        selectDropDownOption(data.getModel());
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectSeries(CalculatorFormData data) {
        seriesDropDown.click();
        selectDropDownOption(data.getSeries());
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectMachineType(CalculatorFormData data) {
        machineTypeDropDown.click();
        selectDropDownOption(data.getMachineType());
        return this;
    }

    public GoogleCloudPricingCalculatorPage addGPUsCheckBoxClick() {
        addGPUsCheckBox.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectGPUType(CalculatorFormData data) {
        gpuTypeDropDown.click();
        selectDropDownOption(data.getGpuType());
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectNumberOfGPUs(CalculatorFormData data) {
        numberOfGPUsDropDown.click();
        selectDropDownOption(data.getNumberOfGPUs());
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectLocalSSD(CalculatorFormData data) {
        localSSDDropDown.click();
        selectDropDownOption(data.getSsd());
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectDataCenterLocation(CalculatorFormData data) {
        dataCenterLocationDropDown.click();
        selectDropDownOption(data.getDataCenterLocation());
        return this;
    }

    public GoogleCloudPricingCalculatorPage selectCommittedUsage(CalculatorFormData data) {
        committedUsageDropDown.click();
        selectDropDownOption(data.getCommittedUsage());
        return this;
    }

    public GoogleCloudPricingCalculatorPage clickAddToEstimateButton() {
        addToEstimateButton.click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage clickEmailEstimateButton() {
        emailEstimateButton.click();
        return this;
    }

    public String getTotalCost() {
        return totalCostCalculator.getText()
                .replaceAll("[a-zA-Z]", "").trim()
                .replaceAll("^.|.$", "").trim();
    }

    public void selectDropDownOption(String option) {
        new WebDriverWait(driver, Duration.ofSeconds(WAIT_TIME_1_SECOND))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.format(DROPDOWN_OPTION_XPATH_PATTERN, option))))
                .click();
    }
}
