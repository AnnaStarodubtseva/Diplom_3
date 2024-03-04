import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.Assert.*;

public class TestGoConstructorAndLogo {
    String password = "123456";
    String email = "AnnaStarodubtseva@mail.ru";
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
    }
    @Test
    public void checkGoConstructor() { testGoConstructor(); }
    @Test
    public void checkGoLogo() { testGoLogo(); }
    @Step("Go to your personal account")
    public void testGoConstructor() {
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
        objPersonalCabinet.clickConstructor();

        assertTrue(objHomePage.signOrder());

        driver.quit();
    }
    @Step("Go to your personal account")
    public void testGoLogo() {
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
        objPersonalCabinet.clickLogo();

        assertTrue(objHomePage.signOrder());

        driver.quit();
    }
}
