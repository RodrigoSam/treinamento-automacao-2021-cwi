package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoryPageElementMapper {

    @FindBy(className = "cat-name")
    public WebElement nameCategoryTShirts;

    @FindBy (css = ".product-container")
    //(xpath = "/html/body/div/div[2]/div/div[3]/div[2]/ul/li/div/div[2]/h5/a")
    public WebElement product;

    @FindBy(css = ".button[title=View]")
    public WebElement buttonMoreAddToProductPage;

    @FindBy(css = ".product_list .product-name")
    public WebElement productNameCategory;


}

