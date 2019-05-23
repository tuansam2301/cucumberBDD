package steps;

import cucumber.TestContext;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.TravelPage;

import java.util.Map;

public class TravelSteps {
    TestContext testContext;
    TravelPage travelPage;

    public TravelSteps(TestContext context) {
        testContext = context;
        travelPage = testContext.getPageObjectManager().getTravelPage();
    }

    @Then("^I should see at least (\\d+) cards are being displayed$")
    public void iShouldSeeLeastCardsAreBeingDisplayed(int expectedCardCount) {
        Assert.assertTrue(travelPage.getCardCount() > expectedCardCount);
    }

    @When("^I sort by \"([^\"]*)\"$")
    public void iSortBy(String option) {
        travelPage.selectSort(option);
    }

    @And("^I set details as below$")
    public void iSetDetailsAsBelow(Map<String, String> details) {
        travelPage.selectDestination(details.get("DESTINATION"));
        travelPage.setStartDate(details.get("START_DATE"));
        travelPage.setEndDate(details.get("END_DATE"));
    }

    @And("^I set filter as below$")
    public void iSetFilterAsBelow(Map<String, String> filters) {
        travelPage.chooseInsurers(filters.get("INSURERS"));
    }

    @And("^I set trip termination range min equals max$")
    public void iSetTripTerminationRangeMinEqualsMax() {
        travelPage.setTerminationRangeMixToMax();
    }

    @Then("^I should see (\\d+) cards are being displayed$")
    public void iShouldSeeCardsAreBeingDisplayed(int expectedCardCount) {
        Assert.assertEquals(expectedCardCount, travelPage.getCardCount());
    }

    @And("^there should be \"([^\"]*)\" text in header$")
    public void thereShouldBeTextInHeader(String expectedPlanFound) {
        Assert.assertEquals(expectedPlanFound, travelPage.getPlanFound());
    }
}
