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
    RegistrPage objRegistrPage;
    CreateUser user;
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        webDriver();
        driver.get(HomePage.URL_HOME);
        objRegistrPage = new RegistrPage(driver);
    }
    @After
    public void closeBrowser() {
        driver.quit();
    }
    @Test
    public void checkSuccessfulRegistration() {
        user = CreateUser.getDataUser(6);
        fillRegistrationForm();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(RegistrPage.enterButton));
        assertTrue(objRegistrPage.signEnter());
    }
    @Test
    public void checkRegistrationWithError() {
        user = CreateUser.getDataUser(5);
        fillRegistrationForm();
        assertEquals ("Некорректный пароль", objRegistrPage.textError());
    }
    @Step("Fill out the registration form")
    public void fillRegistrationForm() {
        objRegistrPage.formRegistr();
        objRegistrPage.enterName(user.getName());
        objRegistrPage.enterEmail(user.getEmail());
        objRegistrPage.enterPassword(user.getPassword());
        objRegistrPage.clickRegistr();
    }
}
