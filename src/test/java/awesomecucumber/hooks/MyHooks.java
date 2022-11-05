package awesomecucumber.hooks;

import awesomecucumber.context.TestContext;
import awesomecucumber.factory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class MyHooks {
    private  WebDriver driver;
    //creating variable for pico container class
    private final TestContext context;

    public MyHooks(TestContext context) {
        this.context = context;
    }


    @Before
    public   void before(Scenario scenario)
    {
        //pico container scenario visibibility with above variable
        /*context.scenarioName= scenario.getName();
        System.out.println("DI injection scenario name : "+context.scenarioName);
*/    //removed to have Dependency injection to the Web Driver
        //for parallel execution we added surfire plugin in pom
        System.out.println("BEFORE:THREAD ID:"+ Thread.currentThread().getId()+","+
                "SCENARIO NAME:"+ scenario.getName());

        driver= DriverFactory.intializeDriver(System.getProperty("browser","chrome"));
        //changed this way after adding multiple browsers in Driverfactory
        context.driver=driver;
    }

    @After
    public  void after(Scenario scenario)
    {
        System.out.println("AFTER:THREAD ID:"+ Thread.currentThread().getId()+","+
                "SCENARIO NAME:"+ scenario.getName());
        driver.quit();
    }
}
