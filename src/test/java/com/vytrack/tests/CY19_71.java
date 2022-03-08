package com.vytrack.tests;

import com.vytrack.pages.Calendar;
import com.vytrack.pages.TopMenu;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CY19_71 extends TestBase{

    @Test (dataProvider = "userTypes")
    public void testLessThan1(String username) {

        // AC : Users see error messages for entering invalid integers.
        // If enters less than 1 —> user should see “The value have not to be less than 1.”

        VytrackUtils.login(username);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        Actions actions = new Actions(Driver.getDriver());
        TopMenu topMenu = new TopMenu();
        Calendar calendar = new Calendar();

        // Go to Calendar page
        actions.moveToElement(topMenu.activitiesLink).perform();
        topMenu.activitiesSubCalendar.click();

        // Click create New Calendar Event
        wait.until(ExpectedConditions.visibilityOf(calendar.createEvent));
        calendar.createEvent.click();

        // Click on Repeat Checkbox
        wait.until(ExpectedConditions.visibilityOf(calendar.repeatCheckbox));
        calendar.repeatCheckbox.click();

        // Enter number less than 1
        wait.until(ExpectedConditions.visibilityOf(calendar.daysInput));
        calendar.daysInput.sendKeys(Keys.BACK_SPACE+"-2");
        calendar.inputTitle.click();

        // Validate error message
        wait.until(ExpectedConditions.visibilityOf(calendar.errorMessage));
        String actualMessage = calendar.errorMessage.getText();
        String expectedMessage = "The value have not to be less than 1.";
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test (dataProvider = "userTypes")
    public void testBiggerThan99(String username) {

        // AC : Users see error messages for entering invalid integers.
        // If enters more than 99 —> user should see “The value have not to be more than 99.”

        VytrackUtils.login(username);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        Actions actions = new Actions(Driver.getDriver());
        TopMenu topMenu = new TopMenu();
        Calendar calendar = new Calendar();

        // Go to Calendar page
        actions.moveToElement(topMenu.activitiesLink).perform();
        topMenu.activitiesSubCalendar.click();

        // Click create New Calendar Event
        wait.until(ExpectedConditions.visibilityOf(calendar.createEvent));
        calendar.createEvent.click();

        // Click on Repeat Checkbox
        wait.until(ExpectedConditions.visibilityOf(calendar.repeatCheckbox));
        calendar.repeatCheckbox.click();

        // Enter number less than 1
        wait.until(ExpectedConditions.visibilityOf(calendar.daysInput));
        calendar.daysInput.sendKeys(Keys.BACK_SPACE+"100");
        calendar.inputTitle.click();

        // Validate error message
        wait.until(ExpectedConditions.visibilityOf(calendar.errorMessage));
        String actualMessage = calendar.errorMessage.getText();
        String expectedMessage = "The value have not to be more than 99.";
        Assert.assertEquals(actualMessage, expectedMessage);
    }
}
