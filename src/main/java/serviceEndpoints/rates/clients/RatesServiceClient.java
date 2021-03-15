package serviceEndpoints.rates.clients;

import config.BaseUrlConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import serviceEndpoints.base.BaseClient;
import serviceEndpoints.rates.request.GetRatesEndpoint;
import serviceEndpoints.rates.response.GetRatesResponse;
import utility.request.RequestHandler;
import static io.restassured.RestAssured.given;

public class RatesServiceClient extends BaseClient {

    public GetRatesResponse getRates(String latestOrDateText) {
        GetRatesEndpoint getRatesEndpoint = new GetRatesEndpoint(latestOrDateText);
        Response response = new RequestHandler().processRequest(getRatesEndpoint);
        GetRatesResponse getRatesResponse = response.as(GetRatesResponse.class);
        getRatesResponse.setHttpStatusCode(response.statusCode());
        return getRatesResponse;
    }

    public GetRatesResponse getRatesError() {
        String invalidurl = String.format("%s/", BaseUrlConfig.getRateAPIHost());

        RequestSpecification requestSpecification = given();
        Response response = get(invalidurl, requestSpecification);
        GetRatesResponse getRatesResponse = response.as(GetRatesResponse.class);
        getRatesResponse.setHttpStatusCode(response.statusCode());
        return getRatesResponse;
    }

    public GetRatesResponse getRatesForSymbols(String latestOrDateText, String symbols) {
        GetRatesEndpoint getRatesEndpoint = new GetRatesEndpoint(latestOrDateText, symbols);
        Response response = new RequestHandler().processRequest(getRatesEndpoint);
        GetRatesResponse getRatesResponse = response.as(GetRatesResponse.class);
        getRatesResponse.setHttpStatusCode(response.statusCode());
        return getRatesResponse;
    }
}
