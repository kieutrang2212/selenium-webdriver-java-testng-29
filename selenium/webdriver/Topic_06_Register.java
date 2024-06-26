package webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_06_Register {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");
    String username,password;

    @BeforeClass
    public void beforeClass() {
        if (osName.contains("Windows")) {
            System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        } else {
            System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
        }

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void TC_01_Register() {
        // Truy cap vao trang Register- https://demo.guru99.com/
        //Nhap vao 1 email bat ki
        //click Submit button
        // Get username and password luu vao 1 bien

        username = driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText();
        password = driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText();
    }

    @Test
    public void TC_02_Login() {
        //Truy cap vao trang Login-https://demo.guru99.com/V4/
        //Nhap username/password o man hinh Register vao
        driver.findElements(By.name("uid")).sendKeys(username);
        driver.findElements(By.name("password")).sendKeys(password);
    }

    @Test
    public void TC_03_() {

    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
