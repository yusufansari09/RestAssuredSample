package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpStatus;
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

    @Then("^specific date rates response status should be 200$")
    public void verifySpecificDateRateStatus() {
        Assert.assertEquals(getSpecificDateResponse.getHttpStatusCode(), HttpStatus.SC_OK);
    }

    @Then("the response for specific date for GBP should match$")
    public void theResponseForSpecificDateForGBPShouldMatch() {
        assertThat(getSpecificDateResponse.getBase(), is(equalTo("EUR")));
        assertThat(getSpecificDateResponse.getRates().getGBP(), is(instanceOf(String.class)));
    }

    @When("user hits a future date rates API")
    public void userHitsAFutureDateRatesAPI() {
        getSpecificDateResponse = specificDateClient.getRates(date);
    }

    @When("user calls rates API for specific date")
    public void userCallsRatesAPIForSpecificDate() {
        getSpecificDateResponse = specificDateClient.getRates(date);
    }

    @When("user calls rates API for specific date for GBP symbol")
    public void userCallsRatesAPIForSpecificDateForGBPSymbol(String symbol) {
        getSpecificDateResponse = specificDateClient.getRatesForSymbols(date, symbol);
    }
}
