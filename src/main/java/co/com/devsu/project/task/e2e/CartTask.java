package co.com.devsu.project.task.e2e;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Step;

import static co.com.devsu.project.ui.youCart.CartUI.BUTTON_CHECKOUT;
import static co.com.devsu.project.ui.youCart.CartUI.ICON_CART;
import static co.com.devsu.project.helpers.Constant.TWO;

public class CartTask implements Task {
    @Override
    @Step("{0} Valida la cantidad de productos y continua el proceso de compra")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Ensure.that(ICON_CART).isDisplayed(),
                Ensure.that(ICON_CART.resolveFor(actor).getText()).isEqualTo(String.valueOf(TWO)),
                Click.on(BUTTON_CHECKOUT)
        );
    }

    public static CartTask numberOfProduct() {
        return Tasks.instrumented(CartTask.class);
    }
}