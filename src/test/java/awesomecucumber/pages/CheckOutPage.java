package awesomecucumber.pages;

import awesomecucumber.DomainObjects.BillingDetails;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage extends BasePage{
    public CheckOutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = ("billing_first_name")) private WebElement fname;

    @FindBy(id = ("billing_last_name"))private WebElement lname;

    @FindBy(id = ("billing_country")) private WebElement country;

    @FindBy(id = ("billing_address_1")) private WebElement ad1;

    @FindBy(id = ("billing_address_2")) private WebElement ad2;

    @FindBy(id = ("billing_city")) private WebElement city;

    @FindBy(id = ("billing_state")) private WebElement state;

    @FindBy(id = ("select2-billing_state-container")) private WebElement alternatestate;

    @FindBy(id = ("billing_postcode")) private WebElement zcode;

    @FindBy(id = ("billing_email")) private WebElement mail;

    @FindBy(xpath=("//button[@id='place_order']")) private WebElement placeorder;

    @FindBy(xpath=("//p[@class='woocommerce-notice woocommerce-notice--success woocommerce-thankyou-order-received']")) private WebElement acttext;

    private  final By overlay=By.cssSelector(".blockUI.blockOverlay");

     public CheckOutPage enterfname(String firstname)
     {
         WebElement e=wait.until(ExpectedConditions.visibilityOf(fname));
         e.clear();
         e.sendKeys(firstname);
         return this;
     }
    public CheckOutPage enterlname(String lastname)
    {
        WebElement e=wait.until(ExpectedConditions.visibilityOf(lname));
        e.clear();
        e.sendKeys(lastname);
        return this;
    }
    public CheckOutPage entercontry(String contry)
    {
        WebElement e=wait.until(ExpectedConditions.visibilityOf(country));
        Select ctry = new Select(e);
        ctry.selectByVisibleText(contry);
        return this;

    }
    public CheckOutPage enteraddress1(String address1)
    {
        WebElement e=wait.until(ExpectedConditions.visibilityOf(ad1));
        e.clear();
        e.sendKeys(address1);
        return this;
    }
    public CheckOutPage enteraddress2(String address2)
    {
        WebElement e=wait.until(ExpectedConditions.visibilityOf(ad2));
        e.clear();
        e.sendKeys(address2);
        return this;
    }
    public CheckOutPage enterscity(String scity)
    {
        WebElement e=wait.until(ExpectedConditions.visibilityOf(city));
        e.clear();
        e.sendKeys(scity);
        return this;
    }
    public CheckOutPage enterstates(String states)
    {
      /*  WebElement e=wait.until(ExpectedConditions.visibilityOf(state));
        Select stat = new Select(e);
        stat.selectByVisibleText(states);
        */ //for execution in firefosxit will not work for select class in dropdown
        //so below method was written to execute in maven command line
        wait.until(ExpectedConditions.elementToBeClickable(alternatestate)).click();
        WebElement e=wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//li[text()='"+states+"']")));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",e);
        e.click();

        return this;
    }
    public CheckOutPage enterzipcode(String zipcode)
    {
        WebElement e=wait.until(ExpectedConditions.visibilityOf(zcode));
        e.clear();
        e.sendKeys(zipcode);
        return this;
    }
    public CheckOutPage enteremail(String email)
    {
        WebElement e=wait.until(ExpectedConditions.visibilityOf(mail));
        e.clear();
        e.sendKeys(email);
        return this;
    }

/*     public CheckOutPage setBillingDetails(String firstname,String lastname,
                                        String contry,String address1,
                                        String address2,String scity,
                                        String states,String zipcode,
                                        String email)
     {
         return enterfname( firstname).
                 enterlname( lastname).
                 entercontry( contry).
                 enteraddress1( address1).
                 enteraddress2( address2).
                 enterscity( scity).
                 enterstates( states).
                 enterzipcode( zipcode).
                 enteremail( email);
     }*/  //after creating domain objects in custom parameters code has bee changed to below like this
    public CheckOutPage setBillingDetails(BillingDetails billingDetails)
    {
        return enterfname(billingDetails.getBillingFirstName()).
                enterlname(billingDetails.getBillingLastName()).
                entercontry(billingDetails.getBillingCountry()).
                enteraddress1(billingDetails.getBillingAddress1()).
                enteraddress2(billingDetails.getBillingAddress2()).
                enterscity(billingDetails.getBillingCity()).
                enterstates(billingDetails.getBillingState()).
                enterzipcode(billingDetails.getBillingZipcode()).
                enteremail(billingDetails.getBillingEmail());
    }
     public void porder()
     {
        waitForOverlaysToDissappear(overlay);
         wait.until(ExpectedConditions.elementToBeClickable(placeorder)).click();
     }

     public String validation()
     {

          String expmsg=wait.until(ExpectedConditions.visibilityOf(acttext)).getText();
          return expmsg;

     }

}
