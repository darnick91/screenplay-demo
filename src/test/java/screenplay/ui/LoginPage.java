package screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://www.saucedemo.com/")
public class LoginPage extends PageObject {

    public static final Target USERNAME = Target.the("Username")
            .locatedBy("//input[@id='user-name']");

    public static final Target PASSWORD = Target.the("Password")
            .locatedBy("//input[@id='password']");

    public static final Target LOGIN_BTN = Target.the("Login Button")
            .locatedBy("//input[@id='login-button']");
}
