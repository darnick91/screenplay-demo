package screenplay.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;
import screenplay.ui.LoginPage;

import static net.serenitybdd.screenplay.Tasks.instrumented;


public class OpenTheLoginPage implements Task {

    public static OpenTheLoginPage loginPage() {
        return instrumented(OpenTheLoginPage.class);
    }

    LoginPage loginPage;

    @Step("{0} access Login page")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.browserOn().the(loginPage));
    }
}
