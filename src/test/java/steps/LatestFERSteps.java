package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

    @Then("^the response status for (\\w+) foreign exchange rates should be (\\d+)$")
    public void verifyResponse(String latest, Integer status) {
        getRatesResponse = latestRateClient.getRates(latest);
        assertThat(getRatesResponse.getHttpStatusCode(), is(equalTo(status)));
    }

    @And("^user hits an invalid URL")
    public void hitWithInvalidURL() {
        getRatesResponse = latestRateClient.getRatesError();
    }

    @Then("^user should get error message")
    public void verifyErrorForInvalidURL() {
        assertThat(getRatesResponse.getError(), is(equalTo("time data 'api' does not match format '%Y-%m-%d'")));
    }

    @Then("^the response for (\\w+) rates for (\\w+) should match$")
    public void verifyResponsBody(String latest, String symbol) {
        GetRatesResponse getratesForSymbol = latestRateClient.getRatesForSymbols(latest, symbol);

        assertThat(getratesForSymbol.getBase(), is(equalTo("EUR")));
//        assertThat(getratesForSymbol.getRates().getUSD(), is(equalTo("1.1892")));
    }
}
