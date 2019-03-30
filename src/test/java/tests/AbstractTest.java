package tests;

import dataBase.DataBase;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import pageObject.LoginPage;
import webDriver.SingletoneWebDriver;


import java.sql.SQLException;

public class AbstractTest {
    protected DataBase dataBase = new DataBase();
    protected static WebDriver singletoneWebDriver;
    protected static LoginPage loginPage;

    @BeforeClass
    public static void setUpDriver() {
        singletoneWebDriver = SingletoneWebDriver.getSingletoneWebDriver();

        singletoneWebDriver.manage().window().maximize();
        loginPage = new LoginPage(singletoneWebDriver);
    }

    @Before
    public void navigateToLoginPage()  {
        loginPage.navigateToMail();
    }

    @After
    public void quitFromMail() {
        loginPage.quitFromMail();
    }

    @AfterClass
    public static void closeResources() {
       // singletoneWebDriver.quit();
    }

}
