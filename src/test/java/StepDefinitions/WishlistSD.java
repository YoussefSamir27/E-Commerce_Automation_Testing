package StepDefinitions;

import POM.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


import static StepDefinitions.Hooks.driver;


public class WishlistSD {

    HomePage home = new HomePage(driver);
    LoginPage login = new LoginPage(driver);
    CategoryPage category = new CategoryPage(driver);
    WishlistPage list = new WishlistPage(driver);


    @Given("user logged in to add product to wishlist")
    public void loggedUser(){
        home.login().click();
        login.userName().sendKeys("yousseftest@gmail.com");
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

}
