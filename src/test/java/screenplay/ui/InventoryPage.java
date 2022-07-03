package screenplay.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.pages.PageObject;

public class InventoryPage extends PageObject {

    public static final Target TITLE_PRODUCTS = Target.the("Products")
            .locatedBy("div span.title");
}


