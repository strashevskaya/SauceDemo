package pages;

import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class LoginPage extends BasePage {
    private static final String LOGIN_URL = "https://www.saucedemo.com/";
    private static final By USERNAME_INPUT = By.id("user-name");
    private static final By PASSWORD_INPUT = By.id("password");
    private static final By LOGIN_BUTTON = By.cssSelector(".btn_action");
    private static final By ERROR_MESSAGE = By.cssSelector("h3");
    private static final By ERROR_BUTTON = By.cssSelector(".error-button");

    private String errorMessage = "Epic sadface: Sorry, this user has been locked out.";
    private String errorMessageOfIncorrectLogin = "Epic sadface: Username and password do not match any user in this service";

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage openPage() {
        driver.get(LOGIN_URL);
        return this;
    }

    public LoginPage isPageOpened() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
        return this;
    }

     public LoginPage login(User user) {
        driver.findElement(USERNAME_INPUT).sendKeys(user.getUserName());
        driver.findElement(PASSWORD_INPUT).sendKeys(user.getPassword());
        driver.findElement(LOGIN_BUTTON).click();
        return new LoginPage(driver);
}

     public void lockedUser(String userName, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(userName);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
        String actualErrorMessage = driver.findElement(ERROR_MESSAGE).getText();
        Assert.assertEquals(actualErrorMessage, errorMessage, "Incorrect message of mistake");
    }

     public void clickErrorButton() {
        driver.findElement(ERROR_BUTTON).click();
}

     public void invalidLoginInputs(String userName, String password) {
     driver.findElement(USERNAME_INPUT).sendKeys(userName);
     driver.findElement(PASSWORD_INPUT).sendKeys(password);
     driver.findElement(LOGIN_BUTTON).click();
     String actualErrorMessage = driver.findElement(ERROR_MESSAGE).getText();
     Assert.assertEquals(actualErrorMessage, errorMessageOfIncorrectLogin, "Incorrect username is used");
}

    }

