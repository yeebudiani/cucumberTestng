package awesomecucumber.customtype;

import awesomecucumber.DomainObjects.BillingDetails;
import io.cucumber.java.DataTableType;

import java.util.Map;

public class CustomDataTableType {

        @DataTableType
        public BillingDetails billingDetailsentry(Map<String,String> entry)
        {
            return new BillingDetails(entry.get("first name"),
                    entry.get("last name"),
                    entry.get("country"),
                    entry.get("address1"),
                    entry.get("address2"),
                    entry.get("town/city"),
                    entry.get("state"),
                    entry.get("Zip code"),
                    entry.get("email")
                    );
        }
}
