package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Calendar {

    public Calendar(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (xpath = "//a[@class='btn main-group btn-primary pull-right ']") public WebElement createEvent;
    @FindBy (xpath = "//input[@data-name='recurrence-repeat']") public WebElement repeatCheckbox;
    @FindBy (xpath = "//input[@class='recurrence-subview-control__number']") public WebElement daysInput;
    @FindBy (xpath = "//span[@class='validation-failed']/span/span") public WebElement errorMessage;
    @FindBy (xpath = "//input[@name='oro_calendar_event_form[title]']") public WebElement inputTitle;
    @FindBy (xpath = "//iframe") public WebElement iframe;
    @FindBy (xpath = "//body") public WebElement textBody;
    @FindBy (xpath = "//p") public WebElement message;
}
