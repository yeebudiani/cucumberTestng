package awesomecucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StorePage extends  BasePage
{
    public StorePage(WebDriver driver) {
        super(driver);
    }



    @FindBy(xpath=("//a[@class='added_to_cart wc-forward']"))
    private WebElement viewcartlink;


    public void viewCart(String productName)
    {
        By addtocart= By.xpath("//A[@aria-label='Add “"+productName+"” to your cart']");
        wait.until(ExpectedConditions.elementToBeClickable( driver.findElement(addtocart))) .click();

        wait.until(ExpectedConditions.elementToBeClickable(viewcartlink)).click();
    }

}
