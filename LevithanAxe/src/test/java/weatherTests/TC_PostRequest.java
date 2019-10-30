package weatherTests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import jdk.nashorn.api.scripting.JSObject;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Test;

public class TC_PostRequest {

    @Test
    public void changeWeather()
    {
        RestAssured.baseURI="http://restapi.demoqa.com/customer";

        //Request Object
        RequestSpecification httpRequest = RestAssured.given();

        //Create a JSON object for request payload
        JSONObject requestParams = new JSONObject();
        requestParams.put("FirstName","bala");
        requestParams.put("LastName","krish");
        requestParams.put("UserName","UsernameXYZ");
        requestParams.put("Password","Joxyx");
        requestParams.put("Email","balakrish@gmail.com");

        //Converting JSON object to JSON string to attach to request body
        httpRequest.body(requestParams.toJSONString());

        //Setting the header for request
        httpRequest.header("Content-Type","application/json");

        //Response Object
        Response response = httpRequest.request(Method.POST,"/register");

        //Printing the response
        System.out.println("POST Details are : " + response.getBody().asString());

        //Print Status code and Line
        int statusCode = response.getStatusCode();
        String statusLine = response.getStatusLine();
        System.out.println("The Status code is : " + statusCode);
        System.out.println("The Status line is : " + statusLine);

        //Assert status code and line
        Assert.assertEquals("The status code is incorrect",statusCode,200);
        Assert.assertEquals("The status line is incorrect",statusLine,"HTTP/1.1 200 OK");

    }
}
