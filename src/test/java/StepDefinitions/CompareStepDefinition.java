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

public class CompareStepDefinition {

    WebDriver driver = null;
    HomePage home;
    LoginPage login;
    SearchPage search;
    CategoryPage category;
    ComparePage compare;


    @Given("user logged in to add product to compare list")
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
        compare = new ComparePage(driver);
        home.login().click();
        login.userName().sendKeys("yousefsamir51@gmail.com");
        login.password().sendKeys("12345678");
        login.loginButton().click();
    }

    @When("user select specific category")
    public void selectCategory()
    {
        home.selectBookCategory().click();
    }

    @And("user add product to compare list")
    public void addToCompareList()
    {
        category.addToCompareButton().click();
    }

    @Then("the product should added to compare list successfully")
    public void productAddedToWishList() throws InterruptedException {
        Thread.sleep(2000);
        String expectedResult = "The product has been added to your product comparison";
        String actualResult = compare.getCompareListMessage().getText();
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
