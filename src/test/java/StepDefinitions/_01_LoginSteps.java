package StepDefinitions;

import Pages.DialogContent;
import Pages.Parent;
import Utilities.GWD;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class _01_LoginSteps extends Parent {

    DialogContent dc=new DialogContent();


    @Given("Navigate to Campus")
    public void navigateToCampus() {

        GWD.getDriver().get("https://test.mersys.io/");
        GWD.getDriver().manage().window().maximize();
    }

    @When("Enter username and password and click Login button")
    public void enterUsernameAndPasswordAndClickLoginButton() {
//        WebDriverWait waitAWhile=new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
//        waitAWhile.until(ExpectedConditions.visibilityOf(dc.loginButton));
//        dc.userName.sendKeys("richfield.edu");
//        dc.password.sendKeys("Richfield2020!");
//        dc.loginButton.click();
        dc.findAndSend("username","turkeyts");
        dc.findAndSend("password","TechnoStudy123");
        dc.findAndClick("loginButton");
        dc.findAndClick("cookieAccept");

    }

    @Then("User should login successfully")
    public void userShouldLoginSuccessfully() {

        dc.findAndContainsText("txtTechnoStudy","Techno Study");


    }

}
