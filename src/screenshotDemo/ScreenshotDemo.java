package screenshotDemo;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotDemo {

    @Test
    public void myTest() throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://facebook.com");

        // 1. create the object reference of TakesScreenshot
        // assign driver to it. type cast it to  TakesScreenshot
        TakesScreenshot ts = (TakesScreenshot) driver;

        String timeStamp = new SimpleDateFormat("_yyyyddMM_hhmmss").format(new Date());
        String fileName = "IMG"+timeStamp+".png";
        // 2. call the method getScreenshotAs using ts
        File srcFile = ts.getScreenshotAs(OutputType.FILE);

        // 3. copy this file object into a real image file
        FileUtils.copyFile(srcFile,new File("D:\\screenshots\\"+fileName));
    }
}
