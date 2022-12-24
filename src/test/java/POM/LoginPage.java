package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    WebDriver driver = null;

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public WebElement userName()
    {
        return driver.findElement(By.id("Email"));
    }

    public WebElement password()
    {
        return driver.findElement(By.xpath("//*[@id=\"Password\"]"));
    }

    public WebElement loginButton()
    {
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[3]/button"));
    }

    public WebElement forgotPassword()
    {
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[2]/form/div[2]/div[3]/span"));
    }



}
