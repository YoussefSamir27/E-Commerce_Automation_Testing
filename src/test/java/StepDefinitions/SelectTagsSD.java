package StepDefinitions;

import POM.CategoryPage;
import POM.HomePage;
import POM.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import static StepDefinitions.Hooks.driver;


public class SelectTagsSD {

    HomePage home = new HomePage(driver);
    CategoryPage category = new CategoryPage(driver);
    LoginPage login = new LoginPage(driver);

    @Given("user login")
    public void loginToWebsite()
    {
        home.login().click();
        login.userName().sendKeys("youssefsamir@gmail.com");
        login.password().sendKeys("12345678");
        login.loginButton().click();
    }

    @And("user choose specific category")
    public void selectCategory()
    {
        home.selectBookCategory().click();
    }

    @And("user select any tag")
    public void selectTag()
    {
        category.computerTag().click();
    }

    @Then("this tag page should be opened successfully")
    public void validateSuccessTag() throws InterruptedException {
        Thread.sleep(2000);
        String expectedResult = "Products tagged with \'computer\'";
        String actualResult = category.getMessageOfTag().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
}
