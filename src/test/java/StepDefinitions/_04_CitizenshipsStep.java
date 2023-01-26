package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class _04_CitizenshipsStep {

    LeftNav ln=new LeftNav();
    DialogContent dc=new DialogContent();
    @And("Navigate to CitizenShip page")
    public void navigateToCitizenShipPage() {
        ln.findAndClick("setupLeft");
        ln.findAndClick("parametersLeft");
        ln.findAndClick("citizenshipsLeft");


    }

    @When("User a CitizenShip name as {string} short name as {string}")
    public void userACitizenShipNameAsShortNameAs(String name, String shortName) {

        dc.findAndClick("plusIcon");
        dc.findAndSend("name",name);
        dc.findAndSend("shortName",shortName);
        dc.findAndClick("save");


    }

    @Then("Already exist message should be displayed")
    public void alreadyExistMessageShouldBeDisplayed() {
        dc.findAndContainsText("alreadyExist","already");
    }

    @When("User delete the {string}")
    public void userDeleteThe(String searchText) {
        dc.findAndDelete(searchText);

    }
}
