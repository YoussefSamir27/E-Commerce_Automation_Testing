package StepDefinitions;

import POM.HomePage;
import POM.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import static StepDefinitions.Hooks.driver;


public class SwitchCurrencySD {

    HomePage home = new HomePage(driver);
    LoginPage login = new LoginPage(driver);

    @Given("user logged in to select currency")
    public void loggedUser()
    {
        home.login().click();
        login.userName().sendKeys("youssefsamir@gmail.com");
        login.password().sendKeys("12345678");
        login.loginButton().click();
    }

    @And("user select EURO currency")
    public void switchCurrency()
    {
        home.selectEuroCurrency();
    }

    @Then("euro sign should be displayed at website")
    public void checkEuroSign()
    {
        boolean actual = home.validateCurrency().isDisplayed();
        Assert.assertTrue(actual);
    }
}
