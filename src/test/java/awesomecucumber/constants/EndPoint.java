package awesomecucumber.constants;

public enum EndPoint {
    STORE("/store"),
    ACCOUNT("/account"),
    MEN("/product-category/men/");


    public final String url;

    EndPoint(String url) {
        this.url=url;
    }
}
