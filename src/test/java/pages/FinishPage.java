package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FinishPage extends BasePage {

    private static final String FINISH_PAGE_URL = "https://www.saucedemo.com/checkout-complete.html";
    private static final By FINISH_LOCATOR = By.cssSelector(".complete-header");

    public FinishPage(WebDriver driver) {
        super(driver);
    }

    public FinishPage openPage() {
        driver.get(FINISH_PAGE_URL);
        return this;
    }

    public FinishPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(FINISH_LOCATOR));
        return this;
    }
}
