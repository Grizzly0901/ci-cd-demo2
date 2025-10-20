package PageTest;

import Base.TestBase;
import Page.HomePage;
import Page.LoginPage;
import Util.WebD;
import io.qameta.allure.Allure;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();


    @Test
    public void Test06() {
        loginPage.login("locked_out_user", "secret_sauce");
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Sorry, this user has been locked out.");
    }

    public void Test062() {
        String username = "standard_user";
        loginPage.login("standard_user", "b2$34572cjk#");
        Assert.assertEquals(loginPage.getErrorMessage(), "Epic sadface: Username and password do not match any user in this service");
    }


}
