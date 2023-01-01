package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pageobjects.Login;



public class TestLogin {

    private WebDriver driver;
    private Login login;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments();
        driver = new ChromeDriver(options);
        login = new Login(driver);
    }

    @Test
    public void succeeded() {
       login.with("tomsmith","SuperSecretPassword!");
       Assert.assertTrue("success message not present",login.successMessage());
    }

    @After
    public  void tearDown() {
        driver.quit();
    }

}
