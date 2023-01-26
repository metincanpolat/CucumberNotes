package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;

public class _02_CountrySteps {
    LeftNav ln=new LeftNav();
    DialogContent dc=new DialogContent();

    @And("Navigate to country page")
    public void navigateToCountryPage() {
        ln.findAndClick("setupLeft");
        ln.findAndClick("parametersLeft");
        ln.findAndClick("countriesLeft");
    }

    @When("Create a country")
    public void createACountry() {
        String randomGenName= RandomStringUtils.randomAlphanumeric(8);
        String randomGenCode= RandomStringUtils.randomNumeric(4);

        dc.findAndClick("plusIcon");
        dc.findAndSend("name",randomGenName);
        dc.findAndSend("code",randomGenCode);
        dc.findAndClick("save");

    }

    @Then("Success message should be displayed")
    public void SuccessMessageShouldBeDisplayed() {
        dc.findAndContainsText("successText","success");
    }

    @When("Create a country name as {string} code as {string}")
    public void createACountryNameAsCodeAs(String name, String code) {
        dc.findAndClick("plusIcon");
        dc.findAndSend("name",name);
        dc.findAndSend("code",code);
        dc.findAndClick("save");
    }
}
