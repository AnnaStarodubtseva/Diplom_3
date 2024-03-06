import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import static org.junit.Assert.*;
public class TestGoPersonalCabinet extends Driver {
    String password = "123456";
    String email = "AnnaStarodubtseva@mail.ru";
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
    }
    @After
    public void closeBrowser() {
        driver.quit();
    }
    @Test
    public void checkGoPersonalCabinet() { testGoPersonalCabinet(); }
    @Step("Go to your personal account")
    public void testGoPersonalCabinet() {
        webDriver();
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
    }
}
