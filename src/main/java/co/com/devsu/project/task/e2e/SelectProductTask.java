package co.com.devsu.project.task.e2e;

import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Step;

import static co.com.devsu.project.helpers.Constant.ONE;
import static co.com.devsu.project.helpers.Constant.SIX;
import static co.com.devsu.project.helpers.DataFaker.fakerNumberOneAndSix;
import static co.com.devsu.project.ui.getProduct.SelectProductUI.*;

@Slf4j
public class SelectProductTask implements Task {

    @Override
    @Step("{0} Valida que se encuentre en la pagina correspondiente cart product" +
            "y crea algoritmo para seleccionar dos productos sin repetir el producto")
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Ensure.that(TITLE_VIEW_PRODUCT).isDisplayed());

        String selectProductOne = fakerNumberOneAndSix();
        String selectProductTwo = fakerNumberOneAndSix();

        // Verificar y actualizar los números hasta que sean distintos
        while (selectProductOne.equals(selectProductTwo)) {
            // Incrementar el segundo número y ajustarlo si supera 6
            int incrementedNumber = Integer.parseInt(selectProductTwo) + ONE;
            if (incrementedNumber > SIX) {
                incrementedNumber = ONE;
            }
            selectProductTwo = String.valueOf(incrementedNumber);

            log.info("Los números son iguales. Actualizando número 2: " + selectProductTwo);
        }
        // Números finales
        log.info("Números finales:");
        log.info("Número 1: " + selectProductOne);
        log.info("Número 2: " + selectProductTwo);


        actor.attemptsTo(
                Click.on(SELECT_PRODUCT.of(selectProductOne)),
                Click.on(SELECT_PRODUCT.of(selectProductTwo)),
                Click.on(ICON_BUTTON_CART)
        );
    }

    public static SelectProductTask ofPreference() {
        return Tasks.instrumented(SelectProductTask.class);
    }
}