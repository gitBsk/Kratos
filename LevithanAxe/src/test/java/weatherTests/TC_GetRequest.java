package weatherTests;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

public class TC_GetRequest {

    @Test
    public void getWeather()
    {
        RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city/";

        //Request Object
        RequestSpecification httpRequest = RestAssured.given();

        //Response Object
        Response response = httpRequest.request(Method.GET,"/Bangalore");

        //Printing the response
        System.out.println("Weather Details are : " + response.getBody().asString());

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
