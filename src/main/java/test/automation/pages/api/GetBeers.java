package test.automation.pages.api;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import test.automation.data.api.Beers;
import test.automation.properties.ConfigProperties;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

@Component("test.automation.pages.api.GetMethod")
public class GetBeers {
    @Autowired
    ConfigProperties configProperties;

    private Response response;

    public Map<String, Object> dataParameter() {
        Map<String, Object> payload = new HashMap<>();

        payload.put("page", Beers.getPage());
        payload.put("per_page", Beers.getDataPerPage());

        payload.values().removeAll(Collections.singleton(null));
        return payload;
    }

    public void sendGetBeersHttpRequestWithParam() throws URISyntaxException {
        RestAssured.baseURI = configProperties.getApi().getBaseUri();
        RequestSpecification requestSpecification = RestAssured.given();
        response = requestSpecification.when().queryParams(dataParameter()).get(new URI("v2/beers"));
    }

    public void validateStatusCodeEqualWith(int statusCode) {
        Assert.assertEquals(statusCode, response.then().extract().statusCode());
    }

    public void validateDataPerPageEqualWith(int number) {
        JsonPath jsonPath = new JsonPath(response.asString());

        int actualDataPage = jsonPath.getInt("data.size()");
        Assert.assertEquals(number, actualDataPage);
    }

    public void sendGetBeersHttpRequest() throws URISyntaxException {
        RestAssured.baseURI = configProperties.getApi().getBaseUri();
        RequestSpecification requestSpecification = RestAssured.given();
        response = requestSpecification.when().get(new URI("v2/beers"));
    }

    public void validateJsonSchema() {
        File schema = new File(System.getProperty("user.dir") + "/src/main/java/test/automation/data/schema/GetBeersJsonSchema.json");
        response.then().assertThat().body(matchesJsonSchema(schema));
    }

    public void getNameFromResponse() {
        ArrayList listName = response.then().extract().path("name");
        for (Object name : listName) {
            System.out.println("nama : " + name);
        }
    }
}
