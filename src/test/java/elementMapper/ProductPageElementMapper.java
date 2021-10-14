package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPageElementMapper {

    @FindBy(css = "h1[itemprop]")
    public WebElement productNamePdp;
}
