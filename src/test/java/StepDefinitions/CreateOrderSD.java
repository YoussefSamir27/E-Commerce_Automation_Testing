package StepDefinitions;

import POM.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static StepDefinitions.Hooks.driver;

public class CreateOrderSD {

    HomePage home = new HomePage(driver);
    LoginPage login = new LoginPage(driver);
    CategoryPage category = new CategoryPage(driver);
    CheckoutPage checkout = new CheckoutPage(driver);
    CartPage cart = new CartPage(driver);

    @When("user login to website")
    public void loggedUser()
    {
        home.login().click();
        login.userName().sendKeys("youssefsamir@gmail.com");
        login.password().sendKeys("12345678");
        login.loginButton().click();
    }

    @And("user choose any category")
    public void selectCategory()
    {
        home.selectBookCategory().click();
    }

    @And("user add any product to cart")
    public void addToCart()
    {
        category.addToCartButton().click();
    }

    @And("user open cart page")
    public void openCartPage()
    {
        home.cartPageButton().click();
    }

    @And("user agree terms and conditions")
    public void agreeTermsANDConditions()
    {
        cart.termsAndConditions().click();
    }

    @And("user click on checkout")
    public void clickOnCheckout()
    {
        cart.checkoutButton().click();
    }

    @And("user edit billing address")
    public void addBillingAddress()
    {
        checkout.editBillingAddress();
    }

    @And("user choose shipping method")
    public void selectShippingMethod()
    {
        checkout.shippingMethod();
    }

    @And("user choose payment method")
    public void selectPaymentMethod()
    {
        checkout.paymentMethod();
    }

    @And("user check payment information")
    public void checkPaymentInformation()
    {
        checkout.paymentInformation();
    }

    @And("user confirm order")
    public void clickConfirmOrder()
    {
        checkout.confirmOrder();
    }

    @Then("order should be placed successfully")
    public void checkOrderIsPlaced() throws InterruptedException {
        Thread.sleep(2000);
        String expectedResult = "Your order has been successfully processed!";
        String actualResult = checkout.getOrderMessage().getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

}
