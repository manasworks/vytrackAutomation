package com.vytrack.tests;

import com.vytrack.pages.Calendar;
import com.vytrack.pages.TopMenu;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CY19_70 extends TestBase{

    @Test (dataProvider = "userTypes")
    public void testCalendarDefault1(String username) {

        //AC #1: user should see the number “1” by default.
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
        BrowserUtils.sleep(0.5);
        wait.until(ExpectedConditions.visibilityOf(calendar.repeatCheckbox));
        calendar.repeatCheckbox.click();

        // Validate user see 1 by default
        wait.until(ExpectedConditions.visibilityOf(calendar.daysInput));
        String actualValue = calendar.daysInput.getAttribute("value");
        String expectedValue = "1";
        Assert.assertEquals(actualValue, expectedValue);
    }

    @Test (dataProvider = "userTypes")
    public void testName(String username) {

        // AC #2: user should see an error message “This value should not be blank.”
        // when the Calendar event repeat field is cleared(delete the number 1).
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

        // Clear days input
        wait.until(ExpectedConditions.visibilityOf(calendar.daysInput));
        calendar.daysInput.clear();

        // Validate error message
        wait.until(ExpectedConditions.visibilityOf(calendar.errorMessage));
        String actualMessage = calendar.errorMessage.getText();
        String expectedMessage = "This value should not be blank.";
        Assert.assertEquals(actualMessage, expectedMessage);
    }
}
