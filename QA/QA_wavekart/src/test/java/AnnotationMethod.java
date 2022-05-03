import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class AnnotationMethod {

    public WebDriver webDriver;

    @BeforeTest
    public void launchDriver() {
        System.out.println("Inside Before Test");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\prashanthm\\Installations\\chromedriver_win32\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @AfterTest
    public void quitDriver() {
        webDriver.close();
    }

}
