package com.vytrack.tests;

import com.vytrack.pages.TopMenu;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CY19_64 extends TestBase{

    @Test (dataProvider = "userTypes")
    public void testOroincDocumentation(String username) {
        // AC #1: users access the Oronic Documentation page by clicking the question icon.
        // The page URL: https://doc.oroinc.com/

        VytrackUtils.login(username);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        TopMenu topMenu = new TopMenu();

        //Storing the main page's window handle as string
        String mainHandle = Driver.getDriver().getWindowHandle();

        // Click help icon
        wait.until(ExpectedConditions.visibilityOf(topMenu.getHelpIcon));
        topMenu.getHelpIcon.click();

        // Switch to new Window.
        BrowserUtils.sleep(1);
        for(String each: Driver.getDriver().getWindowHandles()){
            Driver.getDriver().switchTo().window(each);
        }

        // Validate user on Oronic Documentation page
        BrowserUtils.sleep(1);
        Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://doc.oroinc.com/");

        // Switch back to VyTrack page
        Driver.getDriver().switchTo().window(mainHandle);

        // Validate user on VyTrack page
        Assert.assertEquals(Driver.getDriver().getTitle(), "Dashboard");
    }

}
