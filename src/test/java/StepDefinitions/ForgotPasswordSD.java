package StepDefinitions;

import POM.ForgotPassword;
import POM.HomePage;
import POM.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;


import static StepDefinitions.Hooks.driver;

public class ForgotPasswordSD {

    HomePage home = new HomePage(driver);
    LoginPage login = new LoginPage(driver);
    ForgotPassword forget = new ForgotPassword(driver);

    @Given("user opened login page")
    public void openLoginPage(){
        home.login().click();
    }

    @And("user click on reset password")
    public void forgotPassword()
    {
        login.forgotPassword().click();
    }

    @And("user enter his email")
    public void enterEmail()
    {
        forget.emailAddress().sendKeys("youssefsamir@gmail.com");
    }

    @And("user click recover")
    public void clickOnRecover(){
        forget.recoverButton().click();
    }

    @Then("user should receive a link to reset password")
    public void checkRecoverMessage() throws InterruptedException {
        String expectedResult = "Email with instructions has been sent to you.";
        Thread.sleep(2000);
        String actualResult =  forget.getRecoverMessage().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }


}
