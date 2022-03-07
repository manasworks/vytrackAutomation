package com.vytrack.tests;

import com.vytrack.pages.TopMenu;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CY19_63 extends TestBase{

    @Test (dataProvider = "managers")
    public void testMainModulesManagers(String username) {
        //AC #1: store and sales managers should view 8 module names.
        //Expected module names: Dashboards, Fleet, Customers, Sales, Activities, Marketing, Reports & Segments, System

        VytrackUtils.login(username);
        TopMenu topMenu = new TopMenu();

        List<String> actualModuleNames = new ArrayList<>();
        List<String> expectedModuleNames = new ArrayList<>(Arrays.asList(
                "Dashboards", "Fleet", "Customers", "Sales", "Activities", "Marketing", "Reports & Segments", "System"
        ));

        for (WebElement each : topMenu.allModuleElements) {
            actualModuleNames.add(each.getText());
        }

        Assert.assertEquals(actualModuleNames.size(), 8);
        Assert.assertEquals(actualModuleNames, expectedModuleNames);
    }

    @Test (dataProvider = "drivers")
    public void testMainModulesDriver(String username) {
        //AC #2: drivers should view 4 module names
        //Expected module names: Fleet, Customers, Activities, System

        VytrackUtils.login(username);
        TopMenu topMenu = new TopMenu();

        List<String> actualModuleNames = new ArrayList<>();
        List<String> expectedModuleNames = new ArrayList<>(Arrays.asList(
                "Fleet", "Customers", "Activities", "System"
        ));

        for (WebElement each : topMenu.allModuleElements) {
            actualModuleNames.add(each.getText());
        }

        Assert.assertEquals(actualModuleNames.size(), 4);
        Assert.assertEquals(actualModuleNames, expectedModuleNames);

    }
}
