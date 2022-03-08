package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Campaigns {

    public Campaigns(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//a[@title='Filters']") public WebElement filters;
    @FindBy (xpath = "//a[@class='add-filter-button']") public WebElement manageFilters;
    @FindBy (xpath = "//label/input[@type='checkbox']") public List<WebElement> filterCheckboxes;
}
