package filaB.api.respuestas;

import filaB.api.config.Configuration;
import filaB.api.factoryRequest.FactoryRequest;
import filaB.api.factoryRequest.RequestInfo;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;

public class RespuestasTest extends TestBaseToken {



    @Test
    public void preguntaUno(){
        //Crear un usuario
        createUser();

        //Obtener el token del nuevo usuario
        getNewToken();

        //Crear project con el token
        JSONObject body = new JSONObject();
        body.put("Content","Proyecto1Pregunta1");
        createProjectItem(Configuration.host + "/api/projects.json", body, post);

        //Eliminar el token
        deleteToken();

        //Crear otro proyecto con el token borrado
        body = new JSONObject();
        body.put("Content","Proyecto2Pregunta1");
        createProjectFail(Configuration.host + "/api/projects.json", body, post);

        //Eliminamos el usuario para que el test siga funcionando
        deleteUser();
    }

    @Test
    public void preguntaDos() {
        //Crear 4 items
        List<Integer> ids = new ArrayList<>();
        List<JSONObject> contents = new ArrayList<>();
        JSONObject body;
        for (int i = 0; i < 4; i++) {
            body = new JSONObject();
            body.put("Content", "Proyecto" + (i + 1) + "Pregunta2");
            contents.add(body);
            createProjectItem(Configuration.host + "/api/items.json", body, post);
            ids.add(response.then().extract().path("Id"));
        }

        //Eliminar los 4 items creados
        for(int i = 0; i < ids.size(); i++){
            this.deleteProjectItem(Configuration.host + "/api/items/" + ids.get(i) + ".json", contents.get(i));
        }
    }

    public void createUser(){
        String email = "samuelescobarbejarano@gmail.com";
        String password = "1234";
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
        String credential= Configuration.user+":"+Configuration.password;
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
        String credential= Configuration.user+":"+Configuration.password;
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
