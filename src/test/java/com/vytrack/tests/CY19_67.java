package com.vytrack.tests;

import com.vytrack.pages.TopMenu;
import com.vytrack.pages.VehicleModel;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CY19_67 extends TestBase{

    @Test (dataProvider = "managers")
    public void testManagersVehicleModels(String username) {
        //AC #1: The store manager and sales manager should see 10 columns on the Vehicle Model page.
        //Expected Column names:
        //MODEL NAME, MAKE, CAN BE REQUESTED, CVVI, CO2 FEE (/MONTH), COST (DEPRECIATED),
        //TOTAL COST (DEPRECIATED), CO2 EMISSIONS, FUEL TYPE, VENDORS

        VytrackUtils.login(username);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        Actions actions = new Actions(Driver.getDriver());
        TopMenu  topMenu = new TopMenu();
        VehicleModel vehicleModel = new VehicleModel();

        // 1. Navigate over Fleet link
        wait.until(ExpectedConditions.visibilityOf(topMenu.fleetLink));
        Assert.assertTrue(topMenu.fleetLink.isDisplayed());
        actions.moveToElement(topMenu.fleetLink).perform();

        // 2. Select and click Vehicle Model page
        wait.until(ExpectedConditions.visibilityOf(topMenu.fleetSub_VehiclesModels));
        Assert.assertTrue(topMenu.fleetSub_VehiclesModels.isDisplayed());
        topMenu.fleetSub_VehiclesModels.click();

        //3. Validate if managers see 10 columns on the Vehicle Model page.
        wait.until(ExpectedConditions.visibilityOf(vehicleModel.lastCell));
        List<String> actualHeaders = new ArrayList<>();
        List<String> expectedHeaders = new ArrayList<>(Arrays.asList(
                "MODEL NAME","MAKE", "CAN BE REQUESTED", "CVVI", "CO2 FEE (/MONTH)", "COST (DEPRECIATED)",
                "TOTAL COST (DEPRECIATED)", "CO2 EMISSIONS", "FUEL TYPE", "VENDORS"
                ));

        for (WebElement headerCell : vehicleModel.headerCells) {
            actualHeaders.add(headerCell.getText());
        }

        Assert.assertEquals(vehicleModel.headerCells.size(), 10);
        Assert.assertEquals(actualHeaders, expectedHeaders);
    }

    @Test (dataProvider = "drivers")
    public void testDriversVehicleModels(String username) {
        // AC #2: Drivers should not able to access the Vehicle Model page, users should see
        // “You do not have permission to perform this action.”
        VytrackUtils.login(username);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        Actions actions = new Actions(Driver.getDriver());
        TopMenu topMenu = new TopMenu();

        // Check if there is  any warning displayed, if yes close it
        if (topMenu.warningCloseBtn.isDisplayed()) topMenu.warningCloseBtn.click();

        // 1. Navigate over Fleet link
        wait.until(ExpectedConditions.visibilityOf(topMenu.fleetLink));
        Assert.assertTrue(topMenu.fleetLink.isDisplayed());
        actions.moveToElement(topMenu.fleetLink).perform();

        // 2. Select and click Vehicle Model page
        wait.until(ExpectedConditions.visibilityOf(topMenu.fleetSub_VehiclesModels));
        Assert.assertTrue(topMenu.fleetSub_VehiclesModels.isDisplayed());
        topMenu.fleetSub_VehiclesModels.click();

        // 3. Drivers should not able to access the Vehicle Model page, users should see
        //    “You do not have permission to perform this action.”

        Assert.assertEquals(Driver.getDriver().getTitle(), "Dashboard");

        String actualWarning = topMenu.warningMessage.getText();
        String expectedWarning = "You do not have permission to perform this action.";

        Assert.assertEquals(actualWarning, expectedWarning);
    }
}
