package StepDefinitions;

import POM.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;


import static StepDefinitions.Hooks.driver;


public class HomeStepDefinition {

    HomePage home = new HomePage(driver);
    CategoryPage category = new CategoryPage(driver);
    LoginPage login = new LoginPage(driver);


    @Given("user logged in to select category")
    public void loggedUser(){
        home.login().click();
        login.userName().sendKeys("youssefsamir@gmail.com");
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

}
