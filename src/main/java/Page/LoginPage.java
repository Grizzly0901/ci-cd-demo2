package Page;

import Util.WebD;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import javax.swing.*;
import java.nio.charset.StandardCharsets;
import java.sql.Driver;

public class LoginPage {

    private final By usernameLocator = By.id("user-name");
    private final By passwordLocator = By.id("password");
    private final By loginButtonLocator = By.id("login-button");
    private final By errorMessageLocator = By.xpath("//h3[@data-test='error']");

    @Step ("Login with valid value")
    public void login(String username, String password) {
        Allure.step("Enter username: " + username);
        WebD.WEB_DRIVER.findElement(usernameLocator).sendKeys(username);
        Allure.step("Enter password: " + password);
        WebD.WEB_DRIVER.findElement(passwordLocator).sendKeys(password);
        Allure.step("Click button");
        WebD.WEB_DRIVER.findElement(loginButtonLocator).click();
    }




    public String getErrorMessage() {
        return WebD.WEB_DRIVER.findElement(errorMessageLocator).getText();
    }

    public boolean isUsernameDisplayed() {
        return WebD.WEB_DRIVER.findElement(usernameLocator).isDisplayed();
    }

    public boolean isPasswordDisplayed() {
        return WebD.WEB_DRIVER.findElement(passwordLocator).isDisplayed();
    }

    public boolean isLoginButtonDisplayed() {
        return WebD.WEB_DRIVER.findElement(loginButtonLocator).isDisplayed();
    }

}
