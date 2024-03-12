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
    // кликаем кнопку "Начинки"
    public void clickFillings() {
        driver.findElement(By.xpath(".//span[(text() = 'Начинки')]")).click();
    }
    // кликаем кнопку "Булки"
    public void clickRolls() {
        driver.findElement(By.xpath(".//span[text() = 'Булки']")).click();
    }
    // получаем текст вкладки меню
    public String getMenuText() {
        return driver.findElement(By.xpath("//div[contains(@class,'tab_tab__1SPyG tab_tab_type_current__2BEPc')]")).getText();
    }
}
