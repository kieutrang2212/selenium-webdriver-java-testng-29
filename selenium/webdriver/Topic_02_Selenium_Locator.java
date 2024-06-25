package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_02_Selenium_Locator {
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
        driver.get("https://demo.nopcommerce.com/register");
    }

//    TestNG:   Order testcase theo Alphabet(0-9 A-Z)
    @Test
    public void TC_01_ID() {
        driver.findElement(By.id("FirstName"));
    }

    @Test
    public void TC_02_Class() {
        driver.findElement(By.className("header-logo"));

    }

    @Test
    public void TC_03_Name() {
        driver.findElement(By.name("DateOfBirthDay"));
    }

    @Test
    public void TC_04_TagName() {
        driver.findElements(By.tagName("input"));
    }

    @Test
    public void TC_05_LinkText() {
        driver.findElements(By.linkText("Shipping & returns"));
    }

    @Test
    public void TC_06_Partial_LinkText() {
        driver.findElements(By.partialLinkText("Shipping"));
    }

    @Test
    public void TC_07_Partial_Css() {
        driver.findElements(By.linkText("Shipping"));
    }


    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
