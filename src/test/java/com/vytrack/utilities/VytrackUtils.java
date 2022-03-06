package com.vytrack.utilities;

import com.vytrack.pages.LoginPage;
import com.vytrack.pages.TopMenu;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VytrackUtils {

    private static String username = ConfigurationReader.getProperty("username2");
    private static String password = ConfigurationReader.getProperty("password");

    //This method will log in to CRM, if no username and password provided will use Data from Configuration properties
    public static void login(){
        // Calling webElements from Login Page
        LoginPage loginPage = new LoginPage();
        TopMenu topMenu = new TopMenu();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        //3. Enter valid username
        wait.until(ExpectedConditions.visibilityOf(loginPage.usernameInput));
        loginPage.usernameInput.clear();
        loginPage.usernameInput.sendKeys(username);

        //4. Enter valid password
        wait.until(ExpectedConditions.visibilityOf(loginPage.passwordInput));
        loginPage.passwordInput.clear();
        loginPage.passwordInput.sendKeys(password);

        //5. Click to Log In button
        wait.until(ExpectedConditions.visibilityOf(loginPage.loginButton));
        loginPage.loginButton.click();

        // Verify login successful
        wait.until(ExpectedConditions.visibilityOf(topMenu.homeButton));
        BrowserUtils.verifyTitle("Dashboard");
    }

    public static void login(String username, String password){
        // Calling webElements from Login Page
        LoginPage loginPage = new LoginPage();
        TopMenu topMenu = new TopMenu();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        //3. Enter valid username
        //wait.until(ExpectedConditions.visibilityOf(LoginPage.usernameInput));
        loginPage.usernameInput.clear();
        loginPage.usernameInput.sendKeys(username);

        //4. Enter valid password
        //4. Enter valid password
        wait.until(ExpectedConditions.visibilityOf(loginPage.passwordInput));
        loginPage.passwordInput.clear();
        loginPage.passwordInput.sendKeys(password);

        //5. Click to Log In button
        wait.until(ExpectedConditions.visibilityOf(loginPage.loginButton));
        loginPage.loginButton.click();

        // Verify login successful
        wait.until(ExpectedConditions.visibilityOf(topMenu.homeButton));
        BrowserUtils.verifyTitle("Dashboard");
    }

    public static void login(String username){
        // Calling webElements from Login Page
        LoginPage loginPage = new LoginPage();
        TopMenu topMenu = new TopMenu();

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

        // Enter valid username
        wait.until(ExpectedConditions.visibilityOf(loginPage.usernameInput));
        loginPage.usernameInput.clear();
        loginPage.usernameInput.sendKeys(username);

        // Enter valid password
        wait.until(ExpectedConditions.visibilityOf(loginPage.passwordInput));
        loginPage.passwordInput.clear();
        loginPage.passwordInput.sendKeys(password);;

        // Click to Log In button
        wait.until(ExpectedConditions.visibilityOf(loginPage.loginButton));
        loginPage.loginButton.click();

        // Verify login successful
        wait.until(ExpectedConditions.visibilityOf(topMenu.homeButton));
        BrowserUtils.verifyTitle("Dashboard");
    }

    public static void logout(){
        BrowserUtils.sleep(1);

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

        WebElement userBlock = Driver.getDriver().findElement(By.xpath("//li[@id='user-menu']//a[@class='dropdown-toggle']"));
        wait.until(ExpectedConditions.visibilityOf(userBlock));
        userBlock.click();

        WebElement logoutBtn = Driver.getDriver().findElement(By.xpath("//a[.='Logout']"));
        wait.until(ExpectedConditions.visibilityOf(logoutBtn));
        logoutBtn.click();
    }
}
