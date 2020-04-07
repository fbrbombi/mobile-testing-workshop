package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import views.CalculatorHomeView;

public class TestsThirdApproach {
    private AndroidDriver driver;
    private CalculatorHomeView calculatorHomeView;
    private AppiumDriverLocalService appiumDriverLocalService;

    @BeforeTest
    public void setUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("BROWSER_NAME", "Android");
        capabilities.setCapability("deviceName", "Emulator");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.android.calculator2");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");

        appiumDriverLocalService = new AppiumServiceBuilder().usingPort(4723).build();
        appiumDriverLocalService.start();
        driver = new AndroidDriver(appiumDriverLocalService, capabilities);
    }

    @Test
    public void testCal() {
        calculatorHomeView = new CalculatorHomeView(driver);
        calculatorHomeView.two.click();
        calculatorHomeView.plus.click();
        calculatorHomeView.four.click();
        calculatorHomeView.equalTo.click();
        String result = calculatorHomeView.results.getText();
        Assert.assertEquals(result, "6");
    }

    @AfterMethod
    public void closeAll() {
        driver.quit();
        appiumDriverLocalService.stop();
    }
}
