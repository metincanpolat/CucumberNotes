package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftNav extends Parent{

    public LeftNav() {
        PageFactory.initElements(GWD.getDriver(),this);
    }

    @FindBy(xpath = "(//span[text()='Setup'])[1]")
    private WebElement setupLeft;

    @FindBy(xpath = "//span[text()='Parameters']")
    private WebElement parametersLeft;

    @FindBy(xpath = "(//span[text()='Countries'])[1]")
    private WebElement countriesLeft;

    @FindBy(xpath = "(//span[text()='Citizenships'])[1]")
    private WebElement citizenshipsLeft;

    @FindBy(xpath = "//span[text()='Nationalities']")
    private WebElement nationalities;

    @FindBy(xpath = "(//span[text()='Fees'])[1]")
    private WebElement feesSetup;

    @FindBy(xpath = "(//span[text()='Entrance Exams'])[1]")
    private WebElement entranceExams;

    @FindBy(xpath = "(//span[text()='Setup'])[2]")
    private WebElement setupExam;

    @FindBy(xpath = "(//span[text()='Entrance Exams'])[2]")
    private WebElement entranceExamsSub;

    @FindBy(xpath = "//span[text()='Human Resources']")
    private WebElement humanResources;

    @FindBy(xpath = "//span[text()='Employees']")
    private WebElement employees;

    @FindBy(xpath = "//span[contains(text(),'States')]")
    private WebElement states;

    WebElement myElement;

    public void findAndClick(String strElement)
    {
        //element get : burada string isimden webelemente ulaşacağım
        switch (strElement)
        {
            case "setupLeft" : myElement=setupLeft;break;
            case "parametersLeft" : myElement=parametersLeft;break;
            case "countriesLeft" : myElement=countriesLeft;break;
            case "citizenshipsLeft" : myElement=citizenshipsLeft;break;
            case "nationalities" : myElement=nationalities;break;
            case "feesSetup" : myElement=feesSetup;break;
            case "entranceExams" : myElement=entranceExams;break;
            case "setupExam" : myElement=setupExam;break;
            case "entranceExamsSub" : myElement=entranceExamsSub;break;
            case "humanResources" : myElement=humanResources;break;
            case "employees" : myElement=employees;break;
            case "states" : myElement=states;break;

        }
        clickFunction(myElement);

    }


}
