package co.com.devsu.project.ui.checkoutoverview;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class OverView extends PageObject {

    /*    Maping locator user interface CHECKOUT: OVERVIEW - COMPLETE   **/

    public static final Target TXT_SUB_TOTAL = Target.the("valida que se encuentre dentro de la pagina")
            .located(By.xpath("//*[@id='checkout_summary_container']/div/div[2]/div[5]"));
    public static final Target BUTTON_FINISH = Target.the("selecciona boton finalizar")
            .located(By.id("finish"));

    public static final Target TXT_MESSAGE_VALIDATE_ORDER = Target.the("obtiene el mensaje (gracias por su orden)")
            .located(By.xpath("//*[@id='checkout_complete_container']/h2"));
}