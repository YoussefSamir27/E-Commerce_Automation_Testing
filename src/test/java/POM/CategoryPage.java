package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CategoryPage {

    WebDriver driver = null;

    public CategoryPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public WebElement categoryExist()
    {
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[1]/h1"));
    }

    public WebElement redColorFilter()
    {
        return driver.findElement(By.xpath("//*[@id=\"attribute-option-15\"]"));
    }

    public WebElement filteredCategory()
    {
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div/div/div[2]/h2/a"));
    }

    public WebElement addToCartButton()
    {
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/button[1]"));
    }

    public WebElement addToWishlistButton()
    {
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/button[3]"));
    }

    public WebElement addToCompareButton()
    {
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/button[2]"));
    }

    public WebElement computerTag()
    {
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div[4]/div[2]/div[1]/ul/li[7]"));
    }

    public WebElement getMessageOfTag()
    {
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[1]/h1"));
    }

    public WebElement awesomeTag()
    {
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div[4]/div[2]/div[1]/ul/li[2]/a"));
    }
}
