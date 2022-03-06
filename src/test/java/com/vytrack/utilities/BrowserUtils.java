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
}
