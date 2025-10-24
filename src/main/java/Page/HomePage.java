package Page;

import Util.WebD;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class HomePage {

    private final By menuWrap = By.className("bm-menu-wrap");
    private final By menuButton = By.id("react-burger-menu-btn");
    private final By logoutButton = By.id("logout_sidebar_link");
    private final By secondProduct = By.className("inventory_item_name");
    private final By AddToCartButton = By.xpath("//button[contains(@id,'add-to-cart')]");
    private final By numberOfProduct = By.cssSelector("span.shopping_cart_badge");
    private final By cartBadge = By.className("shopping_cart_badge");
    private final By RandomAddToCart = By.xpath("//button[contains(@id,'add-to-cart')]");
    private final By cartButton = By.cssSelector("a.shopping_cart_link");
    private final By checkoutButton = By.cssSelector("button[id='checkout']");
    private final By continueButton = By.cssSelector("input[id='continue']");
    private final By ProductLocator = By.className("inventory_item");
    private int productCount;



    private final By productContainerLocator = By.className("inventory_item_name");


    @Step ("Open sidebar")
    public void openSidebar() {
        WebD.getWebDriver().findElement(menuButton).click();
        // Đợi cho sidebar hiển thị hoàn toàn
        WebD.getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(menuWrap));
        // Đợi luôn cho nút logout có thể click được (rất quan trọng)
        WebD.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(logoutButton));}
    @Step ("Logout")
    public void clickLogoutMenu() {
        WebD.getWebDriver().findElement(logoutButton).click();
    }

    public void Logout() {
        openSidebar();
        clickLogoutMenu();
    }


    // click random theo số tự nhập
    public void randomProduct(int numOfProducts) {
        List<WebElement> products = WebD.getWebDriver().findElements(ProductLocator);
        int total = products.size();

        // Sinh danh sách index ngẫu nhiên, không trùng
        List<Integer> randomIndexes = new Random()
                .ints(0, total)            // random trong khoảng 0 -> total
                .distinct()                // loại trùng
                .limit(numOfProducts)      // chỉ lấy numOfProducts phần tử
                .boxed()                   // chuyển từ int sang Integer
                .collect(Collectors.toList());

        // Click vào từng sản phẩm theo index ngẫu nhiên
        randomIndexes.forEach(index -> products.get(index).click());
    }


    // chọn và click vào trang chi tiết 1 sp
    public void openRandomProductDetail() {
        List<WebElement> products = WebD.getWebDriver().findElements(productContainerLocator);
        int randomIndex = new Random().nextInt(products.size());
        WebElement randomProduct = products.get(randomIndex);

        // click vào tên sản phẩm để mở trang chi tiết
        randomProduct.click();
    }




    // click nút giỏ hàng
    public void clickAddToCartButton() {
        WebD.getWebDriver().findElement(AddToCartButton).click();
    }

    // Chỉ click random 1 sp
    public void clickRandomAddToCart() {
        List<WebElement> AddButton = WebD.getWebDriver().findElements(RandomAddToCart);
        int index = (int) (Math.random() * AddButton.size());
        WebElement RandomClick = AddButton.get(index);
        RandomClick.click();
    }

    public void clickCartButton() {
        WebD.getWebDriver().findElement(cartButton).click();
    }

    public void checkNumberOfProduct() {
        String Num = WebD.getWebDriver().findElement(numberOfProduct).getText();
        productCount = Integer.parseInt(String.valueOf(Num));
        if (productCount >= 1) {
            System.out.println("Added successfully");
        } else {
            System.out.println("Added failed");
        }
    }



    public void clickCheckout() {
        WebD.getWebDriver().findElement(checkoutButton).click();
    }

    public void clickContinue() {
        WebD.getWebDriver().findElement(continueButton).click();
    }

    public int getCartBadgeCount() {
        List<WebElement> badges = WebD.getWebDriver().findElements(cartBadge);
        if (badges.isEmpty()) {
            return 0; // không có badge = giỏ hàng rỗng
        }
        return Integer.parseInt(badges.get(0).getText());
    }




}
