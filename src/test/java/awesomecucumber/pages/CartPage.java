package awesomecucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='quantity']/child::input[@class='input-text qty text']") private WebElement quantity;



    @FindBy(xpath=("//a[@class='checkout-button button alt wc-forward']")) private WebElement movetocheckoutbtn ;

    public int qty()
    {
        int qvalue= Integer.parseInt(quantity.getAttribute("value"));
        return qvalue;
    }

    public String proname(String productName)
    {
        By proname= By.xpath("//div[@id='primary']/descendant::a[text()='"+productName+"']");
        String pname=wait.until(ExpectedConditions.elementToBeClickable( driver.findElement(proname))) .getText();
        String prname= String.valueOf(pname);
        return prname;
    }

    public void checkout()
    {
        wait.until(ExpectedConditions.elementToBeClickable(movetocheckoutbtn)).click();
    }
}
