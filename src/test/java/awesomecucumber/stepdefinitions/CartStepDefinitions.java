package awesomecucumber.stepdefinitions;

import awesomecucumber.DomainObjects.Product;
import awesomecucumber.context.TestContext;
import awesomecucumber.pages.CartPage;
import awesomecucumber.pages.PageFactoryManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class CartStepDefinitions
{
   // private final WebDriver driver;
    private final CartPage cartPage;


    public CartStepDefinitions(TestContext context)
    {
       // driver= context.driver;
        cartPage= PageFactoryManager.getCartPage(context.driver);
    }

    @Then("I should see {int} {product} in the cart")
    public void iShouldSeeInTheCart(int quantity, Product product) {
        /*Thread.sleep(5000);
        By qvalue=By.xpath("//div[@class='quantity']/child::input[@class='input-text qty text']");
        String qan= driver.findElement(qvalue).getAttribute("value");
        By pname=By.xpath("//div[@id='primary']/descendant::a[text()='Blue Shoes']");
        String proname=driver.findElement(pname).getText();
        int quan=Integer.parseInt(String.valueOf(qan));*/  // moved to cart page for optimized code


        //CartPage c=new CartPage(driver);
          //this tep has been removed bcoz of step step created in constructor
        // through page factory manager
        Assert.assertEquals(product.getName(), cartPage.proname(product.getName()));
        Assert.assertEquals(quantity, cartPage.qty());



    }


    @And("I should go to checkout page")
    public void iShouldGoToChekoutPage() {
       /* By check=By.xpath("//a[@class='checkout-button button alt wc-forward']");
        driver.findElement(check).click();*/  // moved to cart page

/*
        new CartPage(driver).checkout();// new POM optimised code
*/          //due to creation of object in Page Factory Manager class
        //the changed code is written below
        cartPage.checkout();

    }

}
