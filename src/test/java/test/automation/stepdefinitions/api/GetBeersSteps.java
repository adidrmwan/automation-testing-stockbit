package test.automation.stepdefinitions.api;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import test.automation.data.api.Beers;
import test.automation.pages.api.GetBeers;

import java.net.URISyntaxException;

public class GetBeersSteps {
    @Autowired
    GetBeers getBeers;

    @Given("user prepare data for the parameter of per page {string}")
    public void userPrepareTheParameterOfData(String number) {
        Beers.setPage("2");
        Beers.setDataPerPage(number);
    }

    @When("user send get beers HTTP request with param")
    public void userSendGetBeersHTTPRequestWithParam() throws URISyntaxException {
        getBeers.sendGetBeersHttpRequestWithParam();
    }

    @Then("user validate response status code {int} from get beers")
    public void userReceiveValidHTTPResponseCode(int statusCode) {
        getBeers.validateStatusCodeEqualWith(statusCode);
    }


    @And("user validate the data per page is {int}")
    public void userValidateTheDataPerPageIsNumber(int number) {
        getBeers.validateDataPerPageEqualWith(number);
    }

    @Given("user send get beers HTTP request")
    public void userSendGetBeersHTTPRequest() throws URISyntaxException {
        getBeers.sendGetBeersHttpRequest();
    }

    @And("user validate the response of get beers with json schema")
    public void userValidateTheResponseOfGetBeersWithJsonSchema() {
        getBeers.validateJsonSchema();
    }

    @And("user see list of name in response of get beers")
    public void userSeeListOfNameInResponseOfGetBeers() {
        getBeers.getNameFromResponse();
    }
}
