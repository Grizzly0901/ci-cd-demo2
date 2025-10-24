package PageTest;

import Base.TestBase;
import Page.CheckoutPage;
import Page.HomePage;
import Page.LoginPage;
import Util.WebD;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class CheckoutPageTest extends TestBase {

    CheckoutPage checkoutPage = new CheckoutPage();
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();


    @Test
    public void Test11() throws InterruptedException {
        loginPage.login("standard_user", "secret_sauce");
        homePage.clickRandomAddToCart();
        homePage.clickCartButton();
        checkoutPage.clickCheckout();

        // checkoutPage.fillCheckoutForm("Marry", "", "55000");
        // checkoutPage.clickContinue();
        // Assert.assertEquals(checkoutPage.getErrorText(), "Error: Last Name is required");
        // checkoutPage.clearForm();

        // Thread.sleep(5000);
        // checkoutPage.fillCheckoutForm("", "Jane", "55000");
        // Thread.sleep(5000);
        // checkoutPage.clickContinue();
        // Assert.assertEquals(checkoutPage.getErrorText(), "Error: First Name is required");
        // checkoutPage.clearForm();

        // Thread.sleep(5000);
        // checkoutPage.fillCheckoutForm("Marry", "Jane", "");
        // Thread.sleep(5000);
        // checkoutPage.clickContinue();
        // Assert.assertEquals(checkoutPage.getErrorText(), "Error: First name is required");
        // checkoutPage.clearForm();


    }
}
