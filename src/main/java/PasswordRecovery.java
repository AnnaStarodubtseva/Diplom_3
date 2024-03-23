import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordRecovery {
    private WebDriver driver;
    public PasswordRecovery(WebDriver driver){
        this.driver = driver;
    }
    // кликаем на надпись "Войти"
    public void clickLogin() {
        driver.findElement(By.linkText("Войти")).click();
    }
}
