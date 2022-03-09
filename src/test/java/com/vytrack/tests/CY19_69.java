package com.vytrack.tests;

import com.vytrack.pages.TopMenu;
import com.vytrack.pages.Vehicle;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CY19_69 extends TestBase{

    @Test (dataProvider = "managers")
    public void testAllCheckBoxesUnchecked(String username) {
        //AC #1: once the user launched to the Vehicle page, all the checkboxes should be unchecked

        VytrackUtils.login(username);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        Actions actions = new Actions(Driver.getDriver());
        TopMenu topMenu = new TopMenu();
        Vehicle vehicle = new Vehicle();

        // Go to Vehicle page
        actions.moveToElement(topMenu.fleetLink).perform();
        topMenu.fleetSub_Vehicles.click();

        // Wait till last cell of a Table is loaded
        wait.until(ExpectedConditions.visibilityOf(vehicle.lastCell));

        // Validate all checkboxes are visible and unselected
        for (WebElement checkbox : vehicle.checkboxes) {
            Assert.assertTrue(checkbox.isDisplayed());
            Assert.assertFalse(checkbox.isSelected());
        }
    }

    @Test (dataProvider = "managers")
    public void testFirstCheckbox(String username) {
        //AC #2: user check the first checkbox to check all the cars

        VytrackUtils.login(username);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        Actions actions = new Actions(Driver.getDriver());
        TopMenu topMenu = new TopMenu();
        Vehicle vehicle = new Vehicle();

        // Go to Vehicle page
        actions.moveToElement(topMenu.fleetLink).perform();
        topMenu.fleetSub_Vehicles.click();

        // Wait till last cell of a Table is loaded
        wait.until(ExpectedConditions.visibilityOf(vehicle.lastCell));

        // Click first checkbox
        vehicle.firstCheckbox.click();

        // Validate if all other checkboxes are selected
        for (WebElement carCheckbox : vehicle.carCheckboxes) {
            Assert.assertTrue(carCheckbox.isSelected());
        }
    }

    @Test (dataProvider = "managers")
    public void testRandomCarSelected(String username) {
        //AC #3: users can select any car

        VytrackUtils.login(username);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        Actions actions = new Actions(Driver.getDriver());
        TopMenu topMenu = new TopMenu();
        Vehicle vehicle = new Vehicle();

        // Go to Vehicle page
        actions.moveToElement(topMenu.fleetLink).perform();
        topMenu.fleetSub_Vehicles.click();

        // Wait till last cell of a Table is loaded
        wait.until(ExpectedConditions.visibilityOf(vehicle.lastCell));

        // Select random car
        int random = (int) (Math.random()*(20)) + 1;

        WebElement randomCheckbox = Driver.getDriver().findElement(By.xpath("//tr["+random+"]//td//input[@type='checkbox']"));

        wait.until(ExpectedConditions.visibilityOf(randomCheckbox));
        BrowserUtils.sleep(0.5);
        randomCheckbox.click();
        Assert.assertTrue(randomCheckbox.isSelected());


    }
}
