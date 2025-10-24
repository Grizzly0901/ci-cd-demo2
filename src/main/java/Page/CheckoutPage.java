package Page;

import Util.WebD;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage {

    private final By ErrorTextLocator = By.xpath("//h3[@data-test='error']");
    private final By cartButton = By.cssSelector("a.shopping_cart_link");
    private final By checkoutButton = By.cssSelector("button[id='checkout']");
    private final By continueButton = By.cssSelector("input[id='continue']");

    public void clickCartButton() {
        WebD.getWebDriver().findElement(cartButton).click();
    }

    public void clickCheckout() {
        WebD.getWebDriver().findElement(checkoutButton).click();
    }


    public String getErrorText() {
        WebDriverWait wait = new WebDriverWait(WebD.getWebDriver(), Duration.ofSeconds(5));
        WebElement errorMess = wait.until(ExpectedConditions.visibilityOfElementLocated(ErrorTextLocator));
         return WebD.getWebDriver().findElement(ErrorTextLocator).getText();

    }

    public void fillCheckoutForm(String firstname, String lastname, String postcode) {
        WebD.getWebDriver().findElement(By.id("first-name")).sendKeys(firstname);
        WebD.getWebDriver().findElement(By.id("last-name")).sendKeys(lastname);
        WebD.getWebDriver().findElement(By.id("postal-code")).sendKeys(postcode);

    }



    public void clearForm() {
        WebElement firstName = WebD.getWebDriver().findElement(By.id("first-name"));
        WebElement lastName = WebD.getWebDriver().findElement(By.id("last-name"));
        WebElement postalCode = WebD.getWebDriver().findElement(By.id("postal-code"));

        firstName.clear();
        lastName.clear();
        postalCode.clear();
    }



    public void clickContinue() {
        WebD.getWebDriver().findElement(continueButton).click();
    }



}
