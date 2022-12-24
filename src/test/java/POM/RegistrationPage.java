package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegistrationPage {

    WebDriver driver = null;

    public RegistrationPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement genderFemale()
    {
        return driver.findElement(By.id("gender-female"));
    }

    public WebElement genderMale()
    {
        return driver.findElement(By.id("gender-male"));
    }

    public WebElement firstName()
    {
        return driver.findElement(By.name("FirstName"));
    }

    public WebElement lastName()
    {
        return driver.findElement(By.name("LastName"));
    }

    public WebElement email()
    {
        return driver.findElement(By.name("Email"));
    }

    public WebElement password()
    {
        return driver.findElement(By.name("Password"));
    }

    public WebElement confirmPassword()
    {
        return driver.findElement(By.name("ConfirmPassword"));
    }

    public WebElement registerButton(){
        return driver.findElement(By.id("register-button"));
    }

    public WebElement getSuccessMessage()
    {
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]"));
    }

    public WebElement continueButton()
    {
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[2]/a"));
    }

}
