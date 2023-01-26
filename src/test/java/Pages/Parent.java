package Pages;

import Utilities.GWD;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Parent {
    WebDriverWait waitAWhile = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(10));
    public void sendKeysFunction(WebElement element, String value)
    {
        waitUntilVisible(element); // gözükene kadar bekle
        scrollToElement(element);  // elemente kadar scroll yap
        element.clear(); // kutuyu temizle
        element.sendKeys(value); // değeri gönder

    }

    public void clickFunction(WebElement element)
    {
        waitUntilClickable(element);
        scrollToElement(element);  // elemente kadar scroll yap
        element.click();
    }
    public void waitUntilVisible(WebElement element)
    {
        waitAWhile.until(ExpectedConditions.visibilityOf(element));
    }
    public void scrollToElement(WebElement element)
    {
        JavascriptExecutor js=(JavascriptExecutor) GWD.getDriver();
        js.executeScript("arguments[0].scrollIntoView();",element);
    }
    public void waitUntilClickable(WebElement element)
    {
        //waitAWhile.until(ExpectedConditions.visibilityOf(element));
//        Duration dr=Duration.ofSeconds(20);
//        GWD.getDriver().manage().timeouts().implicitlyWait(dr);
        waitAWhile.until(ExpectedConditions.elementToBeClickable(element));

    }
    public void verifyContainsTextFunction(WebElement element,String value)
    {
        waitAWhile.until(ExpectedConditions.textToBePresentInElement(element,value));
        Assert.assertTrue(element.getText().toLowerCase().contains(value.toLowerCase()),"The Text you search could NOT be find");
        new Actions(GWD.getDriver()).sendKeys(Keys.ESCAPE).perform();

    }

    public void waitUntilLoading()
    {
        waitAWhile.until(ExpectedConditions.numberOfElementsToBe(By.cssSelector("fuse-progress-bar > *"), 0));
        // progressbar ın çocukları


    }

}
