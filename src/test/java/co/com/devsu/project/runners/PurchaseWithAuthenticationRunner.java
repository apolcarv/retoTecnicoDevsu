package co.com.devsu.project.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/purchaseWithAuthentication.feature",
        glue = "co.com.devsu.project.stepdefinition",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        plugin = "pretty",
        tags = "@purchaseWithAuthenticationSuccess"
)
public class PurchaseWithAuthenticationRunner {
}
