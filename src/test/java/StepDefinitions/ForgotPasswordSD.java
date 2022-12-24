package StepDefinitions;

import POM.ForgotPassword;
import POM.HomePage;
import POM.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ForgotPasswordSD {

    WebDriver driver = null;
    HomePage home;
    LoginPage login;
    ForgotPassword forget;



    @Given("user opened login page")
    public void openLoginPage() throws InterruptedException {
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.navigate().to("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        home = new HomePage(driver);
        login = new LoginPage(driver);
        forget = new ForgotPassword(driver);
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
        forget.emailAddress().sendKeys("kkk@gmail.com");
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
