package Page;

import Util.WebD;
import org.openqa.selenium.By;

public class DetailPage {

    private final By AddToCartLocator = By.id("add-to-cart");
    private final By removeButton = By.id("remove");


    public void clickAddTocart() {
        WebD.getWebDriver().findElement(AddToCartLocator).click();
    }

    public void clickRemove() {
        WebD.getWebDriver().findElement(removeButton).click();
    }
}
