package com.vytrack.tests;

import com.vytrack.pages.TopMenu;
import com.vytrack.pages.VehicleContacts;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CY19_66 extends TestBase{

    @Test (dataProvider = "managers")
    public void testVehicleContractsManagers(String username) {
        //AC1: Store managers and Sales managers access the Vehicle contracts page.
        //Expected URL: https://qa2.vytrack.com/entity/Extend_Entity_VehicleContract
        //Expected title: All - Vehicle Contract - Entities - System - Car - Entities - System.

        VytrackUtils.login(username);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        Actions actions = new Actions(Driver.getDriver());
        TopMenu topMenu = new TopMenu();
        VehicleContacts vehicleContacts = new VehicleContacts();

        // Go to the Vehicle Contacts page
        actions.moveToElement(topMenu.fleetLink).perform();
        topMenu.fleetSub_VehiclesContracts.click();

        // Validate Title
        wait.until(ExpectedConditions.visibilityOf(vehicleContacts.tableCell));
        BrowserUtils.sleep(0.5);
        BrowserUtils.verifyTitle("All - Vehicle Contract - Entities - System - Car - Entities - System");
    }

    @Test (dataProvider = "drivers")
    public void testVehicleContractsDrivers(String username) {
        // AC2: Drivers should NOT able to access the Vehicle contracts page, the app should display
        // “You do not have permission to perform this action.”

        VytrackUtils.login(username);
        Actions actions = new Actions(Driver.getDriver());
        TopMenu topMenu = new TopMenu();

        // Go to the Vehicle Contacts page
        actions.moveToElement(topMenu.fleetLink).perform();
        topMenu.fleetSub_VehiclesContracts.click();

        // Validate Drivers sees error message
        Assert.assertTrue(topMenu.warningMessage.isDisplayed());
        String actualMessage = topMenu.warningMessage.getText();
        String expectedMessage = "You do not have permission to perform this action.";
        Assert.assertEquals(actualMessage, expectedMessage);
    }
}
