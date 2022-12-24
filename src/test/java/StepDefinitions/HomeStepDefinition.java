package StepDefinitions;

import POM.*;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeStepDefinition {

    WebDriver driver = null;
    HomePage home;
    LoginPage login;
    SearchPage search;
    CategoryPage category;


    @Given("user logged in to select category")
    public void loggedUser() throws InterruptedException {
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.navigate().to("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        home = new HomePage(driver);
        login = new LoginPage(driver);
        search = new SearchPage(driver);
        category = new CategoryPage(driver);
        home.login().click();
        login.userName().sendKeys("qwe@gmail.com");
        login.password().sendKeys("12345678");
        login.loginButton().click();
    }

    @And("user hover on category and select subcategory")
    public void selectCategory()
    {
        home.hoverOnCategory();
    }

    @Then("the selected category should be displayed")
    public void checkSelectedCategory() throws InterruptedException {
        Thread.sleep(2000);
        boolean actualResult = category.categoryExist().isDisplayed();
        Assert.assertEquals(true, actualResult);
    }

    @After
    public void close()
    {
        try{
            driver.quit();
        }catch (NullPointerException e) {
            System.out.println("NullPointerException Thrown!");
        }
    }
}
