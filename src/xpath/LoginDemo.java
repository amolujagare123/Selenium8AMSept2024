package xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginDemo {

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

       // driver.findElement(By.linkText("Add Customer")).click();
        driver.findElement(By.xpath("//a[@href='add_customer.php']")).click();

        driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Saloni");
        driver.findElement(By.xpath("//*[@name='address']")).sendKeys("xyz");
        driver.findElement(By.xpath("//input[@name='contact1']")).sendKeys("5454545");
        driver.findElement(By.xpath("//input[@name='contact2']")).sendKeys("5454545");

        driver.findElement(By.xpath("//input[@type='submit']")).click();


    }
}
