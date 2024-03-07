import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.Assert.*;

public class TestLogOut extends Driver {
    String password = "123456";
    String email = "AnnaStarodubtseva@mail.ru";
    HomePage objHomePage;
    LoginPage objLoginPage;
    PersonalCabinet objPersonalCabinet;
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        webDriver();
        objHomePage = new HomePage(driver);
        objLoginPage = new LoginPage(driver);
        objPersonalCabinet = new PersonalCabinet(driver);
    }
    @After
    public void closeBrowser() {
        driver.quit();
    }
    @Test
    public void checkLogOut() {
        testLogIn();
        testLogOut();
        assertTrue(objLoginPage.buttonLogin());
    }
    @Step("Go to your personal account")
    public void testLogIn() {
        driver.get(HomePage.URL_HOME);
        objHomePage.clickPersonalCabinet();
        objLoginPage.enterEmail(email);
        objLoginPage.enterPassword(password);
        objLoginPage.clickLogin();
    }
    @Step("Go out your personal account")
    public void testLogOut() {
        objPersonalCabinet.clickPersonalCabinetButton();
        objPersonalCabinet.clickLogOut();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(LoginPage.loginButton));
    }
}
