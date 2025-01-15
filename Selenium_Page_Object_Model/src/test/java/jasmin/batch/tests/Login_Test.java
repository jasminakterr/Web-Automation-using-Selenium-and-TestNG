package jasmin.batch.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import jasmin.batch.basedrivers.PageDriver;
import jasmin.batch.pages.Login_Page;
import jasmin.batch.utilities.CommonMethods;
import jasmin.batch.utilities.ExtentFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class Login_Test extends CommonMethods {
    ExtentReports extent;
    ExtentTest parentTest;
    ExtentTest childTest;

    @BeforeClass
    public void open_url() throws InterruptedException {
        PageDriver.getCurrentDriver().get(url);
        sleep();
        extent = ExtentFactory.getInstance();
        parentTest = extent.createTest("<p style=\"color:orange; font-size:13px\"><b>Orange HRM</b></p>").assignAuthor("Tester").assignDevice("Windows");
    }

    @Test
    public void orangehrm_login() throws IOException {
        childTest = parentTest.createNode("<p style=\"color:blue; font-size:13px\"><b>Login</b></p>");
        Login_Page login_page = new Login_Page(childTest);
        login_page.login();
    }

    @AfterClass
    public void report(){
        extent.flush();
    }
}

