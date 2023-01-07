package tests;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.MarkerManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.Login;

import java.time.Duration;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedCondition.*;


public class TestLogin {
    private static Logger demoLogger = LogManager.getLogger(TestLogin.class.getName());

    private WebDriver driver;
    private Login login;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments();
        driver = new ChromeDriver(options);
        login = new Login(driver);
        demoLogger.info("Please wait, its working ...");
    }

    @Test
    public void succeeded() {
        demoLogger.info("Opening the website... ");
        login.visit("https://the-internet.herokuapp.com/login");

        demoLogger.info("Web site is opening.");
       login.with("tomsmith","SuperSecretPassword!");
       Assert.assertTrue("success message not present",login.successMessage());
        demoLogger.info("Finished the program.", driver.getClass());
    }


    @Test
    public void demoqa() throws InterruptedException {
        demoLogger.log(Level.valueOf("Waring"), "Opening new window");

        login.visit("https://demoqa.com/select-menu");
        demoLogger.info("Web site is opening..." + driver.getCurrentUrl());
        login.maximizeWindow();
        demoLogger.info("Maximize the current window");
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scroll(0, 550)");
        demoLogger.info("Scrolling down the window");
        driver.findElement(By.xpath("//div[@class='row']/*/div[@class=' css-2b097c-container']")).click();
        List<WebElement> colors2 = driver.findElements(By.cssSelector("[tabindex=\"-1\"]"));
        System.out.println("Color Array size is " + colors2.size());

        for(WebElement e: colors2) {
            e.click();
        }
        List <WebElement> colors = driver.findElements(By.cssSelector("div.css-1rhbuit-multiValue"));

        for(WebElement e: colors) {
            System.out.println( e.getText() );
        }


        demoLogger.info("Finished the program.");


    }


    @After
    public  void tearDown() {
        demoLogger.log(Level.valueOf("warning"), "Closing the webdriver.");
        driver.quit();
    }

}
