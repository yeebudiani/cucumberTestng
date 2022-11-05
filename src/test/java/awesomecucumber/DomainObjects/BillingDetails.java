package awesomecucumber.DomainObjects;

public class BillingDetails {


    public BillingDetails(String billingFirstName, String billingLastName,
                          String billingCountry, String billingAddress1,
                          String billingAddress2, String billingCity,
                          String billingState, String billingZipcode,
                          String billingEmail)
    {
        this.billingFirstName = billingFirstName;
        this.billingLastName = billingLastName;
        this.billingCountry = billingCountry;
        this.billingAddress1 = billingAddress1;
        BillingAddress2 = billingAddress2;
        this.billingCity = billingCity;
        this.billingState = billingState;
        this.billingZipcode = billingZipcode;
        this.billingEmail = billingEmail;
    }

    private String billingFirstName;
    private String billingLastName;
    private String billingCountry;
    private String billingAddress1;
    private String BillingAddress2;
    private String billingCity;
    private String billingState;
    private String billingZipcode;
    private String billingEmail;

    public String getBillingFirstName() {
        return billingFirstName;
    }

    public void setBillingFirstName(String billingFirstName) {
        this.billingFirstName = billingFirstName;
    }

    public String getBillingLastName() {
        return billingLastName;
    }

    public void setBillingLastName(String billingLastName) {
        this.billingLastName = billingLastName;
    }

    public String getBillingCountry() {
        return billingCountry;
    }

    public void setBillingCountry(String billingCountry) {
        this.billingCountry = billingCountry;
    }

    public String getBillingAddress1() {
        return billingAddress1;
    }

    public void setBillingAddress1(String billingAddress1) {
        this.billingAddress1 = billingAddress1;
    }

    public String getBillingAddress2() {
        return BillingAddress2;
    }

    public void setBillingAddress2(String billingAddress2) {
        BillingAddress2 = billingAddress2;
    }

    public String getBillingCity() {
        return billingCity;
    }

    public void setBillingCity(String billingCity) {
        this.billingCity = billingCity;
    }

    public String getBillingState() {
        return billingState;
    }

    public void setBillingState(String billingState) {
        this.billingState = billingState;
    }

    public String getBillingZipcode() {
        return billingZipcode;
    }

    public void setBillingZipcode(String billingZipcode) {
        this.billingZipcode = billingZipcode;
    }

    public String getBillingEmail() {
        return billingEmail;
    }

    public void setBillingEmail(String billingEmail) {
        this.billingEmail = billingEmail;
    }


}
