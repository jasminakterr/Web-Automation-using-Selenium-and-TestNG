package jasmin.batch.assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertion {
    WebDriver driver;
    @BeforeSuite

    public void startChromeBrowser(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test

    public void openURL() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        Thread.sleep(5000);

        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualTitle,expectedTitle,"Don't match the title");

        WebElement addElement= driver.findElement(By.xpath("//button[contains(text(),'Add Element')]"));
        addElement.click();
        Thread.sleep(5000);

        WebElement remove= driver.findElement(By.xpath("//button[contains(text(),'Delete')]"));
        softAssert.assertTrue(remove.isDisplayed(),"Delete button isn't displayed");
        Thread.sleep(5000);

        String actualText = remove.getText();
        String expectedText = "Delete";
        softAssert.assertEquals(actualText, expectedText, "Delete text did not match");
        Thread.sleep(5000);
    }
    @AfterSuite

    public void closeChromeBrowser(){

        driver.quit();
    }
}

