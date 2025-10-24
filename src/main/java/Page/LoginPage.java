package Page;

import Util.WebD;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


public class LoginPage {

    private final By usernameLocator = By.id("user-name");
    private final By passwordLocator = By.id("password");
    private final By loginButtonLocator = By.id("login-button");
    private final By errorMessageLocator = By.xpath("//h3[@data-test='error']");

    @Step ("Login with valid value")
    public void login(String username, String password) {
        Allure.step("Enter username: " + username);
        WebD.getWebDriver().findElement(usernameLocator).sendKeys(username);
        Allure.step("Enter password: " + password);
        WebD.getWebDriver().findElement(passwordLocator).sendKeys(password);
        Allure.step("Click button");
        WebD.getWebDriver().findElement(loginButtonLocator).click();
    }




    public String getErrorMessage() {
        return WebD.getWebDriver().findElement(errorMessageLocator).getText();
    }

    public boolean isUsernameDisplayed() {
        return WebD.getWebDriver().findElement(usernameLocator).isDisplayed();
    }

    public boolean isPasswordDisplayed() {
        return WebD.getWebDriver().findElement(passwordLocator).isDisplayed();
    }

    public boolean isLoginButtonDisplayed() {
        return WebD.getWebDriver().findElement(loginButtonLocator).isDisplayed();
    }

}
