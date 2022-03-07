package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Vehicle {

    public Vehicle (){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//tr[1]//div[@class='more-bar-holder']/div") public WebElement dots;
    @FindBy (xpath = "//tr[1]//div[@class='more-bar-holder']//li[1]/a") public WebElement icon1;
    @FindBy (xpath = "//tr[1]//div[@class='more-bar-holder']//li[2]/a") public WebElement icon2;
    @FindBy (xpath = "//tr[1]//div[@class='more-bar-holder']//li[3]/a") public WebElement icon3;
    @FindBy (xpath = "//tr[25]//td[20]") public WebElement lastCell;
}
