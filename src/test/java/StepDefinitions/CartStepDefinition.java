package StepDefinitions;

import POM.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


import static StepDefinitions.Hooks.driver;


public class CartStepDefinition {

    HomePage home = new HomePage(driver);
    LoginPage login = new LoginPage(driver);
    CategoryPage category = new CategoryPage(driver);
    CartPage cart = new CartPage(driver);


    @Given("user logged in to add product to cart")
    public void loggedUser(){
        home.login().click();
        login.userName().sendKeys("yousseftest@gmail.com");
        login.password().sendKeys("12345678");
        login.loginButton().click();
    }

    @When("user choose category")
    public void selectCategory()
    {
        home.selectBookCategory().click();
    }

    @And("user add product to cart")
    public void addToCart()
    {
        category.addToCartButton().click();
    }

    @Then("product should be added successfully to cart")
    public void productAddedToCart() throws InterruptedException {
        Thread.sleep(2000);
        String expectedResult = "The product has been added to your shopping cart";
        String actualResult = cart.getCartMessage().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

}
