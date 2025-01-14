package jasmin.batch.copypaste;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class CopyAndPaste {
    WebDriver driver;
    @BeforeSuite

    public void startChromeBrowser(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test

    public void openURL() throws InterruptedException {
        driver.get("https://practicetestautomation.com/practice-test-login/");
        Thread.sleep(5000);

        Actions action= new Actions(driver);
        WebElement usernameCopy = driver.findElement(By.xpath("(//b[contains(text(),'student')])[1]"));

        //copy username
        action.doubleClick(usernameCopy);
        action.keyDown(Keys.CONTROL);
        action.sendKeys("c");
        action.keyUp(Keys.CONTROL);
        action.build().perform();
        Thread.sleep(3000);

        // username
        WebElement user = driver.findElement(By.id("username"));
        user.click();

        action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
        Thread.sleep(3000);

        WebElement password = driver.findElement(By.xpath("(//b[contains(text(),'Password123')])[1]"));

        //Password copy
        action.doubleClick(password);
        action.keyDown(Keys.CONTROL);
        action.sendKeys("c");
        action.keyUp(Keys.CONTROL);
        action.build().perform();
        Thread.sleep(3000);


        // password
        WebElement pass = driver.findElement(By.id("password"));
        pass.click();

        action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
        Thread.sleep(3000);

        WebElement login = driver.findElement(By.id("submit"));
        login.click();
        Thread.sleep(3000);

        WebElement element = driver.findElement(By.xpath("//h1[contains(text(),'Logged In Successfully')]"));
        Thread.sleep(3000);
    }
    @AfterSuite

    public void closeChromeBrowser(){
        driver.close();
    }
}

