import cucumber.api.java.After;
import cucumber.api.java.Before;
import pageObjects.AbstractPage;
import pageObjects.MailBoxPage;

public class Hooks extends AbstractPage {
    private MailBoxPage mailBoxPage=new MailBoxPage(webDriver);

    @Before
    public void beforeScenario(){
        System.out.println("Scenario runs");
    }

    @After
    public void afterScenario(){
        mailBoxPage.quitFromMail();
    }
}
