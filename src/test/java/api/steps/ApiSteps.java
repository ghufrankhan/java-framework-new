package api.steps;

import config.ConfigLoader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.equalTo;

public class ApiSteps {
    private final String baseUrl;
    private Response response;

    public ApiSteps() {
        this.baseUrl = ConfigLoader.getApiBaseUrl();
    }

    @Given("I send a GET request to the endpoint with the value {string}")
    public void i_send_a_get_request_to_the_endpoint_with_the_value(String value) {
        response = get(baseUrl + value);
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @And("the response body contains the name {string}")
    public void the_response_body_contains_the_name(String name) {
        response.then().body("name", equalTo(name));
    }

    @And("the response body contains the gender {string}")
    public void the_response_body_contains_the_gender(String genderString) {
        Object gender = "null".equals(genderString) ? null : genderString;
        response.then().body("gender", equalTo(gender));
    }
}