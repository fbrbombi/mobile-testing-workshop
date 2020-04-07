package tests;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import views.CalculatorHomeView;

public class TestsFourthApproach extends Hooks {

    @BeforeMethod
    public void setUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Pixel 2 API 28");
        capabilities.setCapability("udid", "emulator-5554");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.android.calculator2");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        capabilities.setCapability("systemPort", 8010);

        driver.set(new AndroidDriver(appiumDriverLocalService, capabilities));
    }

    @Test
    public void testCalFourthApproach2() {
        CalculatorHomeView calculatorHomeView = new CalculatorHomeView(driver.get());
        calculatorHomeView.two.click();
        calculatorHomeView.plus.click();
        calculatorHomeView.four.click();
        calculatorHomeView.equalTo.click();
        String result = calculatorHomeView.results.getText();
        Assert.assertEquals(result, "6");
    }

}
