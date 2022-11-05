package awesomecucumber.stepdefinitions;

import awesomecucumber.DomainObjects.Product;
import awesomecucumber.constants.MyEndPoint;
import awesomecucumber.context.TestContext;
import awesomecucumber.pages.StorePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class StoreStepDefinitions {
    private final WebDriver driver;

    public StoreStepDefinitions(TestContext context)
    {
         driver= context.driver;
    }
    @Given("I'm on the store page")
    public void iMOnTheStorePage() {
      /*  //the below code has removed  to inject pico container to driver
        driver= DriverFactory.getDriver();// came from factory pack form getDriver method() where driver is initialized
      */         //new code is inserted in  the class constructor
      /*  StorePage store=new StorePage(driver);
        store.load("https://askomdch.com/store/");*/   //direct method to pass url from base page with the help of storepage(child class of base page)

        //new StorePage(driver).load("https://askomdch.com/store/"); //Short cut to load url from store page
        //new optimized code for url with config properties and base page page is given below

        // new StorePage(driver).load("/store/");

        new StorePage(driver).load(MyEndPoint.STORE);
    }
    @When("I add a {product} to the cart")
    public void iAddAToTheCart(Product product)
    {
        //previous date has been added to store page



        new StorePage(driver).viewCart(product.getName());

    }
}
