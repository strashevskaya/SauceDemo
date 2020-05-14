package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;


public class CartPage extends BasePage {

        private String productQuantityLocator = "//*[contains(text(),'%s')]/../../..//div[@class='cart_quantity']";
        private String productPriceLocator = "//*[contains(text(),'%s')]/../../..//div[@class='inventory_item_price']";
        private static final By CART_ITEM = By.cssSelector(".cart_item");
        private static final String CART_URL = "https://www.saucedemo.com/cart.html";
        private static final By CHECKOUT_BUTTON = By.cssSelector(".checkout_button");
        private static final By CONTINUE_SHOPPING_BUTTON = By.cssSelector(".btn_secondary");

        public CartPage(WebDriver driver) {
            super(driver);
        }

        @Override
        public CartPage openPage() {
            driver.get(CART_URL);
            return this;
        }

        @Override
        public CartPage isPageOpened() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(CHECKOUT_BUTTON));
            return this;
    }

    public void validateProductsAmount(int number) {
            Assert.assertEquals(driver.findElements(CART_ITEM).size(), number, "Quantity is invalid");
        }

        public void validateProductDetails(String productName, int quantity, double price) {
            String actualQuantity = driver.findElement(
                    By.xpath(String.format(productQuantityLocator, productName))).getText();
            Assert.assertEquals(actualQuantity, String.valueOf(quantity),
                    "Quantity is invalid");
            String actualPrice = driver.findElement(
                    By.xpath(String.format(productPriceLocator, productName))).getText();
            Assert.assertEquals(actualPrice, String.valueOf(price),
                    "Price is invalid");
        }

        public void clickCheckout() {
            driver.findElement(CHECKOUT_BUTTON).click();
        }

        public void clickContinueShoppingButton() {
            driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
        }

    }

