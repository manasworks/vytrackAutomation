package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class VehicleCosts {

    public VehicleCosts(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//th//span[1]")
    public List<WebElement> headerCells;

    @FindBy (xpath = "//td[@class='date-cell grid-cell grid-body-cell grid-body-cell-Date']")
    public WebElement actionCell;

    @FindBy (xpath = "//th//input[@type='checkbox']")
    public WebElement firstCheckBox;

    @FindBy (xpath = "//td//input[@type='checkbox']")
    public List<WebElement> allCheckBoxes;
}
