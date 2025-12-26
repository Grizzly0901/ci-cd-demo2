package Base;

import Util.WebD;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {

    @BeforeMethod
    public void setUp() {
//        WebDriverManager.chromedriver().setup();
//
//        ChromeOptions options = new ChromeOptions();
//
//        // 🔹 Các tùy chọn cần thiết cho môi trường CI/CD
//        options.addArguments("--no-sandbox");
//        options.addArguments("--disable-dev-shm-usage");
//        options.addArguments("--remote-allow-origins=*");
//        options.addArguments("--headless=new"); // Bắt buộc trong GitHub Actions (không có GUI)
//
//        // 🔹 Fix lỗi: "user data directory is already in use"
//        options.addArguments("--user-data-dir=/tmp/chrome-" + System.currentTimeMillis());
//
//        // 🔹 Giữ incognito nếu m thích
//        options.addArguments("--incognito");
//
//        WebD.setDrivers(new ChromeDriver(options));
//
//        WebD.getWebDriver().manage().window().maximize();
//
//        new WebDriverWait(WebD.getWebDriver(), Duration.ofSeconds(10));

        ChromeOptions options = new ChromeOptions();
        options.addArguments(new String[]{"--guest"});
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");
        WebD.setDrivers(new ChromeDriver(options));
        WebD.getWebDriver().get("https://www.saucedemo.com/");
        new WebDriverWait(WebD.getWebDriver(), Duration.ofSeconds(5000));
    }

    @AfterMethod
    public void cleanUp() {
        WebD.getWebDriver().close();
    }
}
