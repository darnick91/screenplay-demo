package screenplay.tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;
import screenplay.ui.LoginPage;

public class LoginToSauce implements Task {

    private final String username;
    private final String password;

    public LoginToSauce(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Step("{0} enter username and password '#username' '#password'")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(username).into(LoginPage.USERNAME).thenHit(Keys.TAB));
        actor.attemptsTo(Enter.theValue(password).into(LoginPage.PASSWORD).thenHit(Keys.TAB));
        actor.attemptsTo(Click.on(LoginPage.LOGIN_BTN));
    }

    public static Task withCredentials(String username, String password) {
        return Instrumented
                .instanceOf(LoginToSauce.class)
                .withProperties(username, password);
    }
}
