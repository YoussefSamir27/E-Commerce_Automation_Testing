package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

    WebDriver driver = null;

    public CartPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public WebElement getCartMessage()
    {
        return driver.findElement(By.xpath("//*[@id=\"bar-notification\"]/div/p"));
    }
}
