package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webDriver.Singleton;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginPage extends AbstractPage {
    private static final String SELECT_URL_FROM_WEBPAGES = "SELECT URL FROM webpages";
    private static final String LOGIN = "SELECT name FROM User";
    private static final String PASSWORD = "SELECT password FROM User";

    @FindBy(id = "mailbox:login")
    private WebElement loginField;

    @FindBy(xpath = ".//a[@class ='logo__img']")
    private WebElement logoField;

    @FindBy(xpath = ".//input[@name='q']")
    private WebElement searchFileldOnMailRu;

    @FindBy(xpath = ".//div[@id='suggests-list']//div")
    private List<WebElement> listItemsOfSuggests;

    @FindBy(id = "mailbox:password")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id='mailbox:submit']/input")
    private WebElement buttonEnter;

    @FindBy(xpath = "//*[@id='PH_logoutLink']")
    private WebElement logoutLink;

    @FindBy(xpath = "//*[@id='mailbox:error']")
    public WebElement logoutLinkError;


    public LoginPage(WebDriver webdriver) {
        PageFactory.initElements(webdriver, this);
        this.webDriver = webdriver;
    }


    public void enterLoginAndPass() {
        loginField.clear();
        loginField.sendKeys("egor6661999");
       // loginField.sendKeys(dataBase.createQuery(LOGIN, 1));
        passwordField.clear();
        passwordField.sendKeys("Isaac96Soles13");
       // passwordField.sendKeys(dataBase.createQuery(PASSWORD, 1));
    }

    public void clickEnterButton() {
        buttonEnter.click();
    }

    public boolean logoutLinkPresents() {
       return waitForWebElementPresent(logoutLink);

    }
    public boolean logoMailRuPresents() {
        return waitForWebElementPresent(loginField);
    }

    public void enterTreeSymbols() {
        searchFileldOnMailRu.clear();
        searchFileldOnMailRu.sendKeys("sfg");
    }

    public int countsOfSuggests() {
       return listItemsOfSuggests.size();
    }
}