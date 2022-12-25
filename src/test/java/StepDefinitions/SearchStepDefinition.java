package StepDefinitions;

import POM.HomePage;
import POM.LoginPage;
import POM.SearchPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchStepDefinition {

    WebDriver driver = null;
    HomePage home;
    LoginPage login;
    SearchPage search;


    @Given("user login to his account")
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
        home.login().click();
        login.userName().sendKeys("yui@gmail.com");
        login.password().sendKeys("12345678");
        login.loginButton().click();
    }

    @And("user enter name of product at search box")
    public void searchOnProduct()
    {
        home.searchBox().clear();
        home.searchBox().sendKeys("apple");
    }

    @And("user click on search")
    public void clickSearchButton()
    {
        home.searchButton().click();
    }

    @Then("user could see the product displayed")
    public void productIsDisplayed() throws InterruptedException {
        Thread.sleep(2000);
        boolean expectedResult = search.appleProduct().isDisplayed();
        Assert.assertEquals(expectedResult, true);
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
