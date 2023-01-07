package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login extends Base{
    private WebDriver driver;

    By usernameLocator = By.id("username");
    By passwordLocator = By.id("password");
    By submitBtn = By.cssSelector("button");
    By successMessageLocator = By.id(".flash.success");

    public Login(WebDriver driver) {
        super(driver);
//        visit("https://the-internet.herokuapp.com/login");
    }

    public void with(String username, String password) {
        type(username, usernameLocator);
        type(password, passwordLocator);

        click(submitBtn);

    }



    public boolean successMessage() {
        return driver.findElement(successMessageLocator).isDisplayed();
    }



}
