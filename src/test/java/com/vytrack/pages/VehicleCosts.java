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

    @FindBy (xpath = "//th//span[1]") public List<WebElement> headerCells;
    @FindBy (xpath = "//td[@class='date-cell grid-cell grid-body-cell grid-body-cell-Date']") public WebElement actionCell;
    @FindBy (xpath = "//th//input[@type='checkbox']") public WebElement firstCheckBox;
    @FindBy (xpath = "//td//input[@type='checkbox']") public List<WebElement> allCheckBoxes;
    @FindBy (xpath = "//tr[1]/td[@class='string-cell grid-cell grid-body-cell grid-body-cell-Type']") public WebElement cellType;
    @FindBy (xpath = "//tr[1]//td[@class='number-cell grid-cell grid-body-cell grid-body-cell-TotalPrice']") public WebElement cellPrice;
    @FindBy (xpath = "//tr[1]/td[@class='date-cell grid-cell grid-body-cell grid-body-cell-Date']") public WebElement cellDate;
    @FindBy (xpath = "//span[.='Type']/..") public WebElement firstFilter;
    @FindBy (xpath = "//span[.='Total Price']/..") public WebElement secondFilter;
    @FindBy (xpath = "//span[.='Date']/..") public WebElement thirdFilter;
}
