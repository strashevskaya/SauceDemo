package tests;

import org.testng.annotations.Test;
import pages.LoginPage;

public class SauceDemoTest extends BaseTest {

    @Test
    public void loginTest() {
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        cartPage.openPage();
        cartPage.validateProductsAmount(1);
        cartPage.validateProductDetails("Sauce Labs Fleece Jacket", 1, 49.99);
    }
    @Test
    public void lockedUserTest(){
        loginPage.openPage();
        loginPage.lockedUser("locked_out_user", "secret_sauce");
        loginPage.errorButton();
    }
    @Test
    public void incorrectLoginField(){
        loginPage.openPage();
        loginPage.invalidLogin("asddf","12345");
    }
}

