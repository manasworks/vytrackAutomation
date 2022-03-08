package com.vytrack.tests;

import com.vytrack.pages.Calendar;
import com.vytrack.pages.TopMenu;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CY19_72 extends TestBase{

    @Test (dataProvider = "userTypes")
    public void testCalendarMessage(String username) {

        // AC1: users should be able to write messages in the Description field on the calendar event page.

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

        // Switch to iframe
        Driver.getDriver().switchTo().frame(calendar.iframe);

        // Enter a text to message body
        String text = "New text " + Driver.getDriver();
        calendar.textBody.sendKeys(text);

        // Validate a text entered to body
        String actualText = calendar.message.getText();
        Assert.assertEquals(actualText, text);

        // Switch back to main Dome
        Driver.getDriver().switchTo().parentFrame();
    }
}
