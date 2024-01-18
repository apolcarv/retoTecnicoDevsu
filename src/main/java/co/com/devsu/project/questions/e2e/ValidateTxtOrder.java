package co.com.devsu.project.questions.e2e;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.thucydides.core.annotations.Step;

import static co.com.devsu.project.ui.checkoutOverview.OverView.TXT_MESSAGE_VALIDATE_ORDER;

@AllArgsConstructor
@Slf4j
public class ValidateTxtOrder implements Question<Boolean> {

    private final String confirmText;

    @Override
    @Step("{0} valida el texto #confirmText")
    public Boolean answeredBy(Actor actor) {
        boolean result;
        String txtValidate = TXT_MESSAGE_VALIDATE_ORDER.resolveFor(actor).getText();
        if (txtValidate != null && confirmText != null && txtValidate.equals(confirmText)) {
            log.info(txtValidate);
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    public static ValidateTxtOrder success(String confirmText) {
        return new ValidateTxtOrder(confirmText);
    }
}