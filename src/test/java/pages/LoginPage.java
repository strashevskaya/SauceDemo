package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends BasePage {
    private static final By USERNAME_INPUT = By.id("user-name");
    private static final By PASSWORD_INPUT = By.id("password");
    private static final By LOGIN_BUTTON = By.cssSelector(".btn_action");
    private static final By ERROR_MESSAGE = By.cssSelector("h3");
    private static final By ERROR_BUTTON = By.cssSelector(".error-button");

    private String errorMessage = "Epic sadface: Sorry, this user has been locked out.";
    private String errorMessageOfIncorrectLogin = "Epic sadface: Username and password do not match any user in this service";
    private static final String LOGIN_URL = "https://www.saucedemo.com/";

    public LoginPage(WebDriver driver)
    {
         super(driver);
    }

    public void openPage() {

        driver.get(LOGIN_URL);
    }

public void login(String userName, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(userName);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();


}

public void lockedUser(String userName, String password){
    driver.findElement(USERNAME_INPUT).sendKeys(userName);
    driver.findElement(PASSWORD_INPUT).sendKeys(password);
    driver.findElement(LOGIN_BUTTON).click();
    String actualErrorMessage = driver.findElement(ERROR_MESSAGE).getText();
    Assert.assertEquals(actualErrorMessage, errorMessage,"Incorrect message of mistake");

}
public void errorButton(){
        driver.findElement(ERROR_BUTTON).click();
}

public void invalidLogin(String userName, String password){
    driver.findElement(USERNAME_INPUT).sendKeys(userName);
    driver.findElement(PASSWORD_INPUT).sendKeys(password);
    driver.findElement(LOGIN_BUTTON).click();
    String actualErrorMessage = driver.findElement(ERROR_MESSAGE).getText();
    Assert.assertEquals(actualErrorMessage, errorMessageOfIncorrectLogin, "Incorrect username is used");
}

    }

