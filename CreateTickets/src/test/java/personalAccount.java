import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class personalAccount {
    public WebDriver driver;
    private WebDriverWait wait;


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    private By buttonPersonalAccountLocator = By.cssSelector("div._2qlyB");
    private By formInLocator = By.cssSelector("div._3v9BR");
    private By emailLocator = By.id("userEmail");
    private By passwordLocator = By.id("userPassword");
    private By buttonEntryInFormLocator = By.cssSelector("button.big.default._2M5u-._28MCg");
    private By entryPersonalAccountLocator = By.cssSelector("span._11w_s");

    @Test
    public void inPersonalAccount() {
        var email = "d.agapova@pulkovo-service.ru";
        var password = "iqm8p7";
        driver.navigate().to("https://superkassa.ru/");
        driver.findElement(buttonPersonalAccountLocator).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(formInLocator));
        driver.findElement(emailLocator).sendKeys(email);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(buttonEntryInFormLocator).click();
        Assert.assertEquals("Неверный email", email, driver.findElement(entryPersonalAccountLocator).getText());

        driver.findElement(entryPersonalAccountLocator).click();
    }
}
