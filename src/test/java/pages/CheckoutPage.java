package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutPage extends BasePage {

    private static final By FIRST_NAME_INPUT = By.id("first-name");
    private static final By LAST_NAME_INPUT = By.id("last-name");
    private static final By ZIP_CODE_INPUT = By.id("postal-code");
    private static final By CONTINUE_BUTTON = By.cssSelector(".btn_primary.cart_button");
    private static final By CANCEL_BUTTON = By.cssSelector(".btn_secondary");
    private static final By CHECKOUT_OVERVIEW_PAGE = By.cssSelector(".Checkout: Overview");


    private static final String CHECKOUT_URL = "https://www.saucedemo.com/checkout-step-one.html";

    public CheckoutPage(WebDriver driver){

        super(driver);
    }

    public void openPage(){
        driver.get(CHECKOUT_URL);
    }

    public void checkoutForm(String firstName, String lastName, String zipCode){
        driver.findElement(FIRST_NAME_INPUT).sendKeys(firstName);
        driver.findElement(LAST_NAME_INPUT).sendKeys(lastName);
        driver.findElement(ZIP_CODE_INPUT).sendKeys(zipCode);


    }
    public void cancelButton(){
        driver.findElement(CANCEL_BUTTON).click();

    }

    public void continueButton(){
        driver.findElement(CONTINUE_BUTTON).click();
    }


    public void validateCheckoutOverviewPage(){
        Assert.assertTrue(driver.findElement(CHECKOUT_OVERVIEW_PAGE).isDisplayed());
    }

}

