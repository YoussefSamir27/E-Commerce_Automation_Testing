package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {
    WebDriver driver = null;

    public ForgotPassword(WebDriver driver)
    {
        this.driver = driver;
    }

    public WebElement emailAddress()
    {
        return driver.findElement(By.xpath("//*[@id=\"Email\"]"));
    }

    public WebElement recoverButton()
    {
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/form/div[2]/button"));
    }

    public WebElement getRecoverMessage()
    {
        return driver.findElement(By.xpath("//*[@id=\"bar-notification\"]/div/p"));
    }
}
