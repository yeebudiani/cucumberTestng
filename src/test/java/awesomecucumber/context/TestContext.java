package awesomecucumber.context;

import awesomecucumber.DomainObjects.BillingDetails;
import org.openqa.selenium.WebDriver;

// this class is created to design pico container and it is attached in myhooks class
public class TestContext
{
   // public String scenarioName;
    //removed to inject pico container and go to my hooks page
    public WebDriver driver;

    public BillingDetails billingDetails;
}
