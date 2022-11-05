package awesomecucumber.customtype;

import awesomecucumber.DomainObjects.Product;
import io.cucumber.java.ParameterType;

public class CustomParameterType
{
    @ParameterType(".*")
    public Product product(String name)

    {
     return new Product(name.replace("\"",""));
    }
    @ParameterType(".*")
    public Product menproduct(String name)
    {
        return new Product(name.replace("\"",""));
    }
}
