package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class LoadJsonFileToObject {

    public static <T> T loadPayload(HashMap<String, String> dataToAdd) throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(new FileReader("src/test/resources/payload/payload.json"));
        for (Object o : dataToAdd.entrySet()) {
            HashMap.Entry mapEntry = (HashMap.Entry) o;
            jsonObject.put((String) mapEntry.getKey(), mapEntry.getValue());
        }
        return (T) jsonObject;
    }
}
