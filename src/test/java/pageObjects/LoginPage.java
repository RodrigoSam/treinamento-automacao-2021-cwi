package pageObjects;

import elementMapper.LoginPageElementMapper;
import org.openqa.selenium.support.PageFactory;
import utils.Browser;

public class LoginPage extends LoginPageElementMapper {

    public LoginPage() {

        PageFactory.initElements(Browser.getCurrentDriver(),this);

    }

    public void fillEmail(){
        email.sendKeys("carneiroteste@gmail.com");
    }

    public void fillPassword(){
        passwd.sendKeys("12345");
}

    public void clickbtnSubmitLogin(){
        submitLogin.click();

    }

}
