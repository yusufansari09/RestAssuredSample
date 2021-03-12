package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import serviceEndpoints.rates.clients.RatesServiceClient;
import serviceEndpoints.rates.response.GetRatesResponse;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class SpecifiDatedFERSteps {

    RatesServiceClient specificDateClient;
    GetRatesResponse getSpecificDateResponse;
    public static final String date = "2019-01-12";

    @When("^specific date rates API is available$")
    public void initializeSpecificDateRatesClient() {
        specificDateClient = new RatesServiceClient();
    }

    @Then("^specific date rates response status should be (\\d+)$")
    public void verifySpecificDateRateStatus(Integer status) {
        getSpecificDateResponse = specificDateClient.getRates(date);
        Assert.assertEquals(getSpecificDateResponse.getHttpStatusCode(), status.intValue());
    }

    @Then("the response for specific date for (\\w+) should match$")
    public void theResponseForSpecificDateForGBPShouldMatch(String symbol) {
        getSpecificDateResponse = specificDateClient.getRatesForSymbols(date, symbol);
        assertThat(getSpecificDateResponse.getBase(), is(equalTo("EUR")));
    }

    @When("user hits a future date rates API")
    public void userHitsAFutureDateRatesAPI() {
        getSpecificDateResponse = specificDateClient.getRates(date);
    }
}
