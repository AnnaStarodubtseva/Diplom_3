import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import static org.junit.Assert.*;

public class TestGoConstructorAndLogo extends Driver {
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
    }
    @After
    public void closeBrowser() {
        driver.quit();
    }
    @Test
    public void checkGoConstructor() {
        goPersonalCabinet();
        objPersonalCabinet.clickConstructor();
        assertTrue(objHomePage.signOrder());
    }
    @Test
    public void checkGoLogo() {
        goPersonalCabinet();
        objPersonalCabinet.clickLogo();
        assertTrue(objHomePage.signOrder());
    }
    @Step("Login to your Personal Account")
    public void goPersonalCabinet() {
        objHomePage.clickPersonalCabinet();
        objLoginPage.enterEmail(email);
        objLoginPage.enterPassword(password);
        objLoginPage.clickLogin();
        objPersonalCabinet.clickPersonalCabinetButton();
    }
}
