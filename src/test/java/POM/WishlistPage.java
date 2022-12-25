package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WishlistPage {

    WebDriver driver = null;

    public WishlistPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getWishlistMessage()
    {
        return driver.findElement(By.xpath("//*[@id=\"bar-notification\"]/div/p"));
    }


}
