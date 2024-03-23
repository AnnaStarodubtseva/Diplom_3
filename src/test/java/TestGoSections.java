import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import static org.junit.Assert.*;

public class TestGoSections extends Driver {
    HomePage objHomePage;
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        webDriver();
        driver.get(HomePage.URL_HOME);
        objHomePage = new HomePage(driver);
    }
    @After
    public void closeBrowser() {
        driver.quit();
    }
    @Test
    public void checkGoSauces() {
        objHomePage.clickSauces();
        assertEquals("Соусы", objHomePage.getMenuText());
    }
    @Test
    public void checkGoFillings() {
        objHomePage.clickFillings();
        assertEquals("Начинки", objHomePage.getMenuText());
    }
    @Test
    public void checkGoRolls() {
        objHomePage.clickSauces();
        objHomePage.clickRolls();
        assertEquals("Булки", objHomePage.getMenuText());
    }
}
