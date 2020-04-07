package views;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CalculatorHomeView {

    @AndroidFindBy(id = "digit_2")
    public WebElement two;
    @AndroidFindBy(id = "digit_4")
    public WebElement four;
    @AndroidFindBy(id = "op_add")
    public WebElement plus;
    @AndroidFindBy(id = "eq")
    public WebElement equalTo;
    @AndroidFindBy(id = "result")
    public WebElement results;

    public CalculatorHomeView(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
