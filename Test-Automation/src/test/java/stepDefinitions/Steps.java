package stepDefinitions;

import cucumber.api.java.en.Given;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

public class Steps {
    private static Response response;

    private static final String USERNAME = "TOOLSQA-Test";
    private static final String PASSWORD = "Test@@123";
    @Given("User is able to trigger the API and check the status code")

    public void triggerApiAndCheckStatus() {
        RestAssured.baseURI = "https://bookstore.toolsqa.com";
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        response = request.body("{ \"userName\":\"" + USERNAME + "\", \"password\":\"" + PASSWORD + "\"}").post("/Account/v1/GenerateToken");
        String jsonString = response.asString();
        String token = JsonPath.from(jsonString).get("token");
        response = request.get("/BookStore/v1/Books");
        System.out.println("Response code : "+response.getStatusCode());
        Assert.assertEquals(response.getStatusCode(), 200);
    }
}