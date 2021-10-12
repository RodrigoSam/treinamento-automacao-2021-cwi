package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import utils.Browser;
import utils.Utils;

import java.sql.SQLOutput;

import static org.junit.Assert.assertTrue;

public class setupTest extends baseTests {

    @Test
    public void testOpeningBrowserAndloadingPage(){
        assertTrue(Browser.getCurrentDriver().getCurrentUrl().contains(Utils.getBaseUrl()));
        System.out.println("Abrimos o navegador e carregamos a Url com sucesso");
    }

    @Test

    public void testLogin(){
        Browser.getCurrentDriver().findElement(By.className("login")).click();
        System.out.println("clicou Sign in e direcionou para página de login ok");
        assertTrue(Browser.getCurrentDriver().getCurrentUrl()
        .contains(Utils.getBaseUrl().concat("index.php?controller=authentication&back=my-account")));
        System.out.println("validaçao da página authenticantion ok");
        Browser.getCurrentDriver().findElement(By.id("email")).sendKeys("carneiroteste@gmail.com");
        System.out.println("Preenchimento campo e-mail Ok");
        Browser.getCurrentDriver().findElement(By.name("passwd")).sendKeys("12345");
        System.out.println("Preenchimento campo password ok");
        Browser.getCurrentDriver().findElement(By.id("SubmitLogin")).click();
        System.out.println("Clicar no botão Sign in ok");
        assertTrue(Browser.getCurrentDriver().getCurrentUrl()
        .contains(Utils.getBaseUrl().concat("index.php?controller=my-account")));
        System.out.println("Validação da página my account ok");
        assertTrue(Browser.getCurrentDriver()
        .findElement(By.className("page-heading")).getText().contains("MY ACCOUNT"));
        System.out.println("Validação conta no site ok");

    }
}
