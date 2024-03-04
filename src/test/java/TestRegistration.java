import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestRegistration {
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
    }
    @Test
    public void checkSuccessfulRegistration() { testSuccessfulRegistration(); }
    @Test
    public void checkRegistrationWithError() { testRegistrationWithError(); }

    @Step("Successful registration")
    public void testSuccessfulRegistration() {
        //Драйвер для яндекса
        // System.setProperty("webdriver.chrome.driver", "src/test/resources/Google Chrome");
        // ChromeOptions options = new ChromeOptions();
        // options.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");
        // WebDriver driver = new ChromeDriver(options);

        WebDriver driver = new ChromeDriver();
        driver.get(HomePage.URL_HOME);
        CreateUser user = CreateUser.getDataUser(6);

        RegistrPage objRegistrPage = new RegistrPage(driver);
        objRegistrPage.formRegistr();
        objRegistrPage.enterName(user.getName());
        objRegistrPage.enterEmail(user.getEmail());
        objRegistrPage.enterPassword(user.getPassword());
        objRegistrPage.clickRegistr();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(RegistrPage.enterButton));
        assertTrue(objRegistrPage.signEnter());

        driver.quit();

    }
    @Step("Registration with error for incorrect password")
    public void testRegistrationWithError() {
        //Драйвер для яндекса
        // System.setProperty("webdriver.chrome.driver", "src/test/resources/Google Chrome");
        // ChromeOptions options = new ChromeOptions();
        // options.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");
        // WebDriver driver = new ChromeDriver(options);

        WebDriver driver = new ChromeDriver();
        driver.get(HomePage.URL_HOME);
        CreateUser user = CreateUser.getDataUser(5);

        RegistrPage objRegistrPage = new RegistrPage(driver);
        objRegistrPage.formRegistr();
        objRegistrPage.enterName(user.getName());
        objRegistrPage.enterEmail(user.getEmail());
        objRegistrPage.enterPassword(user.getPassword());
        objRegistrPage.clickRegistr();

        assertEquals ("Некорректный пароль", objRegistrPage.textError());

        driver.quit();

    }
}
