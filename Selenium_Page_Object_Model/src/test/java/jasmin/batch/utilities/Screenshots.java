package jasmin.batch.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;

public class Screenshots {
    public static String capture(WebDriver driver, String screenShotName) throws IOException {

        // Cast the WebDriver instance to TakesScreenshot to enable screenshot capturing
        TakesScreenshot ts = (TakesScreenshot) driver;

        // Capture the screenshot and store it as a File object
        File source = ts.getScreenshotAs(OutputType.FILE);

        // Construct the destination path for the screenshot file
        String dest = System.getProperty("user.dir") + "\\screenshots\\" + screenShotName + ".jpg";

        // Create a new File object for the destination path
        File destination = new File(dest);

        // Copy the screenshot file to the destination path
        FileUtils.copyFile(source, destination);

        // Return the destination path of the screenshot
        return dest;
    }

}
