package awesomecucumber.stepdefinitions;

import awesomecucumber.DomainObjects.Product;
import awesomecucumber.constants.EndPoint;
import awesomecucumber.context.TestContext;
import awesomecucumber.factory.DriverFactory;
import awesomecucumber.pages.CartPage;
import awesomecucumber.pages.MenSectionPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class MensAccessories
{
    private final WebDriver driver;

    public MensAccessories(TestContext context)
    {
       // System.out.println("STEP DEF:DI:SCENARIO NAME:"+ context.scenarioName);

        driver= context.driver;
    }

    @Given("I'm on the Mens page")
    public void iMOnTheMensPage() {
      /*  //below code ha removed for dependency injection to webDriver
        driver= DriverFactory.getDriver();*/
        //new code for dependency injection is given in class constructor

       // new MenSectionPage(driver).load("https://askomdch.com/product-category/men/");
        //this has commented to get config properties base url

      //  new MenSectionPage(driver).load(ConfigLoader.getInstance().getBaseUrl()+"/product-category/men/");
       // this is one one to represent base url
        //optimized way is just to put it in base page the we get following code below

       // new MenSectionPage(driver).load("/product-category/men/");
        // after adding endpoint in constants new code is given below
        new MenSectionPage(driver).load(EndPoint.MEN.url);
    }

    @When("I will add a {menproduct} to the cart")
    public void iWillAddAToTheCart(Product menproduct)
    {
        new MenSectionPage(driver).viewcart(menproduct.getName());
    }

    @Then("I should be able to see {int} {menproduct} in the cart")
    public void iShouldBeAbleToSeeInTheCart(int qty, Product menproduct)
    {
        CartPage c=new CartPage(driver);
        Assert.assertEquals(qty,c.qty());
        Assert.assertEquals(menproduct.getName(),c.proname(menproduct.getName()));
    }



}
