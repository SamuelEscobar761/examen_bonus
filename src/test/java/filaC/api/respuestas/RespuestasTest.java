package filaC.api.respuestas;

import filaC.api.config.Configuration;
import filaC.api.factoryRequest.FactoryRequest;
import filaC.api.factoryRequest.RequestInfo;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.Base64;

import static org.hamcrest.Matchers.equalTo;

public class RespuestasTest extends TestBaseToken {
    String email = "samuelescobarbejarano@gmail.com";
    String password = "1234";

    @Test
    public void preguntaUno(){
        email = "samuelescobarbejarano@gmail.com";
        password = "1234";

        //Crear un usuario
        createUser();

        //Obtener el token del nuevo usuario
        getNewToken();

        //Crear item con el token
        JSONObject body = new JSONObject();
        body.put("Content","Item1Pregunta2");
        createProjectItem(Configuration.host + "/api/items.json", body, post);

        //Eliminar el token
        deleteToken();

        //Crear otro proyecto con el token borrado
        body = new JSONObject();
        body.put("Content","Item2Pregunta2");
        createProjectFail(Configuration.host + "/api/items.json", body, post);

        //Eliminamos el usuario para que el test siga funcionando
        deleteUser();
    }

    @Test
    public void preguntaDos(){
        for(int i = 0; i < 4; i++){
            email = "samuelescobarbejarano"+i+"@gmail.com";
            password = "1234";
            //Crear un usuario
            createUser();

            //Eliminamos el usuario para que el test siga funcionando
            deleteUser();
        }
    }

    public void createUser(){
        Configuration.user = email;
        Configuration.password = password;
        JSONObject body = new JSONObject();
        body.put("Email", email);
        body.put("Password",password);
        body.put("FullName", "Samuel Matias Escobar Bejarano");
        requestInfo = new RequestInfo();
        requestInfo.setUrl(Configuration.host + "/api/user.json");
        requestInfo.setBody(body.toString());
        response = FactoryRequest.make("POST").send(requestInfo);
        response.then().statusCode(200).
                body("Email", equalTo(body.get("Email")));
    }

    public void getNewToken(){
        requestInfo = new RequestInfo();
        String credential= Configuration.user+":"+ Configuration.password;
        requestInfo.setHeaders("Authorization","Basic "+ Base64.getEncoder().encodeToString(credential.getBytes()));
        requestInfo.setUrl(Configuration.host + "/api/authentication/token.json");
        response = FactoryRequest.make("get").send(requestInfo);
        token =response.then().extract().path("TokenString");
        // request get token
        requestInfo = new RequestInfo();
        requestInfo.setHeaders("Token",token);
        response.then().statusCode(200).body("UserEmail", equalTo(Configuration.user));
    }

    public void deleteToken(){
        requestInfo.setUrl(Configuration.host + "/api/authentication/token.json");
        response = FactoryRequest.make("DELETE").send(requestInfo);
        response.then().statusCode(200).
                body("TokenString", equalTo(token));
    }

    public void deleteUser(){
        String credential= Configuration.user+":"+ Configuration.password;
        requestInfo.setHeaders("Authorization","Basic "+ Base64.getEncoder().encodeToString(credential.getBytes()));
        requestInfo.setUrl(Configuration.host + "/api/user/0.json");
        response = FactoryRequest.make("DELETE").send(requestInfo);
        response.then().statusCode(200).
                body("Email", equalTo(Configuration.user));
    }

    private void createProjectItem(String host, JSONObject body, String post) {
        requestInfo.setUrl(host)
                .setBody(body.toString());
        response = FactoryRequest.make(post).send(requestInfo);
        response.then().statusCode(200).
                body("Content", equalTo(body.get("Content")));
    }

    private void createProjectFail(String host, JSONObject body, String post) {
        requestInfo.setUrl(host)
                .setBody(body.toString());
        response = FactoryRequest.make(post).send(requestInfo);
        response.then().statusCode(200).
                body("ErrorCode", equalTo(102));
    }

    private void deleteProjectItem(String host, JSONObject body) {
        requestInfo.setUrl(host);
        response = FactoryRequest.make(delete).send(requestInfo);
        response.then().statusCode(200).
                body("Content", equalTo(body.get("Content")));
    }
}
