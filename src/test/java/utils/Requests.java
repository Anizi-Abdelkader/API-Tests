package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.http.ContentType.JSON;
import static utils.LoadJsonFileToObject.loadPayload;

public class Requests {

    // cette methode pour faire le Post de l'objet construit par la méthode LoadPayload
    public static Response post(HashMap<String, String> dataToAdd) throws IOException, ParseException {

        Object obj = loadPayload(dataToAdd);
        System.out.println("ready to post the object" + obj);
        Map<String,Object> headerMap = new HashMap<String,Object>();
        return RestAssured.given().headers(headerMap).contentType(JSON)
                .accept(JSON).
                body(obj)
                .when().post()
                .then().assertThat().extract().response();
    }
}
