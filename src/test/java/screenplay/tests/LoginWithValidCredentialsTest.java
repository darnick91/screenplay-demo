package screenplay.tests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Managed;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import screenplay.questions.Dashboard;
import screenplay.tasks.LoginToSauce;
import screenplay.tasks.OpenTheLoginPage;


import static net.serenitybdd.screenplay.GivenWhenThen.*;

@RunWith(SerenityRunner.class)
public class LoginWithValidCredentialsTest {

    private final Actor user = new Actor("Bob");

    @Managed(driver = "chrome")
    protected WebDriver hisDriver;

    @BeforeEach
    public void userCanBrowsTheWeb() {
        user.can(BrowseTheWeb.with(hisDriver));
    }

    @Test
    public void loginToSauce() {
        givenThat(user).wasAbleTo(OpenTheLoginPage.loginPage());
        then(user).attemptsTo(LoginToSauce.withCredentials("standard_user", "secret_sauce"));
        Ensure.that(Dashboard.displayed()).isEqualToIgnoringCase("Products");
    }
}
