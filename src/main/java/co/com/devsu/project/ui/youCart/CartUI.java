package co.com.devsu.project.ui.youCart;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CartUI extends PageObject {

    /*    Maping locator user interface YOU-CART   **/
    public static final Target ICON_CART = Target.the("valida la cantidad de productos")
            .located(By.xpath("//*[@class='shopping_cart_badge' and contains(text(),'2')]"));

    public static final Target BUTTON_CHECKOUT = Target.the("pulsa el icono del carrito de compras")
            .located(By.id("checkout"));

}