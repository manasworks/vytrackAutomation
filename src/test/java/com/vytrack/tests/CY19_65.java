package com.vytrack.tests;

import com.vytrack.pages.PinBarHelp;
import com.vytrack.pages.TopMenu;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CY19_65 extends TestBase{

    @Test (dataProvider = "userTypes")
    public void testName(String username) {
        // AC1: when users click the “Learn how to use this space” link on the homepage, users should see:
        // “How To Use Pin bar” and
        // “Use pin icon on the right top corner of the page to create fast access link in the pin bar.”

        VytrackUtils.login(username);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        TopMenu topMenu = new TopMenu();
        PinBarHelp pinBarHelp = new PinBarHelp();

        // Click on “Learn how to use this space” link
        wait.until(ExpectedConditions.visibilityOf(topMenu.pinBarHelp));
        topMenu.pinBarHelp.click();

        // Validate user sees “How To Use Pin bar”
        wait.until(ExpectedConditions.visibilityOf(pinBarHelp.topicPinBar));
        String actualLabel = pinBarHelp.topicPinBar.getText();
        String expectedLabel = "How To Use Pinbar";
        Assert.assertEquals(actualLabel, expectedLabel);

        // Use pin icon on the right top corner of the page to create fast access link in the pin bar.
        wait.until(ExpectedConditions.visibilityOf(pinBarHelp.pinBarButton));
        pinBarHelp.pinBarButton.click();

        // Validate page is pinned to the Top
        wait.until(ExpectedConditions.visibilityOf(pinBarHelp.pinHolder));
        Assert.assertTrue(pinBarHelp.pinHolder.isDisplayed());

        // Remove pinned page and validate it no more displayed
        wait.until(ExpectedConditions.visibilityOf(pinBarHelp.pinBarButton));
        pinBarHelp.pinBarButton.click();

        wait.until(ExpectedConditions.visibilityOf(topMenu.pinBarHelp));
        Assert.assertTrue(topMenu.pinBarHelp.isDisplayed());
    }
}
