package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
public class P01_LoginPage {
   WebDriver driver;
///////////////Locators//////////////
By emailInput =By.xpath("//input[@data-qa=\"login-email\"]");
By passwordInput =By.xpath("//input[@data-qa=\"login-password\"]");
By loginButton=By.xpath("//button[@data-qa=\"login-button\"]");


///////////Constructor///////////////
public P01_LoginPage(WebDriver driver) {this.driver = driver;}

///////////////Actions///////////////
    public void Login(String email,String password){
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    driver.findElement(emailInput).sendKeys(email);
    driver.findElement(passwordInput).sendKeys(password);
    driver.findElement(loginButton).click();
    }

}
