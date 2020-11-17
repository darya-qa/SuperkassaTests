import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class createTicketsForFlight {
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

    private By fromLocator = By.className("QbjCT");
    private By fromResultLocator = By.cssSelector("li._3bJMb");
    private By toLocator = By.className("_3sKfP");
    private By toResultLocator = By.cssSelector("li._3bJMb");
    private By whenFromLocator = By.cssSelector("div._1OB_8:first-child button.u-w7l");
    private By whenMonthLocator = By.cssSelector("button._1JOST+button");
    private By whenFirstLocator = By.cssSelector("div._3SFb0:nth-child(2)>button:last-child");
    private By whenBackLocator = By.cssSelector("button.u-w7l:last-child");
    private By whenSecondLocator = By.cssSelector("div._3SFb0:nth-child(3)>button:first-child");
    private By findLocator = By.cssSelector("button._2ten3._3dZTf");
    private By resultFlightLocator = By.cssSelector("div._1MvqH button");
    private By selectedTariffLocator = By.cssSelector("ul._1vDgo>li:nth-child(2) button._3pvpV");

    @Test
    public void testFlight() {
        driver.navigate().to("https://superkassa.ru/");
        driver.findElement(fromLocator).click();
        driver.findElement(fromResultLocator).click();
        driver.findElement(toLocator).click();
        driver.findElement(toResultLocator).click();
        driver.findElement(whenFromLocator).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(whenMonthLocator));
        driver.findElement(whenMonthLocator).click();
        driver.findElement(whenFirstLocator).click();
        driver.findElement(whenBackLocator).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(whenMonthLocator));
        driver.findElement(whenMonthLocator).click();
        driver.findElement(whenSecondLocator).click();
        driver.findElement(findLocator).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(resultFlightLocator));
        driver.findElement(resultFlightLocator).click();
    }
}
