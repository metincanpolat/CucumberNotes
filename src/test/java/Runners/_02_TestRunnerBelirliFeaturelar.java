package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/test/java/FeatureFiles/_01_Login.feature",
                "src/test/java/StepDefinitions/_02_CountrySteps.java"},
        glue = {"StepDefinitions"},
        dryRun = false // true olduğunda testi çalıştırmaz sadece feature lara
                      // ait steplerin varlığını kontrol eder.
                      // false olduğunda ise testi çalıştırır.



)
public class _02_TestRunnerBelirliFeaturelar extends AbstractTestNGCucumberTests {
}
