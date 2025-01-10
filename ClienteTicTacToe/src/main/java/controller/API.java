package controller;

import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import utils.ResponseModel;
import utils.JsonData;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import utils.Config;

public class API {

    private static final String BASE_URL = Config.API_HOST;
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

    public ResponseModel saveHistory(String nickname, String oponent, String result) throws Exception {
        JsonData json = new JsonData();
        json.addKeyJson("nickname", nickname);
        json.addKeyJson("oponent", oponent);
        json.addKeyJson("result", result);

        setEndpoint("/history");
        ResponseModel response = SendPostRequest(json);

        return response;
    }

    private ResponseModel SendPostRequest(JsonData json) throws Exception {
        try {
            ResponseModel response = new ResponseModel();
            HttpsURLConnection connection = createConnection();

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
                if (response.getResponseCode() >= HttpURLConnection.HTTP_BAD_REQUEST) {
                    StringBuilder responseText = new StringBuilder();
                    try (BufferedReader br = new BufferedReader(
                            new InputStreamReader(connection.getErrorStream(), "utf-8"))) {
                        String responseLine = null;
                        while ((responseLine = br.readLine()) != null) {
                            responseText.append(responseLine.trim());
                        }
                        response.setResponseText(responseText.toString());
                    }
                } else {
                    StringBuilder responseText = new StringBuilder();
                    try (BufferedReader br = new BufferedReader(
                            new InputStreamReader(connection.getInputStream(), "utf-8"))) {

                        String responseLine = null;
                        while ((responseLine = br.readLine()) != null) {
                            responseText.append(responseLine.trim());
                        }
                        response.setBody(responseText.toString());
                    }
                }
            } catch (Exception ex) {
                LOGGER.error("Erro na função SendPostRequest 1 `{}`", ex.getMessage());
            }

            connection.disconnect();
            return response;
        } catch (Exception ex) {
            LOGGER.error("Erro na função SendPostRequest 2 `{}`", ex.getMessage());
            ResponseModel response = new ResponseModel();
            return response;
        }
    }

    private ResponseModel SendGetRequest(String recoverKey) throws Exception {
        try {
            ResponseModel response = new ResponseModel();
            HttpsURLConnection connection = createConnection();
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
                LOGGER.error("Erro na função SendGetRequest 1 `{}`", ex.getMessage());
            }

            connection.disconnect();
            return response;
        } catch (Exception ex) {
            LOGGER.error("Erro na função SendGetRequest 2 `{}`", ex.getMessage());
            ResponseModel response = new ResponseModel();
            return response;
        }
    }

    private HttpsURLConnection createConnection() throws Exception {           
        URL urlObj = new URL(BASE_URL + getEndpoint());
        
        TrustManager[] trustAllCerts = new TrustManager[]{
            new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() { return null; }
                public void checkClientTrusted(X509Certificate[] certs, String authType) {}
                public void checkServerTrusted(X509Certificate[] certs, String authType) {}
            }
        };

        SSLContext sc = SSLContext.getInstance("TLS");
        sc.init(null, trustAllCerts, new java.security.SecureRandom());
        HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
        HttpsURLConnection.setDefaultHostnameVerifier((hostname, session) -> true);
        
        System.setProperty("https.protocols", "TLSv1.2");
        System.setProperty("javax.net.ssl.keyStore", Config.CERT_PATH);
        System.setProperty("javax.net.ssl.keyStorePassword", Config.CERT_PASSWORD);
        System.setProperty("javax.net.ssl.trustStore", Config.CERT_PATH);
        System.setProperty("javax.net.ssl.trustStorePassword", Config.CERT_PASSWORD);
        System.setProperty("javax.net.debug", "all");
        
        HttpsURLConnection connection = (HttpsURLConnection) urlObj.openConnection();

        return connection;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

}
