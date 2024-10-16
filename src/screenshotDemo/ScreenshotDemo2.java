package screenshotDemo;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotDemo2 {

    @Test
    public void myTest() throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://facebook.com");

        // 1. create the web element whose screenshot to be taken

        //WebElement element = driver.findElement(By.xpath("//button[@name='login']"));
        WebElement element = driver.findElement(By.xpath("//div[@class='_6luv _52jv']"));


        String timeStamp = new SimpleDateFormat("_yyyyddMM_hhmmss").format(new Date());
        String fileName = "IMG"+timeStamp+".png";
        // 2. call the method getScreenshotAs using ts
        File srcFile = element.getScreenshotAs(OutputType.FILE);

        // 3. copy this file object into a real image file
        FileUtils.copyFile(srcFile,new File("D:\\screenshots\\"+fileName));
    }
}
