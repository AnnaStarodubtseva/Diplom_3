import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import static org.junit.Assert.*;

public class TestGoSections extends Driver {
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
    }
    @After
    public void closeBrowser() {
        driver.quit();
    }
    @Test
    public void checkGoSauces() { testGoSauces(); }
    @Test
    public void checkGoFillings() { testGoFillings(); }
    @Test
    public void checkGoRolls() { testGoRolls(); }
    @Step("Go to section Sauces")
    public void testGoSauces() {
        webDriver();
        HomePage objHomePage = new HomePage(driver);

        driver.get(HomePage.URL_HOME);
        objHomePage.clickSauces();

        assertTrue(objHomePage.signSauces());
    }
    @Step("Go to section Fillings")
    public void testGoFillings() {
        webDriver();
        HomePage objHomePage = new HomePage(driver);

        driver.get(HomePage.URL_HOME);
        objHomePage.clickFillings();

        assertTrue(objHomePage.signFillings());
    }
    @Step("Go to section Rolls")
    public void testGoRolls() {
        webDriver();
        HomePage objHomePage = new HomePage(driver);

        driver.get(HomePage.URL_HOME);
        objHomePage.clickFillings();
        objHomePage.clickRolls();

        assertTrue(objHomePage.signRolls());
    }
}
