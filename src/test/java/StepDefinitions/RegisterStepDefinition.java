package StepDefinitions;

import POM.HomePage;
import POM.RegistrationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


import static StepDefinitions.Hooks.driver;


public class RegisterStepDefinition {

    HomePage home = new HomePage(driver);
    RegistrationPage register = new RegistrationPage(driver);

    @Given("user navigate to registration page")
    public void openRegistrationPage() {
        home.register().click();
    }


    @When("user choose gender")
    public void chooseGender()
    {
        register.genderMale().click();
    }

    @And("user enter first name")
    public void enterFirstName()
    {
        register.firstName().sendKeys("youssef");
    }

    @And("user enter last name")
    public void enterLastName()
    {
        register.lastName().sendKeys("samir");
    }

    @And("user enter email")
    public void enterEmail()
    {
        register.email().sendKeys("yousseftest@gmail.com");
    }

    @And("user enter password")
    public void enterPassword()
    {
        register.password().sendKeys("12345678");
    }

    @And("user confirm password")
    public void confirmPassword()
    {
        register.confirmPassword().sendKeys("12345678");
    }

    @Then("user could register successfully")
    public void clickOnRegisterBtn()
    {
        register.registerButton().click();
    }

    @And("receive success message")
    public void registered() throws InterruptedException {
        String expectedResult = "Your registration completed";
        Thread.sleep(2000);
        String actualResult = register.getSuccessMessage().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

}
