package StepDefinitions;

import POM.HomePage;
import POM.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


import static StepDefinitions.Hooks.driver;


public class LoginStepDefinition {

    HomePage home = new HomePage(driver);
    LoginPage login = new LoginPage(driver);

    @Given("user to login page")
    public void openLoginPage() throws InterruptedException {
        home.login().click();

    }

    @When("user enter valid email")
    public void enterEmail()
    {
        login.userName().sendKeys("yousseftest@gmail.com");
    }

    @And("user enter valid password")
    public void enterPassword()
    {
        login.password().sendKeys("12345678");
    }

    @And("user click on login")
    public void clickLoginButton()
    {
        login.loginButton().click();
    }

    @Then("user could login successfully and redirected to home page")
    public void successLogin() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertEquals("https://demo.nopcommerce.com/", home.getURL());
    }



}
