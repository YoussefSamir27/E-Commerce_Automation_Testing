package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage {

    WebDriver driver = null;
    Actions action;

    //Constructor
    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        action = new Actions(driver);
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

    public void hoverOnCategory()
    {
        WebElement mainMenu;
        WebElement subMenu;
        //driver.navigate().to("https://demo.nopcommerce.com/");
        //Thread.sleep(2000);
        mainMenu = driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[3]/a"));
        action.moveToElement(mainMenu);
        subMenu = driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[3]/ul/li[1]/a"));
        action.moveToElement(subMenu);
        action.click().build().perform();
    }

    public WebElement selectBookCategory()
    {
        return driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[5]/a"));
    }
}
