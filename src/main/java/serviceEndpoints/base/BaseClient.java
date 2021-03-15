package serviceEndpoints.base;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClient {

    protected Response post(String url, RequestSpecification specification) {

        specification.contentType(ContentType.JSON);

        return specification.post(url);
    }

    protected Response get(String url, RequestSpecification specification) {

        specification.contentType(ContentType.JSON);

        return specification.get(url);
    }

    protected Response delete(String url, RequestSpecification specification) {

        specification.contentType(ContentType.JSON);

        return specification.delete(url);
    }

    protected Response put(String url, RequestSpecification specification) {

        specification.contentType(ContentType.JSON);

        return specification.put(url);
    }

    protected Response patch(String url, RequestSpecification specification) {

        specification.contentType(ContentType.JSON);

        return specification.patch(url);
    }
}
