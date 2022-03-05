package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VehicleModel {

    public VehicleModel(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // 1 Column name
    @FindBy (xpath = "//tr/th[2]/a/span") public WebElement column1;
    @FindBy (xpath = "//tr/th[3]/a/span") public WebElement column2;
    @FindBy (xpath = "//tr/th[4]/a/span") public WebElement column3;
    @FindBy (xpath = "//tr/th[5]/a/span") public WebElement column4;
    @FindBy (xpath = "//tr/th[6]/a/span") public WebElement column5;
    @FindBy (xpath = "//tr/th[7]/a/span") public WebElement column6;
    @FindBy (xpath = "//tr/th[8]/a/span") public WebElement column7;
    @FindBy (xpath = "//tr/th[9]/a/span") public WebElement column8;
    @FindBy (xpath = "//tr/th[10]/a/span") public WebElement column9;
    @FindBy (xpath = "//tr/th[11]/a/span") public WebElement column10;
}
