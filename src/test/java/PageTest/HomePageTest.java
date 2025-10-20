package PageTest;

import Base.TestBase;
import Page.DetailPage;
import Page.HomePage;
import Page.LoginPage;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    DetailPage detailPage = new DetailPage();

    @Test
    public void Test07() {
//        loginPage.login("standard_user", "secret_sauce");
//        Assert.assertTrue(loginPage.isUsernameDisplayed(), "Username textbox is not displayed");
//        Assert.assertTrue(loginPage.isPasswordDisplayed(), "Password textbox is not displayed");
//        Assert.assertTrue(loginPage.isLoginButtonDisplayed(),"Login button is not displayed");
//        homePage.Logout();


            Assert.assertTrue(loginPage.isUsernameDisplayed(), "Username textbox is not displayed");
            Assert.assertTrue(loginPage.isPasswordDisplayed(), "Password textbox is not displayed");
            Assert.assertTrue(loginPage.isLoginButtonDisplayed(), "Login button is not displayed");

            loginPage.login("standard_user", "secret_sauce");
                homePage.Logout();


    }

    
    @Test
    public void Test09() {

        Allure.step("Login");
        loginPage.login("standard_user", "secret_sauce");
        Allure.step("Random product");
        homePage.randomProduct(2);
    }

    @Test
    public void Test10() {

        loginPage.login("standard_user", "secret_sauce");


        homePage.openRandomProductDetail();
        detailPage.clickAddTocart();
//        homePage.checkNumberOfProduct();
        int before = homePage.getCartBadgeCount();
        detailPage.clickRemove();
        int after = homePage.getCartBadgeCount();

        Assert.assertEquals(after , before -1 , "No products have been deleted");
    }



}
