package StepDefinitions;

import Pages.FormContent;
import Pages.Parent;
import Utilities.GWD;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;

public class _07_EmployeeFormSteps extends Parent {

    FormContent fc = new FormContent();
    @And("User sending the keys in Form Content")
    public void userSendingTheKeysInFormContent(DataTable elements) {

        List<List<String>> listElements = elements.asLists(String.class);

        for (int i = 0; i < listElements.size(); i++) {
            fc.findAndSend(listElements.get(i).get(0), listElements.get(i).get(1));



        }
    }

    @And("User press ENTER Key")
    public void userPressENTERKey() throws InterruptedException {

        new Actions(GWD.getDriver()).sendKeys(Keys.ENTER).perform();
    }

    @And("Choose a country")
    public void chooseACountry() throws AWTException {
        fc.findAndSend("country","Turkey");
        fc.findAndWait("country");
        new Actions(GWD.getDriver()).sendKeys(Keys.ENTER).perform();



    }
}
