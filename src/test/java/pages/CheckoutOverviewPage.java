package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class CheckoutOverviewPage extends BasePage{

    private static final String CHECKOUT_URL = "https://www.saucedemo.com/checkout-step-two.html";
    private static final By CART_ITEM = By.cssSelector(".cart_item");
    private static final By FINISH_BUTTON = By.cssSelector(".btn_action.cart_button");
    private static final By CHECKOUT_PAGE = By.xpath("//*[contains(text(),'Checkout: Overview')]");
    private static final By CANCEL_BUTTON = By.cssSelector(".cart_cancel_link.btn_secondary");


    public CheckoutOverviewPage(WebDriver driver){
        super(driver);
    }

    @Override
    public CheckoutOverviewPage openPage(){
        driver.get(CHECKOUT_URL);
        return this;
    }

    @Override
    public CheckoutOverviewPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(CHECKOUT_PAGE));
        return this;
    }

    public void verifyQuantityOfItems(int number){
        Assert.assertEquals(driver.findElements(CART_ITEM).size(), number, "The number of products is incorrect");
    }

    public void clickFinishButton(){
        driver.findElement(FINISH_BUTTON).click();
    }

    public void cancelClick() {
        driver.findElement(CANCEL_BUTTON).click();
    }
}
