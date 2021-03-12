package utility;



import utility.request.HttpMethod;
import utility.request.Param;
import utility.request.RequestBody;

import java.util.List;

public interface ServiceEndpoint {

    String url();

    /**
     * Define HTTP method type
     *
     * @return POST/GET/PUT/DELETE
     */
    HttpMethod httpMethod();

    /**
     * Define service endpoint query params
     *
     * @return List of type params
     */
    List<Param> queryParameters();

    /**
     * Define service endpoint path params
     * @return List of type params
     */
    List<Param> pathParameters();

    /**
     * Define service endpoint headers
     *
     * @return List of type params
     */
    List<Param> headers();

    /**
     * Define service endpoint body
     *
     * @return an intance of type RequestBody
     */
    RequestBody body();

}
