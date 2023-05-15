package tests;

import driver.DriverSingleton;
import model.CalculatorFormData;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.googlecloud.EmailYourEstimatePage;
import pages.googlecloud.GoogleCloudHomePage;
import pages.googlecloud.GoogleCloudPricingCalculatorPage;
import pages.yopmail.YOPMailHomePage;
import pages.yopmail.YOPMailInboxPage;
import service.CalculatorFormDataCreator;
import util.TestListener;

@Listeners({TestListener.class})
public class TotalEstimatedMonthlyCostTest {

    protected WebDriver driver;

    @BeforeClass
    public void browserSetUp() {
        driver = DriverSingleton.getDriver();
    }

    @Test(description = "Verifying whether the total cost in the calculator matches the one displayed in the email.")
    public void testCompareTotalEstimatedCosts() {
        new GoogleCloudHomePage(driver)
                .openPage()
                .searchForTerms("Google Cloud Platform Pricing Calculator");
        CalculatorFormData testData = CalculatorFormDataCreator.withDataFromProperties();
        new GoogleCloudPricingCalculatorPage(driver)
                .switchFrames()
                .computeEngineIconClick()
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
                .addToEstimateButtonClick();
        GoogleCloudPricingCalculatorPage calculatorPage = new GoogleCloudPricingCalculatorPage(driver);
        String calculatorTotalCost = calculatorPage.getTotalCost();
        calculatorPage.emailEstimateButtonClick().exitFromFrame();
        new YOPMailHomePage(driver)
                .openNewTab()
                .openPage()
                .generateRandomEmailAddressIconClick()
                .copyEmailAddressIconClick()
                .switchTabs(0);
        calculatorPage.switchFrames();
        new EmailYourEstimatePage(driver)
                .pasteCopiedEmail()
                .sendEmailButtonClick()
                .switchTabs(1);
        new YOPMailInboxPage(driver)
                .checkInboxButtonClick()
                .refreshPage()
                .switchEmailFrame()
                .getTotalCost();
        YOPMailInboxPage emailPage = new YOPMailInboxPage(driver);
        Assert.assertEquals(emailPage.getTotalCost(), calculatorTotalCost, "The total costs do not match.");
    }

    @AfterClass
    public void browserTearDown() {
        driver = null;
        DriverSingleton.closeDriver();
    }
}
