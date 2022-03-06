package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class VehicleModel {

    public VehicleModel(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//th//span[1]") public List<WebElement> headerCells;
    @FindBy (xpath = "//td[@class='string-cell grid-cell grid-body-cell grid-body-cell-Vendors']") public WebElement lastCell;

}
