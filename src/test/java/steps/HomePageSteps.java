package steps;

import cucumber.TestContext;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pages.HomePage;

public class HomePageSteps {

    TestContext testContext;
    HomePage homePage;

    public HomePageSteps(TestContext context){
        testContext = context;
        homePage = testContext.getPageObjectManager().getHomePage();
    }

    @Given("^I am on UAT page$")
    public void iAmOnUatPage() {
        homePage.navigateToHomePage();
    }

    @When("^I am looking for travel insurance$")
    public void iAmLookingForTravelInsurance() {
        homePage.openTravel();
        homePage.submitForm();
    }
}
