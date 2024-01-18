package co.com.devsu.project.task.e2e;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Step;

import static co.com.devsu.project.ui.checkoutoverview.OverView.BUTTON_FINISH;
import static co.com.devsu.project.ui.checkoutoverview.OverView.TXT_SUB_TOTAL;

public class OverViewTask implements Task {
    @Override
    @Step("{0} valida que se encuentre en la vista que overview" +
            "y finaliza el proceso de compra")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Ensure.that(TXT_SUB_TOTAL).isDisplayed(),
                Scroll.to(BUTTON_FINISH),
                Click.on(BUTTON_FINISH)
        );
    }

    public static OverViewTask informationProduct() {
        return Tasks.instrumented(OverViewTask.class);
    }
}