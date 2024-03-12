import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertTrue;
import io.github.bonigarcia.wdm.WebDriverManager;
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
        driver.get(HomePage.URL_HOME);
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
        objHomePage.clickLoginOnHomePage();
        objLoginPage.enterEmail(email);
        objLoginPage.enterPassword(password);
        objLoginPage.clickLogin();
        assertTrue(objHomePage.signOrder());
    }
    @Test
    public void checkLoginPersonalCabinet() {
        objHomePage.clickPersonalCabinet();
        objLoginPage.enterEmail(email);
        objLoginPage.enterPassword(password);
        objLoginPage.clickLogin();
        assertTrue(objHomePage.signOrder());
    }
    @Test
    public void checkLoginRegistrationForm() {
        CreateUser user = CreateUser.getDataUser(6);

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
    }
    @Test
    public void checkLoginPasswordRecovery() {
        objHomePage.clickLoginOnHomePage();
        objLoginPage.clickPasswordRecovery();
        objPasswordRecovery.clickLogin();
        objLoginPage.enterEmail(email);
        objLoginPage.enterPassword(password);
        objLoginPage.clickLogin();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(HomePage.createOrderButton));
        assertTrue(objHomePage.signOrder());
    }
}
