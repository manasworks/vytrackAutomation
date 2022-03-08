package com.vytrack.tests;

import com.vytrack.pages.TopMenu;
import com.vytrack.pages.VehicleOdometer;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CY19_73 extends TestBase{

    @Test (dataProvider = "managers")
    public void testVehicleOdometerManagers(String username) {
        // AC1: Store and Sales managers should see an error message
        // “You do not have permission to perform this action.”
        // when they click the “Vehicle Odometer” module.

        VytrackUtils.login(username);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        Actions actions = new Actions(Driver.getDriver());
        TopMenu topMenu = new TopMenu();

        // Check if there is  any warning displayed, if yes close it
        BrowserUtils.sleep(1);
        if (topMenu.warningCloseBtn.isDisplayed()) topMenu.warningCloseBtn.click();

        // 1. Navigate over Fleet link
        wait.until(ExpectedConditions.visibilityOf(topMenu.fleetLink));
        actions.moveToElement(topMenu.fleetLink).perform();

        // 2. Select and click Vehicle Odometer page
        wait.until(ExpectedConditions.visibilityOf(topMenu.fleetSub_VehiclesOdometer));
        topMenu.fleetSub_VehiclesOdometer.click();


        // Validate Store and Sales managers should see an error message
        String actualWarning = topMenu.warningMessage.getText();
        String expectedWarning = "You do not have permission to perform this action.";
        Assert.assertEquals(actualWarning, expectedWarning);
    }

    @Test (dataProvider = "drivers")
    public void testVehicleOdometerDrivers(String username) {
        // AC2: Drivers should see the default page as 1.
        // AC3: Divers should see the View Per Page is 25 by default.

        VytrackUtils.login(username);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        Actions actions = new Actions(Driver.getDriver());
        TopMenu topMenu = new TopMenu();
        VehicleOdometer vehicleOdometer = new VehicleOdometer();

        // 1. Navigate over Fleet link
        wait.until(ExpectedConditions.visibilityOf(topMenu.fleetLink));
        actions.moveToElement(topMenu.fleetLink).perform();

        // 2. Select and click Vehicle Odometer page
        wait.until(ExpectedConditions.visibilityOf(topMenu.fleetSub_VehiclesOdometer));
        topMenu.fleetSub_VehiclesOdometer.click();

        // Wait till last cell is loaded
        wait.until(ExpectedConditions.visibilityOf(vehicleOdometer.lastCell));

        // Validate Drivers should see the default page as 1.
        String actual = vehicleOdometer.pageNumber.getAttribute("value");
        String expected = "1";
        Assert.assertEquals(actual, expected);

        // Validate Divers should see the View Per Page is 25 by default.
        actual = vehicleOdometer.viewPerPage.getText();
        expected = "25";
        Assert.assertEquals(actual, expected);
    }
}
