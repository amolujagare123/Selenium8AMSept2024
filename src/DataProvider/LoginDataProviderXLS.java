package DataProvider;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class LoginDataProviderXLS {

    @Test (dataProvider = "getData")
    public  void loginTest(String username,String password) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stock.scriptinglogic.in/");

        WebElement txtUsername = driver.findElement(By.xpath("//input[@id='login-username']"));
        txtUsername.sendKeys(username);

        WebElement txtPassword = driver.findElement(By.xpath("//input[@id='login-password']"));
        txtPassword.sendKeys(password);

        WebElement btnLogin = driver.findElement(By.xpath("//input[@type='submit']"));
        btnLogin.click();

    }


    @DataProvider
    Object[][] getData() throws IOException {
        // read the file
        FileInputStream fis = new FileInputStream("data/myData2.xlsx");

        // convert the file object into workbook object
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        // get the sheet where your data is
        XSSFSheet sheet = workbook.getSheet("data");
        int rowCount  = sheet.getPhysicalNumberOfRows();

        Object[][] data = new Object[rowCount][2];
        
        for(int i=0;i<rowCount;i++) // 6
        {
            XSSFRow row = sheet.getRow(i);
            
            data[i][0] = row.getCell(0).toString(); // admin
            data[i][1] = row.getCell(1).toString(); // admin
        }

       /* data[0][0] = "admin";
        data[0][1] = "admin";

        data[1][0] = "invalid-1";
        data[1][1] = "invalid-1";

        data[2][0] = "invalid-2";
        data[2][1] = "invalid-2";

        data[3][0] = "invalid-3";
        data[3][1] = "invalid-3";*/

        return data;
    }
}
