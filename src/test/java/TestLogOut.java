import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.*;

public class TestLogOut {
    String password = "123456";
    String email = "AnnaStarodubtseva@mail.ru";
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
    }
    @Test
    public void checkLogOut() { testLogOut(); }
    @Step("Go to your personal account")
    public void testLogOut() {
        //Драйвер для яндекса
        // System.setProperty("webdriver.chrome.driver", "src/test/resources/Google Chrome");
        // ChromeOptions options = new ChromeOptions();
        // options.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");
        // WebDriver driver = new ChromeDriver(options);

        WebDriver driver = new ChromeDriver();
        HomePage objHomePage = new HomePage(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        PersonalCabinet objPersonalCabinet = new PersonalCabinet(driver);

        driver.get(HomePage.URL_HOME);
        objHomePage.clickPersonalCabinet();
        objLoginPage.enterEmail(email);
        objLoginPage.enterPassword(password);
        objLoginPage.clickLogin();
        objPersonalCabinet.clickPersonalCabinetButton();
        objPersonalCabinet.clickLogOut();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(LoginPage.loginButton));

        assertTrue(objLoginPage.buttonLogin());

        driver.quit();
    }
}
