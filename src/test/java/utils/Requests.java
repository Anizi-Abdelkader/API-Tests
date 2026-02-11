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
    public static Response post(HashMap<String, String> dataToAdd) throws IOException, ParseException {

        Object obj = loadPayload(dataToAdd);
        System.out.println("ready to post the object" + obj);
        Map<String,Object> headerMap = new HashMap<String,Object>();
        headerMap.put("X-Origin-Brand","EP");
        headerMap.put("X-Requestor-Channel","TESTAUTO");
        headerMap.put("X-Requestor-Screen","e2e");
        return RestAssured.given().headers(headerMap).contentType(JSON)
                .accept(JSON).
                body(obj)
                .when().post()
                .then().assertThat().extract().response();
    }
}
