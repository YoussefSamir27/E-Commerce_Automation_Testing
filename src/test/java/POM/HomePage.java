package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

    WebDriver driver = null;

    //Constructor
    public HomePage(WebDriver driver)
    {
        this.driver = driver;
    }

    //locate Register button
    public WebElement register(){
        return driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a"));
    }

    //locate Login Button
    public WebElement login()
    {
        return driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a"));
    }

    public String getURL()
    {
        String url = driver.getCurrentUrl();
        return url;
    }

    public WebElement searchBox()
    {
        return driver.findElement(By.xpath("//*[@id=\"small-searchterms\"]"));
    }

    public WebElement searchButton()
    {
        return driver.findElement(By.xpath("//*[@id=\"small-search-box-form\"]/button"));
    }

}
