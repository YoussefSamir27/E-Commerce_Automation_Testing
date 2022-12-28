package StepDefinitions;

import POM.*;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {

    static WebDriver driver = null;

    @Before
    public static void openBrowser() throws InterruptedException {
        String chromePath = System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", chromePath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to("https://demo.nopcommerce.com/");
        Thread.sleep(1000);
    }

    @After
    public static void closeBrowser()
    {
        try{
            Thread.sleep(2000);
            driver.quit();
        }catch (NullPointerException e) {
            System.out.println("NullPointerException Thrown!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
