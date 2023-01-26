package StepDefinitions;

import Pages.DialogContent;
import Utilities.DBUtility;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class _11_JDBCSteps {
    @Then("Send the query the database {string} and control match")
    public void sendTheQueryTheDatabaseAndControlMatch(String sorgu) {

        // DB den gerekli listeyi alacağım
        ArrayList<ArrayList<String>> dbList = DBUtility.getListData(sorgu);
        System.out.println(dbList); // db kontrol

        // Webden ekrandaki listeyi alacağım
        DialogContent dc = new DialogContent();
        List<WebElement> uiList = dc.stateList;
        for (WebElement e : uiList)
            System.out.println(e.getText());

        // karşılaştırma
        for (int i = 0; i < dbList.size(); i++) {
            Assert.assertEquals(dbList.get(i).get(1),uiList.get(i).getText(),"Hatalı Eşleştirme");

        }
    }
}
