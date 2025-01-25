import Pages.P01_LoginPage;
import Pages.P02_HomePage;
import Pages.P03_ProductsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.io.FileNotFoundException;
public class AddToCartTest {
    P01_LoginPage loginpage ;
    P02_HomePage homepage;
    P03_ProductsPage productpage;
    WebDriver driver;
    @BeforeMethod
    public  void Intilization(){
        driver=new EdgeDriver();
        driver.get("https://automationexercise.com/login");
    }
    @Test
    public void addToCart() throws FileNotFoundException {
        loginpage=new P01_LoginPage(driver);
        homepage=new P02_HomePage(driver);
        productpage=new P03_ProductsPage(driver);
        loginpage.Login("fatm@gmail.com","P@ssw0rd");
        homepage.navigateToProducts();
        productpage.addProductToCart();
        productpage.viewCartProducts();

    }
    @AfterMethod
    public void tearDown(){
     driver.quit();
    }

}
