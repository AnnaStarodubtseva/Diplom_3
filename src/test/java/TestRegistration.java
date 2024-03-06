import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class TestRegistration extends Driver {
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
    }
    @After
    public void closeBrowser() {
        driver.quit();
    }
    @Test
    public void checkSuccessfulRegistration() { testSuccessfulRegistration(); }
    @Test
    public void checkRegistrationWithError() { testRegistrationWithError(); }

    @Step("Successful registration")
    public void testSuccessfulRegistration() {
        webDriver();
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
    }
    @Step("Registration with error for incorrect password")
    public void testRegistrationWithError() {
        webDriver();
        driver.get(HomePage.URL_HOME);
        CreateUser user = CreateUser.getDataUser(5);

        RegistrPage objRegistrPage = new RegistrPage(driver);
        objRegistrPage.formRegistr();
        objRegistrPage.enterName(user.getName());
        objRegistrPage.enterEmail(user.getEmail());
        objRegistrPage.enterPassword(user.getPassword());
        objRegistrPage.clickRegistr();

        assertEquals ("Некорректный пароль", objRegistrPage.textError());
    }
}
