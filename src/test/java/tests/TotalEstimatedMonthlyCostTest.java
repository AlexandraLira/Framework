package tests;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.googlecloud.GoogleCloudPricingCalculatorPage;
import service.CalculatorFormDataCreator;
import service.ServiceHelper;
import util.TestListener;

@Listeners({TestListener.class})
public class TotalEstimatedMonthlyCostTest {

    private ServiceHelper serviceHelper;
    private WebDriver driver;

    @BeforeClass
    public void browserSetUp() {
        driver = DriverSingleton.getDriver();
        serviceHelper = new ServiceHelper(driver);
    }

    @Test(description = "Verifying whether the total cost in the calculator matches the one displayed in the email.")
    public void compareTotalEstimatedCostsTest() {
        serviceHelper.searchForTermOnGoogleCloudHomePage("Google Cloud Platform Pricing Calculator");
        serviceHelper.fillInGoogleCloudCalculatorFormOnGoogleCloudPricingCalculatorPage(CalculatorFormDataCreator.getDataFromProperties());
        GoogleCloudPricingCalculatorPage calculatorPage = new GoogleCloudPricingCalculatorPage(driver);
        String calculatorTotalCost = calculatorPage.getTotalCost();
        calculatorPage
                .clickEmailEstimateButton()
                .exitFromFrame();
        serviceHelper.generationAndCopyRandomEmailAddressInNewTabOnYOPMail();
        calculatorPage.switchFrames();
        serviceHelper.sendEmailToGeneratedEmailOnEmailYourEstimatePage();
        Assert.assertEquals(serviceHelper.getTotalCostFromEmailOnYOPMailInboxPage(), calculatorTotalCost, "The total costs do not match.");
    }

    @AfterClass
    public void browserTearDown() {
        driver = null;
        DriverSingleton.closeDriver();
    }
}
