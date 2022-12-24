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

public class RegisterStepDefinition {

    WebDriver driver = null;
    HomePage home;
    LoginPage login;
    RegistrationPage register;

    @Given("user open browser navigate to registration page")
    public void openRegistrationPage() throws InterruptedException {
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.navigate().to("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        home = new HomePage(driver);
        login = new LoginPage(driver);
        register = new RegistrationPage(driver);
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
        register.firstName().sendKeys("zxc");
    }

    @And("user enter last name")
    public void enterLastName()
    {
        register.lastName().sendKeys("uuu");
    }

    @And("user enter email")
    public void enterEmail()
    {
        register.email().sendKeys("zxc@gmail.com");
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
