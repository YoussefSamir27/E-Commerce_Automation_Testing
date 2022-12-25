package StepDefinitions;

import POM.CategoryPage;
import POM.HomePage;
import POM.LoginPage;
import POM.SearchPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CategoryStepDefinition {
    WebDriver driver = null;
    HomePage home;
    LoginPage login;
    SearchPage search;
    CategoryPage category;


    @Given("user is logged in to filter")
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
        login.userName().sendKeys("yui@gmail.com");
        login.password().sendKeys("12345678");
        login.loginButton().click();
    }

    @When("user select category")
    public void selectCategory()
    {
        home.hoverOnCategory();
    }

    @And("user filter by color")
    public void filterByColor()
    {
        category.redColorFilter().click();
    }

    @Then("products with this attribute should be displayed")
    public void checkFiltration() throws InterruptedException {
        Thread.sleep(2000);
        boolean actualResult = category.filteredCategory().isDisplayed();
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
