package co.com.devsu.project.ui.getProduct;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SelectProductUI extends PageObject {

    /*    Maping locator user interface PRODUCT   **/
    public static final Target TITLE_VIEW_PRODUCT = Target.the("valida que este la vista correcta")
            .located(By.xpath("//span[@class='title']"));

    public static final Target SELECT_PRODUCT = Target.the("selecciona un producto de forma aletoria")
            .locatedBy("//div[{0}]/div[2]/div[2]/button[contains(text(),'Add to cart')]");
    public static final Target ICON_BUTTON_CART = Target.the("pulsa el icono del carrito de compras")
            .located(By.xpath("//*[@id='shopping_cart_container']"));

}