package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PinBar {

    public PinBar(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//div[@class='clearfix']/h3") public WebElement topic;
    @FindBy (xpath = "//button[@title='Pin/unpin the page']") public WebElement pinBarButton;
    @FindBy (xpath = "//li[@class='pin-holder active']/a[.='How To Use Pinbar']") public WebElement pinHolder;
    @FindBy (xpath = "//img") public WebElement image;
}
