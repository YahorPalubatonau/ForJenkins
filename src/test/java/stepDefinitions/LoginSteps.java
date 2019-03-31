package stepDefinitions;

import cucumber.api.java.en.When;
import pageObjects.LoginPage;
import pageObjects.AbstractPage;


public class LoginSteps extends AbstractPage {

    private LoginPage loginPage = new LoginPage(webDriver);

    @When("^user login in mailBox$")
    public void loginToMailBox() {
        loginPage.enterLoginAndPass();
        loginPage.clickEnterButton();
        loginPage.logoutLinkPresents();
    }


}

