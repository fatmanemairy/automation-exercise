package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class P02_HomePage {
    WebDriver driver;
    ////////////Locators//////////
    By menCategoryButton= By.xpath("//a[contains(.,\"Men\")]");
    By t_shirtCategoryButton= By.xpath("//a[contains(.,\"Tshirts \")]");

    ////////////Constructor//////////////
    public P02_HomePage(WebDriver driver){this.driver=driver;}
    ////////////Actions/////////////////
    public void navigateToProducts(){
     driver.findElement(menCategoryButton).click();
     driver.findElement(t_shirtCategoryButton).click();
    }


}
