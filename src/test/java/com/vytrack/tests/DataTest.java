package com.vytrack.tests;

import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.VytrackUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataTest{


    @Test (dataProvider = "allUsers")
    public void testName(String user) {
        System.out.println(user);
    }
}
