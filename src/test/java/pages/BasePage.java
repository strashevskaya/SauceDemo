package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriver driver;
    protected static final By PRODUCTS_PAGE = By.cssSelector(".product_label");
    protected static final By ABOUT_PAGE = By.cssSelector(".nav-image-link");
    protected static final By LOGOUT_PAGE = By.cssSelector(".btn_action");


    public BasePage(WebDriver driver) {
        this.driver = driver;

    }
}
