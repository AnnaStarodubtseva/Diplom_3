import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
public class LoginPage {
    public static By loginButton = By.xpath(".//button[(text() = 'Войти')]");
    private WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    // кликаем поле Email и вводим тестовые данные
    public void enterEmail(String email) {
        driver.findElement(By.xpath(".//input[@name = 'name']")).sendKeys(email);
    }
    // кликаем поле Password и вводим тестовые данные
    public void enterPassword(String password) {
        driver.findElement(By.xpath(".//input[@name = 'Пароль']")).sendKeys(password);
    }
    // кликаем кнопку Войти
    public void clickLogin() {
        driver.findElement(loginButton).click();
    }
    // кликаем кнопку Восстановить пароль
    public void clickPasswordRecovery() {
        driver.findElement(By.linkText("Восстановить пароль")).click();
    }
    // проверяем наличие кнопки "Войти"
    public  boolean buttonLogin() {
        return driver.findElement(loginButton).isDisplayed();
    }

}
