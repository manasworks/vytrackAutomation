package com.vytrack.tests;

import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

public abstract class TestBase {

    private static final String env = ConfigurationReader.getProperty("env1");

    // Data for different User Types
    @DataProvider(name="userTypes")
    public Object[][] userGroups(){
        return new Object[][]{
                {ConfigurationReader.getProperty("username1")},
                {ConfigurationReader.getProperty("username2")},
                {ConfigurationReader.getProperty("username3")},
        };
    }

    // Data for all Users
    @DataProvider(name="allUsers")
    public Object[][] allUsers(){
        return new Object[][]{
                {ConfigurationReader.getProperty("username1")},
                {ConfigurationReader.getProperty("username2")},
                {ConfigurationReader.getProperty("username3")},
                {ConfigurationReader.getProperty("username4")},
                {ConfigurationReader.getProperty("username5")},
                {ConfigurationReader.getProperty("username6")},
        };
    }

    // Data for Drivers users
    @DataProvider(name="drivers")
    public Object[][] drivers(){
        return new Object[][]{
                {ConfigurationReader.getProperty("username1")},
                {ConfigurationReader.getProperty("username4")},
        };
    }

    // Data for Store Managers users
    @DataProvider(name="storeManagers")
    public Object[][] storeManagers(){
        return new Object[][]{
                {ConfigurationReader.getProperty("username2")},
                {ConfigurationReader.getProperty("username5")},
        };
    }

    // Data for Sales Managers users
    @DataProvider(name="salesManagers")
    public Object[][] salesManagers(){
        return new Object[][]{
                {ConfigurationReader.getProperty("username3")},
                {ConfigurationReader.getProperty("username6")},
        };
    }

    // Data for All Managers users
    @DataProvider(name="managers")
    public Object[][] managers(){
        return new Object[][]{
                {ConfigurationReader.getProperty("username2")},
               // {ConfigurationReader.getProperty("username5")},
               // {ConfigurationReader.getProperty("username3")},
               // {ConfigurationReader.getProperty("username6")},
        };
    }

    @BeforeMethod
    public void setUp() {
        //Go to VY TRACK Page
        Driver.getDriver().get(env);
    }

    @AfterMethod
    public void tearDown() {
        VytrackUtils.logout();
        Driver.closeDriver();
    }
}
