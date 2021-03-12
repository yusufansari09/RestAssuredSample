package serviceEndpoints.rates.request;

import config.BaseUrlConfig;
import utility.ServiceEndpoint;
import utility.request.HttpMethod;
import utility.request.Param;
import utility.request.RequestBody;
import java.util.ArrayList;
import java.util.List;

public class GetRatesEndpoint implements ServiceEndpoint {
    private String pathParam;
    private String symbols;

    public GetRatesEndpoint(String pathParam) {
        this.pathParam = pathParam;
    }

    public GetRatesEndpoint(String pathParam, String symbols) {
        this.pathParam = pathParam;
        this.symbols = symbols;
    }

    @Override
    public String url() {
        return String.format("%s/{pathParam}", BaseUrlConfig.getRateAPIHost());
    }

    @Override
    public HttpMethod httpMethod() {
        return HttpMethod.GET;
    }

    @Override
    public List<Param> queryParameters() {
        List<Param> queryParam = new ArrayList<>();
        if(this.symbols != null && !this.symbols.equals("")) {
            queryParam.add(new Param("symbols", this.symbols));
            return queryParam;
        } else {
            return null;
        }
    }

    @Override
    public List<Param> pathParameters() {
        List<Param> parameter = new ArrayList<>();
        if(this.pathParam !=null && !this.pathParam.equals(""))
            parameter.add(new Param("pathParam", this.pathParam));
        else
            parameter.add(new Param("pathParam", ""));
        return parameter;
    }

    @Override
    public List<Param> headers() {
        List<Param> headers = new ArrayList<>();
        headers.add(new Param("Content-Type", "application/json"));
        return headers;
    }

    @Override
    public RequestBody body() {
        return null;
    }
}
