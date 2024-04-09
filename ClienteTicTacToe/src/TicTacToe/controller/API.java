package TicTacToe.controller;

import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import TicTacToe.utils.ResponseModel;

public class API {
    
    private static final String BASE_URL = "http://127.0.0.1:5000/register";
    
    public ResponseModel CreateUser(String name, String nickname, String password) throws Exception {
        ResponseModel response = new ResponseModel();
        
        String jsonBody = "{\"name\": \""+ name +"\", \"nickname\": \""+ nickname +"\", \"password\": \""+ password + "\"}";

        URL urlObj = new URL(BASE_URL);
        HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();

        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);
        
        try{
            try(OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonBody.getBytes("utf-8");
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
    }
}
