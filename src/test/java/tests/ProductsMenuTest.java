package tests;

import org.testng.annotations.Test;

public class ProductsMenuTest extends BaseTest {

    @Test
    public void productsMenu(){
        loginPage.openPage();
        loginPage.login("standard_user", "secret_sauce");
        productsMenuPage.selectMenu();
        productsMenuPage.verifyAboutLink();
        productsMenuPage.previousPage();
        productsMenuPage.selectMenu();
        productsMenuPage.verifyALLItemsLink();
        productsMenuPage.selectMenu();
        productsMenuPage.verifyLogoutLink();
    }
}
