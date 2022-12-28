package StepDefinitions;

import POM.HomePage;
import POM.LoginPage;
import POM.SearchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;


import static StepDefinitions.Hooks.driver;


public class SearchStepDefinition {

    HomePage home = new HomePage(driver);
    LoginPage login = new LoginPage(driver);
    SearchPage search = new SearchPage(driver);

    @Given("user login to his account")
    public void loggedUser() {
        home.login().click();
        login.userName().sendKeys("yousseftest@gmail.com");
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


}
