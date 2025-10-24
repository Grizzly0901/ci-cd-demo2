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

        // 🔹 Các tùy chọn cần thiết cho môi trường CI/CD
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--headless=new"); // Bắt buộc trong GitHub Actions (không có GUI)

        // 🔹 Fix lỗi: "user data directory is already in use"
        options.addArguments("--user-data-dir=/tmp/chrome-" + System.currentTimeMillis());

        // 🔹 Giữ incognito nếu m thích
        options.addArguments("--incognito");

        WebD.setDrivers(new ChromeDriver(options));

        WebD.getWebDriver().manage().window().maximize();
        WebD.getWebDriver().get("https://www.saucedemo.com/");

        new WebDriverWait(WebD.getWebDriver(), Duration.ofSeconds(10));
    }

    @AfterMethod
    public void cleanUp() {
        if (WebD.getWebDriver() != null) {
            WebD.getWebDriver().quit(); // ✅ Dùng quit() để đóng hoàn toàn session
        }
    }
}
