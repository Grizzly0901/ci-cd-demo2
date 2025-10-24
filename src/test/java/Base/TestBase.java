package Base;

import Util.WebD;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        WebD.setDrivers(new ChromeDriver(options));
        WebD.getWebDriver().manage().window().maximize();
        WebD.getWebDriver().get("https://www.saucedemo.com/");
        WebDriverWait wait = new WebDriverWait(WebD.getWebDriver(), Duration.ofSeconds(10));
    }

    @AfterMethod
    public void cleanUp() {
        WebD.getWebDriver().close();
    }
}
