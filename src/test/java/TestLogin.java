import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.assertTrue;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.openqa.selenium.chrome.ChromeOptions;


public class TestLogin {
    String password = "123456";
    String email = "AnnaStarodubtseva@mail.ru";
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
    }
    @Test
    public void checkLoginOnHomePage() { testLoginOnHomePage(); }
    @Test
    public void checkLoginPersonalCabinet() { testLoginPersonalCabinet(); }
    @Test
    public void checkLoginRegistrationForm() { testLoginRegistrationForm(); }
    @Test
    public void checkLoginPasswordRecovery() { testLoginPasswordRecovery(); }
    @Step("Login using the “Log in to your account” button on the main page")
    public void testLoginOnHomePage() {
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
        objHomePage.clickLoginOnHomePage();
        objLoginPage.enterEmail(email);
        objLoginPage.enterPassword(password);
        objLoginPage.clickLogin();
        assertTrue(objHomePage.signOrder());

        driver.quit();
    }
    @Step("Login through the “Personal Cabinet” button")
    public void testLoginPersonalCabinet() {
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
        assertTrue(objHomePage.signOrder());

        driver.quit();
    }
    @Step("Login via the button in the registration form")
    public void testLoginRegistrationForm() {
        //Драйвер для яндекса
        // System.setProperty("webdriver.chrome.driver", "src/test/resources/Google Chrome");
        // ChromeOptions options = new ChromeOptions();
        // options.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");
        // WebDriver driver = new ChromeDriver(options);

        WebDriver driver = new ChromeDriver();
        LoginPage objLoginPage = new LoginPage(driver);
        HomePage objHomePage = new HomePage(driver);
        RegistrPage objRegistrPage = new RegistrPage(driver);
        CreateUser user = CreateUser.getDataUser(6);

        driver.get(HomePage.URL_HOME);
        objRegistrPage.formRegistr();
        objRegistrPage.enterName(user.getName());
        objRegistrPage.enterEmail(user.getEmail());
        objRegistrPage.enterPassword(user.getPassword());
        objRegistrPage.clickRegistr();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(LoginPage.loginButton));
        objLoginPage.enterEmail(user.getEmail());
        objLoginPage.enterPassword(user.getPassword());
        objLoginPage.clickLogin();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(HomePage.createOrderButton));
        assertTrue(objHomePage.signOrder());

        driver.quit();
    }
    @Step("Login via the button in the password recovery form")
    public void testLoginPasswordRecovery() {
        //Драйвер для яндекса
        // System.setProperty("webdriver.chrome.driver", "src/test/resources/Google Chrome");
        // ChromeOptions options = new ChromeOptions();
        // options.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");
        // WebDriver driver = new ChromeDriver(options);

        WebDriver driver = new ChromeDriver();
        HomePage objHomePage = new HomePage(driver);
        LoginPage objLoginPage = new LoginPage(driver);
        PersonalCabinet objPersonalCabinet = new PersonalCabinet(driver);
        PasswordRecovery objPasswordRecovery = new PasswordRecovery(driver);

        driver.get(HomePage.URL_HOME);
        objHomePage.clickLoginOnHomePage();
        objLoginPage.clickPasswordRecovery();
        objPasswordRecovery.clickLogin();
        objLoginPage.enterEmail(email);
        objLoginPage.enterPassword(password);
        objLoginPage.clickLogin();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(HomePage.createOrderButton));
        assertTrue(objHomePage.signOrder());

        driver.quit();
    }
}
