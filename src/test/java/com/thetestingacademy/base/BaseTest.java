package com.thetestingacademy.base;

import com.thetestingacademy.actions.AssertActions;
import com.thetestingacademy.endpoints.APIConstants;
import com.thetestingacademy.modules.PayloadManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    //Base Test is a single inheritance
    public RequestSpecification requestSpecification;
    public AssertActions assertActions;
    public PayloadManager payloadManager;
    public JsonPath jsonPath;
    public Response response;
    public ValidatableResponse validatableResponse;


    @BeforeMethod
    public void setConfig()  // which will run first assigning all the references whatever the value are ...
    {
        System.out.println("Before test");
        payloadManager = new PayloadManager();
        assertActions = new AssertActions();
        requestSpecification = new RequestSpecBuilder().setBaseUri(APIConstants.BASE_URL)//RequestSpecBuilder is a builder class is same as requestSpecification.
                .addHeader("Content-Type", "application/json")
                .build().log().all();

           /* requestSpecification= RestAssured
                .given()
                .baseUri(APIConstants.BASE_URL)
                .contentType(ContentType.JSON)
                .log().all();*/


    }
}
