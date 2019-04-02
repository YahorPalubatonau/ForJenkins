package stepDefinitions;

import api.VkAPIConnect;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.http.HttpStatus;
import org.apache.log4j.Logger;
import org.testng.Assert;


public class APISteps {
    private static final Logger logger = Logger.getLogger(APISteps.class);

    private VkAPIConnect apiConnect = new VkAPIConnect();

    @When("^user enters comment$")
    public void enterCommit() {
        apiConnect.addCommitOnWall();
        logger.error("Some errors");
    }

    @Then("^user can sees new comment on VK wall$")
    public void checkNewCommit() {
        Assert.assertEquals(apiConnect.getHttpResponseForAddCommit().getStatusLine().getStatusCode(), HttpStatus.SC_OK);
        logger.trace("Check is run");
    }

    @When("^user corrected comment$")
    public void correctCommit() {
        apiConnect.editCommit();
        logger.trace("Step for second test");
    }

    @Then("^user sees the corrected comment$")
    public void checkCorrectedСomment() {
        logger.info("Run second test");
        Assert.assertEquals(apiConnect.getHttpResponseForEdit().getStatusLine().getStatusCode(), HttpStatus.SC_OK);
    }
}
