package com.vytrack.tests;

import com.vytrack.pages.PinBar;
import com.vytrack.pages.TopMenu;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CY19_65 extends TestBase{

    @Test (dataProvider = "userTypes")
    public void testPinBar(String username) {
        // AC1: when users click the “Learn how to use this space” link on the homepage, users should see:
        // “How To Use Pin bar” and
        // “Use pin icon on the right top corner of the page to create fast access link in the pin bar.”

        VytrackUtils.login(username);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        TopMenu topMenu = new TopMenu();
        PinBar pinBar = new PinBar();

        // Click on “Learn how to use this space” link
        wait.until(ExpectedConditions.visibilityOf(topMenu.pinBarHelp));
        topMenu.pinBarHelp.click();

        // Validate user sees “How To Use Pin bar”
        wait.until(ExpectedConditions.visibilityOf(pinBar.topic));
        String actualLabel = pinBar.topic.getText();
        String expectedLabel = "How To Use Pinbar";
        Assert.assertEquals(actualLabel, expectedLabel);

        // Use pin icon on the right top corner of the page to create fast access link in the pin bar.
        wait.until(ExpectedConditions.visibilityOf(pinBar.pinBarButton));
        pinBar.pinBarButton.click();

        // Validate page is pinned to the Top
        wait.until(ExpectedConditions.visibilityOf(pinBar.pinHolder));
        Assert.assertTrue(pinBar.pinHolder.isDisplayed());

        // Remove pinned page and validate it no more displayed
        wait.until(ExpectedConditions.visibilityOf(pinBar.pinBarButton));
        pinBar.pinBarButton.click();

        wait.until(ExpectedConditions.visibilityOf(topMenu.pinBarHelp));
        Assert.assertTrue(topMenu.pinBarHelp.isDisplayed());
    }

    @Test (dataProvider = "userTypes")
    public void testValidateUsersSeeImage(String username) {

        //AC2: users should see an image on the page.
        //[in automation testing, just verify the image source.]
        //Expected source: /bundles/oronavigation/images/pinbar-location.jpg

        VytrackUtils.login(username);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        TopMenu topMenu = new TopMenu();
        PinBar pinBar = new PinBar();

        // Click on “Learn how to use this space” link
        wait.until(ExpectedConditions.visibilityOf(topMenu.pinBarHelp));
        topMenu.pinBarHelp.click();

        wait.until(ExpectedConditions.visibilityOf(pinBar.image));
        Assert.assertTrue(pinBar.image.isDisplayed());
        String actualSource = pinBar.image.getAttribute("src").replace("https://qa1.vytrack.com", "");
        String expectedSource = "/bundles/oronavigation/images/pinbar-location.jpg";
        Assert.assertEquals(actualSource, expectedSource);

    }
}
