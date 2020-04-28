package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutOverviewPage extends BasePage{

    private static final String CHECKOUT_URL = "https://www.saucedemo.com/checkout-step-two.html";
    private static final By CART_ITEM = By.cssSelector(".cart_item");
    private static final By FINISH_BUTTON = By.cssSelector(".btn_action.cart_button");
    private static final By FINISH_PAGE = By.cssSelector(".complete-header");


    public CheckoutOverviewPage(WebDriver driver){
        super(driver);

    }

    public void openPage(){
        driver.get(CHECKOUT_URL);
    }

    public void verifyQuantityOfItems(int number){
        Assert.assertEquals(driver.findElements(CART_ITEM).size(), number, "The number of products is incorrect");
    }
    public void finishButton(){
        driver.findElement(FINISH_BUTTON).click();
    }

    public void checkFinishPage(){
        Assert.assertTrue(driver.findElement(FINISH_PAGE).isDisplayed());
    }
}
