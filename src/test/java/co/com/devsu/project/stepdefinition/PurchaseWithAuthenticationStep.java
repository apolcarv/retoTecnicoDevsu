package co.com.devsu.project.stepdefinition;

import co.com.devsu.project.questions.e2e.ValidateTxtOrder;
import co.com.devsu.project.task.OpenWeb;
import co.com.devsu.project.task.e2e.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import org.hamcrest.Matchers;

import static co.com.devsu.project.helpers.Constant.ACTOR;
import static co.com.devsu.project.helpers.Constant.TITLE_WEBSITE;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

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
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(
                        TheWebPage.title(),
                        Matchers.containsString(TITLE_WEBSITE))
        );

        theActorCalled(ACTOR).attemptsTo(
                LoginTask.submit(),
                SelectProductTask.ofPreference(),
                CartTask.numberOfProduct(),
                YourInformationTask.personal(),
                OverViewTask.informationProduct()
        );
    }

    @Then("al finalizar obtiene una confirmación {string}")
    public void uponCompletionYouGetAConfirmation(String confirmText) {
        theActorInTheSpotlight().should(
                seeThat(ValidateTxtOrder.success(confirmText))
        );
    }
}