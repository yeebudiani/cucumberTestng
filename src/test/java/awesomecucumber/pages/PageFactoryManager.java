package awesomecucumber.pages;

import org.openqa.selenium.WebDriver;

public class PageFactoryManager {
    //this class has been created  to get rid of new StorePage(driver) type of syntax in every page
   // these changes you can see in step definition files of each page
    private static StorePage storePage;
    private static CartPage cartPage;
    private static CheckOutPage checkOutPage;

    public static StorePage getStorePage(WebDriver driver)
    {
      return storePage==null?new StorePage(driver):storePage;
    }
    public static CartPage getCartPage(WebDriver driver)
    {
        return cartPage==null?new CartPage(driver):cartPage;
    }
    public static CheckOutPage getCheckOutPage(WebDriver driver)
    {
        return checkOutPage==null?new CheckOutPage(driver):checkOutPage;
    }
}
