package cucumber;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ScenarioContextAPI {
    private String path;
    public Response response;

    private ScenarioReport report;

    public Map<String, Object> postBody = new HashMap<>();
    public Map<String, Object> queryParams = new HashMap<>();

    public ScenarioContextAPI() {
        reset();
    }

    private void reset() {
        report = new ScenarioReport();
        response = null;
        path = null;
        postBody.clear();
        queryParams.clear();
    }

    public static void setupURL(String url) {
        RestAssured.baseURI = url;
    }

    public void invokeHttpGet(String path, Object... pathParams) {
        response = given()
                .contentType(ContentType.JSON)
                .when()
                .get(path, pathParams)
                .then()
                .extract().response();
    }

    public void invokeHttpPost(String path, Map<String, ?> data) {
        response = given().log().all()
                .body(data)
                .queryParams(queryParams)
                .contentType(ContentType.JSON)
                .post(path)
                .then()
                .extract()
                .response();
    }

    public ScenarioReport getReport() {
        return report;
    }

}
