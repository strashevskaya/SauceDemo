package tests;

import org.testng.annotations.Test;

public class CheckoutOverviewTest extends BaseTest {

    @Test
    public void finishButtonTest() {
        loginPage.openPage();
        loginPage.login(user);
        cartPage.openPage();
        cartPage.clickCheckout();
        checkoutPage.checkoutFormInputs(checkoutInputs);
        checkoutPage.continueButtonClick();
        checkoutOverviewPage.clickFinishButton();
    }
}
