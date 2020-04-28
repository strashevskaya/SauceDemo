package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ProductsMenuPage extends BasePage {
    private static final By MENU_BUTTON = By.cssSelector(".bm-burger-button");
    private static final By CLOSE_MENU_BUTTON = By.cssSelector(".bm-cross-button");
    private static final By ALL_ITEMS_LINK = By.id("inventory_sidebar_link");
    private static final By ABOUT_LINK = By.id("about_sidebar_link");
    private static final By LOGOUT_LINK = By.id("logout_sidebar_link");
    private static final By RESET_APP_STATE = By.id("reset_sidebar_link");

public ProductsMenuPage(WebDriver driver){
    super(driver);
}

public void selectMenu(){
    driver.findElement(MENU_BUTTON).click();

}
public void previousPage(){
    driver.navigate().back();
}

public void verifyALLItemsLink(){
    driver.findElement(ALL_ITEMS_LINK).click();
    Assert.assertTrue(driver.findElement(PRODUCTS_PAGE).isDisplayed(), "Invalid link path");
}
public void verifyAboutLink(){
    driver.findElement(ABOUT_LINK).click();
    Assert.assertTrue(driver.findElement(ABOUT_PAGE).isDisplayed(), "Invalid link path");
}
public void verifyLogoutLink(){
    driver.findElement(LOGOUT_LINK).click();
    Assert.assertTrue(driver.findElement(LOGOUT_PAGE).isDisplayed(), "Invalid link path");
}

public void closeMenu(){
    driver.findElement(CLOSE_MENU_BUTTON).click();
}
}
