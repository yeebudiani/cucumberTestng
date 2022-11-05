package awesomecucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MenSectionPage extends BasePage{
    public MenSectionPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath ="//a[@class='added_to_cart wc-forward']" ) private WebElement cartviewbtn;

    public void viewcart(String productName)
    {
        By proname= By.xpath("//a[@aria-label='Add “"+productName+"” to your cart']");
        WebElement addproduct=driver.findElement(proname);
        wait.until(ExpectedConditions.elementToBeClickable(addproduct)).click();
        wait.until(ExpectedConditions.elementToBeClickable(cartviewbtn)).click();

    }
}
