package steps;

import cucumber.ScenarioContextAPI;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.Matchers;

public class DemoAPISteps {

    private final ScenarioContextAPI context;

    public DemoAPISteps (){
        context = new ScenarioContextAPI();
    }

    @When("^I make a GET call on ([^\"]*)$")
    public void iMakeAGETCallOn(String path) {
        context.invokeHttpGet(path);
    }

    @When("^I make a POST call on ([^\"]*)$")
    public void iMakeAPOSTCallOn(String path) {
        context.invokeHttpPost(path, context.postBody);
    }

    @Then("^I should receive (\\d+) response status code$")
    public void iShouldReceiveStatusCodeResponse(int code) {
        context.response.then().statusCode(code);
    }

    @Then("^should receive a non-empty body$")
    public void shouldReceiveANonEmptyBody() {
        context.response.then().body(Matchers.notNullValue());
    }
}
