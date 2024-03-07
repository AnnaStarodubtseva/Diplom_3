import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import static org.junit.Assert.*;

public class TestGoSections extends Driver {
    HomePage objHomePage;
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        webDriver();
        objHomePage = new HomePage(driver);
    }
    @After
    public void closeBrowser() {
        driver.quit();
    }
    @Test
    public void checkGoSauces() {
        testGoSauces();
        assertTrue(objHomePage.signSauces());
    }
    @Test
    public void checkGoFillings() {
        testGoFillings();
        assertTrue(objHomePage.signFillings());
    }
    @Test
    public void checkGoRolls() {
        testGoFillings();
        assertTrue(objHomePage.signFillings());
        objHomePage.clickRolls();
        assertTrue(objHomePage.signRolls());
    }
    @Step("Go to section Sauces")
    public void testGoSauces() {
        driver.get(HomePage.URL_HOME);
        objHomePage.clickSauces();
    }
    @Step("Go to section Fillings")
    public void testGoFillings() {
        driver.get(HomePage.URL_HOME);
        objHomePage.clickFillings();
    }
}
