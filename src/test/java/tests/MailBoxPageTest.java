package tests;

import org.junit.Assert;
import org.junit.Test;
import pageObject.MailBoxPage;
import java.sql.SQLException;

public class MailBoxPageTest extends AbstractTest {
    private FacadeForTestEmptySpamBox facadeForMethodEmptySpamBox = new FacadeForTestEmptySpamBox();
    protected MailBoxPage mailBoxPage = new MailBoxPage(singletoneWebDriver);

    @Test
    public void lingOutTest() throws SQLException {
        loginPage.enterInMail(dataBase.getName(), dataBase.getPassword());
        Assert.assertTrue(loginPage.logOutLinkPresents().isDisplayed());
    }

    @Test
    public void noEmptySpamBoxTest() throws SQLException {
        loginPage.enterInMail(dataBase.getName(), dataBase.getPassword());
        loginPage.logOutLinkPresents();
        mailBoxPage.tipMessageinSpam();
        mailBoxPage.tipMessage();
        mailBoxPage.moveMessageToSpam();
        Assert.assertFalse(mailBoxPage.getTextFromSpamSection().contains(dataBase.getWordsForTest()));
    }

    @Test
    public void emptySpamBox() throws SQLException {
     //Facade
        Assert.assertTrue(facadeForMethodEmptySpamBox.facadeForPageObject().contains(dataBase.getWordsForTest()));
    }

    @Test
    public void selectTest() throws SQLException {
        loginPage.enterInMail(dataBase.getName(), dataBase.getPassword());
        loginPage.logOutLinkPresents();
        mailBoxPage.goToInboxDerection();
        mailBoxPage.tipTreeMessageinSpam();
        Assert.assertEquals(3, mailBoxPage.getCountOfSelectedChecboxes());
    }

    @Test
    public void unselectTest() throws SQLException {
        loginPage.enterInMail(dataBase.getName(), dataBase.getPassword());
        loginPage.logOutLinkPresents();
        mailBoxPage.tipTreeMessageinSpam();
        mailBoxPage.unselectAll();
        Assert.assertEquals(0, mailBoxPage.getCountOfSelectedChecboxes());
    }

    @Test
    public void sendMessageTest() throws SQLException {
        loginPage.enterInMail(dataBase.getName(), dataBase.getPassword());
        loginPage.logOutLinkPresents();
        //Fluent - Chain of invocations pattern
        mailBoxPage.goToWriteSection()
                .enterToWhom()
                .enterMessage()
                .clickSendButton();
        Assert.assertTrue(mailBoxPage.messageIsPresent());
    }
}
