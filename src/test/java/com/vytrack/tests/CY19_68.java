package com.vytrack.tests;

import com.vytrack.pages.TopMenu;
import com.vytrack.pages.Vehicle;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CY19_68 extends TestBase{

    @Test (dataProvider = "userTypes")
    public void testVehicleIcons(String username) {
        //AC #1: users should see “view, edit, delete” when they hover the mouse to the three dots “...”.

        VytrackUtils.login(username);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        Actions actions = new Actions(Driver.getDriver());
        TopMenu topMenu = new TopMenu();
        Vehicle vehicle = new Vehicle();

        // Go to Vehicle page
        actions.moveToElement(topMenu.fleetLink).perform();
        topMenu.fleetSub_Vehicles.click();

        // Hover over tri dots
        wait.until(ExpectedConditions.visibilityOf(vehicle.lastCell));
        BrowserUtils.sleep(0.5);
        actions.moveToElement(vehicle.dots).perform();
        BrowserUtils.sleep(1);

        // Validate “view, edit, delete” is displayed
        Assert.assertTrue(vehicle.icon1.isDisplayed());
        Assert.assertTrue(vehicle.icon2.isDisplayed());
        Assert.assertTrue(vehicle.icon3.isDisplayed());
    }
}
