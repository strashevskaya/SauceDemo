package tests;

import org.testng.annotations.Test;
import pages.CheckoutPage;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkoutInputsTest() {
        loginPage.openPage();
        loginPage.login(user);
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        cartPage.openPage();
        cartPage.clickCheckout();
        checkoutPage.checkoutFormInputs(checkoutInputs);
        checkoutPage.continueButtonClick();
        checkoutOverviewPage.verifyQuantityOfItems(1);
        checkoutOverviewPage.clickFinishButton();
    }

}