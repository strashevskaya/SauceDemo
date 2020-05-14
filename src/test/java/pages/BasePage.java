package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public abstract class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    protected static final By PRODUCTS_PAGE = By.cssSelector(".product_label");
    protected static final By ABOUT_PAGE = By.cssSelector(".nav-image-link");
    protected static final By LOGOUT_PAGE = By.cssSelector(".btn_action");


    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
    }

    public abstract BasePage openPage();
    public abstract BasePage isPageOpened();

    public void waitForNumberOfElements(By locator, int numberOfElements) {
        try {
            wait.until(ExpectedConditions.numberOfElementsToBe(locator, numberOfElements));
        } catch (TimeoutException ex) {
            ex.printStackTrace();
            Assert.fail("Количество элементов на странице не соответсвует ожидаемому числу" + numberOfElements);
        }
    }
}
