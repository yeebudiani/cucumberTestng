package awesomecucumber.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    // for parallel execution we have changeed below line from public static webdriver driver;
    // private  static final ThreadLocal<WebDriver> driver=new ThreadLocal<>();
    //to inject pico container to the webdriver we are removing the above Thread local class

    public static WebDriver intializeDriver(String browser) {
        WebDriver driver;
        switch (browser) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
            default -> throw new RuntimeException("INVALID BROWSER NAME" + browser);
        }

        driver.manage().window().maximize();
        // DriverFactory.driver.set(driver);
        //removed bcoz thread local class has been removed above
        return driver;
    }

   /* public static  WebDriver getDriver()
    {
        return driver.get();
    }
*/  //bcoz thread local has been removed in the above to inject pico container to the webdriver

}