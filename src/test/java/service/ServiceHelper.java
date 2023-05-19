package service;

import model.CalculatorFormData;
import org.openqa.selenium.WebDriver;
import pages.googlecloud.EmailYourEstimatePage;
import pages.googlecloud.GoogleCloudHomePage;
import pages.googlecloud.GoogleCloudPricingCalculatorPage;
import pages.yopmail.YOPMailHomePage;
import pages.yopmail.YOPMailInboxPage;

public class ServiceHelper {

    protected WebDriver driver;

    public ServiceHelper(WebDriver driver) {
        this.driver = driver;
    }

    public void searchForTermOnGoogleCloudHomePage(String searchTerms) {
        new GoogleCloudHomePage(driver)
                .openPage()
                .searchForTerms(searchTerms);
    }

    public void fillInGoogleCloudCalculatorFormOnGoogleCloudPricingCalculatorPage(CalculatorFormData testData) {
        new GoogleCloudPricingCalculatorPage(driver)
                .switchFrames()
                .clickComputeEngineIcon()
                .setNumberOfInstances(testData)
                .selectOperatingSystemSoftware(testData)
                .selectProvisioningModel(testData)
                .selectSeries(testData)
                .selectMachineType(testData)
                .addGPUsCheckBoxClick()
                .selectGPUType(testData)
                .selectNumberOfGPUs(testData)
                .selectLocalSSD(testData)
                .selectDataCenterLocation(testData)
                .selectCommittedUsage(testData)
                .clickAddToEstimateButton();
    }

    public void generationAndCopyRandomEmailAddressInNewTabOnYOPMail() {
        new YOPMailHomePage(driver)
                .openNewTab()
                .openPage()
                .clickGenerateRandomEmailAddressIcon()
                .clickCopyEmailAddressIcon()
                .switchTabs(0);
    }

    public void sendEmailToGeneratedEmailOnEmailYourEstimatePage() {
        new EmailYourEstimatePage(driver)
                .pasteCopiedEmail()
                .sendEmailButtonClick()
                .switchTabs(1);
    }

    public String getTotalCostFromEmailOnYOPMailInboxPage() {
        return new YOPMailInboxPage(driver)
                .clickCheckInboxButton()
                .refreshPage()
                .switchEmailFrame()
                .getTotalCost();
    }

}
