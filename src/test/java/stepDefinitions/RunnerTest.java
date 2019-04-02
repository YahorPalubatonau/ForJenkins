package stepDefinitions;

import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pageObjects.AbstractPage;
import pageObjects.MailBoxPage;
import webDriver.Singleton;


@CucumberOptions(features = {"src/test/resources/features/"},
        tags = {"@Run"})
public class RunnerTest extends AbstractTestNGCucumberTests {
    //private MailBoxPage mailBoxPage = new MailBoxPage(Singleton.getSingletoneWebDriver());

   /* @BeforeClass(alwaysRun = true)
    public void getWebDriver() {
        AbstractPage abstractPage = new AbstractPage();
        abstractPage.getWebDriver();
    }

    @After(value = "~@MailRu")
    public void afterScenario() {
        mailBoxPage.quitFromMail();
    }

    @AfterClass(alwaysRun = true)
    public static void closeResources() {
        Singleton.getSingletoneWebDriver().quit();
    }*/


}