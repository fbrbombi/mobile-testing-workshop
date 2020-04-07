package tests;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import views.CalculatorHomeView;

import java.net.MalformedURLException;
import java.net.URL;

public class TestSecondApproach {
    private AndroidDriver driver;
    private CalculatorHomeView calculatorHomeView;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("BROWSER_NAME", "Android");
        capabilities.setCapability("deviceName", "Emulator");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("appPackage", "com.android.calculator2");
        capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
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
        driver.quit();
    }
}
