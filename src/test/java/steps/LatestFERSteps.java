package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.HttpStatus;
import serviceEndpoints.rates.clients.RatesServiceClient;
import serviceEndpoints.rates.response.GetRatesResponse;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class LatestFERSteps {

    RatesServiceClient latestRateClient;
    GetRatesResponse getRatesResponse;

    @When("^rates API is available$")
    public void initializeLatestRatesClient() {
        latestRateClient = new RatesServiceClient();
    }

    @Then("^the response status for latest foreign exchange rates should be 200$")
    public void verifyResponse() {
        assertThat(getRatesResponse.getHttpStatusCode(), is(equalTo(HttpStatus.SC_OK)));
    }

    @When("^user hits an invalid URL")
    public void hitWithInvalidURL() {
        getRatesResponse = latestRateClient.getRatesError();
    }

    @Then("^user should get error message")
    public void verifyErrorForInvalidURL() {
        assertThat(getRatesResponse.getError(), is(equalTo("time data 'api' does not match format '%Y-%m-%d'")));
    }

    @Then("^the response for latest rates for USD should match$")
    public void verifyResponsBody() {
        assertThat(getRatesResponse.getBase(), is(equalTo("EUR")));
        assertThat(getRatesResponse.getRates().getUSD(), is(instanceOf(String.class)));
    }

    @When("user calls rates API for (\\w+) foreign exchange rate$")
    public void userCallsRatesAPI(String latest) {
        getRatesResponse = latestRateClient.getRates(latest);
    }

    @When("user calls rates API for (\\w+) foreign exchange rate for (\\w+) symbol$")
    public void userCallsRatesAPI(String latest, String symbol) {
        getRatesResponse = latestRateClient.getRatesForSymbols(latest, symbol);
    }
}
