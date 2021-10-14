package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPageElementMapper {

    @FindBy(css = "#product_1_1_0_0 .product-name")
    public WebElement productNameCart;
}
