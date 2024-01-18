package co.com.devsu.project.task.e2e;

import com.github.javafaker.Faker;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Step;

import java.util.Locale;
import java.util.Random;

import static co.com.devsu.project.ui.checkoutYourInformation.YourInformationUI.*;

public class YourInformationTask implements Task {

    private static Faker faker = Faker.instance(new Locale("es", "CO"), new Random());

    @Override
    @Step("{0} ingresa el nombre, apellido y codigo postal aletorios")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Ensure.that(INPUT_FIRS_NAME).isDisplayed(),
                Enter.theValue(faker.name().firstName()).into(INPUT_FIRS_NAME),
                Enter.theValue(faker.name().lastName()).into(INPUT_LAST_NAME),
                Enter.theValue(faker.address().zipCode()).into(INPUT_ZIP_POSTAL_CODE),
                Click.on(BUTTON_CONTINUE)
        );
    }

    public static YourInformationTask personal() {
        return Tasks.instrumented(YourInformationTask.class);
    }
}