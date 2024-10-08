package xpath;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ViewCustomers {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://stock.scriptinglogic.in/");

        WebElement txtUsername = driver.findElement(By.xpath("//input[@id='login-username']"));
        txtUsername.sendKeys("admin");

        WebElement txtPassword = driver.findElement(By.xpath("//input[@id='login-password']"));
        txtPassword.sendKeys("admin");

        WebElement btnLogin = driver.findElement(By.xpath("//input[@type='submit']"));
        btnLogin.click();

       driver.findElement(By.linkText("Add Customer")).click();
        driver.findElement(By.linkText("View Customers")).click();

        String name = "Siddhu";

       // driver.findElement(By.xpath("//tr[td[text()='"+name+"'] ]/td/input")).click();
       // driver.findElement(By.xpath("//tr[td[text()='"+name+"'] ]//input")).click();
//tr[td[text()='Akansha']]//a[contains(@href,'update')]
        // click on the delete icon of above user

        driver.findElement(By.xpath("//tr[td[text()='"+name+"'] ]//a[contains(@href,'delete')]")).click();


        Alert alert = driver.switchTo().alert();
        alert.accept();

    }
}
