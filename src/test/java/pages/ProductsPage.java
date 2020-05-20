package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage {
    private static final String PRODUCTS_URL = "https://www.saucedemo.com/inventory.html";
    private String ADD_TO_CART_LOCATOR = "//*[text()='%s']/../../..//button";
    private static final By ADD_TO_CART_BUTTON = By.xpath("//*[text()='Sauce Labs Backpack']/../../..//div");
    private static final By ALL_CART_BUTTONS = By.cssSelector(".btn_primary.btn_inventory");
    private static final By CART_BUTTON = By.cssSelector(".shopping_cart_link.fa-layers.fa-fw");


    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public ProductsPage openPage() {
        driver.get(PRODUCTS_URL);
        waitForNumberOfElements(ALL_CART_BUTTONS, 6);
        return this;
    }

    @Override
    public ProductsPage isPageOpened() {
        waitForNumberOfElements(ALL_CART_BUTTONS, 6);
        return this;
    }

    public ProductsPage addToCart(String productName) {
        By addToCartXpath = By.xpath(String.format(ADD_TO_CART_LOCATOR, productName));
        driver.findElement(addToCartXpath).click();
        return this;
    }
    public ProductsPage clickCartButton() {
        driver.findElement(CART_BUTTON).click();
        return this;
    }

}
