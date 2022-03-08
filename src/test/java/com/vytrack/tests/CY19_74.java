package com.vytrack.tests;

import com.vytrack.pages.Accounts;
import com.vytrack.pages.TopMenu;
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

public class CY19_74 extends TestBase{

    @Test (dataProvider = "managers")
    public void testAccountsPage(String username) {

        //AC1: users should see 8 filter items on the Accounts page
        //Expected filter names: Account Name, Contact Name, Contact Email, Contact Phone, Owner, Business Unit, Created At, Updated At.

        VytrackUtils.login(username);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        Actions actions = new Actions(Driver.getDriver());
        TopMenu topMenu = new TopMenu();
        Accounts accounts = new Accounts();

        // 1. Navigate over Customers link
        wait.until(ExpectedConditions.visibilityOf(topMenu.customersLink));
        actions.moveToElement(topMenu.customersLink).perform();

        // 2. Select and click  Accounts page
        wait.until(ExpectedConditions.visibilityOf(topMenu.customersSubAccounts));
        topMenu.customersSubAccounts.click();

        // Click on filter button
        wait.until(ExpectedConditions.visibilityOf(accounts.filters));
        accounts.filters.click();

        // Validate filter names
        List<String> actual = new ArrayList<>();
        List<String> expected = new ArrayList<>(Arrays.asList(
                "Account Name", "Contact Name", "Contact Email", "Contact Phone", "Owner", "Business Unit", "Created At", "Updated At"
        ));

        for (WebElement each : accounts.allFilters) {
            actual.add( each.getText().replace(": All", "") );
        }

        Assert.assertEquals(actual, expected);
    }
}
