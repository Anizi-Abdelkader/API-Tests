package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.json.simple.parser.ParseException;
import org.junit.Assert;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static utils.Requests.post;
import static utils.ResponseValidator.validateSameResponseBody;

public class testSteps {
    HashMap<String, String> dataToAdd = new HashMap<>();
    Response response;


    @Given("The user has their username and password")
    public void theUserHasTheirUsernameAndPassword(Map<String, String> data) {
        dataToAdd.putAll(data);
    }


    @When("The user the user logs in")
    public void theUserLogsIn() throws IOException, ParseException {
        response = post(dataToAdd);
    }

    @Then("The status code is {int}")
    public void theStatusCodeIs(int statusCode) {
        Assert.assertEquals("Problem with Status code ", statusCode, response.statusCode());
    }

    @And("This response was returned")
    public void thisResponseWasReturned(Map<String, String> data) {
        Assert.assertTrue("The data is not the same", validateSameResponseBody(response, data));
    }
}
