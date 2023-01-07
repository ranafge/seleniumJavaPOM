package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Base {


    private WebDriver driver;

    public Base(WebDriver driver){
        this.driver = driver;

    }
    public void visit(String url) {
        driver.get(url);
    }

    public WebElement find(By locator) {
        return driver.findElement(locator);


    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public void implicitlyWait(int timeInSec){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeInSec));
    }



    public void click(By locator) {
        find(locator).click();
    }

    public void type(String inputText, By locator){
        find(locator).sendKeys(inputText);
    }
    public Boolean isDisplayed(By locator) {
        return find(locator).isDisplayed();
    }
}
