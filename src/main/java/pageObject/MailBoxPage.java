package pageObject;

import dataBase.DataBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webDriver.SingletoneWebDriver;
import java.sql.SQLException;
import java.util.List;

public class MailBoxPage extends AbstractPage {

    private WebDriver singletoneWebDriver = SingletoneWebDriver.getSingletoneWebDriver();
    private MailBoxPage mailBox;
    private List<WebElement> checkBoxOfMessage;
    private List<WebElement> checkBoxOfMessageAfterSelected;
    private WebElement spamButton;
    private WebElement spamSection;
    private WebElement nospamButton;
    private WebElement inboxButton;
    private WebElement unselectAllButton;
    private WebElement writeMailButton;
    private WebElement fieldOfToWhom;
    private WebElement changeFrame;
    private WebElement fieldOfMessage;
    private WebElement sendButton;
    private WebElement textInWindow;

    public MailBoxPage(WebDriver singletoneWebDriver) {
        super(singletoneWebDriver);
    }

    public void tipMessage() {
        checkBoxOfMessage = singletoneWebDriver.findElements(By.xpath(".//div[@class='js-checkbox b-checkbox']//div[@class='b-checkbox__box']"));
        checkBoxOfMessage.get(0).click();
    }

    public void tipMessageinSpam() {
        checkBoxOfMessage = singletoneWebDriver.findElements(By.xpath(".//div[@class='js-checkbox b-checkbox']//div[@class='b-checkbox__box']"));
        checkBoxOfMessage.get(2).click();
    }

    public void tipTreeMessageinSpam() {
        checkBoxOfMessage = singletoneWebDriver.findElements(By.xpath(".//div[@class='js-checkbox b-checkbox']//div[@class='b-checkbox__box']"));
        checkBoxOfMessage.get(2).click();
        checkBoxOfMessage.get(1).click();
        checkBoxOfMessage.get(0).click();
    }

    public int getCountOfSelectedChecboxes() {
        checkBoxOfMessageAfterSelected = singletoneWebDriver.findElements(By.xpath("//div[@class='js-checkbox b-checkbox b-checkbox_checked']"));
        return checkBoxOfMessageAfterSelected.size();
    }

    public void unselectAll() {
        unselectAllButton = singletoneWebDriver.findElement(By.xpath(".//div[@id='b-toolbar__right']//div[@dataBase-cache-key='0_undefined_false']//div[@class='b-checkbox__checkmark']"));
        unselectAllButton.click();
    }

    public void moveMessageToSpam() {
        spamButton = singletoneWebDriver.findElement(By.xpath(".//div[@title='Спам (J)']"));
        spamButton.click();
    }

    public String getTextFromSpamSection() {
        spamSection = singletoneWebDriver.findElement(By.xpath(".//span[contains(@class,'b-nav__item__text') and text() ='Спам']"));
        return spamSection.getAttribute("innerText");
    }

    public void goToSpam() {
        spamSection = singletoneWebDriver.findElement(By.xpath(".//span[contains(@class,'b-nav__item__text') and text() ='Спам']"));
        try {
            spamSection.click();
        } catch (org.openqa.selenium.StaleElementReferenceException ex) {
            spamSection.click();
        }
    }

    public void moveMessageToInput() {
        nospamButton = singletoneWebDriver.findElement(By.xpath(".//div[@title='Не спам (J)']"));
        nospamButton.click();
    }

    public void goToInboxDerection() {
        inboxButton = singletoneWebDriver.findElement(By.xpath(".//span[contains(text(),'Входящие')]"));
        inboxButton.click();
    }

    public MailBoxPage goToWriteSection() {
        writeMailButton = singletoneWebDriver.findElement(By.xpath(".//div[@id='b-toolbar__left']//div//a[contains(@class,'b-toolbar__btn b-toolbar__btn_with-foldings js-shortcut')]"));
        writeMailButton.click();
        return mailBox;
    }

    public MailBoxPage enterToWhom() throws SQLException {
        DataBase dataBase = new DataBase();
        fieldOfToWhom = singletoneWebDriver.findElement(By.xpath(".//textarea[@data-original-name='To']"));
        fieldOfToWhom.clear();
        fieldOfToWhom.sendKeys(dataBase.getEmail(1));
        return mailBox;
    }

    public MailBoxPage enterMessage() throws SQLException {
        DataBase dataBase = new DataBase();
        changeFrame = singletoneWebDriver.findElement(By.xpath(".//iframe[@allowtransparency=\"true\"]"));
        fieldOfMessage = singletoneWebDriver.findElement(By.xpath(".//body[@id='tinymce']"));
        singletoneWebDriver.switchTo().frame(changeFrame);
        fieldOfMessage.click();
        fieldOfMessage.clear();
        fieldOfMessage.sendKeys(dataBase.getText(1));
        singletoneWebDriver.switchTo().defaultContent();
        return mailBox;
    }

    public MailBoxPage clickSendButton() {
        sendButton = singletoneWebDriver.findElement(By.xpath(".//div[@id='b-toolbar__right']//div//div[@class='b-toolbar__btn b-toolbar__btn_ b-toolbar__btn_false js-shortcut']"));
        sendButton.click();
        return mailBox;
    }

    public boolean messageIsPresent() {
        textInWindow = singletoneWebDriver.findElement(By.xpath(".//div[@class='message-sent__title']"));
        return (new WebDriverWait(singletoneWebDriver, 3000)).until(ExpectedConditions.visibilityOf(textInWindow)).isDisplayed();
    }

}
