package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VehicleOdometer {

    public VehicleOdometer(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//input[@type='number']") public WebElement pageNumber;
    @FindBy (xpath = "//button[@class='btn dropdown-toggle ']") public WebElement viewPerPage;
    @FindBy (xpath = "//td[@class='action-cell grid-cell grid-body-cell']") public WebElement lastCell;
}
