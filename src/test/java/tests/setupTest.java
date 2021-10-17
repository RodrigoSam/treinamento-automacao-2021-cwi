package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.Test;
import org.openqa.selenium.By;
import pageObjects.*;
import utils.Browser;
import utils.Utils;

import static org.junit.Assert.*;
@Feature("Testes site de e-commerce")
public class setupTest extends baseTests {

    @Test
    @Story("Abrir o site")
    public void testOpeningBrowserAndLoadingPage(){
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl()));
        System.out.println("Abrimos o navegador e carregamos a Url com sucesso");
    }

    @Test
    @Story("Realizar o login")
    public void testLogin(){
//Iniciar teste
        HomePage home = new HomePage();
        LoginPage login = new LoginPage();

        home.clickButtonLogin();
        System.out.println("clicou Sign in e direcionou para página de login ok");
        assertTrue(Browser.getCurrentDriver().getCurrentUrl()
        .contains(Utils.getBaseUrl().concat("index.php?controller=authentication&back=my-account")));
        System.out.println("validação da página authentication ok");

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
    @Story("Fazer uma busca")
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
    @Story("Acessar categoria")
    public void testAccessCategoryTShirts(){
        //iniciar as páginas

        HomePage home = new HomePage();
        CategoryPage category = new CategoryPage();

        //clicar na categoria T-Shirts

        home.clickCategoryTShirts();
        System.out.println("clicar na categoria T-shirts ok");

        //Validar se ao clicar na categoria T-Shirts ocorre o direcionamento correto
        assertTrue(category.isPageTShirts());
        System.out.println("validou a pagina T-Shirts ok");


    }

    @Test
    @Story("Acessar página de produto")
    public void testAddProductToProductPage(){
        //Iniciar as páginas
        CategoryPage category = new CategoryPage();
        ProductPage pdp = new ProductPage();

        //Salva nome do produto na página de categoria
        String nameProductCategory = category.getProductNameCategory();

        //Acessa a categoria T-shirts
        testAccessCategoryTShirts();

        //Clicar em More e direcionar para página do produto
        category.clickProductAddToProductPage();
        System.out.println("Clicar no botão More ok");

        // category.clickTheShort();
        System.out.println("clicar no produto ok");

        //Verificar se o produto está na página de detalhes do produto
        assertEquals(pdp.getProductNamePdp(), nameProductCategory);
        System.out.println("verificar se o produto está na página ok");
    }

    @Test
    @Story("Adicionar produto carrinho")
    public void testAddProductToCartPage(){
        //Acessa a página do produto
        testAddProductToProductPage();

        //Iniciar as páginas
        ProductPage pdp = new ProductPage();
        String nameProductPDP = pdp.getProductNamePdp();
        CartPage cart = new CartPage();

        //Clicar no botão add to cart da página de produto

        pdp.clickButtonAddToCart();
        System.out.println("clicar no botão de adicionar ao carro ok");

        //Clicar no botão Proceed To Checkout no modal

        pdp.clickButtonModalProceedToCheckout();
        System.out.println("clicar no botão checkout ok");

        //Validação do nome do produto no carrinho
        assertEquals(cart.getNameProductCart(), nameProductPDP);
        System.out.println("Produto no carrrinho ok");

    }

}
