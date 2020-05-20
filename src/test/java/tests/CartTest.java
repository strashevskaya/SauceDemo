package tests;

import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test
    public void continueShoppingTest() {
        loginPage.openPage();
        loginPage.login(user);
        productsPage.addToCart("Sauce Labs Backpack");
        productsPage.clickCartButton();
        cartPage.validateProductsAmount(1);
        cartPage.clickContinueShoppingButton();
    }
}
