import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class TestCase {
    private WebDriver webDriver;

    @BeforeTest
    public void launchDriver() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\prashanthm\\Installations\\chromedriver_win32\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("http://pkhw22ds2xds.cloud.wavemakeronline.com/WaveKart/#/Main");
        webDriver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        webDriver.get(webDriver.getCurrentUrl());
    }

    @AfterTest
    public void quitDriver() {
        webDriver.close();
    }

    @Test
    public void credentials() {
        webDriver.findElement(By.xpath("//input[@name='j_username']")).sendKeys("user");
        webDriver.findElement(By.xpath("//input[@name= 'j_password']")).sendKeys("user");
        webDriver.findElement(By.xpath("//button[@name='loginbutton']")).sendKeys(Keys.ENTER);
    }

    @Test
    public void adminCredentials() {
        webDriver.findElement(By.xpath("//input[@name='j_username']")).sendKeys("admin");
        webDriver.findElement(By.xpath("//input[@name= 'j_password']")).sendKeys("admin");
        webDriver.findElement(By.xpath("//button[@name='loginbutton']")).sendKeys(Keys.ENTER);
    }

    @Test(description = "Load a Wave-kart page")
    public void homePage() {
        webDriver.get("http://pkhw22ds2xds.cloud.wavemakeronline.com/WaveKart/#/Main");
    }

    @Test(description = "login check for users/admin")
    public void loginCheck() {
        webDriver.findElement(By.xpath("//a[@name='Login']")).click();
        credentials();
    }

    @Test(description = "search a product")
    public void search() {
        webDriver.findElement(By.xpath("//input[@name='productSearch']")).sendKeys("canon");
        webDriver.findElement(By.xpath("//button[@title='Search']")).click();
    }

    @Test(description = "navigate to the item in hot pick")
    public void hotPicksNav() {
        webDriver.findElement(By.xpath("//div[@name='card_content_Cameras']")).click();
    }

    @Test(description = "Add an item to cart ")
    public void addToCart() {
        webDriver.findElement(By.xpath("//div[@name='card_content_Cameras']")).click();
        webDriver.findElement(By.xpath("//button[@name='AddToCart']")).click();
        credentials();
    }

    @Test(description = "sort the laptops ")
    public void sortLaptops() {
        webDriver.findElement(By.xpath("//a[@name='ProductsPage']")).click();
        webDriver.findElement(By.xpath("//a[@name='Laptops']")).click();
    }

    @Test(description = "Admin Login")
    public void adminLogin() {
        webDriver.findElement(By.xpath("//a[@name='Login']")).click();
        adminCredentials();
    }
}
