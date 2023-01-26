package Pages;

import Utilities.GWD;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class DialogContent extends Parent{

    public DialogContent() {
        PageFactory.initElements(GWD.getDriver(),this);
    }

    @FindBy(css = "[formcontrolname='username']")
    private WebElement userName;

    @FindBy(css = "[formcontrolname='password']")
    private WebElement password;

    @FindBy(css = "[aria-label='LOGIN']")
    private WebElement loginButton;

    @FindBy(css = "span[class='nav-link-title']")
    private WebElement dashboardLeftNav;

    @FindBy(css = "span[class='mat-tooltip-trigger logo-text']")
    private WebElement txtTechnoStudy;

    @FindBy(xpath = "//button[text()='Accept all cookies']")
    private WebElement cookieAccept;

    @FindBy(xpath = "//ms-add-button[contains(@tooltip,'TITLE.ADD')]//button")
    private WebElement plusIcon;

    @FindBy(css = "[data-placeholder='Name'][aria-required='true']")
    private WebElement name;

    @FindBy(xpath = "(//input[@data-placeholder='Code'])[2]")
    private WebElement code;

    @FindBy(xpath = "//span[text()='Save']")
    private WebElement save;

    @FindBy(xpath = "//div[contains(text(),'successfully')]")
    private WebElement successText;

    @FindBy(xpath = "(//input[@data-placeholder='Short Name'])[2]")
    private WebElement shortName;

    @FindBy(xpath = "//div[contains(text(),'already')]")
    private WebElement alreadyExist;

    @FindBy(xpath = "(//*[contains(@data-placeholder,'Name')])[1]")
    private WebElement nameSearch;

    @FindBy(xpath = "(//*[@data-placeholder='Short Name'])[1]")
    private WebElement shortNameSearch;

    @FindBy(xpath = "//span[text()='Search']")
    private WebElement searchButton;

    @FindBy(css = "[data-icon='trash-can']")
    private WebElement deleteIcon;

    @FindBy(xpath = "//span[text()=' Delete ']")
    private WebElement deleteButton;

    @FindBy(xpath = "(//td[@role='cell'])[2]")
    private WebElement searchResultCell;

    @FindBy(xpath = "//input[@data-placeholder='Integration Code']")
    private WebElement integrationCode;

    @FindBy(xpath = "(//input[@data-placeholder='Priority'])[2]")
    private WebElement priorty;

    @FindBy(xpath = "//*[@formcontrolname='active']")
    private WebElement toggleBar;

    @FindBy(xpath = "//tbody[@role='rowgroup']/tr/td[2]")
    public List<WebElement> stateList;





    WebElement myElement;

    public void findAndSend(String strElement,String value)
    {
        //element get : burada string isimden webelemente ulaşacağım
        switch (strElement)
        {
            case "username" : myElement=userName;break;
            case "password" : myElement=password;break;
            case "name" : myElement=name;break;
            case "code" : myElement=code;break;
            case "shortName" : myElement=shortName;break;
            case "nameSearch" : myElement=nameSearch;break;
            case "shortNameSearch" : myElement=shortNameSearch;break;
            case "integrationCode" : myElement=integrationCode;break;
            case "priorty" : myElement=priorty;break;

        }
        sendKeysFunction(myElement,value);

    }
    public void findAndClick(String strElement)
    {
        //element get : burada string isimden webelemente ulaşacağım
        switch (strElement)
        {
            case "loginButton" : myElement=loginButton;break;
            case "cookieAccept" : myElement=cookieAccept;break;
            case "plusIcon" : myElement=plusIcon;break;
            case "save" : myElement=save;break;
            case "searchButton" : myElement=searchButton;break;
            case "deleteIcon" : myElement=deleteIcon;break;
            case "deleteButton" : myElement=deleteButton;break;
            case "toggleBar" : myElement=toggleBar;break;


        }
        clickFunction(myElement);


    }
    public void findAndContainsText(String strElement, String text)
    {
        //element get : burada string isimden webelemente ulaşacağım
        switch (strElement)
        {
            case "txtTechnoStudy" : myElement= txtTechnoStudy;break;
            case "successText" : myElement= successText;break;
            case "alreadyExist" : myElement= alreadyExist;break;
            case "searchResultCell" : myElement= searchResultCell;break;

        }

        verifyContainsTextFunction(myElement,text);

    }
    public void findAndDelete(String searchText)
    {

        findAndSend("nameSearch",searchText);
        findAndClick("searchButton");
        waitUntilLoading();
        findAndContainsText("searchResultCell",searchText);
        findAndClick("deleteIcon");
        findAndClick("deleteButton");


    }








}
