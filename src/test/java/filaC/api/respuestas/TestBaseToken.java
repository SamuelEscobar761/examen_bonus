package filaC.api.respuestas;

import filaC.api.config.Configuration;
import filaC.api.factoryRequest.FactoryRequest;
import filaC.api.factoryRequest.RequestInfo;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Base64;

import static org.hamcrest.Matchers.equalTo;

public class TestBaseToken {
    public String post ="post";
    public String put = "put";
    public String get ="get";
    public String delete ="delete";

    public RequestInfo requestInfo;
    public Response response;
    public String token;
    @BeforeEach
    public void before(){

    }

    @AfterEach
    public void after(){

    }
}
