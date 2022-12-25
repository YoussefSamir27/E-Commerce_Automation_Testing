package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ComparePage {
    WebDriver driver;

    public ComparePage(WebDriver driver)
    {
        this.driver = driver;
    }

    public WebElement getCompareListMessage()
    {
        return driver.findElement(By.xpath("//*[@id=\"bar-notification\"]/div"));
    }
}
