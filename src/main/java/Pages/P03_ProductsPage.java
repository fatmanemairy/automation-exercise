package Pages;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class P03_ProductsPage {
    WebDriver driver;
    ////////////Locators//////////
    By productPrices = By.xpath("//div[@class=\"productinfo text-center\"]/h2");
    By continueShoppingBtn=By.xpath("//button[@data-dismiss=\"modal\"]");
    By veiwCartBtn=By.xpath("//a[@href=\"/view_cart\"]");
    ////////////Constructor//////////////
    public P03_ProductsPage(WebDriver driver){this.driver=driver;}
    ////////////Actions/////////////////
    public void addProductToCart(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        List prices=driver.findElements(productPrices);

        for (int i=1;i<prices.size()+1;i++){
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            int productsPrices= Integer.parseInt((driver.findElement(By.xpath("(//div[@class=\"productinfo text-center\"]/h2)["+i+"]")).getText().replaceAll("[^0-9]","")));
            if(productsPrices<1000)
            {
                driver.findElement(By.xpath("(//div[@class=\"productinfo text-center\"]/a)["+i+"]")).click();
                driver.findElement(continueShoppingBtn).click();
                System.out.println("product added to the cart with price " +productsPrices);
            }
        }

    }
public void viewCartProducts(){
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    driver.findElement(veiwCartBtn).click();
    TakesScreenshot screenshot = (TakesScreenshot) driver;
    File srcFile = screenshot.getScreenshotAs(OutputType.FILE);
    File destFile = new File("C:\\Users\\DELL\\IdeaProjects\\AutomationExercisePractice\\src\\main\\resources\\cart_view.png");

    try {
        FileHandler.copy(srcFile, destFile);
        System.out.println("Screenshot saved at: " + destFile.getAbsolutePath());
    } catch (IOException e) {
        System.err.println("Failed to save screenshot: " + e.getMessage());
    }
}

}


