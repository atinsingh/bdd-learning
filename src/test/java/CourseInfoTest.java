import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import static org.hamcrest.Matchers.*;


public class CourseInfoTest {
    RestAssured restAssured;
    String url;
    ValidatableResponse response;
    @Given("User have access to API on url {string}")
    public void userHaveAccessToAPIOnUrl(String url) {
       this.url = url;
    }

    @When("user calls api with id {string}")
    public void user_calls_api_with_id(String id) {
        restAssured.given().when().get(url, id).prettyPrint();

        response = restAssured.given().when().get(url,id).then();

    }
    @Then("API should return status code {int}")
    public void api_should_return_status_code(Integer statusCode) {
        response.assertThat().statusCode(statusCode);
    }
    @Then("course code should match with {string}")
    public void course_code_should_match_with(String courseCode) {
        response.assertThat().body("courseCode", equalTo(courseCode));
    }

}
