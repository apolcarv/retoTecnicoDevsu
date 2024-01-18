package co.com.devsu.project.ui.login;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginUI extends PageObject {

    /*    Maping locator user interface LOGIN   **/
    public static final Target INPUT_USER_NAME = Target.the("ingresa el nombre de usuario")
            .located(By.id("user-name"));

    public static final Target INPUT_PASSWORD = Target.the("ingresa la contraseña")
            .located(By.id("password"));

    public static final Target BUTTON_LOGIN = Target.the("pulsa el boton login")
            .located(By.id("login-button"));
}
