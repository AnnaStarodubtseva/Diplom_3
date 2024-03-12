import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import static org.junit.Assert.*;
public class TestGoPersonalCabinet extends Driver {
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
    public void checkGoPersonalCabinet() {
        driver.get(HomePage.URL_HOME);
        objHomePage.clickPersonalCabinet();
        objLoginPage.enterEmail(email);
        objLoginPage.enterPassword(password);
        objLoginPage.clickLogin();
        objPersonalCabinet.clickPersonalCabinetButton();
        assertEquals ("В этом разделе вы можете изменить свои персональные данные", objPersonalCabinet.textPagePersonalCabinet());
    }
}
