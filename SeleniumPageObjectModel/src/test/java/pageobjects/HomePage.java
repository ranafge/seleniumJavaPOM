package pageobjects;

import org.bouncycastle.dvcs.DVCSRequestInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    // initiate Webdriver
    WebDriver driver;

    // crate a constructor
    public HomePage(WebDriver driver){
        this.driver = driver;

    }

    // locator

    By loginLocator = By.id("login");

    // method to click

    public void clickLogin() {
        driver.findElement(loginLocator).click();
    }


}
