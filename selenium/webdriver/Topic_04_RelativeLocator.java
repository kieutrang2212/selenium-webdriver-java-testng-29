package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_04_RelativeLocator {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {
        if (osName.contains("Windows")) {
            System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        } else {
            System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
        }

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/login?returnUrl=%2Fregister");
    }

    @Test
    public void TC_01_Relative() {
        By loginButonBy= By.cssSelector("button.login-button");
//        RelativeLocator.with(By.tagName("label")).above(loginButonBy);

        // Remember Me Checkbox
        By rememberMeCheckboxBy= By.id("RememberMe");
        WebElement rememberMeCheckbox = driver.findElement(rememberMeCheckboxBy);

        //Forgot Password
        WebElement forgotPasswordElement=  driver.findElement(By.cssSelector("span.forgot-password"));

        WebElement rememberMeTextElement= driver.findElement(RelativeLocator.with(By.tagName("label")).above(loginButonBy).toRightOf(rememberMeCheckbox).toLeftOf(forgotPasswordElement));
//      RelativeLocator.with(By.tagName("label")).toRightOf(rememberMeCheckbox);
        System.out.println(rememberMeTextElement.getText());

    }

    @Test
    public void TC_02_() {

    }

    @Test
    public void TC_03_() {

    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
