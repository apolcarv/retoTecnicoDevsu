package co.com.devsu.project.task.e2e;

import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;

import java.util.Base64;

import static co.com.devsu.project.helpers.Constant.*;
import static co.com.devsu.project.ui.login.LoginUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class LoginTask implements Task {

    private static EnvironmentVariables environmentVariables;

    @Override
    @Step("{0} obtiene el usuario y contraseña codificado" +
            " y recrea logica para decodificarlo y se autentica exitosamente")
    public <T extends Actor> void performAs(T actor) {
        String user = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(USER_NAME);
        String pwd = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(PWD);

        actor.attemptsTo(
                WaitUntil.the(INPUT_USER_NAME, isVisible())
                        .forNoMoreThan(TIME_SHORT).seconds(),
                Enter.theValue(decode(user)).into(INPUT_USER_NAME),
                Enter.theValue(decode(pwd)).into(INPUT_PASSWORD),
                Click.on(BUTTON_LOGIN));
    }

    public static LoginTask submit() {
        return Tasks.instrumented(LoginTask.class);
    }

    public static String decode(String texto) {
        return new String(Base64.getDecoder().decode(texto));
    }
}