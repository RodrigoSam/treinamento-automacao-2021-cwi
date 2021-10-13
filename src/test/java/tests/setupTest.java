package tests;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import pageObjects.CategoryPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SearchPage;
import utils.Browser;
import utils.Utils;

import java.math.MathContext;
import java.sql.SQLOutput;

import static org.junit.Assert.*;

public class setupTest extends baseTests {

    @Test
    public void testOpeningBrowserAndloadingPage(){
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl()));
        System.out.println("Abrimos o navegador e carregamos a Url com sucesso");
    }

    @Test

    public void testLogin(){
//Iniciar teste
        HomePage home = new HomePage();
        LoginPage login = new LoginPage();

        home.clickButonlogin();
        System.out.println("clicou Sign in e direcionou para página de login ok");
        assertTrue(Browser.getCurrentDriver().getCurrentUrl()
        .contains(Utils.getBaseUrl().concat("index.php?controller=authentication&back=my-account")));
        System.out.println("validaçao da página authenticantion ok");


        login.fillEmail();
        System.out.println("Preenchimento campo e-mail Ok");

        login.fillPassword();
        System.out.println("Preenchimento campo password ok");

        login.clickbtnSubmitLogin();
        System.out.println("Clicar no botão Sign in ok");

        assertTrue(Browser.getCurrentDriver().getCurrentUrl()
        .contains(Utils.getBaseUrl().concat("index.php?controller=my-account")));
        System.out.println("Validação da página my account ok");

        assertTrue(Browser.getCurrentDriver()
        .findElement(By.className("page-heading")).getText().contains("MY ACCOUNT"));
        System.out.println("Validação conta no site ok");


    }

    @Test
    public void testSearch(){
        String quest = "DRESS";
        String questResultQtd = "7 results have been found.";


        //Iniciar as páginas
        HomePage home = new HomePage();
        SearchPage search = new SearchPage();

        //Fazer a pesquisa
        home.doSearch(quest);
        System.out.println("Busca ok");

        //Validar a pesquisa
        assertTrue(search.isSearchPage());
        assertEquals(search.getTextLighter().replace("\"",""),quest);
        assertEquals(search.getTextHeadingCounter(),questResultQtd);
        System.out.println("Validação ok");

    }

    @Test
    public void testAcessCategoryTShirts(){
        //iniciar as páginas

        HomePage home = new HomePage();
        CategoryPage category = new CategoryPage();

        //clicar na categoria T-Shirts

        home.clickCategoryTShirts();
        System.out.println("clicar na categoria T-shirts ok");

        //Validar se ao clicar na categoria T-Shirts ocorre o direcionamento correto
        assertTrue(category.isPageTshirts());
        System.out.println("validou a pagina T-Shirts ok");

    }

}
