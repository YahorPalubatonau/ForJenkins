package pageObject;

import dataBase.DataBase;
import org.openqa.selenium.WebDriver;
import webDriver.SingletoneWebDriver;

import java.sql.SQLException;

public class AbstractPage {

	public WebDriver singletoneWebDriver=SingletoneWebDriver.getSingletoneWebDriver();
	
	AbstractPage(WebDriver singletoneWebDriver) {
        this.singletoneWebDriver = SingletoneWebDriver.getSingletoneWebDriver();
    }

	public void navigateToMail() {
		DataBase dataBase = new DataBase();
		singletoneWebDriver.manage().window().maximize();
		try {
			singletoneWebDriver.get(String.valueOf(dataBase.getURL()));
		} catch (SQLException e) {
			e.printStackTrace();e.printStackTrace();
		}
	}

}
