package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Hooks {
    protected static AppiumDriverLocalService appiumDriverLocalService;
    protected ThreadLocal<AndroidDriver> driver = new ThreadLocal<AndroidDriver>();

    @BeforeSuite
    public void oneTimeSetUp(){
        appiumDriverLocalService = new AppiumServiceBuilder().usingPort(4723).build();
        appiumDriverLocalService.start();
    }

    @AfterSuite
    public void afterAll(){
        appiumDriverLocalService.stop();
    }
}
