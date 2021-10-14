package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPageElementMapper {

    @FindBy(css = "h1[itemprop]")
    public WebElement productNamePdp;

    @FindBy(css = "#add_to_cart>button")
    public WebElement buttonAddToCart;

    @FindBy(css = "a.btn:nth-child(2)")
    public WebElement buttonModalProceedToCheckout;




}
