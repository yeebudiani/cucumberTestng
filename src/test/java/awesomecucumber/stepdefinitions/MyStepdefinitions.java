package awesomecucumber.stepdefinitions;

import awesomecucumber.DomainObjects.BillingDetails;
import awesomecucumber.DomainObjects.Product;
import awesomecucumber.constants.MyEndPoint;
import awesomecucumber.context.TestContext;
import awesomecucumber.factory.DriverFactory;
import awesomecucumber.pages.CartPage;
import awesomecucumber.pages.CheckOutPage;
import awesomecucumber.pages.StorePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class MyStepdefinitions {
    private final WebDriver driver;





    public MyStepdefinitions(TestContext context) {
        // System.out.println("STEP DEF:DI:SCENARIO NAME:"+ context.scenarioName);

        driver= context.driver;
    }



}
