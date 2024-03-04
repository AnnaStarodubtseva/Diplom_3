import org.junit.Test;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.junit.Assert.*;

public class TestGoSections {
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
    }
    @Test
    public void checkGoSauces() { testGoSauces(); }
    @Test
    public void checkGoFillings() { testGoFillings(); }
    @Test
    public void checkGoRolls() { testGoRolls(); }
    @Step("Go to section Sauces")
    public void testGoSauces() {
        //Драйвер для яндекса
        // System.setProperty("webdriver.chrome.driver", "src/test/resources/Google Chrome");
        // ChromeOptions options = new ChromeOptions();
        // options.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");
        // WebDriver driver = new ChromeDriver(options);

        WebDriver driver = new ChromeDriver();
        HomePage objHomePage = new HomePage(driver);

        driver.get(HomePage.URL_HOME);
        objHomePage.clickSauces();

        assertTrue(objHomePage.signSauces());

        driver.quit();
    }
    @Step("Go to section Fillings")
    public void testGoFillings() {
        //Драйвер для яндекса
        // System.setProperty("webdriver.chrome.driver", "src/test/resources/Google Chrome");
        // ChromeOptions options = new ChromeOptions();
        // options.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");
        // WebDriver driver = new ChromeDriver(options);

        WebDriver driver = new ChromeDriver();
        HomePage objHomePage = new HomePage(driver);

        driver.get(HomePage.URL_HOME);
        objHomePage.clickFillings();

        assertTrue(objHomePage.signFillings());

        driver.quit();
    }
    @Step("Go to section Rolls")
    public void testGoRolls() {
        //Драйвер для яндекса
        // System.setProperty("webdriver.chrome.driver", "src/test/resources/Google Chrome");
        // ChromeOptions options = new ChromeOptions();
        // options.setBinary("/Applications/Yandex.app/Contents/MacOS/Yandex");
        // WebDriver driver = new ChromeDriver(options);

        WebDriver driver = new ChromeDriver();
        HomePage objHomePage = new HomePage(driver);

        driver.get(HomePage.URL_HOME);
        objHomePage.clickFillings();
        objHomePage.clickRolls();

        assertTrue(objHomePage.signRolls());

        driver.quit();
    }
}
