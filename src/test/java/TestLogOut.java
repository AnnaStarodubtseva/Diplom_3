import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
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
        driver.get(HomePage.URL_HOME);
        objHomePage = new HomePage(driver);
        objLoginPage = new LoginPage(driver);
        objPersonalCabinet = new PersonalCabinet(driver);

        objHomePage.clickPersonalCabinet();
        objLoginPage.enterEmail(email);
        objLoginPage.enterPassword(password);
        objLoginPage.clickLogin();
    }
    @After
    public void closeBrowser() {
        driver.quit();
    }
    @Test
    public void checkLogOut() {
        objPersonalCabinet.clickPersonalCabinetButton();
        objPersonalCabinet.clickLogOut();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(LoginPage.loginButton));
        assertTrue(objLoginPage.buttonLogin());
    }
}
