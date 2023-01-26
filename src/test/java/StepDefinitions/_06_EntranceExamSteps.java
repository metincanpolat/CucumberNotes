package StepDefinitions;

import Pages.DialogContent;
import Pages.FormContent;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;

import java.util.List;

public class _06_EntranceExamSteps {
    FormContent fc = new FormContent();

    @And("Click on the element in Form Content")
    public void clickOnTheElementInFormContent(DataTable elements) {
        List<String> listElements = elements.asList(String.class);

        for (String strButtonName : listElements)
            fc.findAndClick(strButtonName);


    }

}
