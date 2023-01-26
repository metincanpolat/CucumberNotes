package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FormContent extends Parent{


    public FormContent() {
        PageFactory.initElements(GWD.getDriver(),this);
    }

    @FindBy(xpath = "(//span[text()='Academic Period'])[1]")
    private WebElement academicPeriod;

    @FindBy(xpath = "(//mat-option[@role='option']/span)[1]")
    private WebElement period2022;

    @FindBy(xpath = "(//mat-select[@formcontrolname='id']/div/div)[3]")
    private WebElement gradeLevel;

    @FindBy(xpath = "(//mat-option[@role='option']/span)[2]")
    private WebElement gradeLevel2;

    @FindBy(xpath = "(//mat-option[@role='option']/span[.=' 2.Grade '])")
    private WebElement gradeLevel3;

    @FindBy(xpath = "(//mat-option[@role='option']/span[.=' 3.Grade '])")
    private WebElement gradeLevel4;

    @FindBy(xpath = "(//mat-option[@role='option']/span[.=' 4.Grade '])")
    private WebElement gradeLevel5;

    @FindBy(css = "[formcontrolname='firstName']>input")
    private WebElement firstName;

    @FindBy(css = "[data-placeholder='Last Name']")
    private WebElement lastName;

    @FindBy(css = "[data-placeholder='Employee ID']")
    private WebElement employeeID;

    @FindBy(xpath = "//span[text()='Document Type']")
    private WebElement documentType;

    @FindBy(xpath = "//span[text()=' Personal ID ']")
    private WebElement personalID;

    @FindBy(xpath = "//span[text()=' Personal ID ']")
    private WebElement passport;

    @FindBy(css = "[data-placeholder='Document Number']")
    private WebElement documentNumber;

    @FindBy(xpath = "//div[text()='Contact & Address']")
    private WebElement contactAddress;

    @FindBy(css = "[data-placeholder='Country']")
    private WebElement country;

    @FindBy(css = "[data-placeholder='Country'][aria-expanded='True']")
    private WebElement countryForWait;

    @FindBy(xpath = "//div[text()='Additional Info']")
    private WebElement additionalInfo;

    @FindBy(css = "[data-placeholder='alyupfwe 1']")
    private WebElement alyup;

    @FindBy(css = "[data-icon='floppy-disk']")
    private WebElement save;



    WebElement myElement;
    public void findAndClick(String strlement) {
        //element get :burda string isimden weblemente ulaşıcam
        switch (strlement) {
            case "academicPeriod" : myElement = academicPeriod;break;
            case "period2022": myElement = period2022;break;
            case "gradeLevel" : myElement = gradeLevel;break;
            case "gradeLevel2" : myElement = gradeLevel2;break;
            case "gradeLevel3" : myElement = gradeLevel3;break;
            case "gradeLevel4" : myElement = gradeLevel4;break;
            case "gradeLevel5" : myElement = gradeLevel5;break;
            case "documentType" : myElement = documentType;break;
            case "personalID" : myElement = personalID;break;
            case "contactAddress" : myElement = contactAddress;break;
            case "additionalInfo" : myElement = additionalInfo;break;
            case "save" : myElement = save;break;
            case "passport" : myElement = passport;break;

        }

        clickFunction(myElement);
    }

    public void findAndSend(String strElement,String value)
    {
        //element get : burada string isimden webelemente ulaşacağım
        switch (strElement)
        {
            case "firstName" : myElement=firstName;break;
            case "lastName" : myElement=lastName;break;
            case "employeeID" : myElement=employeeID;break;
            case "documentNumber" : myElement=documentNumber;break;
            case "country" : myElement=country;break;
            case "alyup" : myElement=alyup;break;



        }
        sendKeysFunction(myElement,value);

    }
    public void findAndWait(String searchText)
    {
        switch (searchText)
        {
            case "country" : myElement= country;break;


        }

        waitAWhile.until(ExpectedConditions.attributeToBe(myElement,"aria-expanded","true"));


    }

}
