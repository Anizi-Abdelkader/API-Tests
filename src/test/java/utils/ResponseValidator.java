package utils;

import io.restassured.response.Response;
import org.junit.Assert;

import java.util.Iterator;
import java.util.Map;

public class ResponseValidator {

    //methode générique pour comparer la réponse par rapport à l'entrée pour n'importe quelle nombre d'entrée N
    public static boolean validateSameResponseBody(Response response, Map<String, String> data) {
        boolean isSame = true;
        Iterator<Map.Entry<String, String>> iterator = data.entrySet().iterator();
        while (iterator.hasNext() && isSame) {
            Map.Entry<String, String> mapentry = iterator.next();
            isSame = mapentry.getValue().equals(response.jsonPath().getString(mapentry.getKey()));
            Assert.assertEquals("Data problem", mapentry.getValue(), response.jsonPath().getString(mapentry.getKey()));
        }
        return isSame;
    }
}
