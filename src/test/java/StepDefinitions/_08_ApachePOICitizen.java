package StepDefinitions;

import Pages.DialogContent;
import Utilities.ExcelUtility;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.ArrayList;

public class _08_ApachePOICitizen {
    DialogContent dc=new DialogContent();
    @When("User Create citizenship with excel")
    public void userCreateCitizenshipWithExcel() {
        // excelden oku ve citizenship leri create et
        ArrayList<ArrayList<String>> tablo =
        ExcelUtility.getListData("src/test/java/ApachePOI/resource/ApacheExcel2.xlsx","testCitizen",2);

        for (ArrayList<String> satir : tablo) {
            dc.findAndClick("plusIcon");
            dc.findAndSend("name", satir.get(0));
            dc.findAndSend("shortName", satir.get(1));
            dc.findAndClick("save");
            dc.findAndContainsText("successText", "success");
        }
    }

    @Then("User Delete citizenship with ApachePOI")
    public void userDeleteCitizenshipWithApachePOI() {
        // excelden oku ve citizenship leri create et
        ArrayList<ArrayList<String>> tablo =
                ExcelUtility.getListData("src/test/java/ApachePOI/resource/ApacheExcel2.xlsx","testCitizen",1);

        for (ArrayList<String> satir : tablo) {
            dc.findAndDelete(satir.get(0));
            dc.findAndContainsText("successText", "success");
        }
    }
}
