package StepDefinitions;

import POM.CategoryPage;
import POM.HomePage;
import POM.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


import static StepDefinitions.Hooks.driver;


public class CategoryStepDefinition {

    HomePage home = new HomePage(driver);
    LoginPage login = new LoginPage(driver);
    CategoryPage category = new CategoryPage(driver);


    @Given("user is logged in to filter")
    public void loggedUser(){
        home.login().click();
        login.userName().sendKeys("yousseftest@gmail.com");
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


}
