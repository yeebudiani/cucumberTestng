package awesomecucumber.stepdefinitions;

import awesomecucumber.DomainObjects.BillingDetails;
import awesomecucumber.context.TestContext;
import awesomecucumber.pages.CheckOutPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutStepDefinitions
{
    private final WebDriver driver;

    //private BillingDetails billingDetails;
    //this line has moved to context package Testcontext and its access is given i constructor
    private final TestContext context;

    public CheckoutStepDefinitions(TestContext context)
    {
        driver= context.driver;
        this.context=context; // this has to assign to billing details
    }

   /* private String billingFirstName;
    private String billingLastName;
    private String billingCountry;
    private String billingAddress1;
    private String BillingAddress2;
    private String billingCity;
    private String billingState;
    private String billingZipcode;
    private String billingEmail;*/ // moved to BillingObjects to create domain objects for the variables

    // after moved we wrote below code

    //Sharing state example
    @And("my billing details are")
    /*public void myBillingDetailsAre(List<Map<String, String>> billing)*/ //removed bcoz domain object is created
    // for this  and new line of dis desiigned via private variable mentioned above
    public void myBillingDetailsAre(BillingDetails billingDetails)
    {
      /*  billingFirstName = billing.get(0).get("first name");
        billingLastName = billing.get(0).get("last name");
        billingCountry = billing.get(0).get("country");
        billingAddress1 = billing.get(0).get("address1");
        BillingAddress2 = billing.get(0).get("address2");
        billingCity = billing.get(0).get("town/city");
        billingState = billing.get(0).get("state");
        billingZipcode = billing.get(0).get("Zip code");
        billingEmail = billing.get(0).get("email");*/ //code  moved to custom parameters

       // this.billingDetails=billingDetails;
        //this above line has changed for Testcontext as shown in below
        context.billingDetails=billingDetails;

    }




    @And("I have to provide billingDetails")
    public void iHaveToProvideBillingDetails()
    // public void iHaveToProvideBillingDetails(List<Map<String, String>> billing)//this line has changed to above line
    // and it has been assingned to 2nd step for state change
    {
      /*  Thread.sleep(5000);
        By fname = By.id("billing_first_name");
        By lname = By.id("billing_last_name");
        By country = By.id("billing_country");
        By ad1 = By.id("billing_address_1");
        By ad2 = By.id("billing_address_2");
        By city = By.id("billing_city");
        By state=By.id("billing_state");
        By zcode=By.id("billing_postcode");
        By mail=By.id("billing_email");



        driver.findElement(fname).clear();
        driver.findElement(fname).sendKeys(billing.get(0).get("first name"));
        driver.findElement(lname).clear();
        driver.findElement(lname).sendKeys(billing.get(0).get("last name"));
        Select ctry = new Select(driver.findElement(country));
        ctry.selectByVisibleText(billing.get(0).get("country"));
        driver.findElement(ad1).clear();
        driver.findElement(ad1).sendKeys(billing.get(0).get("address1"));
        driver.findElement(ad2).clear();
        driver.findElement(ad2).sendKeys(billing.get(0).get("address2"));
        driver.findElement(city).clear();
        driver.findElement(city).sendKeys(billing.get(0).get("town/city"));
        Select stot=new Select(driver.findElement(state));
        stot.selectByVisibleText(billing.get(0).get("state"));
        driver.findElement(zcode).clear();
        driver.findElement(zcode).sendKeys(billing.get(0).get("Zip code"));
        driver.findElement(mail).clear();
        driver.findElement(mail).sendKeys(billing.get(0).get("email"));*/   //code has moved to Cart page for POM


       /* CheckOutPage c = new CheckOutPage(driver);
        c.BillingDetails(billing.get(0).get("first name"),
                billing.get(0).get("last name"),
                billing.get(0).get("country"),
                billing.get(0).get("address1"),
                billing.get(0).get("address2"),
                billing.get(0).get("town/city"),
                billing.get(0).get("state"),
                billing.get(0).get("Zip code"),
                billing.get(0).get("email"));*/   //for sharing between states it has been cooment and these steps
        //are thrown to second steop of billing details and ne w code is written below
        CheckOutPage c = new CheckOutPage(driver);
         /* c.setBillingDetails(billingFirstName,
                  billingLastName,
                  billingCountry,
                  billingAddress1,
                  BillingAddress2,
                  billingCity,
                  billingState,
                  billingZipcode,
                  billingEmail);*/
       // c.setBillingDetails(billingDetails);
        //new code after setting Testcontext is written below
        c.setBillingDetails(context.billingDetails);

    }


    @Then("I should be place order")
    public void iShouldBePlaceOrder() {

       /* By porder=By.xpath("//button[@id='place_order']");
        driver.findElement(porder).click();
        Thread.sleep(5000);
        By valid=By.xpath("//p[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received']");
       String expectedmsg= driver.findElement(valid).getText();
        String acttext="Thank you. Your order has been received.";
        Assert.assertEquals(acttext,expectedmsg);
        Thread.sleep(5000);*/   //code hade moved to cartpage in the form POM

        CheckOutPage c=new CheckOutPage(driver);
        c.porder();
        String acttext="Thank you. Your order has been received.";
        c.validation();
        Assert.assertEquals(acttext,c.validation());

    }


}
