package TicTacToe.controller;

import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import TicTacToe.utils.ResponseModel;
import TicTacToe.utils.JsonData;
import java.io.IOException;

public class API {
    
    private static final String BASE_URL = "http://127.0.0.1:5000";
    private String endpoint = "";

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
    
    private ResponseModel SendPostRequest(JsonData json)  throws Exception {        
        try{
            ResponseModel response = new ResponseModel();
            HttpURLConnection connection = createConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            try{
                try(OutputStream os = connection.getOutputStream()) {
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

            } catch(Exception ex){
                System.out.println("AAAAAAAAAAAAAA" + ex);
            }

            connection.disconnect();
            return response;
        } catch(Exception ex){
            ResponseModel response = new ResponseModel();
            return response;
        }
    }
    
    private HttpURLConnection createConnection() throws IOException{
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
