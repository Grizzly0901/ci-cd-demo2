package Base;

import Util.WebD;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {


    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito", "--headless=new", "--no-sandbox", "--disable-dev-shm-usage");
        WebD.WEB_DRIVER = new ChromeDriver(options);
        WebD.WEB_DRIVER.get("https://www.saucedemo.com/");
        WebD.WEB_DRIVER_WAIT = new WebDriverWait(WebD.WEB_DRIVER, Duration.ofSeconds(10));
    }

    @AfterMethod
    public void cleanUp() {
        WebD.WEB_DRIVER.close();
    }
}
