package Util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebD {

    public static final ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

    public static void setDrivers ( WebDriver driver ) {
        drivers.set(driver);
    }

    public static WebDriver getWebDriver() {
       return drivers.get();
    }

    public static WebDriverWait getWebDriverWait() {
        return new WebDriverWait(
                getWebDriver(), Duration.ofSeconds(10)
        );
    }


//    public static WebDriver getWebDriver();
//    public static WebDriverWait getWebDriver()_WAIT;

}

