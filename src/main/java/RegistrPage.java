import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
public class RegistrPage {
    public static By enterButton = By.xpath(".//button[(text() = 'Войти')]");
    private WebDriver driver;
    public RegistrPage(WebDriver driver){
        this.driver = driver;
    }
    // Доходим до формы регистрации
    public void formRegistr() {
        driver.findElement(By.linkText("Личный Кабинет")).click();
        driver.findElement(By.linkText("Зарегистрироваться")).click();
    }
    // кликаем поле Имя и вводим тестовые данные
    public void enterName(String name) {
        driver.findElement(By.xpath("(//*[contains(@class, 'input pr-6 pl-6')]/input)[1]")).sendKeys(name);
    }
    // кликаем поле Email и вводим тестовые данные
    public void enterEmail(String email) {
        driver.findElement(By.xpath("(//*[contains(@class, 'input pr-6 pl-6')]/input)[2]")).sendKeys(email);
    }
    // кликаем поле Password и вводим тестовые данные
    public void enterPassword(String password) {
        driver.findElement(By.xpath(".//input[@name = 'Пароль']")).sendKeys(password);
    }
    // кликаем кнопку Зарегистрироваться
    public void clickRegistr() {
        driver.findElement(By.xpath(".//button[(text() = 'Зарегистрироваться')]")).click();
    }
    // проверяем наличие надписи "Вход"
    public  boolean signEnter() {
        return driver.findElement(enterButton).isDisplayed();
    }
    // получаем текст ошибки при вводе невалидного пароля
    public String textError() {
        return driver.findElement(By.xpath(".//p[text()='Некорректный пароль']")).getText();
    }
}
