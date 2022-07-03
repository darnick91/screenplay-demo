package screenplay.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import screenplay.ui.InventoryPage;

public class Dashboard implements Question<String> {

    public static Question<String> displayed() {
        return new Dashboard();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(InventoryPage.TITLE_PRODUCTS).answeredBy(actor);
    }
}
