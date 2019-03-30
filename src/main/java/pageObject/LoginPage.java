package pageObject;

import mx4j.log.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webDriver.SingletoneWebDriver;

public class LoginPage extends AbstractPage {

    private static final int LINK_PRESENSE_TIMEOUT = 20;
    private WebElement loginField;
    private WebElement passwordField;
    private WebElement buttonEnter;
    private WebElement logoutLink;
    WebDriver singletoneWebDriver = SingletoneWebDriver.getSingletoneWebDriver();

    public LoginPage(WebDriver singletoneWebDriver) {
        super(singletoneWebDriver);
    }

    public void enterInMail(String login, String password) {
        loginField = singletoneWebDriver.findElement(By.id("mailbox:login"));
        loginField.clear();
        loginField.sendKeys(login);
        passwordField = singletoneWebDriver.findElement(By.id("mailbox:password"));
        passwordField.clear();
        passwordField.sendKeys(password);
        buttonEnter = singletoneWebDriver.findElement(By.xpath(".//*[@id='mailbox:submit']/input"));
        buttonEnter.click();
    }

    public void quitFromMail() {
        logoutLink = singletoneWebDriver.findElement(By.xpath(".//*[@id='PH_logoutLink']"));
        logoutLink.click();
    }

    public WebElement logOutLinkPresents() {
        try {
            System.out.println("Hey");
            logoutLink = singletoneWebDriver.findElement(By.id("PH_logoutLink"));
            new WebDriverWait(singletoneWebDriver, LINK_PRESENSE_TIMEOUT).until(ExpectedConditions.visibilityOf(logoutLink));
            return logoutLink;
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            logoutLink = singletoneWebDriver.findElement(By.id("PH_logoutLink"));
            return logoutLink;
        }
     /*   logoutLink = singletoneWebDriver.findElement(By.id("PH_logoutLink"));
        return (new WebDriverWait(singletoneWebDriver, LINK_PRESENSE_TIMEOUT).until(ExpectedConditions.visibilityOf(logoutLink))
                .isDisplayed());*/
    }

}
