package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage {

    WebDriver driver = null;
    Select country;

    public CheckoutPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void editBillingAddress()
    {
        country = new Select(driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_CountryId\"]")));
        country.selectByIndex(65);
        driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_City\"]")).sendKeys("Cairo");
        driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_Address1\"]")).sendKeys("Giza");
        driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_ZipPostalCode\"]")).sendKeys("00000");
        driver.findElement(By.xpath("//*[@id=\"BillingNewAddress_PhoneNumber\"]")).sendKeys("01122220007");
        driver.findElement(By.xpath("//*[@id=\"billing-buttons-container\"]/button[4]")).click();
    }

    public void shippingMethod()
    {
        driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button")).click();
    }

    public void paymentMethod()
    {
        driver.findElement(By.xpath("//*[@id=\"payment-method-buttons-container\"]/button")).click();
    }

    public void paymentInformation()
    {
        driver.findElement(By.xpath("//*[@id=\"payment-info-buttons-container\"]/button")).click();
    }

    public void confirmOrder()
    {
        driver.findElement(By.xpath("//*[@id=\"confirm-order-buttons-container\"]/button")).click();
    }

    public WebElement getOrderMessage()
    {
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[1]/strong"));
    }
}
