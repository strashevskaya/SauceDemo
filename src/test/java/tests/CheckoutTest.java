package tests;

import org.testng.annotations.Test;
import pages.CheckoutPage;

public class CheckoutTest extends BaseTest {

    @Test
    public void verifyCheckOutPage() {
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        cartPage.openPage();
        cartPage.checkout();
        checkoutPage.checkoutForm("Kristina", "Strashevskaya", "220103");
        checkoutPage.continueButton();
        checkoutOverviewPage.verifyQuantityOfItems(1);
        checkoutOverviewPage.finishButton();
        checkoutOverviewPage.checkFinishPage();
    }

}
