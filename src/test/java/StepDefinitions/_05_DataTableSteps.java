package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import Utilities.GWD;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class _05_DataTableSteps {

    LeftNav ln = new LeftNav();
    DialogContent dc = new DialogContent();
    @And("Click on the element in left nav")
    public void clickOnTheElementInLeftNav(DataTable elements) {

        List<String> listElements = elements.asList(String.class);

        for (String strButtonName : listElements){
        ln.findAndClick(strButtonName);
        }

    }

    @And("Click on the element in the Dialog")
    public void clickOnTheElementInTheDialog(DataTable elements) {

        List<String> listElements = elements.asList(String.class);

        for (String strButtonName : listElements)
            dc.findAndClick(strButtonName);

    }

    @And("User sending the keys in Dialog Content")
    public void userSendingTheKeysInDialogContent(DataTable elements) {

        List<List<String>> listElements = elements.asLists(String.class);

        for (int i = 0; i < listElements.size(); i++) {
            dc.findAndSend(listElements.get(i).get(0),listElements.get(i).get(1));
                                // elemanın adı             // elemanın değeri

        }
        //new Actions(GWD.getDriver()).sendKeys(Keys.TAB).perform();
    }

    @And("User delete item from Dialog")
    public void userDeleteItemFromDialog(DataTable elements) {

        List<String> listElements = elements.asList(String.class);

        for (String strButtonName : listElements)
            dc.findAndDelete(strButtonName);

    }
}
