package controller;

import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import utils.ResponseModel;
import utils.JsonData;
import java.io.IOException;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class API {

    private static final String BASE_URL = "http://127.0.0.1:5000";
    private String endpoint = "";
    private static final Logger LOGGER = LogManager.getLogger();

    public ResponseModel CreateUser(String name, String nickname, String password) throws Exception {
        JsonData json = new JsonData();

        json.addKeyJson("name", name);
        json.addKeyJson("nickname", nickname);
        json.addKeyJson("password", password);

        setEndpoint("/register");
        ResponseModel response = SendPostRequest(json);

        return response;
    }

    public ResponseModel Login(String nickname, String password) throws Exception {
        JsonData json = new JsonData();

        json.addKeyJson("nickname", nickname);
        json.addKeyJson("password", password);

        setEndpoint("/login");
        ResponseModel response = SendPostRequest(json);

        return response;
    }

    public String GetFreeUser(String nickname) throws Exception {
        setEndpoint("/users/free?nickname=" + nickname);
        ResponseModel response_api = SendGetRequest("users");

        String[] users = response_api.getResponseText().toString().trim().replace("[", "").replace("]", "").replace("\"", "").split(",");
        return users[0];
    }

    public ResponseModel Logout(String nickname) throws Exception {
        JsonData json = new JsonData();
        json.addKeyJson("nickname", nickname);

        setEndpoint("/logout");
        ResponseModel response = SendPostRequest(json);

        return response;
    }

    public ResponseModel UserStatus() throws Exception {
        setEndpoint("/users/status");
        ResponseModel response = SendGetRequest("status");

        return response;
    }

    public ResponseModel getHistoryUser(String nickname) throws Exception {
        setEndpoint("/history?nickname=" + nickname);
        ResponseModel response = SendGetRequest("history");

        return response;
    }

    public ResponseModel getInvites(String nickname) throws Exception {
        setEndpoint("/invite?nickname=" + nickname);
        ResponseModel response = SendGetRequest("invites");

        return response;
    }

    public ResponseModel saveHistory(String nickname, String oponent, String result) throws Exception {
        JsonData json = new JsonData();
        json.addKeyJson("nickname", nickname);
        json.addKeyJson("oponent", oponent);
        json.addKeyJson("result", result);

        setEndpoint("/history");
        ResponseModel response = SendPostRequest(json);

        return response;
    }

    public ResponseModel inviteGame(String nickname, String oponent) throws Exception {
        JsonData json = new JsonData();

        json.addKeyJson("nickname", nickname);
        json.addKeyJson("oponent", oponent);

        setEndpoint("/invite");
        ResponseModel response = SendPostRequest(json);

        return response;
    }

    private ResponseModel SendPostRequest(JsonData json) throws Exception {
        try {
            ResponseModel response = new ResponseModel();
            HttpURLConnection connection = createConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            try {
                try (OutputStream os = connection.getOutputStream()) {
                    byte[] input = json.getJson().getBytes("utf-8");
                    os.write(input, 0, input.length);
                }

                response.setResponseCode(connection.getResponseCode());

                // Aqui começamos a ler o corpo da resposta
                StringBuilder responseText = new StringBuilder();
                if (response.getResponseCode() >= HttpURLConnection.HTTP_BAD_REQUEST) {
                    try (BufferedReader br = new BufferedReader(
                            new InputStreamReader(connection.getErrorStream(), "utf-8"))) {
                        String responseLine = null;
                        while ((responseLine = br.readLine()) != null) {
                            responseText.append(responseLine.trim());
                        }
                        response.setResponseText(responseText.toString());
                    }
                }
            } catch (Exception ex) {
                LOGGER.error("Erro na função SendPostRequest `{}`", ex.getMessage());
            }

            connection.disconnect();
            return response;
        } catch (Exception ex) {
            ResponseModel response = new ResponseModel();
            return response;
        }
    }

    private ResponseModel SendGetRequest(String recoverKey) throws Exception {
        try {
            ResponseModel response = new ResponseModel();
            HttpURLConnection connection = createConnection();

            connection.setDoOutput(true);

            try {

                response.setResponseCode(connection.getResponseCode());

                // Aqui começamos a ler o corpo da resposta
                if (!recoverKey.isEmpty()) {
                    StringBuilder responseText = new StringBuilder();
                    try (BufferedReader br = new BufferedReader(
                            new InputStreamReader(connection.getInputStream(), "utf-8"))) {
                        String responseLine = null;

                        while ((responseLine = br.readLine()) != null) {
                            responseText.append(responseLine);
                        }

                        response.setData(responseText.toString(), recoverKey);
                    }
                }

            } catch (Exception ex) {
                LOGGER.error("Erro na função SendGetRequest `{}`", ex.getMessage());
            }

            connection.disconnect();
            return response;
        } catch (Exception ex) {
            ResponseModel response = new ResponseModel();
            return response;
        }
    }

    private HttpURLConnection createConnection() throws IOException {
        URL urlObj = new URL(BASE_URL + getEndpoint());
        HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();

        return connection;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

}
