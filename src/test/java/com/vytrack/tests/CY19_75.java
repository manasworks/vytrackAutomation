package com.vytrack.tests;

import com.vytrack.pages.TopMenu;
import com.vytrack.pages.VehicleCosts;
import com.vytrack.utilities.BrowserUtils;
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

public class CY19_75 extends TestBase{

    @Test (dataProvider = "userTypes")
    public void testVehicleCostsPage(String username) {
        // AC #1: Users should see three columns on the Vehicle Costs page.
        // Expected Column names:
        // TYPE, TOTAL PRICE, DATE

        VytrackUtils.login(username);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        Actions actions = new Actions(Driver.getDriver());
        TopMenu topMenu = new TopMenu();
        VehicleCosts vehicleCosts = new VehicleCosts();

        // 1. Navigate over Fleet link
        wait.until(ExpectedConditions.visibilityOf(topMenu.fleetLink));
        Assert.assertTrue(topMenu.fleetLink.isDisplayed());
        actions.moveToElement(topMenu.fleetLink).perform();

        // 2. Select and click Vehicle Costs page
        wait.until(ExpectedConditions.visibilityOf(topMenu.fleetSub_VehiclesCosts));
        Assert.assertTrue(topMenu.fleetSub_VehiclesCosts.isDisplayed());
        topMenu.fleetSub_VehiclesCosts.click();

        // 3. Validate if users see three columns on the Vehicle Costs page. TYPE, TOTAL PRICE, DATE
        wait.until(ExpectedConditions.visibilityOf(vehicleCosts.actionCell));
        List<String> actualHeaders = new ArrayList<>();
        List<String> expectedHeaders = new ArrayList<>(Arrays.asList("TYPE", "TOTAL PRICE", "DATE"));

        for (WebElement headerCell : vehicleCosts.headerCells) {
            actualHeaders.add(headerCell.getText());
        }

        Assert.assertEquals(vehicleCosts.headerCells.size(), 3);
        Assert.assertEquals(actualHeaders, expectedHeaders);
    }

    @Test (dataProvider = "userTypes", dependsOnMethods={"testVehicleCostsPage"})
    public void testVehicleCostsCheckboxes(String username) {
        //AC #2: users check the first checkbox to check all the Vehicle Costs

        VytrackUtils.login(username);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        Actions actions = new Actions(Driver.getDriver());
        TopMenu topMenu = new TopMenu();
        VehicleCosts vehicleCosts = new VehicleCosts();

        // 1. Navigate over Fleet link
        wait.until(ExpectedConditions.visibilityOf(topMenu.fleetLink));
        Assert.assertTrue(topMenu.fleetLink.isDisplayed());
        actions.moveToElement(topMenu.fleetLink).perform();

        // 2. Select and click Vehicle Costs page
        wait.until(ExpectedConditions.visibilityOf(topMenu.fleetSub_VehiclesCosts));
        Assert.assertTrue(topMenu.fleetSub_VehiclesCosts.isDisplayed());
        topMenu.fleetSub_VehiclesCosts.click();

        // Validate users check the first checkbox to check all the Vehicle Costs
        // 3. Click first CheckBox to select all checkboxes
        wait.until(ExpectedConditions.visibilityOf(vehicleCosts.firstCheckBox));
        vehicleCosts.firstCheckBox.click();

        // 4. Validate if all other checkboxes are selected
        for (WebElement each : vehicleCosts.allCheckBoxes) {
            Assert.assertTrue(each.isSelected());
        }

        // 5. Click first CheckBox to deselect all checkboxes
        vehicleCosts.firstCheckBox.click();

        // 6. Validate if all other checkboxes are de-selected
        for (WebElement each : vehicleCosts.allCheckBoxes) {
            Assert.assertFalse(each.isSelected());
        }
    }

    @Test (dataProvider = "userTypes", dependsOnMethods={"testVehicleCostsPage"})
    public void testVehicleCostsTableFilters(String username) {

        //AC #3: users should be able to use table filters

        VytrackUtils.login(username);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        Actions actions = new Actions(Driver.getDriver());
        TopMenu topMenu = new TopMenu();
        VehicleCosts vehicleCosts = new VehicleCosts();

        // 1. Navigate over Fleet link
        wait.until(ExpectedConditions.visibilityOf(topMenu.fleetLink));
        Assert.assertTrue(topMenu.fleetLink.isDisplayed());
        actions.moveToElement(topMenu.fleetLink).perform();

        // 2. Select and click Vehicle Costs page
        wait.until(ExpectedConditions.visibilityOf(topMenu.fleetSub_VehiclesCosts));
        Assert.assertTrue(topMenu.fleetSub_VehiclesCosts.isDisplayed());
        topMenu.fleetSub_VehiclesCosts.click();

        // 3. Validate Filter by Date is working
        String oldValue = vehicleCosts.cellDate.getText();
        vehicleCosts.thirdFilter.click();
        BrowserUtils.sleep(1);
        String newValue = vehicleCosts.cellDate.getText();
        Assert.assertNotEquals(oldValue, newValue);

        // 4. Validate Filter by Type is working
        oldValue = vehicleCosts.cellType.getText();
        vehicleCosts.firstFilter.click();
        BrowserUtils.sleep(1);
        newValue = vehicleCosts.cellType.getText();
        Assert.assertNotEquals(oldValue, newValue);

        // 5. Validate second Filter by Price is working
        oldValue = vehicleCosts.cellPrice.getText();
        vehicleCosts.secondFilter.click();
        BrowserUtils.sleep(1);
        newValue = vehicleCosts.cellPrice.getText();
        Assert.assertNotEquals(oldValue, newValue);
    }
}
