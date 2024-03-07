import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertTrue;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class TestLogin extends Driver {
    String password = "123456";
    String email = "AnnaStarodubtseva@mail.ru";
    HomePage objHomePage;
    LoginPage objLoginPage;
    RegistrPage objRegistrPage;
    PasswordRecovery objPasswordRecovery;
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        webDriver();
        objHomePage = new HomePage(driver);
        objLoginPage = new LoginPage(driver);
        objRegistrPage = new RegistrPage(driver);
        objPasswordRecovery = new PasswordRecovery(driver);
    }
    @After
    public void closeBrowser() {
        driver.quit();
    }
    @Test
    public void checkLoginOnHomePage() {
        testLoginOnHomePage();
        assertTrue(objHomePage.signOrder());
    }
    @Test
    public void checkLoginPersonalCabinet() {
        testLoginPersonalCabinet();
        assertTrue(objHomePage.signOrder());
    }
    @Test
    public void checkLoginRegistrationForm() {
        testLoginRegistrationForm();
        assertTrue(objHomePage.signOrder());
    }
    @Test
    public void checkLoginPasswordRecovery() {
        testLoginPasswordRecovery();
        assertTrue(objHomePage.signOrder());
    }
    @Step("Login using the “Log in to your account” button on the main page")
    public void testLoginOnHomePage() {
        driver.get(HomePage.URL_HOME);
        objHomePage.clickLoginOnHomePage();
        objLoginPage.enterEmail(email);
        objLoginPage.enterPassword(password);
        objLoginPage.clickLogin();
    }
    @Step("Login through the “Personal Cabinet” button")
    public void testLoginPersonalCabinet() {
        driver.get(HomePage.URL_HOME);
        objHomePage.clickPersonalCabinet();
        objLoginPage.enterEmail(email);
        objLoginPage.enterPassword(password);
        objLoginPage.clickLogin();
    }
    @Step("Login via the button in the registration form")
    public void testLoginRegistrationForm() {
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
    }
    @Step("Login via the button in the password recovery form")
    public void testLoginPasswordRecovery() {
        driver.get(HomePage.URL_HOME);
        objHomePage.clickLoginOnHomePage();
        objLoginPage.clickPasswordRecovery();
        objPasswordRecovery.clickLogin();
        objLoginPage.enterEmail(email);
        objLoginPage.enterPassword(password);
        objLoginPage.clickLogin();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(HomePage.createOrderButton));
    }
}
