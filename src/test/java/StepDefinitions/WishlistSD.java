package StepDefinitions;

import POM.*;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WishlistSD {

    WebDriver driver = null;
    HomePage home;
    LoginPage login;
    SearchPage search;
    CategoryPage category;
    WishlistPage list;


    @Given("user logged in to add product to wishlist")
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
        list = new WishlistPage(driver);
        home.login().click();
        login.userName().sendKeys("yui@gmail.com");
        login.password().sendKeys("12345678");
        login.loginButton().click();
    }

    @When("user select any category")
    public void selectCategory()
    {
        home.selectBookCategory().click();
    }

    @And("user add product to wishlist")
    public void addToWishlist()
    {
        category.addToWishlistButton().click();
    }

    @Then("product should add to wishlist successfully")
    public void productAddedToWishlist() throws InterruptedException {
        Thread.sleep(2000);
        String expectedResult = "The product has been added to your wishlist";
        String actualResult = list.getWishlistMessage().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
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
