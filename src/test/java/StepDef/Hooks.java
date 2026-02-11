package StepDef;


import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import utils.ConfigReader;


public class Hooks {

    @BeforeAll
    public static void beforeAll() {
        RestAssured.baseURI = ConfigReader.getBaseUrl();
        RestAssured.basePath = ConfigReader.getBasePath();
    }


    @AfterAll
    public static void afterAll() {

    }

}
