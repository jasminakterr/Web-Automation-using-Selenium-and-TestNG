package jasmin.batch.webelements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class SendkeysCommand {

    WebDriver driver;

    @BeforeSuite

    public void startChromeBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test

    public void openURL() throws InterruptedException {
        driver.get("https://practicetestautomation.com/practice-test-login/");
        Thread.sleep(5000);



        WebElement userName= driver.findElement(By.name("username"));
        userName.sendKeys("student");
        Thread.sleep(5000);

        WebElement password= driver.findElement(By.name("password"));
        password.sendKeys("Password123");
        Thread.sleep(5000);

    }

    @AfterSuite

    public void closeChromeBrowser() {

        driver.close();
    }
}

