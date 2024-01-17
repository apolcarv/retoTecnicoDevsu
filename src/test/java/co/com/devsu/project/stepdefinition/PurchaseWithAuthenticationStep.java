package co.com.devsu.project.stepdefinition;

import co.com.devsu.project.task.OpenWeb;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

@Slf4j
public class PurchaseWithAuthenticationStep {

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("{string} desea realizar una compra por pagina web")
    public void youWantToMakeAPurchaseByWebPage(String actor) {
        OnStage.theActorCalled(actor).attemptsTo(OpenWeb.browserURL());
    }

    @When("realiza todo el proceso de compra")
    public void carryOutTheEntirePurchasingProcess() {
        log.info("hasta aqui vamos bien");
    }

    @Then("al finalizar obtiene una confirmación {string}")
    public void uponCompletionYouGetAConfirmation(String confirmText) {

    }
}