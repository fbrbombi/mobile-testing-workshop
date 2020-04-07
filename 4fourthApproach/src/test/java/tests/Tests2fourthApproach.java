package tests;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import views.CalculatorHomeView;

public class Tests2fourthApproach extends Hooks {

    @BeforeMethod
    public void setUp() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Mobile 2");
        capabilities.setCapability("udid", "emulator-5556");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.android.calculator2");
        capabilities.setCapability("systemPort", 8020);

        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        driver.set(new AndroidDriver(appiumDriverLocalService, capabilities));
    }

    @Test
    public void testCalFourthApproach1() {
        CalculatorHomeView calculatorHomeView = new CalculatorHomeView(driver.get());
        calculatorHomeView.two.click();
        calculatorHomeView.plus.click();
        calculatorHomeView.four.click();
        calculatorHomeView.plus.click();
        calculatorHomeView.four.click();
        calculatorHomeView.equalTo.click();
        String result = calculatorHomeView.results.getText();
        Assert.assertEquals(result, "6");
    }

}
