package tests;


import pageObject.MailBoxPage;

import java.sql.SQLException;

public class FacadeForTestEmptySpamBox extends AbstractTest {

    private MailBoxPage mailBoxPage = new MailBoxPage(singletoneWebDriver);

    public String facadeForPageObject() {
        try {
            loginPage.enterInMail(dataBase.getName(), dataBase.getPassword());
        } catch (SQLException e) {
            System.out.println("Can't receive name or password from data base.");
            e.printStackTrace();
        }
        loginPage.logOutLinkPresents();
        mailBoxPage.goToSpam();
        mailBoxPage.tipMessage();
        mailBoxPage.moveMessageToInput();
        return mailBoxPage.getTextFromSpamSection();
    }
}