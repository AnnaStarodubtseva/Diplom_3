import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    public static final String URL_HOME = "https://stellarburgers.nomoreparties.site/";
    public static By createOrderButton = By.xpath(".//button[(text() = 'Оформить заказ')]");
    private WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    // кликаем кнопку "Войти в аккаунт"
    public void clickLoginOnHomePage() {
        driver.findElement(By.xpath(".//button[(text() = 'Войти в аккаунт')]")).click();
    }
    // кликаем кнопку "Личный кабинет"
    public void clickPersonalCabinet() {
        driver.findElement(By.xpath(".//p[(text() = 'Личный Кабинет')]")).click();
    }
    // проверяем наличие надписи "Оформить заказ"
    public  boolean signOrder() {
        return driver.findElement(createOrderButton).isDisplayed();
    }
    // кликаем кнопку "Соусы"
    public void clickSauces() {
        driver.findElement(By.xpath(".//span[(text() = 'Соусы')]")).click();
    }
    // проверяем наличие надписи "Соусы"
    public  boolean signSauces() {
        return driver.findElement(By.xpath(".//h2[(text() = 'Соусы')]")).isDisplayed();
    }
    // кликаем кнопку "Начинки"
    public void clickFillings() {
        driver.findElement(By.xpath(".//span[(text() = 'Начинки')]")).click();
    }
    // проверяем наличие надписи "Начинки"
    public  boolean signFillings() {
        return driver.findElement(By.xpath(".//h2[(text() = 'Начинки')]")).isDisplayed();
    }
    // кликаем кнопку "Булки"
    public void clickRolls() {
        driver.findElement(By.xpath(".//span[(text() = 'Булки')]")).click();
    }
    // проверяем наличие надписи "Булки"
    public  boolean signRolls() {
        return driver.findElement(By.xpath(".//h2[(text() = 'Булки')]")).isDisplayed();
    }
}
