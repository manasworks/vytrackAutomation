package com.vytrack.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BrowserUtils{

    //This method will accept int (in seconds) and execute
    //Thread.sleep for given duration
    public static void sleep(double second){
        int sec = (int) (second *1000);
        try {
            Thread.sleep(sec);
        }catch (InterruptedException e ) {

        }
    }

    //This method accepts a String "expectedTitle" and Asserts if it is true
    public static void verifyTitle( String expectedTitle){
        Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);
    }

    //This method accepts a String "expectedTitle" and Asserts if it contains in actual title
    public static void verifyTitleContains(String expectedTitle){
        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedTitle));
    }

    // This method find the element by Xpath, CSS or ID
    // and waits until element is loaded to the page
    public static WebElement find(String locator){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        WebElement element;
        if (locator.contains("//")){
            element = Driver.getDriver().findElement(By.xpath(locator));
        } else if ( (locator.contains("[") || locator.contains("#") || locator.contains(".")) && !locator.contains("//")){
            element = Driver.getDriver().findElement(By.cssSelector(locator));
        } else {
            element = Driver.getDriver().findElement(By.id(locator));
        }
        wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }
}
