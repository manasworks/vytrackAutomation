package com.vytrack.tests;

import com.vytrack.pages.TopMenu;
import com.vytrack.pages.VehicleModel;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;

public class All_Methods_test extends TestBase {
    /*
    Data Provider has:
    userTypes, allUsers, drivers, storeManagers, salesManagers
    groups
     */

    @Test (dataProvider = "userTypes")
    public void testName(String username) {

        VytrackUtils.login(username);
        TopMenu topMenu = new TopMenu();
        VehicleModel vehicleModel = new VehicleModel();
        Actions actions = new Actions(Driver.getDriver());

        /* You can also use
              .login("your username") without dataProvider
              .login("your username", "your password") without dataProvider
              .login() will login as user31
         */


        // Verify the title of the page
        BrowserUtils.verifyTitle("Dashboard");

        // Verify if the Title contains
        BrowserUtils.verifyTitleContains("board");

        actions.moveToElement(topMenu.fleetLink).perform();
        topMenu.fleetSub_VehiclesModels.click();






        /*
        List<WebElement> tableColumns = Driver.getDriver().findElements(By.xpath("//tbody/tr[@class='grid-row']/td"));
        Assert.assertEquals(tableColumns.size(), 12);
        List<String> expectedNames = new ArrayList<>(Arrays.asList("MODEL NAME", "MAKE", "CAN BE REQUESTED", "CVVI", "CO2 FEE (/MONTH)", "COST (DEPRECIATED)", "TOTAL COST (DEPRECIATED)", "CO2 EMISSIONS", "FUEL TYPE", "VENDORS", ""));


         */





        //actions.moveToElement(test);

    }
}
