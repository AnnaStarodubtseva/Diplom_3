import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import static org.junit.Assert.*;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestGoPersonalCabinet {
    String password = "123456";
    String email = "AnnaStarodubtseva@mail.ru";
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
    }
    @Test
    public void checkGoPersonalCabinet() { testGoPersonalCabinet(); }
    @Step("Go to your personal account")
    public void testGoPersonalCabinet() {
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

        assertEquals ("В этом разделе вы можете изменить свои персональные данные", objPersonalCabinet.textPagePersonalCabinet());

        driver.quit();
    }
}
