import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class changePersonalInfo {
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
    private By profileLocator = By.cssSelector("a._3_p8L[href='/account/profile']");

    private By emailInPA = By.cssSelector("div._2YlGs div._3orFQ:first-child input");
    private By phoneInPA = By.cssSelector("div._2YlGs div._3orFQ:last-child input");
    private By surnameInPA = By.cssSelector("div.QRXKk div._3orFQ:first-child input");
    private By nameInPA = By.cssSelector("div.QRXKk div._3orFQ:nth-child(2) input");
    private By patronymicInPA = By.cssSelector("div.QRXKk div._3orFQ:last-child input");
    private By bDayInPA = By.cssSelector("div._3163x div._3orFQ:first-child input");
    private By sexInPA = By.cssSelector("div._30gvs input");

    @Test
    public void testChangeInfo() {
        var email = "d.agapova@pulkovo-service.ru";
        var password = "iqm8p7";
        var phone = "9069724662";
        var surname = "Агапова";
        var name = "Дарья";
        var patronymic = "Юрьевна";
        var bDay = "05.08.1999";
        var sex = "Женский";

        driver.navigate().to("https://superkassa.ru/");
        driver.findElement(buttonPersonalAccountLocator).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(formInLocator));
        driver.findElement(emailLocator).sendKeys(email);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(buttonEntryInFormLocator).click();
        Assert.assertEquals("Неверный email", email, driver.findElement(entryPersonalAccountLocator).getText());

        driver.findElement(entryPersonalAccountLocator).click();
        driver.findElement(profileLocator).click();
        Assert.assertEquals("Неверно указан e-mail в ЛК", email, driver.findElement(emailInPA).getAttribute("value"));
        Assert.assertEquals("Неверно указан номер телефона в ЛК", phone, driver.findElement(phoneInPA).getAttribute("value"));
        Assert.assertEquals("Неверно указана фамилия в ЛК", surname, driver.findElement(surnameInPA).getAttribute("value"));
        Assert.assertEquals("Неверно указано имя в ЛК", name, driver.findElement(nameInPA).getAttribute("value"));
        Assert.assertEquals("Неверно указано отчество в ЛК", patronymic, driver.findElement(patronymicInPA).getAttribute("value"));
        Assert.assertEquals("Неверно указана дата рождения в ЛК", bDay, driver.findElement(bDayInPA).getAttribute("value"));
        Assert.assertEquals("Неверно указан пол", sex, driver.findElement(sexInPA).getAttribute("value"));

    }
}
