package pageObjects;

import elementMapper.HomePageElementMapper;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class HomePage extends HomePageElementMapper {

    public HomePage(){

        PageFactory.initElements(Browser.getCurrentDriver(),this);

    }
    @Step("clicou Sign in e direcionou para página de login ok")
    public void clickButtonLogin(){
        login.click();
    }

    public void clickSearchQueryTop(){
        search_query_top.click();
    }
// sendKeys usado para passar a string da busca

    public void sendKeysSearchQueryTop(String keys){
        search_query_top.sendKeys(keys);

    }
    public void clickSubmitSearch(){
        submit_search.click();
    }
    public void doSearch(String quest){

        clickSearchQueryTop();
        sendKeysSearchQueryTop(quest);
        clickSubmitSearch();
    }
    public void clickCategoryTShirts(){
        menuTShirts.click();

    }

}
