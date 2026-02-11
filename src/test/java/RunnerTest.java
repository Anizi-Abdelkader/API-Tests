import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(features = "src/test/resources/features",
        glue = {"StepDef"},
        plugin = {"pretty", "html:target/allure-results/allure.html",
                "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm", "json:target/cucumber-reports/Cucumber.json",
                "rerun:target/rerun.txt"})
public class RunnerCucumberTests {
}
