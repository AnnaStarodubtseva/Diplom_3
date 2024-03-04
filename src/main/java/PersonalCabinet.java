import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalCabinet {
    private WebDriver driver;
    public PersonalCabinet(WebDriver driver){
        this.driver = driver;
    }
    // кликаем по кнопке "Личный кабинет"
    public void clickPersonalCabinetButton() {
        driver.findElement(By.linkText("Личный Кабинет")).click();
    }
    // получаем текст со страницы
    public String textPagePersonalCabinet() {
        return driver.findElement(By.xpath(".//p[(text() = 'В этом разделе вы можете изменить свои персональные данные')]")).getText();
    }
    // кликаем по кнопке Конструктор
    public void clickConstructor() {
        driver.findElement(By.linkText("Конструктор")).click();
    }
    // кликаем на Лого
    public void clickLogo() {
        driver.findElement(By.className("AppHeader_header__logo__2D0X2")).click();
    }
    // кликаем по кнопке Выход
    public void clickLogOut() {
        driver.findElement(By.xpath(".//button[(text() = 'Выход')]")).click();
    }
}
