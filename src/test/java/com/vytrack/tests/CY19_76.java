package com.vytrack.tests;

import com.vytrack.pages.Campaigns;
import com.vytrack.pages.TopMenu;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CY19_76 extends TestBase{

    @Test (dataProvider = "managers")
    public void testCampaigns(String username) {

        //AC #1: Store and sales managers should see all the five filter options are checked by default.

        VytrackUtils.login(username);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        Actions actions = new Actions(Driver.getDriver());
        TopMenu topMenu = new TopMenu();
        Campaigns campaigns = new Campaigns();

        // 1. Navigate over Marketing link
        wait.until(ExpectedConditions.visibilityOf(topMenu.marketingLink));
        actions.moveToElement(topMenu.marketingLink).perform();

        // 2. Select and click  Accounts page
        wait.until(ExpectedConditions.visibilityOf(topMenu.marketingSubCampaigns));
        topMenu.marketingSubCampaigns.click();

        // Click Filters button
        wait.until(ExpectedConditions.visibilityOf(campaigns.filters));
        campaigns.filters.click();

        // Click on the Manage filters
        wait.until(ExpectedConditions.visibilityOf(campaigns.manageFilters));
        campaigns.manageFilters.click();

        // Validate if all 5 filters are displayed and filter options are checked by default.
        Assert.assertEquals(campaigns.filterCheckboxes.size(), 5);

        for (WebElement each : campaigns.filterCheckboxes) {
            Assert.assertTrue(each.isSelected());
        }

    }

    @Test (dataProvider = "managers")
    public void testCampaignsUncheck(String username) {

        //AC #2: any amount of boxes should be unchecked. (can check only 1, or multiple)

        VytrackUtils.login(username);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        Actions actions = new Actions(Driver.getDriver());
        TopMenu topMenu = new TopMenu();
        Campaigns campaigns = new Campaigns();

        // 1. Navigate over Marketing link
        wait.until(ExpectedConditions.visibilityOf(topMenu.marketingLink));
        actions.moveToElement(topMenu.marketingLink).perform();

        // 2. Select and click  Accounts page
        wait.until(ExpectedConditions.visibilityOf(topMenu.marketingSubCampaigns));
        topMenu.marketingSubCampaigns.click();

        // Click Filters button
        wait.until(ExpectedConditions.visibilityOf(campaigns.filters));
        campaigns.filters.click();

        // Click on the Manage filters
        wait.until(ExpectedConditions.visibilityOf(campaigns.manageFilters));
        campaigns.manageFilters.click();

        // Validate any amount of boxes should be unchecked. (can check only 1, or multiple)
        for (int i = 0; i < campaigns.filterCheckboxes.size(); i++) {
            campaigns.filterCheckboxes.get(i).click();
            BrowserUtils.sleep(1);
        }

        for (WebElement each : campaigns.filterCheckboxes) {
            wait.until(ExpectedConditions.elementToBeClickable(each));
            Assert.assertFalse(each.isSelected());
        }

    }
}
