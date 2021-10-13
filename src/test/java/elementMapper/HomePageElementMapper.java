package elementMapper;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageElementMapper {

    @FindBy(className = ("login"))
    public WebElement login;

    public WebElement search_query_top;

    public WebElement submit_search;

    @FindBy(linkText = "T-SHIRTS")
    //(css = "#block_top_menu ul > li:nth-child(3) a[title=T-shirts]")
    public WebElement menuTShirts;

}
