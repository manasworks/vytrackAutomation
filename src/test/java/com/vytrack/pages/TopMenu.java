package com.vytrack.pages;

import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TopMenu {

    public TopMenu(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    // HomeButton
    @FindBy (xpath = "//h1//a[@title='Fleet Management']") public WebElement homeButton;
    @FindBy (xpath = "//div/a[@href='/pinbar/help']") public WebElement pinBarHelp;

    // Top right icons
    @FindBy (xpath = "//a[@class='help no-hash']") public WebElement getHelpIcon;

    // Warning Message
    @FindBy (xpath = "//div[@class='message']") public WebElement warningMessage;

    // Warning message close button
    @FindBy (xpath = "//button[@class='close']") public WebElement warningCloseBtn;

    // Main Menu Elements
    @FindBy (xpath = "//span[@class='title title-level-1']") public List<WebElement> allModuleElements;
    @FindBy (xpath = "//div[@id='main-menu']/ul/li/a/span[contains(text(),'Dashboard')]") public WebElement dashboardLink;
    @FindBy (xpath = "//div[@id='main-menu']/ul/li/a/span[contains(text(),'Fleet')]") public WebElement fleetLink;
    @FindBy (xpath = "//div[@id='main-menu']/ul/li/a/span[contains(text(),'Customers')]") public WebElement customersLink;
    @FindBy (xpath = "//div[@id='main-menu']/ul/li/a/span[contains(text(),'Sales')]") public WebElement salesLink;
    @FindBy (xpath = "//div[@id='main-menu']/ul/li/a/span[contains(text(),'Activities')]") public WebElement activitiesLink;
    @FindBy (xpath = "//div[@id='main-menu']/ul/li/a/span[contains(text(),'Marketing')]") public WebElement marketingLink;
    @FindBy (xpath = "//div[@id='main-menu']/ul/li/a/span[contains(text(),'Report')]") public WebElement reportsLink;
    @FindBy (xpath = "//div[@id='main-menu']/ul/li/a/span[contains(text(),'System')]") public WebElement systemLink;

    // Fleet Sub elements
    @FindBy (xpath = "//span[.='Vehicles']/../..") public WebElement fleetSub_Vehicles;
    @FindBy (xpath = "//span[.='Vehicle Odometer']/../..") public WebElement fleetSub_VehiclesOdometer;
    @FindBy (xpath = "//span[.='Vehicle Costs']/../..") public WebElement fleetSub_VehiclesCosts;
    @FindBy (xpath = "//span[.='Vehicle Contracts']/../..") public WebElement fleetSub_VehiclesContracts;
    @FindBy (xpath = "//span[.='Vehicles Fuel Logs']/../..") public WebElement fleetSub_VehiclesFuelLogs;
    @FindBy (xpath = "//span[.='Vehicle Services Logs']/../..") public WebElement fleetSub_VehiclesServiceLogs;
    @FindBy (xpath = "//span[.='Vehicles Model']/../..") public WebElement fleetSub_VehiclesModels;

    // Dashboard sub elements
    @FindBy (xpath = "//span[.='Dashboard']/../..") public WebElement dashboardSub_Dashboard;
    @FindBy (xpath = "//span[.='Manage Dashboards']/../..") public WebElement dashboardSub_ManageDashboards;

    // Activities sub elements
    @FindBy (xpath = "//span[.='Calendar Events']/../..") public WebElement activitiesSubCalendar;

    // Customers sub elements
    @FindBy (xpath = "//span[.='Accounts']/../..") public WebElement customersSubAccounts;

    // Marketing sub elements
    @FindBy (xpath = "//span[.='Campaigns']/../..") public WebElement marketingSubCampaigns;

}
