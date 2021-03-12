package unitTests;

import constants.TestCategories;
import org.testng.annotations.Test;
import serviceEndpoints.rates.clients.RatesServiceClient;
import serviceEndpoints.rates.response.GetRatesResponse;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

public class RatesServiceHealthCheckTest {

    @Test(groups = TestCategories.SMOKE)
    public void verifyLatestRatesServiceHealth() {
        RatesServiceClient getLatestRates = new RatesServiceClient();
        GetRatesResponse getRatesResponse = getLatestRates.getRates("latest");
        assertThat(getRatesResponse.getHttpStatusCode(), is(equalTo(200)));
    }

    @Test(groups = TestCategories.SMOKE)
    public void verifyRatesByDateServiceHealth() {
        RatesServiceClient getLatestRatesByDate = new RatesServiceClient();
        GetRatesResponse getRatesResponse = getLatestRatesByDate.getRates("2021-01-12");
        assertThat(getRatesResponse.getHttpStatusCode(), is(equalTo(200)));
    }

    @Test(groups = TestCategories.SMOKE)
    public void verifyLatestRatesForSymbolServiceHealth() {
        RatesServiceClient getLatestRates = new RatesServiceClient();
        GetRatesResponse getRatesResponse = getLatestRates.getRatesForSymbols("latest", "USD");
        assertThat(getRatesResponse.getHttpStatusCode(), is(equalTo(200)));
        System.out.println(getRatesResponse.getRates().getUSD());
        assertThat(getRatesResponse.getRates().getUSD(), is(equalTo("1.1969")));
    }

    @Test(groups = TestCategories.SMOKE)
    public void verifyLatestRatesForSymbolByDateServiceHealth() {
        RatesServiceClient getLatestRates = new RatesServiceClient();
        GetRatesResponse getRatesResponse = getLatestRates.getRatesForSymbols("2021-01-12", "USD");
        assertThat(getRatesResponse.getHttpStatusCode(), is(equalTo(200)));
    }

    @Test(groups = TestCategories.SMOKE)
    public void verifyInvalidURLResponse() {
        RatesServiceClient getLatestRates = new RatesServiceClient();
        GetRatesResponse getRatesResponse = getLatestRates.getRatesError();
        assertThat(getRatesResponse.getError(), is(equalTo("time data 'api' does not match format '%Y-%m-%d'")));
    }
}
