package co.com.devsu.project.ui.checkoutyourinformation;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class YourInformationUI extends PageObject {

    /*    Maping locator user interface CHECKOUT: YOUR-INFORMATION   **/
    public static final Target INPUT_FIRS_NAME = Target.the("ingresa el primer nombre")
            .located(By.id("first-name"));

    public static final Target INPUT_LAST_NAME = Target.the("ingresa los apellidos")
            .located(By.id("last-name"));

    public static final Target INPUT_ZIP_POSTAL_CODE = Target.the("ingresa el codigo postal")
            .located(By.id("postal-code"));

    public static final Target BUTTON_CONTINUE= Target.the("pulsa el boton continuar")
            .located(By.id("continue"));

}