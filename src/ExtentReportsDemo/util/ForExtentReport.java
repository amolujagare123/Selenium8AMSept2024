package ExtentReportsDemo.util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ForExtentReport {


    public static String takeScreenshot(WebDriver driver) throws IOException {

        // 1. create the object reference of TakesScreenshot
        // assign driver to it. type cast it to  TakesScreenshot
        TakesScreenshot ts = (TakesScreenshot) driver;

        String timeStamp = new SimpleDateFormat("_yyyyddMM_hhmmss").format(new Date());
        String fileName = "IMG"+timeStamp+".png";
        // 2. call the method getScreenshotAs using ts
        File srcFile = ts.getScreenshotAs(OutputType.FILE);

        // 3. copy this file object into a real image file
        FileUtils.copyFile(srcFile,new File("Report\\screenshots\\"+fileName));

        return fileName;
    }
}
