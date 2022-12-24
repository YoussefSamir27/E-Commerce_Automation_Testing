package StepDefinitions;

import POM.HomePage;
import POM.LoginPage;
import POM.RegistrationPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginStepDefinition {

    WebDriver driver = null;
    HomePage home;
    LoginPage login;
    RegistrationPage register;

    @Given("user open browser navigate to login page")
    public void openLoginPage() throws InterruptedException {
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.navigate().to("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        home = new HomePage(driver);
        login = new LoginPage(driver);
        register = new RegistrationPage(driver);
        home.login().click();

    }

    @When("user enter valid email")
    public void enterEmail()
    {
        login.userName().sendKeys("qwe@gmail.com");
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
        Assert.assertEquals("https://demo.nopcommerce.com/", driver.getCurrentUrl());
    }

    @After
    public void close()
    {
        try{
            driver.quit();
        }catch (NullPointerException e) {
            System.out.println("NullPointerException Thrown!");
        }
    }

}
